package org.ldxx.util;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.ldxx.bean.Business;
import org.ldxx.bean.BusinessExample;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.CurrentFlowExample;
import org.ldxx.bean.FlowEdge;
import org.ldxx.bean.FlowEdgeExample;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.FlowNode;
import org.ldxx.bean.FlowNodeExample;
import org.ldxx.bean.ModeStatus;
import org.ldxx.bean.NodeActorsVo;
import org.ldxx.exception.FlowException;
import org.ldxx.mapper.BusinessMapper;
import org.ldxx.mapper.CurrentFlowMapper;
import org.ldxx.mapper.FlowEdgeMapper;
import org.ldxx.mapper.FlowHistroyMapper;
import org.ldxx.mapper.FlowNodeMapper;
import org.ldxx.mapper.ModeStatusMapper;
import org.ldxx.mapper.NodeActorsMapper;
import org.ldxx.util.BeanUtil;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Component
public class FlowUtill {

	private static final Logger log = Logger.getLogger("myLog");  
	public static FlowUtill INSTANCE; 
	
	@PostConstruct // 第三步  
    public void init() {  
        INSTANCE = this;
        INSTANCE.businessMapper=this.businessMapper;
        INSTANCE.flowNodeMapper=this.flowNodeMapper;
        INSTANCE.currentFlowMapper=this.currentFlowMapper;
        INSTANCE.flowHistroyMapper=this.flowHistroyMapper;
        INSTANCE.flowEdgeMapper=this.flowEdgeMapper;
        INSTANCE.modeStatusMapper=this.modeStatusMapper;
        INSTANCE.nodeActorsMapper=this.nodeActorsMapper;
    } 
	@Autowired
	NodeActorsMapper nodeActorsMapper;
	@Autowired
	ModeStatusMapper modeStatusMapper;
	@Autowired
	FlowEdgeMapper flowEdgeMapper;
	@Autowired
	BusinessMapper businessMapper;
	@Autowired
	FlowNodeMapper flowNodeMapper;
	@Autowired
	CurrentFlowMapper currentFlowMapper;
	@Autowired
	FlowHistroyMapper flowHistroyMapper;
	
	
	/**
	 * 新流程发起，初始提交
	 * @param currentFlow url,Title,Starter,StartName,Sender,SenderName,FK_Dept,DeptName,NodeName,PRI,SDTOfNode,SDTOfFlow,Actor,ActorType,Memo
	 *        flowHistroy Actor ActorName ActorResult view
	 * @author xianing
	 */
	
	@Transactional
	public String submitGetReceiver(CurrentFlow currentFlow) throws Exception{
		currentFlow.setRdt(new Date());
		INSTANCE.init();
		/**0：流程刚发起,暂存状态
		 * 1：流程刚发起,提交状态
		 */
		currentFlow.setWfstate(0);
		currentFlow.setDoDate(new Date());
		String mode_id = "";
		BusinessExample example = new BusinessExample();
		String url = currentFlow.getUrl();
		if(null!=url&&url.contains("-")){
			String urls[] = url.split("-");
			url = urls[0];
			mode_id=urls[1];
		}else{
			log.error("url为null或者url格式有误");
			throw new FlowException("url format error");
		}
		example.createCriteria().andBusinessurlEqualTo(url);
		List<Business> list =  INSTANCE.businessMapper.selectByExample(example);
		Business business = null;
		if(null!=list&&list.size()==1){
			business = list.get(0);
		}else{
			log.error("业务流中不存在该URL:"+url);
			throw new FlowException("url not found");
		}
		currentFlow.setBusId(business.getId());
		currentFlow.setFloTmpId(business.getFloTmpId());
		currentFlow.setId(new TimeUUID().getTimeUUID());
		currentFlow.setModeId(mode_id);
		FlowNode flowNode = INSTANCE.flowNodeMapper.selectStartFlowNode(business.getFloTmpId());
		FlowEdgeExample example3 = new FlowEdgeExample();
		example3.createCriteria().andFloNodeLeftEqualTo(flowNode.getId());
		String floNodeId = "";
		try {
			floNodeId = deque(flowNode, currentFlow);
		} catch (Exception e1) {
			log.error("递归获取下一步floNodeId出错");
			throw new FlowException("deque do error");
		}
		currentFlow.setFloNodeId(floNodeId);
		INSTANCE.currentFlowMapper.insert(currentFlow);
		JSONObject jsonObject = new JSONObject();
		JSONArray arrays = new JSONArray();
		if("end".equals(floNodeId)){
			arrays=null;
		}else{
			List<NodeActorsVo> nodeActorsVos = INSTANCE.nodeActorsMapper.getNextNodeActors(floNodeId,currentFlow.getActor());
			arrays = JSONArray.fromObject(nodeActorsVos);
		}
		jsonObject.put("receiver", arrays);
		jsonObject.put("url", currentFlow.getUrl());
		return jsonObject.toString();
	}
	
	/**
	 * 新流程发起，初始提交
	 * @param currentFlow url,Title,Starter,StartName,Sender,SenderName,FK_Dept,DeptName,NodeName,PRI,SDTOfNode,SDTOfFlow,Actor,ActorType,Memo
	 *        flowHistroy Actor ActorName ActorResult view
	 * @author xianing
	 */
	
	@Transactional
	public String submitFlow(CurrentFlow currentFlowOld,FlowHistroy flowHistroy,String next_user_id,String next_name) throws Exception{
		currentFlowOld.setRdt(new Date());
			ModeStatus modeStatus = new ModeStatus(); 	
			INSTANCE.init();
			/**0：流程刚发起,暂存状态
			 * 1：流程刚发起,提交状态
			 */
			currentFlowOld.setWfstate(1);
			String url = currentFlowOld.getUrl();
			String modeId = "";
			if(null!=url&&url.contains("-")){
				String urls[] = url.split("-");
				url=urls[0];
				modeId =urls[1];
			}else{
				log.error("url为null或者url格式有误");
				throw new FlowException("url format error");
			}
			CurrentFlowExample example2 = new CurrentFlowExample();
			example2.createCriteria().andUrlEqualTo(currentFlowOld.getUrl());
			List<CurrentFlow> currentFlows = INSTANCE.currentFlowMapper.selectByExample(example2);
			CurrentFlow currentFlow = new CurrentFlow();
			try {
				if(null!=currentFlows&&currentFlows.size()>0){
					currentFlow = currentFlows.get(0);
					currentFlow.setDoDate(new Date());
					currentFlow.setDeptname(currentFlowOld.getDeptname());
					flowHistroy = BeanUtil.copyCurrentFlowToHistory(currentFlow, flowHistroy);
					if(!"end".equals(currentFlow.getFloNodeId())){
						currentFlow.setActor(next_user_id);
						currentFlow.setActorname(next_name);
						currentFlow.setDeptname(currentFlowOld.getDeptname());
						INSTANCE.currentFlowMapper.updateByExampleSelective(currentFlow, example2);
						modeStatus.setModeId(modeId);
						//1：流程运转中
						modeStatus.setStatus("1");
						ModeStatus modeStatus2 = INSTANCE.modeStatusMapper.selectByPrimaryKey(modeId);
						if(null!=modeStatus2){
							INSTANCE.modeStatusMapper.updateByPrimaryKey(modeStatus);
						}else{
							INSTANCE.modeStatusMapper.insert(modeStatus);
						}
					}else{
						INSTANCE.currentFlowMapper.deleteByExample(example2);
						modeStatus.setModeId(modeId);
						//5:流程结束
						modeStatus.setStatus("5");
						ModeStatus modeStatus2 = INSTANCE.modeStatusMapper.selectByPrimaryKey(modeId);
						if(null!=modeStatus2){
							INSTANCE.modeStatusMapper.updateByPrimaryKey(modeStatus);
						}else{
							INSTANCE.modeStatusMapper.insert(modeStatus);
						}
					}
				}else{
					log.error("查找currentFlow出错");
					throw new FlowException("find currentFlow error");
				}
				flowHistroy.setDoDate(new Date());
				INSTANCE.flowHistroyMapper.insert(flowHistroy);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("数据库插入错误");
				throw new FlowException("database do error");
			}
		return "success";
	}
	
	
	/**
	 * 新流程发起，初始提交
	 * @param currentFlow url,Title,Starter,StartName,Sender,SenderName,FK_Dept,DeptName,NodeName,PRI,SDTOfNode,SDTOfFlow,Actor,ActorType,Memo
	 *        flowHistroy Actor ActorName ActorResult view
	 * @author xianing
	 */
	@Transactional
	public String shenpiGetReceiver(CurrentFlow currentFlow) throws Exception{
		currentFlow.setRdt(new Date());
		INSTANCE.init();
		
		String floNodeId = "";
	    floNodeId = currentFlow.getFloNodeId();
	    FlowNode flowNode = INSTANCE.flowNodeMapper.selectByPrimaryKey(floNodeId);
		try {
			floNodeId = deque(flowNode, currentFlow);
		} catch (Exception e1) {
			log.error("递归获取下一步floNodeId出错");
			
			throw new FlowException("deque do error");
		}
		currentFlow.setFloNodeId(floNodeId);
		JSONObject jsonObject = new JSONObject();
		JSONArray arrays = new JSONArray();
		if("end".equals(floNodeId)){
			arrays=null;
		}else{
			List<NodeActorsVo> nodeActorsVos = INSTANCE.nodeActorsMapper.getNextNodeActors(floNodeId,currentFlow.getActor());
			arrays = JSONArray.fromObject(nodeActorsVos);
		}
		jsonObject.put("receiver", arrays);
		jsonObject.put("url", currentFlow.getUrl());
		return jsonObject.toString();
	}
	
	/**
	 * 新流程发起，初始提交
	 * @param currentFlow url,Title,Starter,StartName,Sender,SenderName,FK_Dept,DeptName,NodeName,PRI,SDTOfNode,SDTOfFlow,Actor,ActorType,Memo
	 *        flowHistroy Actor ActorName ActorResult view
	 * @author xianing
	 */
	
	@Transactional
	public String shenpiSubmitFlow(CurrentFlow currentFlow,FlowHistroy flowHistroy,String next_user_id,String next_name) throws Exception{
			currentFlow.setRdt(new Date());
			ModeStatus modeStatus = new ModeStatus(); 	
			INSTANCE.init();
			/**0：流程刚发起,暂存状态
			 * 1：流程刚发起,提交状态
			 */
			currentFlow.setWfstate(1);
			String url = currentFlow.getUrl();
			String modeId = "";
			if(null!=url&&url.contains("-")){
				String urls[] = url.split("-");
				url=urls[0];
				modeId =urls[1];
			}else{
				log.error("url为null或者url格式有误");
				throw new FlowException("url format error");
			}
			CurrentFlowExample example2 = new CurrentFlowExample();
			example2.createCriteria().andUrlEqualTo(currentFlow.getUrl());
			List<CurrentFlow> currentFlows = INSTANCE.currentFlowMapper.selectByExample(example2);
			try {
				if(null!=currentFlows&&currentFlows.size()>0){
					currentFlow = currentFlows.get(0);
					flowHistroy = BeanUtil.copyCurrentFlowToHistory(currentFlow, flowHistroy);
					if(!"end".equals(currentFlow.getFloNodeId())){
						currentFlow.setActor(next_user_id);
						currentFlow.setActorname(next_name);
						INSTANCE.currentFlowMapper.updateByExampleSelective(currentFlow, example2);
						modeStatus.setModeId(modeId);
						//1：流程运转中
						modeStatus.setStatus("1");
						ModeStatus modeStatus2 = INSTANCE.modeStatusMapper.selectByPrimaryKey(modeId);
						if(null!=modeStatus2){
							INSTANCE.modeStatusMapper.updateByPrimaryKey(modeStatus);
						}else{
							INSTANCE.modeStatusMapper.insert(modeStatus);
						}
					}else{
						INSTANCE.currentFlowMapper.deleteByExample(example2);
						modeStatus.setModeId(modeId);
						//5:流程结束
						modeStatus.setStatus("5");
						ModeStatus modeStatus2 = INSTANCE.modeStatusMapper.selectByPrimaryKey(modeId);
						if(null!=modeStatus2){
							INSTANCE.modeStatusMapper.updateByPrimaryKey(modeStatus);
						}else{
							INSTANCE.modeStatusMapper.insert(modeStatus);
						}
					}
				}else{
					log.error("查找currentFlow出错");
					throw new FlowException("find currentFlow error");
				}
				INSTANCE.flowHistroyMapper.insert(flowHistroy);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("数据库插入错误");
				throw new FlowException("database do error");
			}
		return "success";
	}
	
	@Transactional
	public String zancunFlow(CurrentFlow currentFlow,FlowHistroy flowHistroy) throws Exception{
		currentFlow.setRdt(new Date());
		INSTANCE.init();
		/**0：流程刚发起,暂存状态
		 * 1：流程刚发起,提交状态
		 */
		currentFlow.setWfstate(0);
		BusinessExample example = new BusinessExample();
		String url = currentFlow.getUrl();
		if(null!=url&&url.contains("-")){
			url = url.split("-")[0];
		}else{
			log.error("url为null或者url格式有误");
			throw new FlowException("url format error");
		}
		example.createCriteria().andBusinessurlEqualTo(url);
		List<Business> list =  INSTANCE.businessMapper.selectByExample(example);
		Business business = null;
		if(null!=list&&list.size()==1){
			business = list.get(0);
		}else{
			log.error("业务流中不存在该URL:"+url);
			throw new FlowException("url not found");
		}
		currentFlow.setFloTmpId(business.getFloTmpId());
		FlowNode flowNode = INSTANCE.flowNodeMapper.selectStartFlowNode(business.getFloTmpId());
		currentFlow.setFloNodeId(flowNode.getId());
		currentFlow.setId(new TimeUUID().getTimeUUID());
		flowHistroy = BeanUtil.copyCurrentFlowToHistory(currentFlow, flowHistroy);
		try {
			INSTANCE.currentFlowMapper.insert(currentFlow);
			/*INSTANCE.flowHistroyMapper.insert(flowHistroy);*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("数据库插入错误");
			throw new FlowException("database do error");
		}
		return "success";
	}
	/**
	 * @param currentFlow url,Title,Starter,StartName,Sender,SenderName,FK_Dept,DeptName,NodeName,PRI,SDTOfNode,SDTOfFlow,Actor,ActorType,Memo
	 *        flowHistroy Actor ActorName ActorResult view
	 * @author xianing
	 */
	@Transactional
	public String chexiaoFlow(CurrentFlow currentFlow,FlowHistroy flowHistroy) throws Exception{
		INSTANCE.init();
		currentFlow.setRdt(new Date());
		/**0：流程刚发起,提交状态
		 * 5：流程被撤销状态
		 */
		String url = currentFlow.getUrl(); 
		CurrentFlowExample example = new CurrentFlowExample();
		example.createCriteria().andUrlEqualTo(url);
		List<CurrentFlow> list = INSTANCE.currentFlowMapper.selectByExample(example);
		if(null!=list&&list.size()==1){
			currentFlow = list.get(1);
		}else{
			log.error("业务流中不存在该URL:"+currentFlow.getUrl());
			throw new FlowException("url not found");
		}
		currentFlow.setWfstate(0);
		CurrentFlowExample example1 = new CurrentFlowExample();
		example.createCriteria().andUrlEqualTo(url);
		INSTANCE.currentFlowMapper.updateByExampleSelective(currentFlow, example1);
		flowHistroy = BeanUtil.copyCurrentFlowToHistory(currentFlow, flowHistroy);
		INSTANCE.flowHistroyMapper.insert(flowHistroy);
		return "success";
	}
	/**
	 * @param currentFlow url,Title,Starter,StartName,Sender,SenderName,FK_Dept,DeptName,NodeName,PRI,SDTOfNode,SDTOfFlow,Actor,ActorType,Memo
	 *        flowHistroy Actor ActorName ActorResult view
	 * @author xianing
	 */
	@Transactional
	public String cancelFlow(CurrentFlow currentFlow,FlowHistroy flowHistroy) throws Exception{
		INSTANCE.init();
		currentFlow.setRdt(new Date());
		/**0：流程刚发起,提交状态
		 * 5：流程被撤销状态
		 */
		String url = currentFlow.getUrl(); 
		CurrentFlowExample example = new CurrentFlowExample();
		example.createCriteria().andUrlEqualTo(url);
		List<CurrentFlow> list = INSTANCE.currentFlowMapper.selectByExample(example);
		if(null!=list&&list.size()==1){
			currentFlow = list.get(1);
		}else{
			log.error("业务流中不存在该URL:"+currentFlow.getUrl());
			throw new FlowException("url not found");
		}
		currentFlow.setWfstate(0);
		CurrentFlowExample example1 = new CurrentFlowExample();
		example.createCriteria().andUrlEqualTo(url);
		INSTANCE.currentFlowMapper.deleteByExample(example1);
		flowHistroy = BeanUtil.copyCurrentFlowToHistory(currentFlow, flowHistroy);
		INSTANCE.flowHistroyMapper.insert(flowHistroy);
		return "success";
	}
	/**
	 * @param currentFlow url,Title,Starter,StartName,Sender,SenderName,FK_Dept,DeptName,NodeName,PRI,SDTOfNode,SDTOfFlow,Actor,ActorType,Memo
	 *        flowHistroy Actor ActorName ActorResult view
	 * @author xianing
	 */
	@Transactional
	public String shenpiFlow(CurrentFlow currentFlow,FlowHistroy flowHistroy) throws Exception{
		INSTANCE.init();
		currentFlow.setRdt(new Date());
		/**0：流程刚发起,提交状态
		 * 5：流程被撤销状态
		 */
		String url = currentFlow.getUrl(); 
		CurrentFlowExample example = new CurrentFlowExample();
		example.createCriteria().andUrlEqualTo(url);
		List<CurrentFlow> list = INSTANCE.currentFlowMapper.selectByExample(example);
		if(null!=list&&list.size()==1){
			currentFlow = list.get(1);
		}else{
			log.error("业务流中不存在该URL:"+currentFlow.getUrl());
			throw new FlowException("url not found");
		}
		currentFlow.setWfstate(0);
		CurrentFlowExample example1 = new CurrentFlowExample();
		example.createCriteria().andUrlEqualTo(url);
		INSTANCE.currentFlowMapper.updateByExampleSelective(currentFlow, example1);
		flowHistroy = BeanUtil.copyCurrentFlowToHistory(currentFlow, flowHistroy);
		INSTANCE.flowHistroyMapper.insert(flowHistroy);
		return "success";
	}
	
	public static String deque(FlowNode flowNode,CurrentFlow currentFlow){
		FlowEdgeExample example3 = new FlowEdgeExample();
		example3.createCriteria().andFloNodeLeftEqualTo(flowNode.getId());
		String floNodeId = "";
		List<FlowEdge> flowEdges = INSTANCE.flowEdgeMapper.selectByExample(example3);
		if(null!=flowEdges){
			if(flowEdges.size()<1){
				floNodeId="end";
				return floNodeId;
			}else if(flowEdges.size()==1){
				//下一步模板Id
				floNodeId = flowEdges.get(0).getFloNodeRight();
				flowNode = INSTANCE.flowNodeMapper.selectByPrimaryKey(floNodeId);
				boolean flag = true;
				if(flag){
					return floNodeId;
				}else{
					deque(flowNode, currentFlow);
				}
			}else if(flowEdges.size()>1){
				for (FlowEdge flowEdge : flowEdges) {
					boolean flag = new ConditionUtil().judgeCondition(flowEdge.getPrerequisite());
					if(flag){
						floNodeId = flowEdge.getFloNodeRight();
						break;
					}
				}
				boolean flag = true;
				if(flag){
					return floNodeId;
				}else{
					deque(flowNode, currentFlow);
				}
				
			}
		}
		return "";
	}
	/*List<FlowEdge> flowEdges = INSTANCE.flowEdgeMapper.selectByExample(example3);
	//正常情况下根据流程方向判断下一步的步骤ID
	if(null!=flowEdges){
		if(flowEdges.size()==1){
			floNodeId = flowEdges.get(0).getFloNodeRight();
			
		}else if(flowEdges.size()>1){
			for (FlowEdge flowEdge : flowEdges) {
				boolean flag = new ConditionUtil().judgeCondition(flowEdge.getPrerequisite());
				if(flag){
					floNodeId = flowEdge.getFloNodeRight();
					break;
				}
			}
		}else{
			floNodeId="end";
		}
	}else{
		log.error("流程方向为空");
		throw new FlowException("flowEdge is null");
	}*/
	public static void main(String[] args) {
		log.error("我是错误啊啊啊啊啊啊啊");
		log.info("我是日志内容啊啊啊啊啊");
	}
}

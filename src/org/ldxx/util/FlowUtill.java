package org.ldxx.util;

import java.util.ArrayList;
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
import org.ldxx.bean.FlowHistroyExample;
import org.ldxx.bean.FlowNode;
import org.ldxx.bean.FlowNodeExample;
import org.ldxx.bean.ModeStatus;
import org.ldxx.bean.ModeStatusExample;
import org.ldxx.bean.NodeActors;
import org.ldxx.bean.NodeActorsVo;
import org.ldxx.bean.User;
import org.ldxx.controller.CurrentFlowController;
import org.ldxx.dao.RoleDao;
import org.ldxx.dao.UserDao;
import org.ldxx.exception.FlowException;
import org.ldxx.mapper.BusinessMapper;
import org.ldxx.mapper.CurrentFlowChaoSongMapper;
import org.ldxx.mapper.CurrentFlowMapper;
import org.ldxx.mapper.FlowEdgeMapper;
import org.ldxx.mapper.FlowHistroyMapper;
import org.ldxx.mapper.FlowNodeMapper;
import org.ldxx.mapper.ModeStatusMapper;
import org.ldxx.mapper.NodeActorsMapper;
import org.ldxx.mapper.RolesMapper;
import org.ldxx.util.BeanUtil;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import sun.security.jca.GetInstance.Instance;

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
        INSTANCE.currentFlowChaoSongMapper=this.currentFlowChaoSongMapper;
        INSTANCE.flowHistroyMapper=this.flowHistroyMapper;
        INSTANCE.flowEdgeMapper=this.flowEdgeMapper;
        INSTANCE.modeStatusMapper=this.modeStatusMapper;
        INSTANCE.nodeActorsMapper=this.nodeActorsMapper;
        INSTANCE.roleDao = this.roleDao;
        INSTANCE.userDao = this.userDao;
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
	CurrentFlowChaoSongMapper currentFlowChaoSongMapper;
	@Autowired
	FlowHistroyMapper flowHistroyMapper;
	@Autowired
	RoleDao roleDao;
	@Autowired
	UserDao userDao;
	/**
	 * 新流程发起，初始提交
	 * @param currentFlow url,Title,Starter,StartName,Sender,SenderName,FK_Dept,DeptName,NodeName,PRI,SDTOfNode,SDTOfFlow,Actor,ActorType,Memo
	 *        flowHistroy Actor ActorName ActorResult view
	 * @author xianing
	 */
	
	@Transactional
	public String submitGetReceiver(CurrentFlow currentFlow,String deptNo) throws Exception{
		currentFlow.setRdt(new Date());
		INSTANCE.init();
		/**0：流程刚发起,暂存状态
		 * 1：流程刚发起,提交状态
		 */
		currentFlow.setWfstate(0);
		//currentFlow.setFlowEndState(5);
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
		currentFlow.setLastOperateType(null);
		FlowNode flowNode = INSTANCE.flowNodeMapper.selectStartFlowNode(business.getFloTmpId());
		FlowEdgeExample example3 = new FlowEdgeExample();
		example3.createCriteria().andFloNodeLeftEqualTo(flowNode.getId());
		currentFlow.setFloNodeId(flowNode.getId());
		
		ModeStatus modeStatus = INSTANCE.modeStatusMapper.selectByPrimaryKey(mode_id);
		if(null!=modeStatus){
			modeStatus.setStatus("1");
			modeStatus.setFlowStatus("1");
			INSTANCE.modeStatusMapper.updateByPrimaryKey(modeStatus);
		}else{
			modeStatus=new ModeStatus();
			modeStatus.setModeId(mode_id);
			modeStatus.setStatus("1");
			modeStatus.setFlowStatus("1");
			INSTANCE.modeStatusMapper.insert(modeStatus);
		}
		
		String floNodeId = "";
		try {
			floNodeId = deque(flowNode, currentFlow);
		} catch (Exception e1) {
			log.error("递归获取下一步floNodeId出错");
			throw new FlowException("deque do error");
		}
		currentFlow.setFlowNodeLast(null);
		currentFlow.setReadreceipts(0);
		INSTANCE.currentFlowMapper.insert(currentFlow);
		JSONObject jsonObject = new JSONObject();
		JSONArray arrays = new JSONArray();
		if("end".equals(floNodeId)){
			arrays=null;
		}else{
			
			//List<NodeActorsVo> nodeActorsVos = INSTANCE.nodeActorsMapper.getNextNodeActors(floNodeId,currentFlow.getActor());
			
			
			List<NodeActors> nodeActors = INSTANCE.nodeActorsMapper.getNextNodeActorsByFloNodeId(floNodeId);
			List<User> usersSubmit = new ArrayList<>();
			if(null!=nodeActors&&nodeActors.size()>0){
			List<User> users = INSTANCE.userDao.selectAllUser();
				for(NodeActors nodeActors2:nodeActors){
					String roleCode = INSTANCE.roleDao.selectRoleById(nodeActors2.getRolecode()).getRoleCode();
					Iterator<User> iterator = users.iterator();
					if(roleCode.endsWith("*.")){
			    		roleCode=roleCode+"r"+deptNo+".";
			    	}
				    while (iterator.hasNext()) {
				    	User user = iterator.next();
				    	String userRole = user.getUserRole();
				    	
				    	
						if(null!=userRole&&userRole.contains(roleCode)){
							usersSubmit.add(user);
							iterator.remove();
						}
				    	
					}
				}
			}
			arrays = JSONArray.fromObject(usersSubmit);
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
	public JSONObject submitFlow(CurrentFlow currentFlowOld,FlowHistroy flowHistroy,String next_user_id,String next_name) throws Exception{
		    currentFlowOld.setRdt(new Date());
			ModeStatus modeStatus = new ModeStatus(); 	
			String end = "kaishi";
			JSONObject jsonObject = new JSONObject();
			
			INSTANCE.init();
			/**0：流程刚发起,暂存状态
			 * 1：流程刚发起,提交状态
			 */
			currentFlowOld.setWfstate(0);
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
			Integer historyLastOperateType=null;
			try {
				if(null!=currentFlows&&currentFlows.size()>0){
					currentFlow = currentFlows.get(0);
					currentFlow.setDoDate(new Date());
					currentFlow.setDeptname(currentFlowOld.getDeptname());
					currentFlow.setLastView(currentFlowOld.getLastView());
					currentFlow.setLastPerson(currentFlow.getActorname());
					historyLastOperateType = currentFlow.getLastOperateType();
					String oldFloNodeId = currentFlow.getFloNodeId();
					FlowNode flowNode = INSTANCE.flowNodeMapper.selectByPrimaryKey(oldFloNodeId);
					String nextFloNodeId = deque(flowNode, currentFlow);
					flowHistroy = BeanUtil.copyCurrentFlowToHistory(currentFlow, flowHistroy);
					flowHistroy.setFlowNodeLast(currentFlow.getFlowNodeLast());
					flowHistroy.setLastOperateType(historyLastOperateType);
					currentFlow.setFlowNodeLast(oldFloNodeId);
					if(!"end".equals(nextFloNodeId)){
						currentFlow.setActor(next_user_id);
						currentFlow.setActorname(next_name);
						currentFlow.setFloNodeId(nextFloNodeId);
						currentFlow.setDeptname(currentFlowOld.getDeptname());
						currentFlow.setReadreceipts(0);
						currentFlow.setSdtofnode(new Date());
						currentFlow.setDoDate(new Date());
						currentFlow.setLastOperateType(1);
						INSTANCE.currentFlowMapper.updateByExampleSelective(currentFlow, example2);
						
						//如果是取消流程
						
						
						ModeStatus modeStatus2 = INSTANCE.modeStatusMapper.selectByPrimaryKey(modeId);
						if(null!=modeStatus2){
							modeStatus2.setFlowStatus("1");
							INSTANCE.modeStatusMapper.updateByPrimaryKey(modeStatus2);
						}else{
							modeStatus.setModeId(modeId);
							//1：流程运转中
							modeStatus.setStatus("1");
							modeStatus.setFlowStatus("1");
							INSTANCE.modeStatusMapper.insert(modeStatus);
						}
					}else{
						end = "jieshu";
						jsonObject.put("modeId", modeId);
						INSTANCE.currentFlowMapper.deleteByExample(example2);
						modeStatus.setModeId(modeId);
						//5:流程结束
						modeStatus.setStatus(currentFlow.getFlowEndState()+"");
						modeStatus.setFlowStatus("2");
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
				flowHistroy.setOperateType(1);
				flowHistroy.setDoDate(new Date());
 				INSTANCE.flowHistroyMapper.insert(flowHistroy);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("数据库插入错误");
				throw new FlowException("database do error");
			}
			jsonObject.put("end", end);
		return jsonObject;
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
		String deptNo = currentFlow.getFkDept();
		String floNodeId = "";
	    floNodeId = currentFlow.getFloNodeId();
	    currentFlow.setFloNodeId(floNodeId);
	    currentFlow.setLastOperateType(1);
	    FlowNode flowNode = INSTANCE.flowNodeMapper.selectByPrimaryKey(floNodeId);
		try {
			floNodeId = deque(flowNode, currentFlow);
		} catch (Exception e1) {
			log.error("递归获取下一步floNodeId出错");
			
			throw new FlowException("deque do error");
		}
		INSTANCE.currentFlowMapper.updateByPrimaryKey(currentFlow);
		JSONObject jsonObject = new JSONObject();
		JSONArray arrays = new JSONArray();
		String end="";
		if("end".equals(floNodeId)){
			end=floNodeId;
			arrays=null;
		}else{
			List<NodeActors> nodeActors = INSTANCE.nodeActorsMapper.getNextNodeActorsByFloNodeId(floNodeId);
			List<User> usersSubmit = new ArrayList<>();
			if(null!=nodeActors&&nodeActors.size()>0){
			List<User> users = INSTANCE.userDao.selectAllUser();
				for(NodeActors nodeActors2:nodeActors){
					String roleCode = INSTANCE.roleDao.selectRoleById(nodeActors2.getRolecode()).getRoleCode();
					Iterator<User> iterator = users.iterator();
					if(roleCode.endsWith("*.")){
			    		roleCode=roleCode+"r"+deptNo+".";
			    	}
				    while (iterator.hasNext()) {
				    	User user = iterator.next();
				    	String userRole = user.getUserRole();
						if(userRole!=null&&userRole.contains(roleCode)){
							usersSubmit.add(user);
							iterator.remove();
						}
					}
				}
			}
			arrays = JSONArray.fromObject(usersSubmit);
		}
		jsonObject.put("receiver", arrays);
		jsonObject.put("url", currentFlow.getUrl());
		jsonObject.put("end",end);
		return jsonObject.toString();
	}
	
	/**
	 * 新流程发起，初始提交
	 * @param currentFlow url,Title,Starter,StartName,Sender,SenderName,FK_Dept,DeptName,NodeName,PRI,SDTOfNode,SDTOfFlow,Actor,ActorType,Memo
	 *        flowHistroy Actor ActorName ActorResult view
	 * @author xianing
	 */
	
	@Transactional
	public String shenpiSubmitFlow(CurrentFlow currentFlowOld,FlowHistroy flowHistroy,String next_user_id,String next_name) throws Exception{
		    currentFlowOld.setRdt(new Date());
			ModeStatus modeStatus = new ModeStatus(); 	
			INSTANCE.init();
			/**0：流程刚发起,暂存状态
			 * 1：流程刚发起,提交状态
			 */
			currentFlowOld.setWfstate(0);
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
					
					String oldFloNodeId = currentFlow.getFloNodeId();
					FlowNode flowNode = INSTANCE.flowNodeMapper.selectByPrimaryKey(oldFloNodeId);
					String nextFloNodeId = deque(flowNode, currentFlow);
					flowHistroy = BeanUtil.copyCurrentFlowToHistory(currentFlow, flowHistroy);
					flowHistroy.setFlowNodeLast(currentFlow.getFlowNodeLast());
					if(!"end".equals(nextFloNodeId)){
						currentFlow.setActor(next_user_id);
						currentFlow.setActorname(next_name);
						currentFlow.setFloNodeId(nextFloNodeId);
						currentFlow.setDeptname(currentFlowOld.getDeptname());
						currentFlow.setReadreceipts(0);
						currentFlow.setSdtofnode(new Date());
						currentFlow.setDoDate(new Date());
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
						modeStatus.setStatus(currentFlow.getFlowEndState()+"");
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
				flowHistroy.setOperateType(2);
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
	public String TuiHuiFlow(String currentFlowId,String view) throws Exception{
			ModeStatus modeStatus = new ModeStatus(); 	
			INSTANCE.init();
			/**0：流程刚发起,暂存状态
			 * 1：流程刚发起,提交状态
			 */
			FlowHistroy flowHistroy = new FlowHistroy();
			CurrentFlowExample example1 = new CurrentFlowExample();
			example1.createCriteria().andModeIdEqualTo(currentFlowId);
			List<CurrentFlow> currentFlows = INSTANCE.currentFlowMapper.selectByExampleNew(currentFlowId);
			CurrentFlow currentFlow = currentFlows.get(0);
			String url = currentFlows.get(0).getUrl();
			currentFlow.setRdt(new Date());
			currentFlow.setDoDate(new Date());
			FlowNode flowNode = INSTANCE.flowNodeMapper.selectByPrimaryKey(currentFlow.getFloNodeId());
			String modeId = "";
			if(null!=url&&url.contains("-")){
				String urls[] = url.split("-");
				url=urls[0];
				modeId =urls[1];
			}else{
				log.error("url为null或者url格式有误");
				throw new FlowException("url format error");
			}
			JSONObject jsonObject = new JSONObject();
			try {
				//returnRole=0代表退回到第一步
				Integer returnRole = flowNode.getReturnrole();
				if(returnRole==Constant.FIRST_FLOW_NODE){
				//获取第一步步骤节点
				FlowNode flowNode1 = INSTANCE.flowNodeMapper.selectStartFlowNode(flowNode.getFloTmpId());
				//将当前流程操作步骤设置成第一步
			    currentFlow.setFloNodeId(flowNode1.getId());
			    FlowHistroyExample example = new FlowHistroyExample();
			    example.createCriteria().andFloNodeIdEqualTo(flowNode1.getId()).andUrlEqualTo(currentFlow.getUrl());
			    currentFlow.setLastPerson(currentFlow.getActorname());
			    //将流程操作角色设置为发起流程的人
			    currentFlow.setActor(currentFlow.getStarter());
			    //将流程操作角色设置为发起流程的人
				currentFlow.setActorname(currentFlow.getStartername());
				CurrentFlowExample example2 = new CurrentFlowExample();
				example2.createCriteria().andIdEqualTo(currentFlowId);
				currentFlow.setReadreceipts(0);
				currentFlow.setLastView(view);
				INSTANCE.currentFlowMapper.updateByExampleSelective(currentFlow, example2);
				
				flowHistroy = BeanUtil.copyCurrentFlowToHistory(currentFlow, flowHistroy);
				
				flowHistroy.setView(view);
				flowHistroy.setFlowNodeLast(currentFlow.getFlowNodeLast());
				//流程历史操作类型为2 退回
				flowHistroy.setOperateType(2);
				flowHistroy.setLastOperateType(currentFlow.getLastOperateType());
				INSTANCE.flowHistroyMapper.insert(flowHistroy); 
				
				jsonObject.put("result", "0");
				
				return jsonObject.toString();
				}else if(returnRole==Constant.LAST_FLOW_NODE){
					//退回到上一步
					//将当前流程操作步骤设置成上一步步骤主键
					currentFlow.setFloNodeId(currentFlow.getFlowNodeLast());
					//退回流程，当前流程的上一步为现在正在操作的流程的 步骤主键
					currentFlow.setFlowNodeLast(flowNode.getId());
					currentFlow.setLastPerson(currentFlow.getActorname());
					currentFlow.setLastView(view);
					FlowHistroyExample example = new FlowHistroyExample();
					INSTANCE.flowHistroyMapper.selectByExample(example);
					
					flowHistroy = BeanUtil.copyCurrentFlowToHistory(currentFlow, flowHistroy);
					flowHistroy.setFloNodeId(flowNode.getId());
					flowHistroy.setFlowNodeLast(currentFlow.getFlowNodeLast());
					flowHistroy.setOperateType(2);
					flowHistroy.setLastOperateType(currentFlow.getLastOperateType());
					INSTANCE.flowHistroyMapper.insert(flowHistroy); 
					CurrentFlowExample example2 = new CurrentFlowExample();
					example2.createCriteria().andIdEqualTo(currentFlowId);
					currentFlow.setReadreceipts(0);
					INSTANCE.currentFlowMapper.updateByExampleSelective(currentFlow, example2);
					jsonObject.put("result", "1");
					return jsonObject.toString();	
				}else if(returnRole==Constant.ALL_FLOW_NODE){
					List<FlowHistroy> flowHistroys = new ArrayList<>();
					flowHistroys = getTuiHuiFlowhistorysNew(flowHistroys, currentFlow.getUrl(), currentFlow.getFlowNodeLast());
					
					List<FlowHistroy> newFlowHistorys = new ArrayList<>();
					for(FlowHistroy flowHistroy2:flowHistroys){
						String flowNodeName = INSTANCE.flowNodeMapper.selectByPrimaryKey(flowHistroy2.getFloNodeId()).getFlownodename();
						flowHistroy2.setFlowNodeName(flowNodeName);
						int step = Integer.parseInt(flowHistroy2.getStep());
						int b = Integer.parseInt(currentFlow.getStep()); 
					    if(step<b){
					    	newFlowHistorys.add(flowHistroy2);
					    }
					}
					
					JSONArray jObject = JSONArray.fromObject(newFlowHistorys);
					jsonObject.put("result", "2");
					jsonObject.put("list", jObject);
					return jsonObject.toString();
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("数据库插入错误");
				throw new FlowException("database do error");
			}
		return "success";
	}
	
	@Transactional
	public String TuiHuiZhi(String url,String view,CurrentFlow currentFlow) throws Exception{
			ModeStatus modeStatus = new ModeStatus(); 	
			INSTANCE.init();
			/**0：流程刚发起,暂存状态
			 * 1：流程刚发起,提交状态
			 */
			FlowHistroy flowHistroy = new FlowHistroy();
			CurrentFlowExample example1 = new CurrentFlowExample();
			example1.createCriteria().andUrlEqualTo(url);
			List<CurrentFlow> currentFlows = INSTANCE.currentFlowMapper.selectByExample(example1);
			CurrentFlow currentFlowNow = currentFlows.get(0);
			
			currentFlowNow.setRdt(new Date());
			currentFlowNow.setDoDate(new Date());
			
			String modeId = "";
			if(null!=url&&url.contains("-")){
				String urls[] = url.split("-");
				url=urls[0];
				modeId =urls[1];
			}else{
				log.error("url为null或者url格式有误");
				throw new FlowException("url format error");
			}
			JSONObject jsonObject = new JSONObject();
			try {
				    String newFloNodeId = currentFlow.getFloNodeId();
				    String oldFloNodeId = currentFlowNow.getFloNodeId();
				    String historyFloNodeId = currentFlow.getFloNodeId();
				    String historyFloNodeLast = currentFlowNow.getFloNodeId();
				    String historyActor = currentFlowNow.getActor();
				    String historyActorName = currentFlowNow.getActorname();
				    Integer historyLastOperateType = currentFlowNow.getLastOperateType();
				    String lastView = view;
				    //退回流程，当前流程的上一步为现在正在操作的流程的 步骤主键
				    currentFlowNow.setFlowNodeLast(currentFlowNow.getFloNodeId());
					//退回到指定步骤
				    currentFlowNow.setFloNodeId(currentFlow.getFloNodeId());
				    currentFlowNow.setActor(currentFlow.getActor());
				    currentFlowNow.setActorname(currentFlow.getActorname());
				    currentFlowNow.setDeptname(currentFlow.getDeptname());
				    currentFlowNow.setLastView(view);
				    currentFlowNow.setLastPerson(historyActorName);
					FlowHistroyExample example = new FlowHistroyExample();
					INSTANCE.flowHistroyMapper.selectByExample(example);
					flowHistroy = BeanUtil.copyCurrentFlowToHistory(currentFlowNow, flowHistroy);
					flowHistroy.setFloNodeId(historyFloNodeLast);
					flowHistroy.setFlowNodeLast(historyFloNodeId);
					flowHistroy.setActor(historyActor);
					flowHistroy.setActorname(historyActorName);
					flowHistroy.setView(view);
					flowHistroy.setOperateType(2);
					flowHistroy.setDoDate(new Date());
					flowHistroy.setLastOperateType(historyLastOperateType);
					INSTANCE.flowHistroyMapper.insert(flowHistroy); 
					CurrentFlowExample example2 = new CurrentFlowExample();
					example2.createCriteria().andIdEqualTo(currentFlowNow.getId());
					currentFlowNow.setReadreceipts(0);
					currentFlowNow.setLastOperateType(2);
					currentFlowNow.setDoDate(new Date());
					INSTANCE.currentFlowMapper.updateByExampleSelective(currentFlowNow, example2);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("数据库插入错误");
				throw new FlowException("database do error");
			}
		return "1";
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
		String modeId = "";
		String url = currentFlow.getUrl();
		if(null!=url&&url.contains("-")){
		String[] urls = url.split("-");
			url = urls[0];
			modeId = urls[1];
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
		currentFlow.setBusId(business.getId());
		currentFlow.setDoDate(new Date());
		currentFlow.setModeId(modeId);
		currentFlow.setReadreceipts(0);
		currentFlow.setLastOperateType(null);
		flowHistroy = BeanUtil.copyCurrentFlowToHistory(currentFlow, flowHistroy);
		try {
			INSTANCE.currentFlowMapper.insert(currentFlow);
			
			ModeStatusExample modeStatusExample = new ModeStatusExample();
			modeStatusExample.createCriteria().andModeIdEqualTo(modeId);
			
			List<ModeStatus> modeStatusDuo = INSTANCE.modeStatusMapper.selectByExample(modeStatusExample);
			ModeStatus modeStatus = new ModeStatus();
			modeStatus.setModeId(modeId);
			modeStatus.setStatus("1");
			modeStatus.setFlowStatus("4");
			if(modeStatusDuo!=null&&modeStatusDuo.size()>0){
				INSTANCE.modeStatusMapper.updateByExample(modeStatus, modeStatusExample);
			}else{
				INSTANCE.modeStatusMapper.insert(modeStatus);
			}
			/*INSTANCE.flowHistroyMapper.insert(flowHistroy);*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("数据库插入错误");
			throw new FlowException("database do error");
		}
		return "success";
	}
	
	@Transactional
	public String zancunFlowUpdateState(CurrentFlow currentFlow,FlowHistroy flowHistroy) throws Exception{
		currentFlow.setRdt(new Date());
		INSTANCE.init();
		/**0：流程刚发起,暂存状态
		 * 1：流程刚发起,提交状态
		 */
		currentFlow.setWfstate(0);
		BusinessExample example = new BusinessExample();
		String modeId = "";
		String url = currentFlow.getUrl();
		if(null!=url&&url.contains("-")){
		String[] urls = url.split("-");
			url = urls[0];
			modeId = urls[1];
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
		currentFlow.setBusId(business.getId());
		currentFlow.setDoDate(new Date());
		currentFlow.setModeId(modeId);
		currentFlow.setReadreceipts(0);
		currentFlow.setLastOperateType(null);
		flowHistroy = BeanUtil.copyCurrentFlowToHistory(currentFlow, flowHistroy);
		try {
			INSTANCE.currentFlowMapper.insert(currentFlow);
			ModeStatus modeStatus = new ModeStatus();
			modeStatus.setModeId(modeId);
			modeStatus.setStatus("1");
			modeStatus.setFlowStatus("4");
			ModeStatusExample modeStatusExample = new ModeStatusExample();
			modeStatusExample.createCriteria().andModeIdEqualTo(modeId);
			int i = INSTANCE.modeStatusMapper.updateByExample(modeStatus, modeStatusExample);
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
		currentFlow.setSdtofnode(new Date());
		currentFlow.setDoDate(new Date());
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
		currentFlow.setDoDate(new Date());
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
	
	private static Date date = null;
	public static List<FlowHistroy> getTuiHuiFlowhistorys(List<FlowHistroy> endFlowHistorys,String url,String flowNodeLast){
		try {
			
			FlowHistroy flowHistroy;
			if(null==date){
				FlowHistroyExample example=new FlowHistroyExample();
				example.createCriteria().andUrlEqualTo(url).andFloNodeIdEqualTo(flowNodeLast).andOperateTypeNotEqualTo(4);
				example.setOrderByClause("do_date desc");
				List<FlowHistroy> histroys = INSTANCE.flowHistroyMapper.selectByExampleWithBLOBs(example);
				flowHistroy= histroys.get(0);
				date = flowHistroy.getDoDate();
			}else{
				FlowHistroyExample example=new FlowHistroyExample();
				example.createCriteria().andUrlEqualTo(url).andFloNodeIdEqualTo(flowNodeLast).andDoDateLessThan(date).andOperateTypeNotEqualTo(4);
				example.setOrderByClause("do_date desc");
				List<FlowHistroy> histroys = INSTANCE.flowHistroyMapper.selectByExampleWithBLOBs(example);
				flowHistroy= histroys.get(0);
				date=flowHistroy.getDoDate();
			}
			if(null!=flowHistroy.getFlowNodeLast()&&!"".equals(flowHistroy.getFlowNodeLast())){
			  endFlowHistorys.add(flowHistroy);	
			  getTuiHuiFlowhistorys(endFlowHistorys,url, flowHistroy.getFlowNodeLast());
			}else{
			  endFlowHistorys.add(flowHistroy);	
			  date = null;
			  return endFlowHistorys;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return endFlowHistorys;
	}
	
	
	public static List<FlowHistroy> getTuiHuiFlowhistorysNew(List<FlowHistroy> endFlowHistorys,String url,String flowNodeLast){
		try {
			
		    FlowHistroy flowHistroy;
			FlowHistroyExample example=new FlowHistroyExample();
			example.createCriteria().andUrlEqualTo(url).andFloNodeIdEqualTo(flowNodeLast).andOperateTypeEqualTo(4);
			example.setOrderByClause("do_date desc");
			List<FlowHistroy> histroys = INSTANCE.flowHistroyMapper.selectByExampleNewWithBLOBs(url,flowNodeLast,1,"");
			flowHistroy= histroys.get(0);
			if(null!=flowHistroy.getFlowNodeLast()&&!"".equals(flowHistroy.getFlowNodeLast())){
			  endFlowHistorys.add(flowHistroy);	
			  getTuiHuiFlowhistorysNew(endFlowHistorys,url, flowHistroy.getFlowNodeLast());
			}else{
			  endFlowHistorys.add(flowHistroy);	
			  return endFlowHistorys;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return endFlowHistorys;
	}
	public String boHuiFlow(String url,String view){
		CurrentFlowExample example = new CurrentFlowExample();
		example.createCriteria().andUrlEqualTo(url);
		List<CurrentFlow> list = INSTANCE.currentFlowMapper.selectByExample(example);
		if(list.size()>0){
			CurrentFlow currentFlow = list.get(0);
			//当前流程步骤
			//String floNodeId= currentFlow.getFloNodeId();
			//当前流程上一步
			String lastFloNodeId = currentFlow.getFlowNodeLast();
			if(null==lastFloNodeId||"".equals(lastFloNodeId)){
				return "noLast";
			}
			FlowHistroy flowHistroy = new FlowHistroy();
			flowHistroy = BeanUtil.copyCurrentFlowToHistory(currentFlow, flowHistroy);
			flowHistroy.setView(view);
			flowHistroy.setDoDate(new Date());
			flowHistroy.setId(new TimeUUID().getTimeUUID());
			flowHistroy.setOperateType(0);
			flowHistroy.setFlowNodeLast(currentFlow.getFlowNodeLast());
			INSTANCE.currentFlowMapper.deleteByPrimaryKey(currentFlow.getId());
			
			INSTANCE.flowHistroyMapper.insert(flowHistroy);
			
			ModeStatus modeStatus = new ModeStatus();
			modeStatus = INSTANCE.modeStatusMapper.selectByPrimaryKey(currentFlow.getModeId());
			if(null!=modeStatus){
				String cuNopassState = currentFlow.getFlowNopassState()+"";
				if("".equals(cuNopassState)){
					cuNopassState = "0";
				}
				modeStatus.setStatus(cuNopassState);
				modeStatus.setFlowStatus("0");
				INSTANCE.modeStatusMapper.updateByPrimaryKeySelective(modeStatus);
				return "true";
			}else{
				return "fail";
			}
		}else{
			return "fail";
		}
	}
	
	public String deleteChaoSongFlow(String id){
		CurrentFlow currentFlow = INSTANCE.currentFlowChaoSongMapper.selectByPrimaryKey(id);
		if(currentFlow!=null){
			//当前流程步骤
			//String floNodeId= currentFlow.getFloNodeId();
			//当前流程上一步
			String lastFloNodeId = currentFlow.getFlowNodeLast();
			if(null==lastFloNodeId||"".equals(lastFloNodeId)){
				return "noLast";
			}
			FlowHistroy flowHistroy = new FlowHistroy();
			flowHistroy = BeanUtil.copyCurrentFlowToHistory(currentFlow, flowHistroy);
			flowHistroy.setDoDate(new Date());
			flowHistroy.setId(new TimeUUID().getTimeUUID());
			flowHistroy.setOperateType(4);
			flowHistroy.setFlowNodeLast(currentFlow.getFlowNodeLast());
			INSTANCE.currentFlowChaoSongMapper.deleteByPrimaryKey(currentFlow.getId());
			
			INSTANCE.flowHistroyMapper.insert(flowHistroy);
			return "ok";
		}else{
			return "fail";
		}
	}
	public String chaoSongFlow(String id,List<User> users){
		CurrentFlowExample example = new CurrentFlowExample();
		example.createCriteria().andUrlLike("%"+id);
		List<CurrentFlow> list = INSTANCE.currentFlowMapper.selectByExample(example);
		if(list.size()>0){
			CurrentFlow currentFlow = list.get(0);
			for(User user:users){
				
				currentFlow.setActor(user.getUserId());
				currentFlow.setActorname(user.getuName());
				currentFlow.setWfstate(1);
				String ss = judgeChaoSong(currentFlow.getUrl(), user.getUserId());
				if("".equals(ss)){
					currentFlow.setId(new TimeUUID().getTimeUUID());
					INSTANCE.currentFlowChaoSongMapper.insert(currentFlow);
				}else{
					example = new CurrentFlowExample();
					example.createCriteria().andUrlEqualTo(currentFlow.getUrl());
					INSTANCE.currentFlowChaoSongMapper.updateByExampleSelective(currentFlow, example);
				}
			}
			return "ok";
		}else{
			return "fail";
		}
	}
	
	public static String judgeChaoSong(String url,String actor){
		CurrentFlowExample example = new CurrentFlowExample();
		example.createCriteria().andUrlEqualTo(url).andActorEqualTo(actor);
		List<CurrentFlow> currentFlows = INSTANCE.currentFlowChaoSongMapper.selectByExample(example);
		if(currentFlows.size()>0){
			return currentFlows.get(0).getId();
		}else{
		    return "";	
		}
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

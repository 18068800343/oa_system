package org.ldxx.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.CurrentFlowExample;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.FlowHistroyExample;
import org.ldxx.bean.FlowNode;
import org.ldxx.bean.ModeStatus;
import org.ldxx.bean.ModeStatusExample;
import org.ldxx.bean.User;
import org.ldxx.mapper.CurrentFlowChaoSongMapper;
import org.ldxx.mapper.CurrentFlowMapper;
import org.ldxx.mapper.FlowHistroyMapper;
import org.ldxx.mapper.FlowNodeMapper;
import org.ldxx.mapper.ModeStatusMapper;
import org.ldxx.model.CurrentFlowVo;
import org.ldxx.model.FlowHistoryVo;
import org.ldxx.service.CurrentFlowService;
import org.ldxx.service.FlowHistoryService;
import org.ldxx.service.UserService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 人员用户管理
 * @author hp
 *
 */
@RequestMapping("currentFlow")
@Controller
public class CurrentFlowController {
	
	@Autowired
	private CurrentFlowService currentFlowService;
	@Autowired
	FlowHistroyMapper flowHistroyMapper;
	@Autowired
	CurrentFlowMapper currentFlowMapper;
	@Autowired
	CurrentFlowChaoSongMapper currentFlowChaoSongMapper;
	@Autowired
	FlowNodeMapper flowNodeMapper;
	@Autowired
	ModeStatusMapper modeStatusMapper;
	@RequestMapping("/getCurrentFlowListStatus1ByUser")
	@ResponseBody
	public List<CurrentFlowVo> getCurrentFlowListByUser(String userId,String statu,HttpSession session){
		List<CurrentFlowVo> list=null;
		User user = (User) session.getAttribute("user");
		if(null==user) {
			return list;
		}
		String id = user.getUserId();
 		list = currentFlowService.getCurrentFlowListByUser(id, statu);
 		List<CurrentFlowVo> list1 = currentFlowChaoSongMapper.getCurrentFlowVoChaoSongByUserId(id);
 		list.addAll(list1);
		return list;
	}
	@RequestMapping("/getCurrentFlowListByStatus")
	@ResponseBody
	public List<CurrentFlowVo> getCurrentFlowListByStatus(String userId,String statu,HttpSession session){
		List<CurrentFlowVo> list=null;
		User user = (User) session.getAttribute("user");
		if(null==user) {
			return list;
		}
		String id = user.getUserId();
		list = currentFlowMapper.getCurrentFlowVoByStatus(id, statu);
		List<CurrentFlowVo> list1 = currentFlowChaoSongMapper.getCurrentFlowVoChaoSongByUserId(id);
		list.addAll(list1);
		return list;
	}
	@RequestMapping("/getCurrentFlowChaoSongListByUser")
	@ResponseBody
	public List<CurrentFlowVo> getCurrentFlowChaoSongListByUser(String userId,String statu,HttpSession session){
		List<CurrentFlowVo> list=null;
		User user = (User) session.getAttribute("user");
		if(null==user) {
			return list;
		}
		String id = user.getUserId();
 		list = currentFlowService.getCurrentFlowListByUser(id, statu);
 		List<CurrentFlowVo> list1 = currentFlowChaoSongMapper.getCurrentFlowVoChaoSongByUserId(userId);
 		list.addAll(list1);
		return list;
	}
	@RequestMapping("/updateReadReceipts")
	@ResponseBody
	public String updateReadReceipts(String url,HttpSession session){
		CurrentFlowExample example = new CurrentFlowExample();
		example.createCriteria().andUrlEqualTo(url);
		List<CurrentFlow> currentFlows = currentFlowMapper.selectByExample(example);
		CurrentFlow currentFlow = currentFlows.get(0);
		currentFlow.setReadreceipts(1);
		int i = currentFlowMapper.updateByPrimaryKeySelective(currentFlow);
		return i+"";
	}
	
	@RequestMapping("/chexiaoGetCurrentFlow")
	@ResponseBody
	public String chexiaoGetCurrentFlow(String url,HttpSession session,String floHistoryId){
		FlowHistroy flowHistroy = flowHistroyMapper.selectByPrimaryKey(floHistoryId);
		String floNodeLast = flowHistroy.getFloNodeId();
		CurrentFlowExample example = new CurrentFlowExample();
		example.createCriteria().andUrlEqualTo(url).andFlowNodeLastEqualTo(floNodeLast);
		List<CurrentFlow> currentFlows = currentFlowMapper.selectByExample(example);
		Integer readReceipts = 5;
		
		if(null!=currentFlows&&currentFlows.size()>0){
			//readReceipts = currentFlows.get(0).getReadreceipts();
			readReceipts=0;
		}else{
			readReceipts = 1;
		}
		return readReceipts+"";
	}
	
	
	
	@RequestMapping("/doChexiao")
	@ResponseBody
	public String doChexiao(String url,HttpSession session){
		User user = (User) session.getAttribute("user");
		String id = user.getUserId();
		String uName = user.getuName();
		String omName = user.getOmName();
		CurrentFlowExample example = new CurrentFlowExample();
		example.createCriteria().andUrlEqualTo(url);
		List<CurrentFlow> currentFlows = currentFlowMapper.selectByExample(example);
		CurrentFlow currentFlow = new CurrentFlow();
		if(null!=currentFlows&&currentFlows.size()>0){
			currentFlow = currentFlows.get(0);
			String floNodeLast = currentFlow.getFlowNodeLast();
			currentFlow.setDoDate(new Date());
			currentFlow.setFloNodeId(floNodeLast);
			currentFlow.setActor(id);
			currentFlow.setActorname(uName);
			currentFlow.setDeptname(omName);
			currentFlow.setReadreceipts(1);
			FlowHistroyExample example2 = new FlowHistroyExample();
			example2.createCriteria().andFloNodeIdEqualTo(floNodeLast).andUrlEqualTo(url).andOperateTypeEqualTo(1);
			List<FlowHistroy> flowHistroys = flowHistroyMapper.selectByExample(example2);
			FlowHistroy flowHistroy = flowHistroys.get(0);
			String historyFloNodeLast = flowHistroy.getFlowNodeLast();
			currentFlow.setFlowNodeLast(historyFloNodeLast);
			flowHistroy.setOperateType(3);
			flowHistroy.setId(new TimeUUID().getTimeUUID());
			currentFlowMapper.updateByPrimaryKeySelective(currentFlow);
			String flowTmpId = currentFlow.getFloTmpId();
			FlowNode flowNode = flowNodeMapper.selectStartFlowNode(flowTmpId);
			String startFlowNodeId=flowNode.getId();
			if(null!=floNodeLast&&floNodeLast.equals(startFlowNodeId)){
				ModeStatusExample modeStatusExample = new ModeStatusExample();
				String modeId = currentFlow.getModeId();
				modeStatusExample.createCriteria().andModeIdEqualTo(modeId);
				ModeStatus modeStatus = new ModeStatus();
				List<ModeStatus> modeStatusDuo = modeStatusMapper.selectByExample(modeStatusExample);
				modeStatus.setModeId(modeId);
				modeStatus.setStatus("1");
				modeStatus.setFlowStatus("4");
				if(modeStatusDuo!=null&&modeStatusDuo.size()>0){
					modeStatusMapper.updateByExample(modeStatus, modeStatusExample);
				}else{
					modeStatusMapper.insert(modeStatus);
				}
			}
			flowHistroy.setDoDate(new Date());
			flowHistroyMapper.insert(flowHistroy);
		}
		return "1";
	}
	
	
	@RequestMapping("/getCurrentFlowListStatus0ByUser")
	@ResponseBody
	public List<CurrentFlowVo> getCurrentFlowListStatus0ByUser(String userId){
		return currentFlowService.getCurrentFlowListByUser(userId, "0");
	}
	
	@RequestMapping("/updateFkDept")
	@ResponseBody
	public int updateFkDept(String id,String fkDept){
		return currentFlowMapper.updateFkDept(id, fkDept);
	}
	
	@RequestMapping("/updateFkDeptByModeId")
	@ResponseBody
	public int updateFkDeptByModeId(String id,String fkDept){
		return currentFlowMapper.updateFkDeptByModeId(id, fkDept);
	}
}

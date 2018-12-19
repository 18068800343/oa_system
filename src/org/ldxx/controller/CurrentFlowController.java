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
import org.ldxx.bean.User;
import org.ldxx.mapper.CurrentFlowMapper;
import org.ldxx.mapper.FlowHistroyMapper;
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
	@RequestMapping("/getCurrentFlowListStatus1ByUser")
	@ResponseBody
	public List<CurrentFlowVo> getCurrentFlowListByUser(String userId,String statu,HttpSession session){
		User user = (User) session.getAttribute("user");
		String id = user.getUserId();
 		List<CurrentFlowVo> list = currentFlowService.getCurrentFlowListByUser(id, statu);
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
			readReceipts = currentFlows.get(0).getReadreceipts();
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
			flowHistroyMapper.insert(flowHistroy);
		}
		return "1";
	}
	
	
	@RequestMapping("/getCurrentFlowListStatus0ByUser")
	@ResponseBody
	public List<CurrentFlowVo> getCurrentFlowListStatus0ByUser(String userId){
		return currentFlowService.getCurrentFlowListByUser(userId, "0");
	}

}

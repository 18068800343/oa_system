package org.ldxx.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.CurrentFlowExample;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.ModeStatus;
import org.ldxx.bean.User;
import org.ldxx.mapper.CurrentFlowMapper;
import org.ldxx.mapper.FlowHistroyMapper;
import org.ldxx.mapper.ModeStatusMapper;
import org.ldxx.model.FlowHistoryNowAndLast;
import org.ldxx.model.FlowHistoryVo;
import org.ldxx.service.FlowHistoryService;
import org.ldxx.service.UserService;
import org.ldxx.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 人员用户管理
 * @author hp
 *
 */
@RequestMapping("flowHistory")
@Controller
public class FlowHistoryController {
	
	@Autowired
	private FlowHistoryService flowHistoryService;
	@Autowired
	private FlowHistroyMapper flowHistroyMapper;
	@Autowired
	private CurrentFlowMapper currentFlowMapper;
	@Autowired
	private ModeStatusMapper modeStatusMapper;
	@RequestMapping("/getFlowHistoryByUser")
	@ResponseBody
	public List<FlowHistoryVo> getFlowHistoryByUser(String status,HttpSession session){
		List<FlowHistoryVo> list=null;
		User user = (User) session.getAttribute("user");
		if(null==user) {
			return list;
		}
	    String userId = user.getUserId();
	    user.getuName();
	    list = flowHistoryService.getFlowHistoryByUser(userId,status);
		return list;
	}
	
	@RequestMapping("/getFlowHistoryDeleteByUser")
	@ResponseBody
	public List<FlowHistoryVo> getFlowHistoryDeleteByUser(String status,HttpSession session){
		List<FlowHistoryVo> list=null;
		User user = (User) session.getAttribute("user");
		if(null==user) {
			return list;
		}
		String userId = user.getUserId();
		user.getuName();
		list = flowHistroyMapper.getFlowHistoryDeleteVoByUserId(userId, status);
		return list;
	}
	
	@RequestMapping("/getDistinctFlowHistoryByUser")
	@ResponseBody
	public List<FlowHistoryVo> getDistinctFlowHistoryByUser(String status,HttpSession session){
		List<FlowHistoryVo> list=null;
		User user = (User) session.getAttribute("user");
		if(null==user) {
			return list;
		}
	    String userId = user.getUserId();
	    user.getuName();
		list = flowHistoryService.getDistinctFlowHistoryByUser(userId,status);
		return list;
	}
	
	@RequestMapping("/getFlowHistoryByUserAlreadyEnd")
	@ResponseBody
	public List<FlowHistoryVo> getFlowHistoryByUserAlreadyEnd(String userId){
		return flowHistoryService.getFlowHistoryByUser(userId,"");
	}
	
	@RequestMapping("/deleteFlowHistory")
	@ResponseBody
	public int deleteFlowHistory(String id){
		int i=flowHistoryService.deleteFlowHistory(id);
		return i;
	}
	
	@RequestMapping("/deleteCurrentFlow")
	@ResponseBody
	public int deleteCurrentFlow(String id){
		CurrentFlow currentFlow = currentFlowMapper.selectByPrimaryKey(id);
		FlowHistroy flowHistroy = new FlowHistroy();
		flowHistroy = BeanUtil.copyCurrentFlowToHistory(currentFlow, flowHistroy);
		flowHistroy.setFlowNodeLast(currentFlow.getFlowNodeLast());
		flowHistroy.setLastOperateType(3);
		flowHistroy.setOperateType(4);
		flowHistroy.setDoDate(new Date());
		int i = currentFlowMapper.deleteByPrimaryKey(id);
		if(i>0){
			 i = flowHistroyMapper.insert(flowHistroy);
			 i = flowHistroyMapper.deleteFlowHistory(flowHistroy.getId());
			 String modeId = currentFlow.getModeId();
			 ModeStatus modeStatus = modeStatusMapper.selectByPrimaryKey(modeId);
				if(null!=modeStatus){
					modeStatus.setStatus("7");
					modeStatus.setFlowStatus("7");
					modeStatusMapper.updateByPrimaryKey(modeStatus);
				}else{
					modeStatus=new ModeStatus();
					modeStatus.setModeId(modeId);
					modeStatus.setStatus("7");
					modeStatus.setFlowStatus("7");
					modeStatusMapper.insert(modeStatus);
				}
		}
		return i;
	}
	
	@RequestMapping("/getHistoryNowAndLast")
	@ResponseBody
	public List<FlowHistoryNowAndLast> getHistoryNowAndLast(String url){
		List<FlowHistoryNowAndLast> list =flowHistroyMapper.getFlowHistorysLeftJoinByUrl(url);
        CurrentFlowExample currentFlowExample = new CurrentFlowExample();
		currentFlowExample.createCriteria().andUrlEqualTo(url);
		List<CurrentFlow> list2 = currentFlowMapper.selectByExample(currentFlowExample);
		FlowHistoryNowAndLast flowHistoryNowAndLast = new FlowHistoryNowAndLast();
		if(list2.size()==1){
			CurrentFlow currentFlow = list2.get(0);
			flowHistoryNowAndLast.setTitle(currentFlow.getTitle());
			flowHistoryNowAndLast.setActorname(currentFlow.getActorname());
			flowHistoryNowAndLast.setView("");
			flowHistoryNowAndLast.setDoDate(null);
			flowHistoryNowAndLast.setOperateType(8);
		}
		if(flowHistoryNowAndLast.getTitle()!=null){
			list.add(flowHistoryNowAndLast);
		}
		return list;
	}
	@RequestMapping("/getHistoryNowAndLastByModeId")
	@ResponseBody
	public List<FlowHistoryNowAndLast> getHistoryNowAndLastByModeId(String id){
		List<FlowHistoryNowAndLast> list =flowHistroyMapper.getFlowHistorysLeftJoinByModeId(id);
		return list;
	}
}

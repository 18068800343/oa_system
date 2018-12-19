package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.User;
import org.ldxx.model.FlowHistoryVo;
import org.ldxx.service.FlowHistoryService;
import org.ldxx.service.UserService;
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
	
	@RequestMapping("/getFlowHistoryByUser")
	@ResponseBody
	public List<FlowHistoryVo> getFlowHistoryByUser(String status,HttpSession session){
		User user = (User) session.getAttribute("user");
	    String userId = user.getUserId();
	    user.getuName();
		return flowHistoryService.getFlowHistoryByUser(userId,status);
	}
	
	@RequestMapping("/getDistinctFlowHistoryByUser")
	@ResponseBody
	public List<FlowHistoryVo> getDistinctFlowHistoryByUser(String status,HttpSession session){
		User user = (User) session.getAttribute("user");
	    String userId = user.getUserId();
	    user.getuName();
		return flowHistoryService.getDistinctFlowHistoryByUser(userId,status);
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

}

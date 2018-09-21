package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.User;
import org.ldxx.model.CurrentFlowVo;
import org.ldxx.model.FlowHistoryVo;
import org.ldxx.service.CurrentFlowService;
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
@RequestMapping("currentFlow")
@Controller
public class CurrentFlowController {
	
	@Autowired
	private CurrentFlowService currentFlowService;
	
	@RequestMapping("/getCurrentFlowListStatus1ByUser")
	@ResponseBody
	public List<CurrentFlowVo> getCurrentFlowListByUser(String userId){
		return currentFlowService.getCurrentFlowListByUser(userId, "1");
	}
	
	@RequestMapping("/getCurrentFlowListStatus0ByUser")
	@ResponseBody
	public List<CurrentFlowVo> getCurrentFlowListStatus0ByUser(String userId){
		return currentFlowService.getCurrentFlowListByUser(userId, "0");
	}

}

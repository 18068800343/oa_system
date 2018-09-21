package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<FlowHistoryVo> getFlowHistoryByUser(String userId){
		return flowHistoryService.getFlowHistoryByUser(userId,"");
	}
	
	@RequestMapping("/getFlowHistoryByUserAlreadyEnd")
	@ResponseBody
	public List<FlowHistoryVo> getFlowHistoryByUserAlreadyEnd(String userId){
		return flowHistoryService.getFlowHistoryByUser(userId,"");
	}

}

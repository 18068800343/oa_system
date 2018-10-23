package org.ldxx.controller;

import org.ldxx.bean.ModeStatus;
import org.ldxx.service.ModeStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("modestatus")
@Controller
public class ModeStatusController {

	@Autowired
	private ModeStatusService service;
	
	@RequestMapping("/addModeStatus")
	@ResponseBody
	public int addModeStatus(ModeStatus ms){
		return service.addModeStatus(ms);
	}
}

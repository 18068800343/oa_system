package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.ProjectAccounting;
import org.ldxx.service.ProjectAccountingService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 项目核算管理
 * @author hp
 *
 */

@RequestMapping("projectaccounting")
@Controller
public class ProjectAccountingController {
	
	@Autowired
	private ProjectAccountingService service;
	
	@RequestMapping("/selectProjectAccounting")
	@ResponseBody
	public List<ProjectAccounting> selectProjectAccounting(String status){
		return service.selectProjectAccounting(status);
	}
	
	@RequestMapping("/getProjectAccountingById")
	@ResponseBody
	public ProjectAccounting getProjectAccountingById(String id){
		return service.getProjectAccountingById(id);
	}
	
	
	@RequestMapping("/addProjectAccounting")
	@ResponseBody
	public Map<String,Object> addProjectAccounting(@RequestBody ProjectAccounting projectAccounting){
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		projectAccounting.setPaId(id);
		int i=service.addProjectAccounting(projectAccounting);
		map.put("result", i);
		map.put("ProjectAccounting", projectAccounting);
		return map;
	}
	
	@RequestMapping("/addProjectAccountingSubmit")
	@ResponseBody
	public Map<String,Object> addProjectAccountingSubmit(@RequestBody ProjectAccounting projectAccounting){
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		projectAccounting.setPaId(id);
		int i=service.addProjectAccounting(projectAccounting);
		map.put("result", i);
		map.put("ProjectAccounting", projectAccounting);
		return map;
	}

}

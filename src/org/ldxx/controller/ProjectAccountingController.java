package org.ldxx.controller;

import java.util.List;

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
	public int addProjectAccounting(@RequestBody ProjectAccounting projectAccounting){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		projectAccounting.setPaId(id);
		int i=service.addProjectAccounting(projectAccounting);
		return i;
	}
	
	@RequestMapping("/addProjectAccountingSubmit")
	@ResponseBody
	public int addProjectAccountingSubmit(@RequestBody ProjectAccounting projectAccounting){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		projectAccounting.setPaId(id);
		int i=service.addProjectAccounting(projectAccounting);
		return i;
	}

}

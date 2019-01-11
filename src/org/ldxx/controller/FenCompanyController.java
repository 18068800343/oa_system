package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.FenCompany;
import org.ldxx.bean.JobLv;
import org.ldxx.service.FenCompanyService;
import org.ldxx.service.JobLvService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("FenCompany")
public class FenCompanyController {

	@Autowired
	private FenCompanyService fenCompanyService;
	
	@RequestMapping("/selectFenCompany")
	@ResponseBody
	public List<FenCompany> selectJobLv(){
		List<FenCompany> job=fenCompanyService.selectFenCompany();
		return job;
	}
	
	@RequestMapping("/addFenCompany")
	@ResponseBody
	public Map<String,Object> addFenCompany(FenCompany job){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		job.setJobLvId(id);
		Map<String,Object> map=new HashMap<>();
		int i=fenCompanyService.addFenCompany(job);
		map.put("result", i);
		map.put("job", job);
		return map;
	}
	
	@RequestMapping("/deleteFenCompany")
	@ResponseBody
	public int deleteJobLv(String id){
		return fenCompanyService.deleteFenCompany(id);
	}
	
	@RequestMapping("/updateFenCompany")
	@ResponseBody
	public Map<String,Object> updateJobLv(FenCompany job){
		Map<String,Object> map=new HashMap<>();
		int i=fenCompanyService.updateFenCompany(job);
		map.put("result", i);
		map.put("job", job);
		return map;
	}
}

package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.JobLv;
import org.ldxx.service.JobLvService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("job")
public class JobLvController {

	@Autowired
	private JobLvService jlservice;
	
	@RequestMapping("/selectJobLv")
	@ResponseBody
	public List<JobLv> selectJobLv(){
		List<JobLv> job=jlservice.selectJobLv();
		return job;
	}
	
	@RequestMapping("/addJobLv")
	@ResponseBody
	public Map<String,Object> addJobLv(JobLv job){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		job.setJobLvId(id);
		Map<String,Object> map=new HashMap<>();
		int i=jlservice.addJobLv(job);
		map.put("result", i);
		map.put("job", job);
		return map;
	}
	
	@RequestMapping("/deleteJobLv")
	@ResponseBody
	public int deleteJobLv(String id){
		return jlservice.deleteJobLv(id);
	}
	
	@RequestMapping("/updateJobLv")
	@ResponseBody
	public Map<String,Object> updateJobLv(JobLv job){
		Map<String,Object> map=new HashMap<>();
		int i=jlservice.updateJobLv(job);
		map.put("result", i);
		map.put("job", job);
		return map;
	}
	
	@RequestMapping("/selectAllJobLv")
	@ResponseBody
	public List<JobLv> selectAllJobLv(){
		List<JobLv> list=jlservice.selectAllJobLv();
		return list;
	}
	
}

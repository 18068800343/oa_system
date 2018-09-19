package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.Job;
import org.ldxx.service.JobService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("jobc")
public class JobController {

	@Autowired
	private JobService jservice;
	
	@RequestMapping("/selectJobByType")
	@ResponseBody
	public List<Job> selectJobByType(String type){
		 List<Job> list=jservice.selectJobByType(type);
		 return list;
	}
	
	@RequestMapping("/addJob")
	@ResponseBody
	public Map<String,Object> addJob(Job job){
		Map<String,Object> map=new HashMap<>();
		int i=jservice.countOfJobSecond(job.getJobSecond(), job.getJobType());
		if(i==0){
			TimeUUID uuid=new TimeUUID();
			String id=uuid.getTimeUUID();
			job.setJobId(id);
			i=jservice.addJob(job);
		}else{
			i=2;
		}
		map.put("result", i);
		map.put("job", job);
		return map;
	}
	
	
	@RequestMapping("/deleteJob")
	@ResponseBody
	public int deleteJob(String id){
		return jservice.deleteJob(id);
	}
	
	@RequestMapping("/updateJob")
	@ResponseBody
	public Map<String,Object> updateJob(Job job){
		Map<String,Object> map=new HashMap<>();
		int i=jservice.countOfJobSecondToEdit(job.getJobSecond(), job.getJobType(), job.getJobId());
		if(i<1){
			i=jservice.updateJob(job);
		}else{
			i=2;
		}
		map.put("result", i);
		map.put("job", job);
		return map;
	}
	
}

package org.ldxx.controller;

import java.util.List;

import org.ldxx.bean.ClOut;
import org.ldxx.service.ClOutService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("clout")
public class ClOutController {

	@Autowired
	private ClOutService service;
	
	@RequestMapping("/addClOutBySave")
	@ResponseBody
	public int addClOutBySave(@RequestBody List<ClOut> out){
		TimeUUID uuid=new TimeUUID();
		for(int a=0;a<out.size();a++){
			out.get(a).setOutId(uuid.getTimeUUID());
		}
		int i=service.addClOut(out);
		return i;
	}
	
	
	@RequestMapping("/selectClOut")
	@ResponseBody
	public List<ClOut> selectClOut(String no){
		no="%"+no+"%";
		List<ClOut> list=service.selectClOutByNo(no);
		return list;
	}
	
	@RequestMapping("/selectClByNoAndTimeAndPerson")
	@ResponseBody
	public List<ClOut> selectClByNoAndTimeAndPerson(String no,String time,String person){
		List<ClOut> list=service.selectClByNoAndTimeAndPerson(no, time, person);
		return list;
	}
}

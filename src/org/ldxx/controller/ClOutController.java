package org.ldxx.controller;

import java.util.List;

import org.ldxx.bean.ClOut;
import org.ldxx.service.ClOutService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("clout")
public class ClOutController {

	@Autowired
	private ClOutService service;
	
	@RequestMapping("/addClOutBySave")
	@ResponseBody
	public int addClOutBySave(ClOut out){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		out.setOutId(id);
		int i=service.addClOut(out);
		return i;
	}
	
	
	@RequestMapping("/selectClOut")
	@ResponseBody
	public List<ClOut> selectClOut(){
		return service.selectClOut();
	}
}

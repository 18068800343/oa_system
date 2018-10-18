package org.ldxx.controller;

import java.util.List;

import org.ldxx.bean.ClRemain;
import org.ldxx.service.ClRemainService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("ClRemain")
public class ClRemainController {

	@Autowired
	private ClRemainService service;
	
	@RequestMapping("/addClRemain")
	@ResponseBody
	public int addClRemain(@RequestBody List<ClRemain> cr){
		TimeUUID uuid=new TimeUUID();
		for(int a=0;a<cr.size();a++){
			String id=uuid.getTimeUUID();
			cr.get(a).setCrId(id);
		}
		int i=service.addClRemain(cr);
		return i;
	}
	
}

package org.ldxx.controller;

import java.util.List;

import org.ldxx.bean.ClOut;
import org.ldxx.bean.ClOutInfo;
import org.ldxx.bean.outRemain;
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
	public int addClOutBySave(@RequestBody ClOut out){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		out.setOutId(id);
		List<ClOutInfo> cInfo=out.getcInfo();
		for(int a=0;a<cInfo.size();a++){
			cInfo.get(a).setOutId(id);
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
	
	@RequestMapping("/selectClOutInfoById")
	@ResponseBody
	public List<ClOutInfo> selectClOutInfoById(String id){
		List<ClOutInfo> list=service.selectClOutInfoById(id);
		return list;
	}
}

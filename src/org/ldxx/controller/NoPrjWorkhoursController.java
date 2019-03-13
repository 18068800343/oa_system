package org.ldxx.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.NoPrjWorkhours;
import org.ldxx.service.NoPrjWorkhoursService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 非项目工时管理
 * @author hp
 *
 */

@RequestMapping("NoPrjWorkhours")
@Controller
public class NoPrjWorkhoursController {
	
	@Autowired
	private NoPrjWorkhoursService service;
	
	@RequestMapping("/selectNoPrjWorkhours")
	@ResponseBody
	public List<NoPrjWorkhours> selectNoPrjWorkhours(){
		return service.selectNoPrjWorkhours();
	}
	
	@RequestMapping("/addNoPrjWorkhours")
	@ResponseBody
	public Map<String,Object> addNoPrjWorkhours(@RequestBody NoPrjWorkhours no){
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id = uuid.getTimeUUID();
		no.setNpId(id);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time=df.format(new Date());// new Date()为获取当前系统时间
        no.setMakeTime(time);
		int i=service.addNoPrjWorkhours(no);
		map.put("result", i);
		map.put("NoPrjWorkhours", no);
		return map;
	}
	
	@RequestMapping("/deleteNoPrjWorkhours")
	@ResponseBody
	public int deleteNoPrjWorkhours(String id){
		int i=service.deleteNoPrjWorkhours(id);
		return i;
	}
	
	@RequestMapping("/updateNoPrjWorkhours")
	@ResponseBody
	public Map<String,Object> updateNoPrjWorkhours(@RequestBody NoPrjWorkhours no){
		Map<String,Object> map=new HashMap<>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time=df.format(new Date());// new Date()为获取当前系统时间
        no.setMakeTime(time);
		int i=service.updateNoPrjWorkhours(no);
		map.put("result", i);
		map.put("NoPrjWorkhours", no);
		return map;
	}

}

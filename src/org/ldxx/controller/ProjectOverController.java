package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.ProjectOver;
import org.ldxx.service.ProjectOverService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 中标项目移交
 * @author hp
 *
 */
@RequestMapping("prjOver")
@Controller
public class ProjectOverController {
	
	@Autowired
	private ProjectOverService prjOverService;
	
	@RequestMapping("/selectPrjOver")
	@ResponseBody
	public List<ProjectOver> selectPrjOver(){
		return prjOverService.selectPrjOver();
	}
	
	@RequestMapping("/addPrjOver")//添加保存
	@ResponseBody
	public Map<String,Object> addPrjOver(ProjectOver projectOver){
		Map<String,Object> map = new HashMap<>();
		String id=new TimeUUID().getTimeUUID();
		projectOver.setPoId(id);
		int i =prjOverService.addPrjOver(projectOver);
		if(i>0){
			map.put("result", i);
			map.put("projectOver", projectOver);
		}else{
			i=2;
		}
		return map;
	}
	
	@RequestMapping("/SubmitPrjOver")//添加提交
	@ResponseBody
	public Map<String,Object> SubmitPrjOver(ProjectOver projectOver){
		Map<String,Object> map = new HashMap<>();
		String id=new TimeUUID().getTimeUUID();
		projectOver.setPoId(id);
		int i =prjOverService.addPrjOver(projectOver);
		if(i>0){
			map.put("result", i);
			map.put("projectOver", projectOver);
		}else{
			i=2;
		}
		return map;
	}
	
	@RequestMapping("/deletePrjOver")
	@ResponseBody
	public int deletePrjOver(String poId){
		int i =prjOverService.deletePrjOver(poId);
		return i;
	}
	
	@RequestMapping("/updatePrjOverById")/*修改保存*/
	@ResponseBody
	public Map<String,Object> updatePrjOverById(ProjectOver projectOver){
		Map<String,Object> map = new HashMap<>();
		int i =prjOverService.updatePrjOverById(projectOver);
		if(i>0){
			map.put("result", i);
			map.put("projectOver", projectOver);
		}else{
			i=2;
		}
		return map;
	}
	
	@RequestMapping("/updatePrjOverByIdSubmit")/*修改提交*/
	@ResponseBody
	public Map<String,Object> updatePrjOverByIdSubmit(ProjectOver projectOver){
		Map<String,Object> map = new HashMap<>();
		int i =prjOverService.updatePrjOverById(projectOver);
		if(i>0){
			map.put("result", i);
			map.put("projectOver", projectOver);
		}else{
			i=2;
		}
		return map;
	}
	
	@RequestMapping("/selectPrjOverById")
	@ResponseBody
	public ProjectOver selectPrjOverById(String poId){
		return prjOverService.selectPrjOverById(poId);
	}
}

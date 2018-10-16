package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.Parameter;
import org.ldxx.service.ParameterService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系数管理
 * @author hp
 *
 */
@RequestMapping("parameter")
@Controller
public class ParameterController {
	
	@Autowired
	private ParameterService service; 

	@RequestMapping("selectParameter")
	@ResponseBody
	public List<Parameter> selectParameter(){
		return service.selectParameter();
	}
	
	@RequestMapping("addParameter")
	@ResponseBody
	public Map<String,Object> addParameter(Parameter p){
		Map<String,Object> map=new HashMap<>();
		String id=new TimeUUID().getTimeUUID();
		p.setpId(id);
		int i=service.addParameter(p);
		map.put("result", i);
		map.put("Parameter", p);
		return map;
	}
	
	@RequestMapping("updateParameter")
	@ResponseBody
	public Map<String,Object> updateParameter(Parameter p){
		Map<String,Object> map=new HashMap<>();
		int i=service.updateParameter(p);
		map.put("result", i);
		map.put("Parameter", p);
		return map;
	}
	
	@RequestMapping("deleteParameter")
	@ResponseBody
	public int deleteParameter(String id){
		return service.deleteParameter(id);
	}
}

package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.PrjConstructionLog;
import org.ldxx.service.PrjConstructionLogService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 项目施工日志
 * @author hp
 *
 */

@RequestMapping("PrjConstructionLog")
@Controller
public class PrjConstructionLogController {
	
	@Autowired
	private PrjConstructionLogService service;
	
	@RequestMapping("/selectPrjConstructionLog")
	@ResponseBody
	public List<PrjConstructionLog> selectPrjConstructionLog(){
		return service.selectPrjConstructionLog();
	}
	
	
	@RequestMapping("/addPrjConstructionLogSave")
	@ResponseBody
	public Map<String,Object> addPrjConstructionLogSave(PrjConstructionLog prjLog){
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		prjLog.setPclId(id);
		int i=service.addPrjConstructionLogSave(prjLog);
		map.put("result", i);
		map.put("PrjConstructionLog", prjLog);
		return map;
	}
	
	
	@RequestMapping("/deletePrjConstructionLog")
	@ResponseBody
	public int deletePrjConstructionLog(String id){
		return service.deletePrjConstructionLog(id);
	}
	
	@RequestMapping("/updatePrjConstructionLogSave")
	@ResponseBody
	public Map<String,Object> updatePrjConstructionLogSave(PrjConstructionLog prjLog){
		Map<String,Object> map=new HashMap<>();
		int i=service.updatePrjConstructionLogSave(prjLog);
		map.put("result", i);
		map.put("PrjConstructionLog", prjLog);
		return map;
	}
	
}

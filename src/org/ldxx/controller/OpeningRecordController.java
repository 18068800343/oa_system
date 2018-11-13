package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.OpeningRecord;
import org.ldxx.service.OpeningRecordService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 开标记录
 * @author hp
 *
 */
@RequestMapping("OpeningRecord")
@Controller
public class OpeningRecordController {
	
	@Autowired
	private OpeningRecordService service;
	
	@RequestMapping("/selectOpeningRecord")
	@ResponseBody
	public List<OpeningRecord> selectOpeningRecord(String status){
		return service.selectOpeningRecord(status);
	}
	
	@RequestMapping("/selectOpeningRecordById")
	@ResponseBody
	public OpeningRecord selectOpeningRecordById(String id){
		return service.selectOpeningRecordById(id);
	}
	
	
	@RequestMapping("/addOpeningRecordSave")
	@ResponseBody
	public Map<String,Object> addOpeningRecordSave(@RequestBody OpeningRecord record){
		Map<String,Object> map = new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		record.setOrId(id);
		int i=service.addOpeningRecordSave(record);
		map.put("result", i);
		map.put("OpeningRecord", record);
		return map;
	}
	@RequestMapping("/addOpeningRecordSubmit")
	@ResponseBody
	public Map<String,Object> addOpeningRecordSubmit(@RequestBody OpeningRecord record){
		Map<String,Object> map = new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		record.setOrId(id);
		int i=service.addOpeningRecordSave(record);
		map.put("result", i);
		map.put("OpeningRecord", record);
		return map;
	}
	
	@RequestMapping("/updateOpeningRecordSave")
	@ResponseBody
	public Map<String,Object> updateOpeningRecordSave(@RequestBody OpeningRecord record){
		Map<String,Object> map = new HashMap<>();
		int i=service.updateOpeningRecordSave(record);
		map.put("result", i);
		map.put("OpeningRecord", record);
		return map;
	}
	
	@RequestMapping("/updateOpeningRecordSubmit")
	@ResponseBody
	public Map<String,Object> updateOpeningRecordSubmit(@RequestBody OpeningRecord record){
		Map<String,Object> map = new HashMap<>();
		int i=service.updateOpeningRecordSave(record);
		map.put("result", i);
		map.put("OpeningRecord", record);
		return map;
	}

}

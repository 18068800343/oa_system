package org.ldxx.controller;

import java.util.List;

import org.ldxx.bean.WasteDispose;
import org.ldxx.bean.WasteDisposeCl;
import org.ldxx.service.WasteDisposeService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("wd")
public class WasteDisposeController {

	@Autowired
	private WasteDisposeService service;
	
	@RequestMapping("/selectWasteDispose")
	@ResponseBody
	public List<WasteDispose> selectWasteDispose(){
		List<WasteDispose> list=service.selectWasteDispose();
		return list;
	}
	
	@RequestMapping("/selectWdById")
	@ResponseBody
	public List<WasteDisposeCl> selectWdById(String id){
		List<WasteDisposeCl> list=service.selectWdById(id);
		return list;
	}
	
	@RequestMapping("/addWasteDispose")
	@ResponseBody
	public int addWasteDispose(@RequestBody WasteDispose wd){
		int i=service.addWasteDispose(wd);
		return i;
	}
}

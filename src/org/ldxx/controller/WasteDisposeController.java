package org.ldxx.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.CompanyMateriaOut;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.Task;
import org.ldxx.bean.User;
import org.ldxx.bean.WasteDispose;
import org.ldxx.bean.WasteDisposeCl;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.TaskService;
import org.ldxx.service.WasteDisposeService;
import org.ldxx.util.FlowUtill;
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
	@Autowired
	private TaskService tService;
	@Autowired
	private OrganizationManagementService oService;
	
	@RequestMapping("/selectWasteDispose")
	@ResponseBody
	public List<WasteDispose> selectWasteDispose(){
		List<WasteDispose> list=service.selectWasteDispose();
		return list;
	}
	
	@RequestMapping("/selectWasteDisposeById")//通过id查看废旧品详细信息
	@ResponseBody
	public WasteDispose selectWasteDisposeById(String id){
		WasteDispose wd=service.selectWasteDisposeById(id);
		return wd;
	}
	
	@RequestMapping("/selectWdById")
	@ResponseBody
	public List<WasteDisposeCl> selectWdById(String id){
		List<WasteDisposeCl> list=service.selectWdById(id);
		return list;
	}
	
	@RequestMapping("/addWasteDispose")
	@ResponseBody
	public Map<String,Object> addWasteDispose(@RequestBody WasteDispose wd,HttpSession session){
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		wd.setWpId(id);
		int i=service.addWasteDispose(wd);
		map.put("result", i);
		map.put("WasteDispose", wd);
		return map;
	}
	
	@RequestMapping("/addWasteDisposeSubmit")
	@ResponseBody
	public Map<String,Object>  addWasteDisposeSubmit(@RequestBody WasteDispose wd,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		wd.setWpId(id);
		Map<String,Object> map=new HashMap<>();
		int i=service.addWasteDispose(wd);
		map.put("result", i);
		map.put("WasteDispose", wd);
		return map;
	}
}

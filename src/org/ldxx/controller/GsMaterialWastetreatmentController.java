package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.GsMaterialWastetreatment;
import org.ldxx.bean.GsMaterialWastetreatmentCl;
import org.ldxx.service.GsMaterialWastetreatmentService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 废旧品处理
 * @author hp
 *
 */
@RequestMapping(" GsMaterialWaste")
@Controller
public class GsMaterialWastetreatmentController {
	
	@Autowired
	private GsMaterialWastetreatmentService service;
	
	@RequestMapping("/selectGsMaterialWastetreatment")
	@ResponseBody
	public List<GsMaterialWastetreatment> selectGsMaterialWastetreatment(String type){
		return service.selectGsMaterialWastetreatment(type);
	}
	
	
	@RequestMapping("/addGsMaterialWastetreatmentSave")
	@ResponseBody
	public Map<String,Object> addGsMaterialWastetreatmentSave(@RequestBody GsMaterialWastetreatment mw){
		Map<String,Object> map=new HashMap<String,Object>();
		TimeUUID uid=new TimeUUID();
		String id = uid.getTimeUUID();
		mw.setCmwId(id);
		int i=service.addGsMaterialWastetreatmentSave(mw);
		map.put("result", i);
		map.put("GsMaterialWastetreatment", mw);
		return map;
	}
	
	@RequestMapping("/selectGsMaterialWastetreatmentClById")//查找材料信息
	@ResponseBody
	public List<GsMaterialWastetreatmentCl> selectGsMaterialWastetreatmentClById(String id){
		return service.selectGsMaterialWastetreatmentClById(id);
	}
	
}

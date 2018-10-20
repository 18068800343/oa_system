package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.CompanyMaterialReturn;
import org.ldxx.bean.GsMaterialWastetreatment;
import org.ldxx.service.GsMaterialReturnService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 公司材料退货
 * @author hp
 *
 */
@RequestMapping("GsMaterialReturn")
@Controller
public class GsMaterialReturnController {
	
	@Autowired
	private GsMaterialReturnService service;
	
	@RequestMapping("/selectGsMaterialReturn")
	@ResponseBody
	public List<CompanyMaterialReturn> selectGsMaterialReturn(){
		return service.selectGsMaterialReturn();
	}
	
	@RequestMapping("/addGsMaterialReturnSave")
	@ResponseBody
	public Map<String,Object> addGsMaterialReturnSave(CompanyMaterialReturn mr){
		Map<String,Object> map=new HashMap<String,Object>();
		TimeUUID uid=new TimeUUID();
		String id = uid.getTimeUUID();
		mr.setCmrId(id);
		int i=service.addGsMaterialReturnSave(mr);
		map.put("result", i);
		map.put("CompanyMaterialReturn", mr);
		return map;
	}
	
	@RequestMapping("/updateGsMaterialReturnSave")
	@ResponseBody
	public Map<String,Object> updateGsMaterialReturnSave(CompanyMaterialReturn mr){
		Map<String,Object> map=new HashMap<String,Object>();
		int i=service.updateGsMaterialReturnSave(mr);
		map.put("result", i);
		map.put("CompanyMaterialReturn", mr);
		return map;
	}
	
	@RequestMapping("/deleteGsMaterialReturn")
	@ResponseBody
	public int deleteGsMaterialReturn(String id){
		return service.deleteGsMaterialReturn(id);
	}

}

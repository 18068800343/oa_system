package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.MaterialCompany;
import org.ldxx.service.MaterialCompanyService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 材料单位字典
 * @author hp
 *
 */
@RequestMapping("MaterialCompany")
@Controller
public class MaterialCompanyController {
	
	@Autowired
	private MaterialCompanyService service;
	
	@RequestMapping("/getAllMaterialCompany")
	@ResponseBody
	public List<MaterialCompany> getAllMaterialCompany(){
		return service.getAllMaterialCompany();
	}
	
	@RequestMapping("/addMaterialCompany")
	@ResponseBody
	public Map<String,Object> addMaterialCompany(MaterialCompany mc){
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id = uuid.getTimeUUID();
		mc.setMcId(id);
		int i=service.addMaterialCompany(mc);
		map.put("result",i);
		map.put("MaterialCompany",mc);
		return map;
	}
	
	@RequestMapping("/deleteMaterialCompanyById")
	@ResponseBody
	public int deleteMaterialCompanyById(String id){
		return service.deleteMaterialCompanyById(id);
	}
	
	@RequestMapping("/updateMaterialCompany")
	@ResponseBody
	public int updateMaterialCompany(MaterialCompany mc){
		int i=service.updateMaterialCompany(mc);
		return i;
	}

}

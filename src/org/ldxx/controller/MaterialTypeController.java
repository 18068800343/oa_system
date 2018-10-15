package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.MaterialType;
import org.ldxx.service.MaterialTypeService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 材料类型字典
 * @author hp
 *
 */
@Controller
@RequestMapping("MaterialType")
public class MaterialTypeController {
	
	@Autowired
	private MaterialTypeService service;
	
	@RequestMapping("/selectMaterialType")
	@ResponseBody
	public List<MaterialType> selectMaterialType(){
		return service.selectMaterialType();
	}
	
	@RequestMapping("/addMaterialType")
	@ResponseBody
	public Map<String,Object> addMaterialType(MaterialType mt){
		Map<String,Object> map=new HashMap<String, Object>();
		TimeUUID uuid=new TimeUUID();
		String id = uuid.getTimeUUID();
		mt.setmId(id);
		int i=service.materialTypecount(mt.getMaterialType());
		if(i==0){
			i=service.addMaterialType(mt);
		}else{
			i=-1;
		}
		map.put("result", i);
		map.put("MaterialType", mt);
		return map;
	}
	
	@RequestMapping("/deleteMaterialTypeById")
	@ResponseBody
	public int deleteMaterialTypeById(String id){
		return service.deleteMaterialTypeById(id);
	}

	
	@RequestMapping("/updateMaterialTypeById")
	@ResponseBody
	public int updateMaterialTypeById(MaterialType mt){
		return service.updateMaterialTypeById(mt);
	}
}

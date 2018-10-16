package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.CompanyMateriaOut;
import org.ldxx.service.GsMaterialOutService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 公司材料出库
 * @author hp
 *
 */

@RequestMapping("gsMaterialOut")
@Controller
public class GsMaterialOutController {
	
	@Autowired
	private GsMaterialOutService service;
	
	@RequestMapping("/selectGsMaterialOut")
	@ResponseBody
	public List<CompanyMateriaOut> selectGsMaterialOut(){
		return service.selectGsMaterialOut();
	}
	
	
	@RequestMapping("/addGsMaterialOutSave")
	@ResponseBody
	public Map<String,Object> addGsMaterialOutSave(CompanyMateriaOut cm){
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id = uuid.getTimeUUID();
		cm.setCmoId(id);
		int i=service.addGsMaterialOutSave(cm);
		map.put("result", i);
		map.put("CompanyMateriaOut", cm);
		return map;
	}
	
	@RequestMapping("/selectXmMaterialOutByNo")
	@ResponseBody
	public List<CompanyMateriaOut> selectXmMaterialOutByNo(String no){
		List<CompanyMateriaOut> list=service.selectXmMaterialOutByNo(no);
		return list;
	}
	
	@RequestMapping("/selectClByNo")
	@ResponseBody
	public List<CompanyMateriaOut> selectClByNo(String no){
		List<CompanyMateriaOut> list=service.selectClByNo(no);
		return list;
	}
	
	@RequestMapping("/selectClInfoByNoAndClName")
	@ResponseBody
	public CompanyMateriaOut selectClInfoByNoAndClName(String no,String clName){
		CompanyMateriaOut cm=service.selectClInfoByNoAndClName(no, clName);
		return cm;
	}
	
	@RequestMapping("/selectNoByName")
	@ResponseBody
	public Map<String,Object> selectNoByName(String name){
		Map<String,Object> map=new HashMap<>();
		CompanyMateriaOut cm=service.selectNoByName(name);
		List<CompanyMateriaOut> list=service.selectClListByName(name);
		map.put("cm", cm);
		map.put("cmList", list);
		return map;
	}
	
	@RequestMapping("/selectNameByNo")
	@ResponseBody
	public Map<String,Object> selectNameByNo(String no){
		Map<String,Object> map=new HashMap<>();
		CompanyMateriaOut cm=service.selectNameByNo(no);
		List<CompanyMateriaOut> list=service.selectClListByNo(no);
		map.put("cm", cm);
		map.put("cmList", list);
		return map;
	}

}

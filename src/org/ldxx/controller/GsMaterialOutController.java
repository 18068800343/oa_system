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

}

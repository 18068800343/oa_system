package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ClOut;
import org.ldxx.bean.ClOutInfo;
import org.ldxx.bean.CompanyMateriaIn;
import org.ldxx.bean.CompanyMaterialInCl;
import org.ldxx.bean.outRemain;
import org.ldxx.service.ClOutService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

//项目材料出库
@RequestMapping("clout")
@Controller
public class ClOutController {

	@Autowired
	private ClOutService service;
	
	@RequestMapping("/addClOutBySave")
	@ResponseBody
	public int addClOutBySave(String clOut){
		Map<String,Class> map2=new HashMap<>();
		map2.put("cInfo", ClOutInfo.class);
		JSONObject jsonObject=JSONObject.fromObject(clOut);
		ClOut out=(ClOut)JSONObject.toBean(jsonObject, ClOut.class,map2);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		out.setOutId(id);
		int i=service.addClOut(out);
		return i;
	}
	
	
	@RequestMapping("/selectClOut")
	@ResponseBody
	public List<ClOut> selectClOut(String no){
		no="%"+no+"%";
		List<ClOut> list=service.selectClOutByNo(no);
		return list;
	}
	
	@RequestMapping("/selectClOutInfoById")
	@ResponseBody
	public List<ClOutInfo> selectClOutInfoById(String id){
		List<ClOutInfo> list=service.selectClOutInfoById(id);
		return list;
	}
}

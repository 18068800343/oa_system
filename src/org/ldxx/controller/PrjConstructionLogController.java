package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CgCl;
import org.ldxx.bean.CgContract;
import org.ldxx.bean.PrjConstructionLog;
import org.ldxx.bean.PrjConstructionLogInfo;
import org.ldxx.service.PrjConstructionLogService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONObject;

/**
 * 项目施工日志
 * @author hp
 *
 */

@RequestMapping("PrjConstructionLog")
@Controller
public class PrjConstructionLogController {
	
	@Autowired
	private PrjConstructionLogService service;
	
	@RequestMapping("/selectPrjConstructionLog")
	@ResponseBody
	public List<PrjConstructionLog> selectPrjConstructionLog(){
		return service.selectPrjConstructionLog();
	}
	
	
	@RequestMapping("/addPrjConstructionLogSave")
	@ResponseBody
	public Map<String,Object> addPrjConstructionLogSave(String rizhi,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		
		Map<String,Class> map2=new HashMap<>();
		map2.put("accessory", Accessory.class);
		map2.put("prjLogInfo", PrjConstructionLogInfo.class);
		JSONObject jsonObject=JSONObject.fromObject(rizhi);
		PrjConstructionLog prjLog=(PrjConstructionLog)JSONObject.toBean(jsonObject, PrjConstructionLog.class,map2);
		
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		List<Accessory> accList=new ArrayList<>();
		if(file.length>0){
			for(int i=0;i<file.length;i++){
				Accessory acc=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				acc.setaId(id);
				acc.setAcName(fileName);
				acc.setAcUrl(id+File.separator+fileName);
				acc.setaType("项目施工日志");
				accList.add(acc);
			}
		}
		prjLog.setPclId(id);
		prjLog.setAccessory(accList);
		int i=service.addPrjConstructionLogSave(prjLog);
		map.put("result", i);
		map.put("PrjConstructionLog", prjLog);
		return map;
	}
	
	
	@RequestMapping("/deletePrjConstructionLog")
	@ResponseBody
	public int deletePrjConstructionLog(String id){
		return service.deletePrjConstructionLog(id);
	}
	
	@RequestMapping("/updatePrjConstructionLogSave")
	@ResponseBody
	public Map<String,Object> updatePrjConstructionLogSave(String rizhi,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		
		Map<String,Class> map2=new HashMap<>();
		map2.put("accessory", Accessory.class);
		map2.put("prjLogInfo", PrjConstructionLogInfo.class);
		JSONObject jsonObject=JSONObject.fromObject(rizhi);
		PrjConstructionLog prjLog=(PrjConstructionLog)JSONObject.toBean(jsonObject, PrjConstructionLog.class,map2);
		String id=prjLog.getPclId();
		TimeUUID uuid=new TimeUUID();
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		List<Accessory> accList=new ArrayList<>();
		if(file.length>0){
			for(int i=0;i<file.length;i++){
				Accessory acc=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				acc.setaId(id);
				acc.setAcName(fileName);
				acc.setAcUrl(id+File.separator+fileName);
				acc.setaType("项目施工日志");
				accList.add(acc);
			}
		}
		prjLog.setAccessory(accList);
		int i=service.updatePrjConstructionLogSave(prjLog);
		map.put("result", i);
		map.put("PrjConstructionLog", prjLog);
		return map;
	}
	
	@RequestMapping("/selectPrjConstructionLogInfoById")
	@ResponseBody
	public List<PrjConstructionLogInfo> selectPrjConstructionLogInfoById(String id){
		return service.selectPrjConstructionLogInfoById(id);
	}
}

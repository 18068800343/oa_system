package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ContractWork;
import org.ldxx.bean.Enterprise;
import org.ldxx.bean.PrjWorkingHours;
import org.ldxx.bean.PrjWorkingHoursP;
import org.ldxx.service.PrjWorkingHoursService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

/**
 *项目工时管理
 * @author hp
 *
 */

@RequestMapping("PrjWorkingHours")
@Controller
public class PrjWorkingHoursController {
	
	@Autowired
	private PrjWorkingHoursService service;
	
	@RequestMapping("/selectPrjWorkingHours")
	@ResponseBody
	public List<PrjWorkingHours> selectPrjWorkingHours(){
		List<PrjWorkingHours> list= service.selectPrjWorkingHours();
		return list;
	}
	
	
	@RequestMapping("/addPrjWorkingHoursSave")//添加保存
	@ResponseBody
	public Map<String,Object> addPrjWorkingHoursSave(String prjGs,@RequestParam("file") MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		Map<String,Class> map2=new HashMap<>();
		map2.put("prjWorkingHoursP", PrjWorkingHoursP.class);
		JSONObject jsonObject=JSONObject.parseObject(prjGs);
		PrjWorkingHours pwh=(PrjWorkingHours)JSONObject.toJavaObject(jsonObject, PrjWorkingHours.class);
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		pwh.setPwhId(id);
		
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				list.add(accessory);
			}
			pwh.setAccessory(list);
		}
		int i=service.addPrjWorkingHoursSave(pwh);
		map.put("result", i);
		map.put("PrjWorkingHours", pwh);
		return map;
	}
	
	
	@RequestMapping("/updatePrjWorkingHoursSave")//修改保存
	@ResponseBody
	public Map<String,Object> updatePrjWorkingHoursSave(String prjGs,@RequestParam("file") MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		Map<String,Class> map2=new HashMap<>();
		map2.put("prjWorkingHoursP", PrjWorkingHoursP.class);
		JSONObject jsonObject=JSONObject.parseObject(prjGs);
		PrjWorkingHours pwh=(PrjWorkingHours)JSONObject.toJavaObject(jsonObject, PrjWorkingHours.class);
		
		String id=pwh.getPwhId();
		TimeUUID uuid=new TimeUUID();
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				list.add(accessory);
			}
			pwh.setAccessory(list);
		}
		int i=service.updatePrjWorkingHoursSave(pwh);
		map.put("result", i);
		map.put("PrjWorkingHours", pwh);
		return map;
	}	
	
	@RequestMapping("/deletePrjWorkingHours")
	@ResponseBody
	public int deletePrjWorkingHours(String id){
		return service.deletePrjWorkingHours(id);
	}
	
	@RequestMapping("/selectAccessoryById")
	@ResponseBody
	public List<Accessory> selectAccessoryById(String id){
		List<Accessory> list=service.selectAccessoryById(id);
		return list;
	}
	
	@RequestMapping("/deleteAccessory")
	@ResponseBody
	public int deleteAccessory(Accessory accessory){
		int i=service.deleteAccessoryByIdAndName(accessory);
		if(i>0){
			File f=new File(accessory.getAcUrl());
			f.delete();
		}
		return i;
	}
	
	
	@RequestMapping("/selectPrjWorkingHoursByPrjNo")
	@ResponseBody
	public PrjWorkingHours selectPrjWorkingHoursByPrjNo(String prjno){
		return service.selectPrjWorkingHoursByPrjNo(prjno);
	}
	
	//190313当未填写项目信息的时候添加项目信息用的 
	@RequestMapping("/updatePrjWorkingHoursAddInfo")//修改保存
	@ResponseBody
	public Map<String,Object> updatePrjWorkingHoursAddInfo(String prjGsAddInfo) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		Map<String,Class> map2=new HashMap<>();
		map2.put("prjWorkingHoursP", PrjWorkingHoursP.class);
		JSONObject jsonObject=JSONObject.parseObject(prjGsAddInfo);
		PrjWorkingHours pwh=(PrjWorkingHours)JSONObject.toJavaObject(jsonObject, PrjWorkingHours.class);
		
		int i=service.updatePrjWorkingHoursAddInfo(pwh);
		map.put("result", i);
		map.put("PrjWorkingHours", pwh);
		return map;
	}

}

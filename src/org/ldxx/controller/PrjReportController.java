package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.PrjReport;
import org.ldxx.bean.PrjWorkingHours;
import org.ldxx.bean.PrjWorkingHoursP;
import org.ldxx.service.PrjReportService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONObject;

/**
 * 项目周报/月报
 * @author hp
 *
 */

@RequestMapping("PrjReport")
@Controller
public class PrjReportController {
	
	@Autowired
	private PrjReportService service;
	
	@RequestMapping("/selectPrjReport")
	@ResponseBody
	public List<PrjReport> selectPrjReport(String prType){
		return service.selectPrjReport(prType);
	}

	
	@RequestMapping("/addPrjReportSave")
	@ResponseBody
	public Map<String,Object> addPrjReportSave(PrjReport prjReport,@RequestParam("file") MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		prjReport.setPrId(id);
		
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
			prjReport.setAccessory(list);;
		}
		int i=service.addPrjReportSave(prjReport);
		map.put("result", i);
		map.put("PrjReport", prjReport);
		return map;
	}
	
	
	@RequestMapping("/deletePrjReport")
	@ResponseBody
	public int deletePrjReport(String id){
		return service.deletePrjReport(id);
	}
	
	
	@RequestMapping("/updatePrjReportSave")
	@ResponseBody
	public Map<String,Object> updatePrjReportSave(PrjReport prjReport,@RequestParam("file") MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		String id = prjReport.getPrId();
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
			prjReport.setAccessory(list);;
		}
		int i=service.updatePrjReportSave(prjReport);
		map.put("result", i);
		map.put("PrjReport", prjReport);
		return map;
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
}

package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ProjectTrace;
import org.ldxx.service.AnnouncementService;
import org.ldxx.service.ProjectTraceService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 项目跟踪单
 * @author hp
 *
 */
@Controller
@RequestMapping("trace")
public class ProjectTraceController {

	@Autowired
	private ProjectTraceService service;

	@Autowired 
	private AnnouncementService aservice;
	
	@RequestMapping("/addProjectTraceOfSave")
	@ResponseBody
	public Map<String,Object> addProjectTraceOfSave(ProjectTrace trace,MultipartFile file){
		List<Accessory> list=new ArrayList<>();
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		trace.setPtId(id);
		if(file!=null){
			String fileName=file.getOriginalFilename();
			String path="D:/oa/ProjectTrace/"+id;
			File f=new File(path);
			if(!f.exists()){
				f.mkdirs();
			}
			String path2=path+File.separator+fileName;
			File f2=new File(path2);
			
			try {
				file.transferTo(f2);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(path2);
				list.add(accessory);
				trace.setAccessory(list);
			} catch (Exception e) {
				e.printStackTrace();
				map.put("result", 0);
			}
		}
		int i=service.addProjectTrace(trace);
		map.put("result", i);
		map.put("trace", trace);
		return map;
	}
	
	
	@RequestMapping("/addProjectTraceOfSubmit")
	@ResponseBody
	public Map<String,Object> addProjectTraceOfSubmit(ProjectTrace trace,MultipartFile file){
		List<Accessory> list=new ArrayList<>();
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		trace.setPtId(id);
		if(file!=null){
			String fileName=file.getOriginalFilename();
			String path="D:/oa/ProjectTrace/"+id;
			File f=new File(path);
			if(!f.exists()){
				f.mkdirs();
			}
			String path2=path+File.separator+fileName;
			File f2=new File(path2);
			
			try {
				file.transferTo(f2);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(path2);
				list.add(accessory);
				trace.setAccessory(list);
			} catch (Exception e) {
				e.printStackTrace();
				map.put("result", 0);
			}
		}
		int i=service.addProjectTrace(trace);
		map.put("result", i);
		map.put("trace", trace);
		return map;
	}
	
	
	@RequestMapping("/deleteProjectTrace")
	@ResponseBody
	public int deleteProjectTrace(String id){
		List<Accessory> list=aservice.selectAccessory(id);
		int i=service.deleteProjectTrace(id);
		if(i>0){
			for(int a=0;a<list.size();a++){
				File f=new File(list.get(a).getAcUrl());
				f.delete();
				f.getParentFile().delete();
			}
		}
		return i;
	}
	
	@RequestMapping("/deleteAccessory")
	@ResponseBody
	public int deleteAccessory(Accessory accessory){
		int i=aservice.deleteAccessoryByIdAndName(accessory);
		if(i>0){
			File f=new File(accessory.getAcUrl());
			f.delete();
		}
		return i;
	}
	
	
	@RequestMapping("/updateProjectTraceOfSave")
	@ResponseBody
	public Map<String,Object> updateProjectTraceOfSave(ProjectTrace trace,MultipartFile file){
		List<Accessory> list=new ArrayList<>();
		Map<String,Object> map=new HashMap<>();
		if(file!=null){
			String fileName=file.getOriginalFilename();
			String id=trace.getPtId();
			String path="D:/oa/ProjectTrace/"+id;
			File f=new File(path);
			if(!f.exists()){
				f.mkdirs();
			}
			String path2=path+File.separator+fileName;
			File f2=new File(path2);
			try {
				file.transferTo(f2);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(path2);
				list.add(accessory);
				trace.setAccessory(list);
			} catch (Exception e) {
				e.printStackTrace();
				map.put("result", 0);
			}
		}
		int i=service.updateProjectTrace(trace);
		map.put("result", i);
		map.put("trace", trace);
		return map;
	}
	
	
	@RequestMapping("/updateProjectTraceOfSubmit")
	@ResponseBody
	public Map<String,Object> updateProjectTraceOfSubmit(ProjectTrace trace,MultipartFile file){
		List<Accessory> list=new ArrayList<>();
		Map<String,Object> map=new HashMap<>();
		if(file!=null){
			String fileName=file.getOriginalFilename();
			String id=trace.getPtId();
			String path="D:/oa/ProjectTrace/"+id;
			File f=new File(path);
			if(!f.exists()){
				f.mkdirs();
			}
			String path2=path+File.separator+fileName;
			File f2=new File(path2);
			try {
				file.transferTo(f2);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(path2);
				list.add(accessory);
				trace.setAccessory(list);
			} catch (Exception e) {
				e.printStackTrace();
				map.put("result", 0);
			}
		}
		int i=service.updateProjectTrace(trace);
		map.put("result", i);
		map.put("trace", trace);
		return map;
	}
	
	
	@RequestMapping("/selectProjectTrace")
	@ResponseBody
	public List<ProjectTrace> selectProjectTrace(String status){
		return service.selectProjectTrace(status);
	}
	
	@RequestMapping("/selectProjectTraceById")
	@ResponseBody
	public ProjectTrace selectProjectTraceById(String id,String status){
		return service.selectProjectTraceById(id,status);
	}
	
}

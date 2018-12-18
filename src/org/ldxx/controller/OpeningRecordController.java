package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ManagingDocuments;
import org.ldxx.bean.ManagingDocumentsTenderer;
import org.ldxx.bean.OpeningInformation;
import org.ldxx.bean.OpeningRecord;
import org.ldxx.service.OpeningRecordService;
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
 * 开标记录
 * @author hp
 *
 */
@RequestMapping("OpeningRecord")
@Controller
public class OpeningRecordController {
	
	@Autowired
	private OpeningRecordService service;
	
	@RequestMapping("/selectOpeningRecord")
	@ResponseBody
	public List<OpeningRecord> selectOpeningRecord(){
		return service.selectOpeningRecord();
	}
	
	@RequestMapping("/selectOpeningRecordById")
	@ResponseBody
	public OpeningRecord selectOpeningRecordById(String id){
		return service.selectOpeningRecordById(id);
	}
	
	
	@RequestMapping("/addOpeningRecordSave")
	@ResponseBody
	public Map<String,Object> addOpeningRecordSave(String record,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String,Object> map = new HashMap<>();
		Map<String,Class> map2=new HashMap<>();
		map2.put("openingInformation", OpeningInformation.class);
		JSONObject jsonObject=JSONObject.fromObject(record);
		OpeningRecord rd=(OpeningRecord)JSONObject.toBean(jsonObject, OpeningRecord.class,map2);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		rd.setOrId(id);
		String path="D:"+File.separator+"oa"+File.separator+"OpeningRecord"+File.separator+id;;
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
				File f1=new File(filePath);
				file[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("开标记录公示截图");
				list.add(accessory);
			}
			rd.setAccessory(list);
		}
		int i=service.addOpeningRecordSave(rd);
		map.put("result", i);
		map.put("OpeningRecord", rd);
		return map;
	}
	@RequestMapping("/addOpeningRecordSubmit")
	@ResponseBody
	public Map<String,Object> addOpeningRecordSubmit(String record,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String,Object> map = new HashMap<>();
		Map<String,Class> map2=new HashMap<>();
		map2.put("openingInformation", OpeningInformation.class);
		JSONObject jsonObject=JSONObject.fromObject(record);
		OpeningRecord rd=(OpeningRecord)JSONObject.toBean(jsonObject, OpeningRecord.class,map2);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		rd.setOrId(id);
		String path="D:"+File.separator+"oa"+File.separator+"OpeningRecord"+File.separator+id;;
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
				File f1=new File(filePath);
				file[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("开标记录公示截图");
				list.add(accessory);
			}
			rd.setAccessory(list);
		}
		int i=service.addOpeningRecordSave(rd);
		map.put("result", i);
		map.put("OpeningRecord", rd);
		return map;
	}
	
	@RequestMapping("/updateOpeningRecordSave")
	@ResponseBody
	public Map<String,Object> updateOpeningRecordSave(String record,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String,Object> map = new HashMap<>();
		Map<String,Class> map2=new HashMap<>();
		map2.put("openingInformation", OpeningInformation.class);
		JSONObject jsonObject=JSONObject.fromObject(record);
		OpeningRecord rd=(OpeningRecord)JSONObject.toBean(jsonObject, OpeningRecord.class,map2);
		String id=rd.getOrId();
		String path="D:"+File.separator+"oa"+File.separator+"OpeningRecord"+File.separator+id;;
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
				File f1=new File(filePath);
				file[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("开标记录公示截图");
				list.add(accessory);
			}
			rd.setAccessory(list);
		}
		int i=service.updateOpeningRecordSave(rd);
		map.put("result", i);
		map.put("OpeningRecord", record);
		return map;
	}
	
	@RequestMapping("/updateOpeningRecordSubmit")
	@ResponseBody
	public Map<String,Object> updateOpeningRecordSubmit(String record,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String,Object> map = new HashMap<>();
		Map<String,Class> map2=new HashMap<>();
		map2.put("openingInformation", OpeningInformation.class);
		JSONObject jsonObject=JSONObject.fromObject(record);
		OpeningRecord rd=(OpeningRecord)JSONObject.toBean(jsonObject, OpeningRecord.class,map2);
		String id=rd.getOrId();
		String path="D:"+File.separator+"oa"+File.separator+"OpeningRecord"+File.separator+id;;
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
				File f1=new File(filePath);
				file[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("开标记录公示截图");
				list.add(accessory);
			}
			rd.setAccessory(list);
		}
		int i=service.updateOpeningRecordSave(rd);
		map.put("result", i);
		map.put("OpeningRecord", record);
		return map;
	}

}

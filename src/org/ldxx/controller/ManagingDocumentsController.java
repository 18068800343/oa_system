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
import org.ldxx.service.ManagingDocumentsService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONObject;

/**
 * 经营文档资料
 * @author hp
 *
 */

@RequestMapping("ManagingDocuments")
@Controller
public class ManagingDocumentsController {

	@Autowired
	private ManagingDocumentsService service;
	
	
	@RequestMapping("/selectManagingDocuments")
	@ResponseBody
	public List<ManagingDocuments> selectManagingDocuments(){
		return service.selectManagingDocuments();
	}
	
	@RequestMapping("/addManagingDocumentsSave")//添加保存
	@ResponseBody
	public Map<String,Object> addPaySave(String managingDocuments,@RequestParam MultipartFile [] file1,@RequestParam MultipartFile [] file2,@RequestParam MultipartFile [] file3,
			@RequestParam MultipartFile [] file4,@RequestParam MultipartFile [] file5,@RequestParam MultipartFile [] file6) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		Map<String,Class> map2=new HashMap<>();
		map2.put("managingDocumentsTenderer", ManagingDocumentsTenderer.class);
		JSONObject jsonObject=JSONObject.fromObject(managingDocuments);
		ManagingDocuments md=(ManagingDocuments)JSONObject.toBean(jsonObject, ManagingDocuments.class,map2);
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		md.setMdId(id);
		String path="D:"+File.separator+"oa"+File.separator+"ManagingDocuments";
		List<Accessory> list1=new ArrayList<>();
		List<Accessory> list2=new ArrayList<>();
		List<Accessory> list3=new ArrayList<>();
		List<Accessory> list4=new ArrayList<>();
		List<Accessory> list5=new ArrayList<>();
		List<Accessory> list6=new ArrayList<>();
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file1.length>0){
			for(int i=0;i<file1.length;i++){
				Accessory accessory1=new Accessory();
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file1[i].transferTo(f1);
				accessory1.setaId(id);
				accessory1.setAcName(fileName);
				accessory1.setAcUrl(filePath);
				accessory1.setaType("招标文件");
				list1.add(accessory1);
			}
			md.setAccessory1(list1);
		}
		if(file2.length>0){
			for(int i=0;i<file2.length;i++){
				Accessory accessory2=new Accessory();
				String fileName=file2[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[i].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(filePath);
				accessory2.setaType("技术文件");
				list2.add(accessory2);
			}
			md.setAccessory2(list2);
		}
		if(file3.length>0){
			for(int i=0;i<file3.length;i++){
				Accessory accessory3=new Accessory();
				String fileName=file3[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f3=new File(filePath);
				file3[i].transferTo(f3);
				accessory3.setaId(id);
				accessory3.setAcName(fileName);
				accessory3.setAcUrl(filePath);
				accessory3.setaType("商务文件");
				list3.add(accessory3);
			}
			md.setAccessory3(list3);
		}
		if(file4.length>0){
			for(int i=0;i<file4.length;i++){
				Accessory accessory4=new Accessory();
				String fileName=file4[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f4=new File(filePath);
				file4[i].transferTo(f4);
				accessory4.setaId(id);
				accessory4.setAcName(fileName);
				accessory4.setAcUrl(filePath);
				accessory4.setaType("中标通知书");
				list4.add(accessory4);
			}
			md.setAccessory4(list4);
		}
		if(file5.length>0){
			for(int i=0;i<file5.length;i++){
				Accessory accessory5=new Accessory();
				String fileName=file5[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f5=new File(filePath);
				file5[i].transferTo(f5);
				accessory5.setaId(id);
				accessory5.setAcName(fileName);
				accessory5.setAcUrl(filePath);
				accessory5.setaType("验收证书");
				list5.add(accessory5);
			}
			md.setAccessory5(list5);
		}
		if(file6.length>0){
			for(int i=0;i<file6.length;i++){
				Accessory accessory6=new Accessory();
				String fileName=file6[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f6=new File(filePath);
				file6[i].transferTo(f6);
				accessory6.setaId(id);
				accessory6.setAcName(fileName);
				accessory6.setAcUrl(filePath);
				accessory6.setaType("开标记录");
				list6.add(accessory6);
			}
			md.setAccessory6(list6);
		}
		
		int i=service.addManagingDocumentsSave(md);
		map.put("result", i);
		map.put("ManagingDocuments", md);
		return map; 
	}
	
	
	@RequestMapping("/updateManagingDocumentsSave")//修改保存
	@ResponseBody
	public Map<String,Object> updateManagingDocumentsSave(String managingDocuments,@RequestParam MultipartFile [] file1,@RequestParam MultipartFile [] file2,@RequestParam MultipartFile [] file3,
			@RequestParam MultipartFile [] file4,@RequestParam MultipartFile [] file5,@RequestParam MultipartFile [] file6) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		Map<String,Class> map2=new HashMap<>();
		map2.put("managingDocumentsTenderer", ManagingDocumentsTenderer.class);
		JSONObject jsonObject=JSONObject.fromObject(managingDocuments);
		ManagingDocuments md=(ManagingDocuments)JSONObject.toBean(jsonObject, ManagingDocuments.class,map2);
		
		String id=md.getMdId();
		String path="D:"+File.separator+"oa"+File.separator+"ManagingDocuments";
		List<Accessory> list1=new ArrayList<>();
		List<Accessory> list2=new ArrayList<>();
		List<Accessory> list3=new ArrayList<>();
		List<Accessory> list4=new ArrayList<>();
		List<Accessory> list5=new ArrayList<>();
		List<Accessory> list6=new ArrayList<>();
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file1.length>0){
			for(int i=0;i<file1.length;i++){
				Accessory accessory1=new Accessory();
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file1[i].transferTo(f1);
				accessory1.setaId(id);
				accessory1.setAcName(fileName);
				accessory1.setAcUrl(filePath);
				accessory1.setaType("招标文件");
				list1.add(accessory1);
			}
			md.setAccessory1(list1);
		}
		if(file2.length>0){
			for(int i=0;i<file2.length;i++){
				Accessory accessory2=new Accessory();
				String fileName=file2[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[i].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(filePath);
				accessory2.setaType("技术文件");
				list2.add(accessory2);
			}
			md.setAccessory2(list2);
		}
		if(file3.length>0){
			for(int i=0;i<file3.length;i++){
				Accessory accessory3=new Accessory();
				String fileName=file3[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f3=new File(filePath);
				file3[i].transferTo(f3);
				accessory3.setaId(id);
				accessory3.setAcName(fileName);
				accessory3.setAcUrl(filePath);
				accessory3.setaType("商务文件");
				list3.add(accessory3);
			}
			md.setAccessory3(list3);
		}
		if(file4.length>0){
			for(int i=0;i<file4.length;i++){
				Accessory accessory4=new Accessory();
				String fileName=file4[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f4=new File(filePath);
				file4[i].transferTo(f4);
				accessory4.setaId(id);
				accessory4.setAcName(fileName);
				accessory4.setAcUrl(filePath);
				accessory4.setaType("中标通知书");
				list4.add(accessory4);
			}
			md.setAccessory4(list4);
		}
		if(file5.length>0){
			for(int i=0;i<file5.length;i++){
				Accessory accessory5=new Accessory();
				String fileName=file5[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f5=new File(filePath);
				file5[i].transferTo(f5);
				accessory5.setaId(id);
				accessory5.setAcName(fileName);
				accessory5.setAcUrl(filePath);
				accessory5.setaType("验收证书");
				list5.add(accessory5);
			}
			md.setAccessory5(list5);
		}
		if(file6.length>0){
			for(int i=0;i<file6.length;i++){
				Accessory accessory6=new Accessory();
				String fileName=file6[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f6=new File(filePath);
				file6[i].transferTo(f6);
				accessory6.setaId(id);
				accessory6.setAcName(fileName);
				accessory6.setAcUrl(filePath);
				accessory6.setaType("开标记录");
				list6.add(accessory6);
			}
			md.setAccessory6(list6);
		}
		
		int i=service.updateManagingDocumentsSave(md);
		map.put("result", i);
		map.put("ManagingDocuments", md);
		return map; 
	}
	
	
	
	@RequestMapping("/deleteManagingDocumentsById")
	@ResponseBody
	public int deleteManagingDocumentsById(String id){
		return service.deleteManagingDocumentsById(id);
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

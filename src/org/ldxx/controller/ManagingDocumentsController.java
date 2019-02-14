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
import org.ldxx.service.AccessoryService;
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
	@Autowired
	private AccessoryService aService;
	
	@RequestMapping("/selectManagingDocuments")
	@ResponseBody
	public List<ManagingDocuments> selectManagingDocuments(){
		List<ManagingDocuments> list = service.selectManagingDocuments();
		for(int i=0;i<list.size();i++){
			int length=aService.fileCount(list.get(i).getMdId());
			list.get(i).setFileLength(length);
		}
		return list;
	}
	
	@RequestMapping("/selectById")//通过id查
	@ResponseBody
	public ManagingDocuments selectById(String id){
		return service.selectById(id);
	}
	
	@RequestMapping("/selectManagingDocumentsByNo")//通过任务单号查
	@ResponseBody
	public ManagingDocuments selectManagingDocumentsById(String no){
		return service.selectManagingDocumentsById(no);
	}
	
	@RequestMapping("/addManagingDocumentsSave")//添加保存
	@ResponseBody
	public Map<String,Object> addPaySave(String managingDocuments,@RequestParam MultipartFile [] file1,@RequestParam MultipartFile [] file2,@RequestParam MultipartFile [] file3,
			@RequestParam MultipartFile [] file4,@RequestParam MultipartFile [] file5) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		Map<String,Class> map2=new HashMap<>();
		//map2.put("managingDocumentsTenderer", ManagingDocumentsTenderer.class);
		map2.put("accessory1", Accessory.class);
		map2.put("accessory2", Accessory.class);
		map2.put("accessory3", Accessory.class);
		map2.put("accessory4", Accessory.class);
		map2.put("accessory5", Accessory.class);
		JSONObject jsonObject=JSONObject.fromObject(managingDocuments);
		ManagingDocuments md=(ManagingDocuments)JSONObject.toBean(jsonObject, ManagingDocuments.class,map2);
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		md.setMdId(id);
		//String path="D:"+File.separator+"oa"+File.separator+"ManagingDocuments"+File.separator+id;;
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file1.length>0){
			List<Accessory> list1=new ArrayList<>();
			for(int i=0;i<file1.length;i++){
				Accessory accessory1=new Accessory();
				String fileName1=file1[i].getOriginalFilename();
				String filePath1=path+File.separator+fileName1;
				File f1=new File(filePath1);
				file1[i].transferTo(f1);
				accessory1.setaId(id);
				accessory1.setAcName(fileName1);
				accessory1.setAcUrl(id+File.separator+fileName1);
				accessory1.setaType("JY招标文件");
				list1.add(accessory1);
			}
			md.setAccessory1(list1);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int i=0;i<file2.length;i++){
				Accessory accessory2=new Accessory();
				String fileName1=file2[i].getOriginalFilename();
				String filePath2=path+File.separator+fileName1;
				File f2=new File(filePath2);
				file2[i].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName1);
				accessory2.setAcUrl(id+File.separator+fileName1);
				accessory2.setaType("JY招标图纸");
				list2.add(accessory2);
			}
			md.setAccessory2(list2);
		}
		if(file3.length>0){
			List<Accessory> list3=new ArrayList<>();
			for(int i=0;i<file3.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file3[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file3[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("JY投标文件(技术+商务)");
				list3.add(accessory);
			}
			md.setAccessory3(list3);
		}
		if(file4.length>0){
			List<Accessory> list4=new ArrayList<>();
			for(int i=0;i<file4.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file4[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file4[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("JY中标通知书(原件由经营部存档)");
				list4.add(accessory);
			}
			md.setAccessory4(list4);
		}
		if(file5.length>0){
			List<Accessory> list5=new ArrayList<>();
			for(int i=0;i<file5.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file5[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file5[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("JY开标记录");
				list5.add(accessory);
			}
			md.setAccessory5(list5);
		}
		
		int i=service.addManagingDocumentsSave(md);
		map.put("result", i);
		map.put("ManagingDocuments", md);
		return map; 
	}
	
	
	@RequestMapping("/updateManagingDocumentsSave")//修改保存
	@ResponseBody
	public Map<String,Object> updateManagingDocumentsSave(String managingDocuments,@RequestParam MultipartFile [] file1,@RequestParam MultipartFile [] file2,@RequestParam MultipartFile [] file3,
			@RequestParam MultipartFile [] file4,@RequestParam MultipartFile [] file5) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		Map<String,Class> map2=new HashMap<>();
		map2.put("accessory1", Accessory.class);
		map2.put("accessory2", Accessory.class);
		map2.put("accessory3", Accessory.class);
		map2.put("accessory4", Accessory.class);
		map2.put("accessory5", Accessory.class);
		JSONObject jsonObject=JSONObject.fromObject(managingDocuments);
		ManagingDocuments md=(ManagingDocuments)JSONObject.toBean(jsonObject, ManagingDocuments.class,map2);
		
		String id=md.getMdId();
		//String path="D:"+File.separator+"oa"+File.separator+"ManagingDocuments";
		TimeUUID uuid=new TimeUUID();
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file1.length>0){
			List<Accessory> list1=new ArrayList<>();
			for(int i=0;i<file1.length;i++){
				Accessory accessory1=new Accessory();
				String fileName1=file1[i].getOriginalFilename();
				String filePath1=path+File.separator+fileName1;
				File f1=new File(filePath1);
				file1[i].transferTo(f1);
				accessory1.setaId(id);
				accessory1.setAcName(fileName1);
				accessory1.setAcUrl(id+File.separator+fileName1);
				accessory1.setaType("JY招标文件");
				list1.add(accessory1);
			}
			md.setAccessory1(list1);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int i=0;i<file2.length;i++){
				Accessory accessory2=new Accessory();
				String fileName1=file2[i].getOriginalFilename();
				String filePath2=path+File.separator+fileName1;
				File f2=new File(filePath2);
				file2[i].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName1);
				accessory2.setAcUrl(id+File.separator+fileName1);
				accessory2.setaType("JY招标图纸");
				list2.add(accessory2);
			}
			md.setAccessory2(list2);
		}
		if(file3.length>0){
			List<Accessory> list3=new ArrayList<>();
			for(int i=0;i<file3.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file3[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file3[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("JY投标文件(技术+商务)");
				list3.add(accessory);
			}
			md.setAccessory3(list3);
		}
		if(file4.length>0){
			List<Accessory> list4=new ArrayList<>();
			for(int i=0;i<file4.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file4[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file4[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("JY中标通知书(原件由经营部存档)");
				list4.add(accessory);
			}
			md.setAccessory4(list4);
		}
		if(file5.length>0){
			List<Accessory> list5=new ArrayList<>();
			for(int i=0;i<file5.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file5[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file5[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("JY开标记录");
				list5.add(accessory);
			}
			md.setAccessory5(list5);
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

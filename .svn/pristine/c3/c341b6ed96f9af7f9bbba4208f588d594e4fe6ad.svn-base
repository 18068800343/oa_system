package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.DataArchive;
import org.ldxx.service.AnnouncementService;
import org.ldxx.service.DataArchiveService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("DataArchive")
public class DataArchiveController {

	@Autowired
	private DataArchiveService service;
	
	@Autowired 
	private AnnouncementService aservice;
	
	@RequestMapping("/addDataArchiveBySave")
	@ResponseBody
	public int addDataArchiveBySave(DataArchive archive,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		archive.setDaId(id);
		String path="D:"+File.separator+"oa"+File.separator+"DataArchive"+File.separator+id;
		File f=new File(path);
		List<Accessory> accList=new ArrayList<>();
		List<Accessory> accList2=new ArrayList<>();
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			for(int i=0;i<file.length;i++){
				Accessory acc=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				acc.setaId(id);
				acc.setAcName(fileName);
				acc.setAcUrl(filePath);
				acc.setaType("资料");
				accList.add(acc);
			}
		}
		
		if(file2.length>0){
			for(int j=0;j<file2.length;j++){
				Accessory acc=new Accessory();
				String fileName=file2[j].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[j].transferTo(f2);
				acc.setaId(id);
				acc.setAcName(fileName);
				acc.setAcUrl(filePath);
				acc.setaType("证书");
				accList2.add(acc);
			}
		}
		archive.setAccessory(accList);
		archive.setAccessory2(accList2);
		int aa=service.addDataArchive(archive);
		return aa;
	}
	
	@RequestMapping("/addDataArchiveBySubmit")
	@ResponseBody
	public int addDataArchiveBySubmit(DataArchive archive,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		archive.setDaId(id);
		String path="D:"+File.separator+"oa"+File.separator+"DataArchive"+File.separator+id;
		File f=new File(path);
		List<Accessory> accList=new ArrayList<>();
		List<Accessory> accList2=new ArrayList<>();
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			for(int i=0;i<file.length;i++){
				Accessory acc=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				acc.setaId(id);
				acc.setAcName(fileName);
				acc.setAcUrl(filePath);
				acc.setaType("资料");
				accList.add(acc);
			}
		}
		
		if(file2.length>0){
			for(int j=0;j<file2.length;j++){
				Accessory acc=new Accessory();
				String fileName=file2[j].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[j].transferTo(f2);
				acc.setaId(id);
				acc.setAcName(fileName);
				acc.setAcUrl(filePath);
				acc.setaType("证书");
				accList2.add(acc);
			}
		}
		archive.setAccessory(accList);
		archive.setAccessory2(accList2);
		int aa=service.addDataArchive(archive);
		return aa;
	}
	
	@RequestMapping("/deleteDataArchive")
	@ResponseBody
	public int deleteDataArchive(String id){
		return service.deleteDataArchive(id);
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
	
	@RequestMapping("/updateDataArchiveBySave")
	@ResponseBody
	public int updateDataArchiveBySave(DataArchive archive,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2) throws IllegalStateException, IOException{
		String id=archive.getDaId();
		String path="D:"+File.separator+"oa"+File.separator+"DataArchive"+File.separator+id;
		File f=new File(path);
		List<Accessory> accList=new ArrayList<>();
		List<Accessory> accList2=new ArrayList<>();
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			for(int i=0;i<file.length;i++){
				Accessory acc=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				acc.setaId(id);
				acc.setAcName(fileName);
				acc.setAcUrl(filePath);
				acc.setaType("资料");
				accList.add(acc);
			}
		}
		
		if(file2.length>0){
			for(int j=0;j<file2.length;j++){
				Accessory acc=new Accessory();
				String fileName=file2[j].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[j].transferTo(f2);
				acc.setaId(id);
				acc.setAcName(fileName);
				acc.setAcUrl(filePath);
				acc.setaType("证书");
				accList2.add(acc);
			}
		}
		archive.setAccessory(accList);
		archive.setAccessory2(accList2);
		int aa=service.updateDataArchive(archive);
		return aa;
	}
	
	@RequestMapping("/updateDataArchiveBySubmit")
	@ResponseBody
	public int updateDataArchiveBySubmit(DataArchive archive,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2) throws IllegalStateException, IOException{
		String id=archive.getDaId();
		String path="D:"+File.separator+"oa"+File.separator+"DataArchive"+File.separator+id;
		File f=new File(path);
		List<Accessory> accList=new ArrayList<>();
		List<Accessory> accList2=new ArrayList<>();
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			for(int i=0;i<file.length;i++){
				Accessory acc=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				acc.setaId(id);
				acc.setAcName(fileName);
				acc.setAcUrl(filePath);
				acc.setaType("资料");
				accList.add(acc);
			}
		}
		
		if(file2.length>0){
			for(int j=0;j<file2.length;j++){
				Accessory acc=new Accessory();
				String fileName=file2[j].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[j].transferTo(f2);
				acc.setaId(id);
				acc.setAcName(fileName);
				acc.setAcUrl(filePath);
				acc.setaType("证书");
				accList2.add(acc);
			}
		}
		archive.setAccessory(accList);
		archive.setAccessory2(accList2);
		int aa=service.updateDataArchive(archive);
		return aa;
	}
	
	@RequestMapping("/selectDataArchive")
	@ResponseBody
	public List<DataArchive> selectDataArchive(){
		return service.selectDataArchive();
	}
	
}

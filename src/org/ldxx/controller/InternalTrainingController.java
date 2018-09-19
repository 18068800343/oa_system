package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.InternalTraining;
import org.ldxx.service.AnnouncementService;
import org.ldxx.service.InternalTrainingService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("InternalTraining")
public class InternalTrainingController {

	@Autowired
	private InternalTrainingService iservice;
	
	@Autowired 
	private AnnouncementService aservice;
	
	@RequestMapping("/addInternalTrainingBySave")
	@ResponseBody
	public int addInternalTrainingBySave(InternalTraining training,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		String path="D:"+File.separator+"oa"+File.separator+"InternalTraining"+File.separator+id;
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
				acc.setAcUrl(filePath);
				accList.add(acc);
			}
		}
		training.setItId(id);
		training.setAccessory(accList);
		int i=iservice.addInternalTraining(training);
		return i;
	}
	
	@RequestMapping("/addInternalTrainingBySubmit")
	@ResponseBody
	public int addInternalTrainingBySubmit(InternalTraining training,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		String path="D:"+File.separator+"oa"+File.separator+"InternalTraining"+File.separator+id;
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
				acc.setAcUrl(filePath);
				accList.add(acc);
			}
		}
		training.setItId(id);
		training.setAccessory(accList);
		int i=iservice.addInternalTraining(training);
		return i;
	}
	
	
	@RequestMapping("/deleteInternalTraining")
	@ResponseBody
	public int deleteInternalTraining(String id){
		int i=iservice.deleteInternalTraining(id);
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
	
	@RequestMapping("/updateInternalTrainingBySave")
	@ResponseBody
	public int updateInternalTrainingBySave(InternalTraining training,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		String id=training.getItId();
		String path="D:"+File.separator+"oa"+File.separator+"InternalTraining"+File.separator+id;
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
				acc.setAcUrl(filePath);
				accList.add(acc);
			}
		}
		training.setAccessory(accList);
		int i=iservice.updateInternalTraining(training);
		return i;
	}
	
	@RequestMapping("/updateInternalTrainingBySubmit")
	@ResponseBody
	public int updateInternalTrainingBySubmit(InternalTraining training,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		String id=training.getItId();
		String path="D:"+File.separator+"oa"+File.separator+"InternalTraining"+File.separator+id;
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
				acc.setAcUrl(filePath);
				accList.add(acc);
			}
		}
		training.setAccessory(accList);
		int i=iservice.updateInternalTraining(training);
		return i;
	}
	
	@RequestMapping("/selectInternalTraining")
	@ResponseBody
	public List<InternalTraining> selectInternalTraining(){
		return iservice.selectInternalTraining();
	}
 }

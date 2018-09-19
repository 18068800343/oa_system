package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.OutTrainAll;
import org.ldxx.service.AnnouncementService;
import org.ldxx.service.OutTrainAllService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("OutTrainAll")
public class OutTrainAllController {

	@Autowired
	private OutTrainAllService oservice;
	
	@Autowired 
	private AnnouncementService aservice;
	
	@RequestMapping("/addOutTrainAllBySave")
	@ResponseBody
	public int addOutTrainAllBySave(OutTrainAll trainAll,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		String path="D:"+File.separator+"oa"+File.separator+"OutTrainAll"+File.separator+id;
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
		trainAll.setAccessory(accList);
		trainAll.setOtaId(id);
		return oservice.addOutTrainAll(trainAll);
	}
	
	@RequestMapping("/addOutTrainAllBySubmit")
	@ResponseBody
	public int addOutTrainAllBySubmit(OutTrainAll trainAll,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		String path="D:"+File.separator+"oa"+File.separator+"OutTrainAll"+File.separator+id;
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
		trainAll.setAccessory(accList);
		trainAll.setOtaId(id);
		return oservice.addOutTrainAll(trainAll);
	}
	
	@RequestMapping("/deleteOutTrainAll")
	@ResponseBody
	public int deleteOutTrainAll(String id){
		return oservice.deleteOutTrainAll(id);
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
	
	@RequestMapping("/updateOutTrainAllBySave")
	@ResponseBody
	public int updateOutTrainAllBySave(OutTrainAll trainAll,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		String id=trainAll.getOtaId();
		String path="D:"+File.separator+"oa"+File.separator+"OutTrain"+File.separator+id;
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
		trainAll.setAccessory(accList);
		return oservice.updateOutTrainAll(trainAll);
	}
	
	@RequestMapping("/updateOutTrainAllBySubmit")
	@ResponseBody
	public int updateOutTrainAllBySubmit(OutTrainAll trainAll,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		String id=trainAll.getOtaId();
		String path="D:"+File.separator+"oa"+File.separator+"OutTrain"+File.separator+id;
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
		trainAll.setAccessory(accList);
		return oservice.updateOutTrainAll(trainAll);
	}
	
	@RequestMapping("/selectOutTrainAll")
	@ResponseBody
	public List<OutTrainAll> selectOutTrainAll(){
		return oservice.selectOutTrainAll();
	}
}

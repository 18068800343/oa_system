package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.ldxx.bean.InternalTraining;
import org.ldxx.service.InternalTrainingService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("InternalTraining")
public class InternalTrainingController {

	@Autowired
	private InternalTrainingService iservice;
	
	@RequestMapping("/addInternalTrainingBySave")
	@ResponseBody
	public int addInternalTrainingBySave(InternalTraining training,MultipartFile file) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		training.setItId(id);
		if(file!=null){
			String fileName=file.getOriginalFilename();
			String filePath="D:"+File.separator+"oa"+File.separator+"InternalTraining"+File.separator+id;
			File f=new File(filePath);
			if(!f.exists()){
				f.mkdirs();
			}
			String url=filePath+File.separator+fileName;
			File f2=new File(url);
			file.transferTo(f2);
			training.setItAccessoryName(fileName);
			training.setItAccessoryUrl(url);
		}
		int i=iservice.addInternalTraining(training);
		return i;
	}
	
	@RequestMapping("/addInternalTrainingBySubmit")
	@ResponseBody
	public int addInternalTrainingBySubmit(InternalTraining training,MultipartFile file) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		training.setItId(id);
		if(file!=null){
			String fileName=file.getOriginalFilename();
			String filePath="D:"+File.separator+"oa"+File.separator+"InternalTraining"+File.separator+id;
			File f=new File(filePath);
			if(!f.exists()){
				f.mkdirs();
			}
			String url=filePath+File.separator+fileName;
			File f2=new File(url);
			file.transferTo(f2);
			training.setItAccessoryName(fileName);
			training.setItAccessoryUrl(url);
		}
		int i=iservice.addInternalTraining(training);
		return i;
	}
	
	
	@RequestMapping("/deleteInternalTraining")
	@ResponseBody
	public int deleteInternalTraining(String id){
		int i=iservice.deleteInternalTraining(id);
		if(i>0){
			InternalTraining it=iservice.selectInternalTrainingById(id);
			File f=new File(it.getItAccessoryUrl());
			f.delete();
			f.getParentFile().delete();
		}
		return i;
	}
	
	@RequestMapping("/deleteFile")
	@ResponseBody
	public int deleteFile(String id,String path){
		int i=iservice.deleteFile(id);
		if(i>0){
			File f=new File(path);
			f.delete();
		}
		return i;
	}
	
	
	@RequestMapping("/updateInternalTrainingBySave")
	@ResponseBody
	public int updateInternalTrainingBySave(InternalTraining training,MultipartFile file) throws IllegalStateException, IOException{
		int i=0;
		if(file!=null){
			String fileName=file.getOriginalFilename();
			String filePath="D:"+File.separator+"oa"+File.separator+"InternalTraining"+File.separator+training.getItId();
			File f=new File(filePath);
			if(!f.exists()){
				f.mkdirs();
			}
			String url=filePath+File.separator+fileName;
			File f2=new File(url);
			file.transferTo(f2);
			training.setItAccessoryName(fileName);
			training.setItAccessoryUrl(url);
			i=iservice.updateInternalTrainingHasFile(training);
		}else{
			i=iservice.updateInternalTrainingNoFile(training);
		}
		return i;
	}
	
	@RequestMapping("/updateInternalTrainingBySubmit")
	@ResponseBody
	public int updateInternalTrainingBySubmit(InternalTraining training,MultipartFile file) throws IllegalStateException, IOException{
		int i=0;
		if(file!=null){
			String fileName=file.getOriginalFilename();
			String filePath="D:"+File.separator+"oa"+File.separator+"InternalTraining"+File.separator+training.getItId();
			File f=new File(filePath);
			if(!f.exists()){
				f.mkdirs();
			}
			String url=filePath+File.separator+fileName;
			File f2=new File(url);
			file.transferTo(f2);
			training.setItAccessoryName(fileName);
			training.setItAccessoryUrl(url);
			i=iservice.updateInternalTrainingHasFile(training);
		}else{
			i=iservice.updateInternalTrainingNoFile(training);
		}
		return i;
	}
	
	@RequestMapping("/selectInternalTraining")
	@ResponseBody
	public List<InternalTraining> selectInternalTraining(){
		return iservice.selectInternalTraining();
	}
 }

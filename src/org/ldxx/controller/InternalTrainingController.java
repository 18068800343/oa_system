package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.InternalTraining;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.OutTrainAll;
import org.ldxx.bean.User;
import org.ldxx.service.AnnouncementService;
import org.ldxx.service.InternalTrainingService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.util.FlowUtill;
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
	
	@Autowired
	private OrganizationManagementService oService;
	
	@RequestMapping("/addInternalTrainingBySave")
	@ResponseBody
	public int addInternalTrainingBySave(InternalTraining training,@RequestParam MultipartFile [] file,HttpSession session) throws IllegalStateException, IOException{
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
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(training.getDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(training.getCourseName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());
			currentFlow.setMemo(training.getCourseName()+"保存");
			currentFlow.setUrl("xingzhengshiwuLook/TrainingManagement3Look.html-"+id);
			currentFlow.setParams("{'cs':'1'}");
			currentFlow.setStarter(user.getUserId());
			currentFlow.setStartername(user.getuName());
			currentFlow.setFkDept(omNo);
			currentFlow.setDeptname(user.getOmName());
			currentFlow.setNodename("节点名称");
			currentFlow.setPri(1);
			currentFlow.setSdtofnode(new Date());
			currentFlow.setSdtofflow(new Date());
			currentFlow.setFlowEndState(2);
			currentFlow.setFlowNopassState(0);
			FlowHistroy flowHistroy = new FlowHistroy();
			flowHistroy.setActor(user.getUserId());
			flowHistroy.setActorname(user.getuName());
			flowHistroy.setActorresult(0);
			flowHistroy.setView("");
			try {
				string = flowUtill.zancunFlow(currentFlow,flowHistroy);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return i;
	}
	
	@RequestMapping("/addInternalTrainingBySubmit")
	@ResponseBody
	public String addInternalTrainingBySubmit(InternalTraining training,@RequestParam MultipartFile [] file,HttpSession session) throws IllegalStateException, IOException{
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
		String string="";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(training.getDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(training.getCourseName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());
			currentFlow.setMemo(training.getCourseName()+"流程发起");
			currentFlow.setUrl("xingzhengshiwuLook/TrainingManagement3Look.html-"+id);
			currentFlow.setParams("{'cs':'1'}");
			currentFlow.setStarter(user.getUserId());
			currentFlow.setStartername(user.getuName());
			currentFlow.setFkDept(omNo);
			currentFlow.setDeptname(user.getOmName());
			currentFlow.setNodename("节点名称");
			currentFlow.setPri(1);
			currentFlow.setSdtofnode(new Date());
			currentFlow.setSdtofflow(new Date());
			currentFlow.setFlowEndState(2);
			currentFlow.setFlowNopassState(0);
			FlowHistroy flowHistroy = new FlowHistroy();
			flowHistroy.setActor(user.getUserId());
			flowHistroy.setActorname(user.getuName());
			flowHistroy.setActorresult(0);
			flowHistroy.setView("");
			try {
				string = flowUtill.submitGetReceiver(currentFlow,omNo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return string;
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
	
	@RequestMapping("/selectInternalTrainingById")
	@ResponseBody
	public InternalTraining selectInternalTrainingById(String id){
		return iservice.selectInternalTrainingById(id);
	}
	
	@RequestMapping("/getInternalTrainingName")
	@ResponseBody
	public List<InternalTraining> getInternalTrainingName(){
		return iservice.getInternalTrainingName();
	}
 }

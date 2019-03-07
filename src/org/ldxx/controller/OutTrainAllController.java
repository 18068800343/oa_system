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
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.OutTrain;
import org.ldxx.bean.OutTrainAll;
import org.ldxx.bean.User;
import org.ldxx.mapper.CurrentFlowMapper;
import org.ldxx.service.AnnouncementService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.OutTrainAllService;
import org.ldxx.util.FlowUtill;
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
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	CurrentFlowMapper currentFlowMapper;
	
	@RequestMapping("/addOutTrainAllBySave")
	@ResponseBody
	public int addOutTrainAllBySave(OutTrainAll trainAll,@RequestParam MultipartFile [] file,HttpSession session) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
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
				acc.setAcUrl(id+File.separator+fileName);
				accList.add(acc);
			}
		}
		trainAll.setAccessory(accList);
		trainAll.setOtaId(id);
		int i=oservice.addOutTrainAll(trainAll);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(trainAll.getOmId());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(trainAll.getOtaTitle());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(trainAll.getOtaTitle()+"保存");
			currentFlow.setUrl("xingzhengshiwuLook/TrainingManagement2Look.html-"+id);
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
	
	@RequestMapping("/addOutTrainAllBySubmit")
	@ResponseBody
	public String addOutTrainAllBySubmit(OutTrainAll trainAll,@RequestParam MultipartFile [] file,HttpSession session) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
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
				acc.setAcUrl(id+File.separator+fileName);
				accList.add(acc);
			}
		}
		trainAll.setAccessory(accList);
		trainAll.setOtaId(id);
		int i=oservice.addOutTrainAll(trainAll);
		String string="";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(trainAll.getOmId());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(trainAll.getOtaTitle());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(trainAll.getOtaTitle()+"流程提交");
			currentFlow.setUrl("xingzhengshiwuLook/TrainingManagement2Look.html-"+id);
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
	public int updateOutTrainAllBySave(OutTrainAll trainAll,@RequestParam(required=false,value="file") MultipartFile [] file) throws IllegalStateException, IOException{
		String id=trainAll.getOtaId();
		TimeUUID uuid=new TimeUUID();
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
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
				acc.setAcUrl(id+File.separator+fileName);
				accList.add(acc);
			}
		}
		trainAll.setAccessory(accList);
		int i= oservice.updateOutTrainAll(trainAll);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(trainAll.getOmId());
			String omNo=om.getOmNo();
			currentFlowMapper.updateFkDeptByModeId(trainAll.getOmId(), omNo);
		}
		return i;
	}
	
	@RequestMapping("/updateOutTrainAllBySubmit")
	@ResponseBody
	public int updateOutTrainAllBySubmit(OutTrainAll trainAll,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		String id=trainAll.getOtaId();
		TimeUUID uuid=new TimeUUID();
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
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
				acc.setAcUrl(id+File.separator+fileName);
				accList.add(acc);
			}
		}
		trainAll.setAccessory(accList);
		int i= oservice.updateOutTrainAll(trainAll);
		/*if(i>0){
			OrganizationManagement om=oService.selectOrgById(trainAll.getOmId());
			String omNo=om.getOmNo();
			currentFlowMapper.updateFkDeptByModeId(trainAll.getOmId(), omNo);
		}*/
		return i;
	}
	
	@RequestMapping("/selectOutTrainAll")
	@ResponseBody
	public List<OutTrainAll> selectOutTrainAll(){
		return oservice.selectOutTrainAll();
	}
	
	@RequestMapping("/selectOutTrainAllById")
	@ResponseBody
	public OutTrainAll selectOutTrainAllById(String id){
		return oservice.selectOutTrainAllById(id);
	}
	
	@RequestMapping("/getOutTrainAllName")
	@ResponseBody
	public List<OutTrainAll> getOutTrainAllName(){
		return oservice.getOutTrainAllName();
	}
}

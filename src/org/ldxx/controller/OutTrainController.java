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
import org.ldxx.bean.User;
import org.ldxx.mapper.CurrentFlowMapper;
import org.ldxx.service.AnnouncementService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.OutTrainService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("outTrain")
public class OutTrainController {

	@Autowired
	private OutTrainService oservice;
	@Autowired 
	private AnnouncementService aservice;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	CurrentFlowMapper currentFlowMapper;
	
	@RequestMapping("/addOutTrainBySave")
	@ResponseBody
	public int addOutTrainBySave(OutTrain outTrain,@RequestParam MultipartFile [] file,HttpSession session) throws IllegalStateException, IOException{
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
		outTrain.setOtId(id);
		outTrain.setAccessory(accList);
		int i=oservice.addOutTrain(outTrain);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(outTrain.getProposerDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(outTrain.getOtTitle());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(outTrain.getOtTitle()+"保存");
			currentFlow.setUrl("xingzhengshiwuLook/TrainingManagementLook.html-"+id);
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
	
	@RequestMapping("/addOutTrainBySubmit")
	@ResponseBody
	public String addOutTrainBySubmit(OutTrain outTrain,@RequestParam MultipartFile [] file,HttpSession session) throws IllegalStateException, IOException{
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
		outTrain.setOtId(id);
		outTrain.setAccessory(accList);
		int i=oservice.addOutTrain(outTrain);
		String string="";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(outTrain.getProposerDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(outTrain.getOtTitle());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());
			currentFlow.setMemo(outTrain.getOtTitle()+"流程提交");
			currentFlow.setUrl("xingzhengshiwuLook/TrainingManagementLook.html-"+id);
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
	
	
	@RequestMapping("/deleteOutTrain")
	@ResponseBody
	public int deleteOutTrain(String id){
		return oservice.deleteOutTrain(id);
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
	
	@RequestMapping("/updateOutTrainBySave")
	@ResponseBody
	public int updateOutTrainBySave(OutTrain outTrain,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		String id=outTrain.getOtId();
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
		outTrain.setAccessory(accList);
		int i=oservice.updateOutTrain(outTrain);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(outTrain.getProposerDepartment());
			String omNo=om.getOmNo();
			currentFlowMapper.updateFkDeptByModeId(outTrain.getOtId(), omNo);
		}
		return i;
	}
	
	@RequestMapping("/updateOutTrainBySubmit")
	@ResponseBody
	public int updateOutTrainBySubmit(OutTrain outTrain,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		String id=outTrain.getOtId();
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
		outTrain.setAccessory(accList);
		int i=oservice.updateOutTrain(outTrain);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(outTrain.getProposerDepartment());
			String omNo=om.getOmNo();
			currentFlowMapper.updateFkDeptByModeId(outTrain.getOtId(), omNo);
		}
		return i;
	}
	
	
	@RequestMapping("/selectOutTrain")
	@ResponseBody
	public List<OutTrain> selectOutTrain(){
		return oservice.selectOutTrain();
	}
	
	@RequestMapping("/selectOutTrainById")
	@ResponseBody
	public OutTrain selectOutTrainById(String id){
		return oservice.selectOutTrainById(id);
	}
	
	@RequestMapping("/getOutTrainName")
	@ResponseBody
	public List<OutTrain> getOutTrainName(){
		return oservice.getOutTrainName();
	}
	
}

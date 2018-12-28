package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.DataArchive;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.InternalTraining;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.OutTrain;
import org.ldxx.bean.OutTrainAll;
import org.ldxx.bean.User;
import org.ldxx.service.AnnouncementService;
import org.ldxx.service.DataArchiveService;
import org.ldxx.service.InternalTrainingService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.OutTrainAllService;
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
@RequestMapping("DataArchive")
public class DataArchiveController {

	@Autowired
	private DataArchiveService service;
	@Autowired 
	private AnnouncementService aservice;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private OutTrainService otservice;//外出
	@Autowired
	private OutTrainAllService otallservice;//外部
	@Autowired
	private InternalTrainingService itservice;//内部
	
	@RequestMapping("/addDataArchiveBySave")
	@ResponseBody
	public int addDataArchiveBySave(DataArchive archive,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2,@RequestParam MultipartFile [] file3,HttpSession session) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		archive.setDaId(id);
		String path="D:"+File.separator+"oa"+File.separator+"DataArchive"+File.separator+id;
		File f=new File(path);
		List<Accessory> accList=new ArrayList<>();
		List<Accessory> accList2=new ArrayList<>();
		List<Accessory> accList3=new ArrayList<>();
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
		if(file3.length>0){
			for(int k=0;k<file3.length;k++){
				Accessory acc=new Accessory();
				String fileName=file3[k].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f3=new File(filePath);
				file3[k].transferTo(f3);
				acc.setaId(id);
				acc.setAcName(fileName);
				acc.setAcUrl(filePath);
				acc.setaType("自我总结");
				accList3.add(acc);
			}
		}
		archive.setAccessory(accList);
		archive.setAccessory2(accList2);
		archive.setAccessory3(accList3);
		int aa=service.addDataArchive(archive);
		if(aa>0){
			User user = (User) session.getAttribute("user");
			OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String omNo=om.getOmNo();
			String string="";
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(archive.getDaName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(archive.getDaName()+"保存");
			currentFlow.setUrl("xingzhengshiwuLook/TrainingManagement4Look.html-"+id);
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
		return aa;
	}
	
	@RequestMapping("/addDataArchiveBySubmit")
	@ResponseBody
	public String addDataArchiveBySubmit(DataArchive archive,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2,@RequestParam MultipartFile [] file3,HttpSession session) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		archive.setDaId(id);
		String path="D:"+File.separator+"oa"+File.separator+"DataArchive"+File.separator+id;
		File f=new File(path);
		List<Accessory> accList=new ArrayList<>();
		List<Accessory> accList2=new ArrayList<>();
		List<Accessory> accList3=new ArrayList<>();
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
		if(file3.length>0){
			for(int k=0;k<file3.length;k++){
				Accessory acc=new Accessory();
				String fileName=file3[k].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f3=new File(filePath);
				file3[k].transferTo(f3);
				acc.setaId(id);
				acc.setAcName(fileName);
				acc.setAcUrl(filePath);
				acc.setaType("自我总结");
				accList3.add(acc);
			}
		}
		archive.setAccessory(accList);
		archive.setAccessory2(accList2);
		archive.setAccessory3(accList3);
		int aa=service.addDataArchive(archive);
		String string = aa+"";
		if(aa>0){
			User user = (User) session.getAttribute("user");
			OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String omNo=om.getOmNo();
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(archive.getDaName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(archive.getDaName()+"流程发起");
			currentFlow.setUrl("xingzhengshiwuLook/TrainingManagement4Look.html-"+id);
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
	public int updateDataArchiveBySave(DataArchive archive,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2,@RequestParam MultipartFile [] file3) throws IllegalStateException, IOException{
		String id=archive.getDaId();
		String path="D:"+File.separator+"oa"+File.separator+"DataArchive"+File.separator+id;
		File f=new File(path);
		List<Accessory> accList=new ArrayList<>();
		List<Accessory> accList2=new ArrayList<>();
		List<Accessory> accList3=new ArrayList<>();
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
		if(file3.length>0){
			for(int k=0;k<file3.length;k++){
				Accessory acc=new Accessory();
				String fileName=file3[k].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f3=new File(filePath);
				file3[k].transferTo(f3);
				acc.setaId(id);
				acc.setAcName(fileName);
				acc.setAcUrl(filePath);
				acc.setaType("自我总结");
				accList3.add(acc);
			}
		}
		archive.setAccessory(accList);
		archive.setAccessory2(accList2);
		archive.setAccessory3(accList3);
		int aa=service.updateDataArchive(archive);
		return aa;
	}
	
	@RequestMapping("/updateDataArchiveBySubmit")
	@ResponseBody
	public int updateDataArchiveBySubmit(DataArchive archive,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2,@RequestParam MultipartFile [] file3) throws IllegalStateException, IOException{
		String id=archive.getDaId();
		String path="D:"+File.separator+"oa"+File.separator+"DataArchive"+File.separator+id;
		File f=new File(path);
		List<Accessory> accList=new ArrayList<>();
		List<Accessory> accList2=new ArrayList<>();
		List<Accessory> accList3=new ArrayList<>();
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
		if(file3.length>0){
			for(int k=0;k<file3.length;k++){
				Accessory acc=new Accessory();
				String fileName=file3[k].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f3=new File(filePath);
				file3[k].transferTo(f3);
				acc.setaId(id);
				acc.setAcName(fileName);
				acc.setAcUrl(filePath);
				acc.setaType("自我总结");
				accList3.add(acc);
			}
		}
		archive.setAccessory(accList);
		archive.setAccessory2(accList2);
		archive.setAccessory3(accList3);
		int aa=service.updateDataArchive(archive);
		return aa;
	}
	
	@RequestMapping("/selectDataArchive")
	@ResponseBody
	public List<DataArchive> selectDataArchive(){
		return service.selectDataArchive();
	}
	
	@RequestMapping("/selectDataArchiveById")
	@ResponseBody
	public DataArchive selectDataArchiveById(String id){
		return service.selectDataArchiveById(id);
	}
	
	@RequestMapping("/getallName")//或得外出外部以及内部的所有课程名
	@ResponseBody
	public Map<String,Object> getallName(){
		Map<String,Object> map=new HashMap<>();
		List<DataArchive> list=new ArrayList<>();
		List<OutTrain> outTrainName = otservice.getOutTrainName();
		for (int i = 0; i < outTrainName.size(); i++) {
			DataArchive dataArchive=new DataArchive();
			String name=outTrainName.get(i).getCourseName();
			dataArchive.setDaName(name);
			list.add(dataArchive);
		}
		List<OutTrainAll> outTrainAllName = otallservice.getOutTrainAllName();
		for (int j = 0; j < outTrainAllName.size(); j++) {
			DataArchive dataArchive=new DataArchive();
			String name=outTrainAllName.get(j).getCourseName();
			dataArchive.setDaName(name);
			list.add(dataArchive);
		}
		List<InternalTraining> internalTrainingName = itservice.getInternalTrainingName();
		for (int k = 0; k < internalTrainingName.size(); k++) {
			DataArchive dataArchive=new DataArchive();
			String name=internalTrainingName.get(k).getCourseName();
			dataArchive.setDaName(name);
			list.add(dataArchive);
		}
		map.put("allNamelist", list);
		return map;
	}
	
}

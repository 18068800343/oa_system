package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.ManagingDocuments;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.PrjRecord;
import org.ldxx.bean.Task;
import org.ldxx.bean.User;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.PrjRecordService;
import org.ldxx.service.TaskService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/PrjRecord")
public class PrjRecordController {
	
	@Autowired
	private PrjRecordService pServcie;
	@Autowired
	private AccessoryDao aDao;
	@Autowired
	private TaskService tService;
	@Autowired
	private OrganizationManagementService oService;
	
	@RequestMapping("/addPrjRecord")
	@ResponseBody
	public Map<String,Object> addPrjRecord(PrjRecord pr){
		Map<String,Object> map=new HashMap<String, Object>();
		int i=pServcie.prjCount(pr.getPrjNo());
		if(i==0){
			TimeUUID uuid=new TimeUUID();
			String id=uuid.getTimeUUID();
			pr.setId(id);
			i = pServcie.addPrjRecord(pr);
			map.put("result", i);
		}else{
			map.put("result", 2);
		}
		map.put("pr", pr);
		return map;		
	}
	
	@RequestMapping("/selectPrjRecord")
	@ResponseBody
	public List<PrjRecord> selectPrjRecord(){
		List<PrjRecord> pr=pServcie.selectPrjRecord();
		return pr;		
	}

	
	@RequestMapping("/addScRecord")
	@ResponseBody
	public Map<String,Object> addScRecord(String id,@RequestParam(required=false,value="file1") MultipartFile [] file1,@RequestParam(required=false,value="file2") MultipartFile [] file2,@RequestParam(required=false,value="file3") MultipartFile [] file3,
			@RequestParam(required=false,value="file4") MultipartFile [] file4,@RequestParam(required=false,value="file5") MultipartFile [] file5,@RequestParam(required=false,value="file6") MultipartFile [] file6,HttpSession session,HttpServletResponse response) throws IllegalStateException, IOException{
		response.setCharacterEncoding("UTF-8");
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id2=uuid.getTimeUUID();
		String webApps=uuid.getWebAppFile();
		String path=webApps+id2;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		List<Accessory> list=new ArrayList<>();
		int num=0;
		if(file1.length>0){
			for(int i=0;i<file1.length;i++){
				Accessory accessory1=new Accessory();
				String fileName1=file1[i].getOriginalFilename();
				String filePath1=path+File.separator+fileName1;
				File f1=new File(filePath1);
				file1[i].transferTo(f1);
				accessory1.setaId(id);
				accessory1.setAcName(fileName1);
				accessory1.setAcUrl(id2+File.separator+fileName1);
				accessory1.setaType("JY招标文件");
				list.add(accessory1);
			}
			num+=1;
		}
		if(file2.length>0){
			for(int i=0;i<file2.length;i++){
				Accessory accessory2=new Accessory();
				String fileName1=file2[i].getOriginalFilename();
				String filePath2=path+File.separator+fileName1;
				File f2=new File(filePath2);
				file2[i].transferTo(f2); 
				accessory2.setaId(id);
				accessory2.setAcName(fileName1);
				accessory2.setAcUrl(id2+File.separator+fileName1);
				accessory2.setaType("JY招标图纸");
				list.add(accessory2);
			}
			num+=1;
		}
		if(file3.length>0){
			for(int i=0;i<file3.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file3[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file3[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("JY投标文件(技术+商务)");
				list.add(accessory);
			}
			num+=1;
		}
		if(file4.length>0){
			for(int i=0;i<file4.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file4[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file4[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("JY中标通知书(原件由经营部存档)");
				list.add(accessory);
			}
			num+=1;
		}
		if(file5.length>0){
			for(int i=0;i<file5.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file5[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file5[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("JY开标记录");
				list.add(accessory);
			}
			num+=1;
		}
		if(file6.length>0){
			for(int i=0;i<file6.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file6[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file6[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("JY其他");
				list.add(accessory);
			}
			num+=1;
		}
		int i=0;
		if(list.size()==0||list==null){
			i=-1;
		}else{
			i=aDao.addAccessory(list);
			if(i>0){
				if(num>0){
					pServcie.updateJyStatus(id, 1);
				}
			}
		}
		
		map.put("result", i);
		map.put("num", num);
		return map;
	}
	
	@RequestMapping("/submitPrjRecordJY")
	@ResponseBody
	public String submitPrjRecordJY(String id,String no,HttpSession session){
		String string="";
		User user = (User) session.getAttribute("user");
		Task task=tService.selectTaskPrjName(no);
		OrganizationManagement om=oService.selectOrgById(task.getMainDepartment());
		String omNo=om.getOmNo();
		FlowUtill flowUtill = new FlowUtill();
		CurrentFlow currentFlow = new CurrentFlow();
		currentFlow.setParams("1");
		currentFlow.setTitle(task.getPrjName()+"-项目经营资料归档");
		currentFlow.setActor(user.getUserId());
		currentFlow.setActorname(user.getuName());;
		currentFlow.setMemo(task.getPrjName()+"-项目经营资料归档");
		currentFlow.setUrl("danganGUanliLook/OperatingDocumentLook.html-"+id);
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
		return string;
	}
	
	@RequestMapping("/submitPrjRecordSc")
	@ResponseBody
	public String submitPrjRecordSc(String id,String no,String type,HttpSession session){
		String string="";
		User user = (User) session.getAttribute("user");
		Task task=tService.selectTaskPrjName(no);
		OrganizationManagement om=oService.selectOrgById(task.getMainDepartment());
		String omNo=om.getOmNo();
		FlowUtill flowUtill = new FlowUtill();
		CurrentFlow currentFlow = new CurrentFlow();
		currentFlow.setParams("1");
		currentFlow.setTitle(task.getPrjName()+"-项目生产资料归档");
		currentFlow.setActor(user.getUserId());
		currentFlow.setActorname(user.getuName());
		currentFlow.setMemo(task.getPrjName()+"-项目生产资料归档");
		if(type.startsWith("C")){
			currentFlow.setUrl("danganGUanliLook/ConstructionDocumentLook.html-"+id);
		}else if(type.startsWith("A")){
			currentFlow.setUrl("danganGUanliLook/DetectionEvaluationLook.html-"+id);
		}else if(type.startsWith("B")){
			currentFlow.setUrl("danganGUanliLook/designDocumentLook.html-"+id);
		}else if(type.startsWith("K")){
			currentFlow.setUrl("danganGUanliLook/ScienceTechnologyLook.html-"+id);
		}
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
		return string;
	}
	
	@RequestMapping("/updateJYStatus")
	@ResponseBody
	public int updateJYStatus(String id){
		int i=pServcie.updateJyStatus(id, 2);
		return i;
	}
	
	@RequestMapping("/updateSCStatus")
	@ResponseBody
	public int updateSCStatus(String id){
		int i=pServcie.updateScStatus(id, 2);
		return i;
	}
	
	
	@RequestMapping("/delPrj")
	@ResponseBody
	public int delPrj(String id){
		int i=pServcie.delPrj(id);
		return i;
	}
	
}

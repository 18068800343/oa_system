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
import org.ldxx.bean.OtherContract;
import org.ldxx.bean.User;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.OtherContractService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("other")
public class OtherContractConroller {

	@Autowired
	private OtherContractService service;
	@Autowired
	private OrganizationManagementService oService;
	
	@RequestMapping("/addOtherContractBySave")
	@ResponseBody
	public int addOtherContractBySave(OtherContract other,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2,HttpSession session) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		other.setoId(id);
		int count=service.countNo();
		String type="";
		String code="QT"+uuid.getPrjCode(type, count+1);
		other.setContractCode(code);
		
		String path="D:"+File.separator+"oa"+File.separator+"OtherContract"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[ii].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("其他合同文本");
				list.add(accessory);
			}
			other.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int ii=0;ii<file2.length;ii++){
				Accessory accessory2=new Accessory();
				String fileName=file2[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[ii].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(filePath);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			other.setAccessory2(list2);
		}
		int i=service.addOtherContract(other);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(other.getAbutmentDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(other.getContractName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(other.getContractName()+"流程发起");
			currentFlow.setUrl("shengchanguanliLook/OtherContract.html-"+id);
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
	
	@RequestMapping("/addOtherContractBySubmit")
	@ResponseBody
	public String addOtherContractBySubmit(OtherContract other,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2,HttpSession session) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		other.setoId(id);
		int count=service.countNo();
		String type="";
		String code="QT"+uuid.getPrjCode(type, count+1);
		other.setContractCode(code);
		String path="D:"+File.separator+"oa"+File.separator+"OtherContract"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[ii].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("其他合同文本");
				list.add(accessory);
			}
			other.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int ii=0;ii<file2.length;ii++){
				Accessory accessory2=new Accessory();
				String fileName=file2[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[ii].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(filePath);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			other.setAccessory2(list2);
		}
		int i=service.addOtherContract(other);
		String string = i+"";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(other.getAbutmentDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(other.getContractName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(other.getContractName()+"流程发起");
			currentFlow.setUrl("shengchanguanliLook/OtherContract.html-"+id);
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
	
	@RequestMapping("/updateOtherContractBySave")
	@ResponseBody
	public int updateOtherContractBySave(OtherContract other,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2,HttpSession session) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		other.setoId(id);
		String path="D:"+File.separator+"oa"+File.separator+"OtherContract"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[ii].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("其他合同文本");
				list.add(accessory);
			}
			other.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int ii=0;ii<file2.length;ii++){
				Accessory accessory2=new Accessory();
				String fileName=file2[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[ii].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(filePath);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			other.setAccessory2(list2);
		}
		int i=service.addOtherContract(other);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(other.getAbutmentDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(other.getContractName()+"其他合同变更");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(other.getContractName()+"其他合同变更流程发起");
			currentFlow.setUrl("shengchanguanliLook/OtherContract.html-"+id);
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
	
	@RequestMapping("/updateOtherContractBySubmit")
	@ResponseBody
	public String updateOtherContractBySubmit(OtherContract other,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2,HttpSession session) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		other.setoId(id);
		String path="D:"+File.separator+"oa"+File.separator+"OtherContract"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[ii].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("其他合同文本");
				list.add(accessory);
			}
			other.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int ii=0;ii<file2.length;ii++){
				Accessory accessory2=new Accessory();
				String fileName=file2[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[ii].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(filePath);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			other.setAccessory2(list2);
		}
		int i=service.addOtherContract(other);
		String string = i+"";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(other.getAbutmentDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(other.getContractName()+"其他合同变更");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(other.getContractName()+"其他合同变更流程发起");
			currentFlow.setUrl("shengchanguanliLook/OtherContract.html-"+id);
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
	
	@RequestMapping("/selectOtherContract")
	@ResponseBody
	public List<OtherContract> selectOtherContract(String status){
		return service.selectOtherContract(status);
	}
	
	@RequestMapping("/selectCjHistory")
	@ResponseBody
	public List<OtherContract> selectCjHistory(String no){
		return service.selectCjHistory(no);
	}
	
	@RequestMapping("/selectOtherContractById")
	@ResponseBody
	public OtherContract selectOtherContractById(String id){
		return service.selectOtherContractById(id);
	}
	
	@RequestMapping("/selectOtherContractByNo")//通过合同号获得其他合同的详细信息
	@ResponseBody
	public OtherContract selectOtherContractByNo(String no){
		return service.selectOtherContractByNo(no);
	}
	
	@RequestMapping("/updateHistoryById") //通过id修改历史状态，prjno为当前的全部改为0，再把当前这条记录的历史状态改为1
	@ResponseBody
	public int updateHistoryById(String id){
		return service.updateHistoryById(id);
	}
	
	@RequestMapping("/updateOtherContractById")
	@ResponseBody
	public int updateOtherContractById(OtherContract other,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2) throws IllegalStateException, IOException{
		String id=other.getoId();
		String path="D:"+File.separator+"oa"+File.separator+"OtherContract"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[ii].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("其他合同文本");
				list.add(accessory);
			}
			other.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int ii=0;ii<file2.length;ii++){
				Accessory accessory2=new Accessory();
				String fileName=file2[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[ii].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(filePath);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			other.setAccessory2(list2);
		}
		int i=service.updateOtherContractById(other);
		return i;
	}
}

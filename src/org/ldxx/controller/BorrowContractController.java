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
import org.ldxx.bean.BorrowContract;
import org.ldxx.bean.CgContract;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.ContractReason;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.User;
import org.ldxx.service.BorrowContractService;
import org.ldxx.service.CjContractService;
import org.ldxx.service.ContractReasonService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 借款合同管理
 * @author hp
 */

@RequestMapping("BorrowContract")
@Controller
public class BorrowContractController {
	
	@Autowired
	private BorrowContractService service;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private CjContractService cService;
	@Autowired
	private ContractReasonService crService;
	
	@RequestMapping("/selectBorrowContract")
	@ResponseBody
	public List<BorrowContract> selectBorrowContract(String status){
		return service.selectBorrowContract(status);
	}
	
	@RequestMapping("/addBorrowContractSave")
	@ResponseBody
	public Map<String,Object> addBorrowContractSave(BorrowContract bc,@RequestParam("file") MultipartFile [] file,@RequestParam("file2") MultipartFile [] file2,HttpSession session) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		bc.setbId(id);
		int count=service.JKNocount();
		String jkNo="JK"+uuid.getClCode("", count+1);
		bc.setbNo(jkNo);
		
		String path = "D:"+File.separator+"oa"+File.separator+"BorrowContract"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				String filename = file[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("借款合同文本");
				list.add(accessory);
			}
			bc.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int i=0;i<file2.length;i++){
				String filename = file2[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file2[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("法律顾问签字");
				list2.add(accessory);
			}
			bc.setAccessory2(list2);
		}
		int i=service.addBorrowContractSave(bc);
		if(i>0){
			CjContract cj=cService.getCjContractMainDepartmentLeader(bc.getCjNo());
			String mainDepartment=cj.getMainDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(bc.getFbNo()+"分包合同借款保存");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(bc.getFbNo()+"分包合同借款保存");
			currentFlow.setUrl("shengchanguanliLook/borrow.html-"+id);
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
		map.put("result", i);
		map.put("BorrowContract", bc);
		return map;
	}
	
	@RequestMapping("/addBorrowContractSubmit")
	@ResponseBody
	public String addBorrowContractSubmit(BorrowContract bc,@RequestParam("file") MultipartFile [] file,@RequestParam("file2") MultipartFile [] file2,HttpSession session) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		bc.setbId(id);
		int count=service.JKNocount();
		String jkNo="JK"+uuid.getClCode("", count+1);
		bc.setbNo(jkNo);
		
		String path = "D:"+File.separator+"oa"+File.separator+"BorrowContract"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				String filename = file[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("借款合同文本");
				list.add(accessory);
			}
			bc.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int i=0;i<file2.length;i++){
				String filename = file2[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file2[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("法律顾问签字");
				list2.add(accessory);
			}
			bc.setAccessory2(list2);
		}
		int i=service.addBorrowContractSave(bc);
		String string = i+"";
		if(i>0){
			CjContract cj=cService.getCjContractMainDepartmentLeader(bc.getCjNo());
			String mainDepartment=cj.getMainDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(bc.getFbNo()+"分包合同借款流程提交");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(bc.getFbNo()+"分包合同借款流程提交");
			currentFlow.setUrl("shengchanguanliLook/borrow.html-"+id);
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
	
	@RequestMapping("/updateBorrowContractSave")
	@ResponseBody
	public Map<String,Object> updateBorrowContractSave(BorrowContract bc,@RequestParam("file") MultipartFile [] file,@RequestParam("file2") MultipartFile [] file2,HttpSession session) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		bc.setbId(id);
		
		String path = "D:"+File.separator+"oa"+File.separator+"BorrowContract"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				String filename = file[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("借款合同文本");
				list.add(accessory);
			}
			bc.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int i=0;i<file2.length;i++){
				String filename = file2[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file2[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("法律顾问签字");
				list2.add(accessory);
			}
			bc.setAccessory2(list2);
		}
		int i=service.addBorrowContractSave(bc);
		if(i>0){
			CjContract cj=cService.getCjContractMainDepartmentLeader(bc.getCjNo());
			String mainDepartment=cj.getMainDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle("借款合同变更："+bc.getFbNo());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo("借款合同变更："+bc.getFbNo()+"流程保存");
			currentFlow.setUrl("shengchanguanliLook/borrow.html-"+id);
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
		map.put("result", i);
		map.put("BorrowContract", bc);
		return map;
	}
	
	@RequestMapping("/updateBorrowContractSubmit")
	@ResponseBody
	public String updateBorrowContractSubmit(BorrowContract bc,@RequestParam("file") MultipartFile [] file,@RequestParam("file2") MultipartFile [] file2,HttpSession session) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		bc.setbId(id);
		
		String path = "D:"+File.separator+"oa"+File.separator+"BorrowContract"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				String filename = file[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("借款合同文本");
				list.add(accessory);
			}
			bc.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int i=0;i<file2.length;i++){
				String filename = file2[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file2[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("法律顾问签字");
				list2.add(accessory);
			}
			bc.setAccessory2(list2);
		}
		int i=service.addBorrowContractSave(bc);
		String string = i+"";
		if(i>0){
			CjContract cj=cService.getCjContractMainDepartmentLeader(bc.getCjNo());
			String mainDepartment=cj.getMainDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle("借款合同变更："+bc.getFbNo());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo("借款合同变更："+bc.getFbNo()+"流程提交");
			currentFlow.setUrl("shengchanguanliLook/borrow.html-"+id);
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
		/*map.put("result", i);
		map.put("BorrowContract", bc);
		return map;*/
	}
	
	@RequestMapping("/selectBorrowContractHistory")
	@ResponseBody
	public List<BorrowContract> selectBorrowContractHistory(String no){
		return service.selectBorrowContractHistory(no);
	}
	
	@RequestMapping("/updateHistoryById") //通过id修改历史状态，prjno为当前的全部改为0，再把当前这条记录的历史状态改为1
	@ResponseBody
	public int updateHistoryById(String id){
		return service.updateHistoryById(id);
	}
	
	@RequestMapping("/selectBorrowById")
	@ResponseBody
	public BorrowContract selectBorrowById(String id){
		BorrowContract bc=service.selectBorrowById(id);
		return bc;
	}
	
	@RequestMapping("/updateBorrowContractById")//修改接口
	@ResponseBody
	public Map<String,Object> updateBorrowContractById(BorrowContract bc,@RequestParam("file") MultipartFile [] file,@RequestParam("file2") MultipartFile [] file2) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		String id=bc.getbId();
		
		String path = "D:"+File.separator+"oa"+File.separator+"BorrowContract"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				String filename = file[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("借款合同文本");
				list.add(accessory);
			}
			bc.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int i=0;i<file2.length;i++){
				String filename = file2[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file2[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("法律顾问签字");
				list2.add(accessory);
			}
			bc.setAccessory2(list2);
		}
		int i=service.updateBorrowContractById(bc);
		map.put("result", i);
		map.put("BorrowContract", bc);
		return map;
	}
	
	
	
	@RequestMapping("/addBorrowContractStopReason")//借款合同取消原因
	@ResponseBody
	public String addBorrowContractStopReason(ContractReason cr,HttpSession session) throws IllegalStateException, IOException{
		int count=crService.countId(cr.getId());
		int i=0;
		if(count==0){
			i=crService.addContractReason(cr);
		}else{
			i=crService.updateContractReasonById(cr);
		}
		String string = i+"";
		if(i>0){
			BorrowContract bc = service.selectBorrowById(cr.getId());
			CjContract cj=cService.getCjContractMainDepartmentLeader(bc.getCjNo());
			String mainDepartment=cj.getMainDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setTitle("借款合同："+bc.getFbNo());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo("借款合同："+bc.getFbNo()+"取消流程提交");
			currentFlow.setUrl("shengchanguanliLook/borrow.html-"+cr.getId());
			currentFlow.setParams("借款合同取消原因："+cr.getStopReason());
			currentFlow.setStarter(user.getUserId());
			currentFlow.setStartername(user.getuName());
			currentFlow.setFkDept(omNo);
			currentFlow.setDeptname(user.getOmName());
			currentFlow.setNodename("节点名称");
			currentFlow.setPri(1);
			currentFlow.setSdtofnode(new Date());
			currentFlow.setSdtofflow(new Date());
			currentFlow.setFlowEndState(3);
			currentFlow.setFlowNopassState(2);
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
	
	@RequestMapping("/addBorrowContractRestartReason")//借款合同启动原因
	@ResponseBody
	public String addBorrowContractRestartReason(ContractReason cr,HttpSession session) throws IllegalStateException, IOException{
		int i=crService.updateContractReasonById(cr);
		String string = i+"";
		if(i>0){
			BorrowContract bc = service.selectBorrowById(cr.getId());
			CjContract cj=cService.getCjContractMainDepartmentLeader(bc.getCjNo());
			String mainDepartment=cj.getMainDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setTitle("借款合同："+bc.getFbNo());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo("借款合同："+bc.getFbNo()+"重新启用流程提交");
			currentFlow.setUrl("shengchanguanliLook/borrow.html-"+cr.getId());
			currentFlow.setParams("借款合同启用原因："+cr.getRestartReason());
			currentFlow.setStarter(user.getUserId());
			currentFlow.setStartername(user.getuName());
			currentFlow.setFkDept(omNo);
			currentFlow.setDeptname(user.getOmName());
			currentFlow.setNodename("节点名称");
			currentFlow.setPri(1);
			currentFlow.setSdtofnode(new Date());
			currentFlow.setSdtofflow(new Date());
			currentFlow.setFlowEndState(2);
			currentFlow.setFlowNopassState(3);
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
	
}

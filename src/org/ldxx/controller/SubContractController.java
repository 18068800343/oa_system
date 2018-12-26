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
import org.ldxx.bean.CjContract;
import org.ldxx.bean.ContractReason;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FbContract;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.User;
import org.ldxx.service.CjContractService;
import org.ldxx.service.ContractReasonService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.SubContractService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
/**
 * 分包合同管理
 * @author hp
 *
 */
@RequestMapping("subcontract")
@Controller
public class SubContractController {

	@Autowired
	private SubContractService scService;
	@Autowired
	private CjContractService cjService;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private ContractReasonService cService;
	
	@RequestMapping("/selectSubContract")
	@ResponseBody
	public List<FbContract> selectSubContract(String status,String startMin,String startMax,String endMin,
			String endMax,String mainDp,String spType,@RequestParam(defaultValue="0")float fbMoneyMin,@RequestParam(defaultValue="0")float fbMoneyMax,
			@RequestParam(defaultValue="0")float contractMoneyMin,@RequestParam(defaultValue="0")float contractMoneyMax,
			@RequestParam(defaultValue="0")float zdMoneyMin,@RequestParam(defaultValue="0")float zdMoneyMax){
		return scService.selectSubContract(status, startMin, startMax, endMin, endMax, mainDp, spType, fbMoneyMin, fbMoneyMax, contractMoneyMin, contractMoneyMax, zdMoneyMin, zdMoneyMax);
	}
	
	@RequestMapping("/saveSubContract")//保存
	@ResponseBody
	public Map<String,Object> saveSubContract(HttpSession session,FbContract fbContract,@RequestParam("file")MultipartFile file[],@RequestParam("file1")MultipartFile file1[]) throws IllegalStateException, IOException{
		Map<String,Object> map = new HashMap<>();
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		fbContract.setFbId(id);
		
		String type = fbContract.getFbcType();
		String code = type.split(" ")[0];
		int count=scService.fbNocount();
		count=count+1;
		String fbNo=uuid.getPrjCode(code, count);
		fbNo="FB"+fbNo;
		fbContract.setFbNo(fbNo);	
		
		String path = "D:"+File.separator+"oa"+File.separator+"subcontract"+File.separator+id;
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
				accessory.setaType("分包合同文本");
				list.add(accessory);
			}
			fbContract.setAccessory(list);
		}
		if(file1.length>0){
			List<Accessory> list1 = new ArrayList<>();
			for(int i=0;i<file1.length;i++){
				Accessory accessory1=new Accessory();
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file1[i].transferTo(f1);
				accessory1.setaId(id);
				accessory1.setAcName(fileName);
				accessory1.setAcUrl(filePath);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			fbContract.setAccessory1(list1);
		}
		int i=scService.saveSubContract(fbContract);
		if(i>0){
			CjContract cj=cjService.getCjContractMainDepartmentLeader(fbContract.getCjContractCode());
			String mainDepartment=cj.getMainDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setTitle(fbContract.getContractName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(fbContract.getContractName()+"流程发起");
			currentFlow.setUrl("shengchanguanliLook/SubcontractManagementLook.html-"+id);
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
		map.put("fbContract", fbContract);
		return map;
	}
	
	@RequestMapping("/submitSubContract")//提交
	@ResponseBody
	public String submitSubContract(FbContract fbContract,@RequestParam("file")MultipartFile file[],@RequestParam("file1")MultipartFile file1[],HttpSession session) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		fbContract.setFbId(id);
		
		String type = fbContract.getFbcType();
		String code = type.split(" ")[0];
		int count=scService.fbNocount();
		count=count+1;
		String fbNo=uuid.getPrjCode(code, count);
		fbNo="FB"+fbNo;
		fbContract.setFbNo(fbNo);
		
		String path = "D:"+File.separator+"oa"+File.separator+"subcontract"+File.separator+id;
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
				accessory.setaType("分包合同文本");
				list.add(accessory);
			}
			fbContract.setAccessory(list);
		}
		if(file1.length>0){
			List<Accessory> list1 = new ArrayList<>();
			for(int i=0;i<file1.length;i++){
				Accessory accessory1=new Accessory();
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file1[i].transferTo(f1);
				accessory1.setaId(id);
				accessory1.setAcName(fileName);
				accessory1.setAcUrl(filePath);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			fbContract.setAccessory1(list1);
		}
		int i=scService.saveSubContract(fbContract);
		String string = i+"";
		if(i>0){
			CjContract cj=cjService.getCjContractMainDepartmentLeader(fbContract.getCjContractCode());
			String mainDepartment=cj.getMainDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setTitle(fbContract.getContractName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(fbContract.getContractName()+"流程发起");
			currentFlow.setUrl("shengchanguanliLook/SubcontractManagementLook.html-"+id);
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
	
	
	@RequestMapping("/submitFbCancel")//合同取消
	@ResponseBody
	public String submitCjCancel(ContractReason cr,String fbName,String cjNo,HttpSession session){
		int i=cService.addContractReason(cr);
		String string = i+"";
		if(i>0){
			CjContract cj=cjService.getCjContractMainDepartmentLeader(cjNo);
			String mainDepartment=cj.getMainDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("合同取消原因："+cr.getStopReason());
			currentFlow.setTitle(fbName+"取消流程发起");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(fbName+"取消流程发起");
			currentFlow.setUrl("shengchanguanliLook/SubcontractManagementLook.html-"+cr.getId());
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
	
	@RequestMapping("/submitFbRestart")//合同重新启用
	@ResponseBody
	public String submitCjRestart(ContractReason cr,String fbName,String cjNo,HttpSession session){
		int i=cService.updateContractReasonById(cr);
		String string = i+"";
		if(i>0){
			CjContract cj=cjService.getCjContractMainDepartmentLeader(cjNo);
			String mainDepartment=cj.getMainDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("合同重新启用原因："+cr.getRestartReason());
			currentFlow.setTitle(fbName+"重新启用流程发起");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(fbName+"重新启用流程发起");
			currentFlow.setUrl("shengchanguanliLook/SubcontractManagementLook.html-"+cr.getId());
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
	
	@RequestMapping("/deleteSubContractById")
	@ResponseBody
	public int deleteSubContractById(String id){
		return scService.deleteSubContractById(id);
	}
	
	
	@RequestMapping("/updateSubContractsave")
	@ResponseBody
	public Map<String,Object> updateSubContractsave(HttpSession session,FbContract fbContract,@RequestParam("file")MultipartFile file[],@RequestParam("file1")MultipartFile file1[]) throws IllegalStateException, IOException{
		Map<String,Object> map = new HashMap<>();
		String id=new TimeUUID().getTimeUUID();
		fbContract.setFbId(id);
		
		String path = "D:"+File.separator+"oa"+File.separator+"subcontract"+File.separator+id;
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
				accessory.setaType("分包合同文本");
				list.add(accessory);
			}
			fbContract.setAccessory(list);
		}
		if(file1.length>0){
			List<Accessory> list1 = new ArrayList<>();
			for(int i=0;i<file1.length;i++){
				Accessory accessory1=new Accessory();
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file1[i].transferTo(f1);
				accessory1.setaId(id);
				accessory1.setAcName(fileName);
				accessory1.setAcUrl(filePath);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			fbContract.setAccessory1(list1);
		}
		int i=scService.saveSubContract(fbContract);
		if(i>0){
			CjContract cj=cjService.getCjContractMainDepartmentLeader(fbContract.getCjContractCode());
			String mainDepartment=cj.getMainDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(fbContract.getContractName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(fbContract.getContractName()+"保存");
			currentFlow.setUrl("shengchanguanliLook/SubcontractManagementLook.html-"+id);
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
		map.put("fbContract", fbContract);
		return map;
	}
	
	@RequestMapping("/updateSubContractsubmit")
	@ResponseBody
	public String updateSubContractsubmit(HttpSession session,FbContract fbContract,@RequestParam("file")MultipartFile file[],@RequestParam("file1")MultipartFile file1[]) throws IllegalStateException, IOException{
		Map<String,Object> map = new HashMap<>();
		String id=new TimeUUID().getTimeUUID();
		fbContract.setFbId(id);
		
		String path = "D:"+File.separator+"oa"+File.separator+"subcontract"+File.separator+id;
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
				accessory.setaType("分包合同文本");
				list.add(accessory);
			}
			fbContract.setAccessory(list);
		}
		if(file1.length>0){
			List<Accessory> list1 = new ArrayList<>();
			for(int i=0;i<file1.length;i++){
				Accessory accessory1=new Accessory();
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file1[i].transferTo(f1);
				accessory1.setaId(id);
				accessory1.setAcName(fileName);
				accessory1.setAcUrl(filePath);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			fbContract.setAccessory1(list1);
		}
		int i=scService.saveSubContract(fbContract);
		String string = i+"";
		if(i>0){
			CjContract cj=cjService.getCjContractMainDepartmentLeader(fbContract.getCjContractCode());
			String mainDepartment=cj.getMainDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(fbContract.getContractName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(fbContract.getContractName()+"流程发起");
			currentFlow.setUrl("shengchanguanliLook/SubcontractManagementLook.html-"+id);
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
	
	@RequestMapping("/selectSubContractById")
	@ResponseBody
	public FbContract selectSubContractById(String id){
		return scService.selectSubContractById(id);
	}
	
	@RequestMapping("/selectAccessoryById")
	@ResponseBody
	public List<Accessory> selectAccessoryById(String id){
		List<Accessory> list=scService.selectAccessoryById(id);
		return list;
	}
	
	@RequestMapping("/deleteAccessory")
	@ResponseBody
	public int deleteAccessory(Accessory accessory){
		int i=scService.deleteAccessoryByIdAndName(accessory);
		if(i>0){
			File f=new File(accessory.getAcUrl());
			f.delete();
		}
		return i;
	}
	
	@RequestMapping("/selectsubcontractHistory")//初始化合同历史信息
	@ResponseBody
	public List<FbContract> selectsubcontractHistory(String fbNo){
		List<FbContract> list=scService.selectsubcontractHistory(fbNo);
		return list;
	}
	
	@RequestMapping("/getFBNameAndNo")//初始化合同名和合同编号和乙方
	@ResponseBody
	public List<FbContract> getFBNameAndNo(){
		List<FbContract> list=scService.getFBNameAndNo();
		return list;
	}
	
	@RequestMapping("/getFBNameByNo")//通过合同编号获得合同名和乙方
	@ResponseBody
	public FbContract getFBNameByNo(String fbNo){
		return scService.getFBNameByNo(fbNo);
	}
	
	@RequestMapping("/getFBNoByName")//通过合同名获得合同编号和乙方
	@ResponseBody
	public FbContract getFBNoByName(String contractName){
		return scService.getFBNoByName(contractName);
	}
	
	@RequestMapping("/getFBContractByName")//通过合同名获得主合同名、主合同号、主合同金额、项目名、任务单号、合同号
	@ResponseBody
	public FbContract getFBContractByName(String contractName){
		return scService.getFBContractByName(contractName);
	}
	
	@RequestMapping("/getFBContractByNo")//通过合同号获得主合同名、主合同号、主合同金额、项目名、任务单号、合同名
	@ResponseBody
	public FbContract getFBContractByNo(String no){
		return scService.getFBContractByNo(no);
	}
	
	@RequestMapping("/getFbcjNo")//初始化主合同号
	@ResponseBody
	public List<FbContract> getFbcjNo(){
		return scService.getFbcjNo();
	}
	
	@RequestMapping("/getFBNoBycjNo")//通过主合同号获得分包合同编号
	@ResponseBody
	public List<FbContract> getFBNoBycjNo(String no){
		return scService.getFBNoBycjNo(no);
	}
	
	@RequestMapping("/updateHistoryById") //通过id修改历史状态，prjno为当前的全部改为0，再把当前这条记录的历史状态改为1
	@ResponseBody
	public int updateHistoryById(String id){
		return scService.updateHistoryById(id);
	}
	
	@RequestMapping("/updateFbById")
	@ResponseBody
	public int updateFbById(FbContract fbContract,@RequestParam("file")MultipartFile [] file,@RequestParam("file1")MultipartFile [] file1){
		Map<String,Object> map = new HashMap<>();
		String id=fbContract.getFbId();
		String path = "D:"+File.separator+"oa"+File.separator+"subcontract"+File.separator+id;
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
				try {
					file[i].transferTo(f1);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("分包合同文本");
				list.add(accessory);
			}
			fbContract.setAccessory(list);
		}
		if(file1.length>0){
			List<Accessory> list1 = new ArrayList<>();
			for(int i=0;i<file1.length;i++){
				Accessory accessory1=new Accessory();
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				try {
					file1[i].transferTo(f1);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				accessory1.setaId(id);
				accessory1.setAcName(fileName);
				accessory1.setAcUrl(filePath);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			fbContract.setAccessory1(list1);
		}
		int i=scService.updateSubContract(fbContract);
		return i;
	}
	
}

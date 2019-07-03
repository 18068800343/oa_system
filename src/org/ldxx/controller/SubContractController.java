package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.BorrowContract;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.ContractReason;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FbContract;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.Task;
import org.ldxx.bean.User;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.OrganizationManagementDao;
import org.ldxx.mapper.CurrentFlowMapper;
import org.ldxx.service.BorrowContractService;
import org.ldxx.service.CjContractService;
import org.ldxx.service.ContractReasonService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.SubContractService;
import org.ldxx.service.TaskService;
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
	@Autowired
	private BorrowContractService bService;
	@Autowired
	private CurrentFlowMapper currentFlowMapper;
	@Autowired
	private OrganizationManagementDao omDao;
	@Autowired
	private TaskService tService;
	@Autowired
	private AccessoryDao adao;
	
	@RequestMapping("/selectSubContract")
	@ResponseBody
	public List<FbContract> selectSubContract(String status,String startMin,String startMax,String endMin,
			String endMax,String mainDp,String spType,@RequestParam(defaultValue="0")Double fbMoneyMin,@RequestParam(defaultValue="0")Double fbMoneyMax,
			@RequestParam(defaultValue="0")Double contractMoneyMin,@RequestParam(defaultValue="0")Double contractMoneyMax,
			@RequestParam(defaultValue="0")Double zdMoneyMin,@RequestParam(defaultValue="0")Double zdMoneyMax){
		return scService.selectSubContract(status, startMin, startMax, endMin, endMax, mainDp, spType, fbMoneyMin, fbMoneyMax, contractMoneyMin, contractMoneyMax, zdMoneyMin, zdMoneyMax);
	}
	
	@RequestMapping("/selectSubContract2")
	@ResponseBody
	public List<FbContract> selectSubContract2(String startMin,String startMax,String endMin,
			String endMax,String mainDp,String spType,@RequestParam(defaultValue="0")Double fbMoneyMin,@RequestParam(defaultValue="0")Double fbMoneyMax,
			@RequestParam(defaultValue="0")Double contractMoneyMin,@RequestParam(defaultValue="0")Double contractMoneyMax,
			@RequestParam(defaultValue="0")Double zdMoneyMin,@RequestParam(defaultValue="0")Double zdMoneyMax){
			List<FbContract>  list = scService.selectSubContract2(startMin, startMax, endMin, endMax, mainDp, spType, fbMoneyMin, fbMoneyMax, contractMoneyMin, contractMoneyMax, zdMoneyMin, zdMoneyMax);
		 return list;
	}
	
	@RequestMapping("/saveSubContract")//保存
	@ResponseBody
	public Map<String,Object> saveSubContract(HttpSession session,FbContract fbContract,@RequestParam("file")MultipartFile file[],@RequestParam("file1")MultipartFile file1[]) throws IllegalStateException, IOException{
		Map<String,Object> map = new HashMap<>();
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID(); 
		fbContract.setFbId(id);
		
		/*String type = fbContract.getFbcType();
		String code = type.split(" ")[0];
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		int count=scService.fbNocount(year);
		count=count+1;
		String fbNo=uuid.getPrjCode(code, count);
		fbNo="FB"+fbNo;
		fbContract.setFbNo(fbNo);	*/
		
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
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
				accessory.setAcUrl(id+File.separator+filename);
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
				accessory1.setAcUrl(id+File.separator+fileName);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			fbContract.setAccessory1(list1);
		}
		int i=scService.saveSubContract(fbContract);
		if(i>0){
			String string="";
			CjContract cj=cjService.getCjContractMainDepartmentLeader(fbContract.getCjContractCode());
			String mainDepartment=cj.getYiCjDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo="";
			if(null!=om){
				omNo=om.getOmNo();
			}
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
		
		/*String type = fbContract.getFbcType();
		String code = type.split(" ")[0];
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		int count=scService.fbNocount(year);
		count=count+1;
		String fbNo=uuid.getPrjCode(code, count);
		fbNo="FB"+fbNo;
		fbContract.setFbNo(fbNo);*/
		
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
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
				accessory.setAcUrl(id+File.separator+filename);
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
				accessory1.setAcUrl(id+File.separator+fileName);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			fbContract.setAccessory1(list1);
		}
		int i=scService.saveSubContract(fbContract);
		String string = i+"";
		if(i>0){
			CjContract cj=cjService.getCjContractMainDepartmentLeader(fbContract.getCjContractCode());
			String mainDepartment=cj.getYiCjDepartment();
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
	public String submitCjCancel(String id,String ContractReason,String fbName,String cjNo,HttpSession session){
		/*int count=cService.countId(cr.getId());
		int i=0;
		if(count==0){
			i=cService.addContractReason(cr);
		}else{
			i=cService.updateContractReasonById(cr);
		}*/
		int i=scService.updateContractReasonById(id,ContractReason);
		String string = i+"";
		if(i>0){
			CjContract cj=cjService.getCjContractMainDepartmentLeader(cjNo);
			String mainDepartment=cj.getYiCjDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("合同取消原因："+ContractReason);
			currentFlow.setTitle(fbName+"取消流程发起");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(fbName+"取消流程发起");
			currentFlow.setUrl("shengchanguanliLook/SubcontractManagementCancelLook.html-"+id);
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
			String mainDepartment=cj.getYiCjDepartment();
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
		TimeUUID uuid=new TimeUUID();
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
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
				accessory.setAcUrl(id+File.separator+filename);
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
				accessory1.setAcUrl(id+File.separator+fileName);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			fbContract.setAccessory1(list1);
		}
		int i=scService.saveSubContract(fbContract);
		if(i>0){
			CjContract cj=cjService.getCjContractMainDepartmentLeader(fbContract.getCjContractCode());
			String mainDepartment=cj.getYiCjDepartment();
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
		TimeUUID uuid=new TimeUUID();
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
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
				accessory.setAcUrl(id+File.separator+filename);
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
				accessory1.setAcUrl(id+File.separator+fileName);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			fbContract.setAccessory1(list1);
		}
		int i=scService.saveSubContract(fbContract);
		String string = i+"";
		if(i>0){
			CjContract cj=cjService.getCjContractMainDepartmentLeader(fbContract.getCjContractCode());
			String mainDepartment=cj.getYiCjDepartment();
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
	
	@RequestMapping("/getFBNoBytaskNo")//通过主合同号获得分包合同编号
	@ResponseBody
	public List<FbContract> getFBNoBytaskNo(String no){
		return scService.getFBNoBytaskNo(no);
	}
	
	@RequestMapping("/updateHistoryById") //通过id修改历史状态，prjno为当前的全部改为0，再把当前这条记录的历史状态改为1
	@ResponseBody
	public int updateHistoryById(String id){
		
			FbContract fb=scService.selectSubContractById(id);
			String type = fb.getFbcType();
			String code = type.split(" ")[0];
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
			String year=sdf.format(new Date());
			/*TimeUUID uuid=new TimeUUID();
			int count=scService.fbNocount(year);
			count=count+1;
			String fbNo=uuid.getPrjCode(code, count);
			fbNo="FB"+fbNo;*/
			String fbNo="FB"+year+cjService.CreateContractNumOrder("FB", year)+code;
			int i=0;
			if(null==fb.getFbNo()||fb.getFbNo().trim().equals("")){
				i=scService.updateFbNoById(id, fbNo);
			}
			i=scService.updateHistoryById(id);
		return i;
	}
	
	@RequestMapping("/CreateContractNumOrder")
	@ResponseBody
	public String CreateContractNumOrder(){
		String fbNo="FB"+"2019"+cjService.CreateContractNumOrder("FB", "2019")+"A";
		return fbNo;
	}
	
	@RequestMapping("/updateFbById")
	@ResponseBody
	public int updateFbById(FbContract fbContract,@RequestParam("file")MultipartFile [] file,@RequestParam("file1")MultipartFile [] file1){
		Map<String,Object> map = new HashMap<>();
		String id=fbContract.getFbId();
		TimeUUID uuid=new TimeUUID();
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
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
				accessory.setAcUrl(id+File.separator+filename);
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
				accessory1.setAcUrl(id+File.separator+fileName);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			fbContract.setAccessory1(list1);
		}
		int i=scService.updateSubContract(fbContract);
		if(i>0){
			String mainDept=fbContract.getMainManageDepartment();
			OrganizationManagement om=omDao.selectOrgById(mainDept);
			String omNo=om.getOmNo();
			currentFlowMapper.updateFkDeptByModeId(id,omNo);
		}
		return i;
	}
	
	@RequestMapping("/selectYiFangByNo")
	@ResponseBody
	public Map<String,Object> selectYiFangByNo(String no){
		Map<String,Object> map=new HashMap<>();
		FbContract fb=scService.selectYiFangByNo(no);
		BorrowContract bc=bService.selectAllBorrowByFbNo(no);
		map.put("fb", fb);
		map.put("bc", bc);
		return map;
	}
	
	@RequestMapping("/selectFbContractByTaskNo")
	@ResponseBody
	public List<FbContract> selectFbContractByTaskNo(String no){
		List<FbContract> list=scService.selectFbContractByTaskNo(no);
		return list;
	}
	
	@RequestMapping("/getShenpiFbMoneyByCjNo")//通过承接合同号查询审批中的分包合同金额
	@ResponseBody
	public Double getShenpiFbMoneyByCjNo(String cjno){
		Double fbMoney=scService.getShenpiFbMoneyByCjNo(cjno);
		return fbMoney;
	}
	@RequestMapping("/addSaoMiaoHeTong")
	@ResponseBody
	public Map<String,Object> addOtherFile(@RequestParam(value="file") MultipartFile [] file,String id,HttpServletRequest request){
		Map<String,Object> map=new HashMap<>();
		TimeUUID tu=new TimeUUID();
		int result;
		
		
		String webApps=tu.getWebAppFile();
		String path=webApps+id;
		//如果存在之前的文件，将其删除
		List<Accessory> list = adao.selectAccessoryById(id);
		for(int i=0;i<list.size();i++) {
			if("合同扫描件".equals(list.get(i).getaType()))
			{
				File fOld = new File(webApps+list.get(i).getAcUrl());
				fOld.delete();
				adao.deleteAccessoryByIdAndAType(list.get(i));			
			}
		}
		
		String fileName =file[0].getOriginalFilename();		
		if(file.length>0){
			Accessory accessory=new Accessory();
			
			String filePath=path+File.separator+fileName;
			File f2=new File(filePath);
			
			if(!f2.getParentFile().exists())
			{
				f2.getParentFile().mkdirs();
			}
			try {
				file[0].transferTo(f2);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			accessory.setaId(id);
			accessory.setAcName(fileName);
			accessory.setAcUrl(id+File.separator+fileName);
			accessory.setaType("合同扫描件");
			List<Accessory> lista=new ArrayList<>();
			lista.add(accessory);
			result = adao.addAccessory(lista);
		}else 
		{
			result=-1;
		}

		map.put("result", result);
		return map;
	}
}

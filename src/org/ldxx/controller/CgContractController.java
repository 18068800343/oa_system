package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.BorrowContract;
import org.ldxx.bean.CgCl;
import org.ldxx.bean.CgContract;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.ContractReason;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FbContract;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.MaterialDemand;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.PrjWorkingHours;
import org.ldxx.bean.PrjWorkingHoursP;
import org.ldxx.bean.Task;
import org.ldxx.bean.User;
import org.ldxx.service.CgContractService;
import org.ldxx.service.ContractReasonService;
import org.ldxx.service.OrganizationManagementService;
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

/**
 * 采购合同管理
 * @author hp
 *
 */

@RequestMapping("cgcontract")
@Controller
public class CgContractController {
	
	@Autowired
	private CgContractService cgService;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private ContractReasonService cService;
	
	@RequestMapping("/selectCgContractByStatus")
	@ResponseBody
	public List<CgContract> selectCgContractByStatus(String status){
		List<CgContract> list = cgService.selectCgContractByStatus(status);
		return list;
	}
	
	@RequestMapping("/addCgContractSave")//保存
	@ResponseBody
	public int addCgContractSave(String cgContract,@RequestParam("file") MultipartFile [] file,@RequestParam("file1") MultipartFile [] file1,HttpSession session) throws IllegalStateException, IOException{
		Map<String,Class> map2=new HashMap<>();
		map2.put("cgcl", CgCl.class);
		map2.put("accessory", Accessory.class);
		map2.put("accessory1", Accessory.class);
		JSONObject jsonObject=JSONObject.fromObject(cgContract);
		CgContract cg=(CgContract)JSONObject.toBean(jsonObject, CgContract.class,map2);
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cg.setCgId(id);
		
		String type = cg.getCgcType();
		String code = type.split(" ")[0];
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		int count=cgService.cgNocount(year);
		count=count+1;
		String cgNo=uuid.getPrjCode(code, count);
		cgNo="CG"+cgNo;
		cg.setCgNo(cgNo);
		
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("采购合同文本");
				list.add(accessory);
			}
			cg.setAccessory(list);
		}
		if(file1.length>0){
			List<Accessory> list1=new ArrayList<>();
			for(int i=0;i<file1.length;i++){
				Accessory accessory1=new Accessory();
				String fileName1=file1[i].getOriginalFilename();
				String filePath1=path+File.separator+fileName1;
				File f2=new File(filePath1);
				file1[i].transferTo(f2);
				accessory1.setaId(id);
				accessory1.setAcName(fileName1);
				accessory1.setAcUrl(id+File.separator+fileName1);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			cg.setAccessory1(list1);
		}
		int i=cgService.addCgContract(cg);
		if(i>0){
			User user = (User) session.getAttribute("user");
			OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String omNo=om.getOmNo();
			String string="";
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(cg.getContractName()+"采购合同申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(cg.getContractName()+"采购合同申请流程发起");
			currentFlow.setUrl("shengchanguanliLook/ProcurementContract.html-"+id);
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

	
	@RequestMapping("/addCgContractSubmit")//提交
	@ResponseBody
	public String addCgContractSubmit(String cgContract,@RequestParam("file") MultipartFile [] file,@RequestParam("file1") MultipartFile [] file1,HttpSession session) throws IllegalStateException, IOException{
		Map<String,Class> map2=new HashMap<>();
		map2.put("cgcl", CgCl.class);
		map2.put("accessory", Accessory.class);
		map2.put("accessory1", Accessory.class);
		JSONObject jsonObject=JSONObject.fromObject(cgContract);
		CgContract cg=(CgContract)JSONObject.toBean(jsonObject, CgContract.class,map2);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cg.setCgId(id);
		
		String type = cg.getCgcType();
		String code = type.split(" ")[0];
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		int count=cgService.cgNocount(year);
		count=count+1;
		String cgNo=uuid.getPrjCode(code, count);
		cgNo="CG"+cgNo;
		cg.setCgNo(cgNo);
		
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("采购合同文本");
				list.add(accessory);
			}
			cg.setAccessory(list);
		}
		if(file1.length>0){
			List<Accessory> list1=new ArrayList<>();
			for(int i=0;i<file1.length;i++){
				Accessory accessory1=new Accessory();
				String fileName1=file1[i].getOriginalFilename();
				String filePath1=path+File.separator+fileName1;
				File f2=new File(filePath1);
				file1[i].transferTo(f2);
				accessory1.setaId(id);
				accessory1.setAcName(fileName1);
				accessory1.setAcUrl(id+File.separator+fileName1);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			cg.setAccessory1(list1);
		}
		int i=cgService.addCgContract(cg);
		String string = i+"";
		if(i>0){
			User user = (User) session.getAttribute("user");
			OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String omNoCg = oService.getOrgIdByName(cg.getCgDepartment()).getOmNo();
			String omNo=om.getOmNo();
			if(!"".equals(omNoCg)){
				omNo=omNoCg;
			}
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(cg.getContractName()+"采购合同申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(cg.getContractName()+"采购合同申请流程发起");
			currentFlow.setUrl("shengchanguanliLook/ProcurementContract.html-"+id);
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
	
	@RequestMapping("/submitCgCancel")//采购合同取消
	@ResponseBody
	public String submitCgCancel(ContractReason cr,String cgName,HttpSession session){
		int count=cService.countId(cr.getId());
		int i=0;
		if(count==0){
			i=cService.addContractReason(cr);
		}else{
			i=cService.updateContractReasonById(cr);
		}
		String string = i+"";
		if(i>0){
			User user = (User) session.getAttribute("user");
			OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String omNo=om.getOmNo();
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setTitle(cgName+"取消流程发起");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(cgName+"取消流程发起");
			currentFlow.setUrl("shengchanguanliLook/ProcurementContract.html-"+cr.getId());
			currentFlow.setParams("采购合同申请取消原因："+cr.getStopReason());
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
	
	@RequestMapping("/submitCgRestart")//采购合同取消
	@ResponseBody
	public String submitCgRestart(ContractReason cr,String cgName,HttpSession session){
		int i=cService.updateContractReasonById(cr);
		String string = i+"";
		if(i>0){
			User user = (User) session.getAttribute("user");
			OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String omNo=om.getOmNo();
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setTitle(cgName+"重新启用流程发起");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(cgName+"重新启用流程发起");
			currentFlow.setUrl("shengchanguanliLook/ProcurementContract.html-"+cr.getId());
			currentFlow.setParams("采购合同申请重新启用原因："+cr.getRestartReason());
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
	
	@RequestMapping("/deleteCgContractById")
	@ResponseBody
	public int deleteCgContractById(String id){
		return cgService.deleteCgContractById(id);
	}
	
	@RequestMapping("/updateCgContractSave")
	@ResponseBody
	public int updateCgContractSave(String cgContract,@RequestParam("file") MultipartFile [] file,@RequestParam("file1") MultipartFile [] file1,HttpSession session) throws IllegalStateException, IOException{
		Map<String,Class> map2=new HashMap<>();
		map2.put("cgcl", CgCl.class);
		map2.put("accessory", Accessory.class);
		map2.put("accessory1", Accessory.class);
		JSONObject jsonObject=JSONObject.fromObject(cgContract);
		CgContract cg=(CgContract)JSONObject.toBean(jsonObject, CgContract.class,map2);
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cg.setCgId(id);
		
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("采购合同文本");
				list.add(accessory);
			}
			cg.setAccessory(list);
		}
		if(file1.length>0){
			List<Accessory> list1=new ArrayList<>();
			for(int i=0;i<file1.length;i++){
				Accessory accessory1=new Accessory();
				String fileName1=file1[i].getOriginalFilename();
				String filePath1=path+File.separator+fileName1;
				File f2=new File(filePath1);
				file1[i].transferTo(f2);
				accessory1.setaId(id);
				accessory1.setAcName(fileName1);
				accessory1.setAcUrl(id+File.separator+fileName1);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			cg.setAccessory1(list1);
		}
		int i=cgService.addCgContract(cg);
		if(i>0){
			User user = (User) session.getAttribute("user");
			OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String omNo=om.getOmNo();
			String string="";
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(cg.getContractName()+"采购合同变更");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(cg.getContractName()+"采购合同变更流程发起");
			currentFlow.setUrl("shengchanguanliLook/ProcurementContract.html-"+id);
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
	
	@RequestMapping("/updateCgContractSubmit")
	@ResponseBody
	public String updateCgContractSubmit(String cgContract,@RequestParam("file") MultipartFile [] file,@RequestParam("file1") MultipartFile [] file1,HttpSession session) throws IllegalStateException, IOException{
		Map<String,Class> map2=new HashMap<>();
		map2.put("cgcl", CgCl.class);
		map2.put("accessory", Accessory.class);
		map2.put("accessory1", Accessory.class);
		JSONObject jsonObject=JSONObject.fromObject(cgContract);
		CgContract cg=(CgContract)JSONObject.toBean(jsonObject, CgContract.class,map2);
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cg.setCgId(id);
		
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("采购合同文本");
				list.add(accessory);
			}
			cg.setAccessory(list);
		}
		if(file1.length>0){
			List<Accessory> list1=new ArrayList<>();
			for(int i=0;i<file1.length;i++){
				Accessory accessory1=new Accessory();
				String fileName1=file1[i].getOriginalFilename();
				String filePath1=path+File.separator+fileName1;
				File f2=new File(filePath1);
				file1[i].transferTo(f2);
				accessory1.setaId(id);
				accessory1.setAcName(fileName1);
				accessory1.setAcUrl(id+File.separator+fileName1);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			cg.setAccessory1(list1);
		}
		int i=cgService.addCgContract(cg);
		String string = i+"";
		if(i>0){
			User user = (User) session.getAttribute("user");
			OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String omNo=om.getOmNo();
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(cg.getContractName()+"采购合同变更");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(cg.getContractName()+"采购合同变更流程发起");
			currentFlow.setUrl("shengchanguanliLook/ProcurementContract.html-"+id);
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
	
	@RequestMapping("/selectCgContractById")
	@ResponseBody
	public CgContract selectCgContractById(String id){
		return cgService.selectCgContractById(id);
	}
	
	@RequestMapping("/selectCgIdAndName")
	@ResponseBody
	public List<CgContract> selectCgIdAndName(){
		return cgService.selectCgIdAndName();
	}
	
	@RequestMapping("/selectCgnoById")
	@ResponseBody
	public CgContract selectCgnoById(String id){
		return cgService.selectCgnoById(id);
	}
	
	@RequestMapping("/selectAccessoryById")
	@ResponseBody
	public List<Accessory> selectAccessoryById(String id){
		List<Accessory> list=cgService.selectAccessoryById(id);
		return list;
	}
	
	@RequestMapping("/deleteAccessory")
	@ResponseBody
	public int deleteAccessory(Accessory accessory){
		int i=cgService.deleteAccessoryByIdAndName(accessory);
		if(i>0){
			File f=new File(accessory.getAcUrl());
			f.delete();
		}
		return i;
	}
	
	@RequestMapping("/selectHistoryByNo")
	@ResponseBody
	public List<CgContract> selectHistoryByNo(String cgNo){
		return cgService.selectHistoryByNo(cgNo);
	}
	
	@RequestMapping("/getCGNameAndNo")//初始化合同名和合同编号、项目名和任务单号
	@ResponseBody
	public List<CgContract> getCGNameAndNo(){
		List<CgContract> list=cgService.getCGNameAndNo();
		return list;
	}
	
	@RequestMapping("/getCGNameByNo")//通过合同编号获得合同名
	@ResponseBody
	public List<CgContract> getCGNameByNo(String cgNo){
		return cgService.getCGNameByNo(cgNo);
	}
	
	@RequestMapping("/getCGNoByName")//通过合同名获得合同编号
	@ResponseBody
	public List<CgContract> getCGNoByName(String contractName){
		return cgService.getCGNoByName(contractName);
	}
	
	
	@RequestMapping("/getCGNameAndPrjNameBytaskNo")//通过任务单获得采购合同和项目名
	@ResponseBody
	public List<CgContract> getCGNameAndPrjNameBytaskNo(String no){
		return cgService.getCGNameAndPrjNameBytaskNo(no);
	}
	
	@RequestMapping("/getCGNametaskNoAndByPrjName")//通过项目名获得采购合同和任务单
	@ResponseBody
	public List<CgContract> getCGNametaskNoAndByPrjName(String name){
		return cgService.getCGNametaskNoAndByPrjName(name);
	}
	
	@RequestMapping("/updateDepartmentMoney")//修改部门金额
	@ResponseBody
	public int updateDepartmentMoney(float price,String id){
		return cgService.updateDepartmentMoney(price,id);
	}
	
	@RequestMapping("/getMdById")//获取材料信息
	@ResponseBody
	public List<MaterialDemand> getMdById(String id){
		return cgService.getMdById(id);
	}
	
	@RequestMapping("/updateMaterial")//修改材料信息
	@ResponseBody
	public int updateMaterial(MaterialDemand md){
		return cgService.updateMaterial(md);
	}
	
	@RequestMapping("/getCGNameCgNoAndCgMoney")//初始化合同名、合同编号、合同金额
	@ResponseBody
	public List<CgContract> getCGNameCgNoAndCgMoney(){
		List<CgContract> list=cgService.getCGNameCgNoAndCgMoney();
		return list;
	}
	
	@RequestMapping("/selectByCgNo")//通过采购号获取详细信息
	@ResponseBody
	public CgContract selectByCgNo(String no){
		return cgService.selectByCgNo(no);
	}
	
	@RequestMapping("/selectByCgNos")//通过多个采购号获取详细信息
	@ResponseBody
	public List<CgContract> selectByCgNos(String nos){
		List<CgContract> list=new ArrayList<>();
		for(int i=0;i<nos.split(",").length;i++){
			CgContract cg=cgService.selectByCgNo(nos.split(",")[i]);
			if(null!=cg){
				list.add(cg);
			}
		}
		return list;
	}
	
	@RequestMapping("/selectCgContractByWorkNo")//通过任务单过滤采购合同
	@ResponseBody
	public List<CgContract> selectCgContractByWorkNo(String no){
		no="%"+no+"%";
		List<CgContract> list=cgService.selectCgContractByWorkNo(no);
		return list;
	}
	
	@RequestMapping("/updateHistoryById") //通过id修改历史状态，prjno为当前的全部改为0，再把当前这条记录的历史状态改为1
	@ResponseBody
	public int updateHistoryById(String id){
		return cgService.updateHistoryById(id);
	}
	
	@RequestMapping("/updateCgContractById")//修改
	@ResponseBody
	public int updateCgContractById(String cgContract,@RequestParam("file") MultipartFile [] file,/*@RequestParam("file1") MultipartFile [] file1,*/HttpSession session) throws IllegalStateException, IOException{
		Map<String,Class> map2=new HashMap<>();
		map2.put("cgcl", CgCl.class);
		map2.put("accessory", Accessory.class);
		JSONObject jsonObject=JSONObject.fromObject(cgContract);
		CgContract cg=(CgContract)JSONObject.toBean(jsonObject, CgContract.class,map2);
		String id=cg.getCgId();
		
		TimeUUID uuid=new TimeUUID();
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("采购合同文本");
				list.add(accessory);
			}
			cg.setAccessory(list);
		}
		/*if(file1.length>0){
			List<Accessory> list1=new ArrayList<>();
			for(int i=0;i<file1.length;i++){
				Accessory accessory1=new Accessory();
				String fileName1=file1[i].getOriginalFilename();
				String filePath1=path+File.separator+fileName1;
				File f2=new File(filePath1);
				file1[i].transferTo(f2);
				accessory1.setaId(id);
				accessory1.setAcName(fileName1);
				accessory1.setAcUrl(id+File.separator+fileName1);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			cg.setAccessory1(list1);
		}*/
		int i=cgService.updateCgContractById(cg);
		return i;
	}
	
	@RequestMapping("/getRateAndMoney")
	@ResponseBody
	public List<BorrowContract> getRateAndMoney(String no){
		List<BorrowContract> list=cgService.getRateAndMoney(no);
		return list;
	}
	
	@RequestMapping("/updatePrjNameAndNoById")
	@ResponseBody
	public int updatePrjNameAndNoById(CgContract cg){
		return cgService.updatePrjNameAndNoById(cg);
	}
	
}

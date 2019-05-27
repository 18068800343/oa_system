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
import org.ldxx.bean.CgCl;
import org.ldxx.bean.CgContract;
import org.ldxx.bean.CgOtherContract;
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
import org.ldxx.dao.AccessoryDao;
import org.ldxx.mapper.CurrentFlowMapper;
import org.ldxx.service.CgOtherContractService;
import org.ldxx.service.CjContractService;
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

@RequestMapping("cgOtherContract")
@Controller
public class CgOtherContractController {
	
	@Autowired
	private CgOtherContractService cgoService;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private ContractReasonService cService;
	@Autowired
	CurrentFlowMapper currentFlowMapper;
	@Autowired
	private CjContractService cjService;
	@Autowired
	private AccessoryDao adao;
	
	@RequestMapping("/selectCgOtherContractByStatus")
	@ResponseBody
	public List<CgOtherContract> selectCgOtherContractByStatus(String status){
		List<CgOtherContract> list = cgoService.selectCgOtherContractByStatus(status);
		return list;
	}
	
	@RequestMapping("/addCgoContractSave")//保存
	@ResponseBody
	public int addCgOtherContractSave(String cgOtherContract,@RequestParam("file") MultipartFile [] file,@RequestParam("file1") MultipartFile [] file1,HttpSession session) throws IllegalStateException, IOException{
		Map<String,Class> map2=new HashMap<>();
		map2.put("accessory", Accessory.class);
		map2.put("accessory1", Accessory.class);
		JSONObject jsonObject=JSONObject.fromObject(cgOtherContract);
		CgOtherContract cgo=(CgOtherContract)JSONObject.toBean(jsonObject, CgOtherContract.class,map2);
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cgo.setCgoId(id);
		
		/*String type = cg.getCgcType();
		String code = type.split(" ")[0];
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		int count=cgService.cgNocount(year);
		count=count+1;
		String cgNo=uuid.getPrjCode(code, count);
		cgNo="CG"+cgNo;
		cg.setCgNo(cgNo);*/
		
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
			cgo.setAccessory(list);
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
			cgo.setAccessory1(list1);
		}
		int i=cgoService.addCgOtherContract(cgo);
		if(i>0){
			User user = (User) session.getAttribute("user");
			OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String omNoCg = oService.getOrgIdByName(cgo.getCgoDepartment()).getOmNo();
			String omNo=om.getOmNo();
			if(!"".equals(omNoCg)){
				omNo=omNoCg;
			}
			String string="";
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(cgo.getContractName()+"采购合同申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(cgo.getContractName()+"采购合同申请流程发起");
			currentFlow.setUrl("shengchanguanliLook/ProcurementOtherContract.html-"+id);
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

	
	@RequestMapping("/addCgoContractSubmit")//提交
	@ResponseBody
	public String addCgOtherContractSubmit(String cgOtherContract,@RequestParam("file") MultipartFile [] file,@RequestParam("file1") MultipartFile [] file1,HttpSession session) throws IllegalStateException, IOException{
		User user = (User) session.getAttribute("user");
		OrganizationManagement om=oService.selectOrgById(user.getOmId());
		if(null==om){
			return "-1";
		}
		Map<String,Class> map2=new HashMap<>();
		map2.put("accessory", Accessory.class);
		map2.put("accessory1", Accessory.class);
		JSONObject jsonObject=JSONObject.fromObject(cgOtherContract);
		CgOtherContract cgo=(CgOtherContract)JSONObject.toBean(jsonObject, CgOtherContract.class,map2);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cgo.setCgoId(id);
		
		/*String type = cg.getCgcType();
		String code = type.split(" ")[0];
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		int count=cgService.cgNocount(year);
		count=count+1;
		String cgNo=uuid.getPrjCode(code, count);
		cgNo="CG"+cgNo;
		cg.setCgNo(cgNo);*/
		
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
			cgo.setAccessory(list);
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
			cgo.setAccessory1(list1);
		}
		int i=cgoService.addCgOtherContract(cgo);
		String string = i+"";
		if(i>0){
			
			String omNoCg = oService.getOrgIdByName(cgo.getCgoDepartment()).getOmNo();
			String omNo=om.getOmNo();
			if(!"".equals(omNoCg)){
				omNo=omNoCg;
			}
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(cgo.getContractName()+"采购合同申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(cgo.getContractName()+"采购合同申请流程发起");
			currentFlow.setUrl("shengchanguanliLook/ProcurementOtherContract.html-"+id);
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
	
	@RequestMapping("/submitCgoCancel")//采购合同取消
	@ResponseBody
	public String submitCgCancel(ContractReason cr,String cgoName,String cgoDepartment,HttpSession session){
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
			String omNoCg = oService.getOrgIdByName(cgoDepartment).getOmNo();
			String omNo=om.getOmNo();
			if(!"".equals(omNoCg)){
				omNo=omNoCg;
			}
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setTitle(cgoName+"取消流程发起");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(cgoName+"取消流程发起");
			currentFlow.setUrl("shengchanguanliLook/ProcurementOtherContract.html-"+cr.getId());
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
	
	@RequestMapping("/submitCgoRestart")//采购合同取消
	@ResponseBody
	public String submitCgRestart(ContractReason cr,String cgoName,String cgoDepartment,HttpSession session){
		int i=cService.updateContractReasonById(cr);
		String string = i+"";
		if(i>0){
			User user = (User) session.getAttribute("user");
			OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String omNoCg = oService.getOrgIdByName(cgoDepartment).getOmNo();
			String omNo=om.getOmNo();
			if(!"".equals(omNoCg)){
				omNo=omNoCg;
			}
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setTitle(cgoName+"重新启用流程发起");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(cgoName+"重新启用流程发起");
			currentFlow.setUrl("shengchanguanliLook/ProcurementOtherContract.html-"+cr.getId());
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
	
	@RequestMapping("/deleteCgOtherContractById")
	@ResponseBody
	public int deleteCgOtherContractById(String id){
		return cgoService.deleteCgOtherContractById(id);
	}
	
	@RequestMapping("/updateCgoContractSave")
	@ResponseBody
	public int updateCgOtherContractSave(String cgOtherContract,@RequestParam("file") MultipartFile [] file,@RequestParam("file1") MultipartFile [] file1,HttpSession session) throws IllegalStateException, IOException{
		Map<String,Class> map2=new HashMap<>();
		map2.put("accessory", Accessory.class);
		map2.put("accessory1", Accessory.class);
		JSONObject jsonObject=JSONObject.fromObject(cgOtherContract);
		CgOtherContract cgo=(CgOtherContract)JSONObject.toBean(jsonObject, CgOtherContract.class,map2);
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cgo.setCgoId(id);
		
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
			cgo.setAccessory(list);
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
			cgo.setAccessory1(list1);
		}
		int i=cgoService.addCgOtherContract(cgo);
		if(i>0){
			User user = (User) session.getAttribute("user");
			//OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String departName = cgo.getCgoDepartment();
			OrganizationManagement oManagement = oService.getOrgIdByName(departName);
			String omNo=oManagement.getOmNo();
			String string="";
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(cgo.getContractName()+"采购合同变更");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(cgo.getContractName()+"采购合同变更流程发起");
			currentFlow.setUrl("shengchanguanliLook/ProcurementOtherContract.html-"+id);
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
	
	@RequestMapping("/updateCgoContractSubmit")
	@ResponseBody
	public String updateCgOtherContractSubmit(String cgOtherContract,@RequestParam("file") MultipartFile [] file,@RequestParam("file1") MultipartFile [] file1,HttpSession session) throws IllegalStateException, IOException{
		Map<String,Class> map2=new HashMap<>();
		map2.put("accessory", Accessory.class);
		map2.put("accessory1", Accessory.class);
		JSONObject jsonObject=JSONObject.fromObject(cgOtherContract);
		CgOtherContract cgo=(CgOtherContract)JSONObject.toBean(jsonObject, CgOtherContract.class,map2);
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cgo.setCgoId(id);
		
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
			cgo.setAccessory(list);
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
			cgo.setAccessory1(list1);
		}
		int i=cgoService.addCgOtherContract(cgo);
		String string = i+"";
		if(i>0){
			User user = (User) session.getAttribute("user");
			//OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String departName = cgo.getCgoDepartment();
			OrganizationManagement oManagement = oService.getOrgIdByName(departName);
			String omNo=oManagement.getOmNo();
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(cgo.getContractName()+"采购合同变更");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(cgo.getContractName()+"采购合同变更流程发起");
			currentFlow.setUrl("shengchanguanliLook/ProcurementOtherContract.html-"+id);
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
	
	@RequestMapping("/selectCgoContractById")
	@ResponseBody
	public CgOtherContract selectCgOtherContractById(String id){
		return cgoService.selectCgOtherContractById(id);
	}
	
	@RequestMapping("/selectCgoIdAndName")
	@ResponseBody
	public List<CgOtherContract> selectCgoIdAndName(){
		return cgoService.selectCgoIdAndName();
	}
	
	@RequestMapping("/selectCgonoById")
	@ResponseBody
	public CgOtherContract selectCgonoById(String id){
		return cgoService.selectCgonoById(id);
	}
	
	@RequestMapping("/selectAccessoryById")
	@ResponseBody
	public List<Accessory> selectAccessoryById(String id){
		List<Accessory> list=cgoService.selectAccessoryById(id);
		return list;
	}
	
	@RequestMapping("/deleteAccessory")
	@ResponseBody
	public int deleteAccessory(Accessory accessory){
		int i=cgoService.deleteAccessoryByIdAndName(accessory);
		if(i>0){
			File f=new File(accessory.getAcUrl());
			f.delete();
		}
		return i;
	}
	
	@RequestMapping("/selectHistoryByNo")
	@ResponseBody
	public List<CgOtherContract> selectHistoryByNo(String cgoNo){
		return cgoService.selectHistoryByNo(cgoNo);
	}
	
	@RequestMapping("/getCGoNameAndNo")//初始化合同名和合同编号、项目名和任务单号
	@ResponseBody
	public List<CgOtherContract> getCGNameAndNo(){
		List<CgOtherContract> list=cgoService.getCGoNameAndNo();
		return list;
	}
	
	@RequestMapping("/getCGoNameByNo")//通过合同编号获得合同名
	@ResponseBody
	public List<CgOtherContract> getCGoNameByNo(String cgoNo){
		return cgoService.getCGoNameByNo(cgoNo);
	}
	
	@RequestMapping("/getCGoNoByName")//通过合同名获得合同编号
	@ResponseBody
	public List<CgOtherContract> getCGoNoByName(String contractName){
		return cgoService.getCGoNoByName(contractName);
	}
	
	@RequestMapping("/getCGoNoByTaskNo")//通过任务单号获得合同编号
	@ResponseBody
	public List<CgOtherContract> getCGoNoByTaskNo(String no){
		return cgoService.getCGoNoByTaskNo(no);
	}
	
	
	@RequestMapping("/getCGoNameAndPrjNameBytaskNo")//通过任务单获得采购合同和项目名
	@ResponseBody
	public List<CgOtherContract> getCGoNameAndPrjNameBytaskNo(String no){
		return cgoService.getCGoNameAndPrjNameBytaskNo(no);
	}
	
	@RequestMapping("/getCGoNametaskNoAndByPrjName")//通过项目名获得采购合同和任务单
	@ResponseBody
	public List<CgOtherContract> getCGoNametaskNoAndByPrjName(String name){
		return cgoService.getCGoNametaskNoAndByPrjName(name);
	}
	
	@RequestMapping("/updateDepartmentMoney")//修改部门金额
	@ResponseBody
	public int updateDepartmentMoney(Double price,String id){
		return cgoService.updateDepartmentMoney(price,id);
	}
	
	@RequestMapping("/getMdById")//获取材料信息
	@ResponseBody
	public List<MaterialDemand> getMdById(String id){
		return cgoService.getMdById(id);
	}
	
	@RequestMapping("/updateMaterial")//修改材料信息
	@ResponseBody
	public int updateMaterial(MaterialDemand md){
		return cgoService.updateMaterial(md);
	}
	
	@RequestMapping("/getCGoNameCgoNoAndCgoMoney")//初始化合同名、合同编号、合同金额
	@ResponseBody
	public List<CgOtherContract> getCGoNameCgoNoAndCgoMoney(){
		List<CgOtherContract> list=cgoService.getCGoNameCgoNoAndCgoMoney();
		return list;
	}
	
	@RequestMapping("/selectByCgoNo")//通过采购号获取详细信息
	@ResponseBody
	public CgOtherContract selectByCgoNo(String no){
		return cgoService.selectByCgoNo(no);
	}
	
	@RequestMapping("/selectByCgoNos")//通过多个采购号获取详细信息
	@ResponseBody
	public List<CgOtherContract> selectByCgoNos(String nos){
		List<CgOtherContract> list=new ArrayList<>();
		for(int i=0;i<nos.split(",").length;i++){
			CgOtherContract cgo=cgoService.selectByCgoNo(nos.split(",")[i]);
			if(null!=cgo){
				list.add(cgo);
			}
		}
		return list;
	}
	
	@RequestMapping("/selectCgOtherContractByWorkNo")//通过任务单过滤采购合同
	@ResponseBody
	public List<CgOtherContract> selectCgOtherContractByWorkNo(String no){
		no="%"+no+"%";
		List<CgOtherContract> list=cgoService.selectCgOtherContractByWorkNo(no);
		return list;
	}
	
	@RequestMapping("/updateHistoryById") //通过id修改历史状态，prjno为当前的全部改为0，再把当前这条记录的历史状态改为1
	@ResponseBody
	public int updateHistoryById(String id){
		int i= cgoService.updateHistoryById(id);
		if(i>0){
			CgOtherContract cgo = cgoService.selectCgOtherContractById(id);
			String cgoNo = cgo.getCgoNo();
			if(cgoNo==null||cgoNo.equals("")){
				String type = cgo.getCgocType();
				String code = type.split(" ")[0];
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
				String year=sdf.format(new Date());
				/*TimeUUID uuid=new TimeUUID();
				int count=cgoService.cgoNocount(year);
				count=count+1;
				String cgoNo2="CGO"+uuid.getPrjCode(code, count);*/
				String cgoNo2="CQ"+year+cjService.CreateContractNumOrder("CQ", year)+code;
				i=cgoService.updatecgoNoById(id,cgoNo2);
			}
		}
		return i;
	}
	
	@RequestMapping("/updateCgoContractById")//修改
	@ResponseBody
	public int updateCgoContractById(String cgOtherContract,@RequestParam("file") MultipartFile [] file,/*@RequestParam("file1") MultipartFile [] file1,*/HttpSession session) throws IllegalStateException, IOException{
		Map<String,Class> map2=new HashMap<>();
		map2.put("accessory", Accessory.class);
		JSONObject jsonObject=JSONObject.fromObject(cgOtherContract);
		CgOtherContract cgo=(CgOtherContract)JSONObject.toBean(jsonObject, CgOtherContract.class,map2);
		String id=cgo.getCgoId();
		
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
			cgo.setAccessory(list);
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
			cgo.setAccessory1(list1);
		}*/
		int i=cgoService.updateCgOtherContractById(cgo);
		if(i>0){
			String departName = cgo.getCgoDepartment();
			OrganizationManagement oManagement = oService.getOrgIdByName(departName);
			String omNo=oManagement.getOmNo();
			currentFlowMapper.updateFkDeptByModeId(cgo.getCgoId(), omNo);
		}
		return i;
	}
	
	
	@RequestMapping("/updatePrjNameAndNoById")
	@ResponseBody
	public int updatePrjNameAndNoById(CgOtherContract cgo){
		return cgoService.updatePrjNameAndNoById(cgo);
	}
	
	@RequestMapping("/addSaoMiaoHeTong")
	@ResponseBody
	public Map<String,Object> addOtherFile(@RequestParam(value="file") MultipartFile [] file,String cgoId,HttpServletRequest request){
		Map<String,Object> map=new HashMap<>();
		TimeUUID tu=new TimeUUID();
		int result;
		String id=cgoId;
		
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

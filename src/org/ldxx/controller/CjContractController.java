package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.ldxx.bean.Accessory;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.CjDeptSplitMoney;
import org.ldxx.bean.CjSplitMoney;
import org.ldxx.bean.ContractReason;
import org.ldxx.bean.ContractWork;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.PrjWorkingHours;
import org.ldxx.bean.PrjWorkingHoursP;
import org.ldxx.bean.Task;
import org.ldxx.bean.User;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.OrganizationManagementDao;
import org.ldxx.dao.TaskDao;
import org.ldxx.mapper.CurrentFlowMapper;
import org.ldxx.service.CjContractService;
import org.ldxx.service.ContractReasonService;
import org.ldxx.service.ContractUpdateService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.TaskService;
import org.ldxx.util.CopyFile;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;


@Controller
@RequestMapping("cj")
public class CjContractController {

	@Autowired
	private CjContractService service;
	@Autowired
	private CurrentFlowMapper currentFlowMapper;
	@Autowired
	private OrganizationManagementDao omDao;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private ContractReasonService cService;
	@Autowired
	private ContractUpdateService cuService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private AccessoryDao adao;
	@Autowired
	private TaskDao taskdao;
	
	@RequestMapping("/addCjContractBySave")
	@ResponseBody
	public int addCjContractBySave(String cjContract,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2,HttpSession session) throws IllegalStateException, IOException{
		Map<String,Class> map=new HashMap<>();
		map.put("cjSplitMoney", CjSplitMoney.class);
		map.put("chaiFenXinXiArray", Task.class);
		map.put("cjDeptSplitMoney", CjDeptSplitMoney.class);
		JSONObject jsonObject=JSONObject.parseObject(cjContract);
		CjContract cj=(CjContract)JSONObject.toJavaObject(jsonObject, CjContract.class);
		
		cuService.addContractAndTaskUpdate(cj.getChaiFenXinXiArray());
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cj.setCjId(id);
	/*	SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		int count=service.countNo(year);
		String code="CJ"+uuid.getPrjCode("", count+1);
		cj.setContractNo(code);*/
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
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
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("承接合同文本");
				list.add(accessory);
			}
			cj.setAccessory(list);
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
				accessory2.setAcUrl(id+File.separator+fileName);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			cj.setAccessory2(list2);
		}
		int i=service.addCjContract(cj);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(cj.getYiCjDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(cj.getContractName()+"流程发起");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(cj.getContractName()+"流程发起");
			currentFlow.setUrl("shengchanGuanli/ContractManagementLook.html-"+id);
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
	
	
	@RequestMapping("/addCjContractBySubmit")
	@ResponseBody
	public String addCjContractBySubmit(String cjContract,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2,HttpSession session) throws IllegalStateException, IOException{
		Map<String,Class> map=new HashMap<>();
		map.put("cjSplitMoney", CjSplitMoney.class);
		map.put("chaiFenXinXiArray", Task.class);
		User user = (User) session.getAttribute("user");
		if(user==null){
			return null;
		}
		JSONObject jsonObject=JSONObject.parseObject(cjContract);
		CjContract cj=(CjContract)JSONObject.toJavaObject(jsonObject, CjContract.class);
		cuService.addContractAndTaskUpdate(cj.getChaiFenXinXiArray());
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cj.setCjId(id);
		/*SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		int count=service.countNo(year);
		String code="CJ"+uuid.getPrjCode("", count+1);
		cj.setContractNo(code);*/
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
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
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("承接合同文本");
				list.add(accessory);
			}
			cj.setAccessory(list);
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
				accessory2.setAcUrl(id+File.separator+fileName);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			cj.setAccessory2(list2);
		}
		int i=service.addCjContract(cj);
		String string = i+"";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(cj.getYiCjDepartment());
			String omNo=om.getOmNo();
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(cj.getContractName()+"流程发起");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(cj.getContractName()+"流程发起");
			currentFlow.setUrl("shengchanGuanli/ContractManagementLook.html-"+id);
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
	
	@RequestMapping("/submitCjCancel")//合同取消
	@ResponseBody
	public String submitCjCancel(String id,String stopReason,String cjName,String department,HttpSession session){
			CjContract cjc = new CjContract();
			cjc.setCjId(id);
			cjc.setCancelReason(stopReason);
		int i=0;
			i=service.updateCjContractCancelReason(cjc);
		String string = i+"";
		if(i>0){
			OrganizationManagement om=oService.getOrgIdByName(department);
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setTitle(cjName);
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(cjName+"取消流程发起");
			currentFlow.setUrl("shengchanGuanli/ContractManagementLook.html-"+cjc.getCjId());
			currentFlow.setParams("合同取消原因："+cjc.getCancelReason());
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
	
	@RequestMapping("/submitCjRestart")//合同重新启用
	@ResponseBody
	public String submitCjRestart(ContractReason cr,String cjName,String department,HttpSession session){
		int i=cService.updateContractReasonById(cr);
		String string = i+"";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(department);
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("合同重新启用原因："+cr.getRestartReason());
			currentFlow.setTitle(cjName);
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(cjName+"重新启用流程发起");
			currentFlow.setUrl("shengchanGuanli/ContractManagementLook.html-"+cr.getId());
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
	
	@RequestMapping("/selectCjContractByStatus")
	@ResponseBody
	public List<CjContract> selectCjContractByStatus(String status,String startMin,String startMax,String endMin,
			String endMax,@RequestParam(defaultValue="%")String mainDp,@RequestParam(defaultValue="%")String xbDp,@RequestParam(defaultValue="0")BigDecimal contractMoneyMin,
			@RequestParam(defaultValue="0")BigDecimal contractMoneyMax,@RequestParam(defaultValue="0")BigDecimal zdMoneyMin,
			@RequestParam(defaultValue="0")BigDecimal zdMoneyMax){
		List<CjContract> list=service.selectCjContractByStatus(status, startMin, startMax, endMin, endMax, mainDp, xbDp, contractMoneyMin, contractMoneyMax, zdMoneyMin, zdMoneyMax);
		return list;
	}
	
	@RequestMapping("/selectCjContractBySome")
	@ResponseBody
	public List<CjContract> selectCjContractBySome(String startMin,String startMax,String endMin,
			String endMax,@RequestParam(defaultValue="%")String mainDp,@RequestParam(defaultValue="%")String xbDp,@RequestParam(defaultValue="0")BigDecimal contractMoneyMin,
			@RequestParam(defaultValue="0")BigDecimal contractMoneyMax,@RequestParam(defaultValue="0")BigDecimal zdMoneyMin,
			@RequestParam(defaultValue="0")BigDecimal zdMoneyMax,String lxdateMin,String lxdateMax,@RequestParam(defaultValue="%")String erjileixing){
		List<CjContract> list=service.selectCjContractBySome(startMin,startMax,endMin,endMax,
															 mainDp,xbDp,contractMoneyMin,
															 contractMoneyMax,zdMoneyMin,zdMoneyMax,lxdateMin,lxdateMax,erjileixing);
		return list;
	}
	
	
	
	@RequestMapping("/selectIdAndName")
	@ResponseBody
	public List<CjContract> selectIdAndName(){
		List<CjContract> list=service.selectIdAndName();
		return list;
	}
	
	@RequestMapping("/selectContractNoById")
	@ResponseBody
	public List<CjContract> selectContractNoById(String id){
		List<CjContract> list=service.selectContractNoById(id);
		return list;
	}
	
	@RequestMapping("/selectCjHistory")
	@ResponseBody
	public List<CjContract> selectCjHistory(String no){
		List<CjContract> list=service.selectCjHistory(no);
		return list;
	}
	
	@RequestMapping("/selectCjHistoryById")
	@ResponseBody
	public Map<String,Object>  selectCjHistoryById(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		CjContract cj = service.selectCjContractById(id);
		String no = "";
		if(null!=cj) {
			no = cj.getContractNo();
			if(null!=no && !"".equals(no)) {
				map.put("history",true);
			}
		}
		List<CjContract> list=service.selectCjHistory(no);
		map.put("list",list);
		return map;
	}
	
	@RequestMapping("/selectContractByTaskNo")
	@ResponseBody
	public List<CjContract> selectContractByTaskNo(String no){
		List<CjContract> list=service.selectContractByTaskNo(no);
		return list;
	}
	
	@RequestMapping("/selectCjByName")
	@ResponseBody
	public List<CjContract> selectCjByName(String name){
		List<CjContract> list=service.selectCjByName(name);
		return list;
	}
	
	@RequestMapping("/selectCjByNo")
	@ResponseBody
	public List<CjContract> selectCjByNo(String no){
		List<CjContract> list=service.selectCjByNo(no);
		return list;
	}
	
	@RequestMapping("/updateCjContractBySave")
	@ResponseBody
	public int updateCjContractBySave(String cjContract,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2,HttpSession session) throws IllegalStateException, IOException{
		Map<String,Class> map=new HashMap<>();
		map.put("cjSplitMoney", CjSplitMoney.class);
		map.put("chaiFenXinXiArray", Task.class);
		JSONObject jsonObject=JSONObject.parseObject(cjContract);
		CjContract cj=(CjContract)JSONObject.toJavaObject(jsonObject, CjContract.class);
		//cuService.addContractAndTaskUpdate(cj.getChaiFenXinXiArray());
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cj.setCjId(id);
		String webApp=uuid.getWebAppFile();
		String path=webApp+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		
		//变更时复制附件
		String oldCjId = cj.getOldCjId();
		String oldCjFileName = cj.getOldCjFileName();
		List<Accessory> oldAccesslist=new ArrayList<>();
		if(oldCjFileName.indexOf(",")!= -1){//包含
			for(int x=0;x<oldCjFileName.split(",").length;x++){
				String name=oldCjFileName.split(",")[x];
				String oldpath=webApp+File.separator+oldCjId+File.separator+name;
				String newpath=webApp+File.separator+id;
				Accessory oldAccessory = adao.getAccessByIdAndName(oldCjId, name);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(name);
				accessory.setAcUrl(id+File.separator+name);
				accessory.setaType(oldAccessory.getaType());
				oldAccesslist.add(accessory);
				cj.setAccessory3(oldAccesslist);
				CopyFile.copyFile(oldpath, newpath);
			}
		}else{
			String oldpath=webApp+File.separator+oldCjId+File.separator+oldCjFileName;
			String newpath=webApp+File.separator+id;
			Accessory oldAccessory = adao.getAccessByIdAndName(oldCjId, oldCjFileName);
			Accessory accessory=new Accessory();
			accessory.setaId(id);
			accessory.setAcName(oldCjFileName);
			accessory.setAcUrl(id+File.separator+oldCjFileName);
			accessory.setaType(oldAccessory.getaType());
			oldAccesslist.add(accessory);
			cj.setAccessory3(oldAccesslist);
			CopyFile.copyFile(oldpath, newpath);
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
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("承接合同文本");
				list.add(accessory);
			}
			cj.setAccessory(list);
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
				accessory2.setAcUrl(id+File.separator+fileName);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			cj.setAccessory2(list2);
		}
		int i=service.addCjContract(cj);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(cj.getYiCjDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(cj.getContractName()+"流程发起");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(cj.getContractName()+"流程发起");
			currentFlow.setUrl("shengchanGuanli/ContractManagementLook.html-"+id);
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
	
	@RequestMapping("/updateCjContractBySubmit")
	@ResponseBody
	public String updateCjContractBySubmit(String cjContract,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2,HttpSession session) throws IllegalStateException, IOException{
		Map<String,Class> map=new HashMap<>();
		map.put("cjSplitMoney", CjSplitMoney.class);
		map.put("chaiFenXinXiArray", Task.class);
		JSONObject jsonObject=JSONObject.parseObject(cjContract);
		CjContract cj=(CjContract)JSONObject.toJavaObject(jsonObject, CjContract.class);
		int l = cuService.addContractAndTaskUpdate(cj.getChaiFenXinXiArray());
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cj.setCjId(id);
		String webApp=uuid.getWebAppFile();
		String path=webApp+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		
		//变更时复制附件
		String oldCjId = cj.getOldCjId();
		String oldCjFileName = cj.getOldCjFileName();
		List<Accessory> oldAccesslist=new ArrayList<>();
		if(oldCjFileName.indexOf(",")!= -1){//包含
			for(int x=0;x<oldCjFileName.split(",").length;x++){
				String name=oldCjFileName.split(",")[x];
				String oldpath=webApp+File.separator+oldCjId+File.separator+name;
				String newpath=webApp+File.separator+id;
				Accessory oldAccessory = adao.getAccessByIdAndName(oldCjId, name);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(name);
				accessory.setAcUrl(id+File.separator+name);
				accessory.setaType(oldAccessory.getaType());
				oldAccesslist.add(accessory);
				cj.setAccessory3(oldAccesslist);
				CopyFile.copyFile(oldpath, newpath);
			}
		}else{
			String oldpath=webApp+File.separator+oldCjId+File.separator+oldCjFileName;
			String newpath=webApp+File.separator+id;
			Accessory oldAccessory = adao.getAccessByIdAndName(oldCjId, oldCjFileName);
			if(null!=oldAccessory) {
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(oldCjFileName);
				accessory.setAcUrl(id+File.separator+oldCjFileName);
				accessory.setaType(oldAccessory.getaType());
				oldAccesslist.add(accessory);
				cj.setAccessory3(oldAccesslist);
				CopyFile.copyFile(oldpath, newpath);
			}
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
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("承接合同文本");
				list.add(accessory);
			}
			cj.setAccessory(list);
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
				accessory2.setAcUrl(id+File.separator+fileName);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			cj.setAccessory2(list2);
		}
		int i=service.addCjContract(cj);
		String string = i+"";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(cj.getYiCjDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(cj.getContractName()+"流程发起");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(cj.getContractName()+"流程发起");
			currentFlow.setUrl("shengchanGuanli/ContractManagementLook.html-"+id);
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
	
	@RequestMapping("/updateCjContractFlow")
	@ResponseBody
	public String updateCjContractFlow(String cjContract,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2,HttpSession session) throws IllegalStateException, IOException{
		Map<String,Class> map=new HashMap<>();
		map.put("cjSplitMoney", CjSplitMoney.class);
		map.put("chaiFenXinXiArray", Task.class);
		JSONObject jsonObject=JSONObject.parseObject(cjContract);
		CjContract cj=(CjContract)JSONObject.toJavaObject(jsonObject, CjContract.class);
		cuService.addContractAndTaskUpdate(cj.getChaiFenXinXiArray());
		TimeUUID uuid=new TimeUUID();
		/*String id=uuid.getTimeUUID();
		cj.setCjId(id);*/
		String id=cj.getCjId();
		String webApp=uuid.getWebAppFile();
		String path=webApp+File.separator+id;
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
				accessory.setaId(cj.getCjId());
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("承接合同文本");
				list.add(accessory);
			}
			cj.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int ii=0;ii<file2.length;ii++){
				Accessory accessory2=new Accessory();
				String fileName=file2[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[ii].transferTo(f2);
				accessory2.setaId(cj.getCjId());
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(id+File.separator+fileName);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			cj.setAccessory2(list2);
		}
		int i=service.updateCjContract(cj);
		String string = i+"";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(cj.getYiCjDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(cj.getContractName()+"流程发起");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(cj.getContractName()+"流程发起");
			currentFlow.setUrl("shengchanGuanli/ContractManagementLook.html-"+cj.getCjId());
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
	@RequestMapping("/selectNameAndNo")//初始化承接合同名和合同号
	@ResponseBody
	public List<CjContract> selectNameAndNo(){
		List<CjContract> list=service.selectNameAndNo();
		return list;
	}
	
	@RequestMapping("/selectCjContractByName")//通过承接合同名查询合同号、项目名以及任务单号
	@ResponseBody
	public CjContract selectCjContractByName(String name){
		return service.selectCjContractByName(name);
	}
	
	@RequestMapping("/selectCjContractByNo")//通过合同号查询承接合同名、项目名以及任务单号
	@ResponseBody
	public CjContract selectCjContractByNo(String no){
		CjContract cj=service.selectCjContractByNo(no);
		return cj;
	}
	
	@RequestMapping("/selectCjContractByTaskNo")//通过任务单号查询承接合同
	@ResponseBody
	public List<CjContract> selectCjContractByTaskNo(String no){
		String code="%"+no+"%";
		return service.selectCjContractByTaskNo(code);
	}
	
	@RequestMapping("/selectCjByCjNo")//通过承接编号查询承接合同详细信息
	@ResponseBody
	public CjContract selectCjByCjNo(String no){
		return service.selectCjByCjNo(no);
	}
	
	@RequestMapping("/selectCjContractById")//通过承接id查询承接合同详细信息
	@ResponseBody
	public CjContract selectCjContractById(String id){
		CjContract cjContract = service.selectCjContractById(id);
		return cjContract;
	}
	
	@RequestMapping("/updateHistoryById")
	@ResponseBody
	public int updateHistoryById(String id){
		    int i = 0;
			CjContract cj=service.selectCjContractById(id);
			String cjNo=cj.getContractNo();
			String prjType=cj.getPrjType();
			if(cjNo==null||cjNo.equals("")){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
				String year=sdf.format(new Date());
				String type="";
				if(null!=prjType&&!"".equals(prjType)){
					type = prjType.charAt(0)+"";
				}
		/*		TimeUUID uuid=new TimeUUID();
				int count=service.countNo(year);
				String code="CJ"+uuid.getPrjCode("", count+1)+prjType;*/
				String code="CJ"+year+service.CreateContractNumOrder("CJ", year)+type;
			    i=service.updateCjNoById(code, id);
			    	
			}
			i = service.updateHistoryById(id);
		return i;
	}
	
	@RequestMapping("/CreateContractNumOrder")
	@ResponseBody
	public String CreateContractNumOrder(){
		String code="CJ"+"2019"+service.CreateContractNumOrder("CJ", "2019");
		return code;
	}
	
	@RequestMapping("/updateCjContractById")
	@ResponseBody
	public int updateCjContractById(String cjContract,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2){
		Map<String,Class> map=new HashMap<>();
		JSONObject jsonObject=JSONObject.parseObject(cjContract);
		map.put("cjSplitMoney", CjSplitMoney.class);
		map.put("chaiFenXinXiArray", Task.class);
		map.put("cjDeptSplitMoney", CjDeptSplitMoney.class);
		CjContract cj=(CjContract)JSONObject.toJavaObject(jsonObject, CjContract.class);
		String id=cj.getCjId();
		TimeUUID uuid=new TimeUUID();
		String webApp=uuid.getWebAppFile();
		String path=webApp+File.separator+id;
		cuService.addContractAndTaskUpdate(cj.getChaiFenXinXiArray());
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
				try {
					file[ii].transferTo(f2);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("承接合同文本");
				list.add(accessory);
			}
			cj.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int ii=0;ii<file2.length;ii++){
				Accessory accessory2=new Accessory();
				String fileName=file2[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				try {
					file2[ii].transferTo(f2);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(id+File.separator+fileName);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			cj.setAccessory2(list2);
		}
		int i=service.updateCjContract(cj);
		if(i>0){
			String mainDept=cj.getYiCjDepartment();
			OrganizationManagement om=omDao.selectOrgById(mainDept);
			String omNo=om.getOmNo();
			int k = currentFlowMapper.updateFkDeptByModeId(id,omNo);
		}
		return i;
	}
	
	
	@RequestMapping("/selectCjDeptSplitMoney")
	@ResponseBody
	public List<CjDeptSplitMoney> selectCjDeptSplitMoney(String id,String dept){
		List<CjDeptSplitMoney> list=service.selectCjDeptSplitMoney(id, dept);
		return list;
	}
	
	@RequestMapping("/addContractUpdate")
	@ResponseBody
	public int addContractUpdate(String id){
		CjContract cjContract =service.selectCjContractById(id);
		String prjNo=cjContract.getTaskCode();
		List<Task> list=new ArrayList<Task>();
		for(int i=0;i<prjNo.split(",").length;i++){
			Task task=taskService.selectTaskPrjName(prjNo.split(",")[i]);
			list.add(task);
			if(null!=task.getContractMoneyOld()&&task.getContractMoneyOld().intValue()==0){//保留原合同金额
				taskdao.updatecontractMoneyOld(cjContract.getContractMoney(), task.getPrjNo());
			}
		}
		int i=cuService.addContractUpdate(list);
		return i;
	}
	
	//对任务单进行拆分
	@RequestMapping("/addContractUpdateTask")
	@ResponseBody
 	public int addContractUpdateTask(@RequestBody List<Task> task){
		int i=cuService.addContractUpdateMainTaskchaifen(task);
		return i;
	}
	
	@RequestMapping("/selectCjContractLikeTaskCode")
	@ResponseBody
	public CjContract selectCjContractLikeTaskCode(String no){
		CjContract cj=service.selectCjContractLikeTaskNo(no);
		return cj;
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

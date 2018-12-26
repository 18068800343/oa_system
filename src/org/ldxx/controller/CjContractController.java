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
import org.ldxx.bean.CjSplitMoney;
import org.ldxx.bean.ContractReason;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.PrjWorkingHours;
import org.ldxx.bean.PrjWorkingHoursP;
import org.ldxx.bean.User;
import org.ldxx.service.CjContractService;
import org.ldxx.service.ContractReasonService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("cj")
public class CjContractController {

	@Autowired
	private CjContractService service;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private ContractReasonService cService;
	
	@RequestMapping("/addCjContractBySave")
	@ResponseBody
	public int addCjContractBySave(String cjContract,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2,HttpSession session) throws IllegalStateException, IOException{
		Map<String,Class> map=new HashMap<>();
		map.put("cjSplitMoney", CjSplitMoney.class);
		JSONObject jsonObject=JSONObject.fromObject(cjContract);
		CjContract cj=(CjContract)JSONObject.toBean(jsonObject, CjContract.class,map);
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cj.setCjId(id);
		int count=service.countNo();
		String code="CJ"+uuid.getPrjCode("", count+1);
		cj.setContractNo(code);
		String path="D:"+File.separator+"oa"+File.separator+"CjContract"+File.separator+id;
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
				accessory2.setAcUrl(filePath);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			cj.setAccessory2(list2);
		}
		int i=service.addCjContract(cj);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(cj.getMainDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(cj.getContractName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(cj.getContractName()+"变更");
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
		JSONObject jsonObject=JSONObject.fromObject(cjContract);
		CjContract cj=(CjContract)JSONObject.toBean(jsonObject, CjContract.class,map);
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cj.setCjId(id);
		int count=service.countNo();
		String code="CJ"+uuid.getPrjCode("", count+1);
		cj.setContractNo(code);
		String path="D:"+File.separator+"oa"+File.separator+"CjContract"+File.separator+id;
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
				accessory2.setAcUrl(filePath);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			cj.setAccessory2(list2);
		}
		int i=service.addCjContract(cj);
		String string = i+"";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(cj.getMainDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(cj.getContractName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(cj.getContractName()+"变更流程发起");
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
	
	@RequestMapping("/submitCjCancel")
	@ResponseBody
	public String submitCjCancel(ContractReason cr,String cjName,String department,HttpSession session){
		int i=cService.addContractReason(cr);
		String string = i+"";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(department);
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams(cr.getStopReason());
			currentFlow.setTitle(cjName);
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(cjName+"取消流程发起");
			currentFlow.setUrl("shengchanGuanli/ContractManagementLook.html-"+cr.getId());
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
	
	
	@RequestMapping("/selectCjContractByStatus")
	@ResponseBody
	public List<CjContract> selectCjContractByStatus(String status,String startMin,String startMax,String endMin,
			String endMax,@RequestParam(defaultValue="%")String mainDp,@RequestParam(defaultValue="%")String xbDp,@RequestParam(defaultValue="0")float contractMoneyMin,
			@RequestParam(defaultValue="0")float contractMoneyMax,@RequestParam(defaultValue="0")float zdMoneyMin,
			@RequestParam(defaultValue="0")float zdMoneyMax){
		List<CjContract> list=service.selectCjContractByStatus(status, startMin, startMax, endMin, endMax, mainDp, xbDp, contractMoneyMin, contractMoneyMax, zdMoneyMin, zdMoneyMax);
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
		JSONObject jsonObject=JSONObject.fromObject(cjContract);
		CjContract cj=(CjContract)JSONObject.toBean(jsonObject, CjContract.class,map);
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cj.setCjId(id);
		String path="D:"+File.separator+"oa"+File.separator+"CjContract"+File.separator+id;
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
				accessory2.setAcUrl(filePath);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			cj.setAccessory2(list2);
		}
		int i=service.addCjContract(cj);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(cj.getMainDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(cj.getContractName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(cj.getContractName()+"变更");
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
	public int updateCjContractBySubmit(String cjContract,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2,HttpSession session) throws IllegalStateException, IOException{
		Map<String,Class> map=new HashMap<>();
		map.put("cjSplitMoney", CjSplitMoney.class);
		JSONObject jsonObject=JSONObject.fromObject(cjContract);
		CjContract cj=(CjContract)JSONObject.toBean(jsonObject, CjContract.class,map);
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cj.setCjId(id);
		String path="D:"+File.separator+"oa"+File.separator+"CjContract"+File.separator+id;
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
				accessory2.setAcUrl(filePath);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			cj.setAccessory2(list2);
		}
		int i=service.addCjContract(cj);
		String string = i+"";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(cj.getMainDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(cj.getContractName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(cj.getContractName()+"变更流程发起");
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
		return i;
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
		return service.selectCjContractByNo(no);
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
		return service.selectCjContractById(id);
	}
	
	@RequestMapping("/updateHistoryById")
	@ResponseBody
	public int updateHistoryById(String id){
		int i=service.updateHistoryById(id);
		return i;
	}
	
	@RequestMapping("/updateCjContractById")
	@ResponseBody
	public int updateCjContractById(String cjContract,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2){
		Map<String,Class> map=new HashMap<>();
		map.put("cjSplitMoney", CjSplitMoney.class);
		JSONObject jsonObject=JSONObject.fromObject(cjContract);
		CjContract cj=(CjContract)JSONObject.toBean(jsonObject, CjContract.class,map);
		String id=cj.getCjId();
		String path="D:"+File.separator+"oa"+File.separator+"CjContract"+File.separator+id;
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
				accessory.setAcUrl(filePath);
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
				accessory2.setAcUrl(filePath);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			cj.setAccessory2(list2);
		}
		int i=service.updateCjContract(cj);
		return i;
	}
	
}

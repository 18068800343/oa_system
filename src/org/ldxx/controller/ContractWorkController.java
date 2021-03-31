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
import org.ldxx.bean.ContractWork;
import org.ldxx.bean.ContractWorkTask;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.Enterprise;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.Task;
import org.ldxx.bean.User;
import org.ldxx.dao.CjContractDao;
import org.ldxx.dao.ContractWorkDao;
import org.ldxx.dao.TaskDao;
import org.ldxx.mapper.CurrentFlowMapper;
import org.ldxx.service.AccessoryService;
import org.ldxx.service.CjContractService;
import org.ldxx.service.ContractUpdateService;
import org.ldxx.service.ContractWorkService;
import org.ldxx.service.EnterpriseService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.TaskService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import net.sf.json.JSONArray;
import com.alibaba.fastjson.JSONObject;
/**
 * 合同履约下的承接合同
 * @author hp
 *
 */
@Controller
@RequestMapping("work")
public class ContractWorkController {

	@Autowired
	private ContractWorkService service;
	@Autowired
	private ContractWorkDao dao;
	@Autowired
	private EnterpriseService eservice;
	@Autowired
	private AccessoryService aservice;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private CjContractService cService;
	@Autowired
	private TaskService tService;
	@Autowired
	private ContractUpdateService cuService;
	@Autowired
	CurrentFlowMapper currentFlowMapper;
	@Autowired
	private TaskDao tdao;
	@Autowired
	private CjContractDao cDao;
	
	@RequestMapping("/addContractWorkBySave")
	@ResponseBody
	public int addContractWorkBySave( String work,@RequestParam MultipartFile [] file/*,@RequestParam MultipartFile [] file1*/) throws IllegalStateException, IOException{
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("enterprise", Enterprise.class);
		
		JSONObject jsonObject=JSONObject.parseObject(work);
		ContractWork cwork=(ContractWork)JSONObject.toJavaObject(jsonObject, ContractWork.class);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cwork.setCwId(id);
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
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
				accessory.setaType("合同文本");
				list.add(accessory);
			}
			cwork.setAccessory(list);
		}
		/*if(file1.length>0){
			List<Accessory> list1=new ArrayList<>();
			for(int ii=0;ii<file1.length;ii++){
				Accessory accessory1=new Accessory();
				String fileName=file1[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file1[ii].transferTo(f2);
				accessory1.setaId(id);
				accessory1.setAcName(fileName);
				accessory1.setAcUrl(filePath);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			cwork.setAccessory1(list1);
		}*/
		int i=service.addContractWork(cwork);
		return i;
	}
	
	@RequestMapping("/addContractWorkBySubmit")
	@ResponseBody
	public int addContractWorkBySubmit(String work,@RequestParam MultipartFile [] file/*,@RequestParam MultipartFile [] file1*/) throws IllegalStateException, IOException{
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("enterprise", Enterprise.class);
		
		JSONObject jsonObject=JSONObject.parseObject(work);
		ContractWork cwork=(ContractWork)JSONObject.toJavaObject(jsonObject, ContractWork.class);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cwork.setCwId(id);
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
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
				accessory.setaType("合同文本");
				list.add(accessory);
			}
			cwork.setAccessory(list);
		}
		/*if(file1.length>0){
			List<Accessory> list1=new ArrayList<>();
			for(int ii=0;ii<file1.length;ii++){
				Accessory accessory1=new Accessory();
				String fileName=file1[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file1[ii].transferTo(f2);
				accessory1.setaId(id);
				accessory1.setAcName(fileName);
				accessory1.setAcUrl(filePath);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			cwork.setAccessory1(list1);
		}*/
		int i=service.addContractWork(cwork);
		return i;
	}
	
	@RequestMapping("/selectContractWork")
	@ResponseBody
	public List<ContractWork> selectContractWork(String type,String status){
		List<ContractWork> list=service.selectContractWork(type,status);
		return list;
	}
	
	@RequestMapping("/selectContractWork2")
	@ResponseBody
	public List<ContractWork> selectContractWork2(String type){
		List<ContractWork> list=service.selectContractWork2(type);
		return list;
	}
	
	@RequestMapping("/selectDepartmentAndPerson")
	@ResponseBody
	public Map<String,Object> selectDepartmentAndPerson(String id){
		Map<String,Object> map =new HashMap<>();
		List<Enterprise> enterprise=eservice.selectEnterpriseById(id);
		List<Accessory> accessory=aservice.selectAccessoryById(id);
		map.put("enterprise", enterprise);
		map.put("accessory", accessory);
		return map;
	}
	
	@RequestMapping("/addContractWork2BySave")
	@ResponseBody
	public int addContractWork2BySave( String work,@RequestParam(value="file", required=false) MultipartFile [] file,@RequestParam(value="file2", required=false) MultipartFile file2,HttpSession session) throws IllegalStateException, IOException{
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("enterprise", Enterprise.class);
		classMap.put("taskArray", Task.class);
		JSONObject jsonObject=JSONObject.parseObject(work);
		ContractWork cwork=(ContractWork)JSONObject.toJavaObject(jsonObject, ContractWork.class);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cwork.setCwId(id);
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		List<Accessory> list=new ArrayList<>();
		if(file.length>0){
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[ii].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("合同文本");
				list.add(accessory);
			}
		}
		if(file2!=null){
			Accessory accessory=new Accessory();
			String fileName=file2.getOriginalFilename();
			String filePath=path+File.separator+fileName;
			File f2=new File(filePath);
			file2.transferTo(f2);
			accessory.setaId(id);
			accessory.setAcName(fileName);
			accessory.setAcUrl(id+File.separator+fileName);
			accessory.setaType("客户满意度");
			list.add(accessory);
		}
		cwork.setAccessory(list);
		/*if(file1.length>0){
			List<Accessory> list1=new ArrayList<>();
			for(int ii=0;ii<file1.length;ii++){
				Accessory accessory1=new Accessory();
				String fileName=file1[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file1[ii].transferTo(f2);
				accessory1.setaId(id);
				accessory1.setAcName(fileName);
				accessory1.setAcUrl(filePath);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			cwork.setAccessory1(list1);
		}*/
		int i=service.addContractWork(cwork);
		if(i>0){
			CjContract cj=cService.selectCjContractByNo(cwork.getCjContractCode());
			OrganizationManagement om=oService.selectOrgById(cj.getYiCjDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(cwork.getCjContractName()+"合同交工履约申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(cwork.getCjContractName()+"合同交工履约申请流程发起");
			currentFlow.setUrl("shengchanguanliLook/UndertakeContractHTLVSQ.html-"+id);
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
	
	@RequestMapping("/addContractWork2BySubmit")
	@ResponseBody
	public String addContractWork2BySubmit(String work,@RequestParam(value="file", required=false)  MultipartFile [] file,@RequestParam(value="file2", required=false)  MultipartFile file2,HttpSession session) throws IllegalStateException, IOException{
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("enterprise", Enterprise.class);
		classMap.put("taskArray", Task.class);
		JSONObject jsonObject=JSONObject.parseObject(work);
		ContractWork cwork=(ContractWork)JSONObject.toJavaObject(jsonObject, ContractWork.class);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cwork.setCwId(id);
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		List<Accessory> list=new ArrayList<>();
		if(file.length>0){
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[ii].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("合同文本");
				list.add(accessory);
			}
		}
		if(file2!=null){
			Accessory accessory=new Accessory();
			String fileName=file2.getOriginalFilename();
			String filePath=path+File.separator+fileName;
			File f2=new File(filePath);
			file2.transferTo(f2);
			accessory.setaId(id);
			accessory.setAcName(fileName);
			accessory.setAcUrl(id+File.separator+fileName);
			accessory.setaType("客户满意度");
			list.add(accessory);
		}
		cwork.setAccessory(list);
		int i=service.addContractWork(cwork);
		String string = i+"";
		if(i>0){
			CjContract cj=cService.selectCjContractByNo(cwork.getCjContractCode());
			OrganizationManagement om=oService.selectOrgById(cj.getYiCjDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(cwork.getCjContractName()+"合同交工履约申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(cwork.getCjContractName()+"合同交工履约申请流程发起");
			currentFlow.setUrl("shengchanguanliLook/UndertakeContractHTLVSQ.html-"+id);
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
	
	@RequestMapping("/updateContractWork2")
	@ResponseBody
	public int updateContractWork2(String work,@RequestParam(value="file", required=false) MultipartFile [] file,@RequestParam(value="file2", required=false) MultipartFile file2,HttpSession session) throws IllegalStateException, IOException{
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("enterprise", Enterprise.class);
		classMap.put("taskArray", Task.class);
		JSONObject jsonObject=JSONObject.parseObject(work);
		ContractWork cwork=(ContractWork)JSONObject.toJavaObject(jsonObject, ContractWork.class);
		String id=cwork.getCwId();
		TimeUUID uuid=new TimeUUID();
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		List<Accessory> list=new ArrayList<>();
		if(file.length>0){
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[ii].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("合同文本");
				list.add(accessory);
			}
		}
		if(file2!=null){
			Accessory accessory=new Accessory();
			String fileName=file2.getOriginalFilename();
			String filePath=path+File.separator+fileName;
			File f2=new File(filePath);
			file2.transferTo(f2);
			accessory.setaId(id);
			accessory.setAcName(fileName);
			accessory.setAcUrl(id+File.separator+fileName);
			accessory.setaType("客户满意度");
			list.add(accessory);
		}
		cwork.setAccessory(list);
		int i=service.updateContractWork2(cwork);
		if(i>0){
			CjContract cj=cService.selectCjContractByNo(cwork.getCjContractCode());
			OrganizationManagement om=oService.selectOrgById(cj.getYiCjDepartment());
			String omNo=om.getOmNo();
			currentFlowMapper.updateFkDeptByModeId(cwork.getCwId(), omNo);
		}
		return i;
	}
	
	@RequestMapping("/addContractWork3BySave")
	@ResponseBody
	public int addContractWork3BySave( String work,@RequestParam MultipartFile [] file/*,@RequestParam MultipartFile [] file1*/,HttpSession session) throws IllegalStateException, IOException{
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("enterprise", Enterprise.class);
		classMap.put("taskArray", Task.class);
		JSONObject jsonObject=JSONObject.parseObject(work);
		ContractWork cwork=(ContractWork)JSONObject.toJavaObject(jsonObject, ContractWork.class);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cwork.setCwId(id);
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
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
				accessory.setaType("合同文本");
				list.add(accessory);
			}
			cwork.setAccessory(list);
		}
		/*if(file1.length>0){
			List<Accessory> list1=new ArrayList<>();
			for(int ii=0;ii<file1.length;ii++){
				Accessory accessory1=new Accessory();
				String fileName=file1[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file1[ii].transferTo(f2);
				accessory1.setaId(id);
				accessory1.setAcName(fileName);
				accessory1.setAcUrl(filePath);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			cwork.setAccessory1(list1);
		}*/
		int i=service.addContractWork(cwork);
		if(i>0){
			CjContract cj=cService.selectCjContractByNo(cwork.getCjContractCode());
			OrganizationManagement om=oService.selectOrgById(cj.getYiCjDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(cwork.getCjContractName()+"合同竣工履约申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(cwork.getCjContractName()+"合同竣工履约申请流程发起");
			currentFlow.setUrl("shengchanguanliLook/UndertakeContractJGSQ.html-"+id);
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
	
	@RequestMapping("/addContractWork3BySubmit")
	@ResponseBody
	public String addContractWork3BySubmit(String work,@RequestParam MultipartFile [] file/*,@RequestParam MultipartFile [] file1*/,HttpSession session) throws IllegalStateException, IOException{
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("enterprise", Enterprise.class);
		classMap.put("taskArray", Task.class);
		JSONObject jsonObject=JSONObject.parseObject(work);
		ContractWork cwork=(ContractWork)JSONObject.toJavaObject(jsonObject, ContractWork.class);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cwork.setCwId(id);
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
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
				accessory.setaType("合同文本");
				list.add(accessory);
			}
			cwork.setAccessory(list);
		}
		/*if(file1.length>0){
			List<Accessory> list1=new ArrayList<>();
			for(int ii=0;ii<file1.length;ii++){
				Accessory accessory1=new Accessory();
				String fileName=file1[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file1[ii].transferTo(f2);
				accessory1.setaId(id);
				accessory1.setAcName(fileName);
				accessory1.setAcUrl(filePath);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			cwork.setAccessory1(list1);
		}*/
		int i=service.addContractWork(cwork);
		String string = i+"";
		if(i>0){
			CjContract cj=cService.selectCjContractByNo(cwork.getCjContractCode());
			OrganizationManagement om=oService.selectOrgById(cj.getYiCjDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(cwork.getCjContractName()+"合同竣工履约申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(cwork.getCjContractName()+"合同竣工履约申请流程发起");
			currentFlow.setUrl("shengchanguanliLook/UndertakeContractJGSQ.html-"+id);
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
	
	@RequestMapping("/updateContractWork3")
	@ResponseBody
	public int updateContractWork3(String work,@RequestParam MultipartFile [] file,HttpSession session) throws IllegalStateException, IOException{
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("enterprise", Enterprise.class);
		classMap.put("taskArray", Task.class);
		JSONObject jsonObject=JSONObject.parseObject(work);
		ContractWork cwork=(ContractWork)JSONObject.toJavaObject(jsonObject, ContractWork.class);
		String id=cwork.getCwId();
		TimeUUID uuid=new TimeUUID();
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
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
				accessory.setaType("合同文本");
				list.add(accessory);
			}
			cwork.setAccessory(list);
		}
		int i=service.updateContractWork3(cwork);
		if(i>0){
			CjContract cj=cService.selectCjContractByNo(cwork.getCjContractCode());
			OrganizationManagement om=oService.selectOrgById(cj.getYiCjDepartment());
			String omNo=om.getOmNo();
			currentFlowMapper.updateFkDeptByModeId(cwork.getCwId(), omNo);
		}
		return i;
	}
	
	
	@RequestMapping("/selectContractWorkByNo")
	@ResponseBody
	public ContractWork selectContractWorkByNo(String no){
		ContractWork cw=service.selectContractWorkByNo(no);
		return cw;
	}
	
	@RequestMapping("/getContractMoney")
	@ResponseBody
	public ContractWork getContractMoney(String no){
		ContractWork cw=service.getContractMoney(no);
		return cw;
	}
	
	@RequestMapping("/selectContractWorkByid")
	@ResponseBody
	public ContractWork selectContractWorkByid(String id){
		ContractWork cw=service.selectContractWorkByid(id);
		return cw;
	}
	
	@RequestMapping("/selectContractWorkByno")//通过承接合同编号查找结算金额和累计收款
	@ResponseBody
	public ContractWork selectContractWorkBytaskNoAndCno(String no,String type){
		ContractWork cw=service.selectContractWorkBytaskNoAndCno(no,type);
		return cw;
	}
	
	@RequestMapping("/selectContractWorkByprjNo")//通过任务单查找信息
	@ResponseBody
	public List<ContractWork> selectContractWorkByprjNo(String prjno,String type){
		String pNo="%"+prjno+"%";
		List<ContractWork> list=service.selectContractWorkByprjNo(pNo,type);
		return list;
	}
	/**
	 *  根据承接合同编号查询是否有审批完成的承接合同交工申请信息
	 * @param cjNo 承接合同编号
	 * @return
	 */
	@RequestMapping("/selectContractWorkByCjNo")
	@ResponseBody
	public List<ContractWork> selectContractWorkByCjNo(String cjNo){
		List<ContractWork> i=dao.selectContractWorkByCjNo(cjNo);
		return i;
	}
	
	/**
	 *  根据承接合同编号查询是否有审批完成的承接合同交工申请信息
	 * @param cjNo 承接合同编号
	 * @return
	 */
	@RequestMapping("/selectContractWorkByCjNoStatusIn12")
	@ResponseBody
	public List<ContractWork> selectContractWorkByCjNoStatusIn12(String cjNo,String type){
		List<ContractWork> i=dao.selectContractWorkByCjNoStatusIn12(cjNo,type);
		return i;
	}
	
	@RequestMapping("/addContractUpdate")
	@ResponseBody
	public int addContractUpdate(String id){
		ContractWork cw=service.selectContractWorkByid(id);
		String prjNo=cw.getPrjCode();
		List<Task> list=new ArrayList<Task>();
		for(int i=0;i<prjNo.split(",").length;i++){
			Task task=tService.selectTaskPrjName(prjNo.split(",")[i]);
			list.add(task);
		}
		int i=cuService.addContractUpdate(list);
		
		i=tdao.updateTasks(cw.getTaskArray());
		i=cDao.updateCjContractMoney(cw.getCjContractCode(), cw.getEndMoney());
		return i;
	}
	
}

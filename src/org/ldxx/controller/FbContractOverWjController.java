package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.Cooperator;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FbContractOverWj;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.User;
import org.ldxx.service.CjContractService;
import org.ldxx.service.FbContractOverWjService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.util.ExportData;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
/**
 * 分包合同履约
 * @author hp
 *
 */
@Controller
@RequestMapping("fbOverWj")
public class FbContractOverWjController {

	@Autowired
	private FbContractOverWjService service;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private CjContractService cService;
	
	@RequestMapping("/addFbContractOverWjBySave")
	@ResponseBody
	public int addFbContractOverWjBySave(FbContractOverWj fbContractOverWj,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file1,HttpSession session) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		fbContractOverWj.setFcowId(id);
		String path="D:"+File.separator+"oa"+File.separator+"fbContractOverWj"+File.separator+id;
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
				accessory.setaType("合同文本");
				list.add(accessory);
			}
			fbContractOverWj.setAccessory(list);
		}
		if(file1.length>0){
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
			fbContractOverWj.setAccessory1(list1);
		}
		int i=service.addFbContractOverWj(fbContractOverWj);
		if(i>0){
			CjContract cj=cService.getCjContractMainDepartmentLeader(fbContractOverWj.getCjContract());
			String mainDepartment=cj.getMainDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(fbContractOverWj.getFbContractName()+"分包合同履约");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(fbContractOverWj.getFbContractName()+"分包合同履约流程保存");
			currentFlow.setUrl("shengchanguanliLook/SubcontractPerformanceHTLY.html-"+id);
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
	
	@RequestMapping("/addFbContractOverWjBySubmit")
	@ResponseBody
	public String addFbContractOverWjBySubmit(FbContractOverWj fbContractOverWj,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file1,HttpSession session) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		fbContractOverWj.setFcowId(id);
		String path="D:"+File.separator+"oa"+File.separator+"fbContractOverWj"+File.separator+id;
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
				accessory.setaType("合同文本");
				list.add(accessory);
			}
			fbContractOverWj.setAccessory(list);
		}
		if(file1.length>0){
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
			fbContractOverWj.setAccessory1(list1);
		}
		int i=service.addFbContractOverWj(fbContractOverWj);
		String string="";
		if(i>0){
			CjContract cj=cService.getCjContractMainDepartmentLeader(fbContractOverWj.getCjContract());
			String mainDepartment=cj.getMainDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(fbContractOverWj.getFbContractName()+"分包合同履约");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(fbContractOverWj.getFbContractName()+"分包合同履约流程发起");
			currentFlow.setUrl("shengchanguanliLook/SubcontractPerformanceHTLY.html-"+id);
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
	
	@RequestMapping("/selectFbContractOverWj")
	@ResponseBody
	public List<FbContractOverWj> selectFbContractOverWj(String state){
		return service.selectFbContractOverWj(state);
	}
	
	
	@RequestMapping("/exportFbOverWj")
	@ResponseBody
	public void exportFbOverWj(HttpServletResponse response,String state) throws Exception{
		String xlsName = "分包合同履约表";  
		ExportData exportData=new ExportData();
		List<FbContractOverWj> fb=service.selectFbContractOverWj(state);
		 List<List<String>> dataList=new ArrayList<>();
		for(int i=0;i<fb.size();i++){
			List<String> data=new ArrayList<>();
			data.add(i+1+"");
			data.add(fb.get(i).getFbContractName());
			data.add(fb.get(i).getFbContract());
			data.add(fb.get(i).getPrjCode());
			data.add(fb.get(i).getPrjChargePerson());
			data.add(fb.get(i).getCjContractName());
			data.add(fb.get(i).getCjContract());
			data.add(fb.get(i).getYiFang());
			data.add(fb.get(i).getFbChargePerson());
			data.add(fb.get(i).getContractMoney()+"");
			data.add(fb.get(i).getProvisionalMoney()+"");
			data.add(fb.get(i).getOverWorkMoney()+"");
			data.add(fb.get(i).getOverWorkExplain());
			data.add(fb.get(i).getAllPayMoney()+"");
			data.add(fb.get(i).getDoAppointScore());
			data.add(fb.get(i).getPrjProbablyText());
			dataList.add(data);
		}
		String [] array={"编号","分包合同名称","分包合同","任务单号","项目负责人","承接合同名称","承接合同","合同乙方单位","分包合同负责人","合同金额","暂定金","结算金额","结算说明","累计付款","履约评级","项目概况"};
	        exportData.ExportWithResponse(xlsName,xlsName,  
	        		array.length, array, dataList, response);
	}
	
	@RequestMapping("/getAllPayMoneyByFbNo")
	@ResponseBody
	public List<FbContractOverWj> getAllPayMoneyByFbNo(String no){
		List<FbContractOverWj> fb=service.getAllPayMoneyByFbNo(no);
		return fb;
	}
	
	@RequestMapping("/selectFbContractOverWjById")
	@ResponseBody
	public FbContractOverWj selectFbContractOverWjById(String id){
		FbContractOverWj fb=service.selectFbContractOverWjById(id);
		return fb;
	}
	
}

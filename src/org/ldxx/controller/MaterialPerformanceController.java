package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CgContract;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.ProjectList;
import org.ldxx.bean.User;
import org.ldxx.bean.clfbCgcontractPerformance;
import org.ldxx.service.MaterialPerformanceService;
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
 * 材料分包合同下的采购合同履约
 * @author hp
 *
 */
@RequestMapping("materialPerformance")
@Controller
public class MaterialPerformanceController {
	
	@Autowired
	private MaterialPerformanceService mpService;
	@Autowired
	private OrganizationManagementService oService;
	
	@RequestMapping("/selectmaterialPerformanceByStatus")
	@ResponseBody
	public List<clfbCgcontractPerformance> selectmaterialPerformanceByStatus(String status){
		return mpService.selectmaterialPerformanceByStatus(status);
	}
	
	@RequestMapping("/addmaterialPerformanceSave")//添加保存
	@ResponseBody
	public Map<String,Object> addmaterialPerformanceSave(clfbCgcontractPerformance c,@RequestParam("file") MultipartFile [] file,@RequestParam("file2") MultipartFile [] file2,HttpSession session) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		c.setpId(id);
		
		String path="D:"+File.separator+"oa"+File.separator+"materialPerformance"+File.separator+id;
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
				accessory.setAcUrl(filePath);
				accessory.setaType("合同文本");
				list.add(accessory);
			}
			c.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2 = new ArrayList<>();
			for(int i=0;i<file2.length;i++){
				Accessory accessory2=new Accessory();
				String fileName=file2[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file2[i].transferTo(f1);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(filePath);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			c.setAccessory2(list2);
		}
		int i=mpService.addmaterialPerformanceSave(c);
		if(i>0){
			User user = (User) session.getAttribute("user");
			OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String omNo=om.getOmNo();
			String string="";
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(c.getCgContract()+"材料采购合同履约");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(c.getCgContract()+"材料采购合同履约流程发起");
			currentFlow.setUrl("shengchanGuanli/SubcontractMaterialHTLY.html-"+id);
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
		map.put("clfbCgcontractPerformance", c);
		return map;
	}
	
	
	@RequestMapping("/addmaterialPerformanceSubmit")//添加提交
	@ResponseBody
	public String addmaterialPerformanceSubmit(clfbCgcontractPerformance c,@RequestParam("file") MultipartFile [] file,@RequestParam("file2") MultipartFile [] file2,HttpSession session) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		c.setpId(id);
		
		String path="D:"+File.separator+"oa"+File.separator+"materialPerformance"+File.separator+id;
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
				accessory.setAcUrl(filePath);
				accessory.setaType("合同文本");
				list.add(accessory);
			}
			c.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2 = new ArrayList<>();
			for(int i=0;i<file2.length;i++){
				Accessory accessory2=new Accessory();
				String fileName=file2[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file2[i].transferTo(f1);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(filePath);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			c.setAccessory2(list2);
		}
		int i=mpService.addmaterialPerformanceSave(c);
		String string = i+"";
		if(i>0){
			User user = (User) session.getAttribute("user");
			OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String omNo=om.getOmNo();
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(c.getCgContract()+"材料采购合同履约");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(c.getCgContract()+"材料采购合同履约流程发起");
			currentFlow.setUrl("shengchanguanliLook/SubcontractMaterialHTLY.html-"+id);
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
		map.put("clfbCgcontractPerformance", c);
		return map;*/
	}
	
	@RequestMapping("/updatematerialPerformanceSave")//修改保存
	@ResponseBody
	public Map<String,Object> updatematerialPerformanceSave(clfbCgcontractPerformance c,@RequestParam("file") MultipartFile file[],@RequestParam("file2") MultipartFile [] file2) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		c.setpId(id);
		
		String path="D:"+File.separator+"oa"+File.separator+"materialPerformance"+File.separator+id;
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
			c.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2 = new ArrayList<>();
			for(int i=0;i<file2.length;i++){
				Accessory accessory2=new Accessory();
				String fileName=file2[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file2[i].transferTo(f1);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(filePath);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			c.setAccessory2(list2);
		}
		int i=mpService.addmaterialPerformanceSave(c);
		map.put("result", i);
		map.put("clfbCgcontractPerformance", c);
		return map;
	}
	
	
	@RequestMapping("/updatematerialPerformanceSubmit")//修改提交
	@ResponseBody
	public Map<String,Object> updatematerialPerformanceSubmit(clfbCgcontractPerformance c,@RequestParam("file") MultipartFile file[],@RequestParam("file2") MultipartFile [] file2) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		c.setpId(id);
		
		String path="D:"+File.separator+"oa"+File.separator+"materialPerformance"+File.separator+id;
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
			c.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2 = new ArrayList<>();
			for(int i=0;i<file2.length;i++){
				Accessory accessory2=new Accessory();
				String fileName=file2[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file2[i].transferTo(f1);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(filePath);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			c.setAccessory2(list2);
		}
		int i=mpService.addmaterialPerformanceSave(c);
		map.put("result", i);
		map.put("clfbCgcontractPerformance", c);
		return map;
	}
	
	@RequestMapping("/selectAccessoryById")
	@ResponseBody
	public List<Accessory> selectAccessoryById(String id){
		List<Accessory> list=mpService.selectAccessoryById(id);
		return list;
	}
	
	@RequestMapping("/deleteAccessory")
	@ResponseBody
	public int deleteAccessory(Accessory accessory){
		int i=mpService.deleteAccessoryByIdAndName(accessory);
		if(i>0){
			File f=new File(accessory.getAcUrl());
			f.delete();
		}
		return i;
	}
	
	
	@RequestMapping("/exportmaterialPerformance")//导出 
	@ResponseBody
	public void exportCooperator(HttpServletResponse response) throws Exception {
		String xlsName = "材料分包采购合同履约申请表";
		ExportData exportData = new ExportData();
		String status="2";
		List<clfbCgcontractPerformance> projectList = mpService.selectmaterialPerformanceByStatus(status);
		List<List<String>> dataList = new ArrayList<>();
		for (int i = 0; i < projectList.size(); i++) {
			List<String> data = new ArrayList<>();
			data.add(i + 1 + "");
			data.add(projectList.get(i).getCgNo());
			data.add(projectList.get(i).getCgContract());
			data.add(projectList.get(i).getTaskNo());
			data.add(projectList.get(i).getPrjPerson());
			data.add(projectList.get(i).getContractYi());
			data.add(projectList.get(i).getFbPerson());
			data.add(projectList.get(i).getContractMoney()+"");
			data.add(projectList.get(i).getSettlementMoney()+"");
			data.add(projectList.get(i).getSettlementDesc());
			data.add(projectList.get(i).getAccumulativePaymentMoney()+"");
			data.add(projectList.get(i).getPerformanceGrade());
			data.add(projectList.get(i).getPerformanceDesc());
			dataList.add(data);
		}
		String[] array = { "编号", "采购合同号", "采购合同名称", "任务单号", "项目负责人", "合同乙方", "分包负责人", "合同金额", "结算金额",
				"结算说明","累计付款","履约评级","项目概况、工作内容、实际工期"};
		exportData.ExportWithResponse(xlsName, xlsName, array.length, array, dataList, response);
	}
	
	@RequestMapping("/selectmaterialPerformanceById")
	@ResponseBody
	public clfbCgcontractPerformance selectmaterialPerformanceById(String id){
		return mpService.selectmaterialPerformanceById(id);
	}
}

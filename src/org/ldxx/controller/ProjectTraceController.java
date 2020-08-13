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

import javax.servlet.http.HttpSession;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ContractWork;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.Enterprise;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.ProjectScale;
import org.ldxx.bean.ProjectTrace;
import org.ldxx.bean.User;
import org.ldxx.service.AnnouncementService;
import org.ldxx.service.EnterpriseService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.ProjectScaleService;
import org.ldxx.service.ProjectTraceService;
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

/**
 * 项目跟踪单
 * @author hp
 *
 */
@Controller
@RequestMapping("trace")
public class ProjectTraceController {

	@Autowired
	private ProjectTraceService service;
	@Autowired 
	private AnnouncementService aservice;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private ProjectScaleService pService;
	@Autowired
	private EnterpriseService eService;
	
	@RequestMapping("/addProjectTraceOfSave")
	@ResponseBody
	public int addProjectTraceOfSave(String trace,@RequestParam(required=false,value="file")MultipartFile file,HttpSession session){
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("enterprise", Enterprise.class);
		
		JSONObject jsonObject=JSONObject.parseObject(trace);
		ProjectTrace pt=(ProjectTrace)JSONObject.toJavaObject(jsonObject, ProjectTrace.class);
		
		List<Accessory> list=new ArrayList<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		pt.setPtId(id);
		
		/*SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		String time=sdf.format(new Date());
		int count=service.dateCount(pt.getFillTime());
		String prjNo="GZ"+time+(count+1);
		pt.setPrjNo(prjNo);*/
		
		String type=pt.getBusinessType();
		String prjType="";
		if(type.equals("JC 检测类")){
			prjType="检测项目";
		}else if(type.equals("XJSG 新建施工")){
			prjType="新建施工";
		}else if(type.equals("JGSG 加固施工")){
			prjType="加固施工";
		}else if(type.equals("SJ 设计")){
			prjType="设计项目";
		}else if(type.equals("EPC EPC")){
			prjType="新建施工";
		}else if(type.equals("QT 其他")){
			prjType="信息化项目";
		}
		ProjectScale ps=pService.selectProjectScale(prjType, pt.getPredictPrjScale().divide(new BigDecimal(10000)));
		String scale=ps.getPrjScale();
		pt.setPrjLv(scale);
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file!=null){
			String fileName=file.getOriginalFilename();
			String path2=path+File.separator+fileName;
			File f2=new File(path2);
			
			try {
				file.transferTo(f2);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				list.add(accessory);
				pt.setAccessory(list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int i=service.addProjectTrace(pt);
		if(i>0){
			User user = (User) session.getAttribute("user");
			OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String omNo=om.getOmNo();
			String string="";
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(pt.getPrjName()+"项目跟踪单申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(pt.getPrjName()+"项目跟踪单申请流程发起");
			currentFlow.setUrl("jingyingguanliLook/ProjectTrackingGZD.html-"+id);
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
	
	
	@RequestMapping("/addProjectTraceOfSubmit")
	@ResponseBody
	public String addProjectTraceOfSubmit(String trace,@RequestParam(required=false,value="file")MultipartFile file,HttpSession session){
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("enterprise", Enterprise.class);
		
		JSONObject jsonObject=JSONObject.parseObject(trace);
		ProjectTrace pt=(ProjectTrace)JSONObject.toJavaObject(jsonObject, ProjectTrace.class);
		
		List<Accessory> list=new ArrayList<>();
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		pt.setPtId(id);
		
		/*SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		String time=sdf.format(new Date());
		int count=service.dateCount(pt.getFillTime());
		String prjNo="GZ"+time+(count+1);
		pt.setPrjNo(prjNo);*/
		
		String type=pt.getBusinessType();
		String prjType="";
		if(type.equals("JC 检测类")){
			prjType="检测项目";
		}else if(type.equals("XJSG 新建施工")){
			prjType="新建施工";
		}else if(type.equals("JGSG 加固施工")){
			prjType="加固施工";
		}else if(type.equals("SJ 设计")){
			prjType="设计项目";
		}else if(type.equals("EPC EPC")){
			prjType="新建施工";
		}else if(type.equals("QT 其他")){
			prjType="信息化项目";
		}
		ProjectScale ps=pService.selectProjectScale(prjType, pt.getPredictPrjScale().divide(new BigDecimal(10000)));
		String scale=ps.getPrjScale();
		pt.setPrjLv(scale);
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file!=null){
			String fileName=file.getOriginalFilename();
			String path2=path+File.separator+fileName;
			File f2=new File(path2);
			
			try {
				file.transferTo(f2);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				list.add(accessory);
				pt.setAccessory(list);
			} catch (Exception e) {
				e.printStackTrace();
				map.put("result", 0);
			}
		}
		int i=service.addProjectTrace(pt);
		String string = i+"";
		if(i>0){
			User user = (User) session.getAttribute("user");
			OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String omNo=om.getOmNo();
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(pt.getPrjName()+"项目跟踪单申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(pt.getPrjName()+"项目跟踪单申请流程发起");
			currentFlow.setUrl("jingyingguanliLook/ProjectTrackingGZD.html-"+id);
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
		map.put("trace", trace);
		return map;*/
	}
	
	
	@RequestMapping("/deleteProjectTrace")
	@ResponseBody
	public int deleteProjectTrace(String id){
		List<Accessory> list=aservice.selectAccessory(id);
		int i=service.deleteProjectTrace(id);
		if(i>0){
			for(int a=0;a<list.size();a++){
				File f=new File(list.get(a).getAcUrl());
				f.delete();
				f.getParentFile().delete();
			}
		}
		return i;
	}
	
	@RequestMapping("/deleteAccessory")
	@ResponseBody
	public int deleteAccessory(Accessory accessory){
		int i=aservice.deleteAccessoryByIdAndName(accessory);
		if(i>0){
			File f=new File(accessory.getAcUrl());
			f.delete();
		}
		return i;
	}
	
	
	@RequestMapping("/updateProjectTraceOfSave")
	@ResponseBody
	public int updateProjectTraceOfSave(String trace,@RequestParam(required=false,value="file")MultipartFile file,HttpSession session){
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("enterprise", Enterprise.class);
		
		JSONObject jsonObject=JSONObject.parseObject(trace);
		ProjectTrace pt=(ProjectTrace)JSONObject.toJavaObject(jsonObject, ProjectTrace.class);
		
		String type=pt.getBusinessType();
		String prjType="";
		if(type.equals("JC 检测类")){
			prjType="检测项目";
		}else if(type.equals("XJSG 新建施工")){
			prjType="新建施工";
		}else if(type.equals("JGSG 加固施工")){
			prjType="加固施工";
		}else if(type.equals("SJ 设计")){
			prjType="设计项目";
		}else if(type.equals("EPC EPC")){
			prjType="新建施工";
		}else if(type.equals("QT 其他")){
			prjType="信息化项目";
		}
		ProjectScale ps=pService.selectProjectScale(prjType, pt.getPredictPrjScale().divide(new BigDecimal(10000)));
		String scale=ps.getPrjScale();
		pt.setPrjLv(scale);
		List<Accessory> list=new ArrayList<>();
		String id=pt.getPtId();
		TimeUUID uuid=new TimeUUID();
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file!=null){
			String fileName=file.getOriginalFilename();
			String path2=path+File.separator+fileName;
			File f2=new File(path2);
			try {
				file.transferTo(f2);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				list.add(accessory);
				pt.setAccessory(list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int i=service.updateProjectTrace(pt);
		return i;
	}
	
	
	@RequestMapping("/updateProjectTraceOfSubmit")
	@ResponseBody
	public Map<String,Object> updateProjectTraceOfSubmit(ProjectTrace trace,MultipartFile file){
		List<Accessory> list=new ArrayList<>();
		Map<String,Object> map=new HashMap<>();
		String id=trace.getPtId();
		TimeUUID uuid=new TimeUUID();
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file!=null){
			String fileName=file.getOriginalFilename();
			String path2=path+File.separator+fileName;
			File f2=new File(path2);
			try {
				file.transferTo(f2);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				list.add(accessory);
				trace.setAccessory(list);
			} catch (Exception e) {
				e.printStackTrace();
				map.put("result", 0);
			}
		}
		int i=service.updateProjectTrace(trace);
		map.put("result", i);
		map.put("trace", trace);
		return map;
	}
	
	
	@RequestMapping("/selectProjectTrace")
	@ResponseBody
	public List<ProjectTrace> selectProjectTrace(String status){
		return service.selectProjectTrace(status);
	}
	
	@RequestMapping("/selectProjectTraceById")
	@ResponseBody
	public ProjectTrace selectProjectTraceById(String id){
		ProjectTrace pt=service.selectProjectTraceById(id);
		List<Enterprise> enterprise=eService.selectEnterpriseById(id);
		pt.setEnterprise(enterprise);
		return pt;
	}
	
	@RequestMapping("/selectProjectTraceByNo")
	@ResponseBody
	public ProjectTrace selectProjectTraceByNo(String no){
		return service.selectProjectTraceByNo(no);
	}
	
	@RequestMapping("/selectProjectTraceByName")
	@ResponseBody
	public ProjectTrace selectProjectTraceByName(String name){
		return service.selectProjectTraceByName(name);
	}
	
	@RequestMapping("/updateTraceEnd")
	@ResponseBody
	public int updateTraceEnd(String gzEnd,String id){
		int i=service.updateTraceEnd(gzEnd, id);
		return i;
	}
	
	@RequestMapping("/updateHistory")
	@ResponseBody
	public int updateHistory(String id){
		TimeUUID uuid=new TimeUUID();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String time=sdf.format(new Date());
		int count=service.dateCount(time);
		String prjNo=uuid.getPrjCode("", count+1);
		prjNo="GZ"+prjNo;
		int i=service.updatePrjNoById(id, prjNo);
		return i;
	}
	
}

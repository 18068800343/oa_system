package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.LianYing;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.Task;
import org.ldxx.bean.User;
import org.ldxx.service.LianYingService;
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

@Controller
@RequestMapping("/LianYing")
public class LianYingController {

	@Autowired
	private LianYingService service;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private TaskService taskService;
	
	@RequestMapping("/addLianYing")
	@ResponseBody
	public String addLianYing(LianYing ly,@RequestParam MultipartFile file,@RequestParam MultipartFile file2,@RequestParam MultipartFile file3,@RequestParam MultipartFile file4,HttpSession session) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		ly.setLyId(id);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		int count=service.lyNoCount(year);
		String lyNo="LY"+uuid.getPrjCode("", count+1);
		ly.setLyNo(lyNo);
		String path="D:"+File.separator+"oa"+File.separator+"LianYing"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		List<Accessory> list=new ArrayList<>();
		if(file!=null){
			Accessory accessory=new Accessory();
			String fileName=file.getOriginalFilename();
			String filePath=path+File.separator+fileName;
			File f2=new File(filePath);
			file.transferTo(f2);
			accessory.setaId(id);
			accessory.setAcName(fileName);
			accessory.setAcUrl(filePath);  
			accessory.setaType("资质证书");
			list.add(accessory);
		}
		if(file2!=null){
			Accessory accessory=new Accessory();
			String fileName=file2.getOriginalFilename();
			String filePath=path+File.separator+fileName;
			File f2=new File(filePath);
			file2.transferTo(f2);
			accessory.setaId(id);
			accessory.setAcName(fileName);
			accessory.setAcUrl(filePath);  
			accessory.setaType("安全生产许可证有效期");
			list.add(accessory);
		}
		if(file3!=null){
			Accessory accessory=new Accessory();
			String fileName=file3.getOriginalFilename();
			String filePath=path+File.separator+fileName;
			File f2=new File(filePath);
			file3.transferTo(f2);
			accessory.setaId(id);
			accessory.setAcName(fileName);
			accessory.setAcUrl(filePath);  
			accessory.setaType("开户许可证");
			list.add(accessory);
		}
		if(file4!=null){
			Accessory accessory=new Accessory();
			String fileName=file4.getOriginalFilename();
			String filePath=path+File.separator+fileName;
			File f2=new File(filePath);
			file4.transferTo(f2);
			accessory.setaId(id);
			accessory.setAcName(fileName);
			accessory.setAcUrl(filePath);  
			accessory.setaType("分包内容");
			list.add(accessory);
		}
		int i=service.addLianYing(ly);
		String string = i+"";
		if(i>0){
			Task t=taskService.selectIdByNo2(ly.getPrjNo());
			OrganizationManagement om=oService.selectOrgById(t.getMainDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(ly.getPrjName()+"流程发起");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(ly.getPrjName()+"流程发起");
			currentFlow.setUrl("shengchanguanliLook/lianying.html-"+id);
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
	
	@RequestMapping("/selectLianYingByStatus")
	@ResponseBody
	public List<LianYing> selectLianYingByStatus(String status){
		List<LianYing> list=service.selectLianYingByStatus(status);
		return list;
	}
	
	@RequestMapping("/selectLianYingById")
	@ResponseBody
	public LianYing selectLianYingById(String id){
		LianYing ly=service.selectLianYingById(id);
		return ly;
	}
	
}

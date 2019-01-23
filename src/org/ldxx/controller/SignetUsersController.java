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
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.SignetManage;
import org.ldxx.bean.SignetUsers;
import org.ldxx.bean.Task;
import org.ldxx.bean.User;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.ProjectSealService;
import org.ldxx.service.SignetUsersService;
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
 * 项目印章使用管理
 * @author hp
 *
 */
@Controller
@RequestMapping("signetUsers")
public class SignetUsersController {

	@Autowired
	private SignetUsersService suserService;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private TaskService tService;
	@Autowired
	private ProjectSealService pService;
	
	@RequestMapping("/selectsUser")
	@ResponseBody
	public List<SignetUsers> selectUser(String status){
		List<SignetUsers> list= suserService.selectUser(status);
		return list;
	}
	
	@RequestMapping("/addsUser")/*保存*/
	@ResponseBody
	public String addsUser(@RequestParam(value="file2",required = false)MultipartFile file2[],SignetUsers sUser,HttpSession session){
		User user = (User) session.getAttribute("user");
		if(user==null){
			return "0";
		}
		List<Accessory> list=new ArrayList<>();
		String id = new TimeUUID().getTimeUUID();
		sUser.setSuId(id);
		
		for (int i=0;i<file2.length;i++) {
			String filename = file2[i].getOriginalFilename();
			String path = "D:"+File.separator+"oa"+File.separator+"signetUsers"+File.separator+ id;
			File f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			String path1 = path + File.separator + filename;
			File f1 = new File(path1);
			try {
				file2[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(path1);
				list.add(accessory);
				sUser.setAccessory(list);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}

		}
		int i=suserService.addsUser(sUser);
		String string=i+"";
		if(i>0){
			Task task=tService.selectIdByNo2(sUser.getTaskNo());
			OrganizationManagement om=oService.selectOrgById(task.getMainDepartment());
			String omNo=om.getOmNo();
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(sUser.getUseProject()+"印章使用");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(sUser.getUseProject()+"印章使用流程发起");
			currentFlow.setUrl("xingzhengshiwuLook/YzUser.html-"+id);
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
	
	@RequestMapping("/submitsUser")/*提交*/
	@ResponseBody
	public String submitsUser(@RequestParam(value="file2",required = false)MultipartFile file2[],SignetUsers sUser,HttpSession session){
		Map<String,Object> map = new HashMap<>();
		List<Accessory> list=new ArrayList<>();
		String id = new TimeUUID().getTimeUUID();
		sUser.setSuId(id);
		
		for (int i=0;i<file2.length;i++) {
			String filename = file2[i].getOriginalFilename();
			String path = "D:"+File.separator+"oa"+File.separator+"signetUsers"+File.separator+ id;
			File f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			String path1 = path + File.separator + filename;
			File f1 = new File(path1);
			try {
				file2[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(path1);
				list.add(accessory);
				sUser.setAccessory(list);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				map.put("result", 0);
			}

		}
		int i=suserService.addsUser(sUser);
		String string = i+"";
		if(i>0){
			User user = (User) session.getAttribute("user");
			OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String omNo=om.getOmNo();
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(sUser.getUseProject()+"印章使用");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(sUser.getUseProject()+"印章使用流程发起");
			currentFlow.setUrl("xingzhengshiwuLook/ProjectSealLookSY.html-"+id);
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
	
	@RequestMapping("/deletesUserById")
	@ResponseBody
	public int deletesUserById(String suId){
		return suserService.deletesUserById(suId);
	}
	
	@RequestMapping("/deleteAccessory")
	@ResponseBody
	public int deleteAccessory(Accessory accessory){
		int i=suserService.deleteAccessoryByIdAndName(accessory);
		if(i>0){
			File f=new File(accessory.getAcUrl());
			f.delete();
		}
		return i;
	}
	
	@RequestMapping("/updatesUser")/*修改保存*/
	@ResponseBody
	public Map<String,Object> updatesUser(@RequestParam(value="file2",required = false)MultipartFile file2[],SignetUsers sUser){
		Map<String,Object> map = new HashMap<>();
		List<Accessory> list=new ArrayList<>();
		String id = sUser.getSuId();
		String path = "D:/oa/prjSeal/" + id;
		
		for(int i=0;i<file2.length;i++) {
			String filename = file2[i].getOriginalFilename();
			File f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			String path1 = path + File.separator + filename;
			File f1 = new File(path1);
			try {
				file2[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(path1);
				list.add(accessory);
				sUser.setAccessory(list);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				map.put("result", 0);
			}

		}
		int i=suserService.updatesUser(sUser);
		map.put("result", i);
		map.put("sUser", sUser);
		return map;
	}
	
	@RequestMapping("/updateSubmitsUser")/*修改提交*/
	@ResponseBody
	public Map<String,Object> updateSubmitsUser(@RequestParam(value="file2",required = false)MultipartFile file2[],SignetUsers sUser){
		Map<String,Object> map = new HashMap<>();
		List<Accessory> list=new ArrayList<>();
		String id = sUser.getSuId();
		String path = "D:/oa/prjSeal/" + id;
		
		for (int i=0;i<file2.length;i++ ) {
			String filename = file2[i].getOriginalFilename();
			File f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			String path1 = path + File.separator + filename;
			File f1 = new File(path1);
			try {
				file2[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(path1);
				list.add(accessory);
				sUser.setAccessory(list);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				map.put("result", 0);
			}

		}
		int i=suserService.updatesUser(sUser);
		map.put("result", i);
		map.put("sUser", sUser);
		return map;
	}
	
	@RequestMapping("/selectUsersById")
	@ResponseBody
	public SignetUsers selectUsersById(String suId){
		return suserService.selectUsersById(suId);
	}
	
	@RequestMapping("/selectAccessoryById")
	@ResponseBody
	public List<Accessory> selectAccessoryById(String id){
		List<Accessory> list=suserService.selectAccessoryById(id);
		return list;
	}
	
	@RequestMapping("/selectSignetNo")
	@ResponseBody
	public List<SignetManage> selectSignetNo(){
		List<SignetManage> list=suserService.selectSignetNo();
		return list;
	}
	
	@RequestMapping(value="/addHuan",produces= "text/plain;charset=UTF-8")
	@ResponseBody
	public String addHuan(SignetUsers sUser,HttpSession session){
		User user = (User) session.getAttribute("user");
		if(user==null){
			return "0";
		}
		int i=suserService.addHuan(sUser);
		String id=sUser.getSuId();
		String string=i+"";
		if(i>0){
			Task task=tService.selectIdByNo2(sUser.getTaskNo());
			OrganizationManagement om=oService.selectOrgById(task.getMainDepartment());
			String omNo=om.getOmNo();
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(sUser.getUseProject()+"印章归还");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(sUser.getUseProject()+"印章归还流程发起");
			currentFlow.setUrl("xingzhengshiwuLook/YzReturn.html-"+id);
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
				string = flowUtill.sigentReturnGetRec(currentFlow,omNo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return string;
	}
	
	
	@RequestMapping("/updateStatus")
	@ResponseBody
	public int updateStatus(String id){
		int i=suserService.updateStatus(id);
		SignetUsers su=suserService.selectUsersById(id);
		String signetNo=su.getSignetNo();
		i=pService.updateStatusByNo(signetNo,"0");
		return i;
	}
	
}

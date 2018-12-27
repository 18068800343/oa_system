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
import org.ldxx.bean.User;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.ProjectSealService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
/**
 * 项目印章管理
 * @author hp
 *
 */
@Controller
@RequestMapping("prjSeal")
public class ProjectSealController {
	
	@Autowired
	private ProjectSealService prjSealService;
	@Autowired
	private OrganizationManagementService oService;
	
	@RequestMapping("/selectPrjSeal")
	@ResponseBody
	public List<SignetManage> selectPrjSeal(String status){
		return prjSealService.selectPrjSeal(status);
	}
	
	@RequestMapping("/addPrjSea")/*添加保存印章*/
	@ResponseBody
	public Map<String,Object> addPrjSeal(SignetManage signetManage,HttpSession session){
		Map<String,Object> map = new HashMap<>();
		String id = new TimeUUID().getTimeUUID();
		signetManage.setSmId(id);
		
		int i = prjSealService.addPrjSeal(signetManage);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(signetManage.getOmId());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(signetManage.getPrjId()+"印章刻制申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(signetManage.getPrjId()+"印章刻制申请保存");
			currentFlow.setUrl("xingzhengshiwuLook/ProjectSealLookKZ.html-"+id);
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
		map.put("signetManage", signetManage);
		return map;
	}
	
	@RequestMapping("/addPrjSealSubmit")/*添加提交印章*/
	@ResponseBody
	public String addPrjSeal2(SignetManage signetManage,HttpSession session){
		Map<String,Object> map = new HashMap<>();
		String id = new TimeUUID().getTimeUUID();
		signetManage.setSmId(id);
		
		int i = prjSealService.addPrjSeal(signetManage);
		String string=i+"";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(signetManage.getOmId());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(signetManage.getPrjId()+"印章刻制申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());
			currentFlow.setMemo(signetManage.getPrjId()+"印章刻制申请流程提交");
			currentFlow.setUrl("xingzhengshiwuLook/ProjectSealLookKZ.html-"+id);
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
	
	@RequestMapping("/deletePrjSealById")
	@ResponseBody
	public int deletePrjSealById(String smId){
		return prjSealService.deletePrjSealById(smId);
	}
	
	
	@RequestMapping("/updatePrjSealById")/*修改保存*/
	@ResponseBody
	public Map<String,Object> updatePrjSealById(SignetManage signetManage){
		Map<String,Object> map = new HashMap<>();
		int i = prjSealService.updatePrjSealById(signetManage);
		map.put("result", i);
		map.put("signetManage", signetManage);
		return map;
	}
	
	@RequestMapping("/updatePrjSealByIdSubmit")/*修改提交*/
	@ResponseBody
	public Map<String,Object> updatePrjSealByIdSubmit(@RequestParam(value="file",required=false) MultipartFile file[],SignetManage signetManage){
		Map<String,Object> map = new HashMap<>();
		int i = prjSealService.updatePrjSealById(signetManage);
		map.put("result", i);
		map.put("signetManage", signetManage);
		return map;
	}
	
	@RequestMapping("/selectPrjSealById")
	@ResponseBody
	public SignetManage selectPrjSealById(String smId){
		return prjSealService.selectPrjSealById(smId);
	}
}

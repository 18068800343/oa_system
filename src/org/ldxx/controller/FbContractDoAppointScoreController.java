package org.ldxx.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.CjContract;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FbContractDoAppointScore;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.User;
import org.ldxx.service.CjContractService;
import org.ldxx.service.FbContractDoAppointScoreService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("fbScore")
public class FbContractDoAppointScoreController {

	@Autowired
	private FbContractDoAppointScoreService service;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private CjContractService cService;
	
	@RequestMapping("addFbContractDoAppointScoreBySave")
	@ResponseBody
	public int addFbContractDoAppointScoreBySave(FbContractDoAppointScore FbContractDoAppoint,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		FbContractDoAppoint.setFcdId(id);
		int i=service.addFbContractDoAppointScore(FbContractDoAppoint);
		if(i>0){
			String string ="";
			CjContract cj=cService.getCjContractMainDepartmentLeader(FbContractDoAppoint.getCjContractCode());
			String mainDepartment=cj.getMainDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(FbContractDoAppoint.getCjContractName()+"履约评价");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(FbContractDoAppoint.getCjContractName()+"履约评价流程发起");
			currentFlow.setUrl("shengchanGuanliLook/SubcontractPerformanceLYPJ.html-"+id);
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
	
	@RequestMapping("addFbContractDoAppointScoreBySubmit")
	@ResponseBody
	public String addFbContractDoAppointScoreBySubmit(FbContractDoAppointScore FbContractDoAppoint,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		FbContractDoAppoint.setFcdId(id);
		int i=service.addFbContractDoAppointScore(FbContractDoAppoint);
		String string = i+"";
		if(i>0){
			CjContract cj=cService.getCjContractMainDepartmentLeader(FbContractDoAppoint.getCjContractCode());
			String mainDepartment=cj.getMainDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(FbContractDoAppoint.getCjContractName()+"履约评价");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(FbContractDoAppoint.getCjContractName()+"履约评价流程发起");
			currentFlow.setUrl("shengchanguanliLook/SubcontractPerformanceLYPJ.html-"+id);
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
	
	@RequestMapping("selectFbContractDoAppointScore")
	@ResponseBody
	public List<FbContractDoAppointScore> selectFbContractDoAppointScore(String state){
		return service.selectFbContractDoAppointScore(state);
	}
	
	@RequestMapping("selectFbContractDoAppointScoreById")
	@ResponseBody
	public FbContractDoAppointScore selectFbContractDoAppointScoreById(String id){
		return service.selectFbContractDoAppointScoreById(id);
	}
	
}

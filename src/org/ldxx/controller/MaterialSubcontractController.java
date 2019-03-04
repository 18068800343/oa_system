package org.ldxx.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.ClfbContractEvaluate;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FbContract;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.Pay;
import org.ldxx.bean.User;
import org.ldxx.mapper.CurrentFlowMapper;
import org.ldxx.service.MaterialSubcontractService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 采购合同履约下的履约评价
 * @author hp
 *
 */

@RequestMapping("MaterialSubcontract")
@Controller
public class MaterialSubcontractController {
	
	@Autowired
	private MaterialSubcontractService msService;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	CurrentFlowMapper currentFlowMapper;
	
	
	@RequestMapping("/selectmSubcontractByStatus")//初始化履约评价
	@ResponseBody
	public List<ClfbContractEvaluate> selectmSubcontractByStatus(String status){
		return msService.selectmSubcontract(status);
	}
	
	@RequestMapping("/addmSubcontractSave")//添加保存
	@ResponseBody
	public int addmSubcontractSave(ClfbContractEvaluate c,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id = uuid.getTimeUUID();
		c.setCeId(id);
		int i=msService.addmSubcontractSave(c);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(c.getDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(c.getPrjName()+"材料采购合同履约评价");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(c.getPrjName()+"材料采购合同履约评价流程发起");
			currentFlow.setUrl("shengchanguanliLook/SubcontractMaterialLYPJ.html-"+id);
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
	
	
	@RequestMapping("/addmSubcontractSubmit")//添加提交
	@ResponseBody
	public String addmSubcontractSubmit(ClfbContractEvaluate c,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id = uuid.getTimeUUID();
		c.setCeId(id);
		
		int i=msService.addmSubcontractSave(c);
		String string = i+"";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(c.getDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(c.getPrjName()+"材料采购合同履约评价");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(c.getPrjName()+"材料采购合同履约评价流程发起");
			currentFlow.setUrl("shengchanguanliLook/SubcontractMaterialLYPJ.html-"+id);
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
	
	
	@RequestMapping("/updatemSubcontractSave")//修改保存
	@ResponseBody
	public int updatemSubcontractSave(ClfbContractEvaluate c,HttpSession session){
		int i=msService.updatemSubcontractById(c);
		return i;
		/*if(i>0){
			OrganizationManagement om=oService.selectOrgById(c.getDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(c.getPrjName()+"材料合同履约评价变更");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(c.getPrjName()+"材料合同履约评价变更流程发起");
			currentFlow.setUrl("shengchanguanliLook/SubcontractMaterialLYPJ.html-"+id);
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
		}*/
	}
	
	/*@RequestMapping("/updatemSubcontractSubmit")//修改提交
	@ResponseBody
	public String updatemSubcontractSubmit(ClfbContractEvaluate c,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id = uuid.getTimeUUID();
		c.setCeId(id);
		int i=msService.addmSubcontractSave(c);
		String string = i+"";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(c.getDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(c.getPrjName()+"材料合同履约评价变更");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(c.getPrjName()+"材料合同履约评价变更流程发起");
			currentFlow.setUrl("shengchanguanliLook/SubcontractMaterialLYPJ.html-"+id);
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
	}*/
	

	@RequestMapping("/selectmSubcontractById")
	@ResponseBody
	public ClfbContractEvaluate selectmSubcontractById(String id){
		return msService.selectmSubcontractById(id);
	}
	
	@RequestMapping("/updatemSubcontractById")//修改
	@ResponseBody
	public int updatemSubcontractById(ClfbContractEvaluate c){
		int i=msService.updatemSubcontractById(c);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(c.getDepartment());
			String omNo=om.getOmNo();
			currentFlowMapper.updateFkDeptByModeId(c.getCeId(), omNo);
		}
		return i;
	}
	
}

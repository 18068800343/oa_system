package org.ldxx.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.MaterialDemand;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.PrjMaterialBuy;
import org.ldxx.bean.User;
import org.ldxx.service.MaterialDemandService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.PrjMaterialBuyService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
* @ClassName: PrjMaterialBuyController 
* @Description: 材料采购申请
* @author zhaohui
* @date 2018年10月12日 上午10:47:30 
*  
*/

@Controller
@RequestMapping("PrjMaterialBuy")
public class PrjMaterialBuyController {

	@Autowired
	private PrjMaterialBuyService service;
	@Autowired
	private OrganizationManagementService oservice;
	@Autowired
	private MaterialDemandService mservice;
	@Autowired
	private OrganizationManagementService oService;
	
	@RequestMapping("/addPrjMaterialBuyBySave")
	@ResponseBody
	public int addPrjMaterialBuyBySave(@RequestBody PrjMaterialBuy buy,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		buy.setPmbId(id);
		int count=service.selectPrjMaterialBuyCount();
		count=count+1;
		OrganizationManagement om2=oservice.selectOrgById(buy.getApplyDepartment());
		String omNo2=om2.getOmNo();
		String taskCode=uuid.getClCode(omNo2, count);
		buy.setTaskCode(taskCode);
		int i=service.addPrjMaterialBuy(buy);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(buy.getApplyDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(buy.getApplyPrj()+"材料采购申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(buy.getApplyPrj()+"材料采购申请流程发起");
			currentFlow.setUrl("shengchanguanliLook/PurchaseApplication.html-"+id);
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
	
	@RequestMapping("/addPrjMaterialBuyBySubmit")
	@ResponseBody
	public String addPrjMaterialBuyBySubmit(@RequestBody PrjMaterialBuy buy,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		buy.setPmbId(id);
		int count=service.selectPrjMaterialBuyCount();
		OrganizationManagement om2=oservice.selectOrgById(buy.getApplyDepartment());
		String omNo2=om2.getOmNo();
		String taskCode=uuid.getClCode(omNo2, count+1);
		buy.setTaskCode(taskCode);
		int i=service.addPrjMaterialBuy(buy);
		String string = i+"";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(buy.getApplyDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(buy.getApplyPrj()+"材料采购申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(buy.getApplyPrj()+"材料采购申请流程发起");
			currentFlow.setUrl("shengchanguanliLook/PurchaseApplication.html-"+id);
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
	
	@RequestMapping("/selectPrjMaterialBuy")
	@ResponseBody
	public List<PrjMaterialBuy> selectPrjMaterialBuy(String status){
		List<PrjMaterialBuy> list=service.selectPrjMaterialBuy(status);
		return list;
	}
	
	@RequestMapping("/selectBuyCode")
	@ResponseBody
	public List<PrjMaterialBuy> selectBuyCode(){
		List<PrjMaterialBuy> list=service.selectBuyCode();
		return list;
	}
	
	@RequestMapping("/selectBuyByIds")
	@ResponseBody
	public List<PrjMaterialBuy> selectBuyByIds(String ids){
		List<PrjMaterialBuy> list=service.selectBuyByIds(ids);
		return list;
	}
	
	@RequestMapping("/updateBuy")
	@ResponseBody
	public int updateBuy(@RequestBody List<MaterialDemand> md){
		int i=mservice.updateMd(md);
		return i;
	}
	
	@RequestMapping("/selectBuyByname")//通过项目名获得材料信息
	@ResponseBody
	public List<PrjMaterialBuy> selectBuyByname(String name){
		List<PrjMaterialBuy> list=service.selectBuyByname(name);
		return list;
	}
	
	@RequestMapping("/selectDepartmentAndMoney")//获得部门名及部门金额
	@ResponseBody
	public List<PrjMaterialBuy> selectDepartmentAndMoney(){
		return service.selectDepartmentAndMoney();
	}
	
	@RequestMapping("/selectDepartmentlike")
	@ResponseBody
	public List<PrjMaterialBuy> selectDepartmentlike(String bumen){
		return service.selectDepartmentlike(bumen);
	}
	
	@RequestMapping("/selectPrjMaterialBuyById")
	@ResponseBody
	public PrjMaterialBuy selectPrjMaterialBuyById(String id){
		return service.selectPrjMaterialBuyById(id);
	}
}

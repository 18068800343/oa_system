package org.ldxx.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.BudgetFpplicationForm;
import org.ldxx.bean.CostBudget;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.PrjProgressFill;
import org.ldxx.bean.PrjProgressFillFb;
import org.ldxx.bean.User;
import org.ldxx.dao.CompanyCostDao;
import org.ldxx.dao.SecondCompanyCostDao;
import org.ldxx.mapper.CurrentFlowMapper;
import org.ldxx.service.BudgetFpplicationFormService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.PrjProgressFillService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 预算单管理
 * @author hp
 *
 */
@Controller
@RequestMapping("budge")
public class BudgetFpplicationFormController {

	@Autowired
	private BudgetFpplicationFormService bservice;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private PrjProgressFillService service;
	@Autowired
	private SecondCompanyCostDao sccDao;
	@Autowired
	private CompanyCostDao ccDao;
	@Autowired
	CurrentFlowMapper currentFlowMapper;
	
	@RequestMapping("/saveBudge")
	@ResponseBody
	public int saveBudge(@RequestBody List<BudgetFpplicationForm> budges,HttpSession session){
		Map<String,Object> map = new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		BudgetFpplicationForm budge = budges.get(0);
		budge.setBfId(id);
		/*SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		int count=bservice.countNo(year);
		String code="YS"+uuid.getPrjCode("", count+1);
		budge.setBfNo(code);*/
		int i=bservice.saveBudge(budge);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(budge.getDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(budge.getPrjId()+"预算");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(budge.getPrjId()+"预算流程发起");
			currentFlow.setUrl("shengchanguanliLook/BudgetManagement.html-"+id);
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
	
	@RequestMapping("/submitBudge")
	@ResponseBody
	public String submitBudge(@RequestBody List<BudgetFpplicationForm> budges,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		BudgetFpplicationForm budge = budges.get(0);
		budge.setBfId(id);
		/*SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		int count=bservice.countNo(year);
		String code="YS"+uuid.getPrjCode("", count+1);
		budge.setBfNo(code);*/
		int i=bservice.saveBudge(budge);
		String string = i+"";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(budge.getDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(budge.getPrjId());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(budge.getPrjId()+"预算流程发起");
			currentFlow.setUrl("shengchanguanliLook/BudgetManagement.html-"+id);
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
			flowHistroy.setActorname(user.getUsername());
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
	
	@RequestMapping("/deleteBudgeById")
	@ResponseBody
	public int deleteBudgeById(String id){
		return bservice.deleteBudgeById(id);
	}
	
	@RequestMapping("/updateBudgeSave")
	@ResponseBody
	public Map<String,Object> updateBudgeSave(@RequestBody List<BudgetFpplicationForm> budges,HttpSession session){
		Map<String,Object> map = new HashMap<>();
		BudgetFpplicationForm budge = budges.get(0);
		String newId=new TimeUUID().getTimeUUID();
		budge.setBfId(newId);
		int i=bservice.saveBudge(budge);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(budge.getDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(budge.getPrjId()+"预算变更");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(budge.getPrjId()+"预算变更");
			currentFlow.setUrl("shengchanguanliLook/BudgetManagement.html-"+newId);
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
		map.put("budge", budge);
		return map;
	}
	
	@RequestMapping("/updateBudgeSubmit")
	@ResponseBody
	public String updateBudgeSubmit(@RequestBody List<BudgetFpplicationForm> budges,HttpSession session){
		Map<String,Object> map = new HashMap<>();
		BudgetFpplicationForm budge = budges.get(0);
		String newId=new TimeUUID().getTimeUUID();
		budge.setBfId(newId);
		int i=bservice.saveBudge(budge);
		String string = i+"";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(budge.getDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(budge.getPrjId()+"预算变更");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(budge.getPrjId()+"预算变更流程发起");
			currentFlow.setUrl("shengchanguanliLook/BudgetManagement.html-"+newId);
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
			flowHistroy.setActorname(user.getUsername());
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
	
	@RequestMapping("/selectBudgeByStatus")
	@ResponseBody
	public List<BudgetFpplicationForm> selectBudgeByStatus(String status,String timeMin,String timeMax,@RequestParam(defaultValue="0")float costMin,@RequestParam(defaultValue="0")float costMax){
		return bservice.selectBudgeByStatus(status,timeMin,timeMax,costMin,costMax);
	}
	
	@RequestMapping("/selectBudgeById")
	@ResponseBody
	public BudgetFpplicationForm selectBudgeById(String id){
		return bservice.selectBudgeById(id);
	}
	
	@RequestMapping("/selectBudgeHistory")
	@ResponseBody
	public List<BudgetFpplicationForm> selectBudgeHistory(String no){
		List<BudgetFpplicationForm> budgeHistoryList=bservice.selectBudgeHistory(no);
		return budgeHistoryList;
	}
	
	@RequestMapping("/selectBudgeByNo")
	@ResponseBody
	public BudgetFpplicationForm selectBudgeByNo(String no){
		return bservice.selectBudgeByNo(no);
	}
	
	@RequestMapping("/selectBudgeByName")
	@ResponseBody
	public BudgetFpplicationForm selectBudgeByName(String name){
		return bservice.selectBudgeByName(name);
	}
	
	@RequestMapping("/getAllCost")
	@ResponseBody
	public BudgetFpplicationForm getAllCost(String no){
		BudgetFpplicationForm cost=bservice.getAllCost(no);
		return cost;
	}
	
	@RequestMapping("/updateHistoryById")
	@ResponseBody
	public int updateHistoryById(String id){
		//更改历史操作
		int i=bservice.updateHistoryById(id);
		BudgetFpplicationForm bff=bservice.selectBudgeById(id);
		if(i>0){
			BudgetFpplicationForm budgetFpplicationForm = bservice.selectBudgeById(id);
			String bfNo = budgetFpplicationForm.getBfNo();
			if(bfNo==null||"".equals(bfNo)){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
				String year=sdf.format(new Date());
				/*TimeUUID uuid=new TimeUUID();
				int count=bservice.countNo(year);
				String code="YS"+uuid.getPrjCode("", count+1);*/
				String code="YS"+year+bservice.CreateBudgetNumOrder(year);
				//budge.setBfNo(code);
				i=bservice.updateBfNoById(id,code);
			}
		}
		
		//重新计算项目进度是否预警
		double ysCost=bff.getAllCost();//预算总费用
		String taskNo=bff.getTaskNo();
		PrjProgressFill ppf=service.selectNewPlanByTaskNo(taskNo);
		if(ppf!=null){
			double prjIncome=ppf.getAllMoneyYuan();//项目累计收入
			double prjMoney=ppf.getPrjMoney();//项目金额
			
			double cost=ccDao.selectSumMoneyByNo(taskNo);//项目累计成本
			double cost2=sccDao.selectSumMoneyByNo(taskNo);//检测二部项目累计成本
			double allCost=cost+cost2;//财务累计成本
			double cwwx=0;//财务外协费
			double fbIncome=0;//分包累计收入
			List<CostBudget> cb=bservice.selectNwCostByTaskNoAndDept(taskNo, "劳务分包费");
			/*List<PrjProgressFillFb> fb=service.selectPrjProgressFillFbByPpfId(ppf.getPpfId());*/
			for(int ii=0;ii<cb.size();ii++){
				double aa=Double.valueOf(cb.get(ii).getCostAmount());
				fbIncome=fbIncome+aa;
			}
			/*累计成本=财务累计成本-财务外协费+分包累计收入（预算分包收入）*/
			double totalCost=allCost-cwwx+fbIncome;
			int status=3;
			if((totalCost/prjIncome)>(1*ysCost/prjMoney)){
				status=1;
			}
			String ppfId= ppf.getPpfId();
			i=service.updateStatusAndDesc(status, "",ppfId);
		}
		return i;
	}
	
	@RequestMapping("/CreateBudgetNumOrder")
	@ResponseBody
	public String CreateBudgetNumOrder(){
		String code="YS"+"2019"+bservice.CreateBudgetNumOrder("2019");
		return code;
	}
	
	@RequestMapping("/updateBudgetById")
	@ResponseBody
	public int updateBudgetById(@RequestBody List<BudgetFpplicationForm> budge){
		BudgetFpplicationForm b=budge.get(0);
		int i=bservice.updateBudge(b);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(b.getDepartment());
			String omNo=om.getOmNo();
			currentFlowMapper.updateFkDeptByModeId(b.getBfId(), omNo);
		}
		return i;
	}
	@RequestMapping("/selectNwCostByTaskNo")//通过任务单号和项目明细查费用总金额
	@ResponseBody
	public CostBudget selectNwCostByTaskNo(String no,String type) {
		return bservice.selectNwCostByTaskNo(no,type);
	}
	
	@RequestMapping("/selectNwCostByTaskNoAndDept")
	@ResponseBody
	public List<CostBudget> selectNwCostByTaskNoAndDept(String no,String type) {
		return bservice.selectNwCostByTaskNoAndDept(no, type);
	}
}

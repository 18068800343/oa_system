package org.ldxx.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.RiskAssessment;
import org.ldxx.bean.User;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.RiskAssessmentService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 项目风险评估
 * @author hp
 *
 */
@RequestMapping("riskAssessment")
@Controller
public class RiskAssessmentController {

	@Autowired
	private RiskAssessmentService raService;
	@Autowired
	private OrganizationManagementService oService;
	
	@RequestMapping("/addRiskAssessment")/*保存*/
	@ResponseBody
	public Map<String,Object> addRiskAssessment(RiskAssessment riskassessment,HttpSession session){
		Map<String,Object> map = new HashMap<>();
		int i =raService.isExistByprjId(riskassessment.getPrjName());
		String id = new TimeUUID().getTimeUUID();
		if(i==0){
			riskassessment.setRaId(id);
			i = raService.addRiskAssessment(riskassessment);
		}else{
			i=-2;
		}
		if(i>0){
			User user = (User) session.getAttribute("user");
			OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String omNo=om.getOmNo();
			String string="";
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(riskassessment.getPrjName()+"项目风险评估");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(riskassessment.getPrjName()+"项目风险评估申请流程发起");
			currentFlow.setUrl("jingyingguanliLook/riskAssessment.html-"+id);
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
		map.put("riskassessment", riskassessment);
		return map;
	}
	
	@RequestMapping("/addRiskAssessmentSubmit")/*提交*/
	@ResponseBody
	public String addRiskAssessmentSubmit(RiskAssessment riskassessment,HttpSession session){
		Map<String,Object> map = new HashMap<>();
		int i =raService.isExistByprjId(riskassessment.getPrjName());
		String id = new TimeUUID().getTimeUUID();
		if(i==0){
			riskassessment.setRaId(id);
			i = raService.addRiskAssessment(riskassessment);
		}else{
			i=-2;
		}
		String string = i+"";
		if(i>0){
			User user = (User) session.getAttribute("user");
			OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String omNo=om.getOmNo();
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(riskassessment.getPrjName()+"项目风险评估");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(riskassessment.getPrjName()+"项目风险评估流程发起");
			currentFlow.setUrl("jingyingguanliLook/riskAssessment.html-"+id);
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
		map.put("riskassessment", riskassessment);
		return map;*/
	}
	
	@RequestMapping("/deleteRiskAssessmentById")
	@ResponseBody
	public int deleteRiskAssessmentById(String raId){
		return raService.deleteRiskAssessmentById(raId);
	}
	
	@RequestMapping("/updateRiskAssessmentById")/*修改保存*/
	@ResponseBody
	public Map<String,Object> updateRiskAssessmentById(RiskAssessment riskassessment){
		Map<String,Object> map = new HashMap<>();
		int i =raService.countOfPrjId(riskassessment.getPrjName(),riskassessment.getRaId());
		if(i<1){
			i = raService.updateRiskAssessmentById(riskassessment);
		}else{
			i=2;
		}
		map.put("result", i);
		map.put("riskassessment", riskassessment);
		return map;
	}
	
	@RequestMapping("/updateRiskAssessmentByIdSubmit")/*修改提交*/
	@ResponseBody
	public Map<String,Object> updateRiskAssessmentByIdSubmit(RiskAssessment riskassessment){
		Map<String,Object> map = new HashMap<>();
		int i =raService.countOfPrjId(riskassessment.getPrjName(),riskassessment.getRaId());
		if(i<1){
			i = raService.updateRiskAssessmentById(riskassessment);
		}else{
			i=2;
		}
		map.put("result", i);
		map.put("riskassessment", riskassessment);
		return map;
	}
	
	@RequestMapping("/selectRiskAssessmentById")
	@ResponseBody
	public RiskAssessment selectRiskAssessmentById(String raId){
		return raService.selectRiskAssessmentById(raId);
	}
	
	@RequestMapping("/selectAllRiskAssessment")
	@ResponseBody
	public List<RiskAssessment> selectAllRiskAssessment(String status){
		return raService.selectAllRiskAssessment(status);
	}
	
	@RequestMapping("/selectRiskAssessmentPrjName")
	@ResponseBody
	public List<RiskAssessment> selectRiskAssessmentPrjName(){
		return raService.selectRiskAssessmentPrjName();
	}
	
	@RequestMapping("/selectIdByName")
	@ResponseBody
	public RiskAssessment selectIdByName(String prjName){
		return raService.selectIdByName(prjName);
	}
	
	@RequestMapping("/updateStep2")
	@ResponseBody
	public int updateStep2(String id,String step,String view){
		int i=raService.updateStep2(id, step,view);
		return i;
	}
	
	@RequestMapping("/updateStep3")
	@ResponseBody
	public int updateStep3(String id,String step,String view){
		int i=raService.updateStep3(id, step,view);
		return i;
	}
	
	@RequestMapping("/updateStep4")
	@ResponseBody
	public int updateStep4(String id,String step,String view){
		int i=raService.updateStep4(id, step,view);
		return i;
	}
	
	@RequestMapping("/updateStep5")
	@ResponseBody
	public int updateStep5(String id,String step,String view){
		int i=raService.updateStep5(id, step,view);
		return i;
	}
	
	@RequestMapping("/updateStep6")
	@ResponseBody
	public int updateStep6(String id,String step,String view){
		int i=raService.updateStep6(id, step,view);
		return i;
	}
	
}

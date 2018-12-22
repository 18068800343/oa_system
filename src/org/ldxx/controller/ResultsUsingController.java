package org.ldxx.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.ResultManagementSignet;
import org.ldxx.bean.Task;
import org.ldxx.bean.User;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.ResultsUsingService;
import org.ldxx.service.TaskService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 成果文件用印管理
 * @author hp
 *
 */

@RequestMapping("ResultsUsing")
@Controller
public class ResultsUsingController {
	
	@Autowired
	private ResultsUsingService rUsingService;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private TaskService tService;
	
	@RequestMapping("/selectResultsUsing")
	@ResponseBody
	public List<ResultManagementSignet> selectResultsUsing(String status){
		return rUsingService.selectResultsUsing(status);
	}
	
	@RequestMapping("/addResultsUsingSave")/*添加保存*/
	@ResponseBody
	public Map<String, Object> addResultsUsingSave(ResultManagementSignet rs,HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		String id=new TimeUUID().getTimeUUID();
		rs.setUsId(id);
		int i = rUsingService.addResultsUsing(rs);
		if(i>0){
			Task t=tService.selectPrjLeaderByPrjNo(rs.getUsNo());
			String mainDepartment=t.getMainDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(rs.getPrjId()+"成果文件用印");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());
			currentFlow.setMemo(rs.getPrjId()+"成果文件用印保存");
			currentFlow.setUrl("xingzhengshiwuLook/ResultsUsingLook.html-"+id);
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
		map.put("ResultManagementSignet", rs);
		return map;
	}
	
	@RequestMapping("/addResultsUsingSubmit")/*添加提交*/
	@ResponseBody
	public String addResultsUsingSubmit(ResultManagementSignet rs,HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		String id=new TimeUUID().getTimeUUID();
		rs.setUsId(id);
		int i = rUsingService.addResultsUsing(rs);
		String string = i+"";
		if(i>0){
			Task t=tService.selectPrjLeaderByPrjNo(rs.getUsNo());
			String mainDepartment=t.getMainDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(rs.getPrjId()+"成果文件用印");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(rs.getPrjId()+"成果文件用印流程发起");
			currentFlow.setUrl("xingzhengshiwuLook/ResultsUsingLook.html-"+id);
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
	
	
	@RequestMapping("/deleteResultsUsingById")
	@ResponseBody
	public int deleteResultsUsingById(String usId){
		return rUsingService.deleteResultsUsingById(usId);
	}
	
	@RequestMapping("/updateResultsUsingByIdSave")/*修改保存*/
	@ResponseBody
	public Map<String, Object> updateResultsUsingByIdSave(ResultManagementSignet rs) {
		Map<String, Object> map = new HashMap<>();
		int i = rUsingService.updateResultsUsingByIdSave(rs);
		if (i>0) {
			map.put("result", i);
			map.put("ResultManagementSignet", rs);
		}else{
			map.put("result", 0);
		}
		return map;
	}
	
	@RequestMapping("/updateResultsUsingByIdSubmit")/*修改提交*/
	@ResponseBody
	public Map<String, Object> updateResultsUsingByIdSubmit(ResultManagementSignet rs) {
		Map<String, Object> map = new HashMap<>();
		int i = rUsingService.updateResultsUsingByIdSave(rs);
		if (i>0) {
			map.put("result", i);
			map.put("ResultManagementSignet", rs);
		}else{
			map.put("result", 0);
		}
		return map;
	}

	@RequestMapping("/selectResultsUsingById")
	@ResponseBody
	public ResultManagementSignet selectResultsUsingById(String usId){
		return rUsingService.selectResultsUsingById(usId);
	}
}

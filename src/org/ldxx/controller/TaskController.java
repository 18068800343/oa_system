package org.ldxx.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.Enterprise;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.Task;
import org.ldxx.service.EnterpriseService;
import org.ldxx.service.TaskService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("task")
public class TaskController {

	@Autowired
	private TaskService tService;
	
	@Autowired
	private EnterpriseService eService;
	
	@RequestMapping("/addTask")/*任务单保存*/
	@ResponseBody
	public int addTask(@RequestBody List<Task> task){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		Task t=task.get(0);
		t.setPrjId(id);
		
		String type=t.getPrjType2();
		String code=type.split(" ")[1];
		int count=tService.typeCount(type);
		count=count+1;
		String prjNo=uuid.getPrjCode(code, count);
		
		
		/*FlowUtill flowUtill = new FlowUtill();
		CurrentFlow currentFlow = new CurrentFlow();
		currentFlow.setUrl("addTask-"+id);
		currentFlow.setParams("1");
		currentFlow.setTitle(t.getPrjName());
		currentFlow.setStarter(id);
		currentFlow.setStartername(t.getPrjName());
		currentFlow.setActor("1");
		currentFlow.setActorname("李四");
		currentFlow.setFkDept("1");
		currentFlow.setDeptname("工程建设一部");
		currentFlow.setNodename("节点名称");
		currentFlow.setPri(1);
		currentFlow.setSdtofnode(new Date());
		currentFlow.setSdtofflow(new Date());
		currentFlow.setActor("1");
		currentFlow.setActorname("张三");
		currentFlow.setMemo("测试保存");
		
		FlowHistroy flowHistroy = new FlowHistroy();
		flowHistroy.setActor(id);
		flowHistroy.setActorname(t.getPrjName());
		flowHistroy.setActorresult(0);
		flowHistroy.setView("意见");
		
		try {
			flowUtill.zancunFlow(currentFlow,flowHistroy);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		return tService.addTask(t);
	}
	
	@RequestMapping("/addTask2")/*任务单提交*/
	@ResponseBody
	public int addTask2(@RequestBody List<Task> task){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		Task t=task.get(0);
		t.setPrjId(id);
		
		String type=t.getPrjType2();
		String code=type.split(" ")[1];
		int count=tService.typeCount(type);
		count=count+1;
		String prjNo=uuid.getPrjCode(code, count);
		
		/*FlowUtill flowUtill = new FlowUtill();
		CurrentFlow currentFlow = new CurrentFlow();
		currentFlow.setUrl("addTask2-"+id);
		currentFlow.setParams("1");
		currentFlow.setTitle(t.getPrjName());
		currentFlow.setStarter(id);
		currentFlow.setStartername(t.getPrjName());
		currentFlow.setFkDept("1");
		currentFlow.setDeptname("工程建设二部");
		currentFlow.setNodename("节点名称");
		currentFlow.setPri(1);
		currentFlow.setSdtofnode(new Date());
		currentFlow.setSdtofflow(new Date());
		currentFlow.setActor("1");
		currentFlow.setActorname("李四");
		currentFlow.setMemo("测试提交");
		
		FlowHistroy flowHistroy = new FlowHistroy();
		flowHistroy.setActor(id);
		flowHistroy.setActorname(t.getPrjName());
		flowHistroy.setActorresult(0);
		flowHistroy.setView("意见");
		
		try {
			flowUtill.submitFlow(currentFlow,flowHistroy,"张三","7dad936dce6a");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		return tService.addTask(t);
	}
	
	@RequestMapping("/addTask3")/*任务单保存*/
	@ResponseBody
	public String addTask3(@RequestBody List<Task> task){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		Task t=task.get(0);
		t.setPrjId(id);
		
		FlowUtill flowUtill = new FlowUtill();
		CurrentFlow currentFlow = new CurrentFlow();
		currentFlow.setUrl("shengchanGuanli/TaskManagementLook.html-"+id);
		currentFlow.setParams("1");
		currentFlow.setTitle(t.getPrjName());
		currentFlow.setActor("88b6f133f129");
		currentFlow.setActorname("索隆");;
		currentFlow.setMemo("流程发起");
		currentFlow.setUrl("shengchanGuanli/TaskManagementLook.html-"+id);
		currentFlow.setParams("{'cs':'1'}");
		currentFlow.setStarter("88b6f133f129");
		currentFlow.setStartername("索隆");
		currentFlow.setFkDept("1");
		currentFlow.setDeptname("工程建设一部");
		currentFlow.setNodename("节点名称");
		currentFlow.setPri(1);
		currentFlow.setSdtofnode(new Date());
		currentFlow.setSdtofflow(new Date());
		
		FlowHistroy flowHistroy = new FlowHistroy();
		flowHistroy.setActor(id);
		flowHistroy.setActorname(t.getPrjName());
		flowHistroy.setActorresult(0);
		flowHistroy.setView("意见");
		tService.addTask(t);
		String string = "";
		try {
			string = flowUtill.submitGetReceiver(currentFlow);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return string;
	}
	
	@RequestMapping("/addTask4")/*任务单保存*/
	@ResponseBody
	public String addTask4(String url,String userId,String uName){
		FlowUtill flowUtill = new FlowUtill();
		CurrentFlow currentFlow = new CurrentFlow();
		currentFlow.setUrl(url);
		FlowHistroy	flowHistroy = new FlowHistroy();
	    flowHistroy.setActor("4136c78ab4d5");
	    flowHistroy.setActorname("萨姆");
	    flowHistroy.setView("发起流程");
	    flowHistroy.setId(new TimeUUID().getTimeUUID());
		String string = "";
		try {
			string = flowUtill.submitFlow(currentFlow, flowHistroy, userId, uName);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return string;
	}
	
	@RequestMapping("/deleteTask")
	@ResponseBody
	public int deleteTask(String id){
		return tService.deleteTask(id);
	}
	
	@RequestMapping("/updateTask")/*任务单修改保存*/
	@ResponseBody
	public int updateTask(@RequestBody List<Task> task){
		Task t=task.get(0);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		t.setPrjId(id);
		return tService.addTask(t);
	}
	
	@RequestMapping("/updateTask2")/*任务单修改提交*/
	@ResponseBody
	public int updateTask2(@RequestBody List<Task> task){
		Task t=task.get(0);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		t.setPrjId(id);
		return tService.addTask(t);
	}
	
	
	@RequestMapping("/selectTaskByStatus")
	@ResponseBody
	public List<Task>selectTaskByStatus(String status){
		return tService.selectTaskByStatus(status);
	}
	
	@RequestMapping("/selectIdAndNameByStatus")
	@ResponseBody
	public List<Task> selectIdAndNameByStatus(String status){
		return tService.selectIdAndNameByStatus(status);
	}
	
	@RequestMapping("/selectTaskById")
	@ResponseBody
	public Task selectTaskById(String id){
		return tService.selectTaskById(id);
	}
	
	@RequestMapping("/selectTaskHistory")
	@ResponseBody
	public Map<String,Object> selectTaskHistory(String id,String no){
		Map<String,Object> map=new HashMap<>();
		Task t=tService.selectTaskById(id);
		map.put("task", t);
		List<Task> list=tService.selectTaskHistory(no);
		map.put("taskList", list);
		return map;
	}
	
	@RequestMapping("/taskOff") /*任务单中止*/
	@ResponseBody
	public int taskOff(){
		return 0;
	}
	
	@RequestMapping("/taskOk")/*任务单履约完成*/
	@ResponseBody
	public int taskOk(){
		return 0;
	}
	
	@RequestMapping("/getEnterpriseById")
	@ResponseBody
	public List<Enterprise> getEnterpriseById(String id){
		List<Enterprise> list=eService.selectEnterpriseById(id);
		return list;
	}
	
	@RequestMapping("/getEnterpriseByIdAndName")
	@ResponseBody
	public List<Enterprise> getEnterpriseByIdAndName(String id,String name){
		List<Enterprise> list=eService.selectEnterpriseByIdAndName(id, name);
		return list;
	}
	
	@RequestMapping("/selectCcNameByPrjId")
	@ResponseBody
	public Task selectCcNameByPrjId(String id){
		return tService.selectCcNameByPrjId(id);
	}
	
	@RequestMapping("/selectPrjNameAndWorkNo")
	@ResponseBody
	public List<Task> selectPrjNameAndWorkNo(){
		return tService.selectPrjNameAndWorkNo();
	}
	
	@RequestMapping("/selectTaskPrjName")
	@ResponseBody
	public Task selectTaskPrjName(String prjNo){
		return tService.selectTaskPrjName(prjNo);
	}
	
	@RequestMapping("/selectTaskPrjNo")
	@ResponseBody
	public Task selectTaskPrjNo(String prjName){
		return tService.selectTaskPrjNo(prjName);
	}
	
}

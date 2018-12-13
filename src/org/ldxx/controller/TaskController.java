package org.ldxx.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.reflection.wrapper.BaseWrapper;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.ConstructionDocuments;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.CurrentFlowExample;
import org.ldxx.bean.DesignDocuments;
import org.ldxx.bean.Enterprise;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.MaintenanceReinforcement;
import org.ldxx.bean.Task;
import org.ldxx.bean.TechnicalDocumentation;
import org.ldxx.bean.TestingEvaluation;
import org.ldxx.dao.ConstructionDocumentsDao;
import org.ldxx.dao.DesignDocumentsDao;
import org.ldxx.dao.MaintenanceReinforcementDao;
import org.ldxx.dao.TechnicalDocumentationDao;
import org.ldxx.dao.TestingEvaluationDao;
import org.ldxx.mapper.CurrentFlowMapper;
import org.ldxx.service.CjContractService;
import org.ldxx.service.EnterpriseService;
import org.ldxx.service.TaskService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("task")
public class TaskController {

	@Autowired
	private TaskService tService;
	@Autowired
	private EnterpriseService eService;
	@Autowired
	private CurrentFlowMapper currentFlowMapper;
	@Autowired
	private CjContractService cjservice;
	@Autowired
	private ConstructionDocumentsDao cDao;
	@Autowired
	private DesignDocumentsDao dDao;
	@Autowired
	private TestingEvaluationDao tDao;
	@Autowired
	private MaintenanceReinforcementDao mDao;
	@Autowired
	private TechnicalDocumentationDao dao;
	
	@RequestMapping("/addTask")/*任务单保存*/
	@ResponseBody
	public int addTask(@RequestBody List<Task> task){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		Task t=task.get(0);
		
		t.setPrjId(id);
		
		String type=t.getPrjType2();
		String code=type.split(" ")[0];
		int count=tService.typeCount();
		count=count+1;
		String prjNo=uuid.getPrjCode(code, count);
		t.setPrjNo(prjNo);
		int i=tService.addTask(t);
		if(i>0){
			String prjName=t.getPrjName();
			if(code.startsWith("A")){//添加检测评估资料
				TestingEvaluation te=new TestingEvaluation();
				te.setTeId(uuid.getTimeUUID());
				te.setPrjName(prjName);
				te.setPrjNo(prjNo);
				tDao.addTestingEvaluationSave(te);
			}else if(code.startsWith("B")){
				if(code.equals("B3")){//添加维修加固设计资料
					MaintenanceReinforcement mr=new MaintenanceReinforcement();
					mr.setMrId(uuid.getTimeUUID());
					mr.setPrjName(prjName);
					mr.setPrjNo(prjNo);
					mDao.addMaintenanceReinforcement(mr);
				}else{//添加设计文件资料
					DesignDocuments dd=new DesignDocuments();
					dd.setDdId(uuid.getTimeUUID());
					dd.setPrjName(prjName);
					dd.setPrjNo(prjNo);
					dDao.addDesignDocumentsSave(dd);
				}
			}else if(code.startsWith("C")){//添加施工文档资料
				ConstructionDocuments cd=new ConstructionDocuments();
				cd.setCdId(uuid.getTimeUUID());
				cd.setPrjName(prjName);
				cd.setPrjNo(prjNo);
				cDao.addConstructionDocumentsSave(cd);
			}else if(code.startsWith("K")){//添加科技文档资料
				TechnicalDocumentation td=new TechnicalDocumentation();
				td.setTdId(uuid.getTimeUUID());
				td.setPrjName(prjName);
				td.setPrjNo(prjNo);
				dao.addConstructionDocumentsSave(td);
			}
		}
		FlowUtill flowUtill = new FlowUtill();
		CurrentFlow currentFlow = new CurrentFlow();
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
		currentFlow.setFlowEndState(2);
		FlowHistroy flowHistroy = new FlowHistroy();
		flowHistroy.setActor(id);
		flowHistroy.setActorname(t.getPrjName());
		flowHistroy.setActorresult(0);
		flowHistroy.setView("意见");
		String string = "";
		try {
			string = flowUtill.zancunFlow(currentFlow, flowHistroy);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	@RequestMapping("/addTask2")/*任务单提交*/
	@ResponseBody
	public String addTask2(@RequestBody List<Task> task){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		Task t=task.get(0);
		
		t.setPrjId(id);
		
		String type=t.getPrjType2();
		String code=type.split(" ")[0];
		int count=tService.typeCount();
		count=count+1;
		String prjNo=uuid.getPrjCode(code, count);
		t.setPrjNo(prjNo);
		int i=tService.addTask(t);
		if(i>0){
			String prjName=t.getPrjName();
			if(code.startsWith("A")){//添加检测评估资料
				TestingEvaluation te=new TestingEvaluation();
				te.setTeId(uuid.getTimeUUID());
				te.setPrjName(prjName);
				te.setPrjNo(prjNo);
				tDao.addTestingEvaluationSave(te);
			}else if(code.startsWith("B")){
				if(code.equals("B3")){//添加维修加固设计资料
					MaintenanceReinforcement mr=new MaintenanceReinforcement();
					mr.setMrId(uuid.getTimeUUID());
					mr.setPrjName(prjName);
					mr.setPrjNo(prjNo);
					mDao.addMaintenanceReinforcement(mr);
				}else{//添加设计文件资料
					DesignDocuments dd=new DesignDocuments();
					dd.setDdId(uuid.getTimeUUID());
					dd.setPrjName(prjName);
					dd.setPrjNo(prjNo);
					dDao.addDesignDocumentsSave(dd);
				}
			}else if(code.startsWith("C")){//添加施工文档资料
				ConstructionDocuments cd=new ConstructionDocuments();
				cd.setCdId(uuid.getTimeUUID());
				cd.setPrjName(prjName);
				cd.setPrjNo(prjNo);
				cDao.addConstructionDocumentsSave(cd);
			}else if(code.startsWith("K")){//添加科技文档资料
				TechnicalDocumentation td=new TechnicalDocumentation();
				td.setTdId(uuid.getTimeUUID());
				td.setPrjName(prjName);
				td.setPrjNo(prjNo);
				dao.addConstructionDocumentsSave(td);
			}
		}
		FlowUtill flowUtill = new FlowUtill();
		CurrentFlow currentFlow = new CurrentFlow();
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
		currentFlow.setFlowEndState(2);
		FlowHistroy flowHistroy = new FlowHistroy();
		flowHistroy.setActor(id);
		flowHistroy.setActorname(t.getPrjName());
		flowHistroy.setActorresult(0);
		flowHistroy.setView("意见");
		String string = "";
		try {
			string = flowUtill.submitGetReceiver(currentFlow);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return string;
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
	    flowHistroy.setActor("88b6f133f129");
	    flowHistroy.setActorname("索隆");
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
	
	@RequestMapping("/addTask5")/*任务单保存*/
	@ResponseBody
	public String addTask5(String url,String userId,String uName,String omName){
		FlowUtill flowUtill = new FlowUtill();
		CurrentFlow currentFlow = new CurrentFlow();
		currentFlow.setUrl(url);
		currentFlow.setDeptname(omName);
		FlowHistroy	flowHistroy = new FlowHistroy();
	    flowHistroy.setActor("88b6f133f129");
	    flowHistroy.setActorname("索隆");
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
	public List<Task>selectTaskByStatus(String status,String startMin,String startMax,String endMin,
			String endMax,String mainDp,String xbDp,@RequestParam(defaultValue="0")float prjMoneyMin,@RequestParam(defaultValue="0")float prjMoneyMax,
			@RequestParam(defaultValue="0")float contractMoneyMin,@RequestParam(defaultValue="0")float contractMoneyMax,
			@RequestParam(defaultValue="0")float zdMoneyMin,@RequestParam(defaultValue="0")float zdMoneyMax){
		return tService.selectTaskByStatus(status, startMin, startMax, endMin, endMax, mainDp, xbDp, prjMoneyMin, prjMoneyMax, contractMoneyMin, contractMoneyMax, zdMoneyMin, zdMoneyMax);
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
	public List<Task> selectTaskPrjName(String prjNo){
		List<Task> list=new ArrayList<Task>();
		for(int i=0;i<prjNo.split(",").length;i++){
			Task task=tService.selectTaskPrjName(prjNo.split(",")[i]);
			list.add(task);
		}
		return list;
	}
	
	@RequestMapping("/selectTaskPrjNo")
	@ResponseBody
	public List<Task> selectTaskPrjNo(String prjName){
		List<Task> list=new ArrayList<Task>();
		for(int i=0;i<prjName.split(",").length;i++){
			Task task=tService.selectTaskPrjNo(prjName.split(",")[i]);
			list.add(task);
		}
		return list;
	}
	
	@RequestMapping("/getReceiver")/*任务单保存*/
	@ResponseBody
	public String getReceiver(String url){
		String string = "";
		CurrentFlowExample example = new CurrentFlowExample();
		example.createCriteria().andUrlEqualTo(url);
		List<CurrentFlow> currentFlows = currentFlowMapper.selectByExample(example);
		FlowUtill flowUtill = new FlowUtill();
		try {
			string = flowUtill.shenpiGetReceiver(currentFlows.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return string;
	}
	@RequestMapping("/tuiHui")/*任务单保存*/
	@ResponseBody
	public String tuiHui(String url,String view){
		FlowUtill flowUtill = new FlowUtill();
		String currentFlowId = "";
		String result = "";
		try {
			currentFlowId = url.split("-")[1];
			result = flowUtill.TuiHuiFlow(currentFlowId, view);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@RequestMapping("/selectCjByTaskName")
	@ResponseBody
	public Map<String,Object> selectCjByTaskName(String name){
		Map<String,Object> map=new HashMap<>();
		Task task=tService.selectNoByName(name);
		String code="%"+task.getPrjNo()+"%";
		List<CjContract> cj=cjservice.selectCjContractByTaskNo(code);
		map.put("task", task);
		map.put("cj", cj);
		return map;
	}
	
	@RequestMapping("/selectCjByTaskNo")
	@ResponseBody
	public Map<String,Object> selectCjByTaskNo(String no){
		Map<String,Object> map=new HashMap<>();
		Task task=tService.selectIdByNo(no);
		String code="%"+no+"%";
		List<CjContract> cj=cjservice.selectCjContractByTaskNo(code);
		map.put("task", task);
		map.put("cj", cj);
		return map;
	}
	
	@RequestMapping("/selectNoByName2")
	@ResponseBody
	public Task selectNoByName2(String name){
		return tService.selectNoByName2(name);
	}
	
	@RequestMapping("/selectIdByNo2")
	@ResponseBody
	public Task selectIdByNo2(String no){
		return tService.selectIdByNo2(no);
	}
	
	@RequestMapping("/selectPrjandNoAndPrjMoney")//获取项目名、任务单号、项目金额、签订时间
	@ResponseBody
	public List<Task> selectPrjandNoAndPrjMoney(){
		return tService.selectPrjandNoAndPrjMoney();
	}
	
	@RequestMapping("/selectPrjByprjlike")
	@ResponseBody
	public List<Task> selectPrjByprjlike(String no){
		return tService.selectPrjByprjlike(no);
	}
	
	@RequestMapping("/selectPrjAndNo")//初始化状态为正在进行和项目终止的项目名和任务单号 
	@ResponseBody
	public List<Task> selectPrjAndNo(){
		return tService.selectPrjAndNo();
	}
	
	@RequestMapping("/getLeader")//根据承接合同关联的项目，找到对应主合同负责人（合同金额多的）
	@ResponseBody
	public Map<String,String> getLeader(String nos){
		Map<String,String> map=new HashMap<>();
		float money=0;
		String leader="";
		for(int i=0;i<nos.split(",").length;i++){
			Task task=tService.selectIdByNo(nos.split(",")[i]);
			if(task.getContractMoney()>money){
				money=task.getContractMoney();
				leader=task.getMainPrjLeader();
			}
		}
		map.put("leader", leader);
		return map;
	}
	
	@RequestMapping("/selectIdByNo")
	@ResponseBody
	public Task selectIdByNo(String no){
		return tService.selectIdByNo(no);
	}
	
	@RequestMapping("/selectIdByName")
	@ResponseBody
	public Task selectIdByName(String name){
		return tService.selectIdByName(name);
	}
	
	@RequestMapping("/selectIdByNameAndNo")//通过项目名和任务单获取唯一Id
	@ResponseBody
	public Task selectIdByNameAndNo(String name,String no){
		return tService.selectIdByNameAndNo(name,no);
	}
	@RequestMapping("/getContracts")//通过项目名和任务单获取唯一Id
	@ResponseBody
	public List<CjContract> getContracts(String id){
		List<CjContract> list = cjservice.selectContractByTaskNo(id);
		return list;
	}
	
	@RequestMapping("/getTaskIdNameNo") //获取正在运行以及完结的任务单列表
	@ResponseBody
	public List<Task> getTaskIdNameNo(){
		List<Task> list=tService.getTaskIdNameNo();
		return list;
	}
}


package org.ldxx.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.ContractUpdate;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.CurrentFlowExample;
import org.ldxx.bean.Enterprise;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.ModeStatus;
import org.ldxx.bean.ModeStatusExample;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.Role;
import org.ldxx.bean.Task;
import org.ldxx.bean.User;
import org.ldxx.bean.UserVo;
import org.ldxx.dao.CjContractDao;
import org.ldxx.dao.ConstructionDocumentsDao;
import org.ldxx.dao.DesignDocumentsDao;
import org.ldxx.dao.MaintenanceReinforcementDao;
import org.ldxx.dao.OrganizationManagementDao;
import org.ldxx.dao.RoleDao;
import org.ldxx.dao.TaskDao;
import org.ldxx.dao.TechnicalDocumentationDao;
import org.ldxx.dao.TestingEvaluationDao;
import org.ldxx.dao.UserDao;
import org.ldxx.mapper.CurrentFlowMapper;
import org.ldxx.mapper.FlowHistroyMapper;
import org.ldxx.mapper.ModeStatusMapper;
import org.ldxx.service.CjContractService;
import org.ldxx.service.ContractUpdateService;
import org.ldxx.service.EnterpriseService;
import org.ldxx.service.TaskService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.SendSms;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;;


@Controller
@RequestMapping("task")
public class TaskController {

	@Autowired
	private TaskService tService;
	@Autowired
	private TaskDao taskDao;
	@Autowired
	private EnterpriseService eService;
	@Autowired
	private CjContractService cjservice;
	@Autowired
	private CjContractDao cjdao;
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
	@Autowired
	private CurrentFlowMapper currentFlowMapper;
	@Autowired
	private FlowHistroyMapper histroyMapper;
	@Autowired
	private OrganizationManagementDao omDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private ModeStatusMapper modeStatusMapper;
	@Autowired
	private ContractUpdateService cuService;
	
	@RequestMapping("/addTask")/*任务单保存*/
	@ResponseBody
	public int addTask(@RequestBody List<Task> task,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		Task t=task.get(0);
		
		t.setPrjId(id);
		String mainDepartMentId = t.getMainDepartment();
		OrganizationManagement oManagement = omDao.selectOrgById(mainDepartMentId);
		String omNo =oManagement.getOmNo();
		/*String type=t.getPrjType2();
		String code=type.split(" ")[0];
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		int count=tService.typeCount(year);
		count=count+1;
		String prjNo=uuid.getPrjCode(code, count);
		t.setPrjNo(prjNo);*/
		int i=tService.addTask(t);
		/*if(i>0){
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
		}*/
		User user = (User) session.getAttribute("user");
		FlowUtill flowUtill = new FlowUtill();
		CurrentFlow currentFlow = new CurrentFlow();
		currentFlow.setParams("1");
		currentFlow.setTitle(t.getPrjName());
		currentFlow.setActor(user.getUserId());
		currentFlow.setActorname(user.getuName());;
		currentFlow.setMemo(t.getPrjName()+"流程发起");
		currentFlow.setUrl("shengchanGuanli/TaskManagementLook.html-"+id);
		currentFlow.setParams("{'cs':'1'}");
		currentFlow.setStarter(user.getUserId());
		currentFlow.setStartername(user.getuName());
		currentFlow.setFkDept(omNo);
		currentFlow.setDeptname(oManagement.getOmName());
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
		String string = "";
		try {
			string = flowUtill.zancunFlow(currentFlow, flowHistroy);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	@Transactional
	@RequestMapping("/addTask2")/*任务单提交*/
	@ResponseBody
	public String addTask2(@RequestBody List<Task> task,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		Task t=task.get(0);
		
		t.setPrjId(id);
		String mainDepartMentId = t.getMainDepartment();
		String omNo = omDao.selectOrgById(mainDepartMentId).getOmNo();
		/*String type=t.getPrjType2();
		String code=type.split(" ")[0];
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		int count=tService.typeCount(year);
		count=count+1;
		String prjNo=uuid.getPrjCode(code, count);
		t.setPrjNo(prjNo);*/
		int i=tService.addTask(t);
		/*if(i>0){
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
		}*/
		User user = (User) session.getAttribute("user");
		FlowUtill flowUtill = new FlowUtill();
		CurrentFlow currentFlow = new CurrentFlow();
		currentFlow.setParams("1");
		currentFlow.setTitle(t.getPrjName());
		currentFlow.setActor(user.getUserId());
		currentFlow.setActorname(user.getuName());;
		currentFlow.setMemo(t.getPrjName()+"流程发起");
		currentFlow.setUrl("shengchanGuanli/TaskManagementLook.html-"+id);
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
		flowHistroy.setActorname(user.getOmName());
		flowHistroy.setActorresult(0);
		flowHistroy.setView("");
		String string = "";
		try {
			string = flowUtill.submitGetReceiver(currentFlow,omNo);
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
		String deptNo="02";
		try {
			string = flowUtill.submitGetReceiver(currentFlow,deptNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return string;
	}
	
	@RequestMapping("/addTask4")/*任务单保存*/
	@ResponseBody
	public JSONObject addTask4(String url,String userId,String uName,HttpSession session,String view,String omName){
		User user = (User) session.getAttribute("user");
		FlowUtill flowUtill = new FlowUtill();
		CurrentFlow currentFlow = new CurrentFlow();
		currentFlow.setUrl(url);
		currentFlow.setLastView(view);
		currentFlow.setNowDeqPerson(user.getuName());
		currentFlow.setNowDeqPersonId(user.getUserId());
		FlowHistroy	flowHistroy = new FlowHistroy();
	    flowHistroy.setActor(user.getUserId());
	    flowHistroy.setActorname(user.getuName());
	    flowHistroy.setView(view);
	    flowHistroy.setDeptname(omName);
	    flowHistroy.setId(new TimeUUID().getTimeUUID());
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject = flowUtill.submitFlow(currentFlow, flowHistroy, userId, uName);
			SendSms ss=new SendSms();
			CurrentFlowExample example=new CurrentFlowExample();
			example.createCriteria().andUrlEqualTo(url);
			List<CurrentFlow> cf =currentFlowMapper.selectByExample(example);
			User u=userDao.selectUserById(userId);
			
/*	        new Thread() {  
	            public void run() {  
	                while (true) {  
	                    ss.sendMessage(u.getRtx(), "待审批通知", cf.get(0).getTitle(), "0", "0");  
	                }  
	            };  
	        }.start(); 
			*/
		
		} catch (Exception e) {
			e.printStackTrace();
			return jsonObject;
		}
		return jsonObject;
	}
	
	
	@RequestMapping("/testRtx")
	@ResponseBody
	public int testRtx(){
		SendSms ss=new SendSms();
		int i=ss.sendMessage("wangjun1", "待审批通知", "47.92.99.112rtx测试", "0", "0");
		return i;
	}
	
	
/*	@RequestMapping("/addTask5")任务单保存
	@ResponseBody
	public String addTask5(String url,String userId,String uName,String omName,String view,HttpSession session){
		FlowUtill flowUtill = new FlowUtill();
		CurrentFlow currentFlow = new CurrentFlow();
		currentFlow.setUrl(url);
		currentFlow.setDeptname(omName);
		FlowHistroy	flowHistroy = new FlowHistroy();
		User user = (User) session.getAttribute("user");
	    flowHistroy.setActor(user.getUserId());
	    flowHistroy.setActorname(user.getuName());
	    flowHistroy.setView(view);
	    flowHistroy.setId(new TimeUUID().getTimeUUID());
		String string = "";
		try {
			string = flowUtill.submitFlow(currentFlow, flowHistroy, userId, uName);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "1";
	}*/
	@RequestMapping("/deleteTask")
	@ResponseBody
	public int deleteTask(String id){
		return tService.deleteTask(id);
	}
	
	@RequestMapping("/updateTask")/*任务单修改保存*/
	@ResponseBody
	public int updateTask(@RequestBody List<Task> task,HttpSession session){
		Task t=task.get(0);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		t.setPrjId(id);
		String time = uuid.getTimeByFmt("yyyy-MM-dd HH:mm:ss", new Date());
		t.setXgDodate(time);
		int i=tService.addTask(t);
		if(i>0){
			String mainDepartMentId = t.getMainDepartment();
			OrganizationManagement oManagement = omDao.selectOrgById(mainDepartMentId);
			String omNo =oManagement.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(t.getPrjName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(t.getPrjName()+"流程发起");
			currentFlow.setUrl("shengchanGuanli/TaskManagementLook.html-"+id);
			currentFlow.setParams("{'cs':'1'}");
			currentFlow.setStarter(user.getUserId());
			currentFlow.setStartername(user.getuName());
			currentFlow.setFkDept(omNo);
			currentFlow.setDeptname(oManagement.getOmName());
			currentFlow.setNodename("节点名称");
			currentFlow.setPri(1);
			currentFlow.setSdtofnode(new Date());
			currentFlow.setSdtofflow(new Date());
			currentFlow.setFlowEndState(2);
			currentFlow.setFlowNopassState(0);
			currentFlow.setGaibian("true");
			FlowHistroy flowHistroy = new FlowHistroy();
			flowHistroy.setActor(user.getUserId());
			flowHistroy.setActorname(user.getuName());
			flowHistroy.setActorresult(0);
			flowHistroy.setView("");
			String string = "";
			try {
				string = flowUtill.zancunFlow(currentFlow, flowHistroy);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return i;
	}
	
	@RequestMapping("/updateTaskCG")/*任务单修改保存*/
	@ResponseBody
	public int updateTaskCG(@RequestBody List<Task> task,HttpSession session){
		Task t=task.get(0);
		int i=tService.updateTask(t);
		if(i>0){
			String mainDept=t.getMainDepartment();
			String id=t.getPrjId();
			OrganizationManagement om=omDao.selectOrgById(mainDept);
			String omNo=om.getOmNo();
			currentFlowMapper.updateFkDeptByModeId(id,omNo);
		}
		return i;
	}
	
	@RequestMapping("/updateTask2")/*任务单修改提交*/
	@ResponseBody
	public String updateTask2(@RequestBody List<Task> task,HttpSession session){
		Task t=task.get(0);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		t.setPrjId(id);
		String time = uuid.getTimeByFmt("yyyy-MM-dd HH:mm:ss", new Date());
		t.setXgDodate(time);
		int i=tService.addTask(t);
		String string = "";
		if(i>0){
			String mainDepartMentId = t.getMainDepartment();
			OrganizationManagement oManagement = omDao.selectOrgById(mainDepartMentId);
			String omNo =oManagement.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(t.getPrjName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(t.getPrjName()+"流程发起");
			currentFlow.setUrl("shengchanGuanli/TaskManagementLook.html-"+id);
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
			currentFlow.setGaibian("true");
			currentFlow.setGaibian_views(t.getTijiaoViews());
			FlowHistroy flowHistroy = new FlowHistroy();
			flowHistroy.setActor(user.getUserId());
			flowHistroy.setActorname(user.getOmName());
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
	
	@RequestMapping("/saveTaskChaifen")/*任务单修改保存*/
	@ResponseBody
	@Transactional
	public int saveTaskChaifen(String task,HttpSession session){
		Map<String,Class> map=new HashMap<>();
		
		JSONArray jsonArray=JSONArray.parseArray(task);
		List<Task> list=new ArrayList<>();
		for(int i=0;i<jsonArray.size();i++){
			JSONObject job = jsonArray.getJSONObject(i); 
			map.put("enterprise", Enterprise.class);
			Task task2 = (Task) JSONObject.toJavaObject(job,Task.class);
			list.add(task2);
		}
		int i = 0;
		for(Task t:list){
			TimeUUID uuid=new TimeUUID();
			String id=uuid.getTimeUUID();
			t.setPrjId(id);
			String mainDepartMentId = t.getMainDepartment();
			OrganizationManagement oManagement = omDao.selectOrgById(mainDepartMentId);
			String omNo =oManagement.getOmNo();
			String type=t.getPrjType2();
			String code=type.split(" ")[0];
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
			String year=sdf.format(new Date());
			int count=tService.typeCount(year);
			count=count+1;
			String prjNo=uuid.getPrjCode(code, count);
			t.setPrjNo(prjNo);
			i=tService.addTask(t);
			ModeStatus modeStatus = new ModeStatus();
			modeStatus.setModeId(id);
			modeStatus.setStatus("1");
			modeStatus.setFlowStatus("4");
			modeStatusMapper.insert(modeStatus);
		}
		
		if(i>0){
			String mainDepartMentId = list.get(0).getMainDepartment();
			OrganizationManagement oManagement = omDao.selectOrgById(mainDepartMentId);
			String omNo =oManagement.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(list.get(0).getPrjName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(list.get(0).getPrjName()+"拆分流程");
			currentFlow.setUrl("shengchanGuanli/TaskManagementChaiFenLook.html-"+list.get(0).getMainPrjId());
			currentFlow.setParams("{'cs':'1'}");
			currentFlow.setStarter(user.getUserId());
			currentFlow.setStartername(user.getuName());
			currentFlow.setFkDept(omNo);
			currentFlow.setDeptname(oManagement.getOmName());
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
			String string = "";
			try {
				string = flowUtill.zancunFlowUpdateState(currentFlow, flowHistroy);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return i;
	}
	
	@RequestMapping("/saveTaskChaifenChange")/*任务单修改保存*/
	@ResponseBody
	@Transactional
	public int saveTaskChaifenChange(String task,HttpSession session){
		Map<String,Class> map=new HashMap<>();
		
		JSONArray jsonArray=JSONArray.parseArray(task);
		List<Task> list=new ArrayList<>();
		for(int i=0;i<jsonArray.size();i++){
			JSONObject job = jsonArray.getJSONObject(i); 
			map.put("enterprise", Enterprise.class);
			Task task2 = (Task) JSONObject.toJavaObject(job,Task.class);
			list.add(task2);
		}
		int i = 0;
		for(Task t:list){
			TimeUUID uuid=new TimeUUID();
			String id=uuid.getTimeUUID();
			if("".equals(t.getPrjId())||t.getPrjId()==null){
				t.setPrjId(id);
			}
			String mainDepartMentId = t.getMainDepartment();
			OrganizationManagement oManagement = omDao.selectOrgById(mainDepartMentId);
			String omNo =oManagement.getOmNo();
			String type=t.getPrjType2();
			String code=type.split(" ")[0];
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
			String year=sdf.format(new Date());
			int count=tService.typeCount(year);
			count=count+1;
			String prjNo=uuid.getPrjCode(code, count);
			if("".equals(t.getPrjNo())||t.getPrjNo()==null){
				t.setPrjNo(prjNo);
				i=tService.addTask(t);
				int k = taskDao.updateById(t);
			}else{
				i=tService.updateTask(t);
				int k = taskDao.updateById(t);
			}
			ModeStatusExample example = new ModeStatusExample();
			example.createCriteria().andModeIdEqualTo(t.getPrjId());
			List<ModeStatus> modeStatuss = modeStatusMapper.selectByExample(example);
			ModeStatus modeStatus = new ModeStatus();
			modeStatus.setModeId(t.getPrjId());
			modeStatus.setStatus("1");
			modeStatus.setFlowStatus("4");
			if(modeStatuss!=null&&modeStatuss.size()>0){
				modeStatusMapper.updateByExample(modeStatus, example);
			}else{
				modeStatusMapper.insert(modeStatus);
			}
		}
		return i;
	}
	
	@RequestMapping("/submitTaskChaifen")/*任务单修改保存*/
	@ResponseBody 
	@Transactional
	public String submitTaskChaifen(String task,HttpSession session){
		Map<String,Class> map=new HashMap<>();
		
		JSONArray jsonArray=JSONArray.parseArray(task);
		List<Task> list=new ArrayList<>();
		for(int i=0;i<jsonArray.size();i++){
			JSONObject job = jsonArray.getJSONObject(i); 
			map.put("enterprise", Enterprise.class);
			Task task2 = (Task) JSONObject.toJavaObject(job,Task.class);
			list.add(task2);
		}
		int i = 0;
		for(Task t:list){
			TimeUUID uuid=new TimeUUID();
			String id=uuid.getTimeUUID();
			t.setPrjId(id);
			String mainDepartMentId = t.getMainDepartment();
			OrganizationManagement oManagement = omDao.selectOrgById(mainDepartMentId);
			String omNo =oManagement.getOmNo();
			String type=t.getPrjType2();
			String code=type.split(" ")[0];
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
			String year=sdf.format(new Date());
			int count=tService.typeCount(year);
			count=count+1;
			String prjNo=uuid.getPrjCode(code, count);
			t.setPrjNo(prjNo);
			t.setPrjEstimateMoneyOld(t.getPrjEstimateMoney());
			i=tService.addTask(t);
			int k = taskDao.updateById(t);
			ModeStatus modeStatus = new ModeStatus();
			modeStatus.setModeId(id);
			modeStatus.setStatus("1");
			modeStatus.setFlowStatus("1");
			modeStatusMapper.insert(modeStatus);
		}
		String string = "";
		if(i>0){
			String mainDepartMentId = list.get(0).getMainDepartment();
			OrganizationManagement oManagement = omDao.selectOrgById(mainDepartMentId);
			String omNo =oManagement.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(list.get(0).getPrjName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(list.get(0).getPrjName()+"拆分流程");
			currentFlow.setUrl("shengchanGuanli/TaskManagementChaiFenLook.html-"+list.get(0).getMainPrjId());
			currentFlow.setParams("{'cs':'1'}");
			currentFlow.setStarter(user.getUserId());
			currentFlow.setStartername(user.getuName());
			currentFlow.setFkDept(omNo);
			currentFlow.setDeptname(oManagement.getOmName());
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
				string = flowUtill.submitGetReceiver(currentFlow, omNo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return string;
	}
	@RequestMapping("/submitTaskChaifenChange")/*任务单修改保存*/
	@ResponseBody
	@Transactional
	public String submitTaskChaifenChange(String task,HttpSession session){
		Map<String,Class> map=new HashMap<>();
		
		JSONArray jsonArray=JSONArray.parseArray(task);
		List<Task> list=new ArrayList<>();
		for(int i=0;i<jsonArray.size();i++){
			JSONObject job = jsonArray.getJSONObject(i); 
			map.put("enterprise", Enterprise.class);
			Task task2 = (Task) JSONObject.toJavaObject(job,Task.class);
			list.add(task2);
		}
		int i = 0;
		for(Task t:list){
			TimeUUID uuid=new TimeUUID();
			String id=uuid.getTimeUUID();
			t.setPrjId(id);
			String mainDepartMentId = t.getMainDepartment();
			OrganizationManagement oManagement = omDao.selectOrgById(mainDepartMentId);
			String omNo =oManagement.getOmNo();
			String type=t.getPrjType2();
			String code=type.split(" ")[0];
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
			String year=sdf.format(new Date());
			int count=tService.typeCount(year);
			count=count+1;
			String prjNo=uuid.getPrjCode(code, count);
			t.setPrjNo(prjNo);
			i=tService.updateTask(t);
			int k = taskDao.updateById(t);
			ModeStatusExample example = new ModeStatusExample();
			example.createCriteria().andModeIdEqualTo(id);
			List<ModeStatus> modeStatuss = modeStatusMapper.selectByExample(example);
			ModeStatus modeStatus = new ModeStatus();
			modeStatus.setModeId(id);
			modeStatus.setStatus("1");
			modeStatus.setFlowStatus("1");
			if(modeStatuss!=null&&modeStatuss.size()>0){
				modeStatusMapper.updateByExample(modeStatus, example);
			}else{
				modeStatusMapper.insert(modeStatus);
			}
		}
		String string = "";
		if(i>0){
			String mainDepartMentId = list.get(0).getMainDepartment();
			OrganizationManagement oManagement = omDao.selectOrgById(mainDepartMentId);
			String omNo =oManagement.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(list.get(0).getPrjName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(list.get(0).getPrjName()+"拆分流程");
			currentFlow.setUrl("shengchanGuanli/TaskManagementChaiFenLook.html-"+list.get(0).getMainPrjId());
			currentFlow.setParams("{'cs':'1'}");
			currentFlow.setStarter(user.getUserId());
			currentFlow.setStartername(user.getuName());
			currentFlow.setFkDept(omNo);
			currentFlow.setDeptname(oManagement.getOmName());
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
				string = flowUtill.submitGetReceiver(currentFlow, omNo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return string;
	}
	
	@RequestMapping("/selectTaskByStatus")
	@ResponseBody
	public List<Task>selectTaskByStatus(String status,@RequestParam(defaultValue="")String startMin,@RequestParam(defaultValue="")String startMax,@RequestParam(defaultValue="")String endMin,
		@RequestParam(defaultValue="")String endMax,@RequestParam(defaultValue="%")String mainDp,@RequestParam(defaultValue="%")String xbDp,@RequestParam(defaultValue="0")BigDecimal prjMoneyMin,@RequestParam(defaultValue="0")BigDecimal prjMoneyMax,
		@RequestParam(defaultValue="0")BigDecimal contractMoneyMin,@RequestParam(defaultValue="0")BigDecimal contractMoneyMax,
		@RequestParam(defaultValue="0")BigDecimal zdMoneyMin,@RequestParam(defaultValue="0")BigDecimal zdMoneyMax){
		List<Task> task=tService.selectTaskByStatus(status, startMin, startMax, endMin, endMax, mainDp, xbDp, prjMoneyMin, prjMoneyMax, contractMoneyMin, contractMoneyMax, zdMoneyMin, zdMoneyMax);
		/*for(int i=0;i<task.size();i++){
			String no=task.get(i).getPrjNo();
			String id = task.get(i).getPrjId();
			List<CjContract> cj=cjservice.selectCjContractByTaskNo(no);
			if(""!=task.get(i).getPrjCompanyVo().getPrjCompany1()){
				task.get(i).setPrjCompany(task.get(i).getPrjCompanyVo().getPrjCompany1());
			}
			task.get(i).setCj(cj);
		}*/
		return task;
	}
	@RequestMapping("/selectTaskTongjiByStatusAndDepart")
	@ResponseBody
	public List<Task> selectTaskTongjiByStatusAndDepart(String departMentId,String status){
		List<Task> task =taskDao.selectTaskTongjiByStatusAndDepart(departMentId, status);
		return task;
	}
	
	@RequestMapping("/selectTaskByStatus2")
	@ResponseBody
	public List<Task>selectTaskByStatus2(String status){
		List<Task> task=tService.selectTaskByStatus2(status);
		return task;
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
	@RequestMapping("/selectTaskAndChildrenById")
	@ResponseBody
	public Task selectTaskAndChildrenById(String id){
		Task t = tService.selectTaskAndTaskChildrenById(id);
		return t;
	}
	
	@RequestMapping("/updateTaskChildrenModeStatusById")
	@ResponseBody
	public int updateTaskChildrenModeStatusById(String id){
		
		Task task1=taskDao.selectTaskById(id);
		List<Task> taskChildren = taskDao.selectTaskAndTaskChildrenByMainPrjNo(task1.getPrjNo(),id);
		BigDecimal mainTaskMoney = task1.getPrjEstimateMoney();
		BigDecimal mainTaskContractMoney = task1.getContractMoney();
		int i=0;
		for(Task task : taskChildren){
			String modeId = task.getPrjId();
			ModeStatus modeStatus = new ModeStatus();
			modeStatus.setModeId(modeId);
			modeStatus.setStatus("2");;
			modeStatus.setFlowStatus("2");
			ModeStatusExample example = new ModeStatusExample();
			example.createCriteria().andModeIdEqualTo(modeId);
			i= modeStatusMapper.updateByExampleSelective(modeStatus, example);
			mainTaskMoney = mainTaskMoney.subtract(task.getPrjEstimateMoney());
		}
		i=taskDao.updateTaskMoneyByIdChaifen(mainTaskMoney, mainTaskContractMoney, id);
		return i;
	}
	
	@RequestMapping("/selectTaskHistory")
	@ResponseBody
	public Map<String,Object> selectTaskHistory(String id,String no){
		Map<String,Object> map=new HashMap<>();
		Task t=tService.selectTaskById(id);
		FlowHistroy fh=histroyMapper.selectLastDoDate(id);
		if(null!=fh){
			Date doDate=fh.getDoDate();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String lxTime=sdf.format(doDate);
			t.setLxTime(lxTime);
		}
		map.put("task", t);
		List<Task> list=tService.selectTaskHistoryById(no, id);
		map.put("taskList", list);
		return map;
	}

	@RequestMapping("/selectTaskHistory_byId")
	@ResponseBody
	public Map<String,Object> selectTaskHistory_byId(String id){
		Map map = new HashMap<String, Object>();
		Task task = tService.selectTaskById(id);
		String no = "";
		if(null!=task) {
			no = task.getPrjNo();
			if(!"".equals(no.trim())) {
				map.put("history", true);
			}
		}
		List<Task> list=tService.selectTaskHistoryById(no, id);
		map.put("taskList", list);
		return map;
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
			if(null!=task){
				list.add(task);
			}
		}
		return list;
	}
	@RequestMapping("/selectTaskPrjNameLast")
	@ResponseBody
	public List<Task> selectTaskPrjNameLast(String prjNo,String contractMoney,String cjId){
		List<Task> list=new ArrayList<Task>();
		for(int i=0;i<prjNo.split(",").length;i++){
			Task task=tService.selectTaskPrjName(prjNo.split(",")[i]);
			if(null!=task){
				list.add(task);
			}
		}
		int i = taskDao.updateTaskSetLastInfoByPrjNo(list);
		int j = cjdao.updateContractMoneyLastByContractMoney(contractMoney, cjId);
		return list;
	}
	
	
	@RequestMapping("/deleteSetTaskLastInfo")
	@ResponseBody
	public List<Task> deleteSetTaskLastInfo(String prjNo,String no){
		List<Task> list=new ArrayList<Task>();
		for(int i=0;i<prjNo.split(",").length;i++){
			Task task=tService.selectTaskPrjName(prjNo.split(",")[i]);
			if(null!=task){
				list.add(task);
			}
		}
		int i = taskDao.updateTaskSetYuanInfoByLastInfoByPrjNo(list);
		CjContract cjContract = cjdao.selectCjContractByNo(no);
		int j = cjdao.updateContractMoneyByLast(cjContract.getContractMoneyLast(), cjContract.getCjId());
		
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
	
	@RequestMapping("/selectTaskByPrjNo")
	@ResponseBody
	public List<Task> selectTaskByPrjNo(String prjNo){
		List<Task> list=new ArrayList<Task>();
		for(int i=0;i<prjNo.split(",").length;i++){
			Task task=tService.selectTaskByPrjNo(prjNo.split(",")[i]);
			list.add(task);
		}
		return list;
	}
	
	@RequestMapping("/getReceiver")/*任务单保存*/
	@ResponseBody
	public String getReceiver(String url,HttpSession session){
		User user = (User) session.getAttribute("user");
		String string = "";
		CurrentFlowExample example = new CurrentFlowExample();
		example.createCriteria().andUrlEqualTo(url);
		List<CurrentFlow> currentFlows = currentFlowMapper.selectByExample(example);
		FlowUtill flowUtill = new FlowUtill();
		CurrentFlow currentFlow = new CurrentFlow();
		if(null!=user){
			String uName = user.getuName();
			String userId = user.getUserId();
			currentFlow=currentFlows.get(0);
			currentFlow.setNowDeqPerson(uName);
			currentFlow.setNowDeqPersonId(userId);
		}
		try {
			string = flowUtill.shenpiGetReceiver(currentFlow);
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
	@RequestMapping("/boHui")/*任务单保存*/
	@ResponseBody
	public String boHui(String url,String view){
		FlowUtill flowUtill = new FlowUtill();
		//String currentFlowId = "";
		String result = "";
		try {
			//currentFlowId = url.split("-")[1];
			result = flowUtill.boHuiFlow(url, view);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
/*	@RequestMapping("/tuiHuiGei")退回流程	
	@ResponseBody
	public String tuiHuiGei(String url,String view){
		FlowUtill flowUtill = new FlowUtill();
		String currentFlowId = "";
		String result = "";
		try {
			currentFlowId = url.split("-")[1];
			result = flowUtill.TuiHuiFlow(currentFlowId,view);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}*/
	
	@RequestMapping("/returnPerson")/*退回流程*/
	@ResponseBody
	public String returnPerson(String url,String view,String tuihuiFloNodeId,String tuihuiDeptName,String tuihuiActor,String tuihuiActorName){
		FlowUtill flowUtill = new FlowUtill();
		CurrentFlow currentFlow = new CurrentFlow();
		currentFlow.setFloNodeId(tuihuiFloNodeId);
		currentFlow.setDeptname(tuihuiDeptName);
		currentFlow.setActor(tuihuiActor);
		currentFlow.setActorname(tuihuiActorName);
		String result = "";
		try {
			result = flowUtill.TuiHuiZhi(url,view,currentFlow);
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
		Task task=tService.selectIdByNo2(no);
		return task;
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
		BigDecimal money=new BigDecimal(0);
		String leader="";
		for(int i=0;i<nos.split(",").length;i++){
			Task task=tService.selectIdByNo(nos.split(",")[i]);
			if(task.getContractMoney().doubleValue()>money.doubleValue()){
				money=task.getContractMoney();
				leader=task.getMainPrjLeaderName();
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
	
	@RequestMapping("/updateById") //通过id修改主办协办部门的项目负责人、主任工程师、其他负责人
	@ResponseBody
	public int updateById(Task task){
		int i=tService.updateById(task);
		return i;
	}
	
	@RequestMapping("/selectPrjLeaderByPrjNo")
	@ResponseBody
	public Map<String,String> selectPrjLeaderByPrjNo(String nos){
		Map<String,String> map=new HashMap<>();
		List<String> list=new ArrayList<>();
		for(int i=0;i<nos.split(",").length;i++){
			String no=nos.split(",")[i];
			Task t=tService.selectPrjLeaderByPrjNo(no);
			if(t!=null){
				String leader=t.getMainPrjLeaderName();
				if(list.size()!=0){
					for(int j=0;j<list.size();j++){
						if(!leader.equals(list.get(j))){
							list.add(leader);
						}
					}
				}else{
					list.add(leader);
				}
			}
		}
		map.put("leader", StringUtils.strip(list.toString(),"[]"));
		return map;
	}
	
	@RequestMapping("/updateHistoryById") //通过id修改历史状态，prjno为当前的全部改为0，再把当前这条记录的历史状态改为1
	@ResponseBody
	public int updateHistoryById(String id){
		int i=tService.updateHistoryById(id);
		if(i>0){
			TimeUUID uuid=new TimeUUID();
			Task t=tService.selectCcNameByPrjId(id);
			String mainDept=t.getMainDepartment();
			String company=t.getPrjCompany();
			String oldNo=t.getPrjNo();
			if(t.getXgDodate()!=""&&t.getXgDodate()!=null){
				String time = uuid.getTimeByFmt("yyyy-MM-dd HH:mm:ss", new Date());
				i=tService.updateXgDodateById(id,time);
			}
			if(oldNo==null||oldNo.equals("")){
				String gs="HT";
				if("华汇".equals(company)){
					gs="HH";
				}
				String type=t.getPrjType2();
				String code=type.substring(0, 1);
				String code2=type.split(" ")[0];
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
				String year=sdf.format(new Date());
				String count=tService.CreateTaskNumOrder(gs, year, code);
//				int count=tService.typeCount(gs+year);
//				String prjNo=uuid.getPrjCode(code, count+1);
//				prjNo=gs+prjNo;
				if(gs.equals("HT")){
					gs="";
				}
				String prjNo=gs+year+count+code2;
				i=tService.updateTaskNoById(prjNo, id);
				t.setPrjNo(prjNo);
			}
			List<Task> taskList=new ArrayList<>();
			taskList.add(t);
			cuService.addContractUpdate(taskList);
		}
		return i;
	}
	
	@RequestMapping("/CreateTaskNumOrder")
	@ResponseBody
	public String CreateTaskNumOrder(){
		String count=tService.CreateTaskNumOrder("HT", "2019", "A");
		return count;
	}
	
	@RequestMapping("/updateTaskById")
	@ResponseBody
	public int updateTaskById(@RequestBody List<Task> task){
		Task t=task.get(0);
		int i=tService.updateTask(t);
		return i;
	}
	@RequestMapping("/updateFlowFkDept")
	@ResponseBody
	public int updateFlowFkDept(String cFlowId,String fkdept){
		
		CurrentFlow record = new CurrentFlow();
		record.setId(cFlowId);
		record.setFkDept(fkdept);
		return currentFlowMapper.updateByPrimaryKeySelective(record);
	}
	@RequestMapping("/updateFlowFkDeptTBSP")
	@ResponseBody
	public int updateFlowFkDeptTBSP(String cFlowId,String fkdept,String agent,String agentType){
		
		CurrentFlow record = new CurrentFlow();
		record.setId(cFlowId);
		record.setFkDept(fkdept);
		record.setAgent(agent);
		record.setAgenttype(agentType);
		return currentFlowMapper.updateByPrimaryKeySelective(record);
	}
	
	@RequestMapping("/updateImportance")
	@ResponseBody
	public int updateImportance(String id,String importance){
		
		return taskDao.updateImportanceById(id, importance);
	}
	
	@RequestMapping("/deleteChaoSong")
	@ResponseBody
	public String deleteChaoSong(String id){
	String result = new FlowUtill().deleteChaoSongFlow(id);
		return result;
	}
	
	@RequestMapping("/yiDuChaoSong")
	@ResponseBody
	public String yiDuChaoSong(String id){
		String result = new FlowUtill().yiDuChaoSong(id);
		return result;
	}
	
	@RequestMapping("/insertChaoSong")
	@ResponseBody
	public String insertChaoSong(@RequestBody UserVo userVo){
	  List<User> users = userVo.getUsers();
	  for(User user:users){
		  if(user.getUserId()==null||"".equals(user.getUserId())){
				User user1 =  userDao.getUserByUname(user.getuName());
				if(null!=user){
					user.setUserId(user1.getUserId());
				}
			  } 
	  }
	  String result = new FlowUtill().chaoSongFlow(users.get(0).getWorkId(), users);
	  return result;
	}
	
	@RequestMapping("/insertChaoSongYZGLY")
	@ResponseBody
	public String insertChaoSong(String  id,String roleName){
		
	  List<User> users = userDao.selectAllUser();
	  List<Role> roles = roleDao.selectRoleByRoleName("印章管理员");
	  String yzRole = "";
	  if(roles.size()>0){
		  yzRole =  roles.get(0).getRoleCode();
	  }
	  List<User> users1 = new ArrayList<>();
	  for(User user:users){
		  if(null!=user.getUserRole()&&user.getUserRole().contains(yzRole)){
			  users1.add(user);
		  }
	  }
	  String result = new FlowUtill().chaoSongFlow(id, users1);
	  return result;
	}
	
	@RequestMapping("/insertChaoSongToRoleName")
	@ResponseBody
	public String insertChaoSongToRoleName(String  id,String roleName){
	  List<User> users = userDao.selectAllUser();
	  List<Role> roles = roleDao.selectRoleByRoleName(roleName);
	  String yzRole = "";
	  if(roles.size()>0){
		  yzRole =  roles.get(0).getRoleCode();
	  }
	  List<User> users1 = new ArrayList<>();
	  for(User user:users){
		  if(null!=user.getUserRole()&&user.getUserRole().contains(yzRole)){
			  users1.add(user);
		  }
	  }
	  String result = new FlowUtill().chaoSongFlow(id, users1);
	  return result;
	}
	@RequestMapping("/insertChaoSongByOmNo")
	@ResponseBody
	public String insertChaoSongByOmNo(String  id,String omNo,String roleName){
		List<User> users = userDao.selectAllUser();
		
		List<Role> roles = roleDao.selectRoleByRoleName(roleName);
		String yzRole = "";
		
		if(roles.size()>0){
			if(roles.get(0).getRoleCode().length()<=5){
				yzRole =  roles.get(0).getRoleCode();
			}
		}
		List<User> users1 = new ArrayList<>();
		for(User user:users){
			if(null!=user.getUserRole()&&user.getUserRole().contains(yzRole+"r"+omNo+".")){
				users1.add(user);
			}
		}
		String result = new FlowUtill().chaoSongFlow(id, users1);
		return result;
	}
	
	@RequestMapping("/selectTaskByCj")
	@ResponseBody
	public List<Task> selectTaskByCj(){
		List<Task> task=tService.selectTaskByCj();
		return task;
	}
	
	@RequestMapping("/selectPrjJsMoneyByNo")//通过任务单号查询项目结算金额（如果有关联任务单，就把结算金额相加）核算专用
	@ResponseBody
	public Task selectPrjJsMoneyByNo(String no){
		Task task=tService.selectPrjJsMoneyByNo(no);
		return task;
	}
	
	@RequestMapping("/selectTask")//档案文档是否归档专用
	@ResponseBody
	public List<Task> selectTask(String mainDepartment){
		mainDepartment="%"+mainDepartment+"%";
		return tService.selectTask(mainDepartment);
	}
	
	
	@RequestMapping("/addStopReason")
	@ResponseBody
	public String addStopReason(Task t,HttpSession session){
		int i=tService.addReason(t.getPrjId(), t.getStopReason());
		String string="";
		if(i>0){
			String mainDepartMentId = t.getMainDepartment();
			String omNo = omDao.selectOrgById(mainDepartMentId).getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(t.getPrjName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(t.getPrjName()+"任务单终止流程");
			currentFlow.setUrl("shengchanguanliLook/TaskManagementCancelLook.html-"+t.getPrjId());
			currentFlow.setParams("{'cs':'1'}");
			currentFlow.setStarter(user.getUserId());
			currentFlow.setStartername(user.getuName());
			currentFlow.setFkDept(omNo);
			currentFlow.setDeptname(user.getOmName());
			currentFlow.setNodename("节点名称");
			currentFlow.setPri(1);
			currentFlow.setSdtofnode(new Date());
			currentFlow.setSdtofflow(new Date());
			currentFlow.setFlowEndState(3);
			currentFlow.setFlowNopassState(2);
			FlowHistroy flowHistroy = new FlowHistroy();
			flowHistroy.setActor(user.getUserId());
			flowHistroy.setActorname(user.getOmName());
			flowHistroy.setActorresult(0);
			flowHistroy.setView("");
			try {
				string = flowUtill.cancelSubmitGetReceiver(currentFlow,omNo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return string;
	}
	
	
	@RequestMapping("/selectTask2")
	@ResponseBody
	public List<Task> selectTask2(@RequestParam(defaultValue="")String startMin,@RequestParam(defaultValue="")String startMax,@RequestParam(defaultValue="")String endMin,
		@RequestParam(defaultValue="")String endMax,@RequestParam(defaultValue="%")String mainDp,@RequestParam(defaultValue="%")String xbDp,@RequestParam(defaultValue="0")BigDecimal prjMoneyMin,@RequestParam(defaultValue="0")BigDecimal prjMoneyMax,
		@RequestParam(defaultValue="0")BigDecimal contractMoneyMin,@RequestParam(defaultValue="0")BigDecimal contractMoneyMax,
		@RequestParam(defaultValue="0")BigDecimal zdMoneyMin,@RequestParam(defaultValue="0")BigDecimal zdMoneyMax,
		@RequestParam(defaultValue="%")String taskNo,@RequestParam(defaultValue="")String lxdateMin,@RequestParam(defaultValue="")String lxdateMax,@RequestParam(defaultValue="%")String erjileixing){
		List<Task> task=taskDao.selectTask2( startMin, startMax, endMin, endMax, mainDp, xbDp, prjMoneyMin, prjMoneyMax,
				contractMoneyMin, contractMoneyMax, zdMoneyMin, zdMoneyMax,taskNo,lxdateMin,lxdateMax,erjileixing);
		return task;
	}
	
	
	@RequestMapping("/updateTaskContractUpdateById") //终止任务单后给contractUpdate里增加部门负金额
	@ResponseBody
	public int updateTaskContractUpdateById(String id){
		Task task = tService.selectTaskById(id);
		List<ContractUpdate> list = new ArrayList<ContractUpdate>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		String time=sdf.format(new Date());
		ContractUpdate cu = new ContractUpdate();
		cu.setDept(task.getMainDepartment());
		cu.setMoney(task.getMainDepartmentMoney().multiply(new BigDecimal(-1)));
		cu.setPrjNo(task.getPrjNo());	
		cu.setTime(time);
		list.add(cu);
		if(null!=task.getAssistDepartment1()&&!task.getAssistDepartment1().equals(""))
		{
			ContractUpdate cu1 = new ContractUpdate();
			cu1.setDept(task.getAssistDepartment1());
			cu1.setMoney(task.getAssistDepartment1Money().multiply(new BigDecimal(-1)));
			//cu1.setMoney(-task.getAssistDepartment1Money());
			cu1.setPrjNo(task.getPrjNo());	
			cu1.setTime(time);
			list.add(cu1);
		}
		if(null!=task.getAssistDepartment2()&&!task.getAssistDepartment2().equals(""))
		{
			ContractUpdate cu1 = new ContractUpdate();
			cu1.setDept(task.getAssistDepartment2());
			cu1.setMoney(task.getAssistDepartment2Money().multiply(new BigDecimal(-1)));
			cu1.setPrjNo(task.getPrjNo());	
			cu1.setTime(time);
			list.add(cu1);
		}
		
		if(null!=task.getAssistDepartment3()&&!task.getAssistDepartment3().equals(""))
		{
			ContractUpdate cu1 = new ContractUpdate();
			cu1.setDept(task.getAssistDepartment3());
			cu1.setMoney(task.getAssistDepartment3Money().multiply(new BigDecimal(-1)));
			cu1.setPrjNo(task.getPrjNo());	
			cu1.setTime(time);
			list.add(cu1);
		}
		cuService.addContractUpdate1(list);
		return 1;
	}
}


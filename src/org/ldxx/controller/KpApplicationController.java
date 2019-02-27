package org.ldxx.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.CjContract;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.KpApplication;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.PrjMaterialBuy;
import org.ldxx.bean.PrjProgressFill;
import org.ldxx.bean.Task;
import org.ldxx.bean.User;
import org.ldxx.dao.OrganizationManagementDao;
import org.ldxx.service.CjContractService;
import org.ldxx.service.KpApplicationService;
import org.ldxx.service.PrjProgressFillService;
import org.ldxx.service.TaskService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//开票申请
@Controller
@RequestMapping("kp")
public class KpApplicationController {

	@Autowired
	private KpApplicationService service;
	@Autowired
	private PrjProgressFillService pService;
	@Autowired
	private TaskService tService;
	@Autowired
	private CjContractService cService;
	@Autowired
	private OrganizationManagementDao omDao;
	
	@RequestMapping("/addKpApplicationBySave")
	@ResponseBody
	public int addKpApplicationBySave(KpApplication kp,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		kp.setKpId(id);
		int count=service.countfpNo();
		String code="KP"+uuid.getClCode("", count+1);
		kp.setKpNo(code);
		int i=service.addKpApplication(kp);
		if(i>0){
			User user = (User) session.getAttribute("user");
			String omNo = omDao.selectOrgById(kp.getKpDepartment()).getOmNo();
			String string="";
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(kp.getPrjName()+"开票申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(kp.getPrjName()+"流程发起");
			currentFlow.setUrl("caiwuguanliLook/ApplicationTicket.html-"+id);
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
	
	@RequestMapping("/addKpApplicationBySubmit")
	@ResponseBody
	public String addKpApplicationBySubmit(KpApplication kp,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		kp.setKpId(id);
		int count=service.countfpNo();
		String code="KP"+uuid.getClCode("", count+1);
		kp.setKpNo(code);
		int i=service.addKpApplication(kp);
		String string = "";
		if(i>0){
			User user = (User) session.getAttribute("user");
			String omNo = omDao.selectOrgById(kp.getKpDepartment()).getOmNo();
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(kp.getPrjName()+"开票申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(kp.getPrjName()+"流程发起");
			currentFlow.setUrl("caiwuguanliLook/ApplicationTicket.html-"+id);
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
			try {
				string = flowUtill.submitGetReceiver(currentFlow,omNo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return string;
	}
	
	@RequestMapping("/selectKpApplication")
	@ResponseBody
	public List<KpApplication> selectKpApplication(String status){
		 List<KpApplication> list=service.selectKpApplication(status);
		 return list;
	}
	
	@RequestMapping("/getAllMoney")
	@ResponseBody
	public float getAllMoney(String contractNo,String prjNo){
		float all=service.getAllMoney(contractNo, prjNo);
		return all;
	}
	
	@RequestMapping("/buleFpNo")
	@ResponseBody
	public int buleFpNo(String no,String id){
		int i=service.buleFpNo(no, id);
		return i;
	}
	
	@RequestMapping("/getKpNo")
	@ResponseBody
	public List<KpApplication> getKpNo(String no){
		List<KpApplication> list=service.getKpNo(no);
		return list;
	}
	
	@RequestMapping("/getAllKpMoneyByFpNo")
	@ResponseBody
	public KpApplication getAllKpMoneyByFpNo(String no){
		KpApplication kp=service.getAllKpMoneyByFpNo(no);
		return kp;
	}
	
	@RequestMapping("/getPrjPlan")
	@ResponseBody
	public Map<String,Object> getPrjPlan(String nos,String contractNo){
		Map<String,Object> map=new HashMap<String, Object>();
		String jindu="";
		float jd=0; 
		if(nos.indexOf(",")>0){
			float sumMoney=0;
			CjContract cj=cService.selectCjContractByNo(contractNo);
			float contractMoney=cj.getContractMoney();
			for(int i=0;i<nos.split(",").length;i++){
				PrjProgressFill pf=pService.selectLastPrjProgressFill(nos.split(",")[i]);
				Task t=tService.selectIdByNo(nos.split(",")[i]);
				float prjMoney=t.getPrjEstimateMoney();
				String allMoney=pf.getAllMoney().replace("%", "");
				float am=Float.valueOf(allMoney);
				sumMoney=sumMoney+(prjMoney*am)/100;
			}
			float jd2=(sumMoney/contractMoney)*100;
			jindu=jd2+"%";
		}else{
			PrjProgressFill pf=pService.selectLastPrjProgressFill(nos);
			if(pf!=null){
				jindu=pf.getAllMoney();
			}else{
				jindu="0%";
			}
		}
		map.put("jindu", jindu);
		return map;
	}
	
	@RequestMapping("/getAllKpMoneyByFpNoAndTaskNo")//通过任务单号和合同编号获取累计开票金额和发票编码
	@ResponseBody
	public List<KpApplication> getAllKpMoneyByFpNoAndTaskNo(String taskno,String contractno){
		List<KpApplication> kpList=service.getAllKpMoneyByFpNoAndTaskNo(taskno,contractno);
		return kpList;
	}
	
	@RequestMapping("/getAllKpMoneyByFpNos")//通过多个发票编码查询累计收款
	@ResponseBody
	public List<KpApplication> getAllKpMoneyByFpNos(String nos){
		List<KpApplication> list=new ArrayList<KpApplication>();
		for(int a=0;a<nos.split(",").length;a++){
			KpApplication kp=service.getAllKpMoneyByFpNo(nos.split(",")[a]);
			list.add(kp);
		}
		return list;
	}
	
	@RequestMapping("/getAllkpNo")//初始化开票编号
	@ResponseBody
	public List<KpApplication> getAllkpNo(){
		List<KpApplication> list=service.getAllkpNo();
		return list;
	}
	
	@RequestMapping("/getKpApplicationBykpNo")//通过开票编号获取信息
	@ResponseBody
	public KpApplication getKpApplicationBykpNo(String kpno){
		KpApplication list=service.getKpApplicationBykpNo(kpno);
		return list;
	}
	
	@RequestMapping("/getKpApplicationById")//通过id获取信息
	@ResponseBody
	public KpApplication getKpApplicationById(String id){
		KpApplication list=service.getKpApplicationById(id);
		return list;
	}
}

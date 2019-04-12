package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.BudgetFpplicationForm;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.ContractWork;
import org.ldxx.bean.CostBudget;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.Enterprise;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.PrjProgressFill;
import org.ldxx.bean.PrjProgressFillCj;
import org.ldxx.bean.PrjProgressFillFb;
import org.ldxx.bean.PrjProgressFillInfo;
import org.ldxx.bean.Task;
import org.ldxx.bean.User;
import org.ldxx.dao.CompanyCostDao;
import org.ldxx.dao.SecondCompanyCostDao;
import org.ldxx.service.AccessoryService;
import org.ldxx.service.BudgetFpplicationFormService;
import org.ldxx.service.CjContractService;
import org.ldxx.service.ContractWorkService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.PrjProgressFillService;
import org.ldxx.service.TaskService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONObject;
/**
 * 进度管理
 * @author hp
 *
 */
@Controller
@RequestMapping("ppf")
public class PrjProgressFillController {

	@Autowired
	private PrjProgressFillService service;
	@Autowired
	private AccessoryService aService;
	@Autowired
	private TaskService tService;
	@Autowired
	private BudgetFpplicationFormService bService;
	@Autowired
	private CjContractService cService;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private ContractWorkService cwService;
	@Autowired
	private SecondCompanyCostDao sccDao;
	@Autowired
	private CompanyCostDao ccDao;
	
	@RequestMapping("/addPrjProgressFillBySave")
	@ResponseBody
	public int addPrjProgressFillBySave(String ppf,@RequestParam MultipartFile [] file,HttpSession session) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("ppfi", PrjProgressFillInfo.class);
		/*classMap.put("ppfi2", PrjProgressFillInfo.class);*/
		/*classMap.put("ppfi3", PrjProgressFillInfo.class);
		classMap.put("ppfi4", PrjProgressFillInfo.class);
		classMap.put("ppfi5", PrjProgressFillInfo.class);
		classMap.put("ppfi6", PrjProgressFillInfo.class);*/
		classMap.put("ppfb", PrjProgressFillFb.class);
		/*classMap.put("ppcj", PrjProgressFillCj.class);*/
		JSONObject jsonObject=JSONObject.fromObject(ppf);
		PrjProgressFill pf=(PrjProgressFill)JSONObject.toBean(jsonObject, PrjProgressFill.class,classMap);
		pf.setPpfId(id);
		
		if(file!=null){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				//String path="D:"+File.separator+"oa"+File.separator+"PrjProgressFill"+File.separator+id;
				String webApps=uuid.getWebAppFile();
				String path=webApps+id;
				File f=new File(path);
				if(!f.exists()){
					f.mkdirs();
				}
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				list.add(accessory);
			}
			pf.setAccessory(list);
		}
		String taskNo=pf.getTaskNo();
		double cost=ccDao.selectSumMoneyByNo(taskNo);//项目累计成本
		double cost2=sccDao.selectSumMoneyByNo(taskNo);//检测二部项目累计成本
		double allCost=cost+cost2;//财务累计成本
		double cwwx=0;//财务外协费
		double fbIncome=0;//分包累计收入
		List<PrjProgressFillFb> ppfb=pf.getPpfb();
		for(int ii=0;ii<ppfb.size();ii++){
			fbIncome=fbIncome+ppfb.get(ii).getIncomeBq();
		}
		
		/*累计成本=财务累计成本-财务外协费+分包累计收入（预算分包收入）*/
		double totalCost=allCost-cwwx+fbIncome;
		double prjIncome=pf.getAllMoneyYuan();//项目累计收入
		double prjMoney=pf.getPrjMoney();//任务单金额
		double ysCost=pf.getBudgetMoneyAll();//任务总预算
		if((totalCost/prjIncome)>(1*ysCost/prjMoney)){
			pf.setStatus(1);
		}else{
			pf.setStatus(3);
		}
		
		int i=service.addPrjProgressFill(pf);
		if(i>0){
			Task ta=tService.selectPrjLeaderByPrjNo(pf.getTaskNo());
			String mainDepartment=ta.getMainDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(pf.getPrjName()+"进度管理");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(pf.getPrjName()+"进度管理流程保存");
			currentFlow.setUrl("shengchanguanliLook/ProgressManagement.html-"+id);
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
	
	
	@RequestMapping("/addPrjProgressFillBySubmit")
	@ResponseBody
	public String addPrjProgressFillBySubmit(String ppf,@RequestParam MultipartFile [] file,HttpSession session) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("ppfi", PrjProgressFillInfo.class);
		/*classMap.put("ppfi2", PrjProgressFillInfo.class);*/
		/*classMap.put("ppfi3", PrjProgressFillInfo.class);
		classMap.put("ppfi4", PrjProgressFillInfo.class);
		classMap.put("ppfi5", PrjProgressFillInfo.class);
		classMap.put("ppfi6", PrjProgressFillInfo.class);*/
		classMap.put("ppfb", PrjProgressFillFb.class);
		/*classMap.put("ppcj", PrjProgressFillCj.class);*/
		JSONObject jsonObject=JSONObject.fromObject(ppf);
		PrjProgressFill pf=(PrjProgressFill)JSONObject.toBean(jsonObject, PrjProgressFill.class,classMap);
		pf.setPpfId(id);
		
		if(file!=null){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				//String path="D:"+File.separator+"oa"+File.separator+"PrjProgressFill"+File.separator+id;
				String webApps=uuid.getWebAppFile();
				String path=webApps+id;
				File f=new File(path);
				if(!f.exists()){
					f.mkdirs();
				}
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				list.add(accessory);
			}
			pf.setAccessory(list);
		}
		/*Task t=tService.selectIdByNo(pf.getTaskNo());
		float prjMoney=t.getPrjEstimateMoney();//项目金额
		float contractMoney=t.getContractMoney();//合同金额
		float allCost=pf.getAllCost();//总累计成本
		float budgetMoney=pf.getBudgetMoneyAll();//总费用预算
		float allMoney=Float.valueOf(pf.getAllMoney().replace("%", ""));
		float am=allMoney/100;//总累计收入
		float allValue=am*prjMoney;//累计产值
		if((allCost/allValue)>(budgetMoney/contractMoney)){
			pf.setStatus(1);
		}else{
			pf.setStatus(3);
		}*/
		pf.setStatus(0);
		int i=service.addPrjProgressFill(pf);
		String string=i+"";
		if(i>0){
			Task ta=tService.selectPrjLeaderByPrjNo(pf.getTaskNo());
			String mainDepartment=ta.getMainDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(pf.getPrjName()+"进度管理");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(pf.getPrjName()+"进度管理流程发起");
			currentFlow.setUrl("shengchanguanliLook/ProgressManagement.html-"+id);
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
	
	@RequestMapping("/selectPrjProgressFill")
	@ResponseBody
	public List<PrjProgressFill> selectPrjProgressFill(String status){
		return service.selectPrjProgressFill(status);
	}
	
	@RequestMapping("/selectPrjProgressFillInfo")
	@ResponseBody
	public PrjProgressFill selectPrjProgressFillInfo(String id){
		PrjProgressFill ppf=service.selectPrjProgressFillById(id);
		List<PrjProgressFillInfo> ppfi=service.selectPrjProgressFillInfo(id, "1");
		/*List<PrjProgressFillInfo> ppfi2=service.selectPrjProgressFillInfo(id, "2");*/
		/*List<PrjProgressFillInfo> ppfi3=service.selectPrjProgressFillInfo(id, "3");
		List<PrjProgressFillInfo> ppfi4=service.selectPrjProgressFillInfo(id, "4");
		List<PrjProgressFillInfo> ppfi5=service.selectPrjProgressFillInfo(id, "5");
		List<PrjProgressFillInfo> ppfi6=service.selectPrjProgressFillInfo(id, "6");*/
		/*List<PrjProgressFillCj> ppcj=service.selectPrjProgressFillCjById(id);*/
		List<PrjProgressFillFb> ppfb=service.selectPrjProgressFillFbByPpfId(id);
		List<Accessory> accessory=aService.selectAccessoryById(id);
		String no=ppf.getTaskNo();
		CjContract cj=cService.selectCjContractLikeTaskNo(no);
		ppf.setCj(cj);
		BudgetFpplicationForm bf=bService.selectBudgeByNo(no);
		if(bf!=null){
			ppf.setBudgetMoneyAll(bf.getAllCost());
		}else{
			ppf.setBudgetMoneyAll(0);
		}
		ppf.setPpfi(ppfi);
		/*ppf.setPpfi2(ppfi2);*/
		/*ppf.setPpfi3(ppfi3);
		ppf.setPpfi4(ppfi4);
		ppf.setPpfi5(ppfi5);
		ppf.setPpfi6(ppfi6);*/
		/*ppf.setPpcj(ppcj);*/
		ppf.setPpfb(ppfb);
		ppf.setAccessory(accessory);
		return ppf;
	}
	
	@RequestMapping("/initTable2")
	@ResponseBody
	public List<CjContract> initTable2(){
		List<CjContract> list=new ArrayList<>();
		List<PrjProgressFill> ppf=service.selectPrjProgressFill("2");
		for(int i=0;i<ppf.size();i++){
			try {
				String taskNo=ppf.get(i).getTaskNo();
				String thisTime=ppf.get(i).getThisTime();
				String aas=ppf.get(i).getContractIncome().equals("")?"0":ppf.get(i).getContractIncome();
				double plan=Double.valueOf(aas.replace("%", ""));
				CjContract cj=cService.selectCjContractLikeTaskCode("%"+taskNo+"%");
				if(cj!=null){
					if(list.size()!=0){
						int end=0;
						for(int ii=0;ii<list.size();ii++){
							if(list.get(ii).getContractNo().equals(cj.getContractNo())&&list.get(ii).getContractSignTime().equals(thisTime)){
								 end=1;
								 double old_plan=Double.valueOf(list.get(ii).getWorkInfo().replace("%", ""));
								 if(old_plan<plan){
									 list.get(ii).setWorkInfo(plan+"%");
								 }
							}
						}
						if(end==0){
							cj.setContractSignTime(thisTime);
							cj.setWorkInfo(plan+"%");
							list.add(cj);
						}
					}else{
						cj.setContractSignTime(thisTime);
						cj.setWorkInfo(plan+"%");
						list.add(cj);
					}
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	@RequestMapping("/selectAllByNo")
	@ResponseBody
	public Map<String,Object> selectAllByNo(String no){
		Map<String,Object> map=new HashMap<>();
		Task t=tService.selectIdByNo2(no);
		map.put("task", t);
		BudgetFpplicationForm bf=bService.selectBudgeByNo(no);
		map.put("bf", bf);
		CjContract cj=service.selectCjContractAndPrjProgressFillCj(no);
		map.put("cj", cj);
		return map;
	}
	
	@RequestMapping("/selectAllByName")
	@ResponseBody
	public Map<String,Object> selectAllByName(String name){
		Map<String,Object> map=new HashMap<>();
		Task t=tService.selectNoByName2(name);
		String no=t.getPrjNo();
		map.put("task", t);
		BudgetFpplicationForm bf=bService.selectBudgeByName(name);
		map.put("bf", bf);
		CjContract cj=service.selectCjContractAndPrjProgressFillCj(no);
		map.put("cj", cj);
		return map;
	}
	
	@RequestMapping("/getPresent")
	@ResponseBody
	public Map<String,String> getPresent(String all,String no){
		Map<String,String> map=new HashMap<>();
		PrjProgressFill pf=service.selectLastPrjProgressFill(no);
		float a=Float.valueOf(all.replace("%",""));
		float l=0;
		if(pf!=null){
			String last=pf.getAllMoney();
			l=Float.valueOf(last.replace("%",""));
		}
		float p=a-l;
		String present=p+"%";
		map.put("present", present);
		return map;
	}
	
	@RequestMapping("/getBq")
	@ResponseBody
	public Map<String,String> getBq(String all,String no,String department){
		Map<String,String> map=new HashMap<>();
		PrjProgressFill pf=service.selectLastPrjProgressFill(no);
		float a=Float.valueOf(all.replace("%",""));
		float m=0;
		if(pf!=null){
			String ppfId=pf.getPpfId();
			PrjProgressFillInfo ppfi=service.getLastByDepartmentAndId(ppfId, department);
			if(ppfi!=null){
				String money=ppfi.getMoney();
				m=Float.valueOf(money.replace("%",""));
			}
		}
		float p=a-m;
		String bq=p+"%";
		map.put("bq", bq);
		return map;
	}
	
	/*@RequestMapping("/cjBq")
	@ResponseBody
	public Map<String,String> cjBq(String all,String no,String id){
		Map<String,String> map=new HashMap<>();
		PrjProgressFill pf=service.selectLastPrjProgressFill(no);
		float a=Float.valueOf(all.replace("%",""));
		float m=0;
		if(pf!=null){
			String ppfId=pf.getPpfId();
			PrjProgressFillCj cj=service.cjBq(ppfId, id);
			if(cj!=null){
				String incomeAll=cj.getIncomeAll();
				m=Float.valueOf(incomeAll.replace("%",""));
			}
		}
		float p=a-m;
		String bq=p+"%";
		map.put("bq", bq);
		return map;
	}*/
	
	@RequestMapping("/selectPrjProgressFillByStatus")
	@ResponseBody
	public List<PrjProgressFill> selectPrjProgressFillByStatus(int status){
		 List<PrjProgressFill> list=service.selectPrjProgressFillByStatus(status);
		 for(int i=0;i<list.size();i++){
			 String taskNo=list.get(i).getTaskNo();
			 double cost=ccDao.selectSumMoneyByNo(taskNo);//项目累计成本
			 double cost2=sccDao.selectSumMoneyByNo(taskNo);//检测二部项目累计成本
			 double allCost=cost+cost2;//财务累计成本
			 list.get(i).setTotalCost(allCost);
			 BudgetFpplicationForm bf=bService.selectBudgeByNo(taskNo);
			 if(bf!=null){
				 list.get(i).setBudgetMoneyAll(bf.getAllCost());
			 }else{
				 list.get(i).setBudgetMoneyAll(0);
			 }
		 }
		 return list;
	}
	
	@RequestMapping("/updateStatusAndDesc")
	@ResponseBody
	public int updateStatusAndDesc(int status,String infos,String id){
		int i=service.updateStatusAndDesc(status, infos,id);
		return i;
	}
	
	@RequestMapping("/selectAllCostAndJd")
	@ResponseBody
	public PrjProgressFill selectAllCostAndJd(String taskNo){
		PrjProgressFill pf=service.selectAllCostAndJd(taskNo);
		return pf;
	}
	
	@RequestMapping("/selectNewest")
	@ResponseBody
	public List<PrjProgressFill> selectNewest(){
		List<PrjProgressFill> ppf=service.selectNewest();
		return ppf;
	}
	
	@RequestMapping("/updatePrjProgressFill")
	@ResponseBody
	public int updatePrjProgressFill(String ppf,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("ppfi", PrjProgressFillInfo.class);
		classMap.put("ppfb", PrjProgressFillFb.class);
		JSONObject jsonObject=JSONObject.fromObject(ppf);
		PrjProgressFill pf=(PrjProgressFill)JSONObject.toBean(jsonObject, PrjProgressFill.class,classMap);
		String id=pf.getPpfId();
		if(file!=null){
			TimeUUID uuid=new TimeUUID();
			String webApps=uuid.getWebAppFile();
			String path=webApps+id;
			File f=new File(path);
			if(!f.exists()){
				f.mkdirs();
			}
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				list.add(accessory);
			}
			pf.setAccessory(list);
		}
		int i=service.updatePrjProgressFill(pf);
		if(i>0){
			
		}
		return i;
	}
	
	
	@RequestMapping("/getPrjAllMoney")
	@ResponseBody
	public Map<String,Object> getPrjAllMoney(String no,int fbNum){
		Map<String,Object> map=new HashMap<>();
		PrjProgressFill pf=service.selectLastPrjProgressFill(no);
		double last=0;
		if(pf!=null){
			last=pf.getAllMoneyYuan();
		}
		List<CostBudget> cb=new ArrayList<>();
		if(fbNum==0){
			cb=bService.selectNwCostByTaskNoAndDept(no, "劳务分包费");
		}
		CjContract cj=cService.selectCjContractLikeTaskNo(no);
		double allMoney=0;
		if(cj!=null){
			String prjNo=cj.getTaskCode();
			for(int i=0;i<prjNo.split(",").length;i++){
				PrjProgressFill pf2=service.selectLastPrjProgressFill(prjNo.split(",")[i]);
				if(pf2!=null){
					double allMoneyYuan=pf2.getAllMoneyYuan();
					allMoney=allMoney+allMoneyYuan;
				}
			}
		}
		map.put("present", last);
		map.put("allMoney", allMoney);
		map.put("cb", cb);
		return map;
	}
	
	
	@RequestMapping("/selectPrjProgressFillFbByFbId")
	@ResponseBody
	public float selectPrjProgressFillFbByFbId(String id){
		PrjProgressFillFb fb=service.selectPrjProgressFillFbByFbId(id);
		if(fb!=null){
			return fb.getIncomeAll();
		}else{
			return 0;
		}
	}
	
	@RequestMapping("/selectPrjProgressFillCjIncomeBq")
	@ResponseBody
	public float selectPrjProgressFillCjIncomeBq(String id,String bq){
		PrjProgressFillCj cj=service.selectPrjProgressFillCjIncomeBq(id, bq);
		if(cj!=null){
			return cj.getIncomeBq();
		}else{
			return 0;
		}
	}
	
	@RequestMapping("/selectPrjProgressFillInfoTotalByTaskAndDept")
	@ResponseBody
	public float selectPrjProgressFillInfoTotalByTaskAndDept(String no,String dept){
		PrjProgressFillInfo info=service.selectPrjProgressFillInfoTotalByTaskAndDept(no, dept);
		float money=info.getAllMoneyYuan();
		return money;
	}
	
	@RequestMapping("/selectNewFbInfoByFbId")
	@ResponseBody
	public Map<String,PrjProgressFillFb> selectNewFbInfoByFbId(String no){
		Map<String,PrjProgressFillFb> map=new HashMap<>();
		PrjProgressFillFb ppfb=service.selectNewFbInfoByFbId(no);
		map.put("ppfb", ppfb);
		return map;
	}
	
}

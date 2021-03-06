package org.ldxx.controller;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.CjContract;
import org.ldxx.bean.DepartmentTarget;
import org.ldxx.bean.FinancialReceipts;
import org.ldxx.bean.MonthTarget;
import org.ldxx.bean.OperationTarget;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.OtherContract;
import org.ldxx.bean.PrjProgressFill;
import org.ldxx.bean.PrjProgressFillInfo;
import org.ldxx.bean.TDepartment;
import org.ldxx.bean.Task2;
import org.ldxx.bean.User;
import org.ldxx.service.BudgetFpplicationFormService;
import org.ldxx.service.CjContractService;
import org.ldxx.service.DepartmentTargetService;
import org.ldxx.service.FinancialReceiptsService;
import org.ldxx.service.MonthTargetService;
import org.ldxx.service.OperationTargetService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.OtherContractService;
import org.ldxx.service.PrjProgressFillService;
import org.ldxx.service.TDepartmentService;
import org.ldxx.service.Task2Service;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

//import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("operationTarget")
public class OperationTargetController {

	@Autowired
	private OperationTargetService oservice;
	
	@Autowired
	private DepartmentTargetService dservice;
	@Autowired
	private MonthTargetService mservice;
	@Autowired
	private PrjProgressFillService pService;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private BudgetFpplicationFormService bService;
	@Autowired
	private FinancialReceiptsService fservice;//项目款认领
	@Autowired
	private CjContractService cjservice;//承接合同
	@Autowired
	private OtherContractService ocservice;//其他合同
	@Autowired
	private PrjProgressFillService ppfservice;//合同进度
	@Autowired
	private Task2Service tService;//检测二部
	@Autowired
	private TDepartmentService tdService;//检测二部部门收入
	
	@RequestMapping("/addOperationTargetBySave")
	@ResponseBody
	public int addOperationTargetBySave(OperationTarget target){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		target.setOtId(id);
		int i=oservice.addOperationTarget(target);
		return i;
	}
	
	@RequestMapping("/addOperationTargetBySubmit")
	@ResponseBody
	public int addOperationTargetBySubmit(OperationTarget target){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		target.setOtId(id);
		int i=oservice.addOperationTarget(target);
		return i;
	}
	
	@RequestMapping("/deleteOperationTarget")
	@ResponseBody
	public int deleteOperationTarget(String id){
		int i=oservice.deleteOperationTargetById(id);
		return i;
	}
	
	@RequestMapping("/updateOperationTargetBySave")
	@ResponseBody
	public int updateOperationTargetBySave(OperationTarget target){
		int i=oservice.updateOperationTarget(target);
		return i;
	}
	
	@RequestMapping("/updateOperationTargetBySubmit")
	@ResponseBody
	public int updateOperationTargetBySubmit(OperationTarget target){
		int i=oservice.updateOperationTarget(target);
		return i;
	}
	
	@RequestMapping("/selectOperationTargetByNowYear")
	@ResponseBody
	public Map<String,Object> selectOperationTargetByNowYear(String year){
		Map<String,Object> map=new HashMap<>();
		//获取公司各种金额
		String resultGs=oservice.selectGsOperationTargetByTime(year+"");
		JSON jsonObject= JSON.parseObject(resultGs);
		OperationTarget ot = new OperationTarget();
		if(jsonObject!=null){
			ot=jsonObject.toJavaObject(OperationTarget.class);
		}else{
			ot.setXqhte(new BigDecimal(0));
			ot.setSr(new BigDecimal(0));
			ot.setSk(new BigDecimal(0));
			ot.setLr(new BigDecimal(0));
		}
		//JSONObject jsonObject=JSONObject.fromObject(resultGs);
		//OperationTarget ot=(OperationTarget)JSONObject.toBean(jsonObject, OperationTarget.class);
		//获取公司各个目标
		OperationTarget ot2=oservice.selectOperationTargetByYear(year+"");
		ot.setYear(year+"");
		if(null!=ot2) {
			ot.setOtId(ot2.getOtId());
			ot.setContractAmount(ot2.getContractAmount());
			ot.setRevenueTarget(ot2.getRevenueTarget());
			ot.setCollectionTarget(ot2.getCollectionTarget());
			ot.setProfit(ot2.getProfit());
		}else {
			ot.setContractAmount(new BigDecimal(0));
			ot.setRevenueTarget(new BigDecimal(0));
			ot.setCollectionTarget(new BigDecimal(0));
			ot.setProfit(new BigDecimal(0));
		}
		
		map.put("ot", ot);
		return map;
		
	}
	
	@RequestMapping("/selectOperationTarget")
	@ResponseBody
	public List<OperationTarget> selectOperationTarget(){
		List<OperationTarget> list=oservice.selectOperationTarget();
		/*int count=oservice.countOperationTarget();
		if(count>0){*/
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
			String nowYear=sdf.format(new Date());
			int nowY=Integer.valueOf(nowYear);
			for(int i=2018;i<=nowY;i++){
				
				//获取完成收入  直接成本   完成收款等信息 
				String resultGs=oservice.selectGsOperationTargetByTime(i+"");
				
				
				JSON jsonObject= JSON.parseObject(resultGs);
				OperationTarget ot=null;
				if(jsonObject!=null){
					ot = jsonObject.toJavaObject(OperationTarget.class);
					
				}
				
				//JSONObject jsonObject=JSONObject.fromObject(resultGs);
				//OperationTarget ot=(OperationTarget)JSONObject.toBean(jsonObject, OperationTarget.class);
				
				OperationTarget ot2=oservice.selectOperationTargetByYear(i+"");
				OperationTarget new_ot=new OperationTarget();
				
				if(ot2!=null){
					new_ot.setOtId(ot2.getOtId());
					new_ot.setYear(ot2.getYear());
					//新签合同额目标
					new_ot.setContractAmount(ot2.getContractAmount());
					//收入目标
					new_ot.setRevenueTarget(ot2.getRevenueTarget());
					//收款目标
					new_ot.setCollectionTarget(ot2.getCollectionTarget());
					//利润目标
					new_ot.setProfit(ot2.getProfit());
					
				}else{
					new_ot.setOtId("");
					new_ot.setYear(i+"");
					new_ot.setContractAmount(new BigDecimal(0));
					new_ot.setRevenueTarget(new BigDecimal(0));
					new_ot.setCollectionTarget(new BigDecimal(0));
					new_ot.setProfit(new BigDecimal(0));
				}
				if(ot!=null){
					//新签合同额
					new_ot.setXqhte(ot.getXqhte());
					//完成收入
					new_ot.setSr(ot.getSr());
					//完成收款
					new_ot.setSk(ot.getSk());
					//直接成本
					new_ot.setZjcb(ot.getZjcb());
					//间接成本
					new_ot.setJjcb(ot.getJjcb());
					//完成利润
					new_ot.setLr(ot.getLr());
					//已签订承接合同额
					new_ot.setCjhte(ot.getCjhte());
				}else{
					//新签合同额
					new_ot.setXqhte(new BigDecimal(0));
					//完成收入
					new_ot.setSr(new BigDecimal(0));
					//完成收款
					new_ot.setSk(new BigDecimal(0));
					//直接成本
					new_ot.setZjcb(new BigDecimal(0));
					//间接成本
					new_ot.setJjcb(new BigDecimal(0));
					//完成利润
					new_ot.setLr(new BigDecimal(0));
					//已签订承接合同额
					new_ot.setCjhte(new BigDecimal(0));
				}
				if(new_ot!=null){
					list.add(new_ot);
				}
			}
		/*}*/
		return list;
		/*for(int i=0;i<list.size();i++){
			float budgetCost=oservice.getSumCostByYear(list.get(i).getYear());
			list.get(i).setBudgetCost(budgetCost);
			List<PrjProgressFill> noList=pService.selectDistinctTaskNo(list.get(i).getYear());
			float actualCost=0;
			if(noList!=null){
				for(int j=0;j<noList.size();j++){
					PrjProgressFill ppf=pService.getCost(noList.get(j).getTaskNo());
					float cost=0;
					if(ppf!=null){
						cost=ppf.getAllCost();
					}
					actualCost=actualCost+cost;
				}
			}
			list.get(i).setActualCost(actualCost);
			
			
			//实际收款
			String y=list.get(i).getYear()+"%";
			List<FinancialReceipts> frList=fservice.selectFinancialReceiptsByYear(y);//先通过年份获取财务收款列表
			float money=0;//实际收款
			if(frList!=null){
				for(int j=0;j<frList.size();j++){
					float resultMoney = frList.get(j).getResultMoney();//实际收款
					String contractNo = frList.get(j).getContractNo();//得到合同的编号
					CjContract cjContract = cjservice.selectCjByCjNo(contractNo);//查承接合同
					if(cjContract!=null){
						float contractMoney = cjContract.getContractMoney();//合同金额
						String mainDepartment=cjContract.getMainDepartment();//主办部门
						if(mainDepartment!=null){
							float mainDepartmentMoney=cjContract.getMainDepartmentMoney();//主办部门金额
							money=money+(mainDepartmentMoney/contractMoney*resultMoney);
						}
						String assistDepartment1 = cjContract.getAssistDepartment1();//协办部门1
						if(assistDepartment1!=null){
							float assistDepartment1Money = cjContract.getAssistDepartment1Money();//协办部门1金额
							money=money+(assistDepartment1Money/contractMoney*resultMoney);
						}
						String assistDepartment2 = cjContract.getAssistDepartment2();//协办部门2
						if(assistDepartment2!=null){
							float assistDepartment2Money = cjContract.getAssistDepartment2Money();//协办部门2金额
							money=money+(assistDepartment2Money/contractMoney*resultMoney);
						}
						String assistDepartment3 = cjContract.getAssistDepartment3();//协办部门3
						if(assistDepartment3!=null){
							float assistDepartment3Money = cjContract.getAssistDepartment3Money();//协办部门3金额
							money=money+(assistDepartment3Money/contractMoney*resultMoney);
						}
					}else{//查其他合同
						OtherContract otherContract = ocservice.selectOtherContractByNo(contractNo);
						if(otherContract!=null){
							String department = otherContract.getAbutmentDepartment();//合同部门
							if(department!=null){
								money=money+resultMoney;
							}
						}
					}
				}
			}
			float actualPayment= new BigDecimal(money).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
			list.get(i).setActualPayment(actualPayment);
			
			//实际收入
			String modestatus="2";
			List<PrjProgressFill> ppf2=ppfservice.selectPrjProgressFillByYear(modestatus,y);//通过年限查询今年项目进度列表
			List<Task2> task2List=tService.selectTask2ByYear(y);//通过年限查询今年检测二部的任务单项目列表
			float money1=0;//进度部门总收入
			if(ppf2!=null){
				for(int j=0;j<ppf2.size();j++){
					float allIncome = ppf2.get(j).getAllIncome();//总实际收入
					List<PrjProgressFillInfo> ppfi=ppfservice.selectPrjProgressFillInfo(ppf2.get(j).getPpfId(), "1");//查询该项目的部门及累计收入
					if(ppfi!=null){
						for(int jj=0;jj<ppfi.size();jj++){
							String mon = ppfi.get(jj).getMoney();//得到该项目进度下所有部门百分比金额
							float f=0;
							if(mon.contains("%")){
								mon=mon.replaceAll("%", "");
								f = (BigDecimal.valueOf(mon))/100;//换算成小数
							}
							money1=money1+(f*allIncome);
						}
					}
				}
			}
			float money2=0;//检测二部部门总收入
			if(task2List.size()!=0){
				for(int ii=0;ii<task2List.size();ii++){
					String no = task2List.get(ii).gettNo();
					List<TDepartment> tDepartment = tdService.selectDepartment(no);//根据项目编号查找这个项目下的所有部门收入信息
					if(tDepartment.size()!=0){
						for(int j=0;j<tDepartment.size();j++){
							float income = tDepartment.get(j).getdIncome();//得到每个项目的部门收入
								money2=money2+(income/10000);
						}
					}
				}
			}
			float value=money1+money2;
			//float realIncome=(float)(Math.round(value*100)/100.0);
			float mon2= new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
			list.get(i).setRealIncome(mon2);
			
			
			//实际合同额
			float actualMoney=0;//实际合同额
			if(frList.size()!=0){
				for(int j=0;j<frList.size();j++){
					String contractNo = frList.get(j).getContractNo();//得到合同的编号
					CjContract cjContract = cjservice.selectCjByCjNo(contractNo);//查承接合同
					if(cjContract!=null){
						String name = cjContract.getName();//合同主办部门名称
						if(name!=null){
							float mainDepartmentMoney=cjContract.getMainDepartmentMoney();//主办部门金额
							actualMoney=actualMoney+mainDepartmentMoney;
						}
						String name2 = cjContract.getName2();//合同协办部门1名称
						if(name2!=null){
							float assistDepartment1Money = cjContract.getAssistDepartment1Money();//协办部门1金额
							actualMoney=actualMoney+assistDepartment1Money;
						}
						String name3 = cjContract.getName3();//合同协办部门2名称
						if(name3!=null){
							float assistDepartment2Money = cjContract.getAssistDepartment2Money();//协办部门2金额
							actualMoney=actualMoney+assistDepartment2Money;
						}
						String name4 = cjContract.getName4();//合同协办部门3名称
						if(name4!=null){
							float assistDepartment3Money = cjContract.getAssistDepartment3Money();//协办部门3金额
							actualMoney=actualMoney+assistDepartment3Money;
						}
					}else{//查其他合同
						OtherContract otherContract = ocservice.selectOtherContractByNo(contractNo);
						if(otherContract!=null){
							BigDecimal contractMoney = otherContract.getContractMoney();//合同金额
							String omName2 = otherContract.getOmName();//其他合同的合同部门名称
							if(omName2!=null){
								actualMoney=actualMoney+contractMoney;
							}
						}
					}
				}
			}
			float actualMoney2=0;//检测二部的部门合同金额
			if(task2List.size()!=0){
				for(int ii=0;ii<task2List.size();ii++){
					String no = task2List.get(ii).gettNo();
					List<TDepartment> tDepartment = tdService.selectDepartment(no);//根据项目编号查找这个项目下的所有部门收入信息
					if(tDepartment.size()!=0){
						for(int j=0;j<tDepartment.size();j++){
							String name = tDepartment.get(j).getdName();//得到每个项目的部门名称
							float dMoney = tDepartment.get(j).getdMoney();//得到每个项目的部门合同金额
							if(name!=null){
								actualMoney2=actualMoney2+(dMoney/10000);
							}
						}
					}
				}
			}
			float sjcontractmoney=actualMoney+actualMoney2;
	       	float allmon= new BigDecimal(sjcontractmoney).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
			list.get(i).setActualContractAmount(allmon);
			
			
		}*/
	}
	
	/***********************************************部门指标**************************************************/
	@RequestMapping("/orNotSplit")
	@ResponseBody
	public int orNotSplit(String id){
		int i=dservice.orNotSplit(id);
		return i;
	}
	
	@RequestMapping("/addDepartmentTargetBySave")/*分解公司指标*/
	@ResponseBody
	public int addDepartmentTargetBySave(@RequestBody List<DepartmentTarget> dTarget){
		String otId=dTarget.get(0).getOtId();
		int a=dservice.orNotSplit(otId);
		if(a==0){
			TimeUUID uuid=new TimeUUID();
			for(int i=0;i<dTarget.size();i++){
				String id=uuid.getTimeUUID();
				dTarget.get(i).settId(id);
			}
			a=dservice.addDepartmentTarget(dTarget);
		}else{
			a=dservice.updateDepartmentTarget(dTarget);
		}
		return a;
	}
	
	
	@RequestMapping("/selectDepartmentTarget")/*查看公司指标下部门指标列表*/
	@ResponseBody
	public List<DepartmentTarget> selectDepartmentTarget(String id,String year){
		String resultBm=oservice.selectBmOperationTargetByTime(year);
		List<DepartmentTarget> dt=(List<DepartmentTarget>)JSONArray.parseArray(resultBm, DepartmentTarget.class);
		for(int i=0;i<dt.size();i++){
			String bmmc=dt.get(i).getBmmc();
			OrganizationManagement om=oService.getOrgIdByName(bmmc);
			DepartmentTarget d=dservice.selectDepartmentTargetByIdAndOmId(id, om.getOmId());
			if(d!=null){
				dt.get(i).settId(d.gettId());
				dt.get(i).setOtId(d.getOtId());
				dt.get(i).setContractAmount(d.getContractAmount());
				dt.get(i).setRevenueTarget(d.getRevenueTarget());
				dt.get(i).setCollectionTarget(d.getCollectionTarget());
				dt.get(i).setProfit(d.getProfit());
			}else{
				dt.get(i).settId("");
				dt.get(i).setOtId("");
				dt.get(i).setContractAmount(new BigDecimal(0));
				dt.get(i).setRevenueTarget(new BigDecimal(0));
				dt.get(i).setCollectionTarget(new BigDecimal(0));
				dt.get(i).setProfit(new BigDecimal(0));
			}
			dt.get(i).setXqhte(dt.get(i).getXqhte());
			dt.get(i).setSr(dt.get(i).getSr());
			dt.get(i).setSk(dt.get(i).getSk());
			dt.get(i).setZjcb(dt.get(i).getZjcb());
			dt.get(i).setJjcb(dt.get(i).getJjcb());
			dt.get(i).setLr(dt.get(i).getLr());
		}
		return dt;
		/*List<DepartmentTarget> list=dservice.selectDepartmentTarget(id);
		String y=year+"%";
		List<FinancialReceipts> frList=fservice.selectFinancialReceiptsByYear(y);//先通过年份获取财务收款列表
		String modestatus="2";
		List<PrjProgressFill> ppf2=ppfservice.selectPrjProgressFillByYear(modestatus,y);//通过年限查询今年项目进度列表
		List<Task2> task2List=tService.selectTask2ByYear(y);//通过年限查询今年检测二部的任务单项目列表
		if(list!=null){
			for(int i=0;i<list.size();i++){
				String om_id=list.get(i).getOmId();
				OrganizationManagement om=oService.getOrgNameById(om_id);
				String omName=om.getOmName();
				float actualCost=0;//获取部门实际成本
				PrjProgressFillInfo fillInfo=pService.selectYearCostByDepartment(omName, "%"+year+"%");
				if(fillInfo!=null){
					actualCost=BigDecimal.valueOf(fillInfo.getMoney());
				}
				list.get(i).setActualCost(actualCost);
				
				float budgetCost=bService.getBudgeCost(om_id, y); //获取预算成本
				list.get(i).setBudgetCost(budgetCost);
				
				//实际合同额
				float actualMoney=0;//实际合同额
				if(frList.size()!=0){
					for(int j=0;j<frList.size();j++){
						String contractNo = frList.get(j).getContractNo();//得到合同的编号
						CjContract cjContract = cjservice.selectCjByCjNo(contractNo);//查承接合同
						if(cjContract!=null){
							String name = cjContract.getName();//合同主办部门名称
							if(name!=null && omName.equals(name)){
								float mainDepartmentMoney=cjContract.getMainDepartmentMoney();//主办部门金额
								actualMoney=actualMoney+mainDepartmentMoney;
							}
							String name2 = cjContract.getName2();//合同协办部门1名称
							if(name2!=null && omName.equals(name2)){
								float assistDepartment1Money = cjContract.getAssistDepartment1Money();//协办部门1金额
								actualMoney=actualMoney+assistDepartment1Money;
							}
							String name3 = cjContract.getName3();//合同协办部门2名称
							if(name3!=null && omName.equals(name3)){
								float assistDepartment2Money = cjContract.getAssistDepartment2Money();//协办部门2金额
								actualMoney=actualMoney+assistDepartment2Money;
							}
							String name4 = cjContract.getName4();//合同协办部门3名称
							if(name4!=null && omName.equals(name4)){
								float assistDepartment3Money = cjContract.getAssistDepartment3Money();//协办部门3金额
								actualMoney=actualMoney+assistDepartment3Money;
							}
						}else{//查其他合同
							OtherContract otherContract = ocservice.selectOtherContractByNo(contractNo);
							if(otherContract!=null){
								BigDecimal contractMoney = otherContract.getContractMoney();//合同金额
								String omName2 = otherContract.getOmName();//其他合同的合同部门名称
								if(omName2!=null && omName.equals(omName2)){
									actualMoney=actualMoney+contractMoney;
								}
							}
						}
					}
				}
				float actualMoney2=0;
				if(task2List.size()!=0){
					for(int ii=0;ii<task2List.size();ii++){
						String no = task2List.get(ii).gettNo();
						List<TDepartment> tDepartment = tdService.selectDepartment(no);//根据项目编号查找这个项目下的所有部门收入信息
						if(tDepartment.size()!=0){
							for(int j=0;j<tDepartment.size();j++){
								String name = tDepartment.get(j).getdName();//得到每个项目的部门名称
								float dMoney = tDepartment.get(j).getdMoney();//得到每个项目的部门合同收入（单位元需/10000）
								if(name.contains(omName)){
									actualMoney2=actualMoney2+(dMoney/10000);
								}
							}
						}
					}
				}
				float sjcontractmoney=actualMoney+actualMoney2;
				float allmon1 = new BigDecimal(sjcontractmoney).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
				list.get(i).setActualContractAmount(allmon1);
				
				
				//获取实际收款
				float actualPayment=0;//获取部门实际收款（先得到财务收款列表，通过合同号得到合同部门分配金额,合同部门分配金额/合同总金额*项目收款的实际收款）
				if(frList.size()!=0){
					for(int j=0;j<frList.size();j++){
						float money=0;//实际收款
						float resultMoney = frList.get(j).getResultMoney();//实际收款
						String contractNo = frList.get(j).getContractNo();//得到合同的编号
						CjContract cjContract = cjservice.selectCjByCjNo(contractNo);//查承接合同
						if(cjContract!=null){
							float contractMoney = cjContract.getContractMoney();//合同金额
							String mainDepartment=cjContract.getMainDepartment();//主办部门
							if(mainDepartment!=null && om_id.equals(mainDepartment)){
								float mainDepartmentMoney=cjContract.getMainDepartmentMoney();//主办部门金额
								money=mainDepartmentMoney/contractMoney*resultMoney;
							}
							String assistDepartment1 = cjContract.getAssistDepartment1();//协办部门1
							if(assistDepartment1!=null && om_id.equals(assistDepartment1)){
								float assistDepartment1Money = cjContract.getAssistDepartment1Money();//协办部门1金额
								money=assistDepartment1Money/contractMoney*resultMoney;
							}
							String assistDepartment2 = cjContract.getAssistDepartment2();//协办部门2
							if(assistDepartment2!=null && om_id.equals(assistDepartment2)){
								float assistDepartment2Money = cjContract.getAssistDepartment2Money();//协办部门2金额
								money=assistDepartment2Money/contractMoney*resultMoney;
							}
							String assistDepartment3 = cjContract.getAssistDepartment3();//协办部门3
							if(assistDepartment3!=null && om_id.equals(assistDepartment3)){
								float assistDepartment3Money = cjContract.getAssistDepartment3Money();//协办部门3金额
								money=assistDepartment3Money/contractMoney*resultMoney;
							}
						}else{//查其他合同
							OtherContract otherContract = ocservice.selectOtherContractByNo(contractNo);
							if(otherContract!=null){
								String department = otherContract.getAbutmentDepartment();//合同部门
								if(department!=null && om_id.equals(department)){
									money=resultMoney;
								}
							}
						}
						float value=actualPayment+money;
						actualPayment=new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
					}
				}
				list.get(i).setActualPayment(actualPayment);
				
				//实际收入
				float realIncome=0;//获取部门实际收入(进度的部门累计百分比*总实际收入+检测二部任务单管理的部门总收入)
				float money1=0;//进度部门总收入
				if(ppf2!=null){
					for(int k=0;k<ppf2.size();k++){
	//					float allIncome = ppf2.get(k).getAllIncome();//总实际收入
						float allIncome =0;
						List<PrjProgressFillInfo> ppfi=ppfservice.selectPrjProgressFillInfo(ppf2.get(k).getPpfId(), "1");
						if(ppfi!=null){
							for(int kk=0;kk<ppfi.size();kk++){
								String department = ppfi.get(kk).getDepartment();//累计收入部门名
								if(department!=null && omName.equals(department)){
									String mon = ppfi.get(kk).getMoney();//得到部门百分比金额
									float f=0;
									if(mon.contains("%")){
										mon=mon.replaceAll("%", "");
										f = (BigDecimal.valueOf(mon))/100;//换算成小数
									}
									money1=money1+(f*allIncome);
								}
							}
						}
					}
				}
				float money2=0;//检测二部部门总收入
				if(task2List.size()!=0){
					for(int ii=0;ii<task2List.size();ii++){
						String no = task2List.get(ii).gettNo();
						List<TDepartment> tDepartment = tdService.selectDepartment(no);//根据项目编号查找这个项目下的所有部门收入信息
						if(tDepartment.size()!=0){
							for(int j=0;j<tDepartment.size();j++){
								String name = tDepartment.get(j).getdName();//得到每个项目的部门名称
								float income = tDepartment.get(j).getdIncome();//得到每个项目的部门收入（单位元需/10000）
								if(name.contains(omName)){
									money2=money2+(income/10000);
								}
							}
						}
					}
				}
				realIncome=money1+money2;
				//realIncome=(float)(Math.round(value*100)/100.0);
				float allmon3= new BigDecimal(realIncome).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
				list.get(i).setRealIncome(allmon3);
			}
		}*/
		
	}
	
	@RequestMapping("/selectDepartmentTargetByOtId")
	@ResponseBody
	public List<DepartmentTarget> selectDepartmentTargetByOtId(String id){
		List<DepartmentTarget> list=dservice.selectDepartmentTarget(id);
		return list;
	}
	
	@RequestMapping("/selectDepartmentTargetByOmId")/*各部门指标列表*/
	@ResponseBody
	public List<DepartmentTarget> selectDepartmentTargetByOmId(HttpSession session){
		List<DepartmentTarget> dtList=new ArrayList<>();
		User user=(User) session.getAttribute("user");
		int count=dservice.countDepartmentTarget(user.getOmId());
		if(count>0){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
			String nowYear=sdf.format(new Date());
			int nowY=Integer.valueOf(nowYear);
			for(int i=2019;i<=nowY;i++){
				String resultBm=oservice.selectBmOperationTargetByTime(i+"");
				List<DepartmentTarget> dt=(List<DepartmentTarget>)JSONArray.parseArray(resultBm, DepartmentTarget.class);
				String omName=user.getOmName();
				for(int j=0;j<dt.size();j++){
					if(dt.get(j).getBmmc().equals(omName)){
						DepartmentTarget d=dt.get(j);
						DepartmentTarget d2=dservice.selectDepartmentTargetByYearAndOmId(i+"", user.getOmId());
						d2.setBmmc(d.getBmmc());
						d2.setXqhte(d.getXqhte());
						d2.setSr(d.getSr());
						d2.setSk(d.getSk());
						d2.setZjcb(d.getZjcb());
						d2.setJjcb(d.getJjcb());
						d2.setLr(d.getLr());
						dtList.add(d2);
					}
				}
			}
		}
		return dtList;
	}
	
	@RequestMapping("/addMonthTargetBySave")/*分解部门月指标*/
	@ResponseBody
	public int addMonthTargetBySave(@RequestBody List<MonthTarget> target){
		String otId=target.get(0).getOtId();
		int i=mservice.orNotSplit(otId);
		if(i>0){
			i=mservice.updateMonthTarget(target);
		}else{
			i=mservice.addMonthTarget(target);
		}
		return i;
	}
	
	@RequestMapping("/selectMonthTargetById")/*查看部门月指标列表*/
	@ResponseBody
	public List<MonthTarget> selectMonthTargetByIdAndType(String tId){
		List<MonthTarget> list=mservice.selectMonthTargetById(tId);
		return list;
	}
	
	@RequestMapping("/getCorporationTarget")
	@ResponseBody
	public List<MonthTarget> getCorporationTarget(String id){
		List<MonthTarget> targetArray=new ArrayList<>();
		int i=mservice.ifTarget(id);
		if(i==0){
			
		}else{
			MonthTarget monthTarget=new MonthTarget();
			BigDecimal targetSumOfList=new BigDecimal(0);
			BigDecimal target2SumOfList=new BigDecimal(0);
			BigDecimal target3SumOfList=new BigDecimal(0);
			List<MonthTarget> list=mservice.selectMonthTargetByMonthSum(id, 1);
			for(int a=0;a<list.size();a++){
				BigDecimal target=list.get(a).getContractAmount();
				targetSumOfList=targetSumOfList.add(target);
				BigDecimal target2=list.get(a).getRevenueTarget();
				target2SumOfList=target2SumOfList.add(target2);
				BigDecimal target3=list.get(a).getCollectionTarget();
				target3SumOfList=target3SumOfList.add(target3);
			}
			monthTarget.setMonth(1);
			monthTarget.setContractAmount(targetSumOfList);
			monthTarget.setRevenueTarget(target2SumOfList);
			monthTarget.setCollectionTarget(target3SumOfList);
			targetArray.add(monthTarget);
			
			MonthTarget monthTarget2=new MonthTarget();
			BigDecimal targetSumOfList2=new BigDecimal(0);
			BigDecimal target2SumOfList2=new BigDecimal(0);
			BigDecimal target3SumOfList2=new BigDecimal(0);
			List<MonthTarget> list2=mservice.selectMonthTargetByMonthSum(id, 2);
			for(int a=0;a<list2.size();a++){
				BigDecimal target=list2.get(a).getContractAmount();
				targetSumOfList2=targetSumOfList2.add(target);
				BigDecimal target2=list2.get(a).getRevenueTarget();
				target2SumOfList2=target2SumOfList2.add(target2);
				BigDecimal target3=list2.get(a).getCollectionTarget();
				target3SumOfList2=target3SumOfList2.add(target3);
			}
			monthTarget2.setMonth(2);
			monthTarget2.setContractAmount(targetSumOfList2);
			monthTarget2.setRevenueTarget(target2SumOfList2);
			monthTarget2.setCollectionTarget(target3SumOfList2);
			targetArray.add(monthTarget2);
			
			MonthTarget monthTarget3=new MonthTarget();
			BigDecimal targetSumOfList3=new BigDecimal(0);
			BigDecimal target2SumOfList3=new BigDecimal(0);
			BigDecimal target3SumOfList3=new BigDecimal(0);
			List<MonthTarget> list3=mservice.selectMonthTargetByMonthSum(id, 3);
			for(int a=0;a<list3.size();a++){
				BigDecimal target=list3.get(a).getContractAmount();
				targetSumOfList3=targetSumOfList3.add(target);
				BigDecimal target2=list3.get(a).getRevenueTarget();
				target2SumOfList3=target2SumOfList3.add(target2);
				BigDecimal target3=list3.get(a).getCollectionTarget();
				target3SumOfList3=target3SumOfList3.add(target3);
			}
			monthTarget3.setMonth(3);
			monthTarget3.setContractAmount(targetSumOfList3);
			monthTarget3.setRevenueTarget(target2SumOfList3);
			monthTarget3.setCollectionTarget(target3SumOfList3);
			targetArray.add(monthTarget3);
			
			MonthTarget monthTarget4=new MonthTarget();
			BigDecimal targetSumOfList4=new BigDecimal(0);
			BigDecimal target2SumOfList4=new BigDecimal(0);
			BigDecimal target3SumOfList4=new BigDecimal(0);
			List<MonthTarget> list4=mservice.selectMonthTargetByMonthSum(id, 4);
			for(int a=0;a<list4.size();a++){
				BigDecimal target=list4.get(a).getContractAmount();
				targetSumOfList4=targetSumOfList4.add(target);
				BigDecimal target2=list4.get(a).getRevenueTarget();
				target2SumOfList4=target2SumOfList4.add(target2);
				BigDecimal target3=list4.get(a).getCollectionTarget();
				target3SumOfList4=target3SumOfList4.add(target3);
			}
			monthTarget4.setMonth(4);
			monthTarget4.setContractAmount(targetSumOfList4);
			monthTarget4.setRevenueTarget(target2SumOfList4);
			monthTarget4.setCollectionTarget(target3SumOfList4);
			targetArray.add(monthTarget4);
			
			MonthTarget monthTarget5=new MonthTarget();
			BigDecimal targetSumOfList5=new BigDecimal(0);
			BigDecimal target2SumOfList5=new BigDecimal(0);
			BigDecimal target3SumOfList5=new BigDecimal(0);
			List<MonthTarget> list5=mservice.selectMonthTargetByMonthSum(id, 5);
			for(int a=0;a<list5.size();a++){
				BigDecimal target=list5.get(a).getContractAmount();
				targetSumOfList5=targetSumOfList5.add(target);
				BigDecimal target2=list5.get(a).getRevenueTarget();
				target2SumOfList5=target2SumOfList5.add(target2);
				BigDecimal target3=list5.get(a).getCollectionTarget();
				target3SumOfList5=target3SumOfList5.add(target3);
			}
			monthTarget5.setMonth(5);
			monthTarget5.setContractAmount(targetSumOfList5);
			monthTarget5.setRevenueTarget(target2SumOfList5);
			monthTarget5.setCollectionTarget(target3SumOfList5);
			targetArray.add(monthTarget5);
			
			MonthTarget monthTarget6=new MonthTarget();
			BigDecimal targetSumOfList6=new BigDecimal(0);
			BigDecimal target2SumOfList6=new BigDecimal(0);
			BigDecimal target3SumOfList6=new BigDecimal(0);
			List<MonthTarget> list6=mservice.selectMonthTargetByMonthSum(id, 6);
			for(int a=0;a<list6.size();a++){
				BigDecimal target=list6.get(a).getContractAmount();
				targetSumOfList6=targetSumOfList6.add(target);
				BigDecimal target2=list6.get(a).getRevenueTarget();
				target2SumOfList6=target2SumOfList6.add(target2);
				BigDecimal target3=list6.get(a).getCollectionTarget();
				target3SumOfList6=target3SumOfList6.add(target3);
			}
			monthTarget6.setMonth(6);
			monthTarget6.setContractAmount(targetSumOfList6);
			monthTarget6.setRevenueTarget(target2SumOfList6);
			monthTarget6.setCollectionTarget(target3SumOfList6);
			targetArray.add(monthTarget6);
			
			MonthTarget monthTarget7=new MonthTarget();
			BigDecimal targetSumOfList7=new BigDecimal(0);
			BigDecimal target2SumOfList7=new BigDecimal(0);
			BigDecimal target3SumOfList7=new BigDecimal(0);
			List<MonthTarget> list7=mservice.selectMonthTargetByMonthSum(id, 7);
			for(int a=0;a<list7.size();a++){
				BigDecimal target=list7.get(a).getContractAmount();
				targetSumOfList7=targetSumOfList7.add(target);
				BigDecimal target2=list7.get(a).getRevenueTarget();
				target2SumOfList7=target2SumOfList7.add(target2);
				BigDecimal target3=list7.get(a).getCollectionTarget();
				target3SumOfList7=target3SumOfList7.add(target3);
			}
			monthTarget7.setMonth(7);
			monthTarget7.setContractAmount(targetSumOfList7);
			monthTarget7.setRevenueTarget(target2SumOfList7);
			monthTarget7.setCollectionTarget(target3SumOfList7);
			targetArray.add(monthTarget7);
			
			MonthTarget monthTarget8=new MonthTarget();
			BigDecimal targetSumOfList8=new BigDecimal(0);
			BigDecimal target2SumOfList8=new BigDecimal(0);
			BigDecimal target3SumOfList8=new BigDecimal(0);
			List<MonthTarget> list8=mservice.selectMonthTargetByMonthSum(id, 8);
			for(int a=0;a<list8.size();a++){
				BigDecimal target=list8.get(a).getContractAmount();
				targetSumOfList8=targetSumOfList8.add(target);
				BigDecimal target2=list8.get(a).getRevenueTarget();
				target2SumOfList8=target2SumOfList8.add(target2);
				BigDecimal target3=list8.get(a).getCollectionTarget();
				target3SumOfList8=target3SumOfList8.add(target3);
			}
			monthTarget8.setMonth(8);
			monthTarget8.setContractAmount(targetSumOfList8);
			monthTarget8.setRevenueTarget(target2SumOfList8);
			monthTarget8.setCollectionTarget(target3SumOfList8);
			targetArray.add(monthTarget8);
			
			MonthTarget monthTarget9=new MonthTarget();
			BigDecimal targetSumOfList9=new BigDecimal(0);
			BigDecimal target2SumOfList9=new BigDecimal(0);
			BigDecimal target3SumOfList9=new BigDecimal(0);
			List<MonthTarget> list9=mservice.selectMonthTargetByMonthSum(id, 9);
			for(int a=0;a<list9.size();a++){
				BigDecimal target=list9.get(a).getContractAmount();
				targetSumOfList9=targetSumOfList9.add(target);
				BigDecimal target2=list9.get(a).getRevenueTarget();
				target2SumOfList9=target2SumOfList9.add(target2);
				BigDecimal target3=list9.get(a).getCollectionTarget();
				target3SumOfList9=target3SumOfList9.add(target3);
			}
			monthTarget9.setMonth(9);
			monthTarget9.setContractAmount(targetSumOfList9);
			monthTarget9.setRevenueTarget(target2SumOfList9);
			monthTarget9.setCollectionTarget(target3SumOfList9);
			targetArray.add(monthTarget9);
			
			MonthTarget monthTarget10=new MonthTarget();
			BigDecimal targetSumOfList10=new BigDecimal(0);
			BigDecimal target2SumOfList10=new BigDecimal(0);
			BigDecimal target3SumOfList10=new BigDecimal(0);
			List<MonthTarget> list10=mservice.selectMonthTargetByMonthSum(id, 10);
			for(int a=0;a<list10.size();a++){
				BigDecimal target=list10.get(a).getContractAmount();
				targetSumOfList10=targetSumOfList10.add(target);
				BigDecimal target2=list10.get(a).getRevenueTarget();
				target2SumOfList10=target2SumOfList10.add(target2);
				BigDecimal target3=list10.get(a).getCollectionTarget();
				target3SumOfList10=target3SumOfList10.add(target3);
			}
			monthTarget10.setMonth(10);
			monthTarget10.setContractAmount(targetSumOfList10);
			monthTarget10.setRevenueTarget(target2SumOfList10);
			monthTarget10.setCollectionTarget(target3SumOfList10);
			targetArray.add(monthTarget10);
			
			MonthTarget monthTarget11=new MonthTarget();
			BigDecimal targetSumOfList11=new BigDecimal(0);
			BigDecimal target2SumOfList11=new BigDecimal(0);
			BigDecimal target3SumOfList11=new BigDecimal(0);
			List<MonthTarget> list11=mservice.selectMonthTargetByMonthSum(id, 11);
			for(int a=0;a<list11.size();a++){
				BigDecimal target=list11.get(a).getContractAmount();
				targetSumOfList11=targetSumOfList11.add(target);
				BigDecimal target2=list11.get(a).getRevenueTarget();
				target2SumOfList11=target2SumOfList11.add(target2);
				BigDecimal target3=list11.get(a).getCollectionTarget();
				target3SumOfList11=target3SumOfList11.add(target3);
			}
			monthTarget11.setMonth(11);
			monthTarget11.setContractAmount(targetSumOfList11);
			monthTarget11.setRevenueTarget(target2SumOfList11);
			monthTarget11.setCollectionTarget(target3SumOfList11);
			targetArray.add(monthTarget11);
			
			MonthTarget monthTarget12=new MonthTarget();
			BigDecimal targetSumOfList12=new BigDecimal(0);
			BigDecimal target2SumOfList12=new BigDecimal(0);
			BigDecimal target3SumOfList12=new BigDecimal(0);
			List<MonthTarget> list12=mservice.selectMonthTargetByMonthSum(id, 12);
			for(int a=0;a<list12.size();a++){
				BigDecimal target=list12.get(a).getContractAmount();
				targetSumOfList12=targetSumOfList12.add(target);
				BigDecimal target2=list12.get(a).getRevenueTarget();
				target2SumOfList12=target2SumOfList12.add(target2);
				BigDecimal target3=list12.get(a).getCollectionTarget();
				target3SumOfList12=target3SumOfList12.add(target3);
			}
			monthTarget12.setMonth(12);
			monthTarget12.setContractAmount(targetSumOfList12);
			monthTarget12.setRevenueTarget(target2SumOfList12);
			monthTarget12.setCollectionTarget(target3SumOfList12);
			targetArray.add(monthTarget12);
		}
		return targetArray;
	}
	
}

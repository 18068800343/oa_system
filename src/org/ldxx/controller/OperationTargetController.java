package org.ldxx.controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

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
	
	@RequestMapping("/selectOperationTarget")
	@ResponseBody
	public List<OperationTarget> selectOperationTarget(){
		List<OperationTarget> list=oservice.selectOperationTarget();
		for(int i=0;i<list.size();i++){
			float budgetCost=oservice.getSumCostByYear(list.get(i).getYear());
			list.get(i).setBudgetCost(budgetCost);
			List<PrjProgressFill> noList=pService.selectDistinctTaskNo(list.get(i).getYear());
			float actualCost=0;
			if(noList!=null){
				for(int j=0;j<noList.size();j++){
					PrjProgressFill ppf=pService.getCost(noList.get(j).getTaskNo());
					float cost=ppf.getAllCost();
					actualCost=actualCost+cost;
				}
			}
			list.get(i).setActualCost(actualCost);
			
			//实际合同额
			//实际收款
			String status="0";
			String y=list.get(i).getYear()+"%";
			List<FinancialReceipts> frList=fservice.selectFinancialReceiptsByYear(status,y);//先通过年份获取项目款已认领列表
			float money=0;//实际收款
			float actualMoney=0;//实际合同额
			if(frList!=null){
				for(int j=0;j<frList.size();j++){
					float resultMoney = frList.get(j).getResultMoney();//实际收款
					String contractId = frList.get(j).getHtContract();//得到合同的外键id
					CjContract cjContract = cjservice.selectCjContractById(contractId);//查承接合同
					if(cjContract!=null){
						float contractMoney = cjContract.getContractMoney();//合同金额
						String mainDepartment=cjContract.getMainDepartment();//主办部门
						if(mainDepartment!=null){
							float mainDepartmentMoney=cjContract.getMainDepartmentMoney();//主办部门金额
							money=money+(mainDepartmentMoney/contractMoney*resultMoney);
							actualMoney=actualMoney+mainDepartmentMoney;
						}
						String assistDepartment1 = cjContract.getAssistDepartment1();//协办部门1
						if(assistDepartment1!=null){
							float assistDepartment1Money = cjContract.getAssistDepartment1Money();//协办部门1金额
							money=money+(assistDepartment1Money/contractMoney*resultMoney);
							actualMoney=actualMoney+assistDepartment1Money;
						}
						String assistDepartment2 = cjContract.getAssistDepartment2();//协办部门2
						if(assistDepartment2!=null){
							float assistDepartment2Money = cjContract.getAssistDepartment2Money();//协办部门2金额
							money=money+(assistDepartment2Money/contractMoney*resultMoney);
							actualMoney=actualMoney+assistDepartment2Money;
						}
						String assistDepartment3 = cjContract.getAssistDepartment3();//协办部门3
						if(assistDepartment3!=null){
							float assistDepartment3Money = cjContract.getAssistDepartment3Money();//协办部门3金额
							money=money+(assistDepartment3Money/contractMoney*resultMoney);
							actualMoney=actualMoney+assistDepartment3Money;
						}
					}else{//查其他合同
						OtherContract otherContract = ocservice.selectOtherContractById(contractId);
						if(otherContract!=null){
							String department = otherContract.getAbutmentDepartment();//合同部门
							Float contractMoney = otherContract.getContractMoney();//合同金额
							if(department!=null){
								money=money+resultMoney;
								actualMoney=actualMoney+contractMoney;
							}
						}
					}
				}
			}
			float actualPayment=(float)(Math.round(money*100)/100.0);
			float actualContractAmount=(float)(Math.round(actualMoney*100)/100.0);
			list.get(i).setActualPayment(actualPayment);
			list.get(i).setActualContractAmount(actualContractAmount);
			
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
								f = (Float.valueOf(mon))/100;//换算成小数
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
								money2=money2+income;
						}
					}
				}
			}
			float value=money1+money2;
			float realIncome=(float)(Math.round(value*100)/100.0);
			list.get(i).setRealIncome(realIncome);
			
		}
		return list;
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
		List<DepartmentTarget> list=dservice.selectDepartmentTarget(id);
		String y=year+"%";
		String status="0";
		List<FinancialReceipts> frList=fservice.selectFinancialReceiptsByYear(status,y);//先通过年份获取项目款已认领列表
		String modestatus="2";
		List<PrjProgressFill> ppf2=ppfservice.selectPrjProgressFillByYear(modestatus,y);//通过年限查询今年项目进度列表
		List<Task2> task2List=tService.selectTask2ByYear(y);//通过年限查询今年检测二部的任务单项目列表
		if(list!=null){
			for(int i=0;i<list.size();i++){
				String om_id=list.get(i).getOmId();
				OrganizationManagement om=oService.getOrgNameById(om_id);
				String omName=om.getOmName();
				float actualCost=0;//获取部门实际成本
				List<PrjProgressFill> noList=pService.selectDistinctTaskNo(year);
				if(noList!=null){
					for(int j=0;j<noList.size();j++){
						PrjProgressFill ppf=pService.getCost(noList.get(j).getTaskNo());
						String ppfId=ppf.getPpfId();
						int count=pService.countOfDepartmentCost(omName, ppfId);
						if(count==0){
							float money=0;
							actualCost=actualCost+money;
						}else{
							float money=pService.getDepartmentCost(omName, ppfId);
							actualCost=actualCost+money;
						}
					}
				}
				list.get(i).setActualCost(actualCost);
				
				float budgetCost=bService.getBudgeCost(om_id, y); //获取预算成本
				list.get(i).setBudgetCost(budgetCost);
				
				//实际合同额
				//获取实际收款
				float actualContractAmount=0;//实际合同额
				float actualPayment=0;//获取部门实际收款（先得到项目收款认领的所有项目列表，通过合同的id得到合同部门分配金额,合同部门分配金额/合同总金额*项目收款的实际收款）
				if(frList.size()!=0){
					for(int j=0;j<frList.size();j++){
						float money=0;//实际收款
						float actualMoney=0;//实际合同额
						float resultMoney = frList.get(j).getResultMoney();//实际收款
						String contractId = frList.get(j).getHtContract();//得到合同的外键id
						CjContract cjContract = cjservice.selectCjContractById(contractId);//查承接合同
						if(cjContract!=null){
							float contractMoney = cjContract.getContractMoney();//合同金额
							String mainDepartment=cjContract.getMainDepartment();//主办部门
							if(mainDepartment!=null && om_id.equals(mainDepartment)){
								float mainDepartmentMoney=cjContract.getMainDepartmentMoney();//主办部门金额
								money=mainDepartmentMoney/contractMoney*resultMoney;
								actualMoney=mainDepartmentMoney;
							}
							String assistDepartment1 = cjContract.getAssistDepartment1();//协办部门1
							if(assistDepartment1!=null && om_id.equals(assistDepartment1)){
								float assistDepartment1Money = cjContract.getAssistDepartment1Money();//协办部门1金额
								money=assistDepartment1Money/contractMoney*resultMoney;
								actualMoney=assistDepartment1Money;
							}
							String assistDepartment2 = cjContract.getAssistDepartment2();//协办部门2
							if(assistDepartment2!=null && om_id.equals(assistDepartment2)){
								float assistDepartment2Money = cjContract.getAssistDepartment2Money();//协办部门2金额
								money=assistDepartment2Money/contractMoney*resultMoney;
								actualMoney=assistDepartment2Money;
							}
							String assistDepartment3 = cjContract.getAssistDepartment3();//协办部门3
							if(assistDepartment3!=null && om_id.equals(assistDepartment3)){
								float assistDepartment3Money = cjContract.getAssistDepartment3Money();//协办部门3金额
								money=assistDepartment3Money/contractMoney*resultMoney;
								actualMoney=assistDepartment3Money;
							}
						}else{//查其他合同
							OtherContract otherContract = ocservice.selectOtherContractById(contractId);
							if(otherContract!=null){
								String department = otherContract.getAbutmentDepartment();//合同部门
								Float contractMoney = otherContract.getContractMoney();//合同金额
								if(department!=null && om_id.equals(department)){
									money=resultMoney;
									actualMoney=contractMoney;
								}
							}
						}
						float value=actualPayment+money;
						actualPayment=(float)(Math.round(value*100)/100.0);
						float value2=actualContractAmount+actualMoney;
						actualContractAmount=(float)(Math.round(value2*100)/100.0);
					}
				}
				list.get(i).setActualPayment(actualPayment);
				list.get(i).setActualContractAmount(actualContractAmount);
				
				//实际收入
				float realIncome=0;//获取部门实际收入(进度的部门累计百分比*总实际收入+检测二部任务单管理的部门总收入)
				float money1=0;//进度部门总收入
				if(ppf2!=null){
					for(int k=0;k<ppf2.size();k++){
						float allIncome = ppf2.get(k).getAllIncome();//总实际收入
						List<PrjProgressFillInfo> ppfi=ppfservice.selectPrjProgressFillInfo(ppf2.get(k).getPpfId(), "1");
						if(ppfi!=null){
							for(int kk=0;kk<ppfi.size();kk++){
								String department = ppfi.get(kk).getDepartment();//累计收入部门名
								if(department!=null && omName.equals(department)){
									String mon = ppfi.get(kk).getMoney();//得到部门百分比金额
									float f=0;
									if(mon.contains("%")){
										mon=mon.replaceAll("%", "");
										f = (Float.valueOf(mon))/100;//换算成小数
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
								float income = tDepartment.get(j).getdIncome();//得到每个项目的部门收入
								if(name.contains(omName)){
									money2=money2+income;
								}
							}
						}
					}
				}
				float value=money1+money2;
				realIncome=(float)(Math.round(value*100)/100.0);
				list.get(i).setRealIncome(realIncome);
			}
		}
		return list;
	}
	
	@RequestMapping("/selectDepartmentTargetByOmId")/*各部门指标列表*/
	@ResponseBody
	public List<DepartmentTarget> selectDepartmentTargetByOmId(String id){
		List<DepartmentTarget> list=dservice.selectDepartmentTargetByOmId(id);
		return list;
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
			float targetSumOfList=0;
			float target2SumOfList=0;
			float target3SumOfList=0;
			List<MonthTarget> list=mservice.selectMonthTargetByMonthSum(id, 1);
			for(int a=0;a<list.size();a++){
				float target=list.get(a).getContractAmount();
				targetSumOfList=targetSumOfList+target;
				float target2=list.get(a).getRevenueTarget();
				target2SumOfList=target2SumOfList+target2;
				float target3=list.get(a).getCollectionTarget();
				target3SumOfList=target3SumOfList+target3;
			}
			monthTarget.setMonth(1);
			monthTarget.setContractAmount(targetSumOfList);
			monthTarget.setRevenueTarget(target2SumOfList);
			monthTarget.setCollectionTarget(target3SumOfList);
			targetArray.add(monthTarget);
			
			MonthTarget monthTarget2=new MonthTarget();
			float targetSumOfList2=0;
			float target2SumOfList2=0;
			float target3SumOfList2=0;
			List<MonthTarget> list2=mservice.selectMonthTargetByMonthSum(id, 2);
			for(int a=0;a<list2.size();a++){
				float target=list2.get(a).getContractAmount();
				targetSumOfList2=targetSumOfList2+target;
				float target2=list2.get(a).getRevenueTarget();
				target2SumOfList2=target2SumOfList2+target2;
				float target3=list2.get(a).getCollectionTarget();
				target3SumOfList2=target3SumOfList2+target3;
			}
			monthTarget2.setMonth(2);
			monthTarget2.setContractAmount(targetSumOfList2);
			monthTarget2.setRevenueTarget(target2SumOfList2);
			monthTarget2.setCollectionTarget(target3SumOfList2);
			targetArray.add(monthTarget2);
			
			MonthTarget monthTarget3=new MonthTarget();
			float targetSumOfList3=0;
			float target2SumOfList3=0;
			float target3SumOfList3=0;
			List<MonthTarget> list3=mservice.selectMonthTargetByMonthSum(id, 3);
			for(int a=0;a<list3.size();a++){
				float target=list3.get(a).getContractAmount();
				targetSumOfList3=targetSumOfList3+target;
				float target2=list3.get(a).getRevenueTarget();
				target2SumOfList3=target2SumOfList3+target2;
				float target3=list3.get(a).getCollectionTarget();
				target3SumOfList3=target3SumOfList3+target3;
			}
			monthTarget3.setMonth(3);
			monthTarget3.setContractAmount(targetSumOfList3);
			monthTarget3.setRevenueTarget(target2SumOfList3);
			monthTarget3.setCollectionTarget(target3SumOfList3);
			targetArray.add(monthTarget3);
			
			MonthTarget monthTarget4=new MonthTarget();
			float targetSumOfList4=0;
			float target2SumOfList4=0;
			float target3SumOfList4=0;
			List<MonthTarget> list4=mservice.selectMonthTargetByMonthSum(id, 4);
			for(int a=0;a<list4.size();a++){
				float target=list4.get(a).getContractAmount();
				targetSumOfList4=targetSumOfList4+target;
				float target2=list4.get(a).getRevenueTarget();
				target2SumOfList4=target2SumOfList4+target2;
				float target3=list4.get(a).getCollectionTarget();
				target3SumOfList4=target3SumOfList4+target3;
			}
			monthTarget4.setMonth(4);
			monthTarget4.setContractAmount(targetSumOfList4);
			monthTarget4.setRevenueTarget(target2SumOfList4);
			monthTarget4.setCollectionTarget(target3SumOfList4);
			targetArray.add(monthTarget4);
			
			MonthTarget monthTarget5=new MonthTarget();
			float targetSumOfList5=0;
			float target2SumOfList5=0;
			float target3SumOfList5=0;
			List<MonthTarget> list5=mservice.selectMonthTargetByMonthSum(id, 5);
			for(int a=0;a<list5.size();a++){
				float target=list5.get(a).getContractAmount();
				targetSumOfList5=targetSumOfList5+target;
				float target2=list5.get(a).getRevenueTarget();
				target2SumOfList5=target2SumOfList5+target2;
				float target3=list5.get(a).getCollectionTarget();
				target3SumOfList5=target3SumOfList5+target3;
			}
			monthTarget5.setMonth(5);
			monthTarget5.setContractAmount(targetSumOfList5);
			monthTarget5.setRevenueTarget(target2SumOfList5);
			monthTarget5.setCollectionTarget(target3SumOfList5);
			targetArray.add(monthTarget5);
			
			MonthTarget monthTarget6=new MonthTarget();
			float targetSumOfList6=0;
			float target2SumOfList6=0;
			float target3SumOfList6=0;
			List<MonthTarget> list6=mservice.selectMonthTargetByMonthSum(id, 6);
			for(int a=0;a<list6.size();a++){
				float target=list6.get(a).getContractAmount();
				targetSumOfList6=targetSumOfList6+target;
				float target2=list6.get(a).getRevenueTarget();
				target2SumOfList6=target2SumOfList6+target2;
				float target3=list6.get(a).getCollectionTarget();
				target3SumOfList6=target3SumOfList6+target3;
			}
			monthTarget6.setMonth(6);
			monthTarget6.setContractAmount(targetSumOfList6);
			monthTarget6.setRevenueTarget(target2SumOfList6);
			monthTarget6.setCollectionTarget(target3SumOfList6);
			targetArray.add(monthTarget6);
			
			MonthTarget monthTarget7=new MonthTarget();
			float targetSumOfList7=0;
			float target2SumOfList7=0;
			float target3SumOfList7=0;
			List<MonthTarget> list7=mservice.selectMonthTargetByMonthSum(id, 7);
			for(int a=0;a<list7.size();a++){
				float target=list7.get(a).getContractAmount();
				targetSumOfList7=targetSumOfList7+target;
				float target2=list7.get(a).getRevenueTarget();
				target2SumOfList7=target2SumOfList7+target2;
				float target3=list7.get(a).getCollectionTarget();
				target3SumOfList7=target3SumOfList7+target3;
			}
			monthTarget7.setMonth(7);
			monthTarget7.setContractAmount(targetSumOfList7);
			monthTarget7.setRevenueTarget(target2SumOfList7);
			monthTarget7.setCollectionTarget(target3SumOfList7);
			targetArray.add(monthTarget7);
			
			MonthTarget monthTarget8=new MonthTarget();
			float targetSumOfList8=0;
			float target2SumOfList8=0;
			float target3SumOfList8=0;
			List<MonthTarget> list8=mservice.selectMonthTargetByMonthSum(id, 8);
			for(int a=0;a<list8.size();a++){
				float target=list8.get(a).getContractAmount();
				targetSumOfList8=targetSumOfList8+target;
				float target2=list8.get(a).getRevenueTarget();
				target2SumOfList8=target2SumOfList8+target2;
				float target3=list8.get(a).getCollectionTarget();
				target3SumOfList8=target3SumOfList8+target3;
			}
			monthTarget8.setMonth(8);
			monthTarget8.setContractAmount(targetSumOfList8);
			monthTarget8.setRevenueTarget(target2SumOfList8);
			monthTarget8.setCollectionTarget(target3SumOfList8);
			targetArray.add(monthTarget8);
			
			MonthTarget monthTarget9=new MonthTarget();
			float targetSumOfList9=0;
			float target2SumOfList9=0;
			float target3SumOfList9=0;
			List<MonthTarget> list9=mservice.selectMonthTargetByMonthSum(id, 9);
			for(int a=0;a<list9.size();a++){
				float target=list9.get(a).getContractAmount();
				targetSumOfList9=targetSumOfList9+target;
				float target2=list9.get(a).getRevenueTarget();
				target2SumOfList9=target2SumOfList9+target2;
				float target3=list9.get(a).getCollectionTarget();
				target3SumOfList9=target3SumOfList9+target3;
			}
			monthTarget9.setMonth(9);
			monthTarget9.setContractAmount(targetSumOfList9);
			monthTarget9.setRevenueTarget(target2SumOfList9);
			monthTarget9.setCollectionTarget(target3SumOfList9);
			targetArray.add(monthTarget9);
			
			MonthTarget monthTarget10=new MonthTarget();
			float targetSumOfList10=0;
			float target2SumOfList10=0;
			float target3SumOfList10=0;
			List<MonthTarget> list10=mservice.selectMonthTargetByMonthSum(id, 10);
			for(int a=0;a<list10.size();a++){
				float target=list10.get(a).getContractAmount();
				targetSumOfList10=targetSumOfList10+target;
				float target2=list10.get(a).getRevenueTarget();
				target2SumOfList10=target2SumOfList10+target2;
				float target3=list10.get(a).getCollectionTarget();
				target3SumOfList10=target3SumOfList10+target3;
			}
			monthTarget10.setMonth(10);
			monthTarget10.setContractAmount(targetSumOfList10);
			monthTarget10.setRevenueTarget(target2SumOfList10);
			monthTarget10.setCollectionTarget(target3SumOfList10);
			targetArray.add(monthTarget10);
			
			MonthTarget monthTarget11=new MonthTarget();
			float targetSumOfList11=0;
			float target2SumOfList11=0;
			float target3SumOfList11=0;
			List<MonthTarget> list11=mservice.selectMonthTargetByMonthSum(id, 11);
			for(int a=0;a<list11.size();a++){
				float target=list11.get(a).getContractAmount();
				targetSumOfList11=targetSumOfList11+target;
				float target2=list11.get(a).getRevenueTarget();
				target2SumOfList11=target2SumOfList11+target2;
				float target3=list11.get(a).getCollectionTarget();
				target3SumOfList11=target3SumOfList11+target3;
			}
			monthTarget11.setMonth(11);
			monthTarget11.setContractAmount(targetSumOfList11);
			monthTarget11.setRevenueTarget(target2SumOfList11);
			monthTarget11.setCollectionTarget(target3SumOfList11);
			targetArray.add(monthTarget11);
			
			MonthTarget monthTarget12=new MonthTarget();
			float targetSumOfList12=0;
			float target2SumOfList12=0;
			float target3SumOfList12=0;
			List<MonthTarget> list12=mservice.selectMonthTargetByMonthSum(id, 12);
			for(int a=0;a<list12.size();a++){
				float target=list12.get(a).getContractAmount();
				targetSumOfList12=targetSumOfList12+target;
				float target2=list12.get(a).getRevenueTarget();
				target2SumOfList12=target2SumOfList12+target2;
				float target3=list12.get(a).getCollectionTarget();
				target3SumOfList12=target3SumOfList12+target3;
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

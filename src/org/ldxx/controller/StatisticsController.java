/**
 * <p>Title: StatisticsController.java</p>
 * <p>Description: 华通桥涵管理系统</p>
 * <p>Company: 环水信息技术有限公司</p>
 * @author 马潇霄
 * @version 1.0 创建时间：2018年12月13日 下午4:41:53
 */

package org.ldxx.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.AlreadyRenling;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.ContractUpdate;
import org.ldxx.bean.DepartmentTarget;
import org.ldxx.bean.MonthTarget;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.PrjProgressFill;
import org.ldxx.bean.StatisticsVo;
import org.ldxx.bean.Task;
import org.ldxx.dao.CjContractDao;
import org.ldxx.service.AlreadySkInfoService;
import org.ldxx.service.CjContractService;
import org.ldxx.service.ContractUpdateService;
import org.ldxx.service.DepartmentTargetService;
import org.ldxx.service.FinancialReceiptsService;
import org.ldxx.service.MonthTargetService;
import org.ldxx.service.OperationTargetService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.OtherContractService;
import org.ldxx.service.PrjProgressFillService;
import org.ldxx.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
* @ClassName: StatisticsController 
* @Description: 统计分析
* @author zhaohui
* @date 2018年12月13日 下午4:41:53 
*  
*/
@Controller
@RequestMapping("/Statistics")
public class StatisticsController {
	
	@Autowired
	private CjContractService cjService;
	@Autowired
	private CjContractDao cjDao;
	@Autowired
	private OtherContractService oService;
	@Autowired
	private PrjProgressFillService pService;
	@Autowired
	private FinancialReceiptsService fService;
	@Autowired
	private MonthTargetService mService;
	@Autowired
	private OrganizationManagementService omService;
	@Autowired
	private DepartmentTargetService dtService;
	@Autowired
	private TaskService tService;
	@Autowired
	private AlreadySkInfoService aService;
	@Autowired
	private ContractUpdateService cuService;

	@RequestMapping("/initGsContract")//初始化本期公司新签合同额。累计收款，累计收入
	@ResponseBody
	public Map<String,Double> initGsContractMoney(){
		Map<String,Double> map=new HashMap<String, Double>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		String time=sdf.format(new Date());
		String year=time.split("-")[0];
		int month=Integer.valueOf(time.split("-")[1]);
		double contractAll=0;//累计合同额
		double allInCome=0;//累计收入
		double allReceipt=0;//累计收款
		ContractUpdate cu=cuService.selectGsContractMoneyByTime(time);
		contractAll=cu.getMoney();
		PrjProgressFill ppf=pService.selectGsIncomeByTime(time);
		allInCome=ppf.getAllMoneyYuan();
		AlreadyRenling ar=aService.selectGsRenlingByTime(time);
		allReceipt=ar.getSkQuerenMoney();
				
		double mbContractMoney=0;//目标合同额
		double mbIncome=0;//目标收入
		double mbReceipt=0;//目标收款
		List<MonthTarget> mt=mService.selectMonthTargetByYearAndMonth(year, month);
		if(mt!=null){
			for(int i=0;i<mt.size();i++){
				double contractAmount=mt.get(i).getContractAmount();
				double revenueTarget=mt.get(i).getRevenueTarget();
				double collectionTarget=mt.get(i).getCollectionTarget();
				mbContractMoney=mbContractMoney+contractAmount;
				mbIncome=mbIncome+revenueTarget;
				mbReceipt=mbReceipt+collectionTarget;
			}
		}
		map.put("mbContractMoney", mbContractMoney);
		map.put("mbIncome", mbIncome);
		map.put("mbReceipt", mbReceipt);
		map.put("contractAll", contractAll);
		map.put("allInCome", allInCome);
		map.put("allReceipt", allReceipt);
		return map;
	}
	
	
	@RequestMapping("/initDepartmentContract")//初始化本期部门新签合同额，累计收入，累计收款
	@ResponseBody
	public Map<String,Object> initDepartmentContract(){
		Map<String,Object> map=new HashMap<>();
		List<StatisticsVo> statistics=new ArrayList<>();
		List<String> omList=new ArrayList<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		String time=sdf.format(new Date());
		String year=time.split("-")[0];
		int month=Integer.valueOf(time.split("-")[1]);
		
		List<OrganizationManagement> om=omService.selectProductionDepartment();
		for(int i=0;i<om.size();i++){
			String omId=om.get(i).getOmId();//部门编号
			String omName=om.get(i).getOmName();//部门名称
			omList.add(omName);
			double contractAll=0;//新签合同额目标
			double totalIncomeAll=0;//累计收入
			double receiptAll=0;//累计收款
			ContractUpdate cu=cuService.selectDeptContractMoneyByTime(time, omId);
			contractAll=cu.getMoney();
			PrjProgressFill ppf=pService.selectGsIncomeByTimeAndDept(time, omName);
			totalIncomeAll=ppf.getAllMoneyYuan();
			AlreadyRenling ar=aService.selectDeptRenlingByTime(time, omName);
			receiptAll=ar.getSkQuerenMoney();
			
			double mbContractMoney=0;//目标合同额
			double mbIncome=0;//目标收入
			double mbReceipt=0;//目标收款
			List<MonthTarget> mt=mService.selectMonthTargetByYearAndMonthAndDepartment(year, month, omId);
			if(mt!=null){
				for(int jj=0;jj<mt.size();jj++){
					double contractAmount=mt.get(jj).getContractAmount();
					double revenueTarget=mt.get(jj).getRevenueTarget();
					double collectionTarget=mt.get(jj).getCollectionTarget();
					mbContractMoney=mbContractMoney+contractAmount;
					mbIncome=mbIncome+revenueTarget;
					mbReceipt=mbReceipt+collectionTarget;
				}
			}
			StatisticsVo vo=new StatisticsVo();
			vo.setMbContractMoney(mbContractMoney);
			vo.setMbIncome(mbIncome);
			vo.setMbReceipt(mbReceipt);
			vo.setAllInCome(totalIncomeAll);
			vo.setAllReceipt(receiptAll);
			vo.setContractAll(contractAll);
			statistics.add(vo);
		}
		map.put("statistics", statistics);
		map.put("omList", omList);
		return map;
	}
	
	@RequestMapping("/seachTab2")//按项目类型查询月
	@ResponseBody
	public Map<String,Object> seachTab(String prjType){
		Map<String,Object> map=new HashMap<>();
		List<List<Float>> resultContract=new ArrayList<>();//实际月部门新签合同额按项目类型
		List<List<Float>> resultIncome=new ArrayList<>();//实际月部门累计收入按项目类型
		List<List<Double>> resultReceipt=new ArrayList<>();//实际月部门累计收款按项目类型
		List<String> omList=new ArrayList<>();
		omList.add("公司");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		
		List<OrganizationManagement> om=omService.selectProductionDepartment();//生产部门列表
		//公司月份部门累加
		List<Float> gsContractMoney=new ArrayList<>();
		float gsContractMoneyMonth1All=0;
		float gsContractMoneyMonth2All=0;
		float gsContractMoneyMonth3All=0;
		float gsContractMoneyMonth4All=0;
		float gsContractMoneyMonth5All=0;
		float gsContractMoneyMonth6All=0;
		float gsContractMoneyMonth7All=0;
		float gsContractMoneyMonth8All=0;
		float gsContractMoneyMonth9All=0;
		float gsContractMoneyMonth10All=0;
		float gsContractMoneyMonth11All=0;
		float gsContractMoneyMonth12All=0;
		
		List<Float> gsIncome=new ArrayList<>();
		float gsIncomeMonth1All=0;
		float gsIncomeMonth2All=0;
		float gsIncomeMonth3All=0;
		float gsIncomeMonth4All=0;
		float gsIncomeMonth5All=0;
		float gsIncomeMonth6All=0;
		float gsIncomeMonth7All=0;
		float gsIncomeMonth8All=0;
		float gsIncomeMonth9All=0;
		float gsIncomeMonth10All=0;
		float gsIncomeMonth11All=0;
		float gsIncomeMonth12All=0;
		
		List<Double> gsReceipt=new ArrayList<>();
		double gsReceiptMonth1All=0;
		double gsReceiptMonth2All=0;
		double gsReceiptMonth3All=0;
		double gsReceiptMonth4All=0;
		double gsReceiptMonth5All=0;
		double gsReceiptMonth6All=0;
		double gsReceiptMonth7All=0;
		double gsReceiptMonth8All=0;
		double gsReceiptMonth9All=0;
		double gsReceiptMonth10All=0;
		double gsReceiptMonth11All=0;
		double gsReceiptMonth12All=0;
		for(int o=0;o<om.size();o++){
			String omId=om.get(o).getOmId();
			String omName=om.get(o).getOmName();
			omList.add(omName);
			
			//部门新签合同额按项目类型
			List<Float> contractMoneyList=new ArrayList<>();
			float contractMonth1All=0;
			float contractMonth2All=0;
			float contractMonth3All=0;
			float contractMonth4All=0;
			float contractMonth5All=0;
			float contractMonth6All=0;
			float contractMonth7All=0;
			float contractMonth8All=0;
			float contractMonth9All=0;
			float contractMonth10All=0;
			float contractMonth11All=0;
			float contractMonth12All=0;
			//部门累计收入按项目类型
			List<Float> inComeMoneyList=new ArrayList<>();
			float inComeMonth1All=0;
			float inComeMonth2All=0;
			float inComeMonth3All=0;
			float inComeMonth4All=0;
			float inComeMonth5All=0;
			float inComeMonth6All=0;
			float inComeMonth7All=0;
			float inComeMonth8All=0;
			float inComeMonth9All=0;
			float inComeMonth10All=0;
			float inComeMonth11All=0;
			float inComeMonth12All=0;
			//部门累计收款按项目类型
			List<Double> receiptMoneyList=new ArrayList<>();
			double receiptMonth1All=0;
			double receiptMonth2All=0;
			double receiptMonth3All=0;
			double receiptMonth4All=0;
			double receiptMonth5All=0;
			double receiptMonth6All=0;
			double receiptMonth7All=0;
			double receiptMonth8All=0;
			double receiptMonth9All=0;
			double receiptMonth10All=0;
			double receiptMonth11All=0;
			double receiptMonth12All=0;
			
			for(int i=0;i<prjType.split(",").length;i++){
				//部门新签合同额按项目类型
				String type=prjType.split(",")[i];
				ContractUpdate cu=cuService.selectDeptContractMoneyByTimeAndType(year+"-01", omId, type);
				float contractMonth1=cu.getMoney();
				contractMonth1All=contractMonth1All+contractMonth1;
				ContractUpdate cu2=cuService.selectDeptContractMoneyByTimeAndType(year+"-02", omId, type);
				float contractMonth2=cu2.getMoney();
				contractMonth2All=contractMonth2All+contractMonth2;
				ContractUpdate cu3=cuService.selectDeptContractMoneyByTimeAndType(year+"-03", omId, type);
				float contractMonth3=cu3.getMoney();
				contractMonth3All=contractMonth3All+contractMonth3;
				ContractUpdate cu4=cuService.selectDeptContractMoneyByTimeAndType(year+"-04", omId, type);
				float contractMonth4=cu4.getMoney();
				contractMonth4All=contractMonth4All+contractMonth4;
				ContractUpdate cu5=cuService.selectDeptContractMoneyByTimeAndType(year+"-05", omId, type);
				float contractMonth5=cu5.getMoney();
				contractMonth5All=contractMonth5All+contractMonth5;
				ContractUpdate cu6=cuService.selectDeptContractMoneyByTimeAndType(year+"-06", omId, type);
				float contractMonth6=cu6.getMoney();
				contractMonth6All=contractMonth6All+contractMonth6;
				ContractUpdate cu7=cuService.selectDeptContractMoneyByTimeAndType(year+"-07", omId, type);
				float contractMonth7=cu7.getMoney();
				contractMonth7All=contractMonth7All+contractMonth7;
				ContractUpdate cu8=cuService.selectDeptContractMoneyByTimeAndType(year+"-08", omId, type);
				float contractMonth8=cu8.getMoney();
				contractMonth8All=contractMonth8All+contractMonth8;
				ContractUpdate cu9=cuService.selectDeptContractMoneyByTimeAndType(year+"-09", omId, type);
				float contractMonth9=cu9.getMoney();
				contractMonth9All=contractMonth9All+contractMonth9;
				ContractUpdate cu10=cuService.selectDeptContractMoneyByTimeAndType(year+"-10", omId, type);
				float contractMonth10=cu10.getMoney();
				contractMonth10All=contractMonth10All+contractMonth10;
				ContractUpdate cu11=cuService.selectDeptContractMoneyByTimeAndType(year+"-11", omId, type);
				float contractMonth11=cu11.getMoney();
				contractMonth11All=contractMonth11All+contractMonth11;
				ContractUpdate cu12=cuService.selectDeptContractMoneyByTimeAndType(year+"-12", omId, type);
				float contractMonth12=cu12.getMoney();
				contractMonth12All=contractMonth12All+contractMonth12;
				
				
				//部门累计收入按项目类型
				PrjProgressFill ppf=pService.selectDeptIncomeByTimeAndType(year+"-01", omName, type);
				float inComeMonth1=ppf.getAllMoneyYuan();
				inComeMonth1All=inComeMonth1All+inComeMonth1;
				PrjProgressFill ppf2=pService.selectDeptIncomeByTimeAndType(year+"-02", omName, type);
				float inComeMonth2=ppf2.getAllMoneyYuan();
				inComeMonth2All=inComeMonth2All+inComeMonth2;
				PrjProgressFill ppf3=pService.selectDeptIncomeByTimeAndType(year+"-03", omName, type);
				float inComeMonth3=ppf3.getAllMoneyYuan();
				inComeMonth3All=inComeMonth3All+inComeMonth3;
				PrjProgressFill ppf4=pService.selectDeptIncomeByTimeAndType(year+"-04", omName, type);
				float inComeMonth4=ppf4.getAllMoneyYuan();
				inComeMonth4All=inComeMonth4All+inComeMonth4;
				PrjProgressFill ppf5=pService.selectDeptIncomeByTimeAndType(year+"-05", omName, type);
				float inComeMonth5=ppf5.getAllMoneyYuan();
				inComeMonth5All=inComeMonth5All+inComeMonth5;
				PrjProgressFill ppf6=pService.selectDeptIncomeByTimeAndType(year+"-06", omName, type);
				float inComeMonth6=ppf6.getAllMoneyYuan();
				inComeMonth6All=inComeMonth6All+inComeMonth6;
				PrjProgressFill ppf7=pService.selectDeptIncomeByTimeAndType(year+"-07", omName, type);
				float inComeMonth7=ppf7.getAllMoneyYuan();
				inComeMonth7All=inComeMonth7All+inComeMonth7;
				PrjProgressFill ppf8=pService.selectDeptIncomeByTimeAndType(year+"-08", omName, type);
				float inComeMonth8=ppf8.getAllMoneyYuan();
				inComeMonth8All=inComeMonth8All+inComeMonth8;
				PrjProgressFill ppf9=pService.selectDeptIncomeByTimeAndType(year+"-09", omName, type);
				float inComeMonth9=ppf9.getAllMoneyYuan();
				inComeMonth9All=inComeMonth9All+inComeMonth9;
				PrjProgressFill ppf10=pService.selectDeptIncomeByTimeAndType(year+"-10", omName, type);
				float inComeMonth10=ppf10.getAllMoneyYuan();
				inComeMonth10All=inComeMonth10All+inComeMonth10;
				PrjProgressFill ppf11=pService.selectDeptIncomeByTimeAndType(year+"-11", omName, type);
				float inComeMonth11=ppf11.getAllMoneyYuan();
				inComeMonth11All=inComeMonth11All+inComeMonth11;
				PrjProgressFill ppf12=pService.selectDeptIncomeByTimeAndType(year+"-12", omName, type);
				float inComeMonth12=ppf12.getAllMoneyYuan();
				inComeMonth12All=inComeMonth12All+inComeMonth12;
				
				
				//部门累计收款按项目类型
				AlreadyRenling ar=aService.selectDeptRenlingByTimeAndType(year+"-01", omName, type);
				double receiptMonth1=ar.getSkQuerenMoney();
				receiptMonth1All=receiptMonth1All+receiptMonth1;
				AlreadyRenling ar2=aService.selectDeptRenlingByTimeAndType(year+"-02", omName, type);
				double receiptMonth2=ar2.getSkQuerenMoney();
				receiptMonth2All=receiptMonth2All+receiptMonth2;	
				AlreadyRenling ar3=aService.selectDeptRenlingByTimeAndType(year+"-03", omName, type);
				double receiptMonth3=ar3.getSkQuerenMoney();
				receiptMonth3All=receiptMonth3All+receiptMonth3;
				AlreadyRenling ar4=aService.selectDeptRenlingByTimeAndType(year+"-04", omName, type);
				double receiptMonth4=ar4.getSkQuerenMoney();
				receiptMonth4All=receiptMonth4All+receiptMonth4;
				AlreadyRenling ar5=aService.selectDeptRenlingByTimeAndType(year+"-05", omName, type);
				double receiptMonth5=ar5.getSkQuerenMoney();
				receiptMonth5All=receiptMonth5All+receiptMonth5;
				AlreadyRenling ar6=aService.selectDeptRenlingByTimeAndType(year+"-06", omName, type);
				double receiptMonth6=ar6.getSkQuerenMoney();
				receiptMonth6All=receiptMonth6All+receiptMonth6;
				AlreadyRenling ar7=aService.selectDeptRenlingByTimeAndType(year+"-07", omName, type);
				double receiptMonth7=ar7.getSkQuerenMoney();
				receiptMonth7All=receiptMonth7All+receiptMonth7;
				AlreadyRenling ar8=aService.selectDeptRenlingByTimeAndType(year+"-08", omName, type);
				double receiptMonth8=ar8.getSkQuerenMoney();
				receiptMonth8All=receiptMonth8All+receiptMonth8;
				AlreadyRenling ar9=aService.selectDeptRenlingByTimeAndType(year+"-09", omName, type);
				double receiptMonth9=ar9.getSkQuerenMoney();
				receiptMonth9All=receiptMonth9All+receiptMonth9;
				AlreadyRenling ar10=aService.selectDeptRenlingByTimeAndType(year+"-10", omName, type);
				double receiptMonth10=ar10.getSkQuerenMoney();
				receiptMonth10All=receiptMonth10All+receiptMonth10;
				AlreadyRenling ar11=aService.selectDeptRenlingByTimeAndType(year+"-11", omName, type);
				double receiptMonth11=ar11.getSkQuerenMoney();
				receiptMonth11All=receiptMonth11All+receiptMonth11;
				AlreadyRenling ar12=aService.selectDeptRenlingByTimeAndType(year+"-12", omName, type);
				double receiptMonth12=ar12.getSkQuerenMoney();
				receiptMonth12All=receiptMonth12All+receiptMonth12;
				
			}
			//公司所有累加
			gsContractMoneyMonth1All=gsContractMoneyMonth1All+contractMonth1All;
			gsContractMoneyMonth2All=gsContractMoneyMonth2All+contractMonth2All;
			gsContractMoneyMonth3All=gsContractMoneyMonth3All+contractMonth3All;
			gsContractMoneyMonth4All=gsContractMoneyMonth4All+contractMonth4All;
			gsContractMoneyMonth5All=gsContractMoneyMonth5All+contractMonth5All;
			gsContractMoneyMonth6All=gsContractMoneyMonth6All+contractMonth6All;
			gsContractMoneyMonth7All=gsContractMoneyMonth7All+contractMonth7All;
			gsContractMoneyMonth8All=gsContractMoneyMonth8All+contractMonth8All;
			gsContractMoneyMonth9All=gsContractMoneyMonth9All+contractMonth9All;
			gsContractMoneyMonth10All=gsContractMoneyMonth10All+contractMonth10All;
			gsContractMoneyMonth11All=gsContractMoneyMonth11All+contractMonth11All;
			gsContractMoneyMonth12All=gsContractMoneyMonth12All+contractMonth12All;
			
			gsIncomeMonth1All=gsIncomeMonth1All+inComeMonth1All;
			gsIncomeMonth2All=gsIncomeMonth2All+inComeMonth2All;
			gsIncomeMonth3All=gsIncomeMonth3All+inComeMonth3All;
			gsIncomeMonth4All=gsIncomeMonth4All+inComeMonth4All;
			gsIncomeMonth5All=gsIncomeMonth5All+inComeMonth5All;
			gsIncomeMonth6All=gsIncomeMonth6All+inComeMonth6All;
			gsIncomeMonth7All=gsIncomeMonth7All+inComeMonth7All;
			gsIncomeMonth8All=gsIncomeMonth8All+inComeMonth8All;
			gsIncomeMonth9All=gsIncomeMonth9All+inComeMonth9All;
			gsIncomeMonth10All=gsIncomeMonth10All+inComeMonth10All;
			gsIncomeMonth11All=gsIncomeMonth11All+inComeMonth11All;
			gsIncomeMonth12All=gsIncomeMonth12All+inComeMonth12All;
			
			gsReceiptMonth1All=gsReceiptMonth1All+receiptMonth1All;
			gsReceiptMonth2All=gsReceiptMonth2All+receiptMonth2All;
			gsReceiptMonth3All=gsReceiptMonth3All+receiptMonth3All;
			gsReceiptMonth4All=gsReceiptMonth4All+receiptMonth4All;
			gsReceiptMonth5All=gsReceiptMonth5All+receiptMonth5All;
			gsReceiptMonth6All=gsReceiptMonth6All+receiptMonth6All;
			gsReceiptMonth7All=gsReceiptMonth7All+receiptMonth7All;
			gsReceiptMonth8All=gsReceiptMonth8All+receiptMonth8All;
			gsReceiptMonth9All=gsReceiptMonth9All+receiptMonth9All;
			gsReceiptMonth10All=gsReceiptMonth10All+receiptMonth10All;
			gsReceiptMonth11All=gsReceiptMonth11All+receiptMonth11All;
			gsReceiptMonth12All=gsReceiptMonth12All+receiptMonth12All;
			
			contractMoneyList.add(contractMonth1All);
			contractMoneyList.add(contractMonth2All);
			contractMoneyList.add(contractMonth3All);
			contractMoneyList.add(contractMonth4All);
			contractMoneyList.add(contractMonth5All);
			contractMoneyList.add(contractMonth6All);
			contractMoneyList.add(contractMonth7All);
			contractMoneyList.add(contractMonth8All);
			contractMoneyList.add(contractMonth9All);
			contractMoneyList.add(contractMonth10All);
			contractMoneyList.add(contractMonth11All);
			contractMoneyList.add(contractMonth12All);
			resultContract.add(contractMoneyList);
			
			inComeMoneyList.add(inComeMonth1All);
			inComeMoneyList.add(inComeMonth2All);
			inComeMoneyList.add(inComeMonth3All);
			inComeMoneyList.add(inComeMonth4All);
			inComeMoneyList.add(inComeMonth5All);
			inComeMoneyList.add(inComeMonth6All);
			inComeMoneyList.add(inComeMonth7All);
			inComeMoneyList.add(inComeMonth8All);
			inComeMoneyList.add(inComeMonth9All);
			inComeMoneyList.add(inComeMonth10All);
			inComeMoneyList.add(inComeMonth11All);
			inComeMoneyList.add(inComeMonth12All);
			resultIncome.add(inComeMoneyList);
			
			receiptMoneyList.add(receiptMonth1All);
			receiptMoneyList.add(receiptMonth2All);
			receiptMoneyList.add(receiptMonth3All);
			receiptMoneyList.add(receiptMonth4All);
			receiptMoneyList.add(receiptMonth5All);
			receiptMoneyList.add(receiptMonth6All);
			receiptMoneyList.add(receiptMonth7All);
			receiptMoneyList.add(receiptMonth8All);
			receiptMoneyList.add(receiptMonth9All);
			receiptMoneyList.add(receiptMonth10All);
			receiptMoneyList.add(receiptMonth11All);
			receiptMoneyList.add(receiptMonth12All);
			resultReceipt.add(receiptMoneyList);
		}
		gsContractMoney.add(gsContractMoneyMonth1All);
		gsContractMoney.add(gsContractMoneyMonth2All);
		gsContractMoney.add(gsContractMoneyMonth3All);
		gsContractMoney.add(gsContractMoneyMonth4All);
		gsContractMoney.add(gsContractMoneyMonth5All);
		gsContractMoney.add(gsContractMoneyMonth6All);
		gsContractMoney.add(gsContractMoneyMonth7All);
		gsContractMoney.add(gsContractMoneyMonth8All);
		gsContractMoney.add(gsContractMoneyMonth9All);
		gsContractMoney.add(gsContractMoneyMonth10All);
		gsContractMoney.add(gsContractMoneyMonth11All);
		gsContractMoney.add(gsContractMoneyMonth12All);
		resultContract.add(0,gsContractMoney);
		
		gsIncome.add(gsIncomeMonth1All);
		gsIncome.add(gsIncomeMonth2All);
		gsIncome.add(gsIncomeMonth3All);
		gsIncome.add(gsIncomeMonth4All);
		gsIncome.add(gsIncomeMonth5All);
		gsIncome.add(gsIncomeMonth6All);
		gsIncome.add(gsIncomeMonth7All);
		gsIncome.add(gsIncomeMonth8All);
		gsIncome.add(gsIncomeMonth9All);
		gsIncome.add(gsIncomeMonth10All);
		gsIncome.add(gsIncomeMonth11All);
		gsIncome.add(gsIncomeMonth12All);
		resultIncome.add(0,gsIncome);
		
		gsReceipt.add(gsReceiptMonth1All);
		gsReceipt.add(gsReceiptMonth2All);
		gsReceipt.add(gsReceiptMonth3All);
		gsReceipt.add(gsReceiptMonth4All);
		gsReceipt.add(gsReceiptMonth5All);
		gsReceipt.add(gsReceiptMonth6All);
		gsReceipt.add(gsReceiptMonth7All);
		gsReceipt.add(gsReceiptMonth8All);
		gsReceipt.add(gsReceiptMonth9All);
		gsReceipt.add(gsReceiptMonth10All);
		gsReceipt.add(gsReceiptMonth11All);
		gsReceipt.add(gsReceiptMonth12All);
		resultReceipt.add(0,gsReceipt);
		map.put("om", omList);
		map.put("resultContract", resultContract);
		map.put("resultIncome", resultIncome);
		map.put("resultReceipt", resultReceipt);
		return map;
	}
	
	@RequestMapping("/seachTab3")//按项目类型查询年
	@ResponseBody
	public Map<String,Object> seachTab3(String prjType){
		Map<String,Object> map=new HashMap<>();
		List<List<Float>> resultContract=new ArrayList<>();//实际年部门新签合同额按项目类型
		List<List<Float>> resultIncome=new ArrayList<>();//实际年部门累计收入按项目类型
		List<List<Double>> resultReceipt=new ArrayList<>();//实际年部门累计收款按项目类型
		List<String> omList=new ArrayList<>();
		List<String> yearList=new ArrayList<>();
		omList.add("公司");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		String year3=((Integer.valueOf(year))-2)+"";
		String year2=((Integer.valueOf(year))-1)+"";
		yearList.add(year3);
		yearList.add(year2);
		yearList.add(year);
		year="%"+year+"%";
		List<OrganizationManagement> om=omService.selectProductionDepartment();//生产部门列表
		//公司月份部门累加
		List<Float> gsContractMoney=new ArrayList<>();
		float gsContractYear1All=0;
		float gsContractYear2All=0;
		float gsContractYear3All=0;
		
		List<Float> gsIncome=new ArrayList<>();
		float gsIncomeYear1All=0;
		float gsIncomeYear2All=0;
		float gsIncomeYear3All=0;
		
		List<Double> gsReceipt=new ArrayList<>();
		double gsReceiptYear1All=0;
		double gsReceiptYear2All=0;
		double gsReceiptYear3All=0;
		for(int o=0;o<om.size();o++){
			String omId=om.get(o).getOmId();
			String omName=om.get(o).getOmName();
			omList.add(omName);
			
			//部门新签合同额按项目类型
			List<Float> contractMoneyList=new ArrayList<>();
			float contractYear1All=0;
			float contractYear2All=0;
			float contractYear3All=0;
			//部门累计收入按项目类型
			List<Float> inComeMoneyList=new ArrayList<>();
			float inComeYear1All=0;
			float inComeYear2All=0;
			float inComeYear3All=0;
			//部门累计收款按项目类型
			List<Double> receiptMoneyList=new ArrayList<>();
			double receiptYear1All=0;
			double receiptYear2All=0;
			double receiptYear3All=0;
			for(int i=0;i<prjType.split(",").length;i++){
				String type=prjType.split(",")[i];
				//部门新签合同额按项目类型
				ContractUpdate cu=cuService.selectDeptContractMoneyByTimeAndType(year3, omId, type);
				float contractMonth1=cu.getMoney();
				contractYear1All=contractYear1All+contractMonth1;
				ContractUpdate cu2=cuService.selectDeptContractMoneyByTimeAndType(year2, omId, type);
				float contractMonth2=cu2.getMoney();
				contractYear2All=contractYear2All+contractMonth2;
				ContractUpdate cu3=cuService.selectDeptContractMoneyByTimeAndType(year, omId, type);
				float contractMonth3=cu3.getMoney();
				contractYear3All=contractYear3All+contractMonth3;
				
				
				//部门累计收入按项目类型
				PrjProgressFill ppf=pService.selectDeptIncomeByTimeAndType(year3, omName, type);
				float inComeMonth1=ppf.getAllMoneyYuan();
				inComeYear1All=inComeYear1All+inComeMonth1;
				PrjProgressFill ppf2=pService.selectDeptIncomeByTimeAndType(year2, omName, type);
				float inComeMonth2=ppf2.getAllMoneyYuan();
				inComeYear2All=inComeYear2All+inComeMonth2;
				PrjProgressFill ppf3=pService.selectDeptIncomeByTimeAndType(year, omName, type);
				float inComeMonth3=ppf3.getAllMoneyYuan();
				inComeYear3All=inComeYear3All+inComeMonth3;
				
				//部门累计收款按项目类型
				AlreadyRenling ar=aService.selectDeptRenlingByTimeAndType(year3, omName, type);
				double receiptMonth1=ar.getSkQuerenMoney();
				receiptYear1All=receiptYear1All+receiptMonth1;
				AlreadyRenling ar2=aService.selectDeptRenlingByTimeAndType(year2, omName, type);
				double receiptMonth2=ar2.getSkQuerenMoney();
				receiptYear2All=receiptYear2All+receiptMonth2;
				AlreadyRenling ar3=aService.selectDeptRenlingByTimeAndType(year, omName, type);
				double receiptMonth3=ar3.getSkQuerenMoney();
				receiptYear3All=receiptYear3All+receiptMonth3;
				
			}
			//公司所有累加
			gsContractYear1All=gsContractYear1All+contractYear1All;
			gsContractYear2All=gsContractYear2All+contractYear2All;
			gsContractYear3All=gsContractYear3All+contractYear3All;
			
			gsIncomeYear1All=gsIncomeYear1All+inComeYear1All;
			gsIncomeYear2All=gsIncomeYear2All+inComeYear2All;
			gsIncomeYear3All=gsIncomeYear3All+inComeYear3All;
			
			gsReceiptYear1All=gsReceiptYear1All+receiptYear1All;
			gsReceiptYear2All=gsReceiptYear2All+receiptYear2All;
			gsReceiptYear3All=gsReceiptYear3All+receiptYear3All;
			
			contractMoneyList.add(contractYear1All);
			contractMoneyList.add(contractYear2All);
			contractMoneyList.add(contractYear3All);
			resultContract.add(contractMoneyList);
			
			inComeMoneyList.add(inComeYear1All);
			inComeMoneyList.add(inComeYear2All);
			inComeMoneyList.add(inComeYear3All);
			resultIncome.add(inComeMoneyList);
			
			receiptMoneyList.add(receiptYear1All);
			receiptMoneyList.add(receiptYear2All);
			receiptMoneyList.add(receiptYear3All);
			resultReceipt.add(receiptMoneyList);
		}
		gsContractMoney.add(gsContractYear1All);
		gsContractMoney.add(gsContractYear2All);
		gsContractMoney.add(gsContractYear3All);
		resultContract.add(0,gsContractMoney);
		
		gsIncome.add(gsIncomeYear1All);
		gsIncome.add(gsIncomeYear2All);
		gsIncome.add(gsIncomeYear3All);
		resultIncome.add(0,gsIncome);
		
		gsReceipt.add(gsReceiptYear1All);
		gsReceipt.add(gsReceiptYear2All);
		gsReceipt.add(gsReceiptYear3All);
		resultReceipt.add(0,gsReceipt);
		map.put("om", omList);
		map.put("resultContract", resultContract);
		map.put("resultIncome", resultIncome);
		map.put("resultReceipt", resultReceipt);
		map.put("year", yearList);
		return map;
	}
	
	
	@RequestMapping("/initTab2ContractMoney")//初始化月份累计新签合同额
	@ResponseBody
	public Map<String,Object> initTab2ContractMoney(){
		Map<String,Object> map=new HashMap<>();
		List<List<Double>> resultList=new ArrayList<>();
		List<List<Double>> mbList=new ArrayList<>();
		List<String> omList=new ArrayList<>();
		omList.add("公司");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		List<OrganizationManagement> om=omService.selectProductionDepartment();//生产部门列表
		List<Double> resultAll=new ArrayList<>();
		List<Double> mbAll=new ArrayList<>();
		double month1All=0;
		double month2All=0;
		double month3All=0;
		double month4All=0;
		double month5All=0;
		double month6All=0;
		double month7All=0;
		double month8All=0;
		double month9All=0;
		double month10All=0;
		double month11All=0;
		double month12All=0;
		double mbMonth1All=0;
		double mbMonth2All=0;
		double mbMonth3All=0;
		double mbMonth4All=0;
		double mbMonth5All=0;
		double mbMonth6All=0;
		double mbMonth7All=0;
		double mbMonth8All=0;
		double mbMonth9All=0;
		double mbMonth10All=0;
		double mbMonth11All=0;
		double mbMonth12All=0;
		for(int i=0;i<om.size();i++){
			List<Double> result=new ArrayList<>();
			List<Double> mb=new ArrayList<>();
			
			String omId=om.get(i).getOmId();//部门编号
			String omName=om.get(i).getOmName();//部门名称
			omList.add(omName);
			
			ContractUpdate cu=cuService.selectDeptContractMoneyByTime(year+"-01", omId);
			double month1=cu.getMoney();//部门1份月合同额
			month1All=month1All+month1;
			
			ContractUpdate cu2=cuService.selectDeptContractMoneyByTime(year+"-02", omId);
			double month2=cu2.getMoney();//部门2份月合同额
			month2All=month2All+month2;
			
			ContractUpdate cu3=cuService.selectDeptContractMoneyByTime(year+"-03", omId);
			double month3=cu3.getMoney();//部门3份月合同额
			month3All=month3All+month3;
			
			ContractUpdate cu4=cuService.selectDeptContractMoneyByTime(year+"-04", omId);
			double month4=cu4.getMoney();//部门4份月合同额
			month4All=month4All+month4;
			
			ContractUpdate cu5=cuService.selectDeptContractMoneyByTime(year+"-05", omId);
			double month5=cu5.getMoney();//部门5份月合同额
			month5All=month5All+month5;
			
			ContractUpdate cu6=cuService.selectDeptContractMoneyByTime(year+"-06", omId);
			double month6=cu6.getMoney();//部门6份月合同额
			month6All=month6All+month6;
			
			ContractUpdate cu7=cuService.selectDeptContractMoneyByTime(year+"-07", omId);
			double month7=cu7.getMoney();//部门7份月合同额
			month7All=month7All+month7;
			
			ContractUpdate cu8=cuService.selectDeptContractMoneyByTime(year+"-08", omId);
			double month8=cu8.getMoney();//部门8份月合同额
			month8All=month8All+month8;
			
			ContractUpdate cu9=cuService.selectDeptContractMoneyByTime(year+"-09", omId);
			double month9=cu9.getMoney();//部门9份月合同额
			month9All=month9All+month9;
			
			ContractUpdate cu10=cuService.selectDeptContractMoneyByTime(year+"-10", omId);
			double month10=cu10.getMoney();//部门10份月合同额
			month10All=month10All+month10;
			
			ContractUpdate cu11=cuService.selectDeptContractMoneyByTime(year+"-11", omId);
			double month11=cu11.getMoney();//部门11份月合同额
			month11All=month11All+month11;
			
			ContractUpdate cu12=cuService.selectDeptContractMoneyByTime(year+"-12", omId);
			double month12=cu12.getMoney();//部门12份月合同额
			month12All=month12All+month12;
			
			result.add(month1);
			result.add(month2);
			result.add(month3);
			result.add(month4);
			result.add(month5);
			result.add(month6);
			result.add(month7);
			result.add(month8);
			result.add(month9);
			result.add(month10);
			result.add(month11);
			result.add(month12);
			resultList.add(result);
			
			List<MonthTarget> mt=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 1, omId);
			double mbMonth1=getMbContractMoney(mt);
			mbMonth1All=mbMonth1All+mbMonth1;
			
			List<MonthTarget> mt2=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 2, omId);
			double mbMonth2=getMbContractMoney(mt2);
			mbMonth2All=mbMonth2All+mbMonth2;
			
			List<MonthTarget> mt3=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 3, omId);
			double mbMonth3=getMbContractMoney(mt3);
			mbMonth3All=mbMonth3All+mbMonth3;
			
			List<MonthTarget> mt4=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 4, omId);
			double mbMonth4=getMbContractMoney(mt4);
			mbMonth4All=mbMonth4All+mbMonth4;
			
			List<MonthTarget> mt5=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 5, omId);
			double mbMonth5=getMbContractMoney(mt5);
			mbMonth5All=mbMonth5All+mbMonth5;
			
			List<MonthTarget> mt6=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 6, omId);
			double mbMonth6=getMbContractMoney(mt6);
			mbMonth6All=mbMonth6All+mbMonth6;
			
			List<MonthTarget> mt7=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 7, omId);
			double mbMonth7=getMbContractMoney(mt7);
			mbMonth7All=mbMonth7All+mbMonth7;
			
			List<MonthTarget> mt8=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 8, omId);
			double mbMonth8=getMbContractMoney(mt8);
			mbMonth8All=mbMonth8All+mbMonth8;
			
			List<MonthTarget> mt9=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 9, omId);
			double mbMonth9=getMbContractMoney(mt9);
			mbMonth9All=mbMonth9All+mbMonth9;
			
			List<MonthTarget> mt10=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 10, omId);
			double mbMonth10=getMbContractMoney(mt10);
			mbMonth10All=mbMonth10All+mbMonth10;
			
			List<MonthTarget> mt11=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 11, omId);
			double mbMonth11=getMbContractMoney(mt11);
			mbMonth11All=mbMonth11All+mbMonth11;
			
			List<MonthTarget> mt12=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 12, omId);
			double mbMonth12=getMbContractMoney(mt12);
			mbMonth12All=mbMonth12All+mbMonth12;
			
			mb.add(mbMonth1);
			mb.add(mbMonth2);
			mb.add(mbMonth3);
			mb.add(mbMonth4);
			mb.add(mbMonth5);
			mb.add(mbMonth6);
			mb.add(mbMonth7);
			mb.add(mbMonth8);
			mb.add(mbMonth9);
			mb.add(mbMonth10);
			mb.add(mbMonth11);
			mb.add(mbMonth12);
			mbList.add(mb);
		}
		resultAll.add(month1All);
		resultAll.add(month2All);
		resultAll.add(month3All);
		resultAll.add(month4All);
		resultAll.add(month5All);
		resultAll.add(month6All);
		resultAll.add(month7All);
		resultAll.add(month8All);
		resultAll.add(month9All);
		resultAll.add(month10All);
		resultAll.add(month11All);
		resultAll.add(month12All);
		mbAll.add(mbMonth1All);
		mbAll.add(mbMonth2All);
		mbAll.add(mbMonth3All);
		mbAll.add(mbMonth4All);
		mbAll.add(mbMonth5All);
		mbAll.add(mbMonth6All);
		mbAll.add(mbMonth7All);
		mbAll.add(mbMonth8All);
		mbAll.add(mbMonth9All);
		mbAll.add(mbMonth10All);
		mbAll.add(mbMonth11All);
		mbAll.add(mbMonth12All);
		resultList.add(0, resultAll);
		mbList.add(0,mbAll);
		map.put("result", resultList);
		map.put("mb", mbList);
		map.put("om", omList);
		return map;
	}
	
	
	@RequestMapping("/initTab2Income")//初始化月份累计收入
	@ResponseBody
	public Map<String,Object> initTab2Income(){
		Map<String,Object> map=new HashMap<>();
		List<List<Double>> resultList=new ArrayList<>();
		List<List<Double>> mbList=new ArrayList<>();
		List<String> omList=new ArrayList<>();
		omList.add("公司");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		List<OrganizationManagement> om=omService.selectProductionDepartment();//生产部门列表
		List<Double> resultAll=new ArrayList<>();
		List<Double> mbAll=new ArrayList<>();
		double month1All=0;
		double month2All=0;
		double month3All=0;
		double month4All=0;
		double month5All=0;
		double month6All=0;
		double month7All=0;
		double month8All=0;
		double month9All=0;
		double month10All=0;
		double month11All=0;
		double month12All=0;
		double mbMonth1All=0;
		double mbMonth2All=0;
		double mbMonth3All=0;
		double mbMonth4All=0;
		double mbMonth5All=0;
		double mbMonth6All=0;
		double mbMonth7All=0;
		double mbMonth8All=0;
		double mbMonth9All=0;
		double mbMonth10All=0;
		double mbMonth11All=0;
		double mbMonth12All=0;
		for(int i=0;i<om.size();i++){
			List<Double> result=new ArrayList<>();
			List<Double> mb=new ArrayList<>();
			String omName=om.get(i).getOmName();
			String omId=om.get(i).getOmId();
			omList.add(omName);
			PrjProgressFill ppf=pService.selectGsIncomeByTimeAndDept(year+"-01", omName);
			month1All=month1All+ppf.getAllMoneyYuan();
			PrjProgressFill ppf2=pService.selectGsIncomeByTimeAndDept(year+"-02", omName);
			month2All=month2All+ppf2.getAllMoneyYuan();
			PrjProgressFill ppf3=pService.selectGsIncomeByTimeAndDept(year+"-03", omName);
			month3All=month3All+ppf3.getAllMoneyYuan();
			PrjProgressFill ppf4=pService.selectGsIncomeByTimeAndDept(year+"-04", omName);
			month4All=month4All+ppf4.getAllMoneyYuan();
			PrjProgressFill ppf5=pService.selectGsIncomeByTimeAndDept(year+"-05", omName);
			month5All=month5All+ppf5.getAllMoneyYuan();
			PrjProgressFill ppf6=pService.selectGsIncomeByTimeAndDept(year+"-06", omName);
			month6All=month6All+ppf6.getAllMoneyYuan();
			PrjProgressFill ppf7=pService.selectGsIncomeByTimeAndDept(year+"-07", omName);
			month7All=month7All+ppf7.getAllMoneyYuan();
			PrjProgressFill ppf8=pService.selectGsIncomeByTimeAndDept(year+"-08", omName);
			month8All=month8All+ppf8.getAllMoneyYuan();
			PrjProgressFill ppf9=pService.selectGsIncomeByTimeAndDept(year+"-09", omName);
			month9All=month9All+ppf9.getAllMoneyYuan();
			PrjProgressFill ppf10=pService.selectGsIncomeByTimeAndDept(year+"-10", omName);
			month10All=month10All+ppf10.getAllMoneyYuan();
			PrjProgressFill ppf11=pService.selectGsIncomeByTimeAndDept(year+"-11", omName);
			month11All=month11All+ppf11.getAllMoneyYuan();
			PrjProgressFill ppf12=pService.selectGsIncomeByTimeAndDept(year+"-12", omName);
			month12All=month12All+ppf12.getAllMoneyYuan();
			result.add((double) ppf.getAllMoneyYuan());
			result.add((double) ppf2.getAllMoneyYuan());
			result.add((double) ppf3.getAllMoneyYuan());
			result.add((double) ppf4.getAllMoneyYuan());
			result.add((double) ppf5.getAllMoneyYuan());
			result.add((double) ppf6.getAllMoneyYuan());
			result.add((double) ppf7.getAllMoneyYuan());
			result.add((double) ppf8.getAllMoneyYuan());
			result.add((double) ppf9.getAllMoneyYuan());
			result.add((double) ppf10.getAllMoneyYuan());
			result.add((double) ppf11.getAllMoneyYuan());
			result.add((double) ppf12.getAllMoneyYuan());
			resultList.add(result);
			
			List<MonthTarget> mt=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 1, omId);
			double mbMonth1=getMbIncome(mt);
			mbMonth1All=mbMonth1All+mbMonth1;
			
			List<MonthTarget> mt2=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 2, omId);
			double mbMonth2=getMbIncome(mt2);
			mbMonth2All=mbMonth2All+mbMonth2;
			
			List<MonthTarget> mt3=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 3, omId);
			double mbMonth3=getMbIncome(mt3);
			mbMonth3All=mbMonth3All+mbMonth3;
			
			List<MonthTarget> mt4=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 4, omId);
			double mbMonth4=getMbIncome(mt4);
			mbMonth4All=mbMonth4All+mbMonth4;
			
			List<MonthTarget> mt5=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 5, omId);
			double mbMonth5=getMbIncome(mt5);
			mbMonth5All=mbMonth5All+mbMonth5;
			
			List<MonthTarget> mt6=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 6, omId);
			double mbMonth6=getMbIncome(mt6);
			mbMonth6All=mbMonth6All+mbMonth6;
			
			List<MonthTarget> mt7=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 7, omId);
			double mbMonth7=getMbIncome(mt7);
			mbMonth7All=mbMonth7All+mbMonth7;
			
			List<MonthTarget> mt8=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 8, omId);
			double mbMonth8=getMbIncome(mt8);
			mbMonth8All=mbMonth8All+mbMonth8;
			
			List<MonthTarget> mt9=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 9, omId);
			double mbMonth9=getMbIncome(mt9);
			mbMonth9All=mbMonth9All+mbMonth9;
			
			List<MonthTarget> mt10=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 10, omId);
			double mbMonth10=getMbIncome(mt10);
			mbMonth10All=mbMonth10All+mbMonth10;
			
			List<MonthTarget> mt11=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 11, omId);
			double mbMonth11=getMbIncome(mt11);
			mbMonth11All=mbMonth11All+mbMonth11;
			
			List<MonthTarget> mt12=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 12, omId);
			double mbMonth12=getMbIncome(mt12);
			mbMonth12All=mbMonth12All+mbMonth12;
			
			mb.add(mbMonth1);
			mb.add(mbMonth2);
			mb.add(mbMonth3);
			mb.add(mbMonth4);
			mb.add(mbMonth5);
			mb.add(mbMonth6);
			mb.add(mbMonth7);
			mb.add(mbMonth8);
			mb.add(mbMonth9);
			mb.add(mbMonth10);
			mb.add(mbMonth11);
			mb.add(mbMonth12);
			mbList.add(mb);
		}
		resultAll.add(month1All);
		resultAll.add(month2All);
		resultAll.add(month3All);
		resultAll.add(month4All);
		resultAll.add(month5All);
		resultAll.add(month6All);
		resultAll.add(month7All);
		resultAll.add(month8All);
		resultAll.add(month9All);
		resultAll.add(month10All);
		resultAll.add(month11All);
		resultAll.add(month12All);
		mbAll.add(mbMonth1All);
		mbAll.add(mbMonth2All);
		mbAll.add(mbMonth3All);
		mbAll.add(mbMonth4All);
		mbAll.add(mbMonth5All);
		mbAll.add(mbMonth6All);
		mbAll.add(mbMonth7All);
		mbAll.add(mbMonth8All);
		mbAll.add(mbMonth9All);
		mbAll.add(mbMonth10All);
		mbAll.add(mbMonth11All);
		mbAll.add(mbMonth12All);
		resultList.add(0, resultAll);
		mbList.add(0,mbAll);
		map.put("result", resultList);
		map.put("mb", mbList);
		map.put("om", omList);
		return map;
	}
	
	
	@RequestMapping("/initTab2Receipt")//初始化月份累计收款
	@ResponseBody
	public Map<String,Object> initTab2Receipt(){
		Map<String,Object> map=new HashMap<>();
		List<List<Double>> resultList=new ArrayList<>();
		List<List<Double>> mbList=new ArrayList<>();
		List<String> omList=new ArrayList<>();
		omList.add("公司");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		List<OrganizationManagement> om=omService.selectProductionDepartment();//生产部门列表
		List<Double> resultAll=new ArrayList<>();
		List<Double> mbAll=new ArrayList<>();
		double month1All=0;
		double month2All=0;
		double month3All=0;
		double month4All=0;
		double month5All=0;
		double month6All=0;
		double month7All=0;
		double month8All=0;
		double month9All=0;
		double month10All=0;
		double month11All=0;
		double month12All=0;
		double mbMonth1All=0;
		double mbMonth2All=0;
		double mbMonth3All=0;
		double mbMonth4All=0;
		double mbMonth5All=0;
		double mbMonth6All=0;
		double mbMonth7All=0;
		double mbMonth8All=0;
		double mbMonth9All=0;
		double mbMonth10All=0;
		double mbMonth11All=0;
		double mbMonth12All=0;
		
		for(int i=0;i<om.size();i++){
			List<Double> result=new ArrayList<>();
			List<Double> mb=new ArrayList<>();
			String omName=om.get(i).getOmName();
			String omId=om.get(i).getOmId();
			omList.add(omName);
			
			AlreadyRenling ar=aService.selectDeptRenlingByTime(year+"-01", omName);
			month1All=month1All+ar.getSkQuerenMoney();
			AlreadyRenling ar2=aService.selectDeptRenlingByTime(year+"-02", omName);
			month2All=month2All+ar2.getSkQuerenMoney();
			AlreadyRenling ar3=aService.selectDeptRenlingByTime(year+"-03", omName);
			month3All=month3All+ar3.getSkQuerenMoney();
			AlreadyRenling ar4=aService.selectDeptRenlingByTime(year+"-04", omName);
			month4All=month4All+ar4.getSkQuerenMoney();
			AlreadyRenling ar5=aService.selectDeptRenlingByTime(year+"-05", omName);
			month5All=month5All+ar5.getSkQuerenMoney();
			AlreadyRenling ar6=aService.selectDeptRenlingByTime(year+"-06", omName);
			month6All=month6All+ar6.getSkQuerenMoney();
			AlreadyRenling ar7=aService.selectDeptRenlingByTime(year+"-07", omName);
			month7All=month7All+ar7.getSkQuerenMoney();
			AlreadyRenling ar8=aService.selectDeptRenlingByTime(year+"-08", omName);
			month8All=month8All+ar8.getSkQuerenMoney();
			AlreadyRenling ar9=aService.selectDeptRenlingByTime(year+"-09", omName);
			month9All=month9All+ar9.getSkQuerenMoney();
			AlreadyRenling ar10=aService.selectDeptRenlingByTime(year+"-10", omName);
			month10All=month10All+ar10.getSkQuerenMoney();
			AlreadyRenling ar11=aService.selectDeptRenlingByTime(year+"-11", omName);
			month11All=month11All+ar11.getSkQuerenMoney();
			AlreadyRenling ar12=aService.selectDeptRenlingByTime(year+"-12", omName);
			month12All=month12All+ar12.getSkQuerenMoney();
			
			result.add(ar.getSkQuerenMoney());
			result.add(ar2.getSkQuerenMoney());
			result.add(ar3.getSkQuerenMoney());
			result.add(ar4.getSkQuerenMoney());
			result.add(ar5.getSkQuerenMoney());
			result.add(ar6.getSkQuerenMoney());
			result.add(ar7.getSkQuerenMoney());
			result.add(ar8.getSkQuerenMoney());
			result.add(ar9.getSkQuerenMoney());
			result.add(ar10.getSkQuerenMoney());
			result.add(ar11.getSkQuerenMoney());
			result.add(ar12.getSkQuerenMoney());
			resultList.add(result);
			
			List<MonthTarget> mt=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 1, omId);
			double mbMonth1=getMbReceipt(mt);
			mbMonth1All=mbMonth1All+mbMonth1;
			
			List<MonthTarget> mt2=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 2, omId);
			double mbMonth2=getMbReceipt(mt2);
			mbMonth2All=mbMonth2All+mbMonth2;
			
			List<MonthTarget> mt3=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 3, omId);
			double mbMonth3=getMbReceipt(mt3);
			mbMonth3All=mbMonth3All+mbMonth3;
			
			List<MonthTarget> mt4=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 4, omId);
			double mbMonth4=getMbReceipt(mt4);
			mbMonth4All=mbMonth4All+mbMonth4;
			
			List<MonthTarget> mt5=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 5, omId);
			double mbMonth5=getMbReceipt(mt5);
			mbMonth5All=mbMonth5All+mbMonth5;
			
			List<MonthTarget> mt6=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 6, omId);
			double mbMonth6=getMbReceipt(mt6);
			mbMonth6All=mbMonth6All+mbMonth6;
			
			List<MonthTarget> mt7=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 7, omId);
			double mbMonth7=getMbReceipt(mt7);
			mbMonth7All=mbMonth7All+mbMonth7;
			
			List<MonthTarget> mt8=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 8, omId);
			double mbMonth8=getMbReceipt(mt8);
			mbMonth8All=mbMonth8All+mbMonth8;
			
			List<MonthTarget> mt9=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 9, omId);
			double mbMonth9=getMbReceipt(mt9);
			mbMonth9All=mbMonth9All+mbMonth9;
			
			List<MonthTarget> mt10=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 10, omId);
			double mbMonth10=getMbReceipt(mt10);
			mbMonth10All=mbMonth10All+mbMonth10;
			
			List<MonthTarget> mt11=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 11, omId);
			double mbMonth11=getMbReceipt(mt11);
			mbMonth11All=mbMonth11All+mbMonth11;
			
			List<MonthTarget> mt12=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 12, omId);
			double mbMonth12=getMbReceipt(mt12);
			mbMonth12All=mbMonth12All+mbMonth12;
			
			mb.add(mbMonth1);
			mb.add(mbMonth2);
			mb.add(mbMonth3);
			mb.add(mbMonth4);
			mb.add(mbMonth5);
			mb.add(mbMonth6);
			mb.add(mbMonth7);
			mb.add(mbMonth8);
			mb.add(mbMonth9);
			mb.add(mbMonth10);
			mb.add(mbMonth11);
			mb.add(mbMonth12);
			mbList.add(mb);
		}
		resultAll.add(month1All);
		resultAll.add(month2All);
		resultAll.add(month3All);
		resultAll.add(month4All);
		resultAll.add(month5All);
		resultAll.add(month6All);
		resultAll.add(month7All);
		resultAll.add(month8All);
		resultAll.add(month9All);
		resultAll.add(month10All);
		resultAll.add(month11All);
		resultAll.add(month12All);
		mbAll.add(mbMonth1All);
		mbAll.add(mbMonth2All);
		mbAll.add(mbMonth3All);
		mbAll.add(mbMonth4All);
		mbAll.add(mbMonth5All);
		mbAll.add(mbMonth6All);
		mbAll.add(mbMonth7All);
		mbAll.add(mbMonth8All);
		mbAll.add(mbMonth9All);
		mbAll.add(mbMonth10All);
		mbAll.add(mbMonth11All);
		mbAll.add(mbMonth12All);
		resultList.add(0, resultAll);
		mbList.add(0,mbAll);
		map.put("result", resultList);
		map.put("mb", mbList);
		map.put("om", omList);
		return map;
	}
	
	@RequestMapping("/initTab3ContractMoney")//初始化年度统计新签合同额最近三年
	@ResponseBody
	public Map<String,Object> initTab3ContractMoney(){
		Map<String,Object> map=new HashMap<>();
		List<List<Double>> resultList=new ArrayList<>();
		List<List<Double>> mbList=new ArrayList<>();
		List<String> omList=new ArrayList<>();
		List<String> yearList=new ArrayList<>();
		omList.add("公司");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		String year2=((Integer.valueOf(year))-1)+"";
		String year3=((Integer.valueOf(year))-2)+"";
		yearList.add(year3);
		yearList.add(year2);
		yearList.add(year);
		List<OrganizationManagement> om=omService.selectProductionDepartment();//生产部门列表
		
		List<Double> resultAll=new ArrayList<>();
		List<Double> mbAll=new ArrayList<>();
		double month1All=0;
		double month2All=0;
		double month3All=0;
		
		double mbMonth1All=0;
		double mbMonth2All=0;
		double mbMonth3All=0;
		
		for(int i=0;i<om.size();i++){
			List<Double> result=new ArrayList<>();
			List<Double> mb=new ArrayList<>();
			
			String omId=om.get(i).getOmId();//部门编号
			String omName=om.get(i).getOmName();//部门名称
			omList.add(omName);
			
			ContractUpdate cu=cuService.selectDeptContractMoneyByTime(year3,omId);
			double month1=cu.getMoney();//部门前年合同额
			month1All=month1All+month1;
			
			ContractUpdate cu2=cuService.selectDeptContractMoneyByTime(year2,omId);
			double month2=cu2.getMoney();//部门去年合同额
			month2All=month2All+month2;
			
			ContractUpdate cu3=cuService.selectDeptContractMoneyByTime(year,omId);
			double month3=cu3.getMoney();//部门去年合同额
			month3All=month3All+month3;
			
			
			result.add(month1);
			result.add(month2);
			result.add(month3);
			resultList.add(result);
			
			DepartmentTarget mt=dtService.selectDepartmentTargetByOmIdAndYear(omId, year3);
			double mbMonth1=0;
			if(mt!=null){
				mbMonth1=mt.getContractAmount();
			}
			mbMonth1All=mbMonth1All+mbMonth1;
			
			DepartmentTarget mt2=dtService.selectDepartmentTargetByOmIdAndYear(omId, year2);
			double mbMonth2=0;
			if(mt2!=null){
				mbMonth2=mt2.getContractAmount();
			}
			mbMonth2All=mbMonth2All+mbMonth2;
			
			DepartmentTarget mt3=dtService.selectDepartmentTargetByOmIdAndYear(omId, year);
			double mbMonth3=0;
			if(mt3!=null){
				 mbMonth3=mt3.getContractAmount();
			}
			mbMonth3All=mbMonth3All+mbMonth3;
			
			
			mb.add(mbMonth1);
			mb.add(mbMonth2);
			mb.add(mbMonth3);
			mbList.add(mb);
		}
		resultAll.add(month1All);
		resultAll.add(month2All);
		resultAll.add(month3All);
		mbAll.add(mbMonth1All);
		mbAll.add(mbMonth2All);
		mbAll.add(mbMonth3All);
		resultList.add(0, resultAll);
		mbList.add(0,mbAll);
		map.put("result", resultList);
		map.put("mb", mbList);
		map.put("om", omList);
		map.put("year", yearList);
		return map;
	}
	
	@RequestMapping("/initTab3Income")
	@ResponseBody
	public Map<String,Object> initTab3Income(){
		Map<String,Object> map=new HashMap<>();
		List<List<Double>> resultList=new ArrayList<>();
		List<List<Double>> mbList=new ArrayList<>();
		List<String> omList=new ArrayList<>();
		List<String> yearList=new ArrayList<>();
		omList.add("公司");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		String year2=((Integer.valueOf(year))-1)+"";
		String year3=((Integer.valueOf(year))-2)+"";
		yearList.add(year3);
		yearList.add(year2);
		yearList.add(year);
		List<OrganizationManagement> om=omService.selectProductionDepartment();//生产部门列表
		List<Double> resultAll=new ArrayList<>();
		List<Double> mbAll=new ArrayList<>();
		double month1All=0;
		double month2All=0;
		double month3All=0;
		
		double mbMonth1All=0;
		double mbMonth2All=0;
		double mbMonth3All=0;
	
		for(int i=0;i<om.size();i++){
			List<Double> result=new ArrayList<>();
			List<Double> mb=new ArrayList<>();
			String omName=om.get(i).getOmName();
			String omId=om.get(i).getOmId();
			omList.add(omName);
			
			PrjProgressFill ppf=pService.selectGsIncomeByTimeAndDept(year3, omName);
			month1All=month1All+ppf.getAllMoneyYuan();
			PrjProgressFill ppf2=pService.selectGsIncomeByTimeAndDept(year2, omName);
			month2All=month2All+ppf2.getAllMoneyYuan();
			PrjProgressFill ppf3=pService.selectGsIncomeByTimeAndDept(year, omName);
			month3All=month3All+ppf3.getAllMoneyYuan();
			
			result.add((double) ppf.getAllMoneyYuan());
			result.add((double) ppf2.getAllMoneyYuan());
			result.add((double) ppf3.getAllMoneyYuan());
			
			resultList.add(result);
			
			DepartmentTarget mt=dtService.selectDepartmentTargetByOmIdAndYear(omId, year3);
			double mbMonth1=0;
			if(mt!=null){
				mbMonth1=mt.getRevenueTarget();
			}
			mbMonth1All=mbMonth1All+mbMonth1;
			
			DepartmentTarget mt2=dtService.selectDepartmentTargetByOmIdAndYear(omId, year2);
			double mbMonth2=0;
			if(mt2!=null){
				mbMonth2=mt2.getRevenueTarget();
			}
			mbMonth2All=mbMonth2All+mbMonth2;
			
			DepartmentTarget mt3=dtService.selectDepartmentTargetByOmIdAndYear(omId, year);
			double mbMonth3=0;
			if(mt3!=null){
				mbMonth3=mt3.getRevenueTarget();
			}
			mbMonth3All=mbMonth3All+mbMonth3;
			
			mb.add(mbMonth1);
			mb.add(mbMonth2);
			mb.add(mbMonth3);
			mbList.add(mb);
		}
		resultAll.add(month1All);
		resultAll.add(month2All);
		resultAll.add(month3All);
		mbAll.add(mbMonth1All);
		mbAll.add(mbMonth2All);
		mbAll.add(mbMonth3All);
		resultList.add(0, resultAll);
		mbList.add(0,mbAll);
		map.put("result", resultList);
		map.put("mb", mbList);
		map.put("om", omList);
		map.put("year", yearList);
		return map;
	}
	
	@RequestMapping("/initTab3Receipt")
	@ResponseBody
	public Map<String,Object> initTab3Receipt(){
		Map<String,Object> map=new HashMap<>();
		List<List<Double>> resultList=new ArrayList<>();
		List<List<Double>> mbList=new ArrayList<>();
		List<String> omList=new ArrayList<>();
		List<String> yearList=new ArrayList<>();
		omList.add("公司");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		String year2=((Integer.valueOf(year))-1)+"";
		String year3=((Integer.valueOf(year))-2)+"";
		yearList.add(year3);
		yearList.add(year2);
		yearList.add(year);
		List<OrganizationManagement> om=omService.selectProductionDepartment();//生产部门列表
		List<Double> resultAll=new ArrayList<>();
		List<Double> mbAll=new ArrayList<>();
		double month1All=0;
		double month2All=0;
		double month3All=0;
		
		double mbMonth1All=0;
		double mbMonth2All=0;
		double mbMonth3All=0;
		
		for(int i=0;i<om.size();i++){
			List<Double> result=new ArrayList<>();
			List<Double> mb=new ArrayList<>();
			String omName=om.get(i).getOmName();
			String omId=om.get(i).getOmId();
			omList.add(omName);
			
			AlreadyRenling ar=aService.selectDeptRenlingByTime(year3, omName);
			month1All=month1All+ar.getSkQuerenMoney();
			AlreadyRenling ar2=aService.selectDeptRenlingByTime(year2, omName);
			month2All=month2All+ar2.getSkQuerenMoney();
			AlreadyRenling ar3=aService.selectDeptRenlingByTime(year, omName);
			month3All=month3All+ar3.getSkQuerenMoney();
			
			result.add(ar.getSkQuerenMoney());
			result.add(ar2.getSkQuerenMoney());
			result.add(ar3.getSkQuerenMoney());
			resultList.add(result);
			
			DepartmentTarget mt=dtService.selectDepartmentTargetByOmIdAndYear(omId, year3);
			double mbMonth1=0;
			if(mt!=null){
				mbMonth1=mt.getCollectionTarget();
			}
			mbMonth1All=mbMonth1All+mbMonth1;
			
			DepartmentTarget mt2=dtService.selectDepartmentTargetByOmIdAndYear(omId, year2);
			double mbMonth2=0;
			if(mt2!=null){
				mbMonth2=mt2.getCollectionTarget();
			}
			mbMonth2All=mbMonth2All+mbMonth2;
			
			DepartmentTarget mt3=dtService.selectDepartmentTargetByOmIdAndYear(omId, year);
			double mbMonth3=0;
			if(mt3!=null){
				mbMonth3=mt3.getCollectionTarget();
			}
			mbMonth3All=mbMonth3All+mbMonth3;
			
			
			mb.add(mbMonth1);
			mb.add(mbMonth2);
			mb.add(mbMonth3);
			mbList.add(mb);
		}
		resultAll.add(month1All);
		resultAll.add(month2All);
		resultAll.add(month3All);
		
		mbAll.add(mbMonth1All);
		mbAll.add(mbMonth2All);
		mbAll.add(mbMonth3All);
		
		resultList.add(0, resultAll);
		mbList.add(0,mbAll);
		map.put("result", resultList);
		map.put("mb", mbList);
		map.put("om", omList);
		map.put("year", yearList);
		return map;
	}
	
	
	public float getDepartmentMoney(List<CjContract> cj,String omId){
		float contractMoney=0;
		for(int i=0;i<cj.size();i++){
			if(omId.equals(cj.get(i).getMainDepartment())){
				contractMoney=cj.get(i).getMainDepartmentMoney();
			}
			if(omId.equals(cj.get(i).getAssistDepartment1())){
				contractMoney=cj.get(i).getAssistDepartment1Money();
			}
			if(omId.equals(cj.get(i).getAssistDepartment2())){
				contractMoney=cj.get(i).getAssistDepartment2Money();
			}
			if(omId.equals(cj.get(i).getAssistDepartment3())){
				contractMoney=cj.get(i).getAssistDepartment3Money();
			}
		}
		return contractMoney;
	}
	
	public float getDepartmentMoneyByTask(List<Task> task,String omId){
		float contractMoney=0;
		for(int i=0;i<task.size();i++){
			if(omId.equals(task.get(i).getMainDepartment())){
				contractMoney=task.get(i).getMainDepartmentMoney();
			}
			if(omId.equals(task.get(i).getAssistDepartment1())){
				contractMoney=task.get(i).getAssistDepartment1Money();
			}
			if(omId.equals(task.get(i).getAssistDepartment2())){
				contractMoney=task.get(i).getAssistDepartment2Money();
			}
			if(omId.equals(task.get(i).getAssistDepartment3())){
				contractMoney=task.get(i).getAssistDepartment3Money();
			}
		}
		return contractMoney;
	}
	
	public float getDepartmentReceipt(List<CjContract> cj,String omId){
		float receiptAll=0;
		if(cj!=null){
			for(int j=0;j<cj.size();j++){
				float contractMoney=cj.get(j).getContractMoney();//承接合同金额
				float resultMoney=cj.get(j).getTemporaryMoney();//承接合同收款金额
				if(omId.equals(cj.get(j).getMainDepartment())){
					receiptAll=receiptAll+(cj.get(j).getMainDepartmentMoney()/contractMoney)*resultMoney;
				}
				if(omId.equals(cj.get(j).getAssistDepartment1())){
					receiptAll=receiptAll+(cj.get(j).getMainDepartmentMoney()/contractMoney)*resultMoney;
				}
				if(omId.equals(cj.get(j).getAssistDepartment2())){
					receiptAll=receiptAll+(cj.get(j).getMainDepartmentMoney()/contractMoney)*resultMoney;
				}
				if(omId.equals(cj.get(j).getAssistDepartment3())){
					receiptAll=receiptAll+(cj.get(j).getMainDepartmentMoney()/contractMoney)*resultMoney;
				}
			}
		}
		return receiptAll;
	}
	
	public double getMbContractMoney(List<MonthTarget> mt){
		double money=0;
		if(mt!=null){
			for(int jj=0;jj<mt.size();jj++){
				double contractAmount=mt.get(jj).getContractAmount();
				money=money+contractAmount;
			}
		}
		return money;
	}
	
	public double getMbIncome(List<MonthTarget> mt){
		double money=0;
		if(mt!=null){
			for(int jj=0;jj<mt.size();jj++){
				double income=mt.get(jj).getRevenueTarget();
				money=money+income;
			}
		}
		return money;
	}
	
	public double getMbReceipt(List<MonthTarget> mt){
		double money=0;
		if(mt!=null){
			for(int jj=0;jj<mt.size();jj++){
				double receipt=mt.get(jj).getCollectionTarget();
				money=money+receipt;
			}
		}
		return money;
	}
	
	public float getReceiptByPrjType(String type,List<CjContract> cj){
		float money=0;
		if(cj!=null){
			for(int i=0;i<cj.size();i++){
				float resultReceipt=cj.get(i).getTemporaryMoney();//实际收款
				float cjContractMoney=cj.get(i).getContractMoney();//承接合同金额
				String prjNo=cj.get(i).getTaskCode();
				for(int ii=0;ii<prjNo.split(",").length;ii++){
					String no=prjNo.split(",")[ii];
					Task t=tService.selectTaskByNoAndType(type, no);
					if(t!=null){
						float contractMoney=t.getContractMoney();//任务单合同金额
						money=money+(cjContractMoney/contractMoney)*resultReceipt;
					}
				}
			}
		}
		return money;
	}
	
}

/**
 * <p>Title: StatisticsController.java</p>
 * <p>Description: 华通桥涵管理系统</p>
 * <p>Company: 环水信息技术有限公司</p>
 * @author 马潇霄
 * @version 1.0 创建时间：2018年12月13日 下午4:41:53
 */

package org.ldxx.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.AlreadyRenling;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.ContractUpdate;
import org.ldxx.bean.DepartmentTarget;
import org.ldxx.bean.MonthTarget;
import org.ldxx.bean.OperationTarget;
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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

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
//	@Autowired
//	private DepartmentTargetService dtService;
	@Autowired
	private TaskService tService;
	@Autowired
	private AlreadySkInfoService aService;
	@Autowired
	private ContractUpdateService cuService;
	@Autowired
	private DepartmentTargetService dtservice; 
	@Autowired
	private OperationTargetService oservice;

	@RequestMapping("/initGsContract")//初始化本期公司新签合同额。累计收款，累计收入
	@ResponseBody
	public Map<String,BigDecimal> initGsContractMoney(){
		Map<String,BigDecimal> map=new HashMap<String, BigDecimal>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		String time=sdf.format(new Date());
		String year=time.split("-")[0];
		int month=Integer.valueOf(time.split("-")[1]);
		BigDecimal contractAll=new BigDecimal(0);//累计合同额
		BigDecimal allInCome=new BigDecimal(0);//累计收入
		BigDecimal allReceipt=new BigDecimal(0);//累计收款
		ContractUpdate cu=cuService.selectGsContractMoneyByTime(time);
		contractAll=cu.getMoney();
		PrjProgressFill ppf=pService.selectGsIncomeByTime(time);
		allInCome=ppf.getAllMoneyYuan();
		AlreadyRenling ar=aService.selectGsRenlingByTime(time);
		allReceipt=ar.getSkQuerenMoney();
				
		BigDecimal mbContractMoney=new BigDecimal(0);//目标合同额
		BigDecimal mbIncome=new BigDecimal(0);//目标收入
		BigDecimal mbReceipt=new BigDecimal(0);//目标收款
		List<MonthTarget> mt=mService.selectMonthTargetByYearAndMonth(year, month);
		if(mt!=null){
			for(int i=0;i<mt.size();i++){
				BigDecimal contractAmount=mt.get(i).getContractAmount();
				BigDecimal revenueTarget=mt.get(i).getRevenueTarget();
				BigDecimal collectionTarget=mt.get(i).getCollectionTarget();
				mbContractMoney=mbContractMoney.add(contractAmount);
				mbIncome=mbIncome.add(revenueTarget);
				mbReceipt=mbReceipt.add(collectionTarget);
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
			BigDecimal contractAll=new BigDecimal(0);//新签合同额目标
			BigDecimal totalIncomeAll=new BigDecimal(0);//累计收入
			BigDecimal receiptAll=new BigDecimal(0);//累计收款
			ContractUpdate cu=cuService.selectDeptContractMoneyByTime(time, omId);
			contractAll=cu.getMoney();
			PrjProgressFill ppf=pService.selectGsIncomeByTimeAndDept(time, omName);
			totalIncomeAll=ppf.getAllMoneyYuan();
			AlreadyRenling ar=aService.selectDeptRenlingByTime(time, omName);
			receiptAll=ar.getSkQuerenMoney();
			
			BigDecimal mbContractMoney=new BigDecimal(0);//目标合同额
			BigDecimal mbIncome=new BigDecimal(0);//目标收入
			BigDecimal mbReceipt=new BigDecimal(0);//目标收款
			List<MonthTarget> mt=mService.selectMonthTargetByYearAndMonthAndDepartment(year, month, omId);
			if(mt!=null){
				for(int jj=0;jj<mt.size();jj++){
					BigDecimal contractAmount=mt.get(jj).getContractAmount();
					BigDecimal revenueTarget=mt.get(jj).getRevenueTarget();
					BigDecimal collectionTarget=mt.get(jj).getCollectionTarget();
					mbContractMoney=mbContractMoney.add(contractAmount);
					mbIncome=mbIncome.add(revenueTarget);
					mbReceipt=mbReceipt.add(collectionTarget);
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
		List<List<BigDecimal>> resultContract=new ArrayList<>();//实际月部门新签合同额按项目类型
		List<List<BigDecimal>> resultIncome=new ArrayList<>();//实际月部门累计收入按项目类型
		List<List<BigDecimal>> resultReceipt=new ArrayList<>();//实际月部门累计收款按项目类型
		List<String> omList=new ArrayList<>();
		//获取月份
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		omList.add("公司");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		
		List<OrganizationManagement> om=omService.selectProductionDepartment();//生产部门列表
		//公司月份部门累加
		List<BigDecimal> gsContractMoney=new ArrayList<>();
		BigDecimal gsContractMoneyMonth1All=new BigDecimal(0);
		BigDecimal gsContractMoneyMonth2All=new BigDecimal(0);
		BigDecimal gsContractMoneyMonth3All=new BigDecimal(0);
		BigDecimal gsContractMoneyMonth4All=new BigDecimal(0);
		BigDecimal gsContractMoneyMonth5All=new BigDecimal(0);
		BigDecimal gsContractMoneyMonth6All=new BigDecimal(0);
		BigDecimal gsContractMoneyMonth7All=new BigDecimal(0);
		BigDecimal gsContractMoneyMonth8All=new BigDecimal(0);
		BigDecimal gsContractMoneyMonth9All=new BigDecimal(0);
		BigDecimal gsContractMoneyMonth10All=new BigDecimal(0);
		BigDecimal gsContractMoneyMonth11All=new BigDecimal(0);
		BigDecimal gsContractMoneyMonth12All=new BigDecimal(0);
		
		List<BigDecimal> gsIncome=new ArrayList<>();
		BigDecimal gsIncomeMonth1All=new BigDecimal(0);
		BigDecimal gsIncomeMonth2All=new BigDecimal(0);
		BigDecimal gsIncomeMonth3All=new BigDecimal(0);
		BigDecimal gsIncomeMonth4All=new BigDecimal(0);
		BigDecimal gsIncomeMonth5All=new BigDecimal(0);
		BigDecimal gsIncomeMonth6All=new BigDecimal(0);
		BigDecimal gsIncomeMonth7All=new BigDecimal(0);
		BigDecimal gsIncomeMonth8All=new BigDecimal(0);
		BigDecimal gsIncomeMonth9All=new BigDecimal(0);
		BigDecimal gsIncomeMonth10All=new BigDecimal(0);
		BigDecimal gsIncomeMonth11All=new BigDecimal(0);
		BigDecimal gsIncomeMonth12All=new BigDecimal(0);
		
		List<BigDecimal> gsReceipt=new ArrayList<>();
		BigDecimal gsReceiptMonth1All=new BigDecimal(0);
		BigDecimal gsReceiptMonth2All=new BigDecimal(0);
		BigDecimal gsReceiptMonth3All=new BigDecimal(0);
		BigDecimal gsReceiptMonth4All=new BigDecimal(0);
		BigDecimal gsReceiptMonth5All=new BigDecimal(0);
		BigDecimal gsReceiptMonth6All=new BigDecimal(0);
		BigDecimal gsReceiptMonth7All=new BigDecimal(0);
		BigDecimal gsReceiptMonth8All=new BigDecimal(0);
		BigDecimal gsReceiptMonth9All=new BigDecimal(0);
		BigDecimal gsReceiptMonth10All=new BigDecimal(0);
		BigDecimal gsReceiptMonth11All=new BigDecimal(0);
		BigDecimal gsReceiptMonth12All=new BigDecimal(0);
		for(int o=0;o<om.size();o++){
			String omId=om.get(o).getOmId();
			String omName=om.get(o).getOmName();
			omList.add(omName);
			
			//部门新签合同额按项目类型
			List<BigDecimal> contractMoneyList=new ArrayList<>();
			BigDecimal contractMonth1All=new BigDecimal(0);
			BigDecimal contractMonth2All=new BigDecimal(0);
			BigDecimal contractMonth3All=new BigDecimal(0);
			BigDecimal contractMonth4All=new BigDecimal(0);
			BigDecimal contractMonth5All=new BigDecimal(0);
			BigDecimal contractMonth6All=new BigDecimal(0);
			BigDecimal contractMonth7All=new BigDecimal(0);
			BigDecimal contractMonth8All=new BigDecimal(0);
			BigDecimal contractMonth9All=new BigDecimal(0);
			BigDecimal contractMonth10All=new BigDecimal(0);
			BigDecimal contractMonth11All=new BigDecimal(0);
			BigDecimal contractMonth12All=new BigDecimal(0);
			//部门累计收入按项目类型
			List<BigDecimal> inComeMoneyList=new ArrayList<>();
			BigDecimal inComeMonth1All=new BigDecimal(0);
			BigDecimal inComeMonth2All=new BigDecimal(0);
			BigDecimal inComeMonth3All=new BigDecimal(0);
			BigDecimal inComeMonth4All=new BigDecimal(0);
			BigDecimal inComeMonth5All=new BigDecimal(0);
			BigDecimal inComeMonth6All=new BigDecimal(0);
			BigDecimal inComeMonth7All=new BigDecimal(0);
			BigDecimal inComeMonth8All=new BigDecimal(0);
			BigDecimal inComeMonth9All=new BigDecimal(0);
			BigDecimal inComeMonth10All=new BigDecimal(0);
			BigDecimal inComeMonth11All=new BigDecimal(0);
			BigDecimal inComeMonth12All=new BigDecimal(0);
			//部门累计收款按项目类型
			List<BigDecimal> receiptMoneyList=new ArrayList<>();
			BigDecimal receiptMonth1All=new BigDecimal(0);
			BigDecimal receiptMonth2All=new BigDecimal(0);
			BigDecimal receiptMonth3All=new BigDecimal(0);
			BigDecimal receiptMonth4All=new BigDecimal(0);
			BigDecimal receiptMonth5All=new BigDecimal(0);
			BigDecimal receiptMonth6All=new BigDecimal(0);
			BigDecimal receiptMonth7All=new BigDecimal(0);
			BigDecimal receiptMonth8All=new BigDecimal(0);
			BigDecimal receiptMonth9All=new BigDecimal(0);
			BigDecimal receiptMonth10All=new BigDecimal(0);
			BigDecimal receiptMonth11All=new BigDecimal(0);
			BigDecimal receiptMonth12All=new BigDecimal(0);
			
			for(int i=0;i<prjType.split(",").length;i++){
				//部门新签合同额按项目类型
				String type=prjType.split(",")[i];
				ContractUpdate cu=cuService.selectDeptContractMoneyByTimeAndType(year+"-01", omId, type);
				BigDecimal contractMonth1=cu.getMoney();
				contractMonth1All=contractMonth1All.add(cu.getMoney());
				ContractUpdate cu2=cuService.selectDeptContractMoneyByTimeAndType(year+"-02", omId, type);
				BigDecimal contractMonth2=cu2.getMoney().add(contractMonth1);
				contractMonth2All=contractMonth2All.add(cu2.getMoney());
				ContractUpdate cu3=cuService.selectDeptContractMoneyByTimeAndType(year+"-03", omId, type);
				BigDecimal contractMonth3=cu3.getMoney().add(contractMonth2);
				contractMonth3All=contractMonth3All.add(cu3.getMoney());
				ContractUpdate cu4=cuService.selectDeptContractMoneyByTimeAndType(year+"-04", omId, type);
				BigDecimal contractMonth4=cu4.getMoney().add(contractMonth3);
				contractMonth4All=contractMonth4All.add(cu4.getMoney());
				ContractUpdate cu5=cuService.selectDeptContractMoneyByTimeAndType(year+"-05", omId, type);
				BigDecimal contractMonth5=cu5.getMoney().add(contractMonth4);
				contractMonth5All=contractMonth5All.add(cu5.getMoney());
				ContractUpdate cu6=cuService.selectDeptContractMoneyByTimeAndType(year+"-06", omId, type);
				BigDecimal contractMonth6=cu6.getMoney().add(contractMonth5);
				contractMonth6All=contractMonth6All.add(cu6.getMoney());
				ContractUpdate cu7=cuService.selectDeptContractMoneyByTimeAndType(year+"-07", omId, type);
				BigDecimal contractMonth7=cu7.getMoney().add(contractMonth6);
				contractMonth7All=contractMonth7All.add(cu7.getMoney());
				ContractUpdate cu8=cuService.selectDeptContractMoneyByTimeAndType(year+"-08", omId, type);
				BigDecimal contractMonth8=cu8.getMoney().add(contractMonth7);
				contractMonth8All=contractMonth8All.add(cu8.getMoney());
				ContractUpdate cu9=cuService.selectDeptContractMoneyByTimeAndType(year+"-09", omId, type);
				BigDecimal contractMonth9=cu9.getMoney().add(contractMonth8);
				contractMonth9All=contractMonth9All.add(cu9.getMoney());
				ContractUpdate cu10=cuService.selectDeptContractMoneyByTimeAndType(year+"-10", omId, type);
				BigDecimal contractMonth10=cu10.getMoney().add(contractMonth9);
				contractMonth10All=contractMonth10All.add(cu10.getMoney());
				ContractUpdate cu11=cuService.selectDeptContractMoneyByTimeAndType(year+"-11", omId, type);
				BigDecimal contractMonth11=cu11.getMoney().add(contractMonth10);
				contractMonth11All=contractMonth11All.add(cu11.getMoney());
				ContractUpdate cu12=cuService.selectDeptContractMoneyByTimeAndType(year+"-12", omId, type);
				BigDecimal contractMonth12=cu12.getMoney().add(contractMonth11);
				contractMonth12All=contractMonth12All.add(cu12.getMoney());
				
				
				//部门累计收入按项目类型
				PrjProgressFill ppf=pService.selectDeptIncomeByTimeAndType(year+"-01", omName, type);
				BigDecimal inComeMonth1=ppf.getAllMoneyYuan();
				inComeMonth1All=inComeMonth1All.add(ppf.getAllMoneyYuan());
				PrjProgressFill ppf2=pService.selectDeptIncomeByTimeAndType(year+"-02", omName, type);
				BigDecimal inComeMonth2=ppf2.getAllMoneyYuan().add(inComeMonth1);
				inComeMonth2All=inComeMonth2All.add(ppf2.getAllMoneyYuan());
				PrjProgressFill ppf3=pService.selectDeptIncomeByTimeAndType(year+"-03", omName, type);
				BigDecimal inComeMonth3=ppf3.getAllMoneyYuan().add(inComeMonth2);
				inComeMonth3All=inComeMonth3All.add(ppf3.getAllMoneyYuan());
				PrjProgressFill ppf4=pService.selectDeptIncomeByTimeAndType(year+"-04", omName, type);
				BigDecimal inComeMonth4=ppf4.getAllMoneyYuan().add(inComeMonth3);
				inComeMonth4All=inComeMonth4All.add(ppf4.getAllMoneyYuan());
				PrjProgressFill ppf5=pService.selectDeptIncomeByTimeAndType(year+"-05", omName, type);
				BigDecimal inComeMonth5=ppf5.getAllMoneyYuan().add(inComeMonth4);
				inComeMonth5All=inComeMonth5All.add(ppf5.getAllMoneyYuan());
				PrjProgressFill ppf6=pService.selectDeptIncomeByTimeAndType(year+"-06", omName, type);
				BigDecimal inComeMonth6=ppf6.getAllMoneyYuan().add(inComeMonth5);
				inComeMonth6All=inComeMonth6All.add(ppf6.getAllMoneyYuan());
				PrjProgressFill ppf7=pService.selectDeptIncomeByTimeAndType(year+"-07", omName, type);
				BigDecimal inComeMonth7=ppf7.getAllMoneyYuan().add(inComeMonth6);
				inComeMonth7All=inComeMonth7All.add(ppf7.getAllMoneyYuan());
				PrjProgressFill ppf8=pService.selectDeptIncomeByTimeAndType(year+"-08", omName, type);
				BigDecimal inComeMonth8=ppf8.getAllMoneyYuan().add(inComeMonth7);
				inComeMonth8All=inComeMonth8All.add(ppf8.getAllMoneyYuan());
				PrjProgressFill ppf9=pService.selectDeptIncomeByTimeAndType(year+"-09", omName, type);
				BigDecimal inComeMonth9=ppf9.getAllMoneyYuan().add(inComeMonth8);
				inComeMonth9All=inComeMonth9All.add(ppf9.getAllMoneyYuan());
				PrjProgressFill ppf10=pService.selectDeptIncomeByTimeAndType(year+"-10", omName, type);
				BigDecimal inComeMonth10=ppf10.getAllMoneyYuan().add(inComeMonth9);
				inComeMonth10All=inComeMonth10All.add(ppf10.getAllMoneyYuan());
				PrjProgressFill ppf11=pService.selectDeptIncomeByTimeAndType(year+"-11", omName, type);
				BigDecimal inComeMonth11=ppf11.getAllMoneyYuan().add(inComeMonth10);
				inComeMonth11All=inComeMonth11All.add(ppf11.getAllMoneyYuan());
				PrjProgressFill ppf12=pService.selectDeptIncomeByTimeAndType(year+"-12", omName, type);
				BigDecimal inComeMonth12=ppf12.getAllMoneyYuan().add(inComeMonth11);
				inComeMonth12All=inComeMonth12All.add(ppf12.getAllMoneyYuan());
				
				
				//部门累计收款按项目类型
				AlreadyRenling ar=aService.selectDeptRenlingByTimeAndType(year+"-01", omName, type);
				BigDecimal receiptMonth1=ar.getSkQuerenMoney();
				receiptMonth1All=receiptMonth1All.add(ar.getSkQuerenMoney());
				AlreadyRenling ar2=aService.selectDeptRenlingByTimeAndType(year+"-02", omName, type);
				BigDecimal receiptMonth2=ar2.getSkQuerenMoney().add(receiptMonth1);
				receiptMonth2All=receiptMonth2All.add(ar2.getSkQuerenMoney());	
				AlreadyRenling ar3=aService.selectDeptRenlingByTimeAndType(year+"-03", omName, type);
				BigDecimal receiptMonth3=ar3.getSkQuerenMoney().add(receiptMonth2);
				receiptMonth3All=receiptMonth3All.add(ar3.getSkQuerenMoney());
				AlreadyRenling ar4=aService.selectDeptRenlingByTimeAndType(year+"-04", omName, type);
				BigDecimal receiptMonth4=ar4.getSkQuerenMoney().add(receiptMonth3);
				receiptMonth4All=receiptMonth4All.add(ar4.getSkQuerenMoney());
				AlreadyRenling ar5=aService.selectDeptRenlingByTimeAndType(year+"-05", omName, type);
				BigDecimal receiptMonth5=ar5.getSkQuerenMoney().add(receiptMonth4);
				receiptMonth5All=receiptMonth5All.add(ar5.getSkQuerenMoney());
				AlreadyRenling ar6=aService.selectDeptRenlingByTimeAndType(year+"-06", omName, type);
				BigDecimal receiptMonth6=ar6.getSkQuerenMoney().add(receiptMonth5);
				receiptMonth6All=receiptMonth6All.add(ar6.getSkQuerenMoney());
				AlreadyRenling ar7=aService.selectDeptRenlingByTimeAndType(year+"-07", omName, type);
				BigDecimal receiptMonth7=ar7.getSkQuerenMoney().add(receiptMonth6);
				receiptMonth7All=receiptMonth7All.add(ar7.getSkQuerenMoney());
				AlreadyRenling ar8=aService.selectDeptRenlingByTimeAndType(year+"-08", omName, type);
				BigDecimal receiptMonth8=ar8.getSkQuerenMoney().add(receiptMonth7);
				receiptMonth8All=receiptMonth8All.add(ar8.getSkQuerenMoney());
				AlreadyRenling ar9=aService.selectDeptRenlingByTimeAndType(year+"-09", omName, type);
				BigDecimal receiptMonth9=ar9.getSkQuerenMoney().add(receiptMonth8);
				receiptMonth9All=receiptMonth9All.add(ar9.getSkQuerenMoney());
				AlreadyRenling ar10=aService.selectDeptRenlingByTimeAndType(year+"-10", omName, type);
				BigDecimal receiptMonth10=ar10.getSkQuerenMoney().add(receiptMonth9);
				receiptMonth10All=receiptMonth10All.add(ar10.getSkQuerenMoney());
				AlreadyRenling ar11=aService.selectDeptRenlingByTimeAndType(year+"-11", omName, type);
				BigDecimal receiptMonth11=ar11.getSkQuerenMoney().add(receiptMonth10);
				receiptMonth11All=receiptMonth11All.add(ar11.getSkQuerenMoney());
				AlreadyRenling ar12=aService.selectDeptRenlingByTimeAndType(year+"-12", omName, type);
				BigDecimal receiptMonth12=ar12.getSkQuerenMoney().add(receiptMonth11);
				receiptMonth12All=receiptMonth12All.add(ar12.getSkQuerenMoney());
				
	
			}
			
			contractMonth2All=contractMonth2All.add(contractMonth1All);
			contractMonth3All=contractMonth3All.add(contractMonth2All);
			contractMonth4All=contractMonth4All.add(contractMonth3All);
			contractMonth5All=contractMonth5All.add(contractMonth4All);
			contractMonth6All=contractMonth6All.add(contractMonth5All);
			contractMonth7All=contractMonth7All.add(contractMonth6All);
			contractMonth8All=contractMonth8All.add(contractMonth7All);
			contractMonth9All=contractMonth9All.add(contractMonth8All);
			contractMonth10All=contractMonth10All.add(contractMonth9All);
			contractMonth11All=contractMonth11All.add(contractMonth10All);
			contractMonth12All=contractMonth12All.add(contractMonth11All);
			
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
			for(int m=12;m>=month+1;m--)
			{
				contractMoneyList.remove(m-1);
			}
			resultContract.add(contractMoneyList);
			
			inComeMonth2All=inComeMonth2All.add(inComeMonth1All);
			inComeMonth3All=inComeMonth3All.add(inComeMonth2All);
			inComeMonth4All=inComeMonth4All.add(inComeMonth3All);
			inComeMonth5All=inComeMonth5All.add(inComeMonth4All);
			inComeMonth6All=inComeMonth6All.add(inComeMonth5All);
			inComeMonth7All=inComeMonth7All.add(inComeMonth6All);
			inComeMonth8All=inComeMonth8All.add(inComeMonth7All);
			inComeMonth9All=inComeMonth9All.add(inComeMonth8All);
			inComeMonth10All=inComeMonth10All.add(inComeMonth9All);
			inComeMonth11All=inComeMonth11All.add(inComeMonth10All);
			inComeMonth12All=inComeMonth12All.add(inComeMonth11All);
			
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
			for(int m=12;m>=month+1;m--)
			{
				inComeMoneyList.remove(m-1);
			}
			resultIncome.add(inComeMoneyList);
			
			receiptMonth2All=receiptMonth2All.add(receiptMonth1All);
			receiptMonth3All=receiptMonth3All.add(receiptMonth2All);
			receiptMonth4All=receiptMonth4All.add(receiptMonth3All);
			receiptMonth5All=receiptMonth5All.add(receiptMonth4All);
			receiptMonth6All=receiptMonth6All.add(receiptMonth5All);
			receiptMonth7All=receiptMonth7All.add(receiptMonth6All);
			receiptMonth8All=receiptMonth8All.add(receiptMonth7All);
			receiptMonth9All=receiptMonth9All.add(receiptMonth8All);
			receiptMonth10All=receiptMonth10All.add(receiptMonth9All);
			receiptMonth11All=receiptMonth11All.add(receiptMonth10All);
			receiptMonth12All=receiptMonth12All.add(receiptMonth11All);
			
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
			for(int m=12;m>=month+1;m--)
			{
				receiptMoneyList.remove(m-1);
			}
			resultReceipt.add(receiptMoneyList);
			
			//公司所有累加
			gsContractMoneyMonth1All=gsContractMoneyMonth1All.add(contractMonth1All);
			gsContractMoneyMonth2All=gsContractMoneyMonth2All.add(contractMonth2All);
			gsContractMoneyMonth3All=gsContractMoneyMonth3All.add(contractMonth3All);
			gsContractMoneyMonth4All=gsContractMoneyMonth4All.add(contractMonth4All);
			gsContractMoneyMonth5All=gsContractMoneyMonth5All.add(contractMonth5All);
			gsContractMoneyMonth6All=gsContractMoneyMonth6All.add(contractMonth6All);
			gsContractMoneyMonth7All=gsContractMoneyMonth7All.add(contractMonth7All);
			gsContractMoneyMonth8All=gsContractMoneyMonth8All.add(contractMonth8All);
			gsContractMoneyMonth9All=gsContractMoneyMonth9All.add(contractMonth9All);
			gsContractMoneyMonth10All=gsContractMoneyMonth10All.add(contractMonth10All);
			gsContractMoneyMonth11All=gsContractMoneyMonth11All.add(contractMonth11All);
			gsContractMoneyMonth12All=gsContractMoneyMonth12All.add(contractMonth12All);
			
			gsIncomeMonth1All=gsIncomeMonth1All.add(inComeMonth1All);
			gsIncomeMonth2All=gsIncomeMonth2All.add(inComeMonth2All);
			gsIncomeMonth3All=gsIncomeMonth3All.add(inComeMonth3All);
			gsIncomeMonth4All=gsIncomeMonth4All.add(inComeMonth4All);
			gsIncomeMonth5All=gsIncomeMonth5All.add(inComeMonth5All);
			gsIncomeMonth6All=gsIncomeMonth6All.add(inComeMonth6All);
			gsIncomeMonth7All=gsIncomeMonth7All.add(inComeMonth7All);
			gsIncomeMonth8All=gsIncomeMonth8All.add(inComeMonth8All);
			gsIncomeMonth9All=gsIncomeMonth9All.add(inComeMonth9All);
			gsIncomeMonth10All=gsIncomeMonth10All.add(inComeMonth10All);
			gsIncomeMonth11All=gsIncomeMonth11All.add(inComeMonth11All);
			gsIncomeMonth12All=gsIncomeMonth12All.add(inComeMonth12All);
			
			gsReceiptMonth1All=gsReceiptMonth1All.add(receiptMonth1All);
			gsReceiptMonth2All=gsReceiptMonth2All.add(receiptMonth2All);
			gsReceiptMonth3All=gsReceiptMonth3All.add(receiptMonth3All);
			gsReceiptMonth4All=gsReceiptMonth4All.add(receiptMonth4All);
			gsReceiptMonth5All=gsReceiptMonth5All.add(receiptMonth5All);
			gsReceiptMonth6All=gsReceiptMonth6All.add(receiptMonth6All);
			gsReceiptMonth7All=gsReceiptMonth7All.add(receiptMonth7All);
			gsReceiptMonth8All=gsReceiptMonth8All.add(receiptMonth8All);
			gsReceiptMonth9All=gsReceiptMonth9All.add(receiptMonth9All);
			gsReceiptMonth10All=gsReceiptMonth10All.add(receiptMonth10All);
			gsReceiptMonth11All=gsReceiptMonth11All.add(receiptMonth11All);
			gsReceiptMonth12All=gsReceiptMonth12All.add(receiptMonth12All);
			
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
		for(int m=12;m>=month+1;m--)
		{
			gsContractMoney.remove(m-1);
		}
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
		for(int m=12;m>=month+1;m--)
		{
			gsIncome.remove(m-1);
		}
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
		for(int m=12;m>=month+1;m--)
		{
			gsReceipt.remove(m-1);
		}
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
		List<List<BigDecimal>> resultContract=new ArrayList<>();//实际年部门新签合同额按项目类型
		List<List<BigDecimal>> resultIncome=new ArrayList<>();//实际年部门累计收入按项目类型
		List<List<BigDecimal>> resultReceipt=new ArrayList<>();//实际年部门累计收款按项目类型
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
		List<BigDecimal> gsContractMoney=new ArrayList<>();
		BigDecimal gsContractYear1All=new BigDecimal(0);
		BigDecimal gsContractYear2All=new BigDecimal(0);
		BigDecimal gsContractYear3All=new BigDecimal(0);
		
		List<BigDecimal> gsIncome=new ArrayList<>();
		BigDecimal gsIncomeYear1All=new BigDecimal(0);
		BigDecimal gsIncomeYear2All=new BigDecimal(0);
		BigDecimal gsIncomeYear3All=new BigDecimal(0);
		
		List<BigDecimal> gsReceipt=new ArrayList<>();
		BigDecimal gsReceiptYear1All=new BigDecimal(0);
		BigDecimal gsReceiptYear2All=new BigDecimal(0);
		BigDecimal gsReceiptYear3All=new BigDecimal(0);
		for(int o=0;o<om.size();o++){
			String omId=om.get(o).getOmId();
			String omName=om.get(o).getOmName();
			omList.add(omName);
			
			//部门新签合同额按项目类型
			List<BigDecimal> contractMoneyList=new ArrayList<>();
			BigDecimal contractYear1All=new BigDecimal(0);
			BigDecimal contractYear2All=new BigDecimal(0);
			BigDecimal contractYear3All=new BigDecimal(0);
			//部门累计收入按项目类型
			List<BigDecimal> inComeMoneyList=new ArrayList<>();
			BigDecimal inComeYear1All=new BigDecimal(0);
			BigDecimal inComeYear2All=new BigDecimal(0);
			BigDecimal inComeYear3All=new BigDecimal(0);
			//部门累计收款按项目类型
			List<BigDecimal> receiptMoneyList=new ArrayList<>();
			BigDecimal receiptYear1All=new BigDecimal(0);
			BigDecimal receiptYear2All=new BigDecimal(0);
			BigDecimal receiptYear3All=new BigDecimal(0);
			for(int i=0;i<prjType.split(",").length;i++){
				String type=prjType.split(",")[i];
				//部门新签合同额按项目类型
				ContractUpdate cu=cuService.selectDeptContractMoneyByTimeAndType(year3, omId, type);
				BigDecimal contractMonth1=cu.getMoney();
				contractYear1All=contractYear1All.add(contractMonth1);
				ContractUpdate cu2=cuService.selectDeptContractMoneyByTimeAndType(year2, omId, type);
				BigDecimal contractMonth2=cu2.getMoney();
				contractYear2All=contractYear2All.add(contractMonth2);
				ContractUpdate cu3=cuService.selectDeptContractMoneyByTimeAndType(year, omId, type);
				BigDecimal contractMonth3=cu3.getMoney();
				contractYear3All=contractYear3All.add(contractMonth3);
				
				
				//部门累计收入按项目类型
				PrjProgressFill ppf=pService.selectDeptIncomeByTimeAndType(year3, omName, type);
				BigDecimal inComeMonth1=ppf.getAllMoneyYuan();
				inComeYear1All=inComeYear1All.add(inComeMonth1);
				PrjProgressFill ppf2=pService.selectDeptIncomeByTimeAndType(year2, omName, type);
				BigDecimal inComeMonth2=ppf2.getAllMoneyYuan();
				inComeYear2All=inComeYear2All.add(inComeMonth2);
				PrjProgressFill ppf3=pService.selectDeptIncomeByTimeAndType(year, omName, type);
				BigDecimal inComeMonth3=ppf3.getAllMoneyYuan();
				inComeYear3All=inComeYear3All.add(inComeMonth3);
				
				//部门累计收款按项目类型
				AlreadyRenling ar=aService.selectDeptRenlingByTimeAndType(year3, omName, type);
				BigDecimal receiptMonth1=ar.getSkQuerenMoney();
				receiptYear1All=receiptYear1All.add(receiptMonth1);
				AlreadyRenling ar2=aService.selectDeptRenlingByTimeAndType(year2, omName, type);
				BigDecimal receiptMonth2=ar2.getSkQuerenMoney();
				receiptYear2All=receiptYear2All.add(receiptMonth2);
				AlreadyRenling ar3=aService.selectDeptRenlingByTimeAndType(year, omName, type);
				BigDecimal receiptMonth3=ar3.getSkQuerenMoney();
				receiptYear3All=receiptYear3All.add(receiptMonth3);
				
			}
			//公司所有累加
			gsContractYear1All=gsContractYear1All.add(contractYear1All);
			gsContractYear2All=gsContractYear2All.add(contractYear2All);
			gsContractYear3All=gsContractYear3All.add(contractYear3All);
			
			gsIncomeYear1All=gsIncomeYear1All.add(inComeYear1All);
			gsIncomeYear2All=gsIncomeYear2All.add(inComeYear2All);
			gsIncomeYear3All=gsIncomeYear3All.add(inComeYear3All);
			
			gsReceiptYear1All=gsReceiptYear1All.add(receiptYear1All);
			gsReceiptYear2All=gsReceiptYear2All.add(receiptYear2All);
			gsReceiptYear3All=gsReceiptYear3All.add(receiptYear3All);
			
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
		List<List<BigDecimal>> resultList=new ArrayList<>();
		List<List<BigDecimal>> mbList=new ArrayList<>();
		List<String> omList=new ArrayList<>();
		//获取月份
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		
		omList.add("公司");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		List<OrganizationManagement> om=omService.selectProductionDepartment();//生产部门列表
		List<BigDecimal> resultAll=new ArrayList<>();
		List<BigDecimal> mbAll=new ArrayList<>();
		BigDecimal month1All=new BigDecimal(0);
		BigDecimal month2All=new BigDecimal(0);
		BigDecimal month3All=new BigDecimal(0);
		BigDecimal month4All=new BigDecimal(0);
		BigDecimal month5All=new BigDecimal(0);
		BigDecimal month6All=new BigDecimal(0);
		BigDecimal month7All=new BigDecimal(0);
		BigDecimal month8All=new BigDecimal(0);
		BigDecimal month9All=new BigDecimal(0);
		BigDecimal month10All=new BigDecimal(0);
		BigDecimal month11All=new BigDecimal(0);
		BigDecimal month12All=new BigDecimal(0);

		for(int i=0;i<om.size();i++){
			List<BigDecimal> result=new ArrayList<>();
			List<BigDecimal> mb=new ArrayList<>();
			String omId=om.get(i).getOmId();//部门编号
			String omName=om.get(i).getOmName();//部门名称
			omList.add(omName);
			
			ContractUpdate cu=cuService.selectDeptContractMoneyByTime(year+"-01", omId);
			BigDecimal month1=cu.getMoney();//部门1份月合同额
			month1All=month1All.add(month1);
			
			ContractUpdate cu2=cuService.selectDeptContractMoneyByTime(year+"-02", omId);
			BigDecimal month2=cu2.getMoney().add(month1);//部门2份月合同额
			month2All=month2All.add(cu2.getMoney());

			ContractUpdate cu3=cuService.selectDeptContractMoneyByTime(year+"-03", omId);
			BigDecimal month3=cu3.getMoney().add(month2);//部门3份月合同额
			month3All=month3All.add(cu3.getMoney());
			
			ContractUpdate cu4=cuService.selectDeptContractMoneyByTime(year+"-04", omId);
			BigDecimal month4=cu4.getMoney().add(month3);//部门4份月合同额
			month4All=month4All.add(cu4.getMoney());
			
			ContractUpdate cu5=cuService.selectDeptContractMoneyByTime(year+"-05", omId);
			BigDecimal month5=cu5.getMoney().add(month4);//部门5份月合同额
			month5All=month5All.add(cu5.getMoney());
			
			ContractUpdate cu6=cuService.selectDeptContractMoneyByTime(year+"-06", omId);
			BigDecimal month6=cu6.getMoney().add(month5);//部门6份月合同额
			month6All=month6All.add(cu6.getMoney());
			
			ContractUpdate cu7=cuService.selectDeptContractMoneyByTime(year+"-07", omId);
			BigDecimal month7=cu7.getMoney().add(month6);//部门7份月合同额
			month7All=month7All.add(cu7.getMoney());
			
			ContractUpdate cu8=cuService.selectDeptContractMoneyByTime(year+"-08", omId);
			BigDecimal month8=cu8.getMoney().add(month7);//部门8份月合同额
			month8All=month8All.add(cu8.getMoney());
			
			ContractUpdate cu9=cuService.selectDeptContractMoneyByTime(year+"-09", omId);
			BigDecimal month9=cu9.getMoney().add(month8);//部门9份月合同额
			month9All=month9All.add(cu9.getMoney());
			
			ContractUpdate cu10=cuService.selectDeptContractMoneyByTime(year+"-10", omId);
			BigDecimal month10=cu10.getMoney().add(month9);//部门10份月合同额
			month10All=month10All.add(cu10.getMoney());
			
			ContractUpdate cu11=cuService.selectDeptContractMoneyByTime(year+"-11", omId);
			BigDecimal month11=cu11.getMoney().add(month10);//部门11份月合同额
			month11All=month11All.add(cu11.getMoney());
	
			ContractUpdate cu12=cuService.selectDeptContractMoneyByTime(year+"-12", omId);
			BigDecimal month12=cu12.getMoney().add(month11);//部门12份月合同额
			month12All=month12All.add(cu12.getMoney());
			
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
			for(int m=12;m>=month+1;m--)
			{
				result.remove(m-1);
			}
			resultList.add(result);
			
//			List<MonthTarget> mt=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 1, omId);
//			BigDecimal mbMonth1=getMbContractMoney(mt);
//			mbMonth1All=mbMonth1All+mbMonth1;
//			
//			List<MonthTarget> mt2=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 2, omId);
//			BigDecimal mbMonth2=getMbContractMoney(mt2);
//			mbMonth2All=mbMonth1All+mbMonth2;
//			
//			List<MonthTarget> mt3=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 3, omId);
//			BigDecimal mbMonth3=getMbContractMoney(mt3);
//			mbMonth3All=mbMonth2All+mbMonth3;
//			
//			List<MonthTarget> mt4=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 4, omId);
//			BigDecimal mbMonth4=getMbContractMoney(mt4);
//			mbMonth4All=mbMonth3All+mbMonth4;
//			
//			List<MonthTarget> mt5=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 5, omId);
//			BigDecimal mbMonth5=getMbContractMoney(mt5);
//			mbMonth5All=mbMonth4All+mbMonth5;
//			
//			List<MonthTarget> mt6=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 6, omId);
//			BigDecimal mbMonth6=getMbContractMoney(mt6);
//			mbMonth6All=mbMonth5All+mbMonth6;
//			
//			List<MonthTarget> mt7=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 7, omId);
//			BigDecimal mbMonth7=getMbContractMoney(mt7);
//			mbMonth7All=mbMonth6All+mbMonth7;
//			
//			List<MonthTarget> mt8=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 8, omId);
//			BigDecimal mbMonth8=getMbContractMoney(mt8);
//			mbMonth8All=mbMonth7All+mbMonth8;
//			
//			List<MonthTarget> mt9=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 9, omId);
//			BigDecimal mbMonth9=getMbContractMoney(mt9);
//			mbMonth9All=mbMonth8All+mbMonth9;
//			
//			List<MonthTarget> mt10=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 10, omId);
//			BigDecimal mbMonth10=getMbContractMoney(mt10);
//			mbMonth10All=mbMonth9All+mbMonth10;
//			
//			List<MonthTarget> mt11=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 11, omId);
//			BigDecimal mbMonth11=getMbContractMoney(mt11);
//			mbMonth11All=mbMonth10All+mbMonth11;
//			
//			List<MonthTarget> mt12=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 12, omId);
//			BigDecimal mbMonth12=getMbContractMoney(mt12);
//			mbMonth12All=mbMonth11All+mbMonth12;
			
			DepartmentTarget dt =  dtservice.selectDepartmentTargetByYearAndOmId(year, omId);
			//部门新签合同额当年目标
			BigDecimal mbdouble =new BigDecimal(0.00);
			if(dt!=null){
				mbdouble=dt.getContractAmount();
			}
			for(int k=0;k<12;k++)
			{
				mb.add(mbdouble);
			}
			mbList.add(mb);
		}
		month2All=month2All.add(month1All);
		month3All=month3All.add(month2All);
		month4All=month4All.add(month3All);
		month5All=month5All.add(month4All);
		month6All=month6All.add(month5All);
		month7All=month7All.add(month6All);
		month8All=month8All.add(month7All);
		month9All=month9All.add(month8All);
		month10All=month10All.add(month9All);
		month11All=month11All.add(month10All);
		month12All=month12All.add(month11All);
		
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
		for(int m=12;m>=month+1;m--)
		{
			resultAll.remove(m-1);
		}
		
		OperationTarget ot=oservice.selectOperationTargetByYear(year);
		BigDecimal mbdouble = new BigDecimal(0.00);
		//BigDecimal mbdouble = 0.00;
		if(ot!=null){
			
			mbdouble=ot.getContractAmount();
		}
		for(int k=0;k<12;k++)
		{
			mbAll.add(mbdouble);
		}
		
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
		List<List<BigDecimal>> resultList=new ArrayList<>();
		List<List<BigDecimal>> mbList=new ArrayList<>();
		List<String> omList=new ArrayList<>();
		//获取月份
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		omList.add("公司");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		List<OrganizationManagement> om=omService.selectProductionDepartment();//生产部门列表
		List<BigDecimal> resultAll=new ArrayList<>();
		List<BigDecimal> mbAll=new ArrayList<>();
		BigDecimal month1All=new BigDecimal(0);
		BigDecimal month2All=new BigDecimal(0);
		BigDecimal month3All=new BigDecimal(0);
		BigDecimal month4All=new BigDecimal(0);
		BigDecimal month5All=new BigDecimal(0);
		BigDecimal month6All=new BigDecimal(0);
		BigDecimal month7All=new BigDecimal(0);
		BigDecimal month8All=new BigDecimal(0);
		BigDecimal month9All=new BigDecimal(0);
		BigDecimal month10All=new BigDecimal(0);
		BigDecimal month11All=new BigDecimal(0);
		BigDecimal month12All=new BigDecimal(0);

		for(int i=0;i<om.size();i++){
			List<BigDecimal> result=new ArrayList<>();
			List<BigDecimal> mb=new ArrayList<>();
			String omName=om.get(i).getOmName();
			String omId=om.get(i).getOmId();
			omList.add(omName);
			PrjProgressFill ppf=pService.selectGsIncomeByTimeAndDept(year+"-01", omName);
			month1All=month1All.add(ppf.getAllMoneyYuan());
			BigDecimal ppfmonth1=ppf.getAllMoneyYuan();
			
			PrjProgressFill ppf2=pService.selectGsIncomeByTimeAndDept(year+"-02", omName);
			month2All=month2All.add(ppf2.getAllMoneyYuan());
			BigDecimal ppfmonth2=ppf2.getAllMoneyYuan().add(ppfmonth1);
			
			PrjProgressFill ppf3=pService.selectGsIncomeByTimeAndDept(year+"-03", omName);
			month3All=month3All.add(ppf3.getAllMoneyYuan());
			BigDecimal ppfmonth3=ppf3.getAllMoneyYuan().add(ppfmonth2);
			
			PrjProgressFill ppf4=pService.selectGsIncomeByTimeAndDept(year+"-04", omName);
			month4All=month4All.add(ppf4.getAllMoneyYuan());
			BigDecimal ppfmonth4=ppf4.getAllMoneyYuan().add(ppfmonth3);
			
			PrjProgressFill ppf5=pService.selectGsIncomeByTimeAndDept(year+"-05", omName);
			month5All=month5All.add(ppf5.getAllMoneyYuan());
			BigDecimal ppfmonth5=ppf5.getAllMoneyYuan().add(ppfmonth4);
			
			PrjProgressFill ppf6=pService.selectGsIncomeByTimeAndDept(year+"-06", omName);
			month6All=month6All.add(ppf6.getAllMoneyYuan());
			BigDecimal ppfmonth6=ppf6.getAllMoneyYuan().add(ppfmonth5);
			
			PrjProgressFill ppf7=pService.selectGsIncomeByTimeAndDept(year+"-07", omName);
			month7All=month7All.add(ppf7.getAllMoneyYuan());
			BigDecimal ppfmonth7=ppf7.getAllMoneyYuan().add(ppfmonth6);
			
			PrjProgressFill ppf8=pService.selectGsIncomeByTimeAndDept(year+"-08", omName);
			month8All=month8All.add(ppf8.getAllMoneyYuan());
			BigDecimal ppfmonth8=ppf8.getAllMoneyYuan().add(ppfmonth7);
			
			PrjProgressFill ppf9=pService.selectGsIncomeByTimeAndDept(year+"-09", omName);
			month9All=month9All.add(ppf9.getAllMoneyYuan());
			BigDecimal ppfmonth9=ppf9.getAllMoneyYuan().add(ppfmonth8);
			
			PrjProgressFill ppf10=pService.selectGsIncomeByTimeAndDept(year+"-10", omName);
			month10All=month10All.add(ppf10.getAllMoneyYuan());
			BigDecimal ppfmonth10=ppf10.getAllMoneyYuan().add(ppfmonth9);
			
			PrjProgressFill ppf11=pService.selectGsIncomeByTimeAndDept(year+"-11", omName);
			month11All=month11All.add(ppf11.getAllMoneyYuan());
			BigDecimal ppfmonth11=ppf11.getAllMoneyYuan().add(ppfmonth10);
			
			PrjProgressFill ppf12=pService.selectGsIncomeByTimeAndDept(year+"-12", omName);
			month12All=month12All.add(ppf12.getAllMoneyYuan());
			BigDecimal ppfmonth12=ppf12.getAllMoneyYuan().add(ppfmonth11);
			
			result.add(ppfmonth1);
			result.add(ppfmonth2);
			result.add(ppfmonth3);
			result.add(ppfmonth4);
			result.add(ppfmonth5);
			result.add(ppfmonth6);
			result.add(ppfmonth7);
			result.add(ppfmonth8);
			result.add(ppfmonth9);
			result.add(ppfmonth10);
			result.add(ppfmonth11);
			result.add(ppfmonth12);
			for(int m=12;m>=month+1;m--)
			{
				result.remove(m-1);
			}
			resultList.add(result);
			
//			List<MonthTarget> mt=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 1, omId);
//			BigDecimal mbMonth1=getMbIncome(mt);
//			mbMonth1All=mbMonth1All+mbMonth1;
//			
//			List<MonthTarget> mt2=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 2, omId);
//			BigDecimal mbMonth2=getMbIncome(mt2);
//			mbMonth2All=mbMonth2All+mbMonth2;
//			
//			List<MonthTarget> mt3=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 3, omId);
//			BigDecimal mbMonth3=getMbIncome(mt3);
//			mbMonth3All=mbMonth3All+mbMonth3;
//			
//			List<MonthTarget> mt4=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 4, omId);
//			BigDecimal mbMonth4=getMbIncome(mt4);
//			mbMonth4All=mbMonth4All+mbMonth4;
//			
//			List<MonthTarget> mt5=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 5, omId);
//			BigDecimal mbMonth5=getMbIncome(mt5);
//			mbMonth5All=mbMonth5All+mbMonth5;
//			
//			List<MonthTarget> mt6=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 6, omId);
//			BigDecimal mbMonth6=getMbIncome(mt6);
//			mbMonth6All=mbMonth6All+mbMonth6;
//			
//			List<MonthTarget> mt7=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 7, omId);
//			BigDecimal mbMonth7=getMbIncome(mt7);
//			mbMonth7All=mbMonth7All+mbMonth7;
//			
//			List<MonthTarget> mt8=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 8, omId);
//			BigDecimal mbMonth8=getMbIncome(mt8);
//			mbMonth8All=mbMonth8All+mbMonth8;
//			
//			List<MonthTarget> mt9=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 9, omId);
//			BigDecimal mbMonth9=getMbIncome(mt9);
//			mbMonth9All=mbMonth9All+mbMonth9;
//			
//			List<MonthTarget> mt10=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 10, omId);
//			BigDecimal mbMonth10=getMbIncome(mt10);
//			mbMonth10All=mbMonth10All+mbMonth10;
//			
//			List<MonthTarget> mt11=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 11, omId);
//			BigDecimal mbMonth11=getMbIncome(mt11);
//			mbMonth11All=mbMonth11All+mbMonth11;
//			
//			List<MonthTarget> mt12=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 12, omId);
//			BigDecimal mbMonth12=getMbIncome(mt12);
//			mbMonth12All=mbMonth12All+mbMonth12;
			
			DepartmentTarget dt =  dtservice.selectDepartmentTargetByYearAndOmId(year, omId);
			//部门新签合同额当年目标
			BigDecimal mbdouble =new BigDecimal(0.00);
			if(dt!=null){
				mbdouble=dt.getRevenueTarget();
			}
			for(int k=0;k<12;k++)
			{
				mb.add(mbdouble);
			}
			mbList.add(mb);
		}
		month2All=month2All.add(month1All);
		month3All=month3All.add(month2All);
		month4All=month4All.add(month3All);
		month5All=month5All.add(month4All);
		month6All=month6All.add(month5All);
		month7All=month7All.add(month6All);
		month8All=month8All.add(month7All);
		month9All=month9All.add(month8All);
		month10All=month10All.add(month9All);
		month11All=month11All.add(month10All);
		month12All=month12All.add(month11All);
		
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
		for(int m=12;m>=month+1;m--)
		{
			resultAll.remove(m-1);
		}
		
		
		OperationTarget ot=oservice.selectOperationTargetByYear(year);
		BigDecimal mbdouble =new BigDecimal(0.00);
		if(ot!=null){
			mbdouble=ot.getRevenueTarget();
		}
		for(int k=0;k<12;k++)
		{
			mbAll.add(mbdouble);
		}
		
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
		List<List<BigDecimal>> resultList=new ArrayList<>();
		List<List<BigDecimal>> mbList=new ArrayList<>();
		List<String> omList=new ArrayList<>();
		//获取月份
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		omList.add("公司");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		List<OrganizationManagement> om=omService.selectProductionDepartment();//生产部门列表
		List<BigDecimal> resultAll=new ArrayList<>();
		List<BigDecimal> mbAll=new ArrayList<>();
		BigDecimal month1All=new BigDecimal(0);
		BigDecimal month2All=new BigDecimal(0);
		BigDecimal month3All=new BigDecimal(0);
		BigDecimal month4All=new BigDecimal(0);
		BigDecimal month5All=new BigDecimal(0);
		BigDecimal month6All=new BigDecimal(0);
		BigDecimal month7All=new BigDecimal(0);
		BigDecimal month8All=new BigDecimal(0);
		BigDecimal month9All=new BigDecimal(0);
		BigDecimal month10All=new BigDecimal(0);
		BigDecimal month11All=new BigDecimal(0);
		BigDecimal month12All=new BigDecimal(0);

		
		for(int i=0;i<om.size();i++){
			List<BigDecimal> result=new ArrayList<>();
			List<BigDecimal> mb=new ArrayList<>();
			String omName=om.get(i).getOmName();
			String omId=om.get(i).getOmId();
			omList.add(omName);
			
			AlreadyRenling ar=aService.selectDeptRenlingByTime(year+"-01", omName);
			month1All=month1All.add(ar.getSkQuerenMoney());
			BigDecimal Month1=ar.getSkQuerenMoney();
			
			AlreadyRenling ar2=aService.selectDeptRenlingByTime(year+"-02", omName);
			month2All=month2All.add(ar2.getSkQuerenMoney());
			BigDecimal Month2=ar2.getSkQuerenMoney().add(Month1);
			
			AlreadyRenling ar3=aService.selectDeptRenlingByTime(year+"-03", omName);
			month3All=month3All.add(ar3.getSkQuerenMoney());
			BigDecimal Month3=ar3.getSkQuerenMoney().add(Month2);
			
			AlreadyRenling ar4=aService.selectDeptRenlingByTime(year+"-04", omName);
			month4All=month4All.add(ar4.getSkQuerenMoney());
			BigDecimal Month4=ar4.getSkQuerenMoney().add(Month3);
			
			AlreadyRenling ar5=aService.selectDeptRenlingByTime(year+"-05", omName);
			month5All=month5All.add(ar5.getSkQuerenMoney());
			BigDecimal Month5=ar5.getSkQuerenMoney().add(Month4);
			
			AlreadyRenling ar6=aService.selectDeptRenlingByTime(year+"-06", omName);
			month6All=month6All.add(ar6.getSkQuerenMoney());
			BigDecimal Month6=ar6.getSkQuerenMoney().add(Month5);
			
			AlreadyRenling ar7=aService.selectDeptRenlingByTime(year+"-07", omName);
			month7All=month7All.add(ar7.getSkQuerenMoney());
			BigDecimal Month7=ar7.getSkQuerenMoney().add(Month6);
			
			AlreadyRenling ar8=aService.selectDeptRenlingByTime(year+"-08", omName);
			month8All=month8All.add(ar8.getSkQuerenMoney());
			BigDecimal Month8=ar8.getSkQuerenMoney().add(Month7);
			
			AlreadyRenling ar9=aService.selectDeptRenlingByTime(year+"-09", omName);
			month9All=month9All.add(ar9.getSkQuerenMoney());
			BigDecimal Month9=ar9.getSkQuerenMoney().add(Month8);
			
			AlreadyRenling ar10=aService.selectDeptRenlingByTime(year+"-10", omName);
			month10All=month10All.add(ar10.getSkQuerenMoney());
			BigDecimal Month10=ar10.getSkQuerenMoney().add(Month9);
			
			AlreadyRenling ar11=aService.selectDeptRenlingByTime(year+"-11", omName);
			month11All=month11All.add(ar11.getSkQuerenMoney());
			BigDecimal Month11=ar11.getSkQuerenMoney().add(Month10);
			
			AlreadyRenling ar12=aService.selectDeptRenlingByTime(year+"-12", omName);
			month12All=month12All.add(ar12.getSkQuerenMoney());
			BigDecimal Month12=ar12.getSkQuerenMoney().add(Month11);
			
			result.add(Month1);
			result.add(Month2);
			result.add(Month3);
			result.add(Month4);
			result.add(Month5);
			result.add(Month6);
			result.add(Month7);
			result.add(Month8);
			result.add(Month9);
			result.add(Month10);
			result.add(Month11);
			result.add(Month12);
			for(int m=12;m>=month+1;m--)
			{
				result.remove(m-1);
			}
			resultList.add(result);
			
//			List<MonthTarget> mt=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 1, omId);
//			BigDecimal mbMonth1=getMbReceipt(mt);
//			mbMonth1All=mbMonth1All+mbMonth1;
//			
//			List<MonthTarget> mt2=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 2, omId);
//			BigDecimal mbMonth2=getMbReceipt(mt2);
//			mbMonth2All=mbMonth2All+mbMonth2;
//			
//			List<MonthTarget> mt3=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 3, omId);
//			BigDecimal mbMonth3=getMbReceipt(mt3);
//			mbMonth3All=mbMonth3All+mbMonth3;
//			
//			List<MonthTarget> mt4=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 4, omId);
//			BigDecimal mbMonth4=getMbReceipt(mt4);
//			mbMonth4All=mbMonth4All+mbMonth4;
//			
//			List<MonthTarget> mt5=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 5, omId);
//			BigDecimal mbMonth5=getMbReceipt(mt5);
//			mbMonth5All=mbMonth5All+mbMonth5;
//			
//			List<MonthTarget> mt6=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 6, omId);
//			BigDecimal mbMonth6=getMbReceipt(mt6);
//			mbMonth6All=mbMonth6All+mbMonth6;
//			
//			List<MonthTarget> mt7=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 7, omId);
//			BigDecimal mbMonth7=getMbReceipt(mt7);
//			mbMonth7All=mbMonth7All+mbMonth7;
//			
//			List<MonthTarget> mt8=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 8, omId);
//			BigDecimal mbMonth8=getMbReceipt(mt8);
//			mbMonth8All=mbMonth8All+mbMonth8;
//			
//			List<MonthTarget> mt9=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 9, omId);
//			BigDecimal mbMonth9=getMbReceipt(mt9);
//			mbMonth9All=mbMonth9All+mbMonth9;
//			
//			List<MonthTarget> mt10=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 10, omId);
//			BigDecimal mbMonth10=getMbReceipt(mt10);
//			mbMonth10All=mbMonth10All+mbMonth10;
//			
//			List<MonthTarget> mt11=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 11, omId);
//			BigDecimal mbMonth11=getMbReceipt(mt11);
//			mbMonth11All=mbMonth11All+mbMonth11;
//			
//			List<MonthTarget> mt12=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 12, omId);
//			BigDecimal mbMonth12=getMbReceipt(mt12);
//			mbMonth12All=mbMonth12All+mbMonth12;
			
			DepartmentTarget dt =  dtservice.selectDepartmentTargetByYearAndOmId(year, omId);
			//部门新签合同额当年目标
			BigDecimal mbdouble =new BigDecimal(0.00);
			if(dt!=null){
				mbdouble=dt.getCollectionTarget();
			}
			for(int k=0;k<12;k++)
			{
				mb.add(mbdouble);
			}
			mbList.add(mb);		
		}
		month2All=month2All.add(month1All);
		month3All=month3All.add(month2All);
		month4All=month4All.add(month3All);
		month5All=month5All.add(month4All);
		month6All=month6All.add(month5All);
		month7All=month7All.add(month6All);
		month8All=month8All.add(month7All);
		month9All=month9All.add(month8All);
		month10All=month10All.add(month9All);
		month11All=month11All.add(month10All);
		month12All=month12All.add(month11All);
		
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
		for(int m=12;m>=month+1;m--)
		{
			resultAll.remove(m-1);
		}
		
		OperationTarget ot=oservice.selectOperationTargetByYear(year);
		BigDecimal mbdouble = new BigDecimal(0.00);
		if(ot!=null){
			mbdouble=ot.getCollectionTarget();
		}
		for(int k=0;k<12;k++)
		{
			mbAll.add(mbdouble);
		}
		
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
		List<List<BigDecimal>> resultList=new ArrayList<>();
		List<List<BigDecimal>> mbList=new ArrayList<>();
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
		
		List<BigDecimal> resultAll=new ArrayList<>();
		List<BigDecimal> mbAll=new ArrayList<>();
		BigDecimal month1All=new BigDecimal(0);
		BigDecimal month2All=new BigDecimal(0);
		BigDecimal month3All=new BigDecimal(0);
		
		BigDecimal mbMonth1All=new BigDecimal(0);
		BigDecimal mbMonth2All=new BigDecimal(0);
		BigDecimal mbMonth3All=new BigDecimal(0);
		
		//获取公司各种金额
		String resultGs=oservice.selectGsOperationTargetByTime(year3+"");
		JSONObject jsonObject=JSONObject.parseObject(resultGs);
		OperationTarget ot=(OperationTarget)JSONObject.toJavaObject(jsonObject, OperationTarget.class);
		month1All=ot.getXqhte();//部门前年合同额
		
		//获取公司各种金额
		resultGs=oservice.selectGsOperationTargetByTime(year2+"");
		jsonObject=JSONObject.parseObject(resultGs);
		ot=(OperationTarget)JSONObject.toJavaObject(jsonObject, OperationTarget.class);
		month2All=ot.getXqhte();//部门去年合同额
		
		//获取公司各种金额
		resultGs=oservice.selectGsOperationTargetByTime(year+"");
		jsonObject=JSONObject.parseObject(resultGs);
		ot=(OperationTarget)JSONObject.toJavaObject(jsonObject, OperationTarget.class);
		month3All=ot.getXqhte();//部门今年合同额
		
		for(int i=0;i<om.size();i++){
			List<BigDecimal> result=new ArrayList<>();
			List<BigDecimal> mb=new ArrayList<>();
			
			String omId=om.get(i).getOmId();//部门编号
			String omName=om.get(i).getOmName();//部门名称
			omList.add(omName);
			
			//获取部门每年的金额
			String resultBm=oservice.selectBmOperationTargetByTime(year3);
			List<DepartmentTarget> dtList=(List<DepartmentTarget>)JSONArray.toJavaObject(JSONArray.parseObject(resultBm), DepartmentTarget.class);
			for(int k=0;k<dtList.size();k++)
			{
				if(dtList.get(k).getBmmc().equals(omName)) {
					result.add(dtList.get(k).getXqhte());
					break;
				}
			}
			
			resultBm=oservice.selectBmOperationTargetByTime(year2);
			dtList=(List<DepartmentTarget>)JSONArray.toJavaObject(JSONArray.parseObject(resultBm), DepartmentTarget.class);
			for(int k=0;k<dtList.size();k++)
			{
				if(dtList.get(k).getBmmc().equals(omName)) {
					result.add(dtList.get(k).getXqhte());
					break;
				}
			}
			
			resultBm=oservice.selectBmOperationTargetByTime(year);
			dtList=(List<DepartmentTarget>)JSONArray.toJavaObject(JSONArray.parseObject(resultBm), DepartmentTarget.class);
			for(int k=0;k<dtList.size();k++)
			{
				if(dtList.get(k).getBmmc().equals(omName)) {
					result.add(dtList.get(k).getXqhte());
					break;
				}
			}
			
			resultList.add(result);
			
			DepartmentTarget mt=dtservice.selectDepartmentTargetByYearAndOmId(year3, omId);
			BigDecimal mbMonth1=new BigDecimal(0);
			if(mt!=null){
				mbMonth1=mt.getContractAmount();
			}
			mbMonth1All=mbMonth1All.add(mbMonth1);
			
			DepartmentTarget mt2=dtservice.selectDepartmentTargetByYearAndOmId(year2, omId);
			BigDecimal mbMonth2=new BigDecimal(0);
			if(mt2!=null){
				mbMonth2=mt2.getContractAmount();
			}
			mbMonth2All=mbMonth2All.add(mbMonth2);
			
			DepartmentTarget mt3=dtservice.selectDepartmentTargetByYearAndOmId(year, omId);
			BigDecimal mbMonth3=new BigDecimal(0);
			if(mt3!=null){
				 mbMonth3=mt3.getContractAmount();
			}
			mbMonth3All=mbMonth3All.add(mbMonth3);
			
			
			mb.add(mbMonth1);
			mb.add(mbMonth2);
			mb.add(mbMonth3);
			mbList.add(mb);
		}
		resultAll.add(month1All);
		resultAll.add(month2All);
		resultAll.add(month3All);
		
		//获取公司各个目标
		OperationTarget ot3=oservice.selectOperationTargetByYear(year3+"");
		if(null!=ot3) {
			mbAll.add(ot3.getContractAmount());
		}else
		{
			mbAll.add(new BigDecimal(0.0));
		}
		OperationTarget ot2=oservice.selectOperationTargetByYear(year2+"");
		if(null!=ot2) {
			mbAll.add(ot2.getContractAmount());
		}else
		{
			mbAll.add(new BigDecimal(0.0));
		}
		OperationTarget ot1=oservice.selectOperationTargetByYear(year+"");
		if(null!=ot1) {
			mbAll.add(ot1.getContractAmount());
		}else
		{
			mbAll.add(new BigDecimal(0.0));
		}
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
		List<List<BigDecimal>> resultList=new ArrayList<>();
		List<List<BigDecimal>> mbList=new ArrayList<>();
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
		List<BigDecimal> resultAll=new ArrayList<>();
		List<BigDecimal> mbAll=new ArrayList<>();
		BigDecimal month1All=new BigDecimal(0);
		BigDecimal month2All=new BigDecimal(0);
		BigDecimal month3All=new BigDecimal(0);
		

		
		//获取公司各种金额
		String resultGs=oservice.selectGsOperationTargetByTime(year3+"");
		JSONObject jsonObject=JSONObject.parseObject(resultGs);
		OperationTarget ot=(OperationTarget)JSONObject.toJavaObject(jsonObject, OperationTarget.class);
		month1All=ot.getSr();//部门前年合同额
		
		//获取公司各种金额
		resultGs=oservice.selectGsOperationTargetByTime(year2+"");
		jsonObject=JSONObject.parseObject(resultGs);
		ot=(OperationTarget)JSONObject.toJavaObject(jsonObject, OperationTarget.class);
		month2All=ot.getSr();//部门去年合同额
		
		//获取公司各种金额
		resultGs=oservice.selectGsOperationTargetByTime(year+"");
		jsonObject=JSONObject.parseObject(resultGs);
		ot=(OperationTarget)JSONObject.toJavaObject(jsonObject, OperationTarget.class);
		month3All=ot.getSr();//部门今年合同额
	
		for(int i=0;i<om.size();i++){
			List<BigDecimal> result=new ArrayList<>();
			List<BigDecimal> mb=new ArrayList<>();
			String omName=om.get(i).getOmName();
			String omId=om.get(i).getOmId();
			omList.add(omName);
			
			//获取部门每年的金额
			String resultBm=oservice.selectBmOperationTargetByTime(year3);
			List<DepartmentTarget> dtList=(List<DepartmentTarget>)JSONArray.toJavaObject(JSONArray.parseObject(resultBm), DepartmentTarget.class);
			for(int k=0;k<dtList.size();k++)
			{
				if(dtList.get(k).getBmmc().equals(omName)) {
					result.add(dtList.get(k).getSr());
					break;
				}
			}
			
			//获取部门每年的金额
			resultBm=oservice.selectBmOperationTargetByTime(year2);
			dtList=(List<DepartmentTarget>)JSONArray.toJavaObject(JSONArray.parseObject(resultBm), DepartmentTarget.class);
			for(int k=0;k<dtList.size();k++)
			{
				if(dtList.get(k).getBmmc().equals(omName)) {
					result.add(dtList.get(k).getSr());
					break;
				}
			}
			
			//获取部门每年的金额
			resultBm=oservice.selectBmOperationTargetByTime(year);
			dtList=(List<DepartmentTarget>)JSONArray.toJavaObject(JSONArray.parseObject(resultBm), DepartmentTarget.class);
			for(int k=0;k<dtList.size();k++)
			{
				if(dtList.get(k).getBmmc().equals(omName)) {
					result.add(dtList.get(k).getSr());
					break;
				}
			}
			
			resultList.add(result);
			
			//部门目标
			DepartmentTarget mt=dtservice.selectDepartmentTargetByYearAndOmId(year3,omId);
			BigDecimal mbMonth1=new BigDecimal(0);
			if(mt!=null){
				mbMonth1=mt.getRevenueTarget();
			}
			
			DepartmentTarget mt2=dtservice.selectDepartmentTargetByYearAndOmId(year2,omId);
			BigDecimal mbMonth2=new BigDecimal(0);
			if(mt2!=null){
				mbMonth2=mt2.getRevenueTarget();
			}
			
			DepartmentTarget mt3=dtservice.selectDepartmentTargetByYearAndOmId(year,omId);
			BigDecimal mbMonth3=new BigDecimal(0);
			if(mt3!=null){
				mbMonth3=mt3.getRevenueTarget();
			}
			
			mb.add(mbMonth1);
			mb.add(mbMonth2);
			mb.add(mbMonth3);
			mbList.add(mb);
		}
		resultAll.add(month1All);
		resultAll.add(month2All);
		resultAll.add(month3All);
		
		//获取公司各个目标
		OperationTarget ot3=oservice.selectOperationTargetByYear(year3+"");
		if(null!=ot3) {
			mbAll.add(ot3.getRevenueTarget());
		}else
		{
			mbAll.add(new BigDecimal(0.0));
		}
		OperationTarget ot2=oservice.selectOperationTargetByYear(year2+"");
		if(null!=ot2) {
			mbAll.add(ot2.getRevenueTarget());
		}else
		{
			mbAll.add(new BigDecimal(0.0));
		}
		OperationTarget ot1=oservice.selectOperationTargetByYear(year+"");
		if(null!=ot1) {
			mbAll.add(ot1.getRevenueTarget());
		}else
		{
			mbAll.add(new BigDecimal(0.0));
		}
		
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
		List<List<BigDecimal>> resultList=new ArrayList<>();
		List<List<BigDecimal>> mbList=new ArrayList<>();
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
		List<BigDecimal> resultAll=new ArrayList<>();
		List<BigDecimal> mbAll=new ArrayList<>();
		BigDecimal month1All=new BigDecimal(0);
		BigDecimal month2All=new BigDecimal(0);
		BigDecimal month3All=new BigDecimal(0);
				
		
		//获取公司各种金额
		String resultGs=oservice.selectGsOperationTargetByTime(year3+"");
		JSONObject jsonObject=JSONObject.parseObject(resultGs);
		OperationTarget ot=(OperationTarget)JSONObject.toJavaObject(jsonObject, OperationTarget.class);
		month1All=ot.getSk();//部门前年合同额
		
		//获取公司各种金额
		resultGs=oservice.selectGsOperationTargetByTime(year2+"");
		jsonObject=JSONObject.parseObject(resultGs);
		ot=(OperationTarget)JSONObject.toJavaObject(jsonObject, OperationTarget.class);
		month2All=ot.getSk();//部门去年合同额
		
		//获取公司各种金额
		resultGs=oservice.selectGsOperationTargetByTime(year+"");
		jsonObject=JSONObject.parseObject(resultGs);
		ot=(OperationTarget)JSONObject.toJavaObject(jsonObject, OperationTarget.class);
		month3All=ot.getSk();//部门今年合同额
		
		for(int i=0;i<om.size();i++){
			List<BigDecimal> result=new ArrayList<>();
			List<BigDecimal> mb=new ArrayList<>();
			String omName=om.get(i).getOmName();
			String omId=om.get(i).getOmId();
			omList.add(omName);
			
			
			//获取部门每年的金额
			String resultBm=oservice.selectBmOperationTargetByTime(year3);
			List<DepartmentTarget> dtList=(List<DepartmentTarget>)JSONArray.toJavaObject(JSONArray.parseObject(resultBm), DepartmentTarget.class);
			for(int k=0;k<dtList.size();k++)
			{
				if(dtList.get(k).getBmmc().equals(omName)) {
					result.add(dtList.get(k).getSk());
					break;
				}
			}
			
			//获取部门每年的金额
			resultBm=oservice.selectBmOperationTargetByTime(year2);
			dtList=(List<DepartmentTarget>)JSONArray.toJavaObject(JSONArray.parseObject(resultBm), DepartmentTarget.class);
			for(int k=0;k<dtList.size();k++)
			{
				if(dtList.get(k).getBmmc().equals(omName)) {
					result.add(dtList.get(k).getSk());
					break;
				}
			}
			
			//获取部门每年的金额
			resultBm=oservice.selectBmOperationTargetByTime(year);
			dtList=(List<DepartmentTarget>)JSONArray.toJavaObject(JSONArray.parseObject(resultBm), DepartmentTarget.class);
			for(int k=0;k<dtList.size();k++)
			{
				if(dtList.get(k).getBmmc().equals(omName)) {
					result.add(dtList.get(k).getSk());
					break;
				}
			}
			resultList.add(result);
			
			DepartmentTarget mt=dtservice.selectDepartmentTargetByYearAndOmId(year3, omId);
			BigDecimal mbMonth1=new BigDecimal(0);
			if(mt!=null){
				mbMonth1=mt.getCollectionTarget();
			}
			
			DepartmentTarget mt2=dtservice.selectDepartmentTargetByYearAndOmId(year2, omId);
			BigDecimal mbMonth2=new BigDecimal(0);
			if(mt2!=null){
				mbMonth2=mt2.getCollectionTarget();
			}
			
			DepartmentTarget mt3=dtservice.selectDepartmentTargetByYearAndOmId(year, omId);
			BigDecimal mbMonth3=new BigDecimal(0);
			if(mt3!=null){
				mbMonth3=mt3.getCollectionTarget();
			}
			
			
			mb.add(mbMonth1);
			mb.add(mbMonth2);
			mb.add(mbMonth3);
			mbList.add(mb);
		}
		resultAll.add(month1All);
		resultAll.add(month2All);
		resultAll.add(month3All);
		
		//获取公司各个目标
		OperationTarget ot3=oservice.selectOperationTargetByYear(year3+"");
		if(null!=ot3) {
			mbAll.add(ot3.getCollectionTarget());
		}else
		{
			mbAll.add(new BigDecimal(0.0));
		}
		OperationTarget ot2=oservice.selectOperationTargetByYear(year2+"");
		if(null!=ot2) {
			mbAll.add(ot2.getCollectionTarget());
		}else
		{
			mbAll.add(new BigDecimal(0.0));
		}
		OperationTarget ot1=oservice.selectOperationTargetByYear(year+"");
		if(null!=ot1) {
			mbAll.add(ot1.getCollectionTarget());
		}else
		{
			mbAll.add(new BigDecimal(0.0));
		}
		
		resultList.add(0, resultAll);
		mbList.add(0,mbAll);
		map.put("result", resultList);
		map.put("mb", mbList);
		map.put("om", omList);
		map.put("year", yearList);
		return map;
	}
	
	
	public BigDecimal getDepartmentMoney(List<CjContract> cj,String omId){
		BigDecimal contractMoney=new BigDecimal(0);
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
	
	public BigDecimal getDepartmentMoneyByTask(List<Task> task,String omId){
		BigDecimal contractMoney=new BigDecimal(0);
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
	
	public BigDecimal getDepartmentReceipt(List<CjContract> cj,String omId){
		BigDecimal receiptAll=new BigDecimal(0);
		if(cj!=null){
			for(int j=0;j<cj.size();j++){
				BigDecimal contractMoney=cj.get(j).getContractMoney();//承接合同金额
				BigDecimal resultMoney=cj.get(j).getTemporaryMoney();//承接合同收款金额
				if(omId.equals(cj.get(j).getMainDepartment())){
					
					receiptAll=receiptAll.add((cj.get(j).getMainDepartmentMoney().divide(contractMoney)).multiply(resultMoney));
					//receiptAll=receiptAll+(cj.get(j).getMainDepartmentMoney()/contractMoney)*resultMoney;
				}
				if(omId.equals(cj.get(j).getAssistDepartment1())){
					receiptAll=receiptAll.add((cj.get(j).getMainDepartmentMoney().divide(contractMoney)).multiply(resultMoney));
					//receiptAll=receiptAll+(cj.get(j).getMainDepartmentMoney()/contractMoney)*resultMoney;
				}
				if(omId.equals(cj.get(j).getAssistDepartment2())){
					receiptAll=receiptAll.add((cj.get(j).getMainDepartmentMoney().divide(contractMoney)).multiply(resultMoney));
					//receiptAll=receiptAll+(cj.get(j).getMainDepartmentMoney()/contractMoney)*resultMoney;
				}
				if(omId.equals(cj.get(j).getAssistDepartment3())){
					receiptAll=receiptAll.add((cj.get(j).getMainDepartmentMoney().divide(contractMoney)).multiply(resultMoney));
					//receiptAll=receiptAll+(cj.get(j).getMainDepartmentMoney()/contractMoney)*resultMoney;
				}
			}
		}
		return receiptAll;
	}
	
	public BigDecimal getMbContractMoney(List<MonthTarget> mt){
		BigDecimal money=new BigDecimal(0);
		if(mt!=null){
			for(int jj=0;jj<mt.size();jj++){
				BigDecimal contractAmount=mt.get(jj).getContractAmount();
				money=money.add(contractAmount);
			}
		}
		return money;
	}
	
	public BigDecimal getMbIncome(List<MonthTarget> mt){
		BigDecimal money=new BigDecimal(0);
		if(mt!=null){
			for(int jj=0;jj<mt.size();jj++){
				BigDecimal income=mt.get(jj).getRevenueTarget();
				money=money.add(income);
			}
		}
		return money;
	}
	
	public BigDecimal getMbReceipt(List<MonthTarget> mt){
		BigDecimal money=new BigDecimal(0);
		if(mt!=null){
			for(int jj=0;jj<mt.size();jj++){
				BigDecimal receipt=mt.get(jj).getCollectionTarget();
				money=money.add(receipt);
			}
		}
		return money;
	}
	
	public BigDecimal getReceiptByPrjType(String type,List<CjContract> cj){
		BigDecimal money=new BigDecimal(0);
		if(cj!=null){
			for(int i=0;i<cj.size();i++){
				BigDecimal resultReceipt=cj.get(i).getTemporaryMoney();//实际收款
				BigDecimal cjContractMoney=cj.get(i).getContractMoney();//承接合同金额
				String prjNo=cj.get(i).getTaskCode();
				for(int ii=0;ii<prjNo.split(",").length;ii++){
					String no=prjNo.split(",")[ii];
					Task t=tService.selectTaskByNoAndType(type, no);
					if(t!=null){
						BigDecimal contractMoney=t.getContractMoney();//任务单合同金额
						money=money.add((cjContractMoney.divide(contractMoney)).multiply(resultReceipt));
						//money=money+(cjContractMoney/contractMoney)*resultReceipt;
					}
				}
			}
		}
		return money;
	}
	
}

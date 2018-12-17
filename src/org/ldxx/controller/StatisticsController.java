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

import org.ldxx.bean.CjContract;
import org.ldxx.bean.DepartmentTarget;
import org.ldxx.bean.MonthTarget;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.StatisticsVo;
import org.ldxx.bean.Task;
import org.ldxx.dao.CjContractDao;
import org.ldxx.service.CjContractService;
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

	@RequestMapping("/initGsContract")//初始化本期公司新签合同额。累计收款，累计收入
	@ResponseBody
	public Map<String,Float> initGsContractMoney(){
		Map<String,Float> map=new HashMap<String, Float>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		String time=sdf.format(new Date());
		String year=time.split("-")[0];
		int month=Integer.valueOf(time.split("-")[1]);
		time="%"+time+"%";
		float contractAll=0;//本期合同金额总和
		float cjContractMoneyAll=cjService.selectCjContractMoneyBySignTime(time);//本期所有承接合同金额总和
		float otherContractMoneyAll=oService.selectOtherContractMoneyBySignTime(time);//本期所有其他合同金额总和
		contractAll=cjContractMoneyAll+otherContractMoneyAll;
		float allInCome=pService.selectTotalIncome(time);//本期收入总和
		float allReceipt=fService.selectResultMoneyBySignTime(time);//本期累计收款
		float mbContractMoney=0;//目标合同额
		float mbIncome=0;//目标收入
		float mbReceipt=0;//目标收款
		List<MonthTarget> mt=mService.selectMonthTargetByYearAndMonth(year, month);
		if(mt!=null){
			for(int i=0;i<mt.size();i++){
				float contractAmount=mt.get(i).getContractAmount();
				float revenueTarget=mt.get(i).getRevenueTarget();
				float collectionTarget=mt.get(i).getCollectionTarget();
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
		time="%"+time+"%";
		List<CjContract> cj=cjDao.selectCjContractMoneyBySignTime(time);
		List<OrganizationManagement> om=omService.selectProductionDepartment();
		for(int i=0;i<om.size();i++){
			String omId=om.get(i).getOmId();//部门编号
			String omName=om.get(i).getOmName();//部门名称
			omList.add(omName);
			float contractMoneyAll=0;//承接合同部门本期总签合同额
			for(int ii=0;ii<cj.size();ii++){
				float contractMoney=0;
				if(omId.equals(cj.get(ii).getMainDepartment())){
					contractMoney=cj.get(ii).getMainDepartmentMoney();
				}
				if(omId.equals(cj.get(ii).getAssistDepartment1())){
					contractMoney=cj.get(ii).getAssistDepartment1Money();
				}
				if(omId.equals(cj.get(ii).getAssistDepartment2())){
					contractMoney=cj.get(ii).getAssistDepartment2Money();
				}
				if(omId.equals(cj.get(ii).getAssistDepartment3())){
					contractMoney=cj.get(ii).getAssistDepartment3Money();
				}
				contractMoneyAll=contractMoneyAll+contractMoney;
			}
			float otherMoney=oService.selectOtherContractMoneyBySignTimeAndDepartment(time, omId);//其他合同本期总金额
			float contractAll=otherMoney+contractMoneyAll;//部门本期总签合同金额
			
			float totalIncomeAll=pService.selectThisTimeIncomeByDepartment(omName, time);//部门本期累计收入
			float receiptAll=0;//部门本期累计收款
			List<CjContract> cj2=fService.selectResultMoneyByCjAndTime(time);
			if(cj2!=null){
				for(int j=0;j<cj2.size();j++){
					float contractMoney=cj2.get(j).getContractMoney();//承接合同金额
					float resultMoney=cj2.get(j).getTemporaryMoney();//承接合同收款金额
					if(omId.equals(cj2.get(j).getMainDepartment())){
						receiptAll=receiptAll+(cj2.get(j).getMainDepartmentMoney()/contractMoney)*resultMoney;
					}
					if(omId.equals(cj2.get(j).getAssistDepartment1())){
						receiptAll=receiptAll+(cj2.get(j).getMainDepartmentMoney()/contractMoney)*resultMoney;
					}
					if(omId.equals(cj2.get(j).getAssistDepartment2())){
						receiptAll=receiptAll+(cj2.get(j).getMainDepartmentMoney()/contractMoney)*resultMoney;
					}
					if(omId.equals(cj2.get(j).getAssistDepartment3())){
						receiptAll=receiptAll+(cj2.get(j).getMainDepartmentMoney()/contractMoney)*resultMoney;
					}
				}
			}
			float mbContractMoney=0;//目标合同额
			float mbIncome=0;//目标收入
			float mbReceipt=0;//目标收款
			List<MonthTarget> mt=mService.selectMonthTargetByYearAndMonthAndDepartment(year, month, omId);
			if(mt!=null){
				for(int jj=0;jj<mt.size();jj++){
					float contractAmount=mt.get(jj).getContractAmount();
					float revenueTarget=mt.get(jj).getRevenueTarget();
					float collectionTarget=mt.get(jj).getCollectionTarget();
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
		List<List<Float>> resultReceipt=new ArrayList<>();//实际月部门累计收款按项目类型
		List<String> omList=new ArrayList<>();
		omList.add("公司");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		year="%"+year+"%";
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
		
		List<Float> gsReceipt=new ArrayList<>();
		float gsReceiptMonth1All=0;
		float gsReceiptMonth2All=0;
		float gsReceiptMonth3All=0;
		float gsReceiptMonth4All=0;
		float gsReceiptMonth5All=0;
		float gsReceiptMonth6All=0;
		float gsReceiptMonth7All=0;
		float gsReceiptMonth8All=0;
		float gsReceiptMonth9All=0;
		float gsReceiptMonth10All=0;
		float gsReceiptMonth11All=0;
		float gsReceiptMonth12All=0;
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
			List<Float> receiptMoneyList=new ArrayList<>();
			float receiptMonth1All=0;
			float receiptMonth2All=0;
			float receiptMonth3All=0;
			float receiptMonth4All=0;
			float receiptMonth5All=0;
			float receiptMonth6All=0;
			float receiptMonth7All=0;
			float receiptMonth8All=0;
			float receiptMonth9All=0;
			float receiptMonth10All=0;
			float receiptMonth11All=0;
			float receiptMonth12All=0;
			
			List<CjContract> cj=fService.selectResultMoneyByCjAndTime("%"+year+"-01%");
			List<CjContract> cj2=fService.selectResultMoneyByCjAndTime("%"+year+"-02%");
			List<CjContract> cj3=fService.selectResultMoneyByCjAndTime("%"+year+"-03%");
			List<CjContract> cj4=fService.selectResultMoneyByCjAndTime("%"+year+"-04%");
			List<CjContract> cj5=fService.selectResultMoneyByCjAndTime("%"+year+"-05%");
			List<CjContract> cj6=fService.selectResultMoneyByCjAndTime("%"+year+"-06%");
			List<CjContract> cj7=fService.selectResultMoneyByCjAndTime("%"+year+"-07%");
			List<CjContract> cj8=fService.selectResultMoneyByCjAndTime("%"+year+"-08%");
			List<CjContract> cj9=fService.selectResultMoneyByCjAndTime("%"+year+"-09%");
			List<CjContract> cj10=fService.selectResultMoneyByCjAndTime("%"+year+"-10%");
			List<CjContract> cj11=fService.selectResultMoneyByCjAndTime("%"+year+"-11%");
			List<CjContract> cj12=fService.selectResultMoneyByCjAndTime("%"+year+"-12%");
			
			for(int i=0;i<prjType.split(",").length;i++){
				//部门新签合同额按项目类型
				String type="%"+prjType.split(",")[i]+"%";
				List<Task> task=tService.selectTaskByPrjType(type, "%"+year+"-01%");
				float contractMonth1=getDepartmentMoneyByTask(task, omId);
				contractMonth1All=contractMonth1All+contractMonth1;
				List<Task> task2=tService.selectTaskByPrjType(type, "%"+year+"-02%");
				float contractMonth2=getDepartmentMoneyByTask(task2, omId);
				contractMonth2All=contractMonth2All+contractMonth2;
				List<Task> task3=tService.selectTaskByPrjType(type, "%"+year+"-03%");
				float contractMonth3=getDepartmentMoneyByTask(task3, omId);
				contractMonth3All=contractMonth3All+contractMonth3;
				List<Task> task4=tService.selectTaskByPrjType(type, "%"+year+"-04%");
				float contractMonth4=getDepartmentMoneyByTask(task4, omId);
				contractMonth4All=contractMonth4All+contractMonth4;
				List<Task> task5=tService.selectTaskByPrjType(type, "%"+year+"-05%");
				float contractMonth5=getDepartmentMoneyByTask(task5, omId);
				contractMonth5All=contractMonth5All+contractMonth5;
				List<Task> task6=tService.selectTaskByPrjType(type, "%"+year+"-06%");
				float contractMonth6=getDepartmentMoneyByTask(task6, omId);
				contractMonth6All=contractMonth6All+contractMonth6;
				List<Task> task7=tService.selectTaskByPrjType(type, "%"+year+"-07%");
				float contractMonth7=getDepartmentMoneyByTask(task7, omId);
				contractMonth7All=contractMonth7All+contractMonth7;
				List<Task> task8=tService.selectTaskByPrjType(type, "%"+year+"-08%");
				float contractMonth8=getDepartmentMoneyByTask(task8, omId);
				contractMonth8All=contractMonth8All+contractMonth8;
				List<Task> task9=tService.selectTaskByPrjType(type, "%"+year+"-09%");
				float contractMonth9=getDepartmentMoneyByTask(task9, omId);
				contractMonth9All=contractMonth9All+contractMonth9;
				List<Task> task10=tService.selectTaskByPrjType(type, "%"+year+"-10%");
				float contractMonth10=getDepartmentMoneyByTask(task10, omId);
				contractMonth10All=contractMonth10All+contractMonth10;
				List<Task> task11=tService.selectTaskByPrjType(type, "%"+year+"-11%");
				float contractMonth11=getDepartmentMoneyByTask(task11, omId);
				contractMonth11All=contractMonth11All+contractMonth11;
				List<Task> task12=tService.selectTaskByPrjType(type, "%"+year+"-12%");
				float contractMonth12=getDepartmentMoneyByTask(task12, omId);
				contractMonth12All=contractMonth12All+contractMonth12;
				
				//部门累计收入按项目类型
				float inComeMonth1=pService.selectThisTimeIncomeByDepartmentAndPrjType(omName, "%"+year+"-01%", type);
				inComeMonth1All=inComeMonth1All+inComeMonth1;
				float inComeMonth2=pService.selectThisTimeIncomeByDepartmentAndPrjType(omName, "%"+year+"-02%", type);
				inComeMonth2All=inComeMonth2All+inComeMonth2;
				float inComeMonth3=pService.selectThisTimeIncomeByDepartmentAndPrjType(omName, "%"+year+"-03%", type);
				inComeMonth3All=inComeMonth3All+inComeMonth3;
				float inComeMonth4=pService.selectThisTimeIncomeByDepartmentAndPrjType(omName, "%"+year+"-04%", type);
				inComeMonth4All=inComeMonth4All+inComeMonth4;
				float inComeMonth5=pService.selectThisTimeIncomeByDepartmentAndPrjType(omName, "%"+year+"-05%", type);
				inComeMonth5All=inComeMonth5All+inComeMonth5;
				float inComeMonth6=pService.selectThisTimeIncomeByDepartmentAndPrjType(omName, "%"+year+"-06%", type);
				inComeMonth6All=inComeMonth6All+inComeMonth6;
				float inComeMonth7=pService.selectThisTimeIncomeByDepartmentAndPrjType(omName, "%"+year+"-07%", type);
				inComeMonth7All=inComeMonth7All+inComeMonth7;
				float inComeMonth8=pService.selectThisTimeIncomeByDepartmentAndPrjType(omName, "%"+year+"-08%", type);
				inComeMonth8All=inComeMonth8All+inComeMonth8;
				float inComeMonth9=pService.selectThisTimeIncomeByDepartmentAndPrjType(omName, "%"+year+"-09%", type);
				inComeMonth9All=inComeMonth9All+inComeMonth9;
				float inComeMonth10=pService.selectThisTimeIncomeByDepartmentAndPrjType(omName, "%"+year+"-10%", type);
				inComeMonth10All=inComeMonth10All+inComeMonth10;
				float inComeMonth11=pService.selectThisTimeIncomeByDepartmentAndPrjType(omName, "%"+year+"-11%", type);
				inComeMonth11All=inComeMonth11All+inComeMonth11;
				float inComeMonth12=pService.selectThisTimeIncomeByDepartmentAndPrjType(omName, "%"+year+"-12%", type);
				inComeMonth12All=inComeMonth12All+inComeMonth12;
				
				//部门累计收款按项目类型
				
				float receiptMonth1=getReceiptByPrjType(type, cj);
				receiptMonth1All=receiptMonth1All+receiptMonth1;
				float receiptMonth2=getReceiptByPrjType(type, cj2);
				receiptMonth2All=receiptMonth2All+receiptMonth2;
				float receiptMonth3=getReceiptByPrjType(type, cj3);
				receiptMonth3All=receiptMonth3All+receiptMonth3;
				float receiptMonth4=getReceiptByPrjType(type, cj4);
				receiptMonth4All=receiptMonth4All+receiptMonth4;
				float receiptMonth5=getReceiptByPrjType(type, cj5);
				receiptMonth5All=receiptMonth5All+receiptMonth5;
				float receiptMonth6=getReceiptByPrjType(type, cj6);
				receiptMonth6All=receiptMonth6All+receiptMonth6;
				float receiptMonth7=getReceiptByPrjType(type, cj7);
				receiptMonth7All=receiptMonth7All+receiptMonth7;
				float receiptMonth8=getReceiptByPrjType(type, cj8);
				receiptMonth8All=receiptMonth8All+receiptMonth8;
				float receiptMonth9=getReceiptByPrjType(type, cj9);
				receiptMonth9All=receiptMonth9All+receiptMonth9;
				float receiptMonth10=getReceiptByPrjType(type, cj10);
				receiptMonth10All=receiptMonth10All+receiptMonth10;
				float receiptMonth11=getReceiptByPrjType(type, cj11);
				receiptMonth11All=receiptMonth11All+receiptMonth11;
				float receiptMonth12=getReceiptByPrjType(type, cj12);
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
		List<List<Float>> resultReceipt=new ArrayList<>();//实际年部门累计收款按项目类型
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
		
		List<Float> gsReceipt=new ArrayList<>();
		float gsReceiptYear1All=0;
		float gsReceiptYear2All=0;
		float gsReceiptYear3All=0;
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
			List<Float> receiptMoneyList=new ArrayList<>();
			float receiptYear1All=0;
			float receiptYear2All=0;
			float receiptYear3All=0;
			List<CjContract> cj=fService.selectResultMoneyByCjAndTime("%"+year3+"%");
			List<CjContract> cj2=fService.selectResultMoneyByCjAndTime("%"+year2+"%");
			List<CjContract> cj3=fService.selectResultMoneyByCjAndTime("%"+year+"%");
			for(int i=0;i<prjType.split(",").length;i++){
				//部门新签合同额按项目类型
				String type="%"+prjType.split(",")[i]+"%";
				List<Task> task=tService.selectTaskByPrjType(type, "%"+year3+"%");
				float contractMonth1=getDepartmentMoneyByTask(task, omId);
				contractYear1All=contractYear1All+contractMonth1;
				List<Task> task2=tService.selectTaskByPrjType(type, "%"+year2+"%");
				float contractMonth2=getDepartmentMoneyByTask(task2, omId);
				contractYear2All=contractYear2All+contractMonth2;
				List<Task> task3=tService.selectTaskByPrjType(type, "%"+year+"%");
				float contractMonth3=getDepartmentMoneyByTask(task3, omId);
				contractYear3All=contractYear3All+contractMonth3;
				
				//部门累计收入按项目类型
				float inComeMonth1=pService.selectThisTimeIncomeByDepartmentAndPrjType(omName, "%"+year3+"%", type);
				inComeYear1All=inComeYear1All+inComeMonth1;
				float inComeMonth2=pService.selectThisTimeIncomeByDepartmentAndPrjType(omName, "%"+year2+"%", type);
				inComeYear2All=inComeYear2All+inComeMonth2;
				float inComeMonth3=pService.selectThisTimeIncomeByDepartmentAndPrjType(omName, "%"+year+"%", type);
				inComeYear3All=inComeYear3All+inComeMonth3;
				
				//部门累计收款按项目类型
				float receiptMonth1=getReceiptByPrjType(type, cj);
				receiptYear1All=receiptYear1All+receiptMonth1;
				float receiptMonth2=getReceiptByPrjType(type, cj2);
				receiptYear2All=receiptYear2All+receiptMonth2;
				float receiptMonth3=getReceiptByPrjType(type, cj3);
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
		List<List<Float>> resultList=new ArrayList<>();
		List<List<Float>> mbList=new ArrayList<>();
		List<String> omList=new ArrayList<>();
		omList.add("公司");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		List<OrganizationManagement> om=omService.selectProductionDepartment();//生产部门列表
		List<CjContract> cj=cjDao.selectCjContractMoneyBySignTime("%"+year+"-01%");
		List<CjContract> cj2=cjDao.selectCjContractMoneyBySignTime("%"+year+"-02%");
		List<CjContract> cj3=cjDao.selectCjContractMoneyBySignTime("%"+year+"-03%");
		List<CjContract> cj4=cjDao.selectCjContractMoneyBySignTime("%"+year+"-04%");
		List<CjContract> cj5=cjDao.selectCjContractMoneyBySignTime("%"+year+"-05%");
		List<CjContract> cj6=cjDao.selectCjContractMoneyBySignTime("%"+year+"-06%");
		List<CjContract> cj7=cjDao.selectCjContractMoneyBySignTime("%"+year+"-07%");
		List<CjContract> cj8=cjDao.selectCjContractMoneyBySignTime("%"+year+"-08%");
		List<CjContract> cj9=cjDao.selectCjContractMoneyBySignTime("%"+year+"-09%");
		List<CjContract> cj10=cjDao.selectCjContractMoneyBySignTime("%"+year+"-10%");
		List<CjContract> cj11=cjDao.selectCjContractMoneyBySignTime("%"+year+"-11%");
		List<CjContract> cj12=cjDao.selectCjContractMoneyBySignTime("%"+year+"-12%");
		List<Float> resultAll=new ArrayList<>();
		List<Float> mbAll=new ArrayList<>();
		float month1All=0;
		float month2All=0;
		float month3All=0;
		float month4All=0;
		float month5All=0;
		float month6All=0;
		float month7All=0;
		float month8All=0;
		float month9All=0;
		float month10All=0;
		float month11All=0;
		float month12All=0;
		float mbMonth1All=0;
		float mbMonth2All=0;
		float mbMonth3All=0;
		float mbMonth4All=0;
		float mbMonth5All=0;
		float mbMonth6All=0;
		float mbMonth7All=0;
		float mbMonth8All=0;
		float mbMonth9All=0;
		float mbMonth10All=0;
		float mbMonth11All=0;
		float mbMonth12All=0;
		for(int i=0;i<om.size();i++){
			List<Float> result=new ArrayList<>();
			List<Float> mb=new ArrayList<>();
			
			String omId=om.get(i).getOmId();//部门编号
			String omName=om.get(i).getOmName();//部门名称
			omList.add(omName);
			
			float cjMonth1=getDepartmentMoney(cj,omId);//部门一月份承接合同额
			float otherMonth1=oService.selectOtherContractMoneyBySignTimeAndDepartment("%"+year+"-01%", omId);//部门1月份其他合同额
			float month1=cjMonth1+otherMonth1;//部门1份月合同额总和
			month1All=month1All+month1;
			
			float cjMonth2=getDepartmentMoney(cj,omId);//部门二月份承接合同额
			float otherMonth2=oService.selectOtherContractMoneyBySignTimeAndDepartment("%"+year+"-02%", omId);//部门2月份其他合同额
			float month2=cjMonth2+otherMonth2;//部门2份月合同额总和
			month2All=month2All+month2;
			
			float cjMonth3=getDepartmentMoney(cj,omId);//部门三月份承接合同额
			float otherMonth3=oService.selectOtherContractMoneyBySignTimeAndDepartment("%"+year+"-03%", omId);//部门3月份其他合同额
			float month3=cjMonth3+otherMonth3;//部门3份月合同额总和
			month3All=month3All+month3;
			
			float cjMonth4=getDepartmentMoney(cj,omId);//部门四月份承接合同额
			float otherMonth4=oService.selectOtherContractMoneyBySignTimeAndDepartment("%"+year+"-04%", omId);//部门4月份其他合同额
			float month4=cjMonth4+otherMonth4;//部门4份月合同额总和
			month4All=month4All+month4;
			
			float cjMonth5=getDepartmentMoney(cj,omId);//部门五月份承接合同额
			float otherMonth5=oService.selectOtherContractMoneyBySignTimeAndDepartment("%"+year+"-05%", omId);//部门5月份其他合同额
			float month5=cjMonth5+otherMonth5;//部门5份月合同额总和
			month5All=month5All+month5;
			
			float cjMonth6=getDepartmentMoney(cj,omId);//部门六月份承接合同额
			float otherMonth6=oService.selectOtherContractMoneyBySignTimeAndDepartment("%"+year+"-06%", omId);//部门6月份其他合同额
			float month6=cjMonth6+otherMonth6;//部门6份月合同额总和
			month6All=month6All+month6;
			
			float cjMonth7=getDepartmentMoney(cj,omId);//部门七月份承接合同额
			float otherMonth7=oService.selectOtherContractMoneyBySignTimeAndDepartment("%"+year+"-07%", omId);//部门7月份其他合同额
			float month7=cjMonth7+otherMonth7;//部门7份月合同额总和
			month7All=month7All+month7;
			
			float cjMonth8=getDepartmentMoney(cj,omId);//部门八月份承接合同额
			float otherMonth8=oService.selectOtherContractMoneyBySignTimeAndDepartment("%"+year+"-08%", omId);//部门8月份其他合同额
			float month8=cjMonth8+otherMonth8;//部门8份月合同额总和
			month8All=month8All+month8;
			
			float cjMonth9=getDepartmentMoney(cj,omId);//部门九月份承接合同额
			float otherMonth9=oService.selectOtherContractMoneyBySignTimeAndDepartment("%"+year+"-09%", omId);//部门9月份其他合同额
			float month9=cjMonth9+otherMonth9;//部门9份月合同额总和
			month9All=month9All+month9;
			
			float cjMonth10=getDepartmentMoney(cj,omId);//部门十月份承接合同额
			float otherMonth10=oService.selectOtherContractMoneyBySignTimeAndDepartment("%"+year+"-10%", omId);//部门10月份其他合同额
			float month10=cjMonth10+otherMonth10;//部门10份月合同额总和
			month10All=month10All+month10;
			
			float cjMonth11=getDepartmentMoney(cj,omId);//部门十一月份承接合同额
			float otherMonth11=oService.selectOtherContractMoneyBySignTimeAndDepartment("%"+year+"-11%", omId);//部门11月份其他合同额
			float month11=cjMonth11+otherMonth11;//部门11份月合同额总和
			month11All=month11All+month11;
			
			float cjMonth12=getDepartmentMoney(cj,omId);//部门十二月份承接合同额
			float otherMonth12=oService.selectOtherContractMoneyBySignTimeAndDepartment("%"+year+"-12%", omId);//部门12月份其他合同额
			float month12=cjMonth12+otherMonth12;//部门12份月合同额总和
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
			float mbMonth1=getMbContractMoney(mt);
			mbMonth1All=mbMonth1All+mbMonth1;
			
			List<MonthTarget> mt2=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 2, omId);
			float mbMonth2=getMbContractMoney(mt2);
			mbMonth2All=mbMonth2All+mbMonth2;
			
			List<MonthTarget> mt3=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 3, omId);
			float mbMonth3=getMbContractMoney(mt3);
			mbMonth3All=mbMonth3All+mbMonth3;
			
			List<MonthTarget> mt4=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 4, omId);
			float mbMonth4=getMbContractMoney(mt4);
			mbMonth4All=mbMonth4All+mbMonth4;
			
			List<MonthTarget> mt5=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 5, omId);
			float mbMonth5=getMbContractMoney(mt5);
			mbMonth5All=mbMonth5All+mbMonth5;
			
			List<MonthTarget> mt6=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 6, omId);
			float mbMonth6=getMbContractMoney(mt6);
			mbMonth6All=mbMonth6All+mbMonth6;
			
			List<MonthTarget> mt7=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 7, omId);
			float mbMonth7=getMbContractMoney(mt7);
			mbMonth7All=mbMonth7All+mbMonth7;
			
			List<MonthTarget> mt8=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 8, omId);
			float mbMonth8=getMbContractMoney(mt8);
			mbMonth8All=mbMonth8All+mbMonth8;
			
			List<MonthTarget> mt9=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 9, omId);
			float mbMonth9=getMbContractMoney(mt9);
			mbMonth9All=mbMonth9All+mbMonth9;
			
			List<MonthTarget> mt10=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 10, omId);
			float mbMonth10=getMbContractMoney(mt10);
			mbMonth10All=mbMonth10All+mbMonth10;
			
			List<MonthTarget> mt11=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 11, omId);
			float mbMonth11=getMbContractMoney(mt11);
			mbMonth11All=mbMonth11All+mbMonth11;
			
			List<MonthTarget> mt12=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 12, omId);
			float mbMonth12=getMbContractMoney(mt12);
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
		List<List<Float>> resultList=new ArrayList<>();
		List<List<Float>> mbList=new ArrayList<>();
		List<String> omList=new ArrayList<>();
		omList.add("公司");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		List<OrganizationManagement> om=omService.selectProductionDepartment();//生产部门列表
		List<Float> resultAll=new ArrayList<>();
		List<Float> mbAll=new ArrayList<>();
		float month1All=0;
		float month2All=0;
		float month3All=0;
		float month4All=0;
		float month5All=0;
		float month6All=0;
		float month7All=0;
		float month8All=0;
		float month9All=0;
		float month10All=0;
		float month11All=0;
		float month12All=0;
		float mbMonth1All=0;
		float mbMonth2All=0;
		float mbMonth3All=0;
		float mbMonth4All=0;
		float mbMonth5All=0;
		float mbMonth6All=0;
		float mbMonth7All=0;
		float mbMonth8All=0;
		float mbMonth9All=0;
		float mbMonth10All=0;
		float mbMonth11All=0;
		float mbMonth12All=0;
		for(int i=0;i<om.size();i++){
			List<Float> result=new ArrayList<>();
			List<Float> mb=new ArrayList<>();
			String omName=om.get(i).getOmName();
			String omId=om.get(i).getOmId();
			omList.add(omName);
			float incomeMonth1=pService.selectThisTimeIncomeByDepartment(omName, "%"+year+"-01%");
			month1All=month1All+incomeMonth1;
			float incomeMonth2=pService.selectThisTimeIncomeByDepartment(omName, "%"+year+"-02%");
			month2All=month2All+incomeMonth2;
			float incomeMonth3=pService.selectThisTimeIncomeByDepartment(omName, "%"+year+"-03%");
			month3All=month3All+incomeMonth3;
			float incomeMonth4=pService.selectThisTimeIncomeByDepartment(omName, "%"+year+"-04%");
			month4All=month4All+incomeMonth4;
			float incomeMonth5=pService.selectThisTimeIncomeByDepartment(omName, "%"+year+"-05%");
			month5All=month5All+incomeMonth5;
			float incomeMonth6=pService.selectThisTimeIncomeByDepartment(omName, "%"+year+"-06%");
			month6All=month6All+incomeMonth6;
			float incomeMonth7=pService.selectThisTimeIncomeByDepartment(omName, "%"+year+"-07%");
			month7All=month7All+incomeMonth7;
			float incomeMonth8=pService.selectThisTimeIncomeByDepartment(omName, "%"+year+"-08%");
			month8All=month8All+incomeMonth8;
			float incomeMonth9=pService.selectThisTimeIncomeByDepartment(omName, "%"+year+"-09%");
			month9All=month9All+incomeMonth9;
			float incomeMonth10=pService.selectThisTimeIncomeByDepartment(omName, "%"+year+"-10%");
			month10All=month10All+incomeMonth10;
			float incomeMonth11=pService.selectThisTimeIncomeByDepartment(omName, "%"+year+"-11%");
			month11All=month11All+incomeMonth11;
			float incomeMonth12=pService.selectThisTimeIncomeByDepartment(omName, "%"+year+"-12%");
			month12All=month12All+incomeMonth12;
			result.add(incomeMonth1);
			result.add(incomeMonth2);
			result.add(incomeMonth3);
			result.add(incomeMonth4);
			result.add(incomeMonth5);
			result.add(incomeMonth6);
			result.add(incomeMonth7);
			result.add(incomeMonth8);
			result.add(incomeMonth9);
			result.add(incomeMonth10);
			result.add(incomeMonth11);
			result.add(incomeMonth12);
			resultList.add(result);
			
			List<MonthTarget> mt=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 1, omId);
			float mbMonth1=getMbIncome(mt);
			mbMonth1All=mbMonth1All+mbMonth1;
			
			List<MonthTarget> mt2=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 2, omId);
			float mbMonth2=getMbIncome(mt2);
			mbMonth2All=mbMonth2All+mbMonth2;
			
			List<MonthTarget> mt3=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 3, omId);
			float mbMonth3=getMbIncome(mt3);
			mbMonth3All=mbMonth3All+mbMonth3;
			
			List<MonthTarget> mt4=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 4, omId);
			float mbMonth4=getMbIncome(mt4);
			mbMonth4All=mbMonth4All+mbMonth4;
			
			List<MonthTarget> mt5=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 5, omId);
			float mbMonth5=getMbIncome(mt5);
			mbMonth5All=mbMonth5All+mbMonth5;
			
			List<MonthTarget> mt6=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 6, omId);
			float mbMonth6=getMbIncome(mt6);
			mbMonth6All=mbMonth6All+mbMonth6;
			
			List<MonthTarget> mt7=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 7, omId);
			float mbMonth7=getMbIncome(mt7);
			mbMonth7All=mbMonth7All+mbMonth7;
			
			List<MonthTarget> mt8=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 8, omId);
			float mbMonth8=getMbIncome(mt8);
			mbMonth8All=mbMonth8All+mbMonth8;
			
			List<MonthTarget> mt9=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 9, omId);
			float mbMonth9=getMbIncome(mt9);
			mbMonth9All=mbMonth9All+mbMonth9;
			
			List<MonthTarget> mt10=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 10, omId);
			float mbMonth10=getMbIncome(mt10);
			mbMonth10All=mbMonth10All+mbMonth10;
			
			List<MonthTarget> mt11=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 11, omId);
			float mbMonth11=getMbIncome(mt11);
			mbMonth11All=mbMonth11All+mbMonth11;
			
			List<MonthTarget> mt12=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 12, omId);
			float mbMonth12=getMbIncome(mt12);
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
		List<List<Float>> resultList=new ArrayList<>();
		List<List<Float>> mbList=new ArrayList<>();
		List<String> omList=new ArrayList<>();
		omList.add("公司");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		List<OrganizationManagement> om=omService.selectProductionDepartment();//生产部门列表
		List<Float> resultAll=new ArrayList<>();
		List<Float> mbAll=new ArrayList<>();
		float month1All=0;
		float month2All=0;
		float month3All=0;
		float month4All=0;
		float month5All=0;
		float month6All=0;
		float month7All=0;
		float month8All=0;
		float month9All=0;
		float month10All=0;
		float month11All=0;
		float month12All=0;
		float mbMonth1All=0;
		float mbMonth2All=0;
		float mbMonth3All=0;
		float mbMonth4All=0;
		float mbMonth5All=0;
		float mbMonth6All=0;
		float mbMonth7All=0;
		float mbMonth8All=0;
		float mbMonth9All=0;
		float mbMonth10All=0;
		float mbMonth11All=0;
		float mbMonth12All=0;
		
		
		List<CjContract> cj=fService.selectResultMoneyByCjAndTime("%"+year+"-01%");
		List<CjContract> cj2=fService.selectResultMoneyByCjAndTime("%"+year+"-02%");
		List<CjContract> cj3=fService.selectResultMoneyByCjAndTime("%"+year+"-03%");
		List<CjContract> cj4=fService.selectResultMoneyByCjAndTime("%"+year+"-04%");
		List<CjContract> cj5=fService.selectResultMoneyByCjAndTime("%"+year+"-05%");
		List<CjContract> cj6=fService.selectResultMoneyByCjAndTime("%"+year+"-06%");
		List<CjContract> cj7=fService.selectResultMoneyByCjAndTime("%"+year+"-07%");
		List<CjContract> cj8=fService.selectResultMoneyByCjAndTime("%"+year+"-08%");
		List<CjContract> cj9=fService.selectResultMoneyByCjAndTime("%"+year+"-09%");
		List<CjContract> cj10=fService.selectResultMoneyByCjAndTime("%"+year+"-10%");
		List<CjContract> cj11=fService.selectResultMoneyByCjAndTime("%"+year+"-11%");
		List<CjContract> cj12=fService.selectResultMoneyByCjAndTime("%"+year+"-12%");
		
		for(int i=0;i<om.size();i++){
			List<Float> result=new ArrayList<>();
			List<Float> mb=new ArrayList<>();
			String omName=om.get(i).getOmName();
			String omId=om.get(i).getOmId();
			omList.add(omName);
			float month1=getDepartmentReceipt(cj,omId);
			month1All=month1All+month1;
			float month2=getDepartmentReceipt(cj2,omId);
			month2All=month2All+month2;
			float month3=getDepartmentReceipt(cj3,omId);
			month3All=month3All+month3;
			float month4=getDepartmentReceipt(cj4,omId);
			month4All=month4All+month4;
			float month5=getDepartmentReceipt(cj5,omId);
			month5All=month5All+month5;
			float month6=getDepartmentReceipt(cj6,omId);
			month6All=month6All+month6;
			float month7=getDepartmentReceipt(cj7,omId);
			month7All=month7All+month7;
			float month8=getDepartmentReceipt(cj8,omId);
			month8All=month8All+month8;
			float month9=getDepartmentReceipt(cj9,omId);
			month9All=month9All+month9;
			float month10=getDepartmentReceipt(cj10,omId);
			month10All=month10All+month10;
			float month11=getDepartmentReceipt(cj11,omId);
			month11All=month11All+month11;
			float month12=getDepartmentReceipt(cj12,omId);
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
			float mbMonth1=getMbReceipt(mt);
			mbMonth1All=mbMonth1All+mbMonth1;
			
			List<MonthTarget> mt2=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 2, omId);
			float mbMonth2=getMbReceipt(mt2);
			mbMonth2All=mbMonth2All+mbMonth2;
			
			List<MonthTarget> mt3=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 3, omId);
			float mbMonth3=getMbReceipt(mt3);
			mbMonth3All=mbMonth3All+mbMonth3;
			
			List<MonthTarget> mt4=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 4, omId);
			float mbMonth4=getMbReceipt(mt4);
			mbMonth4All=mbMonth4All+mbMonth4;
			
			List<MonthTarget> mt5=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 5, omId);
			float mbMonth5=getMbReceipt(mt5);
			mbMonth5All=mbMonth5All+mbMonth5;
			
			List<MonthTarget> mt6=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 6, omId);
			float mbMonth6=getMbReceipt(mt6);
			mbMonth6All=mbMonth6All+mbMonth6;
			
			List<MonthTarget> mt7=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 7, omId);
			float mbMonth7=getMbReceipt(mt7);
			mbMonth7All=mbMonth7All+mbMonth7;
			
			List<MonthTarget> mt8=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 8, omId);
			float mbMonth8=getMbReceipt(mt8);
			mbMonth8All=mbMonth8All+mbMonth8;
			
			List<MonthTarget> mt9=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 9, omId);
			float mbMonth9=getMbReceipt(mt9);
			mbMonth9All=mbMonth9All+mbMonth9;
			
			List<MonthTarget> mt10=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 10, omId);
			float mbMonth10=getMbReceipt(mt10);
			mbMonth10All=mbMonth10All+mbMonth10;
			
			List<MonthTarget> mt11=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 11, omId);
			float mbMonth11=getMbReceipt(mt11);
			mbMonth11All=mbMonth11All+mbMonth11;
			
			List<MonthTarget> mt12=mService.selectMonthTargetByYearAndMonthAndDepartment(year, 12, omId);
			float mbMonth12=getMbReceipt(mt12);
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
		List<List<Float>> resultList=new ArrayList<>();
		List<List<Float>> mbList=new ArrayList<>();
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
		List<CjContract> cj=cjDao.selectCjContractMoneyBySignTime("%"+year3+"%");//前年承接合同
		List<CjContract> cj2=cjDao.selectCjContractMoneyBySignTime("%"+year2+"%");//去年承接合同
		List<CjContract> cj3=cjDao.selectCjContractMoneyBySignTime("%"+year+"%");//今年承接合同
		
		List<Float> resultAll=new ArrayList<>();
		List<Float> mbAll=new ArrayList<>();
		float month1All=0;
		float month2All=0;
		float month3All=0;
		
		float mbMonth1All=0;
		float mbMonth2All=0;
		float mbMonth3All=0;
		
		for(int i=0;i<om.size();i++){
			List<Float> result=new ArrayList<>();
			List<Float> mb=new ArrayList<>();
			
			String omId=om.get(i).getOmId();//部门编号
			String omName=om.get(i).getOmName();//部门名称
			omList.add(omName);
			
			float cjMonth1=getDepartmentMoney(cj,omId);//部门前年承接合同额
			float otherMonth1=oService.selectOtherContractMoneyBySignTimeAndDepartment("%"+year3+"%", omId);//部门前年其他合同额
			float month1=cjMonth1+otherMonth1;//部门前年合同额总和
			month1All=month1All+month1;
			
			float cjMonth2=getDepartmentMoney(cj,omId);//部门去年承接合同额
			float otherMonth2=oService.selectOtherContractMoneyBySignTimeAndDepartment("%"+year2+"%", omId);//部门去年其他合同额
			float month2=cjMonth2+otherMonth2;//部门去年合同额总和
			month2All=month2All+month2;
			
			float cjMonth3=getDepartmentMoney(cj,omId);//部门今年承接合同额
			float otherMonth3=oService.selectOtherContractMoneyBySignTimeAndDepartment("%"+year+"%", omId);//部门今年其他合同额
			float month3=cjMonth3+otherMonth3;//部门今年合同额总和
			month3All=month3All+month3;
			
			
			result.add(month1);
			result.add(month2);
			result.add(month3);
			resultList.add(result);
			
			DepartmentTarget mt=dtService.selectDepartmentTargetByOmIdAndYear(omId, year3);
			float mbMonth1=0;
			if(mt!=null){
				mbMonth1=mt.getContractAmount();
			}
			mbMonth1All=mbMonth1All+mbMonth1;
			
			DepartmentTarget mt2=dtService.selectDepartmentTargetByOmIdAndYear(omId, year2);
			float mbMonth2=0;
			if(mt2!=null){
				mbMonth2=mt2.getContractAmount();
			}
			mbMonth2All=mbMonth2All+mbMonth2;
			
			DepartmentTarget mt3=dtService.selectDepartmentTargetByOmIdAndYear(omId, year);
			float mbMonth3=0;
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
		List<List<Float>> resultList=new ArrayList<>();
		List<List<Float>> mbList=new ArrayList<>();
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
		List<Float> resultAll=new ArrayList<>();
		List<Float> mbAll=new ArrayList<>();
		float month1All=0;
		float month2All=0;
		float month3All=0;
		
		float mbMonth1All=0;
		float mbMonth2All=0;
		float mbMonth3All=0;
	
		for(int i=0;i<om.size();i++){
			List<Float> result=new ArrayList<>();
			List<Float> mb=new ArrayList<>();
			String omName=om.get(i).getOmName();
			String omId=om.get(i).getOmId();
			omList.add(omName);
			float incomeMonth1=pService.selectThisTimeIncomeByDepartment(omName, "%"+year3+"%");
			month1All=month1All+incomeMonth1;
			float incomeMonth2=pService.selectThisTimeIncomeByDepartment(omName, "%"+year2+"%");
			month2All=month2All+incomeMonth2;
			float incomeMonth3=pService.selectThisTimeIncomeByDepartment(omName, "%"+year+"%");
			month3All=month3All+incomeMonth3;
			
			result.add(incomeMonth1);
			result.add(incomeMonth2);
			result.add(incomeMonth3);
			
			resultList.add(result);
			
			DepartmentTarget mt=dtService.selectDepartmentTargetByOmIdAndYear(omId, year3);
			float mbMonth1=0;
			if(mt!=null){
				mbMonth1=mt.getRevenueTarget();
			}
			mbMonth1All=mbMonth1All+mbMonth1;
			
			DepartmentTarget mt2=dtService.selectDepartmentTargetByOmIdAndYear(omId, year2);
			float mbMonth2=0;
			if(mt2!=null){
				mbMonth2=mt2.getRevenueTarget();
			}
			mbMonth2All=mbMonth2All+mbMonth2;
			
			DepartmentTarget mt3=dtService.selectDepartmentTargetByOmIdAndYear(omId, year);
			float mbMonth3=0;
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
		List<List<Float>> resultList=new ArrayList<>();
		List<List<Float>> mbList=new ArrayList<>();
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
		List<Float> resultAll=new ArrayList<>();
		List<Float> mbAll=new ArrayList<>();
		float month1All=0;
		float month2All=0;
		float month3All=0;
		
		float mbMonth1All=0;
		float mbMonth2All=0;
		float mbMonth3All=0;
		
		List<CjContract> cj=fService.selectResultMoneyByCjAndTime("%"+year3+"%");
		List<CjContract> cj2=fService.selectResultMoneyByCjAndTime("%"+year2+"%");
		List<CjContract> cj3=fService.selectResultMoneyByCjAndTime("%"+year+"%");
		
		for(int i=0;i<om.size();i++){
			List<Float> result=new ArrayList<>();
			List<Float> mb=new ArrayList<>();
			String omName=om.get(i).getOmName();
			String omId=om.get(i).getOmId();
			omList.add(omName);
			float month1=getDepartmentReceipt(cj,omId);
			month1All=month1All+month1;
			float month2=getDepartmentReceipt(cj2,omId);
			month2All=month2All+month2;
			float month3=getDepartmentReceipt(cj3,omId);
			month3All=month3All+month3;
			
			result.add(month1);
			result.add(month2);
			result.add(month3);
			resultList.add(result);
			
			DepartmentTarget mt=dtService.selectDepartmentTargetByOmIdAndYear(omId, year3);
			float mbMonth1=0;
			if(mt!=null){
				mbMonth1=mt.getCollectionTarget();
			}
			mbMonth1All=mbMonth1All+mbMonth1;
			
			DepartmentTarget mt2=dtService.selectDepartmentTargetByOmIdAndYear(omId, year2);
			float mbMonth2=0;
			if(mt2!=null){
				mbMonth2=mt2.getCollectionTarget();
			}
			mbMonth2All=mbMonth2All+mbMonth2;
			
			DepartmentTarget mt3=dtService.selectDepartmentTargetByOmIdAndYear(omId, year);
			float mbMonth3=0;
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
	
	public float getMbContractMoney(List<MonthTarget> mt){
		float money=0;
		if(mt!=null){
			for(int jj=0;jj<mt.size();jj++){
				float contractAmount=mt.get(jj).getContractAmount();
				money=money+contractAmount;
			}
		}
		return money;
	}
	
	public float getMbIncome(List<MonthTarget> mt){
		float money=0;
		if(mt!=null){
			for(int jj=0;jj<mt.size();jj++){
				float income=mt.get(jj).getRevenueTarget();
				money=money+income;
			}
		}
		return money;
	}
	
	public float getMbReceipt(List<MonthTarget> mt){
		float money=0;
		if(mt!=null){
			for(int jj=0;jj<mt.size();jj++){
				float receipt=mt.get(jj).getCollectionTarget();
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

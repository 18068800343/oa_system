/**
 * <p>Title: StatisticsController.java</p>
 * <p>Description: 华通桥涵管理系统</p>
 * <p>Company: 环水信息技术有限公司</p>
 * @author 马潇霄
 * @version 1.0 创建时间：2018年12月13日 下午4:41:53
 */

package org.ldxx.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.CjContract;
import org.ldxx.bean.MonthTarget;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.dao.CjContractDao;
import org.ldxx.service.CjContractService;
import org.ldxx.service.FinancialReceiptsService;
import org.ldxx.service.MonthTargetService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.OtherContractService;
import org.ldxx.service.PrjProgressFillService;
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

	@RequestMapping("/initGsContract")
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
	
	
	@RequestMapping("/initDepartmentContract")
	@ResponseBody
	public Map<String,Object> initDepartmentContract(){
		Map<String,Object> map=new HashMap<>();
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
			
			float totalIncomeAll=pService.selectThisTimeIncomeByDepartment(omName, time);//部门本期累计收入
			float receiptAll=0;//部门本期累计收款
			List<CjContract> cj2=fService.selectResultMoneyByCjAndTime(time);
			if(cj2!=null){
				for(int j=0;j<cj2.size();j++){
					
				}
			}
			
		}
		return map;
	}
	
}

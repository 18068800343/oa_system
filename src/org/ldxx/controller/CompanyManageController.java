/**
 * <p>Title: CompanyManageController.java</p>
 * <p>Description: 华通桥涵管理系统</p>
 * <p>Company: 环水信息技术有限公司</p>
 * @author 马潇霄
 * @version 1.0 创建时间：2018年12月10日 下午1:54:29
 */

package org.ldxx.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.CjContract;
import org.ldxx.bean.CompanyManage;
import org.ldxx.bean.DepartmentTarget;
import org.ldxx.bean.FinancialReceipts;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.PrjProgressFill;
import org.ldxx.bean.PrjProgressFillInfo;
import org.ldxx.service.CjContractService;
import org.ldxx.service.DepartmentTargetService;
import org.ldxx.service.FinancialReceiptsService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.PrjProgressFillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
* @ClassName: CompanyManageController 
* @Description: 公司经营情况
* @author zhaohui
* @date 2018年12月10日 下午1:54:29 
*  
*/
@Controller
@RequestMapping("/CompanyManage")
public class CompanyManageController {

	@Autowired
	private PrjProgressFillService pService;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private DepartmentTargetService dService;
	@Autowired
	private CjContractService cService;
	@Autowired
	private FinancialReceiptsService fService;
	
	@RequestMapping("/selectCompanyManage")
	@ResponseBody
	public Map<String,Object> selectCompanyManage(String endTime){
		Map<String,Object> map=new HashMap<String, Object>();
		List<CompanyManage> list=new ArrayList<>();
		String year=endTime.split("-")[0];
		String y=year+"%";
		String startTime=year+"-01-01 00:00:01";
		endTime=endTime+" 23:59:59";
		
		 List<OrganizationManagement> om=oService.selectProductionDepartment();
		 
		 try {
			for(int i=0;i<om.size();i++){
				 String omName=om.get(i).getOmName();
				 String omId=om.get(i).getOmId();
				 List<PrjProgressFill> ppf=pService.selectDepartmentIncome(omName, startTime, endTime);
				 float totalAccomplish=0;//累计完成收入
				 if(ppf!=null){
					 for(int j=0;j<ppf.size();j++){
						 /*float inCome=ppf.get(j).getAllIncome();//总实际收入*/
						 float inCome=0;
						 String thisTimePercentage=ppf.get(j).getAllMoney();//本期收入比例
						 thisTimePercentage=thisTimePercentage.replace("%", "");
						 float Percentage=Float.valueOf(thisTimePercentage)/100;
						 totalAccomplish=totalAccomplish+inCome*Percentage;
					 }
				 }
				 DepartmentTarget dt=dService.selectDepartmentTargetByOmIdAndYear(omId, year);
				 float revenueTarget=0;//收入目标
				 float contractAmount=0;//合同额目标
				 if(dt!=null){
					 revenueTarget=dt.getRevenueTarget();//收入目标
					 contractAmount=dt.getContractAmount();//合同额目标
				 }
				 float finish=(totalAccomplish/revenueTarget)*100;
				 String finishStr=Math.round(finish)+"%";//完成百分比
				 
				 List<CjContract> cj=cService.selectNoAndMoneyByDepartment(omId,y);
				 float allContractMoney=0;//累计合同金额
				 float temporaryMoney=0;//暂定金
				 float moneyReceipt=0;//本年度已收款
				 float moneyReceiptAll=0;//合同已收款
				 float accruedAssets=0;//未收款
				 for(int ii=0;ii<cj.size();ii++){
					 float cMoney=cj.get(ii).getContractMoney();
					 allContractMoney=allContractMoney+cMoney;
					 float zdMoney=cj.get(ii).getTemporaryMoney();
					 temporaryMoney=temporaryMoney+zdMoney;
					 String contractNo=cj.get(ii).getContractNo();
					 FinancialReceipts fr=fService.selectResultMoney(contractNo,y);
					 float resultMoney=0;
					 if(fr!=null){
						 resultMoney=fr.getResultMoney();//本年度累计总收款
					 }
					 moneyReceipt=moneyReceipt+resultMoney;
					 FinancialReceipts fr2=fService.selectResultMoneyAll(contractNo);
					 float resultMoneyAll=0;
					 if(fr2!=null){
						 resultMoneyAll=fr2.getResultMoney();//合同累计总收款
					 }
					 moneyReceiptAll=moneyReceiptAll+resultMoneyAll;
				 }
				 accruedAssets=allContractMoney-moneyReceiptAll;
				 PrjProgressFillInfo ppfi=pService.selectYearCostByDepartment(omName, y);
				 float cost=0;
				 if(ppfi!=null){
					 cost=Float.valueOf(ppfi.getMoney());//年度累计部门成本
				 }
				 CompanyManage cm=new CompanyManage();
				 cm.setDepartmentName(omName);
				 cm.setTotalAccomplish(totalAccomplish);
				 cm.setTargetRevenues(revenueTarget);
				 cm.setPercentage(finishStr);
				 cm.setMoneyReceipt(moneyReceipt);
				 cm.setAccruedAssets(accruedAssets);
				 cm.setCost(cost);
				 cm.setNewContractAmount(allContractMoney);
				 cm.setContractZdMoney(temporaryMoney);
				 cm.setContractTargetMoney(contractAmount);
				 list.add(cm);
			 }
			map.put("list", list);
			if(list.size()>0){
				map.put("result", "success");
			}else{
				map.put("result", "nothing");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			map.put("result", "error");
		}
		return map;
	}
	
}

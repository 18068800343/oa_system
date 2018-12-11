/**
 * <p>Title: CompanyManageController.java</p>
 * <p>Description: 华通桥涵管理系统</p>
 * <p>Company: 环水信息技术有限公司</p>
 * @author 马潇霄
 * @version 1.0 创建时间：2018年12月10日 下午1:54:29
 */

package org.ldxx.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.CjContract;
import org.ldxx.bean.DepartmentTarget;
import org.ldxx.bean.FinancialReceipts;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.PrjProgressFill;
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
		String year=endTime.split("-")[0];
		String startTime=year+"-01-01 00:00:01";
		endTime=endTime=" 23:59:59";
		
		 List<OrganizationManagement> om=oService.getOrgIdAndName();
		 
		 for(int i=0;i<om.size();i++){
			 String omName=om.get(i).getOmName();
			 String omId=om.get(i).getOmId();
			 List<PrjProgressFill> ppf=pService.selectDepartmentIncome(omName, startTime, endTime);
			 float totalAccomplish=0;//累计完成收入
			 if(ppf!=null){
				 for(int j=0;j<ppf.size();j++){
					 float inCome=ppf.get(j).getAllIncome();//总实际收入
					 String thisTimePercentage=ppf.get(j).getAllMoney();//本期收入比例
					 thisTimePercentage=thisTimePercentage.replace("%", "");
					 float Percentage=Float.valueOf(thisTimePercentage)/100;
					 totalAccomplish=totalAccomplish+inCome*Percentage;
				 }
			 }
			 DepartmentTarget dt=dService.selectDepartmentTargetByOmIdAndYear(omId, year);
			 float revenueTarget=dt.getRevenueTarget();//收入目标
			 float contractAmount=dt.getContractAmount();//合同额目标
			 float finish=(totalAccomplish/revenueTarget)*100;
			 String finishStr=Math.round(finish)+"%";//完成百分比
			 
			 List<CjContract> cj=cService.selectNoAndMoneyByDepartment(omId);
			 float allContractMoney=0;//累计合同金额
			 float moneyReceipt=0;//已收款
			 float accruedAssets=0;//未收款
			 for(int ii=0;ii<cj.size();ii++){
				 float cMoney=cj.get(ii).getContractMoney();
				 allContractMoney=allContractMoney+cMoney;
				 String contractNo=cj.get(ii).getContractNo();
				 FinancialReceipts fr=fService.selectResultMoney(contractNo);
				 float resultMoney=fr.getResultMoney();
				 moneyReceipt=moneyReceipt+resultMoney;
			 }
			 accruedAssets=allContractMoney-moneyReceipt;
		 }
		
		
		return map;
	}
	
}

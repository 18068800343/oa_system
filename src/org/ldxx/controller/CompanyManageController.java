/**
 * <p>Title: CompanyManageController.java</p>
 * <p>Description: 华通桥涵管理系统</p>
 * <p>Company: 环水信息技术有限公司</p>
 * @author 马潇霄
 * @version 1.0 创建时间：2018年12月10日 下午1:54:29
 */

package org.ldxx.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.AlreadyRenling;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.CompanyCost;
import org.ldxx.bean.CompanyManage;
import org.ldxx.bean.ContractUpdate;
import org.ldxx.bean.DepartmentTarget;
import org.ldxx.bean.FinancialReceipts;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.PrjProgressFill;
import org.ldxx.bean.PrjProgressFillInfo;
import org.ldxx.dao.CompanyCostDao;
import org.ldxx.service.AlreadySkInfoService;
import org.ldxx.service.CjContractService;
import org.ldxx.service.ContractUpdateService;
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
	@Autowired
	private ContractUpdateService cuService;
	@Autowired
	private AlreadySkInfoService aService;
	@Autowired
	private CompanyCostDao cDao;
	
	@RequestMapping("/selectCompanyManage")
	@ResponseBody
	public Map<String,Object> selectCompanyManage(String endTime) throws ParseException{
		Map<String,Object> map=new HashMap<String, Object>();
		List<CompanyManage> list=new ArrayList<>();
		String year=endTime.split("-")[0];
		String y=year+"%";
		String startTime=year+"-01-01 00:00:00";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		startTime=sdf.format(sdf.parse(startTime).getTime()-5000);
		endTime=endTime+" 23:59:59";
		
		 List<OrganizationManagement> om=oService.selectProductionDepartment();
		 
		 try {
			for(int i=0;i<om.size();i++){
				 String omName=om.get(i).getOmName();
				 String omId=om.get(i).getOmId();
				 
				 PrjProgressFill ppf=pService.selectTotalIncome(omName, startTime, endTime);
				 double totalAccomplish=0;
				 if(ppf!=null){
					 totalAccomplish=ppf.getAllMoneyYuan();//累计完成收入
				 }
				 
				 DepartmentTarget dt=dService.selectDepartmentTargetByOmIdAndYear(omId, year);
				 float revenueTarget=0;//收入目标
				 float contractAmount=0;//合同额目标
				 if(dt!=null){
					 revenueTarget=(float) dt.getRevenueTarget();//收入目标
					 contractAmount=(float) dt.getContractAmount();//合同额目标
				 }
				 double finish=(totalAccomplish/revenueTarget)*100;
				 String finishStr=Math.round(finish)+"%";//完成百分比
				 
				 ContractUpdate cu=cuService.selectDeptContractMoneyByStartAndEndTime(startTime, endTime, omId);
				 Double allContractMoney=cu.getMoney();//新签合同金额
				 
				 List<CjContract> cj=cService.selectNoAndMoneyByDepartment(omId,y);
				 float temporaryMoney=0;//暂定金
				 for(int ii=0;ii<cj.size();ii++){
					 float zdMoney=cj.get(ii).getTemporaryMoney();
					 temporaryMoney=temporaryMoney+zdMoney;
				 }
				 AlreadyRenling ar=aService.selectDeptRenlingByStartAndEndTime(startTime, endTime, omName);
				 double moneyReceipt=ar.getSkQuerenMoney();//已收款
				 double accruedAssets=allContractMoney-moneyReceipt;//未收款
				 
				 CompanyCost cc=cDao.selectDeptCostByStartAndEndTime(startTime, endTime, omName);
				 double cost=0;
				 if(cc!=null){
					 cost=cc.getMoney()+cc.getMoney2();//部门成本
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

package org.ldxx.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.BudgetFpplicationForm;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.ContractWork;
import org.ldxx.bean.FbContract;
import org.ldxx.bean.FbContractOverWj;
import org.ldxx.bean.Pay;
import org.ldxx.bean.PrjProgressFill;
import org.ldxx.bean.ProjectIntegrated;
import org.ldxx.bean.Task;
import org.ldxx.dao.CompanyCostDao;
import org.ldxx.dao.SecondCompanyCostDao;
import org.ldxx.service.AlreadySkInfoService;
import org.ldxx.service.BudgetFpplicationFormService;
import org.ldxx.service.CjContractService;
import org.ldxx.service.ContractPaymentService;
import org.ldxx.service.ContractWorkService;
import org.ldxx.service.FbContractOverWjService;
import org.ldxx.service.KpApplicationService;
import org.ldxx.service.PrjProgressFillService;
import org.ldxx.service.SubContractService;
import org.ldxx.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/ProjectIntegrated")
@Controller
public class ProjectIntegratedController {
	
	@Autowired
	private TaskService tService;
	@Autowired
	private CjContractService cService;
	@Autowired
	private BudgetFpplicationFormService bservice;
	@Autowired
	private ContractWorkService service;
	@Autowired
	private KpApplicationService kService;
	@Autowired
	private PrjProgressFillService pService;
	@Autowired
	private SubContractService sService;
	@Autowired
	private FbContractOverWjService fService;
	@Autowired
	private ContractPaymentService cpService;
	@Autowired
	private CompanyCostDao ccDao;
	@Autowired
	private SecondCompanyCostDao sccDao;
	@Autowired
	private AlreadySkInfoService asService;
	
	@RequestMapping("/selectProjectIntegrated")
	@ResponseBody
	public Map<String,Object> selectProjectIntegrated(String no){
		Map<String,Object> map=new HashMap<>();
		List<ProjectIntegrated> list=new ArrayList<ProjectIntegrated>();
		try {
			Task t=tService.selectIdByNo2(no);
			String prjName=t.getPrjName();
			String prjType=t.getPrjType2();
			String cjDepartment=t.getOmName();//承接主办部门
			String prjLeader=t.getMainPrjLeaderName();//项目负责人
			BigDecimal prjMoney= ((t.getPrjEstimateMoney()==null||"".equals(t.getPrjEstimateMoney()))?new BigDecimal(0):t.getPrjEstimateMoney());//项目金额
			BigDecimal contractMoney=(t.getContractMoney()==null||"".equals(t.getContractMoney()))?new BigDecimal(0):t.getContractMoney();//合同金额
			BigDecimal zdMoney=(t.getProvisionalSum()==null||"".equals(t.getProvisionalSum()))?new BigDecimal(0):t.getProvisionalSum();//暂定金
			BudgetFpplicationForm bff=bservice.getAllCost(no);
			BigDecimal ysCost=new BigDecimal(0);//项目预算
			if(bff!=null){
				 ysCost=bff.getAllCost();
			}
			
			PrjProgressFill pf=pService.selectAllCostAndJd(no);
			String prjJd="0%";
			if(pf!=null){
				prjJd=pf.getAllMoney();//项目进度
			}
			
			List<CjContract> cj=cService.selectCjContractByTaskNo(no);
			String contractName="";//承接合同名称
			String contractNo="";//承接合同编号
			BigDecimal htMoney=new BigDecimal(0);//承接合同金额
			BigDecimal cjZdMoney=new BigDecimal(0);//承接合同暂定金
			BigDecimal contractEndMoney=new BigDecimal(0);//结算金额
			BigDecimal allKp=new BigDecimal(0);//累计开票金额
			if(cj!=null&&cj.size()>0){
				contractName=cj.get(0).getContractName();
				contractNo=cj.get(0).getContractNo();
				htMoney=(cj.get(0).getContractMoney()==null||"".equals(cj.get(0).getContractMoney()))?new BigDecimal(0):cj.get(0).getContractMoney();
				cjZdMoney=(cj.get(0).getTemporaryMoney()==null||"".equals(cj.get(0).getTemporaryMoney()))?new BigDecimal(0):cj.get(0).getTemporaryMoney();
				ContractWork cw=service.getContractMoney(contractNo);
				if(cw!=null){
					contractEndMoney=(cw.getEndMoney()==null||"".equals(cw.getEndMoney()))?new BigDecimal(0):cw.getEndMoney();
				}
				allKp=kService.getAllMoney(contractNo, no);
			}
			
			BigDecimal allReceieveMoney=asService.getAllSkByTaskNo(no);	//累计收款
			BigDecimal cost1=ccDao.selectSumMoneyByNo(no);
			BigDecimal cost2=sccDao.selectSumMoneyByNo(no);
			BigDecimal prjCost=cost1.add(cost2);//项目成本
			
			ProjectIntegrated pi=new ProjectIntegrated();
			pi.setPrjNo(no);
			pi.setPrjName(prjName);
			pi.setContractNo(contractNo);
			pi.setContractName(contractName);
			pi.setPrjType2(prjType);
			pi.setPrjYs(ysCost);
			pi.setCjDepartment(cjDepartment);
			pi.setPrjLeader(prjLeader);
			pi.setWorkMoney(prjMoney);
			pi.setContractMoney(contractMoney);
			pi.setZdMoney(zdMoney);
			pi.setContractEndMoney(contractEndMoney);
			pi.setTotalKpMoney(allKp);
			pi.setTotalMoney(allReceieveMoney);
			pi.setPrjCost(prjCost);
			pi.setPrjPlan(prjJd);
			list.add(pi);
			
			List<FbContract> fb=sService.selectFbContractByTaskNo(no);
			if(fb.size()>0){
				list.clear();
				for(int ii=0;ii<fb.size();ii++){
					String fbName=fb.get(ii).getContractName();//分包合同名称
					String fbNo=fb.get(ii).getFbNo();//分包合同编号
					BigDecimal fbMoney=fb.get(ii).getContractMoney();//分包合同金额
					FbContractOverWj fw=fService.getFbOverMoney(fbNo);
					BigDecimal fbOverMoney=new BigDecimal(0);
					if(fw!=null){
						fbOverMoney=fw.getOverWorkMoney();//分包结算金额
					}
					Pay cp=cpService.getFbPayPlanAndMoney(fbNo);
					String fbPlan="0%";
					BigDecimal fbActualPay=new BigDecimal(0);
					if(cp!=null){
						fbPlan=cp.getFbContractSchedule();//分包进度
					}
					Pay p2=cpService.getTotalPayMoney(fbNo);
					fbActualPay=p2.getAlreadyAccumulateMoney();
					ProjectIntegrated pi2=new ProjectIntegrated();
					pi2.setPrjNo(no);
					pi2.setPrjName(prjName);
					pi2.setContractNo(contractNo);
					pi2.setContractName(contractName);
					pi2.setPrjType2(prjType);
					pi2.setPrjYs(ysCost);
					pi2.setCjDepartment(cjDepartment);
					pi2.setPrjLeader(prjLeader);
					pi2.setWorkMoney(prjMoney);
					pi2.setContractMoney(contractMoney);
					pi2.setZdMoney(zdMoney);
					pi2.setContractEndMoney(contractEndMoney);
					pi2.setTotalKpMoney(allKp);
					pi2.setTotalMoney(allReceieveMoney);
					pi2.setPrjCost(prjCost);
					pi2.setPrjPlan(prjJd);
					pi2.setFbName(fbName);
					pi2.setFbContractMoney(fbMoney);
					pi2.setFbEndMoney(fbOverMoney);
					pi2.setFbPlan(fbPlan);
					pi2.setPracticalFbPayMoney(fbActualPay);
					list.add(pi2);
				}
			}
			map.put("result", "success");
			map.put("list", list);
		} catch (Exception e) {
			map.put("result", "error");
			e.printStackTrace();
		}
		return map;
	}
}

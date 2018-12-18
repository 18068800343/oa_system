package org.ldxx.controller;

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
			String prjLeader=t.getMainPrjLeader();//项目负责人
			float prjMoney=t.getPrjEstimateMoney();//项目金额
			float contractMoney=t.getContractMoney();//合同金额
			float zdMoney=t.getProvisionalSum();//暂定金
			BudgetFpplicationForm bff=bservice.getAllCost(no);
			float ysCost=bff.getAllCost();//预算成本
			List<CjContract> cj=cService.selectContractByTaskNo(no);
			PrjProgressFill pf=pService.selectAllCostAndJd(no);
			String prjJd=pf.getAllMoney();//项目进度
			float prjCost=pf.getAllCost();//项目成本
			for(int i=0;i<cj.size();i++){
				String contractName=cj.get(i).getContractName();//承接合同名称
				String contractNo=cj.get(i).getContractNo();//承接合同编号
				float htMoney=cj.get(i).getContractMoney();//承接合同金额
				float cjZdMoney=cj.get(i).getTemporaryMoney();//承接合同暂定金
				ContractWork cw=service.getContractMoney(contractNo);
				float contractEndMoney=cw.getEndMoney();//合同结算金额
				float allReceieveMoney=cw.getAllReceieveMoney();//合同累计收款
				float allKp=kService.getAllMoney(contractNo, no);//累计开票金额
				List<FbContract> fb=sService.getFBNameAndNo2();
				for(int ii=0;ii<fb.size();ii++){
					String fbName=fb.get(ii).getContractName();//分包合同名称
					String fbNo=fb.get(ii).getFbNo();//分包合同编号
					float fbMoney=fb.get(ii).getContractMoney();//分包合同金额
					FbContractOverWj fw=fService.getFbOverMoney(fbNo);
					float fbOverMoney=0;
					if(fw!=null){
						fbOverMoney=fw.getOverWorkMoney();//分包结算金额
					}
					Pay cp=cpService.getFbPayPlanAndMoney(fbNo);
					String fbPlan="0%";
					float fbActualPay=0;
					if(cp!=null){
						fbPlan=cp.getFbContractSchedule();//分包进度
						/*fbActualPay=cp.getAlreadyAccumulateMoney();//分包实际累计付款金额*/	
				}
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
					pi.setFbName(fbName);
					pi.setFbContractMoney(fbMoney);
					pi.setFbEndMoney(fbOverMoney);
					pi.setFbPlan(fbPlan);
					pi.setPracticalFbPayMoney(fbActualPay);
					list.add(pi);
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

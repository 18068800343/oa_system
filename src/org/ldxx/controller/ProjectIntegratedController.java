package org.ldxx.controller;

import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.CjContract;
import org.ldxx.bean.ProjectIntegrated;
import org.ldxx.bean.Task;
import org.ldxx.service.BudgetFpplicationFormService;
import org.ldxx.service.CjContractService;
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
	
	@RequestMapping("/selectProjectIntegrated")
	@ResponseBody
	public List<ProjectIntegrated> selectProjectIntegrated(String no){
		List<ProjectIntegrated> list=new ArrayList<ProjectIntegrated>();
		Task t=tService.selectIdByNo2(no);
		String prjName=t.getPrjName();
		String prjType=t.getPrjType2();
		String cjDepartment=t.getName1();//承接主办部门
		String prjLeader=t.getMainPrjLeader();//项目负责人
		float prjMoney=t.getPrjEstimateMoney();//项目金额
		float contractMoney=t.getContractMoney();//合同金额
		float zdMoney=t.getProvisionalSum();//暂定金
		float ysCost=bservice.getAllCost(no);//预算成本
		List<CjContract> cj=cService.selectContractByTaskNo(no);
		for(int i=0;i<cj.size();i++){
			String contractName=cj.get(i).getContractName();//承接合同名称
			String contractNo=cj.get(i).getContractNo();//承接合同编号
			float htMoney=cj.get(i).getContractMoney();//承接合同金额
			float cjZdMoney=cj.get(i).getTemporaryMoney();//承接合同暂定金
			
		}
		return list;
	}
}

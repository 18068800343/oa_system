package org.ldxx.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ldxx.bean.ContractUpdate;
import org.ldxx.bean.Task;
import org.ldxx.dao.ContractUpdateDao;
import org.ldxx.dao.TaskDao;
import org.ldxx.service.ContractUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractUpdateServiceImpl implements ContractUpdateService{

	@Autowired
	private ContractUpdateDao dao;
	@Autowired
	private TaskDao taskDao;
	@Override
	public BigDecimal selectContractUpdateByPrjNoAndDept(String no, String dept) {
		ContractUpdate cu=dao.selectContractUpdateByPrjNoAndDept(no, dept);
		BigDecimal money=cu.getMoney();
		return money;
	}

	@Transactional
	@Override
	public int addContractUpdate(List<Task> task) {
		int i=0;
		List<ContractUpdate> cus=splitTask(task);
		for(int ii=0;ii<cus.size();ii++){
			ContractUpdate cu=dao.selectContractUpdateByPrjNoAndDept(cus.get(ii).getPrjNo(), cus.get(ii).getDept());
			BigDecimal sumMoney=cu.getMoney();
			BigDecimal resultMoney= (cus.get(ii).getMoney().subtract(sumMoney));
			cus.get(ii).setMoney(resultMoney);
		}
		i=dao.addContractUpdate(cus);
		return i; 
	}
	
	@Transactional
	@Override
	public int addContractUpdateMainTask(List<Task> task) {
		int i=0;
		List<ContractUpdate> cus=splitTask(task);
		for(int ii=0;ii<cus.size();ii++){
			ContractUpdate cu=dao.selectContractUpdateByPrjNoAndDept(task.get(0).getMainPrjNo(), cus.get(ii).getDept());
			BigDecimal sumMoney=cu.getMoney();
			BigDecimal resultMoney=cus.get(ii).getMoney().subtract(sumMoney);
			cus.get(ii).setMoney(resultMoney);
		}
		i=dao.addContractUpdate(cus);
		return i; 
	}
	
	@Transactional
	@Override
	public int addContractAndTaskUpdate(List<Task> task) {
		int i=0;
	/*	List<ContractUpdate> cus=splitTask(task);
		for(int ii=0;ii<cus.size();ii++){
			ContractUpdate cu=dao.selectContractUpdateByPrjNoAndDept(cus.get(ii).getPrjNo(), cus.get(ii).getDept());
			float sumMoney=cu.getMoney();
			float resultMoney=cus.get(ii).getMoney()-sumMoney;
			cus.get(ii).setMoney(resultMoney);
		}
		i=dao.addContractUpdate(cus);*/
		
		i=taskDao.updateTasksByHistory(task);
		return i; 
	}

	
	public List<ContractUpdate> splitTask(List<Task> task){
		List<ContractUpdate> cuList=new ArrayList<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		String year=sdf.format(new Date());
		for(int ii=0;ii<task.size();ii++){
			ContractUpdate cu=new ContractUpdate();
			cu.setPrjNo(task.get(ii).getPrjNo());
			cu.setDept(task.get(ii).getMainDepartment());
			cu.setMoney(task.get(ii).getMainDepartmentMoney());
			cu.setTime(year);
			cuList.add(cu);
			if(task.get(ii).getAssistDepartment1()!=null&&!task.get(ii).getAssistDepartment1().equals("")){
				ContractUpdate cu2=new ContractUpdate();
				cu2.setPrjNo(task.get(ii).getPrjNo());
				cu2.setDept(task.get(ii).getAssistDepartment1());
				cu2.setMoney(task.get(ii).getAssistDepartment1Money());
				cu2.setTime(year);
				cuList.add(cu2);
			}
			if(task.get(ii).getAssistDepartment2()!=null&&!task.get(ii).getAssistDepartment2().equals("")){
				ContractUpdate cu3=new ContractUpdate();
				cu3.setPrjNo(task.get(ii).getPrjNo());
				cu3.setDept(task.get(ii).getAssistDepartment2());
				cu3.setMoney(task.get(ii).getAssistDepartment2Money());
				cu3.setTime(year);
				cuList.add(cu3);
			}
			if(task.get(ii).getAssistDepartment3()!=null&&!task.get(ii).getAssistDepartment3().equals("")){
				ContractUpdate cu4=new ContractUpdate();
				cu4.setPrjNo(task.get(ii).getPrjNo());
				cu4.setDept(task.get(ii).getAssistDepartment3());
				cu4.setMoney(task.get(ii).getAssistDepartment3Money());
				cu4.setTime(year);
				cuList.add(cu4);
			}
		}
		return cuList;
	}
	

	@Override
	public ContractUpdate selectGsContractMoneyByTime(String time) {
		time="%"+time+"%";
		return dao.selectGsContractMoneyByTime(time);
	}

	@Override
	public ContractUpdate selectDeptContractMoneyByTime(String time, String dept) {
		time="%"+time+"%";
		return dao.selectDeptContractMoneyByTime(time, dept);
	}

	@Override
	public ContractUpdate selectDeptContractMoneyByTimeAndType(String time, String dept, String type) {
		time="%"+time+"%";
		type="%"+type+"%";
		return dao.selectDeptContractMoneyByTimeAndType(time, dept, type);
	}

	@Override
	public ContractUpdate selectDeptContractMoneyByStartAndEndTime(String start, String end, String dept) {
		return dao.selectDeptContractMoneyByStartAndEndTime(start, end, dept);
	}
	
	@Override
	public int addContractUpdateMainTaskchaifen(List<Task> task) {
			int i=0;
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
			String year=sdf.format(new Date());
			//拆分任务单子任务单contractUpdate列
			List<ContractUpdate> cus=splitTask(task);
			
			//拆分任务单主任务单contractUpdate列,对应子任务单金额的负数（0-Money）。
			List<ContractUpdate> cut=new ArrayList<ContractUpdate>();
			//创建主任务单对应原本的需要减少的负钱款
			Task mtask = taskDao.selectTaskPrjName(task.get(0).getMainPrjNo());
			ContractUpdate mcu =new ContractUpdate();			
			mcu.setPrjNo(mtask.getPrjNo());
			mcu.setDept(mtask.getMainDepartment());
			mcu.setTime(year);
			ContractUpdate m2cu=dao.selectContractUpdateByPrjNoAndDept(task.get(0).getMainPrjNo(), mcu.getDept());
			mcu.setMoney(mtask.getPrjEstimateMoney().subtract(m2cu.getMoney()));	
			cut.add(mcu);
			
			dao.addContractUpdate(cut);
			i=dao.addContractUpdate(cus);
			return i; 
		}
	public int addContractUpdate1(List<ContractUpdate> cu) {
		int i=0;
		i=dao.addContractUpdate(cu);
		return i; 
	}
}

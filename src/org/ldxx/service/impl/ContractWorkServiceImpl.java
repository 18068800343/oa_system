package org.ldxx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ContractWork;
import org.ldxx.bean.ContractWorkTask;
import org.ldxx.bean.Enterprise;
import org.ldxx.bean.Task;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.CjContractDao;
import org.ldxx.dao.ContractWorkDao;
import org.ldxx.dao.EnterpriseDao;
import org.ldxx.dao.TaskDao;
import org.ldxx.service.ContractWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractWorkServiceImpl implements ContractWorkService{

	@Autowired
	private ContractWorkDao dao;
	@Autowired
	private AccessoryDao adao;
	@Autowired
	private EnterpriseDao edao;
	@Autowired
	private TaskDao tdao;
	@Autowired
	private CjContractDao cDao;
	
	@Transactional
	@Override
	public int addContractWork(ContractWork work) {
		int i=dao.addContractWork(work);
		String id=work.getCwId();
		if(i>0){
			List<Accessory> accessory=work.getAccessory();
			if(accessory!=null&&accessory.size()!=0){
				i=adao.addAccessory(accessory);
			}
			/*List<Accessory> accessory1=work.getAccessory1();
			if(accessory1!=null){
				i=adao.addAccessory(accessory1);
			}*/
			List<Enterprise> enterprise=work.getEnterprise();
			if(enterprise!=null&&enterprise.size()!=0){
				for(int a=0;a<enterprise.size();a++){
					enterprise.get(a).seteId(id);
				}
				i=edao.addEnterprise(enterprise);
			}
			List<Task> task=work.getTaskArray();
			if(task!=null&&task.size()!=0){
				for(int j=0;j<task.size();j++){
					int count=dao.getCount(id,task.get(j).getPrjId());
					if(count<=0){
						i=dao.addContractWorkTask(task.get(j),id);
					}else{
						i=dao.updateContractWorkTask(task.get(j),id);
					}
				}
				
			}
			/*i=tdao.updateTasks(task);
			i=cDao.updateCjContractMoney(work.getCjContractCode(), work.getEndMoney());*/
		}
		return i;
	}

	@Override
	public List<ContractWork> selectContractWork(String type,String status) {
		return dao.selectContractWork(type,status);
	}
	public List<ContractWork> selectContractWork2(String type) {
		List<ContractWork> list = dao.selectContractWork2(type);
		return list;
	}

	@Override
	public ContractWork selectContractWorkByNo(String no) {
		return dao.selectContractWorkByNo(no);
	}

	@Override
	public ContractWork getContractMoney(String no) {
		return dao.getContractMoney(no);
	}

	@Override
	public ContractWork selectContractWorkByid(String id) {
		ContractWork c= dao.selectContractWorkByid(id);
		List<ContractWorkTask> contractWorkTasks = dao.selectContractWorkTaskBycwid(id);
		if(contractWorkTasks!=null&&contractWorkTasks.size()!=0){
			List<Task> taskArray = new ArrayList<>();
			for(int j=0;j<contractWorkTasks.size();j++){
				Task t=new Task();
				t.setPrjId(contractWorkTasks.get(j).getPrjId());
				t.setPrjNo(contractWorkTasks.get(j).getPrjNO());
				t.setPrjEstimateMoney(contractWorkTasks.get(j).getPrjEstimateMoney());
				t.setContractMoney(contractWorkTasks.get(j).getEndMoney());
				t.setMainDepartment(contractWorkTasks.get(j).getMainDepartment());
				t.setMainDepartmentMoney(contractWorkTasks.get(j).getMainDepartmentMoney());
				t.setMainDepartmentCost(contractWorkTasks.get(j).getMainDepartmentCost());
				t.setAssistDepartment1(contractWorkTasks.get(j).getAssistDepartment1());
				t.setAssistDepartment1Money(contractWorkTasks.get(j).getAssistDepartment1Money());
				t.setAssistDepartment1Cost(contractWorkTasks.get(j).getAssistDepartment1Cost());
				t.setAssistDepartment2(contractWorkTasks.get(j).getAssistDepartment2());
				t.setAssistDepartment2Money(contractWorkTasks.get(j).getAssistDepartment2Money());
				t.setAssistDepartment2Cost(contractWorkTasks.get(j).getAssistDepartment2Cost());
				t.setAssistDepartment3(contractWorkTasks.get(j).getAssistDepartment3());
				t.setAssistDepartment3Money(contractWorkTasks.get(j).getAssistDepartment3Money());
				t.setAssistDepartment3Cost(contractWorkTasks.get(j).getAssistDepartment3Cost());
				t.setOmName(contractWorkTasks.get(j).getOmName());
				t.setName1(contractWorkTasks.get(j).getName1());
				t.setName2(contractWorkTasks.get(j).getName2());
				t.setName3(contractWorkTasks.get(j).getName3());
				if(t!=null){
					taskArray.add(t);					
				}
				
			}
			c.setTaskArray(taskArray);
		}
		return c;
	}

	@Override
	public ContractWork selectContractWorkBytaskNoAndCno(String no, String type) {
		return dao.selectContractWorkBytaskNoAndCno(no,type);
	}

	@Transactional
	@Override
	public int updateContractWork2(ContractWork work) {
		int i=dao.updateContractWork2(work);
		String id=work.getCwId();
		if(i>0){
			List<Accessory> accessory=work.getAccessory();
			if(accessory!=null&&accessory.size()!=0){
				adao.addAccessory(accessory);
			}
			edao.deleteEnterprise(id);
			List<Enterprise> enterprise=work.getEnterprise();
			if(enterprise!=null&&enterprise.size()!=0){
				for(int a=0;a<enterprise.size();a++){
					enterprise.get(a).seteId(id);
				}
				edao.addEnterprise(enterprise);
			}
			List<Task> task=work.getTaskArray();
			if(task!=null&&task.size()!=0){
				for(int j=0;j<task.size();j++){
					int count=dao.getCount(id,task.get(j).getPrjId());
					if(count<=0){
						i=dao.addContractWorkTask(task.get(j),id);
					}else{
						i=dao.updateContractWorkTask(task.get(j),id);
					}
				}
			}
			/*
			tdao.updateTasks(task);
			cDao.updateCjContractMoney(work.getCjContractCode(), work.getEndMoney());*/
		}
		return i;
	}
	
	@Transactional
	@Override
	public int updateContractWork3(ContractWork work) {
		int i=dao.updateContractWork3(work);
		String id=work.getCwId();
		if(i>0){
			List<Accessory> accessory=work.getAccessory();
			if(accessory!=null&&accessory.size()!=0){
				adao.addAccessory(accessory);
			}
			edao.deleteEnterprise(id);
			List<Enterprise> enterprise=work.getEnterprise();
			if(enterprise!=null&&enterprise.size()!=0){
				for(int a=0;a<enterprise.size();a++){
					enterprise.get(a).seteId(id);
				}
				edao.addEnterprise(enterprise);
			}
			List<Task> task=work.getTaskArray();
			if(task!=null&&task.size()!=0){
				for(int j=0;j<task.size();j++){
					int count=dao.getCount(id,task.get(j).getPrjId());
					if(count<=0){
						i=dao.addContractWorkTask(task.get(j),id);
					}else{
						i=dao.updateContractWorkTask(task.get(j),id);
					}
				}
			}
			/*
			tdao.updateTasks(task);
			cDao.updateCjContractMoney(work.getCjContractCode(), work.getEndMoney());*/
		}
		return i;
	}

	@Override
	public List<ContractWork> selectContractWorkByprjNo(String pNo,String type) {
		return dao.selectContractWorkByprjNo(pNo,type);
	}

}

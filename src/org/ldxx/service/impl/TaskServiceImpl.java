package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Enterprise;
import org.ldxx.bean.Task;
import org.ldxx.dao.EnterpriseDao;
import org.ldxx.dao.TaskDao;
import org.ldxx.service.TaskService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskDao tdao;
	
	@Autowired
	private EnterpriseDao edao;
	
	@Transactional
	@Override
	public int addTask(Task task) {
		List<Enterprise> enterprise=task.getEnterprise();
		int i=tdao.addTask(task);
		if(i>0){
			for(int ii=0;ii<enterprise.size();ii++){
				enterprise.get(ii).seteId(task.getPrjId());
			}
			i=edao.addEnterprise(enterprise);
		}
		return i;
	}
	
	@Transactional
	@Override
	public int deleteTask(String id) {
		int i=edao.deleteEnterprise(id);
		if(i>0){
			i=tdao.deleteTask(id);
		}
		return i;
	}

	@Transactional
	@Override
	public int updateTask(Task task) {
		int i=edao.deleteEnterprise(task.getPrjId());
		List<Enterprise> enterprise=task.getEnterprise();
		for(int ii=0;ii<enterprise.size();ii++){
			enterprise.get(ii).seteId(task.getPrjId());
		}
		if(i>0){
			i=tdao.updateTask(task);
			if(i>0){
				i=edao.addEnterprise(task.getEnterprise());
			}
		}
		return i;
	}

	@Override
	public List<Task> selectTaskByStatus(String status) {
		return tdao.selectTaskByStatus(status);
	}

	@Override
	public Task selectTaskById(String id) {
		Task task=tdao.selectTaskById(id);
		List<Enterprise> enterprise=edao.selectEnterpriseById(id);
		task.setEnterprise(enterprise);
		return task;
	}

	@Override
	public List<Task> selectIdAndNameByStatus(String status) {
		return tdao.selectIdAndNameByStatus(status);
	}

	@Override
	public int typeCount() {
		return tdao.typeCount();
	}

	@Override
	public List<Task> selectTaskHistory(String no) {
		return tdao.selectTaskHistory(no);
	}

	@Override
	public Task selectCcNameByPrjId(String id) {
		return tdao.selectCcNameByPrjId(id);
	}

	@Override
	public List<Task> selectPrjNameAndWorkNo() {
		return tdao.selectPrjNameAndWorkNo();
	}

	@Override
	public Task selectTaskPrjName(String prjNo) {
		return tdao.selectTaskPrjName(prjNo);
	}

	@Override
	public Task selectTaskPrjNo(String prjName) {
		return tdao.selectTaskPrjNo(prjName);
	}

	@Override
	public Task selectNoByName(String name) {
		return tdao.selectNoByName(name);
	}

	@Override
	public Task selectIdByNo(String no) {
		return tdao.selectIdByNo(no);
	}

	@Override
	public Task selectNoByName2(String name) {
		return tdao.selectNoByName2(name);
	}

	@Override
	public Task selectIdByNo2(String no) {
		return tdao.selectIdByNo2(no);
	}

	@Override
	public List<Task> selectPrjandNoAndPrjMoney() {
		return tdao.selectPrjandNoAndPrjMoney();
	}

}

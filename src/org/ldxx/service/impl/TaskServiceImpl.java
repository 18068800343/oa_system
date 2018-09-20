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
		
		/*int i=edao.deleteEnterprise(task.getPrjId());
		List<Enterprise> enterprise=task.getEnterprise();
		for(int ii=0;ii<enterprise.size();ii++){
			enterprise.get(ii).seteId(task.getPrjId());
		}
		if(i>0){
			i=tdao.updateTask(task);
			if(i>0){
				i=edao.addEnterprise(task.getEnterprise());
			}
		}*/
		return 0;
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

}

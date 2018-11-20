package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Task;

public interface TaskService {

	public int addTask(Task task);
	
	public int deleteTask(String id);
	
	public int updateTask(Task task);
	
	public List<Task> selectTaskByStatus(String status);
	
	public Task selectTaskById(String id);

	public List<Task> selectIdAndNameByStatus(String status);
	
	public int typeCount();
	
	public List<Task> selectTaskHistory(String no);
	
	public Task selectCcNameByPrjId(String id);
	
	public List<Task> selectPrjNameAndWorkNo();
	
	public Task selectTaskPrjName(String prjNo);
	
	public Task selectTaskPrjNo(String prjName);
	
	public Task selectNoByName(String name);
	
	public Task selectIdByNo(String no);
	
	public Task selectIdByName(String name);
	
	public Task selectNoByName2(String name);
	
	public Task selectIdByNo2(String no);

	public List<Task> selectPrjandNoAndPrjMoney();

	public List<Task> selectPrjByprjlike(String no);

	public List<Task> selectPrjAndNo();
}

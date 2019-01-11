package org.ldxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Task;

public interface TaskService {

	public int addTask(Task task);
	
	public int deleteTask(String id);
	
	public int updateTask(Task task);
	
	public List<Task> selectTaskByStatus(String status,String startMin,String startMax,String endMin,String endMax,String mainDp,String xbDp,float prjMoneyMin,float prjMoneyMax,float contractMoneyMin,float contractMoneyMax,float zdMoneyMin,float zdMoneyMax);
	
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

	public Task selectIdByNameAndNo(String name, String no);
	
	public List<Task> getTaskIdNameNo();
	
	public List<Task> selectTaskByPrjType(String type,String time);
	
	public Task selectTaskByNoAndType(String type,String no);

	public int updateById(Task task);
	
	public Task selectPrjLeaderByPrjNo(String no);

	public int updateHistoryById(String id);
	
	public List<Task> selectTaskByCj();
}

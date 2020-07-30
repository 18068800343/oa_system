package org.ldxx.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Task;

public interface TaskService {

	public int addTask(Task task);
	
	public int deleteTask(String id);
	
	public int updateTask(Task task);
	
	public List<Task> selectTaskByStatus(String status,String startMin,String startMax,String endMin,String endMax,String mainDp,String xbDp,BigDecimal prjMoneyMin,BigDecimal prjMoneyMax,BigDecimal contractMoneyMin,BigDecimal contractMoneyMax,BigDecimal zdMoneyMin,BigDecimal zdMoneyMax);
	
	public List<Task> selectTaskByStatus2(String status);
	
	public Task selectTaskById(String id);

	public List<Task> selectIdAndNameByStatus(String status);
	
	public int typeCount(String year);
	
	public List<Task> selectTaskHistory(String no);
	
	public List<Task> selectTaskHistoryById(String no,String id);
	
	public Task selectCcNameByPrjId(String id);
	
	public List<Task> selectPrjNameAndWorkNo();
	
	public Task selectTaskPrjName(String prjNo);
	
	public Task selectTaskPrjNameLast(String prjNo);
	
	public Task selectTaskPrjNo(String prjName);
	
	public Task selectTaskByPrjNo(String prjNo);
	
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
	
	public int updateTasks(List<Task> task);

	public Task selectPrjJsMoneyByNo(String no);

	Task selectTaskAndTaskChildrenById(String id);

	public List<Task> selectTask(String mainDepartment);
	
	public int updateTaskNoById(String no,String id);
	
	public String CreateTaskNumOrder(String gs,String year,String type);
	
	public String selectIdByTaskNo(String prjNo);
	
	public int addReason(String id,String reason);

	public int updateXgDodateById(String id, String time);
}

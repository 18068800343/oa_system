package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Task;

public interface TaskDao {
	
	public int addTask(@Param("task")Task task);
	
	public int deleteTask(@Param("id")String id);
	
	public int updateTask(@Param("task")Task task);
	
	public List<Task> selectTaskByStatus(@Param("status") String status,@Param("startMin") String startMin,@Param("startMax") String startMax,@Param("endMin") String endMin,@Param("endMax") String endMax,@Param("mainDp") String mainDp,@Param("xbDp") String xbDp,@Param("prjMoneyMin") float prjMoneyMin,@Param("prjMoneyMax") float prjMoneyMax,@Param("contractMoneyMin") float contractMoneyMin,@Param("contractMoneyMax") float contractMoneyMax,@Param("zdMoneyMin") float zdMoneyMin,@Param("zdMoneyMax") float zdMoneyMax);
	
	public Task selectTaskById(@Param("id")String id);

	public List<Task> selectIdAndNameByStatus(@Param("status") String status);
	
	public int typeCount();
	
	public List<Task> selectTaskHistory(@Param("no")String no);
	
	public Task selectCcNameByPrjId(@Param("id")String id);
	
	public List<Task> selectPrjNameAndWorkNo();
	
	public Task selectTaskPrjName(@Param("prjNo")String prjNo);
	
	public Task selectTaskPrjNo(@Param("prjName")String prjName);
	
	public Task selectNoByName(@Param("name")String name);
	
	public Task selectIdByNo(@Param("no")String no);
	
	public Task selectIdByName(@Param("name")String name);
	
	public Task selectNoByName2(@Param("name")String name);
	
	public Task selectIdByNo2(@Param("no")String no);

	public List<Task> selectPrjandNoAndPrjMoney();

	public List<Task> selectPrjByprjlike(@Param("no")String no);

	public List<Task> selectPrjAndNo();

	public Task selectIdByNameAndNo(@Param("name")String name,@Param("no") String no);
	
	public List<Task> getTaskIdNameNo();//获取正在运行以及完结的任务单列表
	
	public List<Task> selectTaskByPrjType(@Param("type")String type,@Param("time")String time);
	
	public Task selectTaskByNoAndType(@Param("type")String type,@Param("no")String no);

	public int updateById(@Param("task")Task task);
	
	public Task selectPrjLeaderByPrjNo(@Param("no")String no);
}

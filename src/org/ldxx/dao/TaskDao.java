package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Task;

public interface TaskDao {
	
	public int addTask(@Param("task")Task task);
	
	public int deleteTask(@Param("id")String id);
	
	public int updateTask(@Param("task")Task task);
	
	public List<Task> selectTaskByStatus(@Param("status") String status,@Param("startMin") String startMin,@Param("startMax") String startMax,@Param("endMin") String endMin,@Param("endMax") String endMax,@Param("mainDp") String mainDp,@Param("xbDp") String xbDp,@Param("prjMoneyMin") Double prjMoneyMin,@Param("prjMoneyMax") Double prjMoneyMax,@Param("contractMoneyMin") Double contractMoneyMin,@Param("contractMoneyMax") Double contractMoneyMax,@Param("zdMoneyMin") Double zdMoneyMin,@Param("zdMoneyMax") Double zdMoneyMax);
	
	public List<Task> selectTaskByStatus2(@Param("status") String status);
	
	public List<Task> selectTaskTongjiByStatusAndDepart(@Param("departMentId") String departMentId,@Param("status")String status);
	
	public Task selectTaskById(@Param("id")String id);

	public List<Task> selectIdAndNameByStatus(@Param("status") String status);
	
	public int typeCount(@Param("year")String year);
	
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

	public int updateHistoryById(@Param("id")String id);

	public int updateHistoryNow(@Param("id")String id);
	
	public int updateImportanceById(@Param("id")String id,@Param("importance")String importance);
	
	public List<Task> selectTaskByCj();//承接合同选择项目列表(除去已选项目)
	
	public int updateTasks(@Param("task")List<Task> task);
	
	public int updateTasksByHistory(@Param("task")List<Task> task);

	public Task selectPrjJsMoneyByNo(@Param("no")String no);
	
	public int updateTaskMoneyByIdChaifen(@Param("prjMoney")Double prjMoney,@Param("contractMoney")Double contractMoney,@Param("id")String id);

	public Double getPrjEstimateMoneyByNo(@Param("mainPrjNo")String mainPrjNo);

	public List<Task> selectTaskAndTaskChildrenByMainPrjNo(@Param("mainPrjNo")String mainPrjNo, @Param("id")String id);

	public List<Task> selectlikeMainDepartment(@Param("mainDepartment")String mainDepartment);
	
	public int updateTaskNoById(@Param("no")String no,@Param("id")String id);
	
	public String CreateTaskNumOrder(@Param("gs")String gs,@Param("year")String year,@Param("type")String type);
	
	public String selectIdByTaskNo(@Param("prjNo")String prjNo);
	
	public int addReason(@Param("id")String id,@Param("reason")String reason);

	public List<Task> selectTask2(@Param("startMin") String startMin,@Param("startMax") String startMax,@Param("endMin") String endMin,@Param("endMax") String endMax,@Param("mainDp") String mainDp,@Param("xbDp") String xbDp,@Param("prjMoneyMin") Double prjMoneyMin,@Param("prjMoneyMax") Double prjMoneyMax,@Param("contractMoneyMin") Double contractMoneyMin,@Param("contractMoneyMax") Double contractMoneyMax,@Param("zdMoneyMin") Double zdMoneyMin,@Param("zdMoneyMax") Double zdMoneyMax,@Param("taskNo") String taskNo,@Param("lxdateMin") String lxdateMin,@Param("lxdateMax") String lxdateMax);

	public int updateXgDodateById(@Param("id")String id,@Param("time") String time);
}

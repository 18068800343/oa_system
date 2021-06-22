package org.ldxx.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.TDepartment;
import org.ldxx.bean.Task;
import org.ldxx.bean.Task2;

public interface Task2Dao {

	public int addTask2(@Param("t2")List<Task2> t2);
	
	public int addTask2One(@Param("t")Task2 t);
	
	public int deleteTask2All();
	
	public int updateTask2ById(Task2 t);
	
	public List<Task2> selectTask2();
	
	public int selectTask2CountByTaskNo(@Param("taskNo")String taskNo);
	
	public int deleteTask2(@Param("tId")String tId);

	public List<Task2> selectTask2ByYear(@Param("y")String y);

	public Task2 selectTask2ById(@Param("id")String id);

	public List<Task2> selectTask2ByNo(@Param("no")String no);

	public List<Task2> selectDistinctTask2();
	
	public String getBM2ManageTarget(String year);

	public int isCountBytNoAndDate(@Param("tNo")String tNo, @Param("date1")String date1,@Param("money")BigDecimal money);

	public int updateBytNoAndDate(@Param("xgt2") Task2 xgt2);
	
	public List<Task2> getSumMoneyByYear(@Param("year")String year);
	
}

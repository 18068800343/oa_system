package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Task;
import org.ldxx.bean.Task2;

public interface Task2Dao {

	public int addTask2(@Param("t2")List<Task2> t2);
	
	public int addTask2One(@Param("t")Task2 t);
	
	public List<Task2> selectTask2();
	
	public int selectTask2CountByTaskNo(@Param("taskNo")String taskNo);
	
	public int deleteTask2(@Param("no")String no);

	public List<Task2> selectTask2ByYear(@Param("y")String y);

	public Task2 selectTask2ById(@Param("id")String id);
	
}

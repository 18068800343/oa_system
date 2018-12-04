package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Task2;

public interface Task2Dao {

	public int addTask2(@Param("t2")List<Task2> t2);
	
	public List<Task2> selectTask2();
	
	public int deleteTask2(@Param("no")String no);

	public List<Task2> selectTask2ByYear(@Param("y")String y);
	
}

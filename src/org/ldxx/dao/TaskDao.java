package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Task;

public interface TaskDao {
	
	public int addTask(@Param("task")Task task);
	
	public int deleteTask(@Param("id")String id);
	
	public int updateTask(@Param("task")Task task);
	
	public List<Task> selectTaskByStatus(@Param("status") String status);
	
	public Task selectTaskById(@Param("id")String id);

	public List<Task> selectIdAndNameByStatus(@Param("status") String status);
}

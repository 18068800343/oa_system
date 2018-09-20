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
	
	public int typeCount(String type);
	
	public List<Task> selectTaskHistory(String no);
}

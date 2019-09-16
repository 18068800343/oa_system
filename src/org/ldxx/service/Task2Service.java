package org.ldxx.service;

import java.util.List;
import java.util.Map;

import org.ldxx.bean.Task2;


public interface Task2Service {

	public int addTask2(Map<String,Object> map);
	
	public List<Task2> selectTask2();
	
	public int deleteTask2(String no);

	public List<Task2> selectTask2ByYear(String y);

	int deleteTDepartmentIncomeById(String id);

	public Task2 selectTask2ById(String id);

	public List<Task2> selectTask2ByNo(String no);
	
	public String getBM2ManageTarget(String year);
}

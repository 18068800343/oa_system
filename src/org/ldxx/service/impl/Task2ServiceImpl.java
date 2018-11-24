package org.ldxx.service.impl;

import java.util.List;
import java.util.Map;

import org.ldxx.bean.TDepartment;
import org.ldxx.bean.Task2;
import org.ldxx.dao.TDepartmentDao;
import org.ldxx.dao.Task2Dao;
import org.ldxx.service.Task2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Task2ServiceImpl implements Task2Service{

	@Autowired
	private Task2Dao dao;
	@Autowired
	private TDepartmentDao tDao;

	@Transactional
	@Override
	public int addTask2(Map<String, Object> map) {
		List<Task2> t2=(List<Task2>) map.get("t2");
		List<TDepartment> td=(List<TDepartment>) map.get("department");
		int i=dao.addTask2(t2);
		if(i>0){
			i=tDao.addTDepartment(td);
		}
		return i;
	}

	@Override
	public List<Task2> selectTask2() {
		return dao.selectTask2();
	}

	@Transactional
	@Override
	public int deleteTask2(String no) {
		int i=dao.deleteTask2(no);
		if(i>0){
			i=tDao.deleteDepartmentByNo(no);
		}
		return i;
	}
	
	

	
}

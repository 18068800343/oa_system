package org.ldxx.service.impl;

import java.util.List;
import java.util.Map;

import org.ldxx.bean.TDepartment;
import org.ldxx.bean.Task;
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
		int k=0;
		for(Task2 task:t2){
			/*int i = dao.selectTask2CountByTaskNo(task.gettNo());
			if(i>0){
				
			}else{
				if(task.gettNo()!=null&&!"".equals(task.gettNo())){*/
					k=dao.addTask2One(task);
				//}
			//}
		}
		/*if(k>0){
			for(TDepartment tDepartment:td){
				int l = tDao.selectDepartmentCountByTNoAndDepart(tDepartment.gettNo(), tDepartment.getdName());
				if(l<=0){
					k=tDao.addTDepartmentOne(tDepartment);
				}
			}
		}*/
		return k;
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
	
	@Override
	public int deleteTDepartmentIncomeById(String id) {
		int i=tDao.deleteDepartmentInComeById(id);
		return i;
	}

	@Override
	public List<Task2> selectTask2ByYear(String y) {
		return dao.selectTask2ByYear(y);
	}

	@Override
	public Task2 selectTask2ById(String id) {
		return dao.selectTask2ById(id);
	}

	@Override
	public List<Task2> selectTask2ByNo(String no) {
		return dao.selectTask2ByNo(no);
	}
	
	

	
}

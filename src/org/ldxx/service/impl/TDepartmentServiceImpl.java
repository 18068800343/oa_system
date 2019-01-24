package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.TDepartment;
import org.ldxx.dao.TDepartmentDao;
import org.ldxx.service.TDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TDepartmentServiceImpl implements TDepartmentService{

	@Autowired
	private TDepartmentDao dao;
	
	@Override
	public int addTDepartment(List<TDepartment> td) {
		return dao.addTDepartment(td);
	}

	@Override
	public int updateIncome(List<TDepartment> td) {
		int i=0;
		for(TDepartment tDepartment:td){
			i=dao.updateIncomeOne(tDepartment);
			if(i>0){
				i=dao.addTDepartmentIncome(tDepartment);
			}
		}
		return i;
		
	}

	@Override
	public List<TDepartment> selectDepartment(String no) {
		return dao.selectDepartment(no);
	}

	@Override
	public int deleteDepartmentByNo(String no) {
		return dao.deleteDepartmentByNo(no);
	}

}

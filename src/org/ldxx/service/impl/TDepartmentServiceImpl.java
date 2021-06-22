package org.ldxx.service.impl;

import java.util.List;
import java.util.Map;

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
	public int updateIncome(Map<String,Object> map) {
		List<TDepartment> list = (List<TDepartment>) map.get("TDepartment");
		List<TDepartment> list2 = (List<TDepartment>) map.get("xgTDepartment");
		int i=0;
		i = dao.deleteIncome();
		for(TDepartment tDepartment:list){
		  i=dao.addTDepartmentIncome(tDepartment);
		}
//		for(TDepartment tDepartment2:list2){
//			  i=dao.updateTDepartmentIncomeBytNoAndDate(tDepartment2);
//			}
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

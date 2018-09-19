package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.MonthTarget;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.dao.MonthTargetDao;
import org.ldxx.dao.OrganizationManagementDao;
import org.ldxx.service.MonthTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonthTargetServiceImpl implements MonthTargetService{

	@Autowired
	private MonthTargetDao dao;
	
	@Autowired
	private OrganizationManagementDao odao;
	
	@Override
	public int addMonthTarget(List<MonthTarget> target) {
		return dao.addMonthTarget(target);
	}

	@Override
	public int updateMonthTarget(List<MonthTarget> target) {
		return dao.updateMonthTarget(target);
	}

	@Override
	public List<MonthTarget> selectMonthTargetById(String tId) {
		return dao.selectMonthTargetById(tId);
	}

	@Override
	public int orNotSplit(String id) {
		return dao.orNotSplit(id);
	}

	@Override
	public int ifTarget(String id) {
		int i=0;
		int a=dao.yearTargetCount(id);
		List<OrganizationManagement> list=odao.getOrgIdAndName();
		int b=list.size()*12;
		if(a==b){
			i=1;
		}
		return i;
	}

	@Override
	public List<MonthTarget> selectMonthTargetByMonthSum(String id, int month) {
		return dao.selectMonthTargetByMonthSum(id, month);
	}

}

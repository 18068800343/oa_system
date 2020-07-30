package org.ldxx.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.ldxx.bean.AllQuery;
import org.ldxx.dao.AllQueryDao;
import org.ldxx.service.AllQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllQueryServiceImpl implements AllQueryService {

	@Autowired
	AllQueryDao allQueryDao;
	@Override
	public List<AllQuery> selectAllQueryByTimeAndDepart(String year_Time, String month_time,String depart,String omName) {
		// TODO Auto-generated method stub
		return allQueryDao.selectAllQueryByTime(year_Time,depart,omName);
	}
	@Override
	public List<AllQuery> getQueryTable(String depart, String omName, BigDecimal seachCjMoneyMin, BigDecimal seachCjMoneyMax,
			String seachTimeMin, String seachTimeMax, String serchType,String serchYear) {
		return allQueryDao.getQueryTable(depart,omName,seachCjMoneyMin,seachCjMoneyMax,seachTimeMin,seachTimeMax,serchType,serchYear);
	}

}

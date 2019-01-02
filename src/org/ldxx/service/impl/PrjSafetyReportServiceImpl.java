package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.PrjSafetyReport;
import org.ldxx.dao.PrjSafetyReportDao;
import org.ldxx.service.PrjSafetyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrjSafetyReportServiceImpl implements PrjSafetyReportService{

	@Autowired
	private PrjSafetyReportDao dao;
	
	@Override
	public List<PrjSafetyReport> selectPrjSafetyReport(String time) {
		return dao.selectPrjSafetyReport(time);
	}

}

package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.PrjSafetyReport;

public interface PrjSafetyReportService {

	public List<PrjSafetyReport> selectPrjSafetyReport(String time);
}

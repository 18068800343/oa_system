package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.PrjReport;

public interface PrjReportService {

	List<PrjReport> selectPrjReport(String prType);

	int addPrjReportSave(PrjReport prjReport);

	List<Accessory> selectAccessoryById(String id);

	int deleteAccessoryByIdAndName(Accessory accessory);

	int deletePrjReport(String id);

	int updatePrjReportSave(PrjReport prjReport);

}

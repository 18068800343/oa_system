package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.clfbCgcontractPerformance;

public interface MaterialPerformanceService {

	List<clfbCgcontractPerformance> selectmaterialPerformanceByStatus(String status);

	int pNocount();

	int addmaterialPerformanceSave(clfbCgcontractPerformance c);

	void updateHistoryById(String pId);

	List<Accessory> selectAccessoryById(String id);

	int deleteAccessoryByIdAndName(Accessory accessory);

	List<clfbCgcontractPerformance> selectHistoryByNo(String no);

}

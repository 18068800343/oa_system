package org.ldxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Accessory;
import org.ldxx.bean.clfbCgcontractPerformance;

public interface MaterialPerformanceService {

	List<clfbCgcontractPerformance> selectmaterialPerformanceByStatus(String status);

	int addmaterialPerformanceSave(clfbCgcontractPerformance c);

	List<Accessory> selectAccessoryById(String id);

	int deleteAccessoryByIdAndName(Accessory accessory);

	clfbCgcontractPerformance selectmaterialPerformanceById(String id);
	
	int updateMaterialPerformance(clfbCgcontractPerformance c);

}

package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.clfbCgcontractPerformance;

public interface MaterialPerformanceDao {

	List<clfbCgcontractPerformance> selectmaterialPerformanceByStatus(@Param("status")String status);

	int addmaterialPerformanceSave(@Param("c")clfbCgcontractPerformance c);

	clfbCgcontractPerformance selectmaterialPerformanceById(@Param("id")String id);
	
	int updateMaterialPerformance(@Param("c")clfbCgcontractPerformance c);

	List<clfbCgcontractPerformance> selectmaterialPerformanceByStatus2();

}

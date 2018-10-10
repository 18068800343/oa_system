package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.clfbCgcontractPerformance;

public interface MaterialPerformanceDao {

	List<clfbCgcontractPerformance> selectmaterialPerformanceByStatus(@Param("status")String status);

	int pNocount();

	int addmaterialPerformanceSave(@Param("c")clfbCgcontractPerformance c);

	void updateHistoryById(@Param("pId")String pId);

	List<clfbCgcontractPerformance> selectHistoryByNo(@Param("no")String no);

}

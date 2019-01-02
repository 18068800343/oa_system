package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.PrjSafetyReport;

public interface PrjSafetyReportDao {

	public List<PrjSafetyReport> selectPrjSafetyReport(@Param("time")String time);
}

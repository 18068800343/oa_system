package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.PrjReport;

public interface PrjReportDao {

	List<PrjReport> selectPrjReport(@Param("prType")String prType);

	int addPrjReportSave(@Param("prjReport")PrjReport prjReport);

	int deletePrjReport(@Param("id")String id);

	int updatePrjReportSave(@Param("prjReport")PrjReport prjReport);

}

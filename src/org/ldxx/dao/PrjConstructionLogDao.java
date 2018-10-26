package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.PrjConstructionLog;

public interface PrjConstructionLogDao {

	List<PrjConstructionLog> selectPrjConstructionLog();

	int addPrjConstructionLogSave(@Param("prjLog")PrjConstructionLog prjLog);

	int deletePrjConstructionLog(@Param("id")String id);

	int updatePrjConstructionLogSave(@Param("prjLog")PrjConstructionLog prjLog);

}

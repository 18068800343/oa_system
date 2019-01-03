package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.PrjConstructionLog;
import org.ldxx.bean.PrjConstructionLogInfo;

public interface PrjConstructionLogService {

	List<PrjConstructionLog> selectPrjConstructionLog();

	int addPrjConstructionLogSave(PrjConstructionLog prjLog);

	int deletePrjConstructionLog(String id);

	int updatePrjConstructionLogSave(PrjConstructionLog prjLog);

	List<PrjConstructionLogInfo> selectPrjConstructionLogInfoById(String id);

}

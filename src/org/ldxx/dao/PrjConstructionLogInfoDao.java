package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.PrjConstructionLogInfo;

public interface PrjConstructionLogInfoDao {

	int addrjConstructionLogInfo(@Param("prjLogInfo")List<PrjConstructionLogInfo> prjLogInfo);

	int deletePrjConstructionLogInfo(@Param("id")String id);

	List<PrjConstructionLogInfo> selectPrjConstructionLogInfoById(@Param("id")String id);

}

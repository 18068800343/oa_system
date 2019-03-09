package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.PrjRecord;

public interface PrjRecordDao {

	public int addPrjRecord(@Param("pr")PrjRecord pr);
	
	public List<PrjRecord> selectPrjRecord();
}

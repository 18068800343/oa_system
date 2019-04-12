package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.PrjRecord;

public interface PrjRecordDao {

	public int addPrjRecord(@Param("pr")PrjRecord pr);
	
	public List<PrjRecord> selectPrjRecord();
	
	public int updateJyStatus(@Param("id")String id,@Param("status")int status);
	
	public int updateScStatus(@Param("id")String id,@Param("status")int status);
	
	public int prjCount(@Param("no")String no);
}

package org.ldxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.PrjRecord;

public interface PrjRecordService{

	public int addPrjRecord(PrjRecord pr);
	
	public List<PrjRecord> selectPrjRecord();
	
	public int updateJyStatus(String id,int status);
	
	public int updateScStatus(String id,int status);
	
	public int prjCount(String no);
}

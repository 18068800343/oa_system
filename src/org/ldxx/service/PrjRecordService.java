package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.PrjRecord;

public interface PrjRecordService{

	public int addPrjRecord(PrjRecord pr);
	
	public List<PrjRecord> selectPrjRecord();
}

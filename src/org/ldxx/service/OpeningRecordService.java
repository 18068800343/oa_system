package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.OpeningRecord;

public interface OpeningRecordService {

	List<OpeningRecord> selectOpeningRecord();

	int addOpeningRecordSave(OpeningRecord record);

	int updateOpeningRecordSave(OpeningRecord record);

	OpeningRecord selectOpeningRecordById(String id);
	
	int addOpeningRecord(OpeningRecord record);

}

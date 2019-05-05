package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.OpeningRecord;

public interface OpeningRecordDao {

	List<OpeningRecord> selectOpeningRecord();

	int addOpeningRecordSave(@Param("record")OpeningRecord record);

	int updateOpeningRecordSave(@Param("record")OpeningRecord record);

	OpeningRecord selectOpeningRecordById(@Param("id")String id);
	
	int addOpeningRecord(@Param("record")List<OpeningRecord> record);
	
	int updateIsQibiao(@Param("isQibiao")String isQibiao,@Param("orId")String orId);
	
	int updateIsLiubiao(@Param("isLiubiao")String isLiubiao,@Param("orId")String orId);
	
}

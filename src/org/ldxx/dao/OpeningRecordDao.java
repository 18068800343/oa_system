package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.OpeningRecord;

public interface OpeningRecordDao {

	List<OpeningRecord> selectOpeningRecord(@Param("status")String status);

	int addOpeningRecordSave(@Param("record")OpeningRecord record);

	int updateOpeningRecordSave(@Param("record")OpeningRecord record);

	OpeningRecord selectOpeningRecordById(@Param("id")String id);

}

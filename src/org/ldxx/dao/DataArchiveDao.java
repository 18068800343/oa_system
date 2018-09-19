package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.DataArchive;

public interface DataArchiveDao {

	public int addDataArchive(@Param("archive")DataArchive archive);
	
	public int deleteDataArchive(@Param("id")String id);
	
	public int updateDataArchive(@Param("archive")DataArchive archive);
	
	public List<DataArchive> selectDataArchive();
}

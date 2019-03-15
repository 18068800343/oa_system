package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.OtherFile;


public interface OtherFileDao {

	public int deleteOtherFileById(@Param("id")String id);
	
	public int insertOtherFile(@Param("file")OtherFile otherFile);
	
	public List<OtherFile> selectAllOhterFile();
	
	public OtherFile selectOtherFileById(@Param("id")String id);
}

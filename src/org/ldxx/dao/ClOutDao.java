package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ClOut;
import org.ldxx.bean.ClOutInfo;

public interface ClOutDao {

	public int addClOut(@Param("out")ClOut out);
	
	public int addClOutInfo(@Param("cInfo")List<ClOutInfo> cInfo);
	
	public List<ClOut> selectClOutByNo(@Param("no")String no,@Param("useromId") String useromId);
	
	public List<ClOutInfo> selectClOutInfoById(@Param("id")String id);
}

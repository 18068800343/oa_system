package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.LianYing;
import org.ldxx.bean.LianYingHeSuan;

public interface LianYingDao {
	
	public int addLianYing(@Param("ly")LianYing ly);
	
	public List<LianYing> selectLianYingByStatus(@Param("status")String status);
	
	public LianYing selectLianYingById(@Param("id")String id);
	
	public int lyNoCount(@Param("year")String year);
	
	public LianYing selectLianYingByNo(@Param("no")String no);
	
	public int addLianYingHeSuan(@Param("hs")LianYingHeSuan hs);
	
	public List<LianYingHeSuan> selectLianYingHeSuan();
	
	public int updateLianYing(@Param("ly")LianYing ly);
	
	public int updateLyNoById(@Param("id")String id,@Param("no")String no);

	public LianYing getLianYingBylyNo(@Param("no")String no);

	public List<LianYing> selectLianYing2();

}

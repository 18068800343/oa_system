package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.LianYing;

public interface LianYingDao {
	
	public int addLianYing(@Param("ly")LianYing ly);
	
	public List<LianYing> selectLianYingByStatus(@Param("status")String status);
	
	public LianYing selectLianYingById(@Param("id")String id);

}
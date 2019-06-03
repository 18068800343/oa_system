package org.ldxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.LianYing;
import org.ldxx.bean.LianYingHeSuan;

public interface LianYingService {

	public int addLianYing(LianYing ly);
	
	public List<LianYing> selectLianYingByStatus(String status);
	
	public LianYing selectLianYingById(String id);
	
	public int lyNoCount(String year);
	
	public LianYing selectLianYingByNo(String no);
	
	public int addLianYingHeSuan(LianYingHeSuan hs);
	
	public List<LianYingHeSuan> selectLianYingHeSuan();
	
	public int updateLianYing(LianYing ly);
	
	public int updateLyNoById(String id,String no);

	public LianYing getLianYingBylyNo(String no);

	public List<LianYing> selectLianYing2();
}

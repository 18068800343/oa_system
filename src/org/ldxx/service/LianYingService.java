package org.ldxx.service;

import java.util.List;

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
}

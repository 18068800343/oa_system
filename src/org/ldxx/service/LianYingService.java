package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.LianYing;

public interface LianYingService {

	public int addLianYing(LianYing ly);
	
	public List<LianYing> selectLianYingByStatus(String status);
	
	public LianYing selectLianYingById(String id);
}

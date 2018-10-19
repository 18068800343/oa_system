package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.ClRemain;

public interface ClRemainService {

	public int addClRemain(List<ClRemain> cr);
	
	public List<ClRemain> selectClRemainById(String id);
}

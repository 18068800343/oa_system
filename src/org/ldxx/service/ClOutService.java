package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.ClOut;

public interface ClOutService {

	public int addClOut(ClOut out);
	
	public List<ClOut> selectClOut();
}

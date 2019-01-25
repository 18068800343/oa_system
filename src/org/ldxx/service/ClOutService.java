package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.ClOut;
import org.ldxx.bean.ClOutInfo;

public interface ClOutService {

	public int addClOut(ClOut out);
	
	public List<ClOut> selectClOutByNo(String no, String useromId);
	
	public List<ClOutInfo> selectClOutInfoById(String id);
}

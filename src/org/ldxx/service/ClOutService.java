package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.ClOut;

public interface ClOutService {

	public int addClOut(List<ClOut> out);
	
	public List<ClOut> selectClOutByNo(String no);
	
	public List<ClOut> selectClByNoAndTimeAndPerson(String no,String time,String person);
}

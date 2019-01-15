package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.AlreadyRenling;

public interface AlreadySkInfoService {

	int addAlreadyRenling(AlreadyRenling ar);

	AlreadyRenling getyirenlingfpMoneyByKpno(String kpno);

	List<AlreadyRenling> selectAlreadyRenling();

	List<AlreadyRenling> selectAlreadySkBySkno(String skno);

	int deleteAlreadyRenlingById(String rId);
	
	public AlreadyRenling selectGsRenlingByTime(String time);
	
	public AlreadyRenling selectDeptRenlingByTime(String time,String dept);

}

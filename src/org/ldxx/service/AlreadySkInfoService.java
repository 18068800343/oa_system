package org.ldxx.service;

import java.math.BigDecimal;
import java.util.List;

import org.ldxx.bean.AlreadyRenling;

public interface AlreadySkInfoService {

	int addAlreadyRenling(AlreadyRenling ar);

	AlreadyRenling getyirenlingfpMoneyByKpno(String kpno);

	List<AlreadyRenling> selectAlreadyRenling(String seachPrjName, String seachMainDepartment);

	List<AlreadyRenling> selectAlreadySkBySkno(String skno);

	int deleteAlreadyRenlingById(String rId);
	
	public AlreadyRenling selectGsRenlingByTime(String time);
	
	public AlreadyRenling selectDeptRenlingByTime(String time,String dept);
	
	public AlreadyRenling selectDeptRenlingByTimeAndType(String time,String dept,String type);
	
	public AlreadyRenling selectDeptRenlingByStartAndEndTime(String start,String end,String dept);

	public BigDecimal getAllSkByTaskNo(String no);

	int buleFpNo(String id, String fpNo);
}

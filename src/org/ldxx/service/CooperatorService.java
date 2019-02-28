package org.ldxx.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Cooperator;

public interface CooperatorService {

	public int addCooperator(Cooperator cooperator);
	
	public int deleteCooperator(String id);
	
	public int updateCooperator(Cooperator cooperator);
	
	public List<Cooperator> selectAllCooperator();
	
	public Cooperator selectOneCooperator(String id);
	
	public List<Cooperator> selectCooperatorIdAndName();

	public Cooperator selectCooperatorByCcName(String name);
}

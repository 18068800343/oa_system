package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Cooperator;

public interface CooperatorDao {

	public int addCooperator(@Param("cooperator")Cooperator cooperator);
	
	public int deleteCooperator(@Param("id")String id);
	
	public int updateCooperator(@Param("cooperator")Cooperator cooperator);
	
	public List<Cooperator> selectAllCooperator();
	
	public Cooperator selectOneCooperator(@Param("id")String id);
	
	public List<Cooperator> selectCooperatorIdAndName();
	
	public List<Cooperator> selectCooperatorIdAndNameByCcType(@Param("ccType")String ccType);
	
	public Cooperator selectCooperatorByCcName(@Param("name")String name);
}

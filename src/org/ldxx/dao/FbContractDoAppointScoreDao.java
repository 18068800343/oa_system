package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FbContractDoAppointScore;

public interface FbContractDoAppointScoreDao {

	public int addFbContractDoAppointScore(@Param("fb")FbContractDoAppointScore FbContractDoAppoint);
	
	public List<FbContractDoAppointScore> selectFbContractDoAppointScore(@Param("state")String state,@Param("depart")String depart,@Param("thisYear") String thisYear);
	
	public List<FbContractDoAppointScore> selectFbContractDoAppointScore2();
	
	public FbContractDoAppointScore selectFbContractDoAppointScoreById(@Param("id")String id);
	
	public int updateFbContractDoAppointScore(@Param("fb")FbContractDoAppointScore FbContractDoAppoint);
	
}

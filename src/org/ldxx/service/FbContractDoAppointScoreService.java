package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.FbContractDoAppointScore;

public interface FbContractDoAppointScoreService {

	public int addFbContractDoAppointScore(FbContractDoAppointScore FbContractDoAppoint);
	
	public FbContractDoAppointScore selectFbContractDoAppointScoreById(String id);
	
	public int updateFbContractDoAppointScore(FbContractDoAppointScore FbContractDoAppoint);

	List<FbContractDoAppointScore> selectFbContractDoAppointScore(String state, String depart, String thisYear);
	List<FbContractDoAppointScore> selectFbContractDoAppointScore2();
}

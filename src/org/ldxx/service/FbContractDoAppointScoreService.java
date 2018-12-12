package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.FbContractDoAppointScore;

public interface FbContractDoAppointScoreService {

	public int addFbContractDoAppointScore(FbContractDoAppointScore FbContractDoAppoint);
	
	public List<FbContractDoAppointScore> selectFbContractDoAppointScore(String state);
}

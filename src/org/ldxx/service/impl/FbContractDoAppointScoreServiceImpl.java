package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.FbContractDoAppointScore;
import org.ldxx.dao.FbContractDoAppointScoreDao;
import org.ldxx.service.FbContractDoAppointScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FbContractDoAppointScoreServiceImpl implements FbContractDoAppointScoreService{

	@Autowired
	private FbContractDoAppointScoreDao dao;
	
	@Override
	public int addFbContractDoAppointScore(FbContractDoAppointScore FbContractDoAppoint) {
		return dao.addFbContractDoAppointScore(FbContractDoAppoint);
	}

	@Override
	public List<FbContractDoAppointScore> selectFbContractDoAppointScore(String state) {
		return dao.selectFbContractDoAppointScore(state);
	}

	@Override
	public FbContractDoAppointScore selectFbContractDoAppointScoreById(String id) {
		return dao.selectFbContractDoAppointScoreById(id);
	}

}

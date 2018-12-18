package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.FbContractOverWj;

public interface FbContractOverWjService {

	public int addFbContractOverWj(FbContractOverWj fbContractOverWj);
	
	public List<FbContractOverWj> selectFbContractOverWj(String state);
	
	public FbContractOverWj getFbOverMoney(String no);
	
	public List<FbContractOverWj> getAllPayMoneyByFbNo(String no);
}

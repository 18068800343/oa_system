package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.FbContractOver;

public interface FbContractOverService {

	public int addFbContractOver(FbContractOver fbContractOver);
	
	public List<FbContractOver> selectFbContractOver(String state);
	
	public FbContractOver selectFbContractOverById(String id);
	
	public int updateFbContractOver(FbContractOver fbContractOver);

	public float selectFbJsMoneyByNo(String no);

	public List<FbContractOver> selectFbJsByNo(String no);
}

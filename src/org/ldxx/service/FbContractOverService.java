package org.ldxx.service;

import java.math.BigDecimal;
import java.util.List;

import org.ldxx.bean.FbContractOver;

public interface FbContractOverService {

	public int addFbContractOver(FbContractOver fbContractOver);
	
	public List<FbContractOver> selectFbContractOver(String state);
	
	public List<FbContractOver> selectFbContractOver2();
	
	public FbContractOver selectFbContractOverById(String id);
	
	public int updateFbContractOver(FbContractOver fbContractOver);

	public BigDecimal selectFbJsMoneyByNo(String no);

	public List<FbContractOver> selectFbJsByNo(String no);
}

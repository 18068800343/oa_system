package org.ldxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FbContractOverWj;

public interface FbContractOverWjService {

	public int addFbContractOverWj(FbContractOverWj fbContractOverWj);
	
	public List<FbContractOverWj> selectFbContractOverWj();
	
	public FbContractOverWj getFbOverMoney(String no);
}

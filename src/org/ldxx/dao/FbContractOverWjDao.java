package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FbContractOverWj;

public interface FbContractOverWjDao {

	public int addFbContractOverWj(@Param("fb")FbContractOverWj fbContractOverWj);
	
	public List<FbContractOverWj> selectFbContractOverWj(@Param("state")String state);
	
	public FbContractOverWj getFbOverMoney(@Param("no")String no);
	
	public List<FbContractOverWj> getAllPayMoneyByFbNo(@Param("no")String no);
	
	public FbContractOverWj selectFbContractOverWjById(@Param("id")String id);
}

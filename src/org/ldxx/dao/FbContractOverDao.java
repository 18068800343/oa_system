package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FbContractOver;

public interface FbContractOverDao {

	public int addFbContractOver(@Param("fb")FbContractOver fbContractOver);
	
	public List<FbContractOver> selectFbContractOver(@Param("state")String state);
	
	public List<FbContractOver> selectFbContractOver2();
	
	public FbContractOver selectFbContractOverById(@Param("id")String id);
	
	public int updateFbContractOver(@Param("fb")FbContractOver fbContractOver);

	public Double selectFbJsMoneyByNo(@Param("no")String no);

	public List<FbContractOver> selectFbJsByNo(@Param("no")String no);
}

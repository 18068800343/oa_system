package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FbContractOver;

public interface FbContractOverDao {

	public int addFbContractOver(@Param("fb")FbContractOver fbContractOver);
	
	public List<FbContractOver> selectFbContractOver();
}

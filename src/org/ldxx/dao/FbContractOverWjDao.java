package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FbContractOverWj;

public interface FbContractOverWjDao {

	public int addFbContractOverWj(@Param("fb")FbContractOverWj fbContractOverWj);
	
	public List<FbContractOverWj> selectFbContractOverWj();
}

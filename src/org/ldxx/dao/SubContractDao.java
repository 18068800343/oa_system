package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FbContract;

public interface SubContractDao {

	List<FbContract> selectSubContract(@Param("status")String status);

	int saveSubContract(@Param("fbContract")FbContract fbContract);

	int deleteSubContractById(@Param("id")String id);

	FbContract selectSubContractById(@Param("id")String id);

	int updateSubContract(@Param("fbContract")FbContract fbContract);

}

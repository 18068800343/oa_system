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

	List<FbContract> selectsubcontractHistory(@Param("fbNo")String fbNo);

	int fbNocount();

	void updateHistory(@Param("fbId")String fbId);

	List<FbContract> getFBNameAndNo();

	FbContract getFBNameByNo(@Param("fbNo")String fbNo);

	FbContract getFBNoByName(@Param("contractName")String contractName);

}

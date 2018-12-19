package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FbContract;

public interface SubContractDao {

	List<FbContract> selectSubContract(@Param("status")String status,@Param("startMin")String startMin,@Param("startMax")String startMax,@Param("endMin")String endMin,@Param("endMax")String endMax,@Param("mainDp")String mainDp,@Param("spType")String spType,@Param("fbMoneyMin")float fbMoneyMin,@Param("fbMoneyMax")float fbMoneyMax,@Param("contractMoneyMin")float contractMoneyMin,@Param("contractMoneyMax")float contractMoneyMax,@Param("zdMoneyMin")float zdMoneyMin,@Param("zdMoneyMax")float zdMoneyMax);

	int saveSubContract(@Param("fbContract")FbContract fbContract);

	int deleteSubContractById(@Param("id")String id);

	FbContract selectSubContractById(@Param("id")String id);

	int updateSubContract(@Param("fbContract")FbContract fbContract);

	List<FbContract> selectsubcontractHistory(@Param("fbNo")String fbNo);

	int fbNocount();

	List<FbContract> getFBNameAndNo();
	
	List<FbContract> getFBNameAndNo2();

	FbContract getFBNameByNo(@Param("fbNo")String fbNo);

	FbContract getFBNoByName(@Param("contractName")String contractName);

	FbContract getFBContractByName(@Param("contractName")String contractName);

	FbContract getFBContractByNo(@Param("no")String no);

	List<FbContract> getFbcjNo();

	List<FbContract> getFBNoBycjNo(@Param("no")String no);

	int updateHistoryById(@Param("id")String id);

	int updateHistoryNow(@Param("id")String id);


}

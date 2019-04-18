package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.FbCgContract;
import org.ldxx.bean.FbContract;

public interface SubContractDao2 {

	List<FbCgContract> selectSubContract(@Param("status")String status,@Param("startMin")String startMin,@Param("startMax")String startMax,@Param("endMin")String endMin,@Param("endMax")String endMax,@Param("mainDp")String mainDp,@Param("spType")String spType,@Param("fbMoneyMin")Double fbMoneyMin,@Param("fbMoneyMax")Double fbMoneyMax,@Param("contractMoneyMin")Double contractMoneyMin,@Param("contractMoneyMax")Double contractMoneyMax,@Param("zdMoneyMin")Double zdMoneyMin,@Param("zdMoneyMax")Double zdMoneyMax);

	int saveSubContract(@Param("fbContract")FbCgContract fbContract);

	int deleteSubContractById(@Param("id")String id);

	FbCgContract selectSubContractById(@Param("id")String id);

	int updateSubContract(@Param("fbContract")FbCgContract fbContract);

	List<FbCgContract> selectsubcontractHistory(@Param("fbNo")String fbNo);

	int fbNocount(@Param("year")String year);

	List<FbCgContract> getFBNameAndNo();
	
	List<FbCgContract> getFBNameAndNo2();

	FbCgContract getFBNameByNo(@Param("fbNo")String fbNo);

	FbCgContract getFBNoByName(@Param("contractName")String contractName);

	FbCgContract getFBContractByName(@Param("contractName")String contractName);

	FbCgContract getFBContractByNo(@Param("no")String no);

	List<FbCgContract> getFbcjNo();

	List<FbCgContract> getFBNoBycjNo(@Param("no")String no);

	int updateHistoryById(@Param("id")String id);

	int updateHistoryNow(@Param("id")String id);

	CjContract getCjContractMainPrjLeaderByFbNo(@Param("fbNo")String fbNo);
	
	FbCgContract selectYiFangByNo(@Param("no")String no);
	
	List<FbCgContract> selectFbContractByTaskNo(@Param("no")String no);
	
	public int updateFbNoById(@Param("id")String id,@Param("no")String no);
	
	public FbCgContract selectFbContractShowByFbNo(@Param("no")String fbNo);
	
	public String CreateEBContractNumOrder(@Param("year")String year);
}

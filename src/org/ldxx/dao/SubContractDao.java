package org.ldxx.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.FbContract;

public interface SubContractDao {

	List<FbContract> selectSubContract(@Param("status")String status,@Param("startMin")String startMin,@Param("startMax")String startMax,@Param("endMin")String endMin,@Param("endMax")String endMax,@Param("mainDp")String mainDp,@Param("spType")String spType,@Param("fbMoneyMin")BigDecimal fbMoneyMin,@Param("fbMoneyMax")BigDecimal fbMoneyMax,@Param("contractMoneyMin")BigDecimal contractMoneyMin,@Param("contractMoneyMax")BigDecimal contractMoneyMax,@Param("zdMoneyMin")BigDecimal zdMoneyMin,@Param("zdMoneyMax")BigDecimal zdMoneyMax);

	List<FbContract> selectSubContract2(@Param("startMin")String startMin,@Param("startMax")String startMax,@Param("endMin")String endMin,@Param("endMax")String endMax,@Param("mainDp")String mainDp,@Param("spType")String spType,@Param("fbMoneyMin")BigDecimal fbMoneyMin,@Param("fbMoneyMax")BigDecimal fbMoneyMax,@Param("contractMoneyMin")BigDecimal contractMoneyMin,@Param("contractMoneyMax")BigDecimal contractMoneyMax,@Param("zdMoneyMin")BigDecimal zdMoneyMin,@Param("zdMoneyMax")BigDecimal zdMoneyMax);
	
	int saveSubContract(@Param("fbContract")FbContract fbContract);

	int deleteSubContractById(@Param("id")String id);

	FbContract selectSubContractById(@Param("id")String id);

	int updateSubContract(@Param("fbContract")FbContract fbContract);

	List<FbContract> selectsubcontractHistory(@Param("fbNo")String fbNo);

	int fbNocount(@Param("year")String year);

	List<FbContract> getFBNameAndNo();
	
	List<FbContract> getFBNameAndNo2();

	FbContract getFBNameByNo(@Param("fbNo")String fbNo);

	FbContract getFBNoByName(@Param("contractName")String contractName);

	FbContract getFBContractByName(@Param("contractName")String contractName);
	
	FbContract getFBContractByFbNo(@Param("fbNo")String contractName);

	FbContract getFBContractByNo(@Param("no")String no);

	List<FbContract> getFbcjNo();

	List<FbContract> getFBNoBycjNo(@Param("no")String no);
	
	List<FbContract> getFBNoBytaskNo(String no);

	int updateHistoryById(@Param("id")String id);

	int updateHistoryNow(@Param("id")String id);

	CjContract getCjContractMainPrjLeaderByFbNo(@Param("fbNo")String fbNo);
	
	FbContract selectYiFangByNo(@Param("no")String no);
	
	List<FbContract> selectFbContractByTaskNo(@Param("no")String no);
	
	public int updateFbNoById(@Param("id")String id,@Param("no")String no);
	
	public FbContract selectFbContractShowByFbNo(@Param("no") String fbNo);

	BigDecimal getShenpiFbMoneyByCjNo(@Param("cjno")String cjno);

	int updateContractReasonById(@Param("id")String id,@Param("contractReason") String contractReason);
}

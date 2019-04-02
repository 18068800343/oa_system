package org.ldxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Accessory;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.FbCgContract;

public interface SubContractService2 {

	List<FbCgContract> selectSubContract(String status,String startMin,String startMax,String endMin,String endMax,String mainDp,String spType,float fbMoneyMin,float fbMoneyMax,float contractMoneyMin,float contractMoneyMax,float zdMoneyMin,float zdMoneyMax);

	int saveSubContract(FbCgContract fbContract);

	int deleteSubContractById(String id);

	FbCgContract selectSubContractById(String id);

	List<Accessory> selectAccessoryById(String id);

	int updateSubContract(FbCgContract fbContract);

	int deleteAccessoryByIdAndName(Accessory accessory);

	List<FbCgContract> selectsubcontractHistory(String fbNo);

	int fbNocount(String year);

	List<FbCgContract> getFBNameAndNo();
	
	List<FbCgContract> getFBNameAndNo2();

	FbCgContract getFBNameByNo(String fbNo);

	FbCgContract getFBNoByName(String contractName);

	FbCgContract getFBContractByName(String contractName);

	FbCgContract getFBContractByNo(String no);

	List<FbCgContract> getFbcjNo();

	List<FbCgContract> getFBNoBycjNo(String no);

	int updateHistoryById(String id);

	CjContract getCjContractMainPrjLeaderByFbNo(String fbNo);
	
	FbCgContract selectYiFangByNo(String no);
	
	List<FbCgContract> selectFbContractByTaskNo(String no);
	
	public int updateFbNoById(String id,String no);

	public FbCgContract selectFbContractShowByFbNo(@Param("no") String fbNo);
	
	public String CreateEBContractNumOrder(String year);
}

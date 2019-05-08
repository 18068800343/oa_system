package org.ldxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Accessory;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.FbContract;

public interface SubContractService {

	List<FbContract> selectSubContract(String status,String startMin,String startMax,String endMin,String endMax,String mainDp,String spType,Double fbMoneyMin,Double fbMoneyMax,Double contractMoneyMin,Double contractMoneyMax,Double zdMoneyMin,Double zdMoneyMax);

	int saveSubContract(FbContract fbContract);

	int deleteSubContractById(String id);

	FbContract selectSubContractById(String id);

	List<Accessory> selectAccessoryById(String id);

	int updateSubContract(FbContract fbContract);

	int deleteAccessoryByIdAndName(Accessory accessory);

	List<FbContract> selectsubcontractHistory(String fbNo);

	int fbNocount(String year);

	List<FbContract> getFBNameAndNo();
	
	List<FbContract> getFBNameAndNo2();

	FbContract getFBNameByNo(String fbNo);

	FbContract getFBNoByName(String contractName);

	FbContract getFBContractByName(String contractName);

	FbContract getFBContractByNo(String no);

	List<FbContract> getFbcjNo();

	List<FbContract> getFBNoBycjNo(String no);
	
	List<FbContract> getFBNoBytaskNo(String no);

	int updateHistoryById(String id);

	CjContract getCjContractMainPrjLeaderByFbNo(String fbNo);
	
	FbContract selectYiFangByNo(String no);
	
	List<FbContract> selectFbContractByTaskNo(String no);
	
	public int updateFbNoById(String id,String no);

	public FbContract selectFbContractShowByFbNo(@Param("no") String fbNo);

	Double getShenpiFbMoneyByCjNo(String cjno);

	int updateContractReasonById(String id, String contractReason);
}

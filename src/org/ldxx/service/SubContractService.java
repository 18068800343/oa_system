package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.FbContract;

public interface SubContractService {

	List<FbContract> selectSubContract(String status,String startMin,String startMax,String endMin,String endMax,String mainDp,String spType,float fbMoneyMin,float fbMoneyMax,float contractMoneyMin,float contractMoneyMax,float zdMoneyMin,float zdMoneyMax);

	int saveSubContract(FbContract fbContract);

	int deleteSubContractById(String id);

	FbContract selectSubContractById(String id);

	List<Accessory> selectAccessoryById(String id);

	int updateSubContract(FbContract fbContract);

	int deleteAccessoryByIdAndName(Accessory accessory);

	List<FbContract> selectsubcontractHistory(String fbNo);

	int fbNocount();

	List<FbContract> getFBNameAndNo();
	
	List<FbContract> getFBNameAndNo2();

	FbContract getFBNameByNo(String fbNo);

	FbContract getFBNoByName(String contractName);

	FbContract getFBContractByName(String contractName);

	FbContract getFBContractByNo(String no);

	List<FbContract> getFbcjNo();

	List<FbContract> getFBNoBycjNo(String no);

	int updateHistoryById(String id);

	CjContract getCjContractMainPrjLeaderByFbNo(String fbNo);

}

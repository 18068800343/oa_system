package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.FbContract;

public interface SubContractService {

	List<FbContract> selectSubContract(String status);

	int saveSubContract(FbContract fbContract);

	int deleteSubContractById(String id);

	FbContract selectSubContractById(String id);

	List<Accessory> selectAccessoryById(String id);

	int updateSubContract(FbContract fbContract);

	int deleteAccessoryByIdAndName(Accessory accessory);

	List<FbContract> selectsubcontractHistory(String fbNo);

	int fbNocount();

	void updateHistory(String fbId);

	List<FbContract> getFBNameAndNo();

	FbContract getFBNameByNo(String fbNo);

	FbContract getFBNoByName(String contractName);

	FbContract getFBContractByName(String contractName);

	FbContract getFBContractByNo(String no);

}

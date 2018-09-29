package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CgContract;
import org.ldxx.bean.FbContract;

public interface CgContractService {

	List<CgContract> selectCgContractByStatus(String status);

	int addCgContract(CgContract cg);

	int deleteCgContractById(String id);

	int updateCgContractSave(CgContract cg);

	CgContract selectCgContractById(String id);

	List<Accessory> selectAccessoryById(String id);

	int deleteAccessoryByIdAndName(Accessory accessory);

	List<CgContract> selectCgIdAndName();

	CgContract selectCgnoById(String id);

	void updateHistoryById(String cgId);

	List<CgContract> selectHistoryByNo(String cgNo);

	int cgNocount();

	List<CgContract> getCGNameAndNo();

	CgContract getCGNameByNo(String cgNo);

	CgContract getCGNoByName(String contractName);

}

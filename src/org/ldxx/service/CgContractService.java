package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CgContract;

public interface CgContractService {

	List<CgContract> selectCgContractByStatus(String status);

	int addCgContract(CgContract cg);

	int deleteCgContractById(String id);

	int updateCgContractSave(CgContract cg);

	CgContract selectCgContractById(String id);

	List<Accessory> selectAccessoryById(String id);

	int deleteAccessoryByIdAndName(Accessory accessory);

}

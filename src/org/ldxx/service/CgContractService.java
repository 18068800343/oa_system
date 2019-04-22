package org.ldxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Accessory;
import org.ldxx.bean.BorrowContract;
import org.ldxx.bean.CgContract;
import org.ldxx.bean.FbContract;
import org.ldxx.bean.MaterialDemand;

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

	int updateHistoryById(String id);

	List<CgContract> selectHistoryByNo(String cgNo);

	int cgNocount(String year);

	List<CgContract> getCGNameAndNo();

	List<CgContract> getCGNameByNo(String cgNo);

	List<CgContract> getCGNoByName(String contractName);
	
	List<CgContract> getCGNoByTaskNo(String no);

	List<CgContract> getCGNameAndPrjNameBytaskNo(String no);

	List<CgContract> getCGNametaskNoAndByPrjName(String name);

	int updateDepartmentMoney(Double price, String id);

	int updateMaterial(MaterialDemand md);

	List<CgContract> getCGNameCgNoAndCgMoney();

	List<MaterialDemand> getMdById(String id);

	CgContract selectByCgNo(String no);
	
	List<CgContract> selectCgContractByWorkNo(String no);

	int updateCgContractById(CgContract cg);

	List<BorrowContract> getRateAndMoney(String no);

	int updatePrjNameAndNoById(CgContract cg);

	int updatecgNoById(String id, String cgNo2);
	
	CgContract selectCgContractShowByCgNo(String cgNo);

}

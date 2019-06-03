package org.ldxx.service;

import java.util.List;


import org.ldxx.bean.Accessory;
import org.ldxx.bean.BorrowContract;
import org.ldxx.bean.CgOtherContract;
import org.ldxx.bean.MaterialDemand;

public interface CgOtherContractService {

	List<CgOtherContract> selectCgOtherContractByStatus(String status);

	List<CgOtherContract> selectCgOtherContractByStatus2();

	
	int addCgOtherContract(CgOtherContract cgo);

	int deleteCgOtherContractById(String id);

	int updateCgOtherContractSave(CgOtherContract cgo);

	CgOtherContract selectCgOtherContractById(String id);

	List<Accessory> selectAccessoryById(String id);

	int deleteAccessoryByIdAndName(Accessory accessory);

	List<CgOtherContract> selectCgoIdAndName();

	CgOtherContract selectCgonoById(String id);

	int updateHistoryById(String id);

	List<CgOtherContract> selectHistoryByNo(String cgoNo);

	int cgoNocount(String year);

	List<CgOtherContract> getCGoNameAndNo();

	List<CgOtherContract> getCGoNameByNo(String cgoNo);

	List<CgOtherContract> getCGoNoByTaskNo(String cgoNo);
	
	List<CgOtherContract> getCGoNoByName(String contractName);

	List<CgOtherContract> getCGoNameAndPrjNameBytaskNo(String no);

	List<CgOtherContract> getCGoNametaskNoAndByPrjName(String name);

	int updateDepartmentMoney(Double price, String id);

	int updateMaterial(MaterialDemand md);

	List<CgOtherContract> getCGoNameCgoNoAndCgoMoney();

	List<MaterialDemand> getMdById(String id);

	CgOtherContract selectByCgoNo(String no);
	
	List<CgOtherContract> selectCgOtherContractByWorkNo(String no);

	int updateCgOtherContractById(CgOtherContract cgo);

	int updatePrjNameAndNoById(CgOtherContract cgo);

	int updatecgoNoById(String id, String cgoNo2);
	
	CgOtherContract selectCgOtherContractShowByCgoNo(String cgoNo);

}

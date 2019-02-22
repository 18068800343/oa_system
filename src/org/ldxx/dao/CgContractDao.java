package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CgContract;
import org.ldxx.bean.FbContract;

public interface CgContractDao {

	List<CgContract> selectCgContractByStatus(@Param("status")String status);

	int addCgContract(@Param("cg")CgContract cg);

	int deleteCgContractById(@Param("id")String id);

	int updateCgContractSave(@Param("cg")CgContract cg);

	CgContract selectCgContractById(@Param("id")String id);

	List<CgContract> selectCgIdAndName();

	CgContract selectCgnoById(@Param("id")String id);

	int updateHistoryById(@Param("id")String id);

	List<CgContract> selectHistoryByNo(@Param("cgNo")String cgNo);

	int cgNocount(@Param("year")String year);

	List<CgContract> getCGNameAndNo();

	List<CgContract> getCGNameByNo(@Param("cgNo")String cgNo);

	List<CgContract> getCGNoByName(@Param("contractName")String contractName);

	List<CgContract> getCGNameAndPrjNameBytaskNo(@Param("no")String no);

	List<CgContract> getCGNametaskNoAndByPrjName(@Param("name")String name);

	List<CgContract> getCGNameCgNoAndCgMoney();

	CgContract selectByCgNo(@Param("no")String no);
	
	List<CgContract> selectCgContractByWorkNo(@Param("no")String no);

	int updateHistoryNow(@Param("id")String id);

	int updateCgContractById(@Param("cg")CgContract cg);

	int updatePrjNameAndNoById(@Param("cg")CgContract cg);

}

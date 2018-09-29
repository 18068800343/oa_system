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

	void updateHistoryById(@Param("cgId")String cgId);

	List<CgContract> selectHistoryByNo(@Param("cgNo")String cgNo);

	int cgNocount();

	List<CgContract> getCGNameAndNo();

	CgContract getCGNameByNo(@Param("cgNo")String cgNo);

	CgContract getCGNoByName(@Param("contractName")String contractName);

}

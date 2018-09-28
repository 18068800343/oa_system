package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CgContract;

public interface CgContractDao {

	List<CgContract> selectCgContractByStatus(@Param("status")String status);

	int addCgContract(@Param("cg")CgContract cg);

	int deleteCgContractById(@Param("id")String id);

	int updateCgContractSave(@Param("cg")CgContract cg);

	CgContract selectCgContractById(@Param("id")String id);

}

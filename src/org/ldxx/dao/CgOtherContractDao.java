package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CgOtherContract;


public interface CgOtherContractDao {

	List<CgOtherContract> selectCgOtherContractByStatus(@Param("status")String status);

	int addCgOtherContract(@Param("cgo")CgOtherContract cgo);

	int deleteCgOtherContractById(@Param("id")String id);

	int updateCgOtherContractSave(@Param("cgo")CgOtherContract cgo);

	CgOtherContract selectCgOtherContractById(@Param("id")String id);

	List<CgOtherContract> selectCgoIdAndName();

	CgOtherContract selectCgonoById(@Param("id")String id);

	int updateHistoryById(@Param("id")String id);

	List<CgOtherContract> selectHistoryByNo(@Param("cgoNo")String cgoNo);

	int cgoNocount(@Param("year")String year);

	List<CgOtherContract> getCGoNameAndNo();

	List<CgOtherContract> getCGoNameByNo(@Param("cgoNo")String cgoNo);

	List<CgOtherContract> getCGoNoByName(@Param("contractName")String contractName);

	List<CgOtherContract> getCGoNameAndPrjNameBytaskNo(@Param("no")String no);

	List<CgOtherContract> getCGoNametaskNoAndByPrjName(@Param("name")String name);

	List<CgOtherContract> getCGoNameCgoNoAndCgoMoney();

	CgOtherContract selectByCgoNo(@Param("no")String no);
	
	List<CgOtherContract> selectCgOtherContractByWorkNo(@Param("no")String no);

	int updateHistoryNow(@Param("id")String id);

	int updateCgOtherContractById(@Param("cgo")CgOtherContract cgo);

	int updatePrjNameAndNoById(@Param("cgo")CgOtherContract cgo);

	int updatecgoNoById(@Param("id")String id,@Param("cgoNo2") String cgoNo2);

	CgOtherContract selectCgOtherContractShowByCgoNo(@Param("cgoNo")String cgoNo);
}

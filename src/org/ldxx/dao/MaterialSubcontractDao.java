package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ClfbContractEvaluate;

public interface MaterialSubcontractDao {

	List<ClfbContractEvaluate> selectmSubcontract(@Param("status")String status);

	int addmSubcontractSave(@Param("c")ClfbContractEvaluate c);

	void updateHistory(@Param("ceId")String ceId);

	List<ClfbContractEvaluate> selectHistoryBypayCode(@Param("code")String code);

	int MCodecount();

	ClfbContractEvaluate selectmSubcontractById(@Param("id")String id);

}

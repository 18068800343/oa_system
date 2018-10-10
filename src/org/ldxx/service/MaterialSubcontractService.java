package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.ClfbContractEvaluate;

public interface MaterialSubcontractService {

	List<ClfbContractEvaluate> selectmSubcontract(String status);

	int addmSubcontractSave(ClfbContractEvaluate c);

	void updateHistory(String ceId);

	List<ClfbContractEvaluate> selectHistoryBypayCode(String code);

	int MCodecount();

	ClfbContractEvaluate selectmSubcontractById(String id);

}

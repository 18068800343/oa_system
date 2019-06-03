package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.ClfbContractEvaluate;

public interface MaterialSubcontractService {

	List<ClfbContractEvaluate> selectmSubcontract(String status);

	int addmSubcontractSave(ClfbContractEvaluate c);

	ClfbContractEvaluate selectmSubcontractById(String id);

	int updatemSubcontractById(ClfbContractEvaluate c);

	List<ClfbContractEvaluate> selectmSubcontractByStatus2();

}

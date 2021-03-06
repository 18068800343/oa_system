package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.ContractReason;
import org.ldxx.dao.ContractReasonDao;
import org.ldxx.service.ContractReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractReasonServiceImpl implements ContractReasonService{

	@Autowired
	private ContractReasonDao dao;
	
	@Override
	public ContractReason selectContractReasonById(String id) {
		return dao.selectContractReasonById(id);
	}

	@Override
	public int addContractReason(ContractReason cr) {
		return dao.addContractReason(cr);
	}

	@Override
	public int updateContractReasonById(ContractReason cr) {
		return dao.updateContractReasonById(cr);
	}

	@Override
	public int countId(String id) {
		return dao.countId(id);
	}

}

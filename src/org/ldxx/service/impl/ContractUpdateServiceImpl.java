package org.ldxx.service.impl;

import org.ldxx.bean.ContractUpdate;
import org.ldxx.dao.ContractUpdateDao;
import org.ldxx.service.ContractUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractUpdateServiceImpl implements ContractUpdateService{

	@Autowired
	private ContractUpdateDao dao;
	
	@Override
	public int addContractUpdate(ContractUpdate cu) {
		return dao.addContractUpdate(cu);
	}

	@Override
	public int updateContractUpdate(ContractUpdate cu) {
		return dao.updateContractUpdate(cu);
	}

}

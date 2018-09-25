package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.CjContract;
import org.ldxx.dao.CjContractDao;
import org.ldxx.service.CjContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CjContractServiceImpl implements CjContractService{

	@Autowired
	private CjContractDao dao;
	
	@Override
	public int addCjContract(CjContract cj) {
		return 0;
	}

	@Override
	public int updateCjContract(CjContract cj) {
		return 0;
	}

	@Override
	public List<CjContract> selectCjContractByStatus(String status) {
		return null;
	}

	@Override
	public CjContract selectCjContractById(String id) {
		return null;
	}

	@Override
	public int deleteCjContract(String id) {
		return 0;
	}

}

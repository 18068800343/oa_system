package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.ClfbContractEvaluate;
import org.ldxx.dao.MaterialSubcontractDao;
import org.ldxx.service.MaterialSubcontractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MaterialSubcontractServiceImpl implements MaterialSubcontractService {

	@Autowired
	private MaterialSubcontractDao msDao;

	@Override
	public List<ClfbContractEvaluate> selectmSubcontract(String status) {
		return msDao.selectmSubcontract(status);
	}

	@Override
	public int addmSubcontractSave(ClfbContractEvaluate c) {
		return msDao.addmSubcontractSave(c);
	}

	@Override
	public ClfbContractEvaluate selectmSubcontractById(String id) {
		return msDao.selectmSubcontractById(id);
	}
	
}

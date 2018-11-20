package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.FinancialHk;
import org.ldxx.dao.FinancialHkDao;
import org.ldxx.service.FinancialHkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancialHkServiceImpl implements FinancialHkService{

	@Autowired
	private FinancialHkDao dao;
	
	@Override
	public int addFinancialHk(FinancialHk hk) {
		return dao.addFinancialHk(hk);
	}

	@Override
	public List<FinancialHk> selectFinancialHk() {
		return dao.selectFinancialHk();
	}

	@Override
	public FinancialHk selectFinancialHkById(String id) {
		return dao.selectFinancialHkById(id);
	}

}

package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.FinancialReceipts;
import org.ldxx.dao.FinancialReceiptsDao;
import org.ldxx.service.FinancialReceiptsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancialReceiptsServiceImpl implements FinancialReceiptsService{

	@Autowired
	private FinancialReceiptsDao dao;
	
	@Override
	public int addFinancialReceipts(FinancialReceipts fr) {
		return dao.addFinancialReceipts(fr);
	}

	@Override
	public List<FinancialReceipts> selectFinancialReceipts() {
		return dao.selectFinancialReceipts();
	}

	@Override
	public FinancialReceipts selectFinancialReceiptsById(String id) {
		return dao.selectFinancialReceiptsById(id);
	}

	@Override
	public List<FinancialReceipts> selectFinancialReceiptsByStatus(String status) {
		return dao.selectFinancialReceiptsByStatus(status);
	}

	@Override
	public int updateStatus(String status, String id) {
		return dao.updateStatus(status, id);
	}

	@Override
	public List<FinancialReceipts> selectFinancialReceiptsByYear( String y) {
		return dao.selectFinancialReceiptsByYear(y);
	}

	@Override
	public FinancialReceipts selectResultMoney(String no) {
		return dao.selectResultMoney(no);
	}

}

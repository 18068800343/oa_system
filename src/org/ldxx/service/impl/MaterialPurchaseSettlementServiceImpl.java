package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.clfbContractPurchaseSettlement;
import org.ldxx.dao.MaterialPurchaseSettlementDao;
import org.ldxx.service.MaterialPurchaseSettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MaterialPurchaseSettlementServiceImpl implements MaterialPurchaseSettlementService {

	@Autowired
	private MaterialPurchaseSettlementDao mDao;

	@Override
	public List<clfbContractPurchaseSettlement> selectmaterialPurchaseSettlement(String status) {
		return mDao.selectmaterialPurchaseSettlement(status);
	}

	@Override
	public int addmaterialPurchaseSettlementSave(clfbContractPurchaseSettlement c) {
		return mDao.addmaterialPurchaseSettlementSave(c);
	}

	@Override
	public int updateHistory(String cpId) {
		return mDao.updateHistory(cpId);
	}

	@Override
	public clfbContractPurchaseSettlement selectmaterialPurchaseSettlementById(String id) {
		return mDao.selectmaterialPurchaseSettlementById(id);
	}

	@Override
	public int cgjsNocount() {
		return mDao.cgjsNocount();
	}

	@Override
	public List<clfbContractPurchaseSettlement> selectHistoryByNo(String no) {
		return mDao.selectHistoryByNo(no);
	}
}

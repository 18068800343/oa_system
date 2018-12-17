package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.CjContract;
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
	public FinancialReceipts selectResultMoney(String no,String year) {
		return dao.selectResultMoney(no,year);
	}

	@Override
	public FinancialReceipts selectResultMoneyAll(String no) {
		return dao.selectResultMoneyAll(no);
	}

	@Override
	public float selectResultMoneyBySignTime(String time) {
		float money=0;
		List<FinancialReceipts> fr=dao.selectResultMoneyBySignTime(time);
		if(fr!=null){
			for(int i=0;i<fr.size();i++){
				float resultMoney=fr.get(i).getResultMoney();
				money=money+resultMoney;
			}
		}
		return money;
	}

	@Override
	public List<CjContract> selectResultMoneyByCjAndTime(String time) {
		return dao.selectResultMoneyByCjAndTime(time);
	}

	@Override
	public FinancialReceipts selectTotalMoneyByCj(String no) {
		return dao.selectTotalMoneyByCj(no);
	}

}

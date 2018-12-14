package org.ldxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.FinancialReceipts;

public interface FinancialReceiptsService {

	public int addFinancialReceipts(FinancialReceipts fr);
	
	public List<FinancialReceipts> selectFinancialReceipts();
	
	public FinancialReceipts selectFinancialReceiptsById(String id);
	
	public List<FinancialReceipts> selectFinancialReceiptsByStatus(String status);
	
	public int updateStatus(String status,String id);

	public List<FinancialReceipts> selectFinancialReceiptsByYear( String y);
	
	public FinancialReceipts selectResultMoney(String no,String year);
	
	public FinancialReceipts selectResultMoneyAll(String no);
	
	public float selectResultMoneyBySignTime(String time);
	
	public List<CjContract> selectResultMoneyByCjAndTime(String time);
}

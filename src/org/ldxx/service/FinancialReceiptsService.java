package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.FinancialReceipts;

public interface FinancialReceiptsService {

	public int addFinancialReceipts(FinancialReceipts fr);
	
	public List<FinancialReceipts> selectFinancialReceipts();
	
	public FinancialReceipts selectFinancialReceiptsById(String id);
	
	public List<FinancialReceipts> selectFinancialReceiptsByStatus(String status);
	
	public int updateStatus(String status,String id);

	public List<FinancialReceipts> selectFinancialReceiptsByYear(String status, String y);
}

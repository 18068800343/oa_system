package org.ldxx.service;

import java.util.List;
import java.util.Map;

import org.ldxx.bean.FinancialReceipts;
import org.ldxx.bean.FinancialTables;

public interface FinancialReceipts2Service {

	
	public List<FinancialTables> selectfinancialTables();
	
	public List<FinancialTables> selectfinancialTablesByState(String state);
	
	public int updateState(String state,String id);

	public List<FinancialReceipts> selectFinancialReceiptsByYear(String status, String y);

	public int addFinancialReceipts2(Map<String, Object> map);
}

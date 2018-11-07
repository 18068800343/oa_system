package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FinancialReceipts;

public interface FinancialReceiptsDao {

	public int addFinancialReceipts(@Param("fr")FinancialReceipts fr);
	
	public List<FinancialReceipts> selectFinancialReceipts();
	
	public FinancialReceipts selectFinancialReceiptsById(@Param("id")String id);
	
	public List<FinancialReceipts> selectFinancialReceiptsByStatus(@Param("status")String status);
	
	public int updateStatus(@Param("status")String status,@Param("id")String id);
}

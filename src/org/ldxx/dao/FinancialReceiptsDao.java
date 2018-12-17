package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.FinancialReceipts;

public interface FinancialReceiptsDao {

	public int addFinancialReceipts(@Param("fr")FinancialReceipts fr);
	
	public List<FinancialReceipts> selectFinancialReceipts();
	
	public FinancialReceipts selectFinancialReceiptsById(@Param("id")String id);
	
	public List<FinancialReceipts> selectFinancialReceiptsByStatus(@Param("status")String status);
	
	public int updateStatus(@Param("status")String status,@Param("id")String id);

	public List<FinancialReceipts> selectFinancialReceiptsByYear(@Param("y") String y);
	
	public FinancialReceipts selectResultMoney(@Param("no")String no,@Param("year")String year);
	
	public FinancialReceipts selectResultMoneyAll(@Param("no")String no);
	
	public List<FinancialReceipts> selectResultMoneyBySignTime(@Param("time")String time);
	
	public List<CjContract> selectResultMoneyByCjAndTime(@Param("time")String time);
	
	public FinancialReceipts selectTotalMoneyByCj(@Param("no")String no);
	
}

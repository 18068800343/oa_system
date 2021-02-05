package org.ldxx.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FinancialReceipts;
import org.ldxx.bean.FinancialTables;

public interface FinancialReceipts2Dao {

	public List<FinancialTables> selectfinancialTables();
	
	public int updatefinancialTables2Byid(FinancialTables f);
	
	public List<FinancialTables> selectfinancialTablesByState(@Param("state")String state);
	
	public int updateState(@Param("state")String state,@Param("id")String id);

	public List<FinancialReceipts> selectFinancialReceiptsByYear(@Param("status")String status,@Param("y") String y);

	public int addFinancialReceipts2(@Param("list")List<FinancialTables> list);

	public int updateValueByNo(@Param("f")FinancialTables f);

	public FinancialTables selectValueByno(@Param("no")String no);

	public int updateValueById(@Param("ftId")String ftId,@Param("ftMoney") BigDecimal ftMoney);

	public int updateValueById2(@Param("ftId")String ftId,@Param("ftMoney") BigDecimal ftMoney);
	
	public List<FinancialTables> getSumMoneyByYear(@Param("year")String year);

	public int deletefinancialTables2Byid(@Param("id")String id);
}

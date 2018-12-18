package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Pay;

public interface ContractPaymentDao {

	List<Pay> selectPayByStatus(@Param("status")String status);

	int addPaySave(@Param("pay")Pay pay);

	void updateHistory(@Param("payId")String payId);

	Pay selectPayById(@Param("id")String id);

	int fkNocount();

	List<Pay> selectHistoryBypayCode(@Param("payCode")String payCode);
	
	Pay selectPayByNo(@Param("fbNo")String fbNo);

	int updateGenerationAdvancesMoney(@Param("programMoney")Float programMoney, @Param("id")String id);

	Pay getFbPayPlanAndMoney(@Param("no")String no);
	
	public Pay getTotalPayMoney(@Param("no")String no);
}

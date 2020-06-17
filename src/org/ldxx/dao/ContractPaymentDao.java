package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Pay;

public interface ContractPaymentDao {

	List<Pay> selectPayByStatus(@Param("status")String status);
	
	List<Pay> selectPayByStatus2();
	
	int addPaySave(@Param("pay")Pay pay);

	Pay selectPayById(@Param("id")String id);

	int fkNocount();

	List<Pay> selectHistoryBypayCode(@Param("id")String payId);
	
	Pay selectPayByNo(@Param("fbNo")String fbNo);

	int updateGenerationAdvancesMoney(@Param("programMoney")Double programMoney, @Param("id")String id);

	Pay getFbPayPlanAndMoney(@Param("no")String no);
	
	public Pay getTotalPayMoney(@Param("no")String no);
	
	public int addPayResultInfo(@Param("id")String id,@Param("resultPay")Double resultPay,@Param("payTime")String payTime);

	int updateHistoryById(@Param("id")String id);

	int updateHistoryNow(@Param("id")String id);

	Pay getAllDaiDianByFbNo(@Param("no")String no);//获取所有代垫款
	
	int updateAuthorisePayment(@Param("id")String id,@Param("money")Double money);

	int updatePayById(@Param("pay")Pay pay);
	
	String CreatePayNumOrder(@Param("year")String year);
	
	int updatePayNo(@Param("id")String id,@Param("no")String no);
	
	public int getApprovalCountByfbNo(@Param("fbNo")String fbNo);
	
	public Pay getAccumulatedFinancialRecognitionMoneyByFbNo(@Param("fbNo")String fbNo);

	int updatecwqrljMoneyById(@Param("pay")Pay pay);

}

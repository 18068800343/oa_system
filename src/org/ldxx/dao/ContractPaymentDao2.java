package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Pay;
import org.ldxx.bean.Pay2;

public interface ContractPaymentDao2 {

	List<Pay2> selectPayByStatus(@Param("status")String status);
	
	List<Pay2> selectPayByStatus2();
	
	int addPaySave(@Param("pay")Pay2 pay);

	Pay2 selectPayById(@Param("id")String id);

	int fkNocount();

	List<Pay2> selectHistoryBypayCode(@Param("id")String payId);
	
	Pay2 selectPayByNo(@Param("fbNo")String fbNo);

	int updateGenerationAdvancesMoney(@Param("programMoney")Double programMoney, @Param("id")String id);

	Pay2 getFbPayPlanAndMoney(@Param("no")String no);
	
	public Pay2 getTotalPayMoney(@Param("no")String no);
	
	public int addPayResultInfo(@Param("id")String id,@Param("resultPay")Double resultPay,@Param("payTime")String payTime);

	int updateHistoryById(@Param("id")String id);

	int updateHistoryNow(@Param("id")String id);

	Pay2 getAllDaiDianByFbNo(@Param("no")String no);//获取所有代垫款
	
	int updateAuthorisePayment(@Param("id")String id,@Param("money")Double money);

	int updatePayById(@Param("pay")Pay2 pay);
	
	String CreatePayNumOrder(@Param("year")String year);
	
	int updatePayNo(@Param("id")String id,@Param("no")String no);
	
	public int getApprovalCountByfbNo(@Param("fbNo")String fbNo);
	
	public Pay2 getAccumulatedFinancialRecognitionMoneyByFbNo(@Param("fbNo")String fbNo);

	int updatecwqrljMoneyById(@Param("pay")Pay2 pay);

}

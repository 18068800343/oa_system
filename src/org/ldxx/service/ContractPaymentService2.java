package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.Pay2;

public interface ContractPaymentService2 {

	List<Pay2> selectPayByStatus(String status);

	List<Pay2> selectPayByStatus2();
	
	int addPaySave(Pay2 pay);

	Pay2 selectPayById(String id);

	int fkNocount();

	int deleteAccessoryByIdAndName(Accessory accessory);

	List<Accessory> selectAccessoryById(String id);

	List<Pay2> selectHistoryBypayCode(String payId);
	
	Pay2 getFbPayPlanAndMoney(String no);
	
	public Pay2 getTotalPayMoney(String no);
	
	public int addPayResultInfo(String id,Double resultPay,String payTime);

	int updateHistoryById(String id);
	
	Pay2 getAllDaiDianByFbNo(String no);//获取所有代垫款
	
	int updateAuthorisePayment(String id,Double money);

	int updatePayById(Pay2 pay);
	
	String CreatePayNumOrder(String year);
	
	int updatePayNo(String id,String no);

}

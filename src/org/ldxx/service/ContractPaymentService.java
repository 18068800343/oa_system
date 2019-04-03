package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.Pay;

public interface ContractPaymentService {

	List<Pay> selectPayByStatus(String status);

	int addPaySave(Pay pay);

	Pay selectPayById(String id);

	int fkNocount();

	int deleteAccessoryByIdAndName(Accessory accessory);

	List<Accessory> selectAccessoryById(String id);

	List<Pay> selectHistoryBypayCode(String payId);
	
	Pay getFbPayPlanAndMoney(String no);
	
	public Pay getTotalPayMoney(String no);
	
	public int addPayResultInfo(String id,float resultPay,String payTime);

	int updateHistoryById(String id);
	
	Pay getAllDaiDianByFbNo(String no);//获取所有代垫款
	
	int updateAuthorisePayment(String id,float money);

	int updatePayById(Pay pay);
	
	String CreatePayNumOrder(String year);
	
	int updatePayNo(String id,String no);

}

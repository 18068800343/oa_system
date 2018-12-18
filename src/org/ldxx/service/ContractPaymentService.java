package org.ldxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Accessory;
import org.ldxx.bean.Pay;

public interface ContractPaymentService {

	List<Pay> selectPayByStatus(String status);

	int addPaySave(Pay pay);

	void updateHistory(String payId);

	Pay selectPayById(String id);

	int fkNocount();

	int deleteAccessoryByIdAndName(Accessory accessory);

	List<Accessory> selectAccessoryById(String id);

	List<Pay> selectHistoryBypayCode(String payCode);
	
	Pay getFbPayPlanAndMoney(String no);
	
	public Pay getTotalPayMoney(String no);

}

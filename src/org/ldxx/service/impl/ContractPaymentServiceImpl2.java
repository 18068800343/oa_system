package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.Pay2;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.ContractPaymentDao2;
import org.ldxx.service.ContractPaymentService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContractPaymentServiceImpl2 implements ContractPaymentService2 {
	
	@Autowired
	private ContractPaymentDao2 contractPaymentDao2;

	@Autowired
	private AccessoryDao adao;
	
	@Override
	public List<Pay2> selectPayByStatus(String status) {
		List<Pay2> list = contractPaymentDao2.selectPayByStatus(status);
		return list;
	}

	@Override
	public List<Pay2> selectPayByStatus2() {
		List<Pay2> list = contractPaymentDao2.selectPayByStatus2();
		return list;
	}
	
	@Override
	public int addPaySave(Pay2 pay) {
		int i=contractPaymentDao2.addPaySave(pay);
		if(i>0){
			List<Accessory> accessory = pay.getAccessory();
			if(accessory!=null&&accessory.size()>0){
				adao.addAccessory(accessory);
			}
			List<Accessory> accessory2 = pay.getAccessory2();
			if(accessory2!=null&&accessory2.size()>0){
				adao.addAccessory(accessory2);
			}
			/*List<Accessory> accessory3 = pay.getAccessory3();
			if(accessory3!=null&&accessory3.size()>0){
				i=adao.addAccessory(accessory3);
			}*/
		}
		return i;
	}


	@Override
	public Pay2 selectPayById(String id) {
		return contractPaymentDao2.selectPayById(id);
	}

	@Override
	public int fkNocount() {
		return contractPaymentDao2.fkNocount();
	}

	@Override
	public int deleteAccessoryByIdAndName(Accessory accessory) {
		return adao.deleteAccessoryByIdAndName(accessory);
	}

	@Override
	public List<Accessory> selectAccessoryById(String id) {
		return adao.selectAccessoryById(id);
	}

	@Override
	public List<Pay2> selectHistoryBypayCode(String payCode) {
		List<Pay2> list = contractPaymentDao2.selectHistoryBypayCode(payCode);
		return list;
	}

	@Override
	public Pay2 getFbPayPlanAndMoney(String no) {
		return contractPaymentDao2.getFbPayPlanAndMoney(no);
	}

	@Override
	public Pay2 getTotalPayMoney(String no) {
		return contractPaymentDao2.getTotalPayMoney(no);
	}

	@Override
	public int addPayResultInfo(String id, Double resultPay, String payTime) {
		return contractPaymentDao2.addPayResultInfo(id, resultPay, payTime);
	}

	@Override
	public int updateHistoryById(String id) {
		int i= contractPaymentDao2.updateHistoryById(id);
		if(i>0){
			i=contractPaymentDao2.updateHistoryNow(id);
		}
		return i;
	}

	@Override
	public Pay2 getAllDaiDianByFbNo(String no) {
		return contractPaymentDao2.getAllDaiDianByFbNo(no);
	}

	@Override
	public int updateAuthorisePayment(String id, Double money) {
		return contractPaymentDao2.updateAuthorisePayment(id, money);
	}

	@Override
	public int updatePayById(Pay2 pay) {
		int i=contractPaymentDao2.updatePayById(pay);
		if(i>0){
			List<Accessory> accessory = pay.getAccessory();
			if(accessory!=null&&accessory.size()>0){
				adao.addAccessory(accessory);
			}
			List<Accessory> accessory2 = pay.getAccessory2();
			if(accessory2!=null&&accessory2.size()>0){
				adao.addAccessory(accessory2);
			}
		}
		return i;
	}

	@Override
	public String CreatePayNumOrder(String year) {
		return contractPaymentDao2.CreatePayNumOrder(year);
	}

	@Override
	public int updatePayNo(String id, String no) {
		return contractPaymentDao2.updatePayNo(id, no);
	}

}

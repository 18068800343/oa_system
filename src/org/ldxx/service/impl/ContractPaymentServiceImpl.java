package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.Pay;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.ContractPaymentDao;
import org.ldxx.service.ContractPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContractPaymentServiceImpl implements ContractPaymentService {
	
	@Autowired
	private ContractPaymentDao payDao;

	@Autowired
	private AccessoryDao adao;
	
	@Override
	public List<Pay> selectPayByStatus(String status) {
		List<Pay> list = payDao.selectPayByStatus(status);
		return list;
	}

	@Override
	public int addCgContract(Pay pay) {
		int i=payDao.addCgContract(pay);
		if(i>0){
			List<Accessory> accessory = pay.getAccessory();
			if(accessory!=null&&accessory.size()>0){
				i=adao.addAccessory(accessory);
			}
			List<Accessory> accessory2 = pay.getAccessory2();
			if(accessory2!=null&&accessory2.size()>0){
				i=adao.addAccessory(accessory2);
			}
			List<Accessory> accessory3 = pay.getAccessory3();
			if(accessory3!=null&&accessory3.size()>0){
				i=adao.addAccessory(accessory3);
			}
		}
		return i;
	}

	@Override
	public void updateHistory(String payId) {
		payDao.updateHistory(payId);
	}

	@Override
	public Pay selectPayById(String id) {
		return payDao.selectPayById(id);
	}

	@Override
	public int fkNocount() {
		return payDao.fkNocount();
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
	public List<Pay> selectHistoryBypayCode(String payCode) {
		List<Pay> list = payDao.selectHistoryBypayCode(payCode);
		return list;
	}

}

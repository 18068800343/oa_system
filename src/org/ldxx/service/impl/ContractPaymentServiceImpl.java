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
		for(int i=0;i<list.size();i++){
			String id = list.get(i).getPayId();
			List<Accessory> access1 = adao.selectAccessoryByIdAndType(id, "开票附件");
			List<Accessory> access2 = adao.selectAccessoryByIdAndType(id, "附件上传");
			list.get(i).setAccessory(access1);
			list.get(i).setAccessory2(access2);
		}
		return list;
	}

	@Override
	public int addCgContract(Pay pay) {
		int i=payDao.addCgContract(pay);
		List<Accessory> accessory = pay.getAccessory();
		List<Accessory> accessory2 = pay.getAccessory2();
		if(i>0){
			if(accessory!=null&&accessory.size()>0){
				i=adao.addAccessory(accessory);
			}
			if(accessory2!=null&&accessory2.size()>0){
				i=adao.addAccessory(accessory2);
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
		for(int i=0;i<list.size();i++){
			String id = list.get(i).getPayId();
			List<Accessory> access1 = adao.selectAccessoryByIdAndType(id, "开票附件");
			List<Accessory> access2 = adao.selectAccessoryByIdAndType(id, "附件上传");
			list.get(i).setAccessory(access1);
			list.get(i).setAccessory2(access2);
		}
		return list;
	}

}

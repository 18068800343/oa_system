package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.BorrowContract;
import org.ldxx.bean.Pay;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.BorrowContractDao;
import org.ldxx.dao.ContractPaymentDao;
import org.ldxx.service.BorrowContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BorrowContractServiceImpl implements BorrowContractService {

	@Autowired
	private BorrowContractDao dao;
	@Autowired
	private AccessoryDao adao;
	@Autowired
	private ContractPaymentDao payDao;

	@Override
	public List<BorrowContract> selectBorrowContract(String status) {
		return dao.selectBorrowContract(status);
	}

	@Override
	public int JKNocount() {
		return dao.JKNocount();
	}

	@Override
	public int addBorrowContractSave(BorrowContract bc) {
		String borrowingPurposes = bc.getBorrowingPurposes();
		int i=dao.addBorrowContractSave(bc);
		if(i>0){
			if(borrowingPurposes.equals("其他借款")){	//当用途是其他借款时，金额统计到付款申请代垫款中。
				Pay pay=payDao.selectPayByNo(bc.getFbNo());
				if(pay!=null){
					i=payDao.updateGenerationAdvancesMoney(bc.getThisBorrowMoney(),pay.getPayId());
				}
			}
			List<Accessory> accessory = bc.getAccessory();
			if(accessory!=null&&accessory.size()>0){
				i = adao.addAccessory(accessory);
			}
			List<Accessory> accessory2 = bc.getAccessory2();
			if(accessory2!=null&&accessory2.size()>0){
				i = adao.addAccessory(accessory2);
			}
		}
		return i;
	}

	@Override
	public List<BorrowContract> selectBorrowContractHistory(String no) {
		return dao.selectBorrowContractHistory(no);
	}

	@Override
	public int updateHistoryById(String id) {
		int i= dao.updateHistoryById(id);
		if(i>0){
			i=dao.updateHistoryNow(id);
		}
		return i;
	}

	@Override
	public BorrowContract selectBorrowById(String id) {
		return dao.selectBorrowById(id);
	}

	@Override
	public int updateBorrowContractById(BorrowContract bc) {
		int i=dao.updateBorrowContractById(bc);
		if(i>0){
			String borrowingPurposes = bc.getBorrowingPurposes();
			if(borrowingPurposes.equals("其他借款")){	//当用途是其他借款时，金额统计到付款申请代垫款中。
				Pay pay=payDao.selectPayByNo(bc.getFbNo());
				if(pay!=null){
					i=payDao.updateGenerationAdvancesMoney(bc.getThisBorrowMoney(),pay.getPayId());
				}
			}
			List<Accessory> accessory = bc.getAccessory();
			if(accessory!=null&&accessory.size()>0){
				i = adao.addAccessory(accessory);
			}
			List<Accessory> accessory2 = bc.getAccessory2();
			if(accessory2!=null&&accessory2.size()>0){
				i = adao.addAccessory(accessory2);
			}
		}
		return i;
	}

	@Override
	public BorrowContract selectAllBorrowByFbNo(String no) {
		return dao.selectAllBorrowByFbNo(no);
	}

	@Override
	public List<BorrowContract> getRateAndMoney(String no) {
		return dao.getRateAndMoney(no);
	}
	
}

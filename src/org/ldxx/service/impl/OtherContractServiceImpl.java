package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.OtherContract;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.OtherContractDao;
import org.ldxx.service.OtherContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OtherContractServiceImpl implements OtherContractService{

	@Autowired
	private OtherContractDao dao;
	
	@Autowired
	private AccessoryDao adao;
	
	@Transactional
	@Override
	public int addOtherContract(OtherContract other) {
		int i=dao.addOtherContract(other);
		if(i>0){
			List<Accessory> accessory=other.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
		}
		return i;
	}

	@Override
	public int deleteOtherContract(String id) {
		return 0;
	}

	@Override
	public List<OtherContract> selectOtherContract(String status) {
		return dao.selectOtherContract(status);
	}

	@Transactional
	@Override
	public int updateOtherContract(OtherContract other) {
		int i=dao.updateOtherContract(other);
		if(i>0){
			List<Accessory> accessory=other.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
		}
		return i;
	}

}

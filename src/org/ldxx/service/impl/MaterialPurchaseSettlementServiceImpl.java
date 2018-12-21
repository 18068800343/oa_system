package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.clfbContractPurchaseSettlement;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.MaterialPurchaseSettlementDao;
import org.ldxx.service.MaterialPurchaseSettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MaterialPurchaseSettlementServiceImpl implements MaterialPurchaseSettlementService {

	@Autowired
	private MaterialPurchaseSettlementDao mDao;
	@Autowired
	private AccessoryDao adao;

	@Override
	public List<clfbContractPurchaseSettlement> selectmaterialPurchaseSettlement(String status) {
		return mDao.selectmaterialPurchaseSettlement(status);
	}

	@Override
	public int addmaterialPurchaseSettlementSave(clfbContractPurchaseSettlement c) {
		int i=mDao.addmaterialPurchaseSettlementSave(c);
		if(i>0){
			List<Accessory> accessory = c.getAccessory();
			if(accessory!=null && accessory.size()!=0){
				i=adao.addAccessory(accessory);
			}
		}
		return i;
	}


	@Override
	public clfbContractPurchaseSettlement selectmaterialPurchaseSettlementById(String id) {
		return mDao.selectmaterialPurchaseSettlementById(id);
	}



	@Override
	public List<Accessory> selectAccessoryById(String id) {
		return adao.selectAccessoryById(id);
	}

	@Override
	public int deleteAccessoryByIdAndName(Accessory accessory) {
		return adao.deleteAccessoryByIdAndName(accessory);
	}
}

package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.FbContractOver;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.FbContractOverDao;
import org.ldxx.service.FbContractOverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FbContractOverServiceImpl implements FbContractOverService{

	@Autowired
	private FbContractOverDao dao;
	
	@Autowired
	private AccessoryDao adao;
	
	@Transactional
	@Override
	public int addFbContractOver(FbContractOver fbContractOver) {
		int i=dao.addFbContractOver(fbContractOver);
		if(i>0){
			List<Accessory> accessory=fbContractOver.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
			List<Accessory> accessory2=fbContractOver.getAccessory2();
			if(accessory2!=null){
				i=adao.addAccessory(accessory2);
			}
		}
		return i;
	}

	@Override
	public List<FbContractOver> selectFbContractOver(String state) {
		return dao.selectFbContractOver(state);
	}

	@Override
	public FbContractOver selectFbContractOverById(String id) {
		return dao.selectFbContractOverById(id);
	}

	@Transactional
	@Override
	public int updateFbContractOver(FbContractOver fbContractOver) {
		int i=dao.updateFbContractOver(fbContractOver);
		return i;
	}

}

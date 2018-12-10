package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.FbContractOverWj;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.FbContractOverWjDao;
import org.ldxx.service.FbContractOverWjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FbContractOverWjServiceImpl implements FbContractOverWjService{

	@Autowired
	private FbContractOverWjDao dao;
	
	@Autowired
	private AccessoryDao adao;
	
	@Transactional
	@Override
	public int addFbContractOverWj(FbContractOverWj fbContractOverWj) {
		int i=dao.addFbContractOverWj(fbContractOverWj);
		if(i>0){
			List<Accessory> accessory=fbContractOverWj.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
			List<Accessory> accessory1=fbContractOverWj.getAccessory1();
			if(accessory1!=null){
				i=adao.addAccessory(accessory1);
			}
		}
		return i;
	}

	@Override
	public List<FbContractOverWj> selectFbContractOverWj() {
		return dao.selectFbContractOverWj();
	}

	@Override
	public FbContractOverWj getFbOverMoney(String no) {
		return dao.getFbOverMoney(no);
	}

}

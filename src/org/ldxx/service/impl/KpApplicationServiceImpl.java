package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.KpApplication;
import org.ldxx.dao.KpApplicationDao;
import org.ldxx.service.KpApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KpApplicationServiceImpl implements KpApplicationService{

	@Autowired
	private KpApplicationDao dao;
	
	@Override
	public int addKpApplication(KpApplication kp) {
		return dao.addKpApplication(kp);
	}

	@Override
	public List<KpApplication> selectKpApplication(String status) {
		return dao.selectKpApplication(status);
	}

	@Override
	public float getAllMoney(String contractNo, String prjNo) {
		return dao.getAllMoney(contractNo, prjNo);
	}

}

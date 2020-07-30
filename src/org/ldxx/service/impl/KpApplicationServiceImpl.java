package org.ldxx.service.impl;

import java.math.BigDecimal;
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
	public BigDecimal getAllMoney(String contractNo, String prjNo) {
		return dao.getAllMoney(contractNo, prjNo);
	}

	@Override
	public int buleFpNo(String no, String id) {
		return dao.buleFpNo(no, id);
	}

	@Override
	public List<KpApplication> getKpNo(String no) {
		return dao.getKpNo(no);
	}

	@Override
	public KpApplication getAllKpMoneyByFpNo(String no) {
		return dao.getAllKpMoneyByFpNo(no);
	}

	@Override
	public List<KpApplication> getAllKpMoneyByFpNoAndTaskNo(String taskno, String contractno) {
		String tno="%"+taskno+"%";
		return dao.getAllKpMoneyByFpNoAndTaskNo(tno,contractno);
	}

	@Override
	public int countfpNo() {
		return dao.countfpNo();
	}

	@Override
	public List<KpApplication> getAllkpNo() {
		return dao.getAllkpNo();
	}

	@Override
	public KpApplication getKpApplicationBykpNo(String kpno) {
		return dao.getKpApplicationBykpNo(kpno);
	}

	@Override
	public KpApplication getKpApplicationById(String id) {
		return dao.getKpApplicationBykpId(id);
	}

	@Override
	public int updateKpApplicationById(KpApplication kp) {
		return dao.updateKpApplicationById(kp);
	}

	@Override
	public int updateKpNoById(String id, String code) {
		return dao.updateKpNoById(id,code);
	}

}

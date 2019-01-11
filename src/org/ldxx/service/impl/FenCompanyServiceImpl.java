package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.FenCompany;
import org.ldxx.dao.FenCompanyDao;
import org.ldxx.service.FenCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FenCompanyServiceImpl implements FenCompanyService{

	@Autowired
	private FenCompanyDao fenCompanyDao;
	
	@Override
	public List<FenCompany> selectFenCompany() {
		return fenCompanyDao.selectFenCompany();
	}

	@Override
	public int addFenCompany(FenCompany job) {
		int i=fenCompanyDao.addFenCompany(job);
		return i;
	}

	@Override
	public int deleteFenCompany(String id) {
		return fenCompanyDao.deleteFenCompany(id);
	}

	@Override
	public int updateFenCompany(FenCompany job) {
		int	i=fenCompanyDao.updateFenCompany(job);
		return i;
	}

}

package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Enterprise;
import org.ldxx.dao.EnterpriseDao;
import org.ldxx.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseServiceImpl implements EnterpriseService{

	@Autowired
	private EnterpriseDao dao;
	
	@Override
	public List<Enterprise> selectEnterpriseById(String id) {
		return dao.selectEnterpriseById(id);
	}

	@Override
	public List<Enterprise> selectEnterpriseByIdAndName(String id, String name) {
		return dao.selectEnterpriseByIdAndName(id, name);
	}

	@Override
	public int countOfEnterprise(Enterprise etel) {
		int i=dao.countOf(etel);
		if(i==0){
			i=dao.addEnterpriseFirst(etel);
		}
		return i;
	}

}

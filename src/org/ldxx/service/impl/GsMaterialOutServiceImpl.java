package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.CompanyMateriaOut;
import org.ldxx.dao.GsMaterialOutDao;
import org.ldxx.service.GsMaterialOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GsMaterialOutServiceImpl implements GsMaterialOutService {

	@Autowired
	private GsMaterialOutDao dao;

	@Override
	public List<CompanyMateriaOut> selectGsMaterialOut() {
		return dao.selectGsMaterialOut();
	}

	@Override
	public int addGsMaterialOutSave(CompanyMateriaOut cm) {
		return dao.addGsMaterialOutSave(cm);
	}
}

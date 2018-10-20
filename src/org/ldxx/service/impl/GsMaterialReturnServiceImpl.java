package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.CompanyMaterialReturn;
import org.ldxx.dao.GsMaterialReturnDao;
import org.ldxx.service.GsMaterialReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GsMaterialReturnServiceImpl implements GsMaterialReturnService {

	@Autowired
	private GsMaterialReturnDao dao;

	@Override
	public List<CompanyMaterialReturn> selectGsMaterialReturn() {
		return dao.selectGsMaterialReturn();
	}

	@Override
	public int addGsMaterialReturnSave(CompanyMaterialReturn mr) {
		return dao.addGsMaterialReturnSave(mr);
	}

	@Override
	public int updateGsMaterialReturnSave(CompanyMaterialReturn mr) {
		return dao.updateGsMaterialReturnSave(mr);
	}

	@Override
	public int deleteGsMaterialReturn(String id) {
		return dao.deleteGsMaterialReturn(id);
	}
}

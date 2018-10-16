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

	@Override
	public List<CompanyMateriaOut> selectXmMaterialOutByNo(String no) {
		no="%"+no+"%";
		return dao.selectXmMaterialOutByNo(no);
	}

	@Override
	public List<CompanyMateriaOut> selectClByNo(String no) {
		return dao.selectClByNo(no);
	}

	@Override
	public CompanyMateriaOut selectNoByName(String name) {
		return dao.selectNoByName(name);
	}

	@Override
	public CompanyMateriaOut selectNameByNo(String no) {
		return dao.selectNameByNo(no);
	}

	@Override
	public List<CompanyMateriaOut> selectClListByNo(String no) {
		return dao.selectClListByNo(no);
	}

	@Override
	public List<CompanyMateriaOut> selectClListByName(String name) {
		return dao.selectClListByName(name);
	}

	@Override
	public CompanyMateriaOut selectClInfoByNoAndClName(String no, String clName) {
		return dao.selectClInfoByNoAndClName(no, clName);
	}
}

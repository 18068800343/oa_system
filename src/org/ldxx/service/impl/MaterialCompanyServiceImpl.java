package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.MaterialCompany;
import org.ldxx.dao.MaterialCompanyDao;
import org.ldxx.service.MaterialCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MaterialCompanyServiceImpl implements MaterialCompanyService {
	
	@Autowired
	private MaterialCompanyDao dao;

	@Override
	public int addMaterialCompany(MaterialCompany mc) {
		int i=dao.countOfmcName(mc.getMcName());
		if(i==0){
			i= dao.addMaterialCompany(mc);
		}else{
			i=-1;
		}
		return i;
	}

	@Override
	public List<MaterialCompany> getAllMaterialCompany() {
		return dao.getAllMaterialCompany();
	}

	@Override
	public int deleteMaterialCompanyById(String id) {
		return dao.deleteMaterialCompanyById(id);
	}

	@Override
	public int updateMaterialCompany(MaterialCompany mc) {
		int i=dao.countOfmcName(mc.getMcName());
		if(i==0){
			i= dao.updateMaterialCompany(mc);
		}else{
			i=-1;
		}
		return i;
	}

}

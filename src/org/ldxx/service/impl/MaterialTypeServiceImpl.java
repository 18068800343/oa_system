package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.MaterialType;
import org.ldxx.dao.MaterialTypeDao;
import org.ldxx.service.MaterialTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MaterialTypeServiceImpl implements MaterialTypeService {
	
	@Autowired
	private MaterialTypeDao dao;

	@Override
	public int addMaterialType(MaterialType mt) {
		return dao.addMaterialType(mt);
	}

	@Override
	public int deleteMaterialTypeById(String id) {
		return dao.deleteMaterialTypeById(id);
	}

	@Override
	public int updateMaterialTypeById(MaterialType mt) {
		return dao.updateMaterialTypeById(mt);
	}

	@Override
	public List<MaterialType> selectMaterialType() {
		return dao.selectMaterialType();
	}

	@Override
	public int materialTypecount(String materialType) {
		return dao.materialTypecount(materialType);
	}

}

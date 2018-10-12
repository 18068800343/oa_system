package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.MaterialDemand;
import org.ldxx.dao.MaterialDemandDao;
import org.ldxx.service.MaterialDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialDemandServiceImpl implements MaterialDemandService{

	@Autowired
	private MaterialDemandDao dao;
	
	@Override
	public int addMaterialDemand(List<MaterialDemand> md) {
		return dao.addMaterialDemand(md);
	}

	@Override
	public List<MaterialDemand> selectMaterialDemandById(String id) {
		return dao.selectMaterialDemandById(id);
	}

	
}

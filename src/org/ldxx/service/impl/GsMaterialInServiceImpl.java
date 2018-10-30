package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CompanyMateriaIn;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.GsMaterialInDao;
import org.ldxx.dao.MaterialDemandDao;
import org.ldxx.service.GsMaterialInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GsMaterialInServiceImpl implements GsMaterialInService {
	
	@Autowired
	private GsMaterialInDao gmDao;
	
	@Autowired
	private AccessoryDao adao;
	
	@Autowired
	private MaterialDemandDao mdao;
	
	@Override
	public List<CompanyMateriaIn> selectGsMaterialIn() {
		return gmDao.selectGsMaterialIn();
	}

	@Override
	public int addGsMaterialInSave(CompanyMateriaIn cm) {
		int i=gmDao.addGsMaterialInSave(cm);
		if(i>0){
			List<Accessory> accessory=cm.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
		}
		return i;
	}


	@Override
	public List<Accessory> selectAccessoryById(String id) {
		return adao.selectAccessoryById(id);
	}

	@Override
	public int deleteAccessoryByIdAndName(Accessory accessory) {
		return adao.deleteAccessoryByIdAndName(accessory);
	}

	@Override
	public List<CompanyMateriaIn> selectcgNotaskNoPrjName() {
		return gmDao.selectcgNotaskNoPrjName();
	}

	@Override
	public List<CompanyMateriaIn> selecttaskNoPrjNameBycgNo(String cgNo) {
		return gmDao.selecttaskNoPrjNameBycgNo(cgNo);
	}

	@Override
	public List<CompanyMateriaIn> selectcgNotaskNoPrjNameBycgName(String cgName) {
		return gmDao.selectcgNotaskNoPrjNameBycgName(cgName);
	}

	@Override
	public int updateGsMaterialInSave(CompanyMateriaIn cm) {
		return gmDao.updateGsMaterialInSave(cm);
	}

	@Override
	public int updateMaterialbuyUnitAndManufacturer(String id,String unit, String manufacturer) {
		return mdao.updateMaterialbuyUnitAndManufacturer(id,unit,manufacturer);
	}


}

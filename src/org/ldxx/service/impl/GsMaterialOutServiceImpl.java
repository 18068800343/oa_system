package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CompanyMateriaOut;
import org.ldxx.dao.AccessoryDao;
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
	@Autowired
	private AccessoryDao adao;
	
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
	public CompanyMateriaOut selectNoByName(String name) {
		return dao.selectNoByName(name);
	}

	@Override
	public CompanyMateriaOut selectNameByNo(String no) {
		return dao.selectNameByNo(no);
	}

	@Transactional
	@Override
	public int updateStatus(CompanyMateriaOut out) {
		int i=dao.updateStatus(out);
		if(i>0){
			List<Accessory> accessory=out.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
		}
		return i;
	}

	@Override
	public List<CompanyMateriaOut> selectAllXmMaterialOut() {
		return dao.selectAllXmMaterialOut();
	}

	@Override
	public List<CompanyMateriaOut> selectCompanyMateriaOutForEnd(String no) {
		no="%"+no+"%";
		return dao.selectCompanyMateriaOutForEnd(no);
	}
}

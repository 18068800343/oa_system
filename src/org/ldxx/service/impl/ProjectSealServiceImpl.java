package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.SignetManage;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.ProjectSealDao;
import org.ldxx.service.ProjectSealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProjectSealServiceImpl implements ProjectSealService {
	
	@Autowired
	private ProjectSealDao prjSealDao;
	
	@Autowired
	private AccessoryDao adao;

	@Override
	public List<SignetManage> selectPrjSeal(String status) {
		return prjSealDao.selectPrjSeal(status);
	}

	@Override
	public int addPrjSeal(SignetManage signetManage) {
		int i=prjSealDao.addPrjSeal(signetManage);
		return i;
	}

	@Override
	public int deletePrjSealById(String id) {
		int i=prjSealDao.deletePrjSealById(id);
		return i;
	}

	@Override
	public int updatePrjSealById(SignetManage signetManage) {
		int i= prjSealDao.updatePrjSealById(signetManage);
		return i;
	}

	@Override
	public SignetManage selectPrjSealById(String smId) {
		SignetManage signetManage = prjSealDao.selectPrjSealById(smId);
		List<Accessory>accessory=adao.selectAccessoryById(smId);
		signetManage.setAccessory(accessory);
		return signetManage;
	}


	@Override
	public int deleteAccessoryByIdAndName(Accessory accessory) {
		return adao.deleteAccessoryByIdAndName(accessory);
	}

	@Transactional
	@Override
	public int addStop(SignetManage signetManage) {
		int i=prjSealDao.addStop(signetManage);
		if(i>0){
			List<Accessory> accessory=signetManage.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
		}
		return i;
	}

	@Override
	public int updateStatus(String id, String status) {
		return prjSealDao.updateStatus(id, status);
	}

	@Override
	public int updateStatusByNo(String no, String status) {
		return prjSealDao.updateStatusByNo(no, status);
	}

	@Override
	public int countSignet(String year) {
		year="%"+year+"%";
		return prjSealDao.countSignet(year);
	}

}

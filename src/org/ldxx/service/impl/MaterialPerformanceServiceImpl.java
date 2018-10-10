package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.clfbCgcontractPerformance;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.MaterialPerformanceDao;
import org.ldxx.service.MaterialPerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MaterialPerformanceServiceImpl implements MaterialPerformanceService {

	@Autowired
	private MaterialPerformanceDao mpDao;
	
	@Autowired
	private AccessoryDao adao;

	@Override
	public List<clfbCgcontractPerformance> selectmaterialPerformanceByStatus(String status) {
		return mpDao.selectmaterialPerformanceByStatus(status);
	}

	@Override
	public int pNocount() {
		return mpDao.pNocount();
	}

	@Override
	public int addmaterialPerformanceSave(clfbCgcontractPerformance c) {
		int i=mpDao.addmaterialPerformanceSave(c);
		if(i>0){
			List<Accessory> accessory=c.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
		}
		return i;
	}

	@Override
	public void updateHistoryById(String pId) {
		mpDao.updateHistoryById(pId);
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
	public List<clfbCgcontractPerformance> selectHistoryByNo(String no) {
		return mpDao.selectHistoryByNo(no);
	}
}

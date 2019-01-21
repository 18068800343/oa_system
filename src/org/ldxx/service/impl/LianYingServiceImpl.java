package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.LianYing;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.LianYingDao;
import org.ldxx.service.LianYingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LianYingServiceImpl implements LianYingService{

	@Autowired
	private LianYingDao dao;
	@Autowired
	private AccessoryDao aDao;
	
	@Transactional
	@Override
	public int addLianYing(LianYing ly) {
		int i=dao.addLianYing(ly);
		if(i>0){
			List<Accessory> accessory=ly.getAccessory();
			if(accessory!=null){
				i=aDao.addAccessory(accessory);
			}
		}
		return i;
	}

	@Override
	public List<LianYing> selectLianYingByStatus(String status) {
		List<LianYing> list=dao.selectLianYingByStatus(status);
		return list;
	}

	@Override
	public LianYing selectLianYingById(String id) {
		LianYing ly=dao.selectLianYingById(id);
		return ly;
	}

	@Override
	public int lyNoCount(String year) {
		year="%"+year+"%";
		return dao.lyNoCount(year);
	}

}

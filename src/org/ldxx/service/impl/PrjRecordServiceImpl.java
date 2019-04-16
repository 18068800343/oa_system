package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.PrjRecord;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.PrjRecordDao;
import org.ldxx.service.PrjRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrjRecordServiceImpl implements PrjRecordService{

	@Autowired
	private PrjRecordDao pDao;
	@Autowired
	private AccessoryDao aDao;
	
	@Transactional
	@Override
	public int addPrjRecord(PrjRecord pr) {
		return pDao.addPrjRecord(pr);
	}

	@Override
	public List<PrjRecord> selectPrjRecord() {
		List<PrjRecord> list=pDao.selectPrjRecord();
		return list;
	}

	@Override
	public int updateJyStatus(String id, int status) {
		int i=pDao.updateJyStatus(id, status);
		return i;
	}

	@Override
	public int updateScStatus(String id, int status) {
		return pDao.updateScStatus(id, status);
	}

	@Override
	public int prjCount(String no) {
		return pDao.prjCount(no);
	}

	@Override
	public int delPrj(String id) {
		int i=pDao.delPrj(id);
		if(i>0){
			aDao.deleteAccessory(id);
		}
		return i;
	}

}

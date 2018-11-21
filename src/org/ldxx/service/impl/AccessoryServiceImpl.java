package org.ldxx.service.impl;

import java.io.File;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessoryServiceImpl implements AccessoryService{

	@Autowired
	private AccessoryDao dao;
	
	@Override
	public int addAccessory(List<Accessory> accessory) {
		return dao.addAccessory(accessory);
	}

	@Override
	public int deleteAccessory(String id) {
		return dao.deleteAccessory(id);
	}

	@Override
	public List<Accessory> selectAccessoryById(String id) {
		return dao.selectAccessoryById(id);
	}

	@Override
	public int deleteAccessoryByIdAndName(Accessory accessory) {
		int i=dao.deleteAccessoryByIdAndName(accessory);
		if(i>0){
			String path=accessory.getAcUrl();
			File f=new File(path);
			f.delete();
		}
		return i;
	}

	@Override
	public List<Accessory> selectAccessoryByIdAndType(String id, String type) {
		return dao.selectAccessoryByIdAndType(id, type);
	}

}

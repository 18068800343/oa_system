package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.SignetManage;
import org.ldxx.bean.SignetUsers;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.SignetUsersDao;
import org.ldxx.service.SignetUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SignetUsersServiceImpl implements SignetUsersService {

	@Autowired
	private SignetUsersDao sUserDao;
	
	@Autowired
	private AccessoryDao adao;

	@Override
	public int addsUser(SignetUsers sUser) {
		int i=sUserDao.addsUser(sUser);
		if(i>0){
			List<Accessory> accessory = sUser.getAccessory();
			if(accessory!=null){
				i = adao.addAccessory(accessory);
			}
		}
		return i;
	}

	@Override
	public int deletesUserById(String suId) {
		int i=sUserDao.deletesUserById(suId);
		if(i>0){
			i=adao.deleteAccessory(suId);
		}
		return i;
	}

	@Override
	public int updatesUser(SignetUsers sUser) {
		int i= sUserDao.updatesUser(sUser);
		if(i>0){
			List<Accessory> accessory = sUser.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
		}
		return i;
	}

	@Override
	public List<SignetUsers> selectUser() {
		return sUserDao.selectUser();
	}
	
	@Override
	public SignetUsers selectUsersById(String suId) {
		SignetUsers sm=sUserDao.selectUsersById(suId);
		List<Accessory> accessory=adao.selectAccessoryById(suId);
		sm.setAccessory(accessory);
		return sm;
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
	public List<SignetManage> selectSignetNo() {
		return sUserDao.selectSignetNo();
	}

	@Override
	public int addHuan(SignetUsers sUser) {
		return sUserDao.addHuan(sUser);
	}
}

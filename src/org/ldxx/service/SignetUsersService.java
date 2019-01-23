package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.SignetManage;
import org.ldxx.bean.SignetUsers;

public interface SignetUsersService {

	int addsUser(SignetUsers sUser);

	int deletesUserById(String suId);

	int updatesUser(SignetUsers sUser);

	List<SignetUsers> selectUser();

	SignetUsers selectUsersById(String suId);

	List<Accessory> selectAccessoryById(String id);

	int deleteAccessoryByIdAndName(Accessory accessory);
	
	List<SignetManage> selectSignetNo(); 
	
	int addHuan(SignetUsers sUser);

}

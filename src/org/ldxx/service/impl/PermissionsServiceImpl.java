package org.ldxx.service.impl;

import java.util.List;
import java.util.Map;

import org.ldxx.bean.Permissions;
import org.ldxx.bean.PermissionsUser;
import org.ldxx.dao.PermissionsDao;
import org.ldxx.dao.PermissionsUserDao;
import org.ldxx.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionsServiceImpl implements PermissionsService {

	@Autowired
	private PermissionsDao dao;
	@Autowired
	private PermissionsUserDao pUserdao;

	@Override
	public Permissions getNameByPermissions(String uPermission) {
		return dao.getNameByPermissions(uPermission);
	}

	@Override
	public List<Permissions> getAllPermissions() {
		return dao.getAllPermissions();
	}

	@Override
	public int updatePermissionsSave(PermissionsUser pUser) {
		PermissionsUser pu=pUserdao.selectPermissionsUserById(pUser.getuId());
		if(pu!=null){
			return pUserdao.updatePermissionsSave(pUser);
		}else{
			return pUserdao.addPermissionsSave(pUser);
		}
	}
	
	@Override
	public String getPermissionsByuId(String uId)
	{
 		PermissionsUser pUser = pUserdao.selectPermissionsUserById(uId);
		
		return pUser==null?"":pUser.getuPermissions();
	}
}

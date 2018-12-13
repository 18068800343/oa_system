package org.ldxx.service.impl;

import java.util.List;
import java.util.Map;

import org.ldxx.bean.Permissions;
import org.ldxx.dao.PermissionsDao;
import org.ldxx.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionsServiceImpl implements PermissionsService {

	@Autowired
	private PermissionsDao dao;

	@Override
	public Permissions getNameByPermissions(String uPermission) {
		return dao.getNameByPermissions(uPermission);
	}
}

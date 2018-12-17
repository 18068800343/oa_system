package org.ldxx.service;

import java.util.List;
import java.util.Map;

import org.ldxx.bean.Permissions;
import org.ldxx.bean.PermissionsUser;

public interface PermissionsService {

	Permissions getNameByPermissions(String uPermission);

	List<Permissions> getAllPermissions();

	int updatePermissionsSave(PermissionsUser pUser);

}

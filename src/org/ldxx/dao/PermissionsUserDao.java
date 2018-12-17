package org.ldxx.dao;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.PermissionsUser;

public interface PermissionsUserDao {

	int addPermissionsSave(@Param("pUser")PermissionsUser pUser);

	PermissionsUser selectPermissionsUserById(@Param("uId")String uId);

	int updatePermissionsSave(@Param("pUser")PermissionsUser pUser);

}

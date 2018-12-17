package org.ldxx.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Permissions;

public interface PermissionsDao {

	Permissions getNameByPermissions(@Param("uPermission")String uPermission);

	List<Permissions> getAllPermissions();

}

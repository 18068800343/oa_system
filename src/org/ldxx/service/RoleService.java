package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.ClOut;
import org.ldxx.bean.ClOutInfo;
import org.ldxx.bean.Role;

public interface RoleService {

	public int addRole(Role role);
	
	public List<Role> selectRoleList();

	List<Role> selectParentRoles();
	
	String addRoleByInput(String inputRoleName, String parentRole, String ifCouXiang) throws Exception;

	List<Role> selectRoleListById();

	int updatePersonRole(String personId, String personRoles);

	List<Role> selectRolesSort();

	public int delRole(String id);

	public int updRole(String id, String roleName);
	
}

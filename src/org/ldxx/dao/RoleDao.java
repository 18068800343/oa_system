package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ClOut;
import org.ldxx.bean.ClOutInfo;
import org.ldxx.bean.Role;

public interface RoleDao {

	public int addRole(@Param("role")Role role);
	
	public int updatePersonRole(@Param("personId")String personId,@Param("personRoles")String personRoles);
	
	public List<Role> selectRoleOneByCodeLength(@Param("length")Integer length);
	
	public List<Role> selectRoleTwoByCodeLength(@Param("length")Integer length);
	
	public List<Role> selectRoleByCodeLike(@Param("code")String code,@Param("length")Integer length);

	public List<Role> selectRolesSort();
	
	public List<Role> selectRoleByRoleCode(String roleCode);
	
	public Role selectRoleById(String id);
	
	public List<Role> selectRoleByRoleName(@Param("name")String name);

	public int delRole(@Param("id")String id);

	public int updRole(@Param("id")String id,@Param("roleName") String roleName);
}

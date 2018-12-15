package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ClOut;
import org.ldxx.bean.ClOutInfo;
import org.ldxx.bean.Role;

public interface RoleDao {

	public int addRole(@Param("role")Role role);
	
	public List<Role> selectRoleOneByCodeLength(@Param("length")Integer length);
	
	public List<Role> selectRoleTwoByCodeLength(@Param("length")Integer length);
	
	public List<Role> selectRoleByCodeLike(@Param("code")String code,@Param("length")Integer length);

	public List<Role> selectRolesSort();
	
	public List<Role> selectRoleByRoleCode(String roleCode);
}
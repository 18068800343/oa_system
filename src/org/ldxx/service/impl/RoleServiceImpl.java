package org.ldxx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.Role;
import org.ldxx.dao.RoleDao;
import org.ldxx.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired 
	RoleDao roleDao;
	@Override
	public int addRole(Role role) {
		int i = roleDao.addRole(role);
		return i;
	}
	@Override
	public int updatePersonRole(String personId,String personRoles) {
		int i = roleDao.updatePersonRole(personId, personRoles);
		return i;
	}
	@Override
	public List<Role> selectRoleList() {
		List<Role> roles = roleDao.selectRoleOneByCodeLength(4);
		List<Role> newRoles = new ArrayList<>();
		for(Role role:roles){
			String code = role.getRoleCode();
			List<Role> roles2 = roleDao.selectRoleByCodeLike(code+"%",8);
			role.setNodes(roles2);
			newRoles.add(role);
		}
		return newRoles;
	}
	@Override
	public List<Role> selectRoleListById() {
		List<Role> roles = roleDao.selectRoleOneByCodeLength(4);
		List<Role> newRoles = new ArrayList<>();
		for(Role role:roles){
			role.setParentRoleCode("0");
			String code = role.getRoleCode();
			List<Role> roles2 = roleDao.selectRoleByCodeLike(code+"%",8);
			for(Role role2 :roles2){
				role2.setParentRoleCode(role.getRoleCode());
			}
			role.setNodes(roles2);
			newRoles.add(role);
		}
		return newRoles;
	}
	@Override
	public List<Role> selectParentRoles() {
		List<Role> roles = roleDao.selectRoleOneByCodeLength(4);
		return roles;
	}

	@Override
	public String addRoleByInput(String inputRoleName,String parentRole,String ifCouXiang) throws Exception{
		int result=5;
		List<Role> rolesSort = roleDao.selectRolesSort();
		//确定角色编码   01   08
		String codeBasic = "";
		int key = 0;
		if(rolesSort!=null&&rolesSort.size()>0){
			Integer id = rolesSort.get(0).getId()+1;
			key=rolesSort.get(0).getId()+1;
			codeBasic = id.toString();
			if(codeBasic.length()==1){
				codeBasic="0"+codeBasic;
				key=1;
			}
		}else{
			codeBasic="01";
		}
		//parentRole 为0 则表明本次新建角色无父级角色  1有父角色
		//ifCouXiang 为0 则表明本次新建角色是抽象角色 1不是抽象角色
		
		if(ifCouXiang.equals("0")){
			Role role = new Role();
			if("0".equals(parentRole)){
				role.setId(key);
				role.setRoleCode("r"+codeBasic+"*.");
				role.setRoleSort(codeBasic);
				role.setRoleName(inputRoleName);
			}else{
				role.setId(key);
				role.setRoleCode(parentRole+"r"+codeBasic+"*.");
				role.setRoleSort(codeBasic);
				role.setRoleName(inputRoleName);
			}
			result = roleDao.addRole(role);
		}else{
			Role role = new Role();
			if("0".equals(parentRole)){
				role.setId(key);
				role.setRoleCode("r"+codeBasic+".");
				role.setRoleSort(codeBasic);
				role.setRoleName(inputRoleName);
			}else{
				role.setId(key);
				role.setRoleCode(parentRole+"r"+codeBasic+".");
				role.setRoleSort(codeBasic);
				role.setRoleName(inputRoleName);
			}
			result = roleDao.addRole(role);
		}
		return result+"";
	}
}

package org.ldxx.controller;

import java.util.List;
import org.ldxx.bean.Role;
import org.ldxx.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/role")
@Controller
public class RoleController {
	
	@Autowired
	private RoleService service;
	
	@RequestMapping("/getRolesList")
	@ResponseBody
	public List<Role> getRolesList(){
		List<Role> roles = service.selectRoleList();
		return roles;
	}
	@RequestMapping("/initRoleListById")
	@ResponseBody
	public List<Role> initRoleListById(){
		List<Role> roles = service.selectRoleListById();
		return roles;
	}
	@RequestMapping("/updateParentRole")
	@ResponseBody
	public int  updateParentRole(String personId,String personRoles){
		if("".equals(personRoles.trim())){
			personRoles="";
		}else{
			personRoles = personRoles.substring(0,personRoles.length()-1);
		}
		int i = service.updatePersonRole(personId, personRoles);
		return i;
	}
	@RequestMapping("/getParentRoles")
	@ResponseBody
	public List<Role> getParentRoles(){
		List<Role> roles = service.selectRoleList();
		return roles;
	}
	
	@RequestMapping("/addRole")
	@ResponseBody
	public String addRole(String inputRoleName,String parentRole,String ifCouXiang){
		String aString = "";
		try {
			aString = service.addRoleByInput(inputRoleName, parentRole, ifCouXiang);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aString;
	}
	
	@RequestMapping("/selectRolesSort")
	@ResponseBody
	public List<Role> selectRolesSort(){
		List<Role> roles = service.selectRolesSort();
		return roles;
	}
	
	@RequestMapping("/delRole")
	@ResponseBody
	public int delRole(String id){
		int i=service.delRole(id);
		return i;
	}
	
	@RequestMapping("/updRole")
	@ResponseBody
	public int updRole(String id,String roleName){
		int i=service.updRole(id,roleName);
		return i;
	}
	
}

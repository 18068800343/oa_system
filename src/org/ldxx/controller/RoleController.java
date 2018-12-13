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
	
}

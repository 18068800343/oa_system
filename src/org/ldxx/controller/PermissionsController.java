package org.ldxx.controller;
/**
 * 权限管理
 * @author hp
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.Permissions;
import org.ldxx.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("permissions")
@Controller
public class PermissionsController {
	
	@Autowired
	private PermissionsService service;
	
	@RequestMapping("/getNameByPermissions")
	@ResponseBody
	public List<Permissions> getNameByPermissions(String uPermissions){
		List<Permissions> list=new ArrayList<>();
		String[] splitValue = uPermissions.split(",");
		for(int i=0;i<splitValue.length;i++){
			String uPermission=splitValue[i];
			Permissions pers=service.getNameByPermissions(uPermission);
			list.add(pers);
		}
		return list;
	}

}

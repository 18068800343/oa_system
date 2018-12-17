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
import org.ldxx.bean.PermissionsUser;
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
		if(uPermissions!=null&&uPermissions!=""){
			String[] splitValue = uPermissions.split(",");
			for(int i=0;i<splitValue.length;i++){
				String uPermission=splitValue[i];
				Permissions pers=service.getNameByPermissions(uPermission);
				list.add(pers);
			}
		}
		return list;
	}
	
	@RequestMapping("/getAllPermissions")
	@ResponseBody
	public Map<String,Object> getAllPermissions(){
		Map<String,Object> map=new HashMap<>();
		List<Permissions> list= service.getAllPermissions();
		map.put("list",list);
		List<Permissions> list1=new ArrayList<>();
		List<Permissions> list2=new ArrayList<>();
		List<Permissions> list3=new ArrayList<>();
		List<Permissions> list4=new ArrayList<>();
		List<Permissions> list5=new ArrayList<>();
		List<Permissions> list6=new ArrayList<>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getCoding().length()==3){//一级菜单栏
				list1.add(list.get(i));
				map.put("list1",list1);
			}else if(list.get(i).getCoding().length()==4){//二级子菜单栏
				list2.add(list.get(i));
				map.put("list2",list2);
			}else if(list.get(i).getCoding().length()==5){//三级子菜单栏
				list3.add(list.get(i));
				map.put("list3",list3);
			}else if(list.get(i).getCoding().length()==6){//四级子菜单栏
				list4.add(list.get(i));
				map.put("list4",list4);
			}else if(list.get(i).getCoding().length()==7){//五级子菜单栏
				list5.add(list.get(i));
				map.put("list5",list5);
			}else{										//六级子菜单栏
				list6.add(list.get(i));
				map.put("list6",list6);
			}
		}
		return map;
	}
	
	//修改保存
	@RequestMapping("/updatePermissionsSave")
	@ResponseBody
	public int updatePermissionsSave(PermissionsUser pUser){
		int i=service.updatePermissionsSave(pUser);
		return i;
	}

}

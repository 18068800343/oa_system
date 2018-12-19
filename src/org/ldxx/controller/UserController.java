package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.User;
import org.ldxx.service.UserService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 人员用户管理
 * @author hp
 *
 */
@RequestMapping("user")
@Controller
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping("/addUser")
	@ResponseBody
	public Map<String,Object> addUser(User user){
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		user.setUserId(uuid.getTimeUUID());
		int count=userservice.countuserCode();
		user.setUserCode(uuid.getUserCode(count+1));
		int i = userservice.countOfusername(user.getUsername());
		if(i>0){/*用户名已存在*/
			i= 2;
		}
		int j = userservice.countOfworkId(user.getWorkId());
		if(j>0){/*工号已存在*/
			i= 3;
		}
		int k = userservice.countOfrecordNo(user.getRecordNo());
		if(k>0){/*档案号已存在*/
			i= 4;
		}
		i = userservice.addUser(user);
		map.put("result", i);
		map.put("user", user);
		return map;
	}
	
	@RequestMapping("/deleteUser")
	@ResponseBody
	public int deleteUser(String userId){
		return userservice.deleteUser(userId);
	}
	
	@RequestMapping("/updateUser")
	@ResponseBody
	public Map<String,Object> updateUser(User user){
		Map<String,Object> map=new HashMap<>();
		int i = userservice.countOfusernameEdit(user.getUsername(),user.getUserId());
		if(i>0){/*用户名已存在*/
			i= 2;
		}
		int j = userservice.countOfworkIdEdit(user.getWorkId(),user.getUserId());
		if(j>0){/*工号已存在*/
			i= 3;
		}
		int k = userservice.countOfrecordNoEdit(user.getRecordNo(),user.getUserId());
		if(k>0){/*档案号已存在*/
			i= 4;
		}
		i= userservice.updateUser(user);
		map.put("result", i);
		map.put("user", user);
		return map;
	}

	@RequestMapping("/selectAllUser")
	@ResponseBody
	public List<User> selectAllUser(){
		return userservice.selectAllUser();
	}
	
	@RequestMapping("/selectUserById")
	@ResponseBody
	public User selectUserById(String userId){
		return userservice.selectUserById(userId);
	}
	
	@RequestMapping("/selectUserByomId")
	@ResponseBody
	public List<User> selectUserByomId(String omId){
		return userservice.selectUserByomId(omId);
	}
	
	@RequestMapping("/selectUserAndRoles")
	@ResponseBody
	public List<User> selectUserAndRoles(){
		return userservice.selectUserAndRoles();
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("/updatePasswordById")
	@ResponseBody
	public int updatePasswordById(String userId,String password){
		String old_password = password.split(",")[0];
		String new_password = password.split(",")[1];
		User user = userservice.selectUserById(userId);
		int i=0;
		if(!user.getPassword().equals(old_password)){
			i=-1;
		}else if(user.getPassword().equals(new_password)){
			i=-2;
		}else{
			i=userservice.updatePasswordById(userId,new_password);
		}
		return i;
	}
}

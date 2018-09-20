package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.User;
import org.ldxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 人员用户管理
 * @author hp
 *
 */
@RequestMapping("flowHistory")
@Controller
public class FlowHistoryController {
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping("/addUser")
	@ResponseBody
	public int addUser(User user){
		int i = userservice.countOfusername(user.getUsername());
		if(i>0){/*用户名已存在*/
			return 2;
		}
		int j = userservice.countOfworkId(user.getWorkId());
		if(j>0){/*工号已存在*/
			return 3;
		}
		int k = userservice.countOfrecordNo(user.getRecordNo());
		if(k>0){/*档案号已存在*/
			return 4;
		}
		return userservice.addUser(user);
	}
	
	@RequestMapping("/deleteUser")
	@ResponseBody
	public int deleteUser(String userId){
		return userservice.deleteUser(userId);
	}
	
	@RequestMapping("/updateUser")
	@ResponseBody
	public int updateUser(User user){
		int i = userservice.countOfusernameEdit(user.getUsername(),user.getUserId());
		if(i>0){/*用户名已存在*/
			return 2;
		}
		int j = userservice.countOfworkIdEdit(user.getWorkId(),user.getUserId());
		if(j>0){/*工号已存在*/
			return 3;
		}
		int k = userservice.countOfrecordNoEdit(user.getRecordNo(),user.getUserId());
		if(k>0){/*档案号已存在*/
			return 4;
		}
		return userservice.updateUser(user);
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
}

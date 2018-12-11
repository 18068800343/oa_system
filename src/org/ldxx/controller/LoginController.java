package org.ldxx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ldxx.bean.User;
import org.ldxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户登录
 * @author hp
 *
 */
@RequestMapping("login")
@Controller
public class LoginController {
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping("/userlogin")
	@ResponseBody
	public Map<String,Object> userlogin(User user,HttpServletRequest request){
		Map<String,Object> map=new HashMap<>();
		HttpSession session = request.getSession();
		String pass=userservice.countUsername(user.getUsername());//判断用户名是否存在,如果存在返回密码，不存在返回null
		int i=0;
		User us=null;
		if(pass!=null){
			if(pass.equals(user.getPassword())){
				us=userservice.selectUserByusername(user.getUsername());
				session.setAttribute("user", us);
				i=1;//登陆成功
			}else{
				i=-2;//密码不正确
			}
		}else{
			i=-1;//用户名不存在
		}
		map.put("result", i);
		map.put("user", us);
		return map;
	}
	
	@RequestMapping("/getUser")
	@ResponseBody
	public User getUser(HttpServletRequest request){
		User user=(User) request.getSession().getAttribute("user");
		return user;
	}

	@RequestMapping("/exit")//退出
	@ResponseBody
	public void exit(HttpServletRequest request){
		request.getSession().removeAttribute("user");
	}
	
}

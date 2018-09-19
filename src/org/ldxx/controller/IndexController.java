package org.ldxx.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
public class IndexController {
	
	
	@RequestMapping("/")
	public String returnLogin(){
		return "redirect:view/WEB/login.html";
	}
	@RequestMapping("login")
	public String returnDoLogin(){
		return "login";
	}
	
	@ResponseBody
	@RequestMapping("getData")
	public String returnAjax(){
		JSONObject object = new JSONObject();
		object.put("name", "夏宁");
		object.put("age", 17);
		return object.toString();
	}
}

package org.ldxx.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.User;
import org.ldxx.service.BusinessReminderService;
import org.ldxx.service.FlowHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 业务催办
 * @author hp
 *
 */

@RequestMapping("BusinessReminder")
@Controller
public class BusinessReminderController {
	
	@Autowired
	private BusinessReminderService service;
	
	@RequestMapping("/selectBusinessReminder")
	@ResponseBody
	public List<CurrentFlow> selectBusinessReminder(String status,HttpSession session){
		User user = (User) session.getAttribute("user");
	    String userId = user.getUserId();
	    user.getuName();
	    List<CurrentFlow> list=service.selectBusinessReminder(userId,status);
	    return list;
	}

}

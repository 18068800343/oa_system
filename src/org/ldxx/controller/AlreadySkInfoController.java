package org.ldxx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ldxx.bean.AlreadyRenling;
import org.ldxx.bean.ProjectList;
import org.ldxx.bean.User;
import org.ldxx.service.AlreadySkInfoService;
import org.ldxx.util.ExportData;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 收款认领
 * @author hp
 *
 */
@RequestMapping("AlreadySk")
@Controller
public class AlreadySkInfoController {
	
	@Autowired
	private AlreadySkInfoService service;
	
	@RequestMapping("/getyirenlingfpMoneyByKpno")//通过开票申请编号查询已认领的发票金额总和
	@ResponseBody
	public AlreadyRenling getyirenlingfpMoneyByKpno(String kpno){
		return service.getyirenlingfpMoneyByKpno(kpno);
	}
	
	
	@RequestMapping("/addAlreadyRenling")
	@ResponseBody
	public int addAlreadyRenling(@RequestBody AlreadyRenling ar){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		ar.setrId(id);
		int i=service.addAlreadyRenling(ar);
		return i;
	}
	
	@RequestMapping("/selectAlreadyRenling")//查status=2的已认领完的信息
	@ResponseBody
	public List<AlreadyRenling> selectAlreadyRenling(){
		return service.selectAlreadyRenling();
	}
	
	@RequestMapping("/selectAlreadySkBySkno")
	@ResponseBody
	public List<AlreadyRenling> selectAlreadySkBySkno(String skno){
		return service.selectAlreadySkBySkno(skno);
	}
	
	@RequestMapping("/deleteAlreadyRenlingById")
	@ResponseBody
	public int deleteAlreadyRenlingById(String rId){
		return service.deleteAlreadyRenlingById(rId);
	}
	
}

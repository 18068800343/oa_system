package org.ldxx.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.AlreadyRenling;
import org.ldxx.bean.AlreadySkInfo;
import org.ldxx.bean.User;
import org.ldxx.service.AlreadySkInfoService;
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
@RequestMapping("AlreadySkOmInfo")
@Controller
public class AlreadySkInfoController {
	
	@Autowired
	private AlreadySkInfoService service;
	
	
	@RequestMapping("/addAlreadySkInfo")
	@ResponseBody
	public int addAlreadySkInfo(@RequestBody AlreadyRenling ar,HttpSession session){
		User user = (User) session.getAttribute("user");
		String uName = user.getuName();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		ar.setrId(id);
		int count=service.countquerenNo();
		String no = uuid.getClCode("", count+1);
		ar.setQuerenNo(no);
		ar.setThisPerson(uName);
		int i=service.addAlreadyRenling(ar);
		return i;
	}
	
	
	/*@RequestMapping("/addAlreadySkInfo")
	@ResponseBody
	public int addAlreadySkInfo(@RequestBody AlreadySkInfo as,HttpSession session){
		User user = (User) session.getAttribute("user");
		String uName = user.getuName();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		as.setcId(id);
		as.setOperatorPerson(uName);
		int i=service.addAlreadySkInfo(as,uName);
		return i;
	}
	
	
	@RequestMapping("/selectAlreadySkInfo")
	@ResponseBody
	public List<AlreadySkInfo> selectAlreadySkInfo(){
		return service.selectAlreadySkInfo();
	}
	
	@RequestMapping("/selectAlreadySkInfoByskId")
	@ResponseBody
	public AlreadySkInfo selectAlreadySkInfoByskId(String skId){
		return service.selectAlreadySkInfoByskId(skId);
	}
	
	@RequestMapping("/updateStatusBack")//退回
	@ResponseBody
	public int updateStatusBack(String id,String status,String cId){//id是财务收款的id，cId是已认领的id
		return service.updateStatusBack(id,status,cId);
	}*/
}

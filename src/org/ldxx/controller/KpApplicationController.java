package org.ldxx.controller;

import java.util.List;

import org.ldxx.bean.KpApplication;
import org.ldxx.service.KpApplicationService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("kp")
public class KpApplicationController {

	@Autowired
	private KpApplicationService service;
	
	@RequestMapping("/addKpApplicationBySave")
	@ResponseBody
	public int addKpApplicationBySave(KpApplication kp){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		kp.setKpId(id);
		int i=service.addKpApplication(kp);
		return i;
	}
	
	@RequestMapping("/addKpApplicationBySubmit")
	@ResponseBody
	public int addKpApplicationBySubmit(KpApplication kp){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		kp.setKpId(id);
		int i=service.addKpApplication(kp);
		return i;
	}
	
	@RequestMapping("/selectKpApplication")
	@ResponseBody
	public List<KpApplication> selectKpApplication(String status){
		 List<KpApplication> list=service.selectKpApplication(status);
		 return list;
	}
	
	@RequestMapping("/getAllMoney")
	@ResponseBody
	public float getAllMoney(String contractNo,String prjNo){
		float all=service.getAllMoney(contractNo, prjNo);
		return all;
	}
	
}

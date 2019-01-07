package org.ldxx.controller;

import java.util.List;

import org.ldxx.bean.FinancialHk;
import org.ldxx.service.FinancialHkService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/FinancialHk")
public class FinancialHkController {

	@Autowired
	private FinancialHkService fService;
	
	@RequestMapping("/addFinancialHkBySave")
	@ResponseBody
	public int addFinancialHkBySave(FinancialHk hk){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		hk.setHkId(id);
		int i=fService.addFinancialHk(hk);
		return i;
	}
	
	@RequestMapping("/addFinancialHkBySubmit")
	@ResponseBody
	public int addFinancialHkBySubmit(FinancialHk hk){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		hk.setHkId(id);
		int i=fService.addFinancialHk(hk);
		return i;
	}
	
	@RequestMapping("/selectFinancialHk")
	@ResponseBody
	public List<FinancialHk> selectFinancialHk(){
		 List<FinancialHk> hk=fService.selectFinancialHk();
		 return hk;
	}
	
	@RequestMapping("/selectFinancialHkById")
	@ResponseBody
	public FinancialHk selectFinancialHkById(String id ){
		FinancialHk  hk=fService.selectFinancialHkById(id);
		return hk;
	}
	
	@RequestMapping("/updateFinancialHk")
	@ResponseBody
	public int updateFinancialHk(FinancialHk hk){
		int i=fService.updateFinancialHk(hk);
		return i;
	}
	
}

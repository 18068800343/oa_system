package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.FinancialReceipts;
import org.ldxx.service.FinancialReceiptsService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("FinancialReceipts")
public class FinancialReceiptsController {

	@Autowired
	private FinancialReceiptsService service;
	
	@RequestMapping("/addFinancialReceipts")
	@ResponseBody
	public Map<String,Object> addFinancialReceipts(FinancialReceipts fr){
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		fr.setFrId(id);
		int i=service.addFinancialReceipts(fr);
		map.put("result", i);
		map.put("fr", fr);
		return map;
	}
	
	@RequestMapping("/selectFinancialReceipts")
	@ResponseBody
	public List<FinancialReceipts> selectFinancialReceipts(){
		List<FinancialReceipts> list=service.selectFinancialReceipts();
		return list;
	}
	
	@RequestMapping("/selectFinancialReceiptsById")
	@ResponseBody
	public FinancialReceipts selectFinancialReceiptsById(String id){
		FinancialReceipts fr=service.selectFinancialReceiptsById(id);
		return fr;
	}
	
	@RequestMapping("/selectFinancialReceiptsByStatus")
	@ResponseBody
	public List<FinancialReceipts> selectFinancialReceiptsByStatus(String status){
		List<FinancialReceipts> list=service.selectFinancialReceiptsByStatus(status);
		return list;
	}
	
	@RequestMapping("/updateStatus")
	@ResponseBody
	public int updateStatus(String status,String id){
		int i=service.updateStatus(status, id);
		return i;
	}
	
}

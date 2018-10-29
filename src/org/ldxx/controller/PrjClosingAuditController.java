package org.ldxx.controller;

import java.util.List;

import org.ldxx.bean.PrjClosingAudit;
import org.ldxx.bean.PrjClosingAuditPerson;
import org.ldxx.service.PrjClosingAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("audit")
public class PrjClosingAuditController {

	@Autowired
	private PrjClosingAuditService service;
	
	@RequestMapping("/addPrjClosingAudit")
	@ResponseBody
	public int addPrjClosingAudit(@RequestBody PrjClosingAudit audit){
		int i=service.addPrjClosingAudit(audit);
		return i;
	}
	
	@RequestMapping("/selectPrjClosingAudit")
	@ResponseBody
	public List<PrjClosingAudit> selectPrjClosingAudit(){
		List<PrjClosingAudit> list=service.selectPrjClosingAudit();
		return list;
	}
	
	@RequestMapping("/selectPrjClosingAuditById")
	@ResponseBody
	public PrjClosingAudit selectPrjClosingAuditById(String id){
		PrjClosingAudit audit=service.selectPrjClosingAuditById(id);
		List<PrjClosingAuditPerson> person=service.selectPrjClosingAuditPersonById(id);
		audit.setPerson(person);
		return audit;
	}
	
}

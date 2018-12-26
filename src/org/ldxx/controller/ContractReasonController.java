package org.ldxx.controller;

import org.ldxx.bean.ContractReason;
import org.ldxx.service.ContractReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ContractReason")
public class ContractReasonController {

	@Autowired
	private ContractReasonService service;
	
	@RequestMapping("/selectContractReasonById")
	@ResponseBody
	public ContractReason selectContractReasonById(String id){
		ContractReason cr=service.selectContractReasonById(id);
		return cr;
	}
	
}

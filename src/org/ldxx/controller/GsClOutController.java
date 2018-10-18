package org.ldxx.controller;

import java.util.List;

import org.ldxx.bean.CompanyMateriaOut;
import org.ldxx.bean.GsClOut;
import org.ldxx.service.GsClOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("GsClOut")
public class GsClOutController {

	@Autowired
	private GsClOutService service;
	
	@RequestMapping("/selectClByNo")
	@ResponseBody
	public List<GsClOut> selectClByNo(String no){
		List<GsClOut> list=service.selectClByNo(no);
		return list;
	}
}

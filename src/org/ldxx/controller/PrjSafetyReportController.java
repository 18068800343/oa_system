package org.ldxx.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.ldxx.bean.PrjSafetyReport;
import org.ldxx.service.PrjSafetyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/PrjSafetyReport")
public class PrjSafetyReportController {

	@Autowired
	private PrjSafetyReportService pService;
	
	@RequestMapping("/selectPrjSafetyReport")
	@ResponseBody
	public List<PrjSafetyReport> selectPrjSafetyReport(){
		String time=getLastMonth();
		List<PrjSafetyReport> list=pService.selectPrjSafetyReport(time);
		return list;
	}
	
	@RequestMapping("/selectPrjSafetyReportByTime")
	@ResponseBody
	public List<PrjSafetyReport> selectPrjSafetyReportByTime(String time){
		List<PrjSafetyReport> list=pService.selectPrjSafetyReport(time);
		return list;
	}
	
	public String getLastMonth() {
		LocalDate today = LocalDate.now();
		today = today.minusMonths(1);
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM");
		return formatters.format(today);
	}
	
}

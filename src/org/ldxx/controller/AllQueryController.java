package org.ldxx.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.AllQuery;
import org.ldxx.service.AccessoryService;
import org.ldxx.service.AllQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/allQuery")
@Controller
public class AllQueryController {
	@Autowired
	private AllQueryService service;
	
	@RequestMapping("/allQueryTable")
	@ResponseBody
	public List<AllQuery> addAccessory(String depart){
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("YY-MM");
		String nowDate = simpleDateFormat.format(new Date());
		String[] timeArr = nowDate.split("-");
		String year_Time = timeArr[0]+"%";
		String month_time = nowDate;
		List<AllQuery> i=service.selectAllQueryByTimeAndDepart(year_Time, month_time, depart);
		for(AllQuery allQuery:i){
			String fbNo = allQuery.getFbNo();
			
		}
		return i;
	}
	
}

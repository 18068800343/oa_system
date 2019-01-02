package org.ldxx.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.AllQuery;
import org.ldxx.bean.Pay;
import org.ldxx.dao.PrjProgressFillDao;
import org.ldxx.service.AccessoryService;
import org.ldxx.service.AllQueryService;
import org.ldxx.service.ContractPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/allQuery")
@Controller
public class AllQueryController {
	@Autowired
	private AllQueryService service;
	@Autowired
	private PrjProgressFillDao prjProgressFillDao; 
	@Autowired
	private ContractPaymentService payService;
	
	@RequestMapping("/allQueryTable")
	@ResponseBody
	public List<AllQuery> addAccessory(String depart,String omName){
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("YY-MM");
		String nowDate = simpleDateFormat.format(new Date());
		String[] timeArr = nowDate.split("-");
		String year_Time = timeArr[0]+"%";
		String month_time = nowDate;
		List<AllQuery> i=service.selectAllQueryByTimeAndDepart(year_Time, month_time, depart,omName);
		for(AllQuery allQuery:i){
			String cjNo = allQuery.getContractNo();
			//累计付款
			Pay pay = payService.getTotalPayMoney(allQuery.getFbNo());
			String leijifkMoney = String.valueOf(pay.getAlreadyAccumulateMoney());
			allQuery.setLeiJiPayMoney(leijifkMoney);
			//未付金额
			String fbJueSuanMoney = allQuery.getFbJueSuanMoney();
			Double weiPayMoney = 0.0;
			if(fbJueSuanMoney!=null && !fbJueSuanMoney.equals("")){
				weiPayMoney=Double.parseDouble(fbJueSuanMoney)-Double.parseDouble(leijifkMoney);
			}else if(allQuery.getNowFbAllMoney()!=null && !allQuery.getNowFbAllMoney().equals("")){
				weiPayMoney=Double.parseDouble(allQuery.getNowFbAllMoney())-Double.parseDouble(leijifkMoney);
			}
			allQuery.setWeiPayMoney(weiPayMoney.toString());
		}
		return i;
	}
	
}

package org.ldxx.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.AllQuery;
import org.ldxx.bean.OperationTarget;
import org.ldxx.bean.Pay;
import org.ldxx.dao.PrjProgressFillDao;
import org.ldxx.service.AccessoryService;
import org.ldxx.service.AllQueryService;
import org.ldxx.service.ContractPaymentService;
import org.ldxx.service.OperationTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@RequestMapping("/allQuery")
@Controller
public class AllQueryController {
	@Autowired
	private AllQueryService service;
	@Autowired
	private PrjProgressFillDao prjProgressFillDao; 
	@Autowired
	private ContractPaymentService payService;
	@Autowired
	private OperationTargetService oservice;
	
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
	
	
	@RequestMapping("/getQueryTable")
	@ResponseBody
	public List<AllQuery> getQueryTable(@RequestParam(defaultValue="")String depart,@RequestParam(defaultValue="")String omName,
			@RequestParam(defaultValue="0")Double seachCjMoneyMin,@RequestParam(defaultValue="0")Double seachCjMoneyMax,
			@RequestParam(defaultValue="")String seachTimeMin,@RequestParam(defaultValue="")String seachTimeMax,
			@RequestParam(defaultValue="%")String serchType,String serchYear){
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("YY-MM");
		String nowDate = simpleDateFormat.format(new Date());
		String[] timeArr = nowDate.split("-");
		String year_Time = timeArr[0]+"%";
		String month_time = nowDate;
		serchType="%"+serchType+"%";
		if(serchYear!=""&&serchYear!=null){
			serchYear="%"+serchYear+"%";
		}
		
		List<AllQuery> i=service.getQueryTable(depart,omName,seachCjMoneyMin,seachCjMoneyMax,seachTimeMin,seachTimeMax,serchType,serchYear);
		
		/*
		 * String resultGs=oservice.selectGsOperationTargetByTime(i+"");
		 * 
		 * JSONObject jsonObject=JSONObject.fromObject(resultGs);
		 * 
		 * OperationTarget ot=(OperationTarget)JSONObject.toBean(jsonObject,
		 * OperationTarget.class);
		 */
		
		
		
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
	
	@RequestMapping("/getQueryTableBySqlThread")
	@ResponseBody
	public List<AllQuery> getQueryTableBySqlThread(@RequestParam(defaultValue="")String depart,@RequestParam(defaultValue="")String omName,
			@RequestParam(defaultValue="0")Double seachCjMoneyMin,@RequestParam(defaultValue="0")Double seachCjMoneyMax,
			@RequestParam(defaultValue="")String seachTimeMin,@RequestParam(defaultValue="")String seachTimeMax,
			@RequestParam(defaultValue="%")String serchType,String serchYear){
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("YY-MM");
		String nowDate = simpleDateFormat.format(new Date());
		String[] timeArr = nowDate.split("-");
		String year_Time = timeArr[0]+"%";
		String month_time = nowDate;
		serchType="%"+serchType+"%";
		if(serchYear!=""&&serchYear!=null){
			serchYear="%"+serchYear+"%";
		}
		List<AllQuery> i=service.getQueryTable(depart,omName,seachCjMoneyMin,seachCjMoneyMax,seachTimeMin,seachTimeMax,serchType,serchYear);
		
		int nowY=Integer.valueOf(seachTimeMax.split("-")[0]);
		
		String resultGs=oservice.selectGsOperationTargetByTime(nowY+"");
	  
		JSONObject jsonObject=JSONObject.fromObject(resultGs);
	  
		OperationTarget ot=(OperationTarget)JSONObject.toBean(jsonObject,
		OperationTarget.class);
		
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
			//新签合同额
			allQuery.setPrjEstimateMoney(ot.getXqhte());
			//总收入
			allQuery.setAllMoneyYuan(ot.getSr());
			//总收款
			allQuery.setResultMoney(ot.getSk()+"");
			//利润
			allQuery.setLiRun(ot.getLr());
			
			allQuery.setCjmoney(ot.getCjhte()+"");
			
			allQuery.setWeiPayMoney(weiPayMoney.toString());
		}
		return i;
	}
}

package org.ldxx.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.AllQuery;
import org.ldxx.bean.OperationTarget;
import org.ldxx.bean.Pay;
import org.ldxx.dao.CjContractDao;
import org.ldxx.dao.PrjProgressFillDao;
import org.ldxx.dao.SubContractDao;
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
	@Autowired
	private CjContractDao cjDao;
	@Autowired
	private SubContractDao fbdao;
	
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
			BigDecimal weiPayMoney = new BigDecimal(0);
			if(fbJueSuanMoney!=null && !fbJueSuanMoney.equals("")){
				weiPayMoney=new BigDecimal(fbJueSuanMoney).subtract(new BigDecimal(leijifkMoney));
			}else if(allQuery.getNowFbAllMoney()!=null && !allQuery.getNowFbAllMoney().equals("")){
				weiPayMoney=new BigDecimal(allQuery.getNowFbAllMoney()).subtract(new BigDecimal(leijifkMoney));
			}
			allQuery.setWeiPayMoney(weiPayMoney.toString());
		}
		return i;
	}
	
	
	@RequestMapping("/getQueryTable")
	@ResponseBody
	public List<AllQuery> getQueryTable(@RequestParam(defaultValue="")String depart,@RequestParam(defaultValue="")String omName,
			@RequestParam(defaultValue="0")BigDecimal seachCjMoneyMin,@RequestParam(defaultValue="0")BigDecimal seachCjMoneyMax,
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
		
		//根据年份查询承接合同数量
		int cjNoNum = cjDao.countNo("%");
		//查分包合同数量
		int fbNoNum = fbdao.fbNocount("%");
		
 		for(AllQuery allQuery:i){
			String cjNo = allQuery.getContractNo();
			//累计付款
			Pay pay = payService.getTotalPayMoney(allQuery.getFbNo());
			String leijifkMoney = String.valueOf(pay.getAlreadyAccumulateMoney());
			allQuery.setLeiJiPayMoney(leijifkMoney);
			//未付金额
			String fbJueSuanMoney = allQuery.getFbJueSuanMoney();
			BigDecimal weiPayMoney = new BigDecimal(0.0);
			if(fbJueSuanMoney!=null && !fbJueSuanMoney.equals("")){
				weiPayMoney=new BigDecimal(fbJueSuanMoney).subtract(new BigDecimal(leijifkMoney));
			}else if(allQuery.getNowFbAllMoney()!=null && !allQuery.getNowFbAllMoney().equals("")){
				weiPayMoney=new BigDecimal(allQuery.getNowFbAllMoney()).subtract(new BigDecimal(leijifkMoney));
			}
			allQuery.setWeiPayMoney(weiPayMoney.toString());
			
			allQuery.setCjNum(cjNoNum);
			allQuery.setFbNum(fbNoNum);
		}
		return i;
	}
	
	@RequestMapping("/getQueryTableBySqlThread")
	@ResponseBody
	public List<AllQuery> getQueryTableBySqlThread(@RequestParam(defaultValue="")String depart,@RequestParam(defaultValue="")String omName,
			@RequestParam(defaultValue="0")BigDecimal seachCjMoneyMin,@RequestParam(defaultValue="0")BigDecimal seachCjMoneyMax,
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
		
		//根据年份查询承接合同数量
		int cjNoNum = cjDao.countNo(serchYear);
		//查分包合同数量
		int fbNoNum = fbdao.fbNocount(serchYear);
		
		for(AllQuery allQuery:i){
			String cjNo = allQuery.getContractNo();
			//累计付款
			Pay pay = payService.getTotalPayMoney(allQuery.getFbNo());
			String leijifkMoney = String.valueOf(pay.getAlreadyAccumulateMoney());
			allQuery.setLeiJiPayMoney(leijifkMoney);
			//未付金额
			String fbJueSuanMoney = allQuery.getFbJueSuanMoney();
			BigDecimal weiPayMoney = new BigDecimal(0.0);
			if(fbJueSuanMoney!=null && !fbJueSuanMoney.equals("")){
				
				BigDecimal fbJueSuanMoneyDec = new BigDecimal(fbJueSuanMoney);
				BigDecimal leijifkMoneyDec = new BigDecimal(leijifkMoney);
				
				weiPayMoney=fbJueSuanMoneyDec.subtract(leijifkMoneyDec);
				//weiPayMoney=new BigDecimal(fbJueSuanMoney)-new BigDecimal(leijifkMoney);
			}else if(allQuery.getNowFbAllMoney()!=null && !allQuery.getNowFbAllMoney().equals("")){
				BigDecimal nowFbAllMoneyDec = new BigDecimal(allQuery.getNowFbAllMoney());
				BigDecimal leijifkMoneyDec = new BigDecimal(leijifkMoney);
				
				weiPayMoney=nowFbAllMoneyDec.subtract(leijifkMoneyDec);
				//weiPayMoney=new BigDecimal(allQuery.getNowFbAllMoney())-new BigDecimal(leijifkMoney);
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
			
			allQuery.setCjNum(cjNoNum);
			
			allQuery.setCjNum(cjNoNum);
			allQuery.setFbNum(fbNoNum);
		}
		return i;
	}
	
	public static void main(String[] args) {

		BigDecimal bignum1 = new BigDecimal("10"); 

		BigDecimal bignum2 = new BigDecimal("5"); 

		BigDecimal bignum3 = null; 

		   

		//加法 

		bignum3 =  bignum1.add(bignum2);      

		System.out.println("求和：" + bignum3); 

		   

		//减法 

		bignum3 = bignum1.subtract(bignum2); 

		System.out.println("求差：" + bignum3); 

		   

		//乘法 

		bignum3 = bignum1.multiply(bignum2); 

		System.out.println("乘法积：" + bignum3); 

		   

		//除法 

		bignum3 = bignum1.divide(bignum2); 

		System.out.println("除法结果：" + bignum3); 
		
		BigDecimal a = new BigDecimal(3); 
		BigDecimal b = new BigDecimal(2); 
		//前提为a、b均不能为null
		if(a.compareTo(b) == -1){
		    System.out.println("a小于b");
		}
		 
		if(a.compareTo(b) == 0){
		    System.out.println("a等于b");
		}
		 
		if(a.compareTo(b) == 1){
		    System.out.println("a大于b");
		}

		if(a.doubleValue()>b.doubleValue()){
			System.out.println("a大于b");
		}
		 
		if(a.compareTo(b) > -1){
		    System.out.println("a大于等于b");
		}
		 
		if(a.compareTo(b) < 1){
		    System.out.println("a小于等于b");
		}
	}
}

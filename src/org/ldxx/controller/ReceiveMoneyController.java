package org.ldxx.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.AlreadyRenling;
import org.ldxx.bean.ReceiveMoney;
import org.ldxx.bean.User;
import org.ldxx.dao.AlreadySkInfoDao;
import org.ldxx.dao.ReceiveMoneyDao;
import org.ldxx.util.DateUtil;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/receiveMoney")
@Controller
public class ReceiveMoneyController {
	@Autowired
	private ReceiveMoneyDao receiveMoneyDao;
	@Autowired
	private AlreadySkInfoDao asDao;
	
	@RequestMapping("/getReceiveMoneyList")
	@ResponseBody
	public List<ReceiveMoney> getReceiveMoneyList(String depart,String omName){
		List<ReceiveMoney> list = receiveMoneyDao.selectReceiveList();
		for(int i=0;i<list.size();i++){
			String skNo = list.get(i).getSkNo();
			AlreadyRenling ar=asDao.getyirenlingfpMoneyByskno(skNo);
			double yirenlingallFpMoney = ar.getYirenlingallFpMoney();//已认领的确认金额总和
			list.get(i).setLeijiquerenMoney(yirenlingallFpMoney);
			double receiveMoney = list.get(i).getReceiveMoney();//收款金额
			double shengyuMoney=receiveMoney-yirenlingallFpMoney;
			list.get(i).setShengyuMoney(shengyuMoney);
		}
		return list;
	}
	
	@RequestMapping("/getReceiveMoneyListByStatus")
	@ResponseBody
	public List<ReceiveMoney> getReceiveMoneyListByStatus(String status){
		return receiveMoneyDao.selectReceiveListByStatus(status);
	}
	
	@RequestMapping("/addReceiveMoney")
	@ResponseBody
	public ReceiveMoney addReceiveMoney(ReceiveMoney receiveMoney,HttpSession session){
		User user = (User) session.getAttribute("user");
		receiveMoney.setRmId(new TimeUUID().getTimeUUID());
		receiveMoney.setDoTime(TimeUUID.getTimeByFmt("yyyy-MM-dd hh:mm:ss", new Date()));
		receiveMoney.setDoPerson(user.getuName());
		receiveMoney.setStatus("0");
		String ymDate = DateUtil.getDateStrByPattern("yyyy", new Date());
		String count=receiveMoneyDao.CreateRecieveMoneyNumOrder(ymDate);
		String ymDate1 = DateUtil.getDateStrByPattern("yyyyMM", new Date());
		String code="SK"+ymDate1+count;
		receiveMoney.setSkNo(code);
		receiveMoneyDao.addReceiveMoney(receiveMoney);
		return receiveMoney;
	}
	
	@RequestMapping("/updateReceiveMoney")
	@ResponseBody
	public int updateReceiveMoney(ReceiveMoney receiveMoney,HttpSession session){
		User user = (User) session.getAttribute("user");
		receiveMoney.setDoTime(TimeUUID.getTimeByFmt("yyyy-MM-dd hh:mm:ss", new Date()));
		receiveMoney.setDoPerson(user.getuName());
		receiveMoney.setStatus("0");
		return receiveMoneyDao.updateReceiveMoney(receiveMoney);
	}
	
	@RequestMapping("/deleteReceiveMoney")
	@ResponseBody
	public int deleteReceiveMoney(String id){
		return receiveMoneyDao.deleteReceiveMoneyById(id);
	}
	
	@RequestMapping("/updateStatus")
	@ResponseBody
	public int updateStatus(String skno,String status){
		return receiveMoneyDao.updateStatus(skno,status);
	}
}

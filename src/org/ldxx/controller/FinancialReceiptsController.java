package org.ldxx.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ldxx.bean.FinancialReceipts;
import org.ldxx.bean.ReceiveMoney;
import org.ldxx.dao.ReceiveMoneyDao;
import org.ldxx.service.FinancialReceiptsService;
import org.ldxx.util.ImportData;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("FinancialReceipts")
public class FinancialReceiptsController {

	@Autowired
	private FinancialReceiptsService service;
	@Autowired
	private ReceiveMoneyDao receiveMoneyDao;
	
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
	
	@RequestMapping("/importExcel")
	@ResponseBody
	public int importExcel(@RequestParam("file") MultipartFile file,HttpServletResponse response,HttpSession session) throws IOException{
		InputStream is=file.getInputStream();
		ImportData importData=new ImportData();
		Map<String, Object> map = importData.readExcelShouKuan(is);
		@SuppressWarnings("unchecked")
		List<ReceiveMoney> list = (List<ReceiveMoney>) map.get("fR2");
		if(list.size()!=0){
			for(int i=0;i<list.size();i++){
				String rmId=list.get(i).getRmId();
				String skNo=list.get(i).getSkNo();
				String ccName = list.get(i).getCcName();
				double receiveMoney =  list.get(i).getReceiveMoney();
				String rmDesc = list.get(i).getRmDesc();
				String rmtime = list.get(i).getRmTime();
				String doPerson = list.get(i).getDoPerson();
				ReceiveMoney receiveMoney2=new ReceiveMoney();
				receiveMoney2.setRmId(rmId);
				receiveMoney2.setSkNo(skNo);
				receiveMoney2.setCcName(ccName);
				receiveMoney2.setReceiveMoney(receiveMoney);
				receiveMoney2.setRmTime(rmtime);
				receiveMoney2.setRmDesc(rmDesc);
				receiveMoney2.setDoPerson(doPerson);
				receiveMoneyDao.addReceiveMoney(receiveMoney2);
			}
		}
		return 1;
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
	
	@RequestMapping("/selectTotalMoneyByCj")
	@ResponseBody
	public FinancialReceipts selectTotalMoneyByCj(String no){
		FinancialReceipts fr=service.selectTotalMoneyByCj(no);
		return fr;
	}
	
}

package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.clfbContractPurchaseSettlement;
import org.ldxx.service.MaterialPurchaseSettlementService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 材料分包合同下的采购结算申请
 * @author hp
 *
 */

@RequestMapping("materialPurchaseSettlement")
@Controller
public class MaterialPurchaseSettlementController {
	
	@Autowired
	private MaterialPurchaseSettlementService mService;
	
	@RequestMapping("/selectmaterialPurchaseSettlement")//初始化
	@ResponseBody
	public List<clfbContractPurchaseSettlement> selectmaterialPurchaseSettlement(String status){
		List<clfbContractPurchaseSettlement> list = mService.selectmaterialPurchaseSettlement(status);
		return list;
	}
	
	@RequestMapping("/addmaterialPurchaseSettlementSave")//添加保存
	@ResponseBody
	public Map<String,Object> addmaterialPurchaseSettlementSave(clfbContractPurchaseSettlement c){
		Map<String,Object> map=new HashMap<String, Object>();
		TimeUUID uuid=new TimeUUID();
		String id = uuid.getTimeUUID();
		c.setCpId(id);
		int count=mService.cgjsNocount();
		count=count+1;
		String code=uuid.getPrjCode("", count);
		code="CGJS"+code;
		c.setCgjsNo(code);
		
		int i=mService.addmaterialPurchaseSettlementSave(c);
		map.put("result",i);
		map.put("clfbContractPurchaseSettlement", c);
		return map;
	}
	
	@RequestMapping("/addmaterialPurchaseSettlementSubmit")//添加提交
	@ResponseBody
	public Map<String,Object> addmaterialPurchaseSettlementSubmit(clfbContractPurchaseSettlement c){
		Map<String,Object> map=new HashMap<String, Object>();
		TimeUUID uuid=new TimeUUID();
		String id = uuid.getTimeUUID();
		c.setCpId(id);
		int count=mService.cgjsNocount();
		count=count+1;
		String code=uuid.getPrjCode("", count);
		code="CGJS"+code;
		c.setCgjsNo(code);
		
		int i=mService.addmaterialPurchaseSettlementSave(c);
		map.put("result",i);
		map.put("clfbContractPurchaseSettlement", c);
		return map;
	}
	
	
	@RequestMapping("/updatematerialPurchaseSettlementSave")//修改保存
	@ResponseBody
	public Map<String,Object> updatematerialPurchaseSettlementSave(clfbContractPurchaseSettlement c){
		Map<String,Object> map=new HashMap<String, Object>();
		int i=mService.updateHistory(c.getCpId());
		if(i>0){
			TimeUUID uuid=new TimeUUID();
			String id = uuid.getTimeUUID();
			c.setCpId(id);
			i=mService.addmaterialPurchaseSettlementSave(c);
			map.put("result",i);
			map.put("clfbContractPurchaseSettlement", c);
		}
		return map;
	}
	
	
	@RequestMapping("/updatematerialPurchaseSettlementSubmit")//修改提交
	@ResponseBody
	public Map<String,Object> updatematerialPurchaseSettlementSubmit(clfbContractPurchaseSettlement c){
		Map<String,Object> map=new HashMap<String, Object>();
		int i=mService.updateHistory(c.getCpId());
		if(i>0){
			TimeUUID uuid=new TimeUUID();
			String id = uuid.getTimeUUID();
			c.setCpId(id);
			i=mService.addmaterialPurchaseSettlementSave(c);
			map.put("result",i);
			map.put("clfbContractPurchaseSettlement", c);
		}
		return map;
	}
	
	
	@RequestMapping("/selectmaterialPurchaseSettlementById")//通过id查询
	@ResponseBody
	public clfbContractPurchaseSettlement selectmaterialPurchaseSettlementById(String id){
		return mService.selectmaterialPurchaseSettlementById(id);
	}
	
	@RequestMapping("/selectHistoryByNo")//通过采购结算单号查询所有历史信息
	@ResponseBody
	public List<clfbContractPurchaseSettlement> selectHistoryByNo(String no){
		return mService.selectHistoryByNo(no);
	}

}

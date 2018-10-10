package org.ldxx.controller;

import java.util.List;

import org.ldxx.bean.ClfbContractEvaluate;
import org.ldxx.bean.FbContract;
import org.ldxx.bean.Pay;
import org.ldxx.service.MaterialSubcontractService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 材料分包合同的履约评价
 * @author hp
 *
 */

@RequestMapping("MaterialSubcontract")
@Controller
public class MaterialSubcontractController {
	
	@Autowired
	private MaterialSubcontractService msService;
	
	
	@RequestMapping("/selectmSubcontractByStatus")//初始化履约评价
	@ResponseBody
	public List<ClfbContractEvaluate> selectmSubcontractByStatus(String status){
		return msService.selectmSubcontract(status);
	}
	
	@RequestMapping("/addmSubcontractSave")//添加保存
	@ResponseBody
	public int addmSubcontractSave(ClfbContractEvaluate c){
		TimeUUID uuid=new TimeUUID();
		String id = uuid.getTimeUUID();
		c.setCeId(id);
		
		int count=msService.MCodecount();
		count=count+1;
		String code=uuid.getPrjCode("", count);
		code="CLCG"+code;
		c.setMaterialContractCode(code);
		
		int i=msService.addmSubcontractSave(c);
		return i;
	}
	
	
	@RequestMapping("/addmSubcontractSubmit")//添加提交
	@ResponseBody
	public int addmSubcontractSubmit(ClfbContractEvaluate c){
		TimeUUID uuid=new TimeUUID();
		String id = uuid.getTimeUUID();
		c.setCeId(id);
		
		int count=msService.MCodecount();
		count=count+1;
		String code=uuid.getPrjCode("", count);
		code="CLCG"+code;
		c.setMaterialContractCode(code);
		
		int i=msService.addmSubcontractSave(c);
		return i;
	}
	
	
	@RequestMapping("/updatemSubcontractSave")//修改保存
	@ResponseBody
	public int updatemSubcontractSave(ClfbContractEvaluate c){
		String ceId = c.getCeId();
		msService.updateHistory(ceId);//修改历史状态
		TimeUUID uuid=new TimeUUID();
		String id = uuid.getTimeUUID();
		c.setCeId(id);
		int i=msService.addmSubcontractSave(c);
		return i;
	}
	
	@RequestMapping("/updatemSubcontractSubmit")//修改提交
	@ResponseBody
	public int updatemSubcontractSubmit(ClfbContractEvaluate c){
		String ceId = c.getCeId();
		msService.updateHistory(ceId);//修改历史状态
		TimeUUID uuid=new TimeUUID();
		String id = uuid.getTimeUUID();
		c.setCeId(id);
		int i=msService.addmSubcontractSave(c);
		return i;
	}
	

	@RequestMapping("/selectHistoryBypayCode")//查找历史信息
	@ResponseBody
	public List<ClfbContractEvaluate> selectHistoryBypayCode(String code){
		return msService.selectHistoryBypayCode(code);
	}
	
	@RequestMapping("/selectmSubcontractById")
	@ResponseBody
	public ClfbContractEvaluate selectmSubcontractById(String id){
		return msService.selectmSubcontractById(id);
	}
	
}

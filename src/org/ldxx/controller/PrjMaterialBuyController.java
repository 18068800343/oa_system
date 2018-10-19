package org.ldxx.controller;

import java.util.List;

import org.ldxx.bean.MaterialDemand;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.PrjMaterialBuy;
import org.ldxx.service.MaterialDemandService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.PrjMaterialBuyService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
* @ClassName: PrjMaterialBuyController 
* @Description: 材料采购申请
* @author zhaohui
* @date 2018年10月12日 上午10:47:30 
*  
*/

@Controller
@RequestMapping("PrjMaterialBuy")
public class PrjMaterialBuyController {

	@Autowired
	private PrjMaterialBuyService service;
	@Autowired
	private OrganizationManagementService oservice;
	@Autowired
	private MaterialDemandService mservice;
	
	@RequestMapping("/addPrjMaterialBuyBySave")
	@ResponseBody
	public int addPrjMaterialBuyBySave(@RequestBody PrjMaterialBuy buy){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		buy.setPmbId(id);
		int count=service.selectPrjMaterialBuyCount();
		count=count+1;
		OrganizationManagement om=oservice.selectOrgById(buy.getApplyDepartment());
		String omNo=om.getOmNo();
		String taskCode=uuid.getClCode(omNo, count);
		buy.setTaskCode(taskCode);
		int i=service.addPrjMaterialBuy(buy);
		return i;
	}
	
	@RequestMapping("/addPrjMaterialBuyBySubmit")
	@ResponseBody
	public int addPrjMaterialBuyBySubmit(@RequestBody PrjMaterialBuy buy){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		buy.setPmbId(id);
		int count=service.selectPrjMaterialBuyCount();
		OrganizationManagement om=oservice.selectOrgById(buy.getApplyDepartment());
		String omNo=om.getOmNo();
		String taskCode=uuid.getClCode(omNo, count+1);
		buy.setTaskCode(taskCode);
		int i=service.addPrjMaterialBuy(buy);
		return i;
	}
	
	@RequestMapping("/selectPrjMaterialBuy")
	@ResponseBody
	public List<PrjMaterialBuy> selectPrjMaterialBuy(){
		List<PrjMaterialBuy> list=service.selectPrjMaterialBuy();
		return list;
	}
	
	@RequestMapping("/selectBuyCode")
	@ResponseBody
	public List<PrjMaterialBuy> selectBuyCode(){
		List<PrjMaterialBuy> list=service.selectBuyCode();
		return list;
	}
	
	@RequestMapping("/selectBuyByIds")
	@ResponseBody
	public List<PrjMaterialBuy> selectBuyByIds(String ids){
		List<PrjMaterialBuy> list=service.selectBuyByIds(ids);
		return list;
	}
	
	@RequestMapping("/updateBuy")
	@ResponseBody
	public int updateBuy(@RequestBody List<MaterialDemand> md){
		int i=mservice.updateMd(md);
		return i;
	}
	
	@RequestMapping("/selectBuyByname")//通过项目名获得材料信息
	@ResponseBody
	public List<PrjMaterialBuy> selectBuyByname(String name){
		List<PrjMaterialBuy> list=service.selectBuyByname(name);
		return list;
	}
}

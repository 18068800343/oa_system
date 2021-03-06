package org.ldxx.controller;

import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.ClRemain;
import org.ldxx.bean.CompanyMateriaIn;
import org.ldxx.bean.CompanyMateriaOut;
import org.ldxx.bean.GsClOut;
import org.ldxx.bean.PrjMaterialBuy;
import org.ldxx.service.ClRemainService;
import org.ldxx.service.GsMaterialInService;
import org.ldxx.service.GsMaterialOutService;
import org.ldxx.service.PrjMaterialBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 公司结余管理
 * @author hp
 *
 */
@RequestMapping("GsMaterialRemain")
@Controller
public class GsMaterialRemainController {

	@Autowired
	private GsMaterialOutService Outservice;
	@Autowired
	private ClRemainService clRemainservice;
	
	@RequestMapping("/selectGsMaterialRemain")//查看已结余的信息
	@ResponseBody
	public List<CompanyMateriaOut> selectGsMaterialRemain(int remainType){
		List<CompanyMateriaOut> list=Outservice.selectGSmaterialRemain(remainType);
		return list;
	}
	
	@RequestMapping("/selectGsMaterialRemainByname")//通过已结余的项目名查找任务单
	@ResponseBody
	public List<CompanyMateriaOut> selectGsMaterialRemainByname(int remainType,String name){
		List<CompanyMateriaOut> list=Outservice.selectGsMaterialRemainByname(remainType,name);
		return list;
	}
	
	@RequestMapping("/selectGsMaterialRemainByno")//通过已结余的任务单查找项目名
	@ResponseBody
	public List<CompanyMateriaOut> selectGsMaterialRemainByno(int remainType,String no){
		List<CompanyMateriaOut> list=Outservice.selectGsMaterialRemainByno(remainType,no);
		return list;
	}
	
	@RequestMapping("/updateClRemainNum")//修改结余材料的出库数、剩余数量以及出库金额
	@ResponseBody
	public int updateClRemainNum(ClRemain cr){
		int i=clRemainservice.updateClRemainNum(cr);
		return i;
	}
	
}

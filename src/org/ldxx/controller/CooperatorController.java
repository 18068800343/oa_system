package org.ldxx.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.ldxx.bean.Cooperator;
import org.ldxx.bean.Enterprise;
import org.ldxx.dao.CooperatorDao;
import org.ldxx.service.CooperatorService;
import org.ldxx.service.EnterpriseService;
import org.ldxx.util.ExportData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
* @ClassName: CooperatorController 
* @Description: 合作单位管理
* @author ailun
* @date 2018年8月13日 下午4:02:28 
*  
*/

@RequestMapping("cooperator")
@Controller
public class CooperatorController {

	@Autowired
	private CooperatorService cservice;
	@Autowired
	private EnterpriseService eService;
	@Autowired
	private CooperatorDao cDao;
	@RequestMapping("/addCooperator")
	@ResponseBody
	public  Map<String,Object> addCooperator(@RequestBody List<Cooperator> cooperator){
		Map<String,Object> map = new HashMap<>();
		Cooperator Co=cooperator.get(0);
		int i=cservice.addCooperator(Co);
		map.put("result", i);
		map.put("Cooperator", Co);
		return map;
	}
	
	
	@RequestMapping("/deleteCooperator")
	@ResponseBody
	public int deleteCooperator(String id){
		return cservice.deleteCooperator(id);
	}
	
	
	@RequestMapping("/updateCooperator")
	@ResponseBody
	public Map<String,Object> updateCooperator(@RequestBody List<Cooperator> cooperator){
		Map<String,Object> map = new HashMap<>();
		Cooperator Co=cooperator.get(0);
		int i=cservice.updateCooperator(Co);
		map.put("result", i);
		map.put("Cooperator", Co);
		return map;
	}
	
	@RequestMapping("/selectAllCooperator")
	@ResponseBody
	public List<Cooperator> selectAllCooperator(){
		return cservice.selectAllCooperator();
	}
	
	@RequestMapping("/selectOneCooperator")
	@ResponseBody
	public Cooperator selectOneCooperator(String id){
		return cservice.selectOneCooperator(id);
	}
	
	@RequestMapping("/exportCooperator")
	@ResponseBody
	public void exportCooperator(HttpServletResponse response) throws Exception{
		String xlsName = "合作单位信息表";  
		ExportData exportData=new ExportData();
		List<Cooperator> cooperator=cservice.selectAllCooperator();
		 List<List<String>> dataList=new ArrayList<>();
		for(int i=0;i<cooperator.size();i++){
			List<String> data=new ArrayList<>();
			data.add(i+1+"");
			data.add(cooperator.get(i).getCcName());
			data.add(cooperator.get(i).getCcType());
			data.add(cooperator.get(i).getCreditCode());
			data.add(cooperator.get(i).getBankNo());
			data.add(cooperator.get(i).getBankName());
			data.add(cooperator.get(i).getBusinessLicense());
			data.add(cooperator.get(i).getBusinessLicenseTime());
			data.add(cooperator.get(i).getLegalPersonName());
			data.add(cooperator.get(i).getEnterpriseType());
			data.add(cooperator.get(i).getEnterpriseAddr());
			data.add(cooperator.get(i).getEnterpriseFax());
			data.add(cooperator.get(i).getEnterpriseEmail());
			data.add("sss");
			dataList.add(data);
		}
		String [] array={"编号","企业名称","类型","社会统一信用代码","银行账户","开户行","营业执照","营业执照有效期","法人姓名","企业性质","地址","传真","电子邮件","企业评级"};
	        exportData.ExportWithResponse(xlsName,xlsName,  
	        		array.length, array, dataList, response);
	}
	
	
	@RequestMapping("/selectCooperatorIdAndName")
	@ResponseBody
	public List<Cooperator> selectCooperatorIdAndName(){
		List<Cooperator> list=cservice.selectCooperatorIdAndName();
		return list;
	}
	@RequestMapping("/selectCooperatorIdAndNameByCcType")
	@ResponseBody
	public List<Cooperator> selectCooperatorIdAndNameByCcType(String ccType){
		List<Cooperator> list=cDao.selectCooperatorIdAndNameByCcType(ccType);
		return list;
	}
	
	@RequestMapping("/selectCooperatorById")
	@ResponseBody
	public Cooperator selectCooperatorById(String id){
		Cooperator list=cservice.selectOneCooperator(id);
		List<Enterprise> ent=eService.selectEnterpriseById(id);
		list.setEnterprise(ent);
		return list;
	}
	
	
	@RequestMapping("/countOfEnterprise")//先判断该公司下该联系人是否存在，不存在就添加
	@ResponseBody
	public int countOfEnterprise(Enterprise etel){
		return eService.countOfEnterprise(etel);
	}
	
}

package org.ldxx.controller;

import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.DepartmentTarget2;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.dao.DepartmentTarget2Dao;
import org.ldxx.service.OrganizationManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//经营指标双击列表
@RequestMapping("DepartmentTarget2")
@Controller
public class DepartmentTarget2Controller {
	
	@Autowired
	private DepartmentTarget2Dao dDao;
	@Autowired
	private OrganizationManagementService oService;
	
	//部门新承接合同额双击列表
	@RequestMapping("/getbmcjhteList")
	@ResponseBody
	public List<DepartmentTarget2> getbmcjhteList(String year,String omName){
		year=year+"%";
		OrganizationManagement om=oService.getOrgIdByName(omName);
		List<DepartmentTarget2> DepartmentTarget2=dDao.getcontractUpdatebyomIdAndyear(year,om.getOmId());
		List<DepartmentTarget2> task2=dDao.getTask2byomNameAndyear(year,omName);
		if(task2!=null&&task2.size()>0){
			for(int i=0;i<task2.size();i++){
				DepartmentTarget2 d2=new DepartmentTarget2();
				d2.setPrjNo(task2.get(i).getPrjNo());
				d2.setPrjName(task2.get(i).getPrjName());
				d2.setOmName(task2.get(i).getOmName());
				d2.setYear(task2.get(i).getYear());
				d2.setMoney(task2.get(i).getMoney());
				DepartmentTarget2.add(d2);
			}
		}
		return DepartmentTarget2;
	}
	
	//已签订合同额双击列表
	@RequestMapping("/getyqdheList")
	@ResponseBody
	public List<DepartmentTarget2> getyqdheList(String year,String omName){
		year=year+"%";
		OrganizationManagement om=oService.getOrgIdByName(omName);
		List<DepartmentTarget2> DepartmentTarget2=dDao.getcjcontractUpdatebyomIdAndyear(year,om.getOmId());
		return DepartmentTarget2;
	}
	
	//部门完成收入双击列表
	@RequestMapping("/getbmwcsrList")
	@ResponseBody
	public List<DepartmentTarget2> getbmwcsrList(String year,String omName){
		year=year+"%";
		OrganizationManagement om=oService.getOrgIdByName(omName);
		List<DepartmentTarget2> DepartmentTarget2=dDao.getprjProgressFillbyomIdAndyear(year,om.getOmId());
		List<DepartmentTarget2> d2=dDao.gettDepartmentIncomebyomNameAndyear(year,omName);
		if(d2!=null&&d2.size()>0){
			for(int i=0;i<d2.size();i++){
				DepartmentTarget2 d=new DepartmentTarget2();
				d.setPrjNo(d2.get(i).getPrjNo());
				d.setPrjName(d2.get(i).getPrjName());
				d.setOmName(d2.get(i).getOmName());
				d.setYear(d2.get(i).getYear());
				d.setMoney(d2.get(i).getMoney());
				DepartmentTarget2.add(d);
			}
		}
		return DepartmentTarget2;
	}
	
	//部门间接成本双击列表
	@RequestMapping("/getbmjjcbList")
	@ResponseBody
	public List<DepartmentTarget2> getbmjjcbList(String year,String omName){
		year=year+"%";
		OrganizationManagement om=oService.getOrgIdByName(omName);
		List<DepartmentTarget2> DepartmentTarget2=dDao.getcompanyCostbyomNameAndyear(year,omName);
		return DepartmentTarget2;
	}

}

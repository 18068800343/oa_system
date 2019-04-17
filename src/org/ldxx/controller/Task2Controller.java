package org.ldxx.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ldxx.bean.CompanyCost;
import org.ldxx.bean.SecondCompanyCost;
import org.ldxx.bean.TDepartment;
import org.ldxx.bean.Task;
import org.ldxx.bean.Task2;
import org.ldxx.dao.CompanyCostDao;
import org.ldxx.dao.SecondCompanyCostDao;
import org.ldxx.dao.TDepartmentDao;
import org.ldxx.dao.Task2Dao;
import org.ldxx.service.TDepartmentService;
import org.ldxx.service.Task2Service;
import org.ldxx.service.TaskService;
import org.ldxx.util.ImportData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/** 
* @ClassName: Task2Controller 
* @Description: 检测二部
* @author zhaohui
* @date 2018年11月21日 下午3:14:38 
*  
*/
@Controller
@RequestMapping("task2")
public class Task2Controller {
	
	@Autowired
	private Task2Service tService;
	@Autowired
	private TDepartmentService tdService;
	@Autowired
	private SecondCompanyCostDao sccDao;
	@Autowired
	private Task2Dao task2Dao;
	@Autowired
	private TDepartmentDao tDepartmentDao;
	@Autowired
	private CompanyCostDao ccDao;
	@Autowired
	private TaskService taskService;
	
	@RequestMapping("/importExcel")
	@ResponseBody
	public int importExcel(@RequestParam("file") MultipartFile file,String time,HttpServletResponse response,HttpSession session) throws IOException{
		InputStream is=file.getInputStream();
		ImportData importData=new ImportData();
		Map<String,Object> map=importData.readXls(is,time);
		int i=tService.addTask2(map);
		return i;
	}
	@RequestMapping("/importExcelSecondCompanyCost")
	@ResponseBody
	public int importExcelSecondCompanyCost(@RequestParam("file") MultipartFile file,String time,HttpServletResponse response,HttpSession session) throws IOException{
		InputStream is=file.getInputStream();
		ImportData importData=new ImportData();
		Map<String,Object> map=importData.readExcelSecondCompanyCost(is,time);
		int i=sccDao.addSecondCompanyCost((List<SecondCompanyCost>) map.get("fR2"));
		return i;
	}
	@RequestMapping("/importExcelCompanyCost")
	@ResponseBody
	public int importExcelCompanyCost(@RequestParam("file") MultipartFile file,String time,HttpServletResponse response,HttpSession session) throws IOException{
		InputStream is=file.getInputStream();
		ImportData importData=new ImportData();
		Map<String,Object> map=importData.readExcelCompanyCost(is);
		List<CompanyCost> cc=(List<CompanyCost>) map.get("fR2");
		for(int ii=0;ii<cc.size();ii++){
			cc.get(ii).setDate(time);
		}
		int i=ccDao.addCompanyCost(cc);
		return i;
	}

	@RequestMapping("/selectTask2")
	@ResponseBody
	public List<Task2> selectTask2(){
		List<Task2> list=tService.selectTask2();
		return list;
	}
	
	@RequestMapping("/selectSecondCompanyCost")
	@ResponseBody
	public List<SecondCompanyCost> selectSecondCompanyCost(){
		List<SecondCompanyCost> list=sccDao.selectSecondComCost();
		return list;
	}
	
	@RequestMapping("/selectCompanyCost")
	@ResponseBody
	public List<CompanyCost> selectCompanyCost(){
		List<CompanyCost> list=ccDao.selectCompanyCost();
		return list;
	}
	
	@RequestMapping("/selectSumMoneyByNo")//通过任务单号查直接成本总额
	@ResponseBody
	public Double selectSumMoneyByNo(String no){
		Double cc=ccDao.selectSumMoneyByNo(no);
		return cc;
	}
	
	@RequestMapping("/selectTask2ById")//通过id查
	@ResponseBody
	public Task2 selectTask2ById(String id){
		return tService.selectTask2ById(id);
	}
	
	@RequestMapping("/importExcel2")
	@ResponseBody
	public int importExcel2(@RequestParam("file") MultipartFile file,String time,HttpServletResponse response,HttpSession session) throws IOException, ParseException{
		InputStream is=file.getInputStream();
		ImportData importData=new ImportData();
		List<TDepartment> td=importData.readXls2(is,time);
		
		int i=tdService.updateIncome(td);
		
		return i;
	}
	
	@RequestMapping("/selectDepartment")
	@ResponseBody
	public List<TDepartment> selectDepartment(String no){
		List<TDepartment> list=tdService.selectDepartment(no);
		return list;
	}
	
	@RequestMapping("/selectDepartmentIncome")
	@ResponseBody
	public List<TDepartment> selectDepartmentIncome(){
		List<TDepartment> list=tDepartmentDao.selectDepartmentIncome();
		return list;
	}
	
	@RequestMapping("/deleteDepartmentIncome")
	@ResponseBody
	public Integer deleteDepartmentIncome(String id){
		Integer i=tDepartmentDao.deleteDepartmentInComeById(id);
		return i;
	}
	
	@RequestMapping("/deleteTask2")
	@ResponseBody
	public int deleteTask2(String no){
		int i=tService.deleteTask2(no);
		return i;
	}
	
	
	@RequestMapping("/selectTask2ByNo")
	@ResponseBody
	public List<Task2> selectTask2ByNo(String no){
		 List<Task2> task2ByNo = tService.selectTask2ByNo(no);
		 TDepartment td=tDepartmentDao.getDistinctDepartmentIncomeByNo(no);
		 if(td!=null){
			 for(int i=0;i<task2ByNo.size();i++){
				 Double income2 = td.getdIncome2();
				 Double money2 = task2ByNo.get(i).getdMoney2();
				 task2ByNo.get(i).setdMoney2(income2+money2);
			 }
		 }
		 return task2ByNo;
	}
	
	
	@RequestMapping("/gettaskAndtask2")
	@ResponseBody
	public List<Task> gettaskAndtask2(){
		List<Task> list = taskService.selectPrjNameAndWorkNo();
		List<Task2> list2 = task2Dao.selectDistinctTask2();
		List<TDepartment> list3 = tDepartmentDao.getDistinctDepartmentIncome();
		
		if(list2!=null&&list2.size()!=0){
			for (int i=0;i<list2.size();i++) {
				for(int a=0;a<list3.size();a++){
					String no1 = list2.get(i).gettNo();
					String no2 = list3.get(a).gettNo();
					if(no1.equals(no2)){
						list2.get(i).setdMoney2(list2.get(i).getdMoney2()+list3.get(a).getdIncome2());
						TDepartment tDepartment = list3.get(a);
						list3.remove(tDepartment);
					}
				}
				Task task=new Task();
				task.setPrjName(list2.get(i).gettName());
				task.setPrjNo(list2.get(i).gettNo());
				task.setContractMoney(list2.get(i).getdMoney2());
				task.setPrjType2(list2.get(i).gettType());
				task.setMainDepartment(list2.get(i).getOmId());
				task.setOmName(list2.get(i).getdName());
				list.add(task);
			}
		}
		if(list3!=null&&list3.size()!=0){
			for(int j=0;j<list3.size();j++){
				Task task=new Task();
				task.setPrjName(list3.get(j).gettName());
				task.setPrjNo(list3.get(j).gettNo());
				task.setContractMoney(list3.get(j).getdIncome2());
				task.setMainDepartment(list3.get(j).getOmId());
				task.setOmName(list3.get(j).getdName());
				list.add(task);
			}
		}
		return list;
	}
}

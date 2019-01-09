package org.ldxx.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ldxx.bean.SecondCompanyCost;
import org.ldxx.bean.TDepartment;
import org.ldxx.bean.Task2;
import org.ldxx.dao.SecondCompanyCostDao;
import org.ldxx.service.TDepartmentService;
import org.ldxx.service.Task2Service;
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
	@RequestMapping("/importExcel")
	@ResponseBody
	public int importExcel(@RequestParam("file") MultipartFile file,HttpServletResponse response,HttpSession session) throws IOException{
		InputStream is=file.getInputStream();
		ImportData importData=new ImportData();
		Map<String,Object> map=importData.readXls(is);
		int i=tService.addTask2(map);
		return i;
	}
	@RequestMapping("/importExcelSecondCompanyCost")
	@ResponseBody
	public int importExcelSecondCompanyCost(@RequestParam("file") MultipartFile file,HttpServletResponse response,HttpSession session) throws IOException{
		InputStream is=file.getInputStream();
		ImportData importData=new ImportData();
		Map<String,Object> map=importData.readExcelSecondCompanyCost(is);
		int i=sccDao.addSecondCompanyCost((List<SecondCompanyCost>) map.get("fR2"));
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
	
	@RequestMapping("/importExcel2")
	@ResponseBody
	public int importExcel2(@RequestParam("file") MultipartFile file,HttpServletResponse response,HttpSession session) throws IOException, ParseException{
		InputStream is=file.getInputStream();
		ImportData importData=new ImportData();
		List<TDepartment> td=importData.readXls2(is);
		int i=tdService.updateIncome(td);
		return i;
	}
	
	@RequestMapping("/selectDepartment")
	@ResponseBody
	public List<TDepartment> selectDepartment(String no){
		List<TDepartment> list=tdService.selectDepartment(no);
		return list;
	}
	
	@RequestMapping("/deleteTask2")
	@ResponseBody
	public int deleteTask2(String no){
		int i=tService.deleteTask2(no);
		return i;
	}
	
}

package org.ldxx.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.ldxx.bean.FinancialDepartments;
import org.ldxx.bean.FinancialReceipts;
import org.ldxx.bean.FinancialTables;
import org.ldxx.bean.TDepartment;
import org.ldxx.bean.Task2;
import org.ldxx.dao.FinancialReceipts2Dao;
import org.ldxx.service.FinancialReceipts2Service;
import org.ldxx.util.ImportData;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
/**
 * 检测二部的财务收款
 * @author hp
 *
 */
@Controller
@RequestMapping("FinancialReceipts2")
public class FinancialReceipts2Controller {

	@Autowired
	private FinancialReceipts2Service service;
	@Autowired
	private FinancialReceipts2Dao dao;
	
	
	@RequestMapping("/selectfinancialTables")
	@ResponseBody
	public List<FinancialTables> selectfinancialTables(){
		List<FinancialTables> list=service.selectfinancialTables();
		return list;
	}
	
	@RequestMapping("/importExcel")//导入收款项目
	@ResponseBody
	public int importExcel(@RequestParam("file") MultipartFile file,String time,HttpServletResponse response,HttpSession session) throws IOException{
		InputStream is=file.getInputStream();
		ImportData importData=new ImportData();
		Map<String, Object> map = importData.fR2readXls(is,time);
		int i=service.addFinancialReceipts2(map);//
		return i;
	}
	
	
	
	@RequestMapping("/selectfinancialTablesByState")
	@ResponseBody
	public List<FinancialTables> selectfinancialTablesByState(String state){
		List<FinancialTables> list=service.selectfinancialTablesByState(state);
		return list;
	}
	
	@RequestMapping("/selectFinancialDepartmentsById")
	@ResponseBody
	public List<FinancialDepartments> selectFinancialDepartmentsById(String id){
		List<FinancialDepartments> list=service.selectFinancialDepartmentsById(id);
		return list;
	}
	
	
	
	@RequestMapping("/updateState")
	@ResponseBody
	public int updateState(FinancialDepartments fd){
		return service.updateState(fd);
	}
	
	
	@RequestMapping("/getSumMoneyByYear")
	@ResponseBody
	public List<FinancialTables> getSumMoneyByYear(String year){
		year="%"+year+"%";
		List<FinancialTables> f=dao.getSumMoneyByYear(year);
		return f;
	}
	
	
	@RequestMapping("/updatefinancialTables2Byid")
	@ResponseBody()
	public Map<String,Object> updatefinancialTables2Byid(FinancialTables f){
		Map<String,Object> map=new HashMap<>();
		int i = dao.updatefinancialTables2Byid(f);
		map.put("result", i);
		map.put("obj", f);
		return map;
	}
}

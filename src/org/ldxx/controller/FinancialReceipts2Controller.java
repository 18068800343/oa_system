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
import org.ldxx.bean.FinancialReceipts;
import org.ldxx.bean.FinancialTables;
import org.ldxx.bean.TDepartment;
import org.ldxx.bean.Task2;
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
	
	
	@RequestMapping("/selectfinancialTables")
	@ResponseBody
	public List<FinancialTables> selectfinancialTables(){
		List<FinancialTables> list=service.selectfinancialTables();
		return list;
	}
	
	@RequestMapping("/importExcel")
	@ResponseBody
	public int importExcel(@RequestParam("file") MultipartFile file,HttpServletResponse response,HttpSession session) throws IOException{
		InputStream is=file.getInputStream();
		ImportData importData=new ImportData();
		Map<String, Object> map = importData.fR2readXls(is);
		int i=service.addFinancialReceipts2(map);//
		return 1;
	}
	
	
	@RequestMapping("/selectfinancialTablesByState")
	@ResponseBody
	public List<FinancialTables> selectfinancialTablesByState(String state){
		List<FinancialTables> list=service.selectfinancialTablesByState(state);
		return list;
	}
	
	
	
	@RequestMapping("/updateState")
	@ResponseBody
	public int updateState(String state,String id){
		return service.updateState(state, id);
	}
	
}

package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.ldxx.bean.Cooperator;
import org.ldxx.bean.DictionaryFirst;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.ProjectList;
import org.ldxx.bean.RiskAssessment;
import org.ldxx.service.BiddingListService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.ProjectTypeService;
import org.ldxx.service.RiskAssessmentService;
import org.ldxx.util.ExportData;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 投标项目列表
 * 
 * @author hp
 *
 */
@Controller
@RequestMapping("diddingList")
public class BiddingListController {

	@Autowired
	private BiddingListService bListService;

	@Autowired
	OrganizationManagementService omservice;
	
	@Autowired
	private RiskAssessmentService raService;
	
	@Autowired
	private ProjectTypeService projectTypeService;
	
	@RequestMapping("/adddiddingList")
	@ResponseBody
	public Map<String, Object> adddiddingList(ProjectList projectList, MultipartFile file1, MultipartFile file2,
			MultipartFile file3) {
		Map<String, Object> map = new HashMap<>();
		TimeUUID uuid = new TimeUUID();
		String id = uuid.getTimeUUID();
		projectList.setPlId(id);
		String path = "D:/oa/diddingList/" + id;
		String filename1;
		String filename2;
		String filename3;
		String path1;
		String path2;
		String path3;
		if (file1 != null) {
			filename1 = file1.getOriginalFilename();
			File f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			path1 = path + File.separator + filename1;
			File f1 = new File(path1);
			try {
				file1.transferTo(f1);
				projectList.setZhaofile(filename1);
				projectList.setZhaofileUrl(path1);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				map.put("result", 0);
			}

		}
		if (file2 != null) {
			filename2 = file2.getOriginalFilename();
			File f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			path2 = path + File.separator + filename2;
			File f2 = new File(path2);
			try {
				file2.transferTo(f2);
				projectList.setToufile(filename2);
				projectList.setToufileUrl(path2);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				map.put("result", 0);
			}
		}
		if (file3 != null) {
			filename3 = file3.getOriginalFilename();
			File f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			path3 = path + File.separator + filename3;
			File f3 = new File(path3);
			try {
				file3.transferTo(f3);
				projectList.setDrawing(filename3);
				projectList.setDrawingUrl(path3);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				map.put("result", 0);
			}
		}
		int i = bListService.adddiddingList(projectList);
		map.put("result", i);
		map.put("projectList", projectList);
		return map;
	}

	@RequestMapping("/selectdiddingListById")
	@ResponseBody
	public ProjectList selectdiddingListById(String id) {
		return bListService.selectdiddingListById(id);
	}
	
	@RequestMapping("/deletediddingListById")
	@ResponseBody
	public int deletediddingListById(String plId) {
		return bListService.deletediddingListById(plId);
	}

	@RequestMapping("/deletezhaoFileById")
	@ResponseBody
	public int deletezhaoFileById(String plId) {
		return bListService.deletezhaoFileById(plId);
	}

	@RequestMapping("/deletetouFileById")
	@ResponseBody
	public int deletetouFileById(String plId) {
		return bListService.deletetouFileById(plId);
	}

	@RequestMapping("/deletetuzhiFileById")
	@ResponseBody
	public int deletetuzhiFileById(String plId) {
		return bListService.deletetuzhiFileById(plId);
	}

	@SuppressWarnings("unused")
	@RequestMapping("/updatediddingList")
	@ResponseBody
	public Map<String, Object> updatediddingList(ProjectList projectList, MultipartFile file1, MultipartFile file2,
			MultipartFile file3) {
		Map<String, Object> map = new HashMap<>();
		String id = projectList.getPlId();
		String path = "D:/oa/diddingList/" + id;
		String filename1;
		String filename2;
		String filename3;
		String path1;
		String path2;
		String path3;
		if (file1 != null) {
			filename1 = file1.getOriginalFilename();
			File f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			path1 = path + File.separator + filename1;
			File f1 = new File(path1);
			try {
				file1.transferTo(f1);
				projectList.setZhaofile(filename1);
				projectList.setZhaofileUrl(path1);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				map.put("result", 0);
			}

		}
		if (file2 != null) {
			filename2 = file2.getOriginalFilename();
			File f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			path2 = path + File.separator + filename2;
			File f2 = new File(path2);
			try {
				file2.transferTo(f2);
				projectList.setToufile(filename2);
				projectList.setToufileUrl(path2);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				map.put("result", 0);
			}
		}
		if (file3 != null) {
			filename3 = file3.getOriginalFilename();
			File f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			path3 = path + File.separator + filename3;
			File f3 = new File(path3);
			try {
				file3.transferTo(f3);
				projectList.setDrawing(filename3);
				projectList.setDrawingUrl(path3);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				map.put("result", 0);
			}
		}
		int i = bListService.updatediddingList(projectList);
		map.put("result", i);
		map.put("projectList", projectList);
		return map;
	}

	@RequestMapping("/selectdiddingList")
	@ResponseBody
	public List<ProjectList> selectdiddingList() {
		return bListService.selectdiddingList();
	}

	@RequestMapping("/selectdiddingUnitAndType")
	@ResponseBody
	public List<ProjectList> selectdiddingUnitAndType() {/* 初始化部门和类型 */
		return bListService.selectdiddingUnitAndType();
	}

	@RequestMapping("/selectdiddingByUnitAndType")
	@ResponseBody
	public List<ProjectList> selectdiddingByUnitAndType(String plUnit, String prjType) { //通过部门和类型查询 
		return bListService.selectdiddingByUnitAndType(plUnit, prjType);
	}

	// 导入
	@RequestMapping("/ImportiddingList")
	@ResponseBody
	public int ImportiddingList(@RequestParam("file") MultipartFile file, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Workbook hssfWorkbook = null;
		TimeUUID uuid = new TimeUUID();
		String id = uuid.getTimeUUID();
		String path = "D:/oa/diddingList/" + id;
		try {
			InputStream is = file.getInputStream();
			String filename = file.getOriginalFilename();
			File f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			String path1 = path + File.separator + filename;
			File f1 = new File(path1);
			file.transferTo(f1);
			hssfWorkbook = WorkbookFactory.create(is);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		// 开始解析
		Sheet sheet = hssfWorkbook.getSheetAt(0); // 读取sheet 0
		int firstRowIndex = sheet.getFirstRowNum() + 1; // 第一行是列名，所以不读
		int lastRowIndex = sheet.getLastRowNum();
		int i = 0;
		ProjectList projectList = new ProjectList();
		// 循环工作表Sheet
		for (int rIndex = firstRowIndex; rIndex < lastRowIndex; rIndex++) {
			Row row = sheet.getRow(rIndex);
			if (row != null) {
				int firstCellIndex = row.getFirstCellNum();
				int lastCellIndex = row.getLastCellNum();
				for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {// 遍历列
					Cell cell = row.getCell(cIndex);
					if (cell != null && !"".equals(cell.toString().trim())) {
						switch (cIndex) {
						case 0:// 投标部门
							String bumen = cell.toString();
							projectList.setOmName(bumen);
							break;
						case 1:// 项目名称
							String prjName = cell.toString();
							projectList.setPrjName(prjName);
							break;
						/*case 2:// 项目类型1
							String prjtype1 = cell.toString();
							projectList.setNameFirst(prjtype1);
							break;*/
						case 2:// 项目类型
							String prjtype = cell.toString();
							projectList.setPrjType(prjtype);
							break;
						case 3:// 是否中标
							String zhongbiao = cell.toString();
							projectList.setIsbiding(zhongbiao);
							break;
						case 4:// 中标金额
							String money = cell.toString()/*.split("\\.")[0]*/;
							projectList.setPlMoney(money);
							break;
						case 5:// 招标文件
							String zhao = cell.toString();
							projectList.setZhaofile(zhao);
							break;
						case 6:// 招标文件地址
							String zhaoUrl = cell.toString();
							projectList.setZhaofileUrl(zhaoUrl);
							break;
						case 7:// 投标文件
							String tou = cell.toString();
							projectList.setToufile(tou);
							break;
						case 8:// 投标文件地址
							String touUrl = cell.toString();
							projectList.setToufileUrl(touUrl);
							break;
						case 9:// 图纸
							String tuzhi = cell.toString();
							projectList.setDrawing(tuzhi);
							break;
						case 10:// 图纸地址
							String tuzhiUrl = cell.toString();
							projectList.setDrawingUrl(tuzhiUrl);
							break;
						default:
							break;
						}
					}
				}
				
				OrganizationManagement om = omservice.getOrgIdByName(projectList.getOmName());
				projectList.setPlUnit(om.getOmId());
				/*RiskAssessment rs = raService.selectIdByName(projectList.getPrjId());
				projectList.setPrjName(rs.getRaId());
				DictionaryFirst df = projectTypeService.selectOneIdByName(projectList.getNameFirst());
				projectList.setPrjType(df.getIdFirst());*/
				
				TimeUUID uuid2 = new TimeUUID();
				String id2 = uuid.getTimeUUID();
				projectList.setPlId(id2);
				i = bListService.adddiddingList(projectList);
			}
		}
		return i;
	}

	// 导出
	@RequestMapping("/exportdiddingList")
	@ResponseBody
	public void exportCooperator(HttpServletResponse response) throws Exception {
		String xlsName = "投标项目信息表";
		ExportData exportData = new ExportData();
		List<ProjectList> projectList = bListService.selectdiddingList();
		List<List<String>> dataList = new ArrayList<>();
		for (int i = 0; i < projectList.size(); i++) {
			List<String> data = new ArrayList<>();
			data.add(i + 1 + "");
			data.add(projectList.get(i).getOmName());
			data.add(projectList.get(i).getPrjName());
			data.add(projectList.get(i).getPrjType());
			data.add(projectList.get(i).getIsbiding());
			data.add(projectList.get(i).getPlMoney());
			data.add(projectList.get(i).getZhaofile());
			data.add(projectList.get(i).getZhaofileUrl());
			data.add(projectList.get(i).getToufile());
			data.add(projectList.get(i).getToufileUrl());
			data.add(projectList.get(i).getDrawing());
			data.add(projectList.get(i).getDrawingUrl());
			dataList.add(data);
		}
		String[] array = { "编号", "投标部门", "项目名称", "项目类型", "是否中标", "中标金额", "招标文件", "招标文件地址", "投标文件", "投标文件地址", "图纸",
				"图纸地址" };
		exportData.ExportWithResponse(xlsName, xlsName, array.length, array, dataList, response);
	}

}

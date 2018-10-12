package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CompanyMateriaIn;
import org.ldxx.bean.clfbCgcontractPerformance;
import org.ldxx.service.GsMaterialInService;
import org.ldxx.util.ExportData;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 公司材料入库
 * @author hp
 *
 */
@RequestMapping("gsMaterialIn")
@Controller
public class GsMaterialInController {
	
	@Autowired
	private GsMaterialInService gmService;
	
	@RequestMapping("/selectGsMaterialIn")
	@ResponseBody
	public List<CompanyMateriaIn> selectGsMaterialIn(){
		return gmService.selectGsMaterialIn();
	}
	
	@RequestMapping("/addGsMaterialInSave")//添加保存
	@ResponseBody
	public Map<String,Object> addGsMaterialInSave(CompanyMateriaIn cm,@RequestParam("file") MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cm.setCmId(id);
		
		
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String path="D:"+File.separator+"oa"+File.separator+"gsMaterialIn"+File.separator+id;
				File f=new File(path);
				if(!f.exists()){
					f.mkdirs();
				}
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				list.add(accessory);
			}
			cm.setAccessory(list);
		}
		int i=gmService.addGsMaterialInSave(cm);
		map.put("result", i);
		map.put("CompanyMateriaIn", cm);
		return map;
	}
	
	
	@RequestMapping("/addGsMaterialInSubmit")//添加提交
	@ResponseBody
	public Map<String,Object> addGsMaterialInSubmit(CompanyMateriaIn cm,@RequestParam("file") MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cm.setCmId(id);
		
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String path="D:"+File.separator+"oa"+File.separator+"gsMaterialIn"+File.separator+id;
				File f=new File(path);
				if(!f.exists()){
					f.mkdirs();
				}
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				list.add(accessory);
			}
			cm.setAccessory(list);
		}
		int i=gmService.addGsMaterialInSave(cm);
		map.put("result", i);
		map.put("CompanyMateriaIn", cm);
		return map;
	}
	
	
	@RequestMapping("/updateGsMaterialInSave")//修改保存
	@ResponseBody
	public Map<String,Object> updateGsMaterialInSave(CompanyMateriaIn cm,@RequestParam("file") MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cm.setCmId(id);
		
		
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String path="D:"+File.separator+"oa"+File.separator+"gsMaterialIn"+File.separator+id;
				File f=new File(path);
				if(!f.exists()){
					f.mkdirs();
				}
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				list.add(accessory);
			}
			cm.setAccessory(list);
		}
		int i=gmService.addGsMaterialInSave(cm);
		map.put("result", i);
		map.put("CompanyMateriaIn", cm);
		return map;
	}
	
	@RequestMapping("/selectAccessoryById")
	@ResponseBody
	public List<Accessory> selectAccessoryById(String id){
		List<Accessory> list=gmService.selectAccessoryById(id);
		return list;
	}
	
	@RequestMapping("/deleteAccessory")
	@ResponseBody
	public int deleteAccessory(Accessory accessory){
		int i=gmService.deleteAccessoryByIdAndName(accessory);
		if(i>0){
			File f=new File(accessory.getAcUrl());
			f.delete();
		}
		return i;
	}
	
	@RequestMapping("/exportgsMaterialIn")//导出 
	@ResponseBody
	public void exportCooperator(HttpServletResponse response) throws Exception {
		String xlsName = "公司材料入库";
		ExportData exportData = new ExportData();
		List<CompanyMateriaIn> projectList = gmService.selectGsMaterialIn();
		List<List<String>> dataList = new ArrayList<>();
		for (int i = 0; i < projectList.size(); i++) {
			List<String> data = new ArrayList<>();
			data.add(i + 1 + "");
			data.add(projectList.get(i).getCgNo());
			data.add(projectList.get(i).getTaskNo());
			data.add(projectList.get(i).getDemandProject());
			data.add(projectList.get(i).getMaterialName());
			data.add(projectList.get(i).getMaterialType());
			data.add(projectList.get(i).getSpecificationModel());
			data.add(projectList.get(i).getCmUnit());
			data.add(projectList.get(i).getCmNumber());
			data.add(projectList.get(i).getCmUnitPrice()+"");
			data.add(projectList.get(i).getCmMoney()+"");
			data.add(projectList.get(i).getSentDate());
			data.add(projectList.get(i).getSentUnit());
			data.add(projectList.get(i).getManufacturer());
			data.add(projectList.get(i).getOmName());
			data.add(projectList.get(i).getuName());
			data.add(projectList.get(i).getCmDesc());
			data.add(projectList.get(i).getAcceptanceOpinion());
			dataList.add(data);
		}
		String[] array = { "编号","采购合同号" , "任务单号", "需求项目", "材料名称", "材料类型","规格型号", "单位", "数量", "单价", "金额", "收货日期", "来货单位",
				"生产厂家","收货人所属部门","收货人","备注","验收及处理意见"};
		exportData.ExportWithResponse(xlsName, xlsName, array.length, array, dataList, response);
	}
	
	@RequestMapping("/selectcgNotaskNoPrjName")//初始化采购合同号、任务单号、项目名 
	@ResponseBody
	public List<CompanyMateriaIn> selectcgNotaskNoPrjName(){
		return gmService.selectcgNotaskNoPrjName();
	}
	
	@RequestMapping("/selecttaskNoPrjNameBycgNo")//通过采购合同号查找任务单号、项目名 
	@ResponseBody
	public List<CompanyMateriaIn> selecttaskNoPrjNameBycgNo(String cgNo){
		return gmService.selecttaskNoPrjNameBycgNo(cgNo);
	}
	
	@RequestMapping("/selectcgNoPrjNameBytaskNo")//通过任务单号查找采购合同号、项目名 
	@ResponseBody
	public List<CompanyMateriaIn> selectcgNoPrjNameBytaskNo(String taskNo){
		return gmService.selectcgNoPrjNameBytaskNo(taskNo);
	}
	
	@RequestMapping("/selectcgNotaskNoByPrjName")//通过项目名 查找采购合同号、任务单号
	@ResponseBody
	public List<CompanyMateriaIn> selectcgNotaskNoByPrjName(String name){
		return gmService.selectcgNotaskNoByPrjName(name);
	}

}

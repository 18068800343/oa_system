package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.Cooperator;
import org.ldxx.bean.FbContractOverWj;
import org.ldxx.service.FbContractOverWjService;
import org.ldxx.util.ExportData;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
/**
 * 分包合同履约
 * @author hp
 *
 */
@Controller
@RequestMapping("fbOverWj")
public class FbContractOverWjController {

	@Autowired
	private FbContractOverWjService service;
	
	@RequestMapping("/addFbContractOverWjBySave")
	@ResponseBody
	public int addFbContractOverWjBySave(FbContractOverWj fbContractOverWj,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file1) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		fbContractOverWj.setFcowId(id);
		String path="D:"+File.separator+"oa"+File.separator+"fbContractOverWj"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[ii].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("合同文本");
				list.add(accessory);
			}
			fbContractOverWj.setAccessory(list);
		}
		if(file1.length>0){
			List<Accessory> list1=new ArrayList<>();
			for(int ii=0;ii<file1.length;ii++){
				Accessory accessory1=new Accessory();
				String fileName=file1[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file1[ii].transferTo(f2);
				accessory1.setaId(id);
				accessory1.setAcName(fileName);
				accessory1.setAcUrl(filePath);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			fbContractOverWj.setAccessory1(list1);
		}
		int i=service.addFbContractOverWj(fbContractOverWj);
		return i;
	}
	
	@RequestMapping("/addFbContractOverWjBySubmit")
	@ResponseBody
	public int addFbContractOverWjBySubmit(FbContractOverWj fbContractOverWj,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file1) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		fbContractOverWj.setFcowId(id);
		String path="D:"+File.separator+"oa"+File.separator+"fbContractOverWj"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[ii].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("合同文本");
				list.add(accessory);
			}
			fbContractOverWj.setAccessory(list);
		}
		if(file1.length>0){
			List<Accessory> list1=new ArrayList<>();
			for(int ii=0;ii<file1.length;ii++){
				Accessory accessory1=new Accessory();
				String fileName=file1[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file1[ii].transferTo(f2);
				accessory1.setaId(id);
				accessory1.setAcName(fileName);
				accessory1.setAcUrl(filePath);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			fbContractOverWj.setAccessory1(list1);
		}
		int i=service.addFbContractOverWj(fbContractOverWj);
		return i;
	}
	
	@RequestMapping("/selectFbContractOverWj")
	@ResponseBody
	public List<FbContractOverWj> selectFbContractOverWj(String state){
		return service.selectFbContractOverWj(state);
	}
	
	
	@RequestMapping("/exportFbOverWj")
	@ResponseBody
	public void exportFbOverWj(HttpServletResponse response,String state) throws Exception{
		String xlsName = "分包合同履约表";  
		ExportData exportData=new ExportData();
		List<FbContractOverWj> fb=service.selectFbContractOverWj(state);
		 List<List<String>> dataList=new ArrayList<>();
		for(int i=0;i<fb.size();i++){
			List<String> data=new ArrayList<>();
			data.add(i+1+"");
			data.add(fb.get(i).getFbContractName());
			data.add(fb.get(i).getFbContract());
			data.add(fb.get(i).getPrjCode());
			data.add(fb.get(i).getPrjChargePerson());
			data.add(fb.get(i).getCjContractName());
			data.add(fb.get(i).getCjContract());
			data.add(fb.get(i).getYiFang());
			data.add(fb.get(i).getFbChargePerson());
			data.add(fb.get(i).getContractMoney()+"");
			data.add(fb.get(i).getProvisionalMoney()+"");
			data.add(fb.get(i).getOverWorkMoney()+"");
			data.add(fb.get(i).getOverWorkExplain());
			data.add(fb.get(i).getAllPayMoney()+"");
			data.add(fb.get(i).getDoAppointScore());
			data.add(fb.get(i).getPrjProbablyText());
			dataList.add(data);
		}
		String [] array={"编号","分包合同名称","分包合同","任务单号","项目负责人","承接合同名称","承接合同","合同乙方单位","分包合同负责人","合同金额","暂定金","结算金额","结算说明","累计付款","履约评级","项目概况"};
	        exportData.ExportWithResponse(xlsName,xlsName,  
	        		array.length, array, dataList, response);
	}
	
	@RequestMapping("/getAllPayMoneyByFbNo")
	@ResponseBody
	public List<FbContractOverWj> getAllPayMoneyByFbNo(String no){
		List<FbContractOverWj> fb=service.getAllPayMoneyByFbNo(no);
		return fb;
	}
	
}

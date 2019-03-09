package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.ManagingDocuments;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.PrjRecord;
import org.ldxx.bean.User;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.service.PrjRecordService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/PrjRecord")
public class PrjRecordController {
	
	@Autowired
	private PrjRecordService pServcie;
	@Autowired
	private AccessoryDao aDao;
	
	@RequestMapping("/addPrjRecord")
	@ResponseBody
	public Map<String,Object> addPrjRecord(PrjRecord pr){
		Map<String,Object> map=new HashMap<String, Object>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		pr.setId(id);
		int i = pServcie.addPrjRecord(pr);
		map.put("result", i);
		map.put("pr", pr);
		return map;		
	}
	
	@RequestMapping("/selectPrjRecord")
	@ResponseBody
	public List<PrjRecord> selectPrjRecord(){
		List<PrjRecord> pr=pServcie.selectPrjRecord();
		return pr;		
	}

	
	@RequestMapping("/addScRecord")
	@ResponseBody
	public int addScRecord(String id,@RequestParam(required=false,value="file1") MultipartFile [] file1,@RequestParam(required=false,value="file2") MultipartFile [] file2,@RequestParam(required=false,value="file3") MultipartFile [] file3,
			@RequestParam(required=false,value="file4") MultipartFile [] file4,@RequestParam(required=false,value="file5") MultipartFile [] file5,HttpSession session,HttpServletResponse response) throws IllegalStateException, IOException{
		response.setCharacterEncoding("UTF-8");
		
		TimeUUID uuid=new TimeUUID();
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		List<Accessory> list=new ArrayList<>();
		if(file1.length>0){
			for(int i=0;i<file1.length;i++){
				Accessory accessory1=new Accessory();
				String fileName1=file1[i].getOriginalFilename();
				String filePath1=path+File.separator+fileName1;
				File f1=new File(filePath1);
				file1[i].transferTo(f1);
				accessory1.setaId(id);
				accessory1.setAcName(fileName1);
				accessory1.setAcUrl(id+File.separator+fileName1);
				accessory1.setaType("JY招标文件");
				list.add(accessory1);
			}
		}
		if(file2.length>0){
			for(int i=0;i<file2.length;i++){
				Accessory accessory2=new Accessory();
				String fileName1=file2[i].getOriginalFilename();
				String filePath2=path+File.separator+fileName1;
				File f2=new File(filePath2);
				file2[i].transferTo(f2); 
				accessory2.setaId(id);
				accessory2.setAcName(fileName1);
				accessory2.setAcUrl(id+File.separator+fileName1);
				accessory2.setaType("JY招标图纸");
				list.add(accessory2);
			}
		}
		if(file3.length>0){
			for(int i=0;i<file3.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file3[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file3[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("JY投标文件(技术+商务)");
				list.add(accessory);
			}
		}
		if(file4.length>0){
			for(int i=0;i<file4.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file4[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file4[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("JY中标通知书(原件由经营部存档)");
				list.add(accessory);
			}
		}
		if(file5.length>0){
			for(int i=0;i<file5.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file5[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file5[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("JY开标记录");
				list.add(accessory);
			}
		}
		int i=aDao.addAccessory(list);
		return i;
	}
	
}

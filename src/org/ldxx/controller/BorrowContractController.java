package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.BorrowContract;
import org.ldxx.bean.CgContract;
import org.ldxx.service.BorrowContractService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 借款合同管理
 * @author hp
 */

@RequestMapping("BorrowContract")
@Controller
public class BorrowContractController {
	
	@Autowired
	private BorrowContractService service;
	
	@RequestMapping("/selectBorrowContract")
	@ResponseBody
	public List<BorrowContract> selectBorrowContract(String status){
		return service.selectBorrowContract(status);
	}
	
	@RequestMapping("/addBorrowContractSave")
	@ResponseBody
	public Map<String,Object> addBorrowContractSave(BorrowContract bc,@RequestParam("file") MultipartFile [] file,@RequestParam("file2") MultipartFile [] file2) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		bc.setbId(id);
		int count=service.JKNocount();
		String jkNo="JK"+uuid.getClCode("", count+1);
		bc.setbNo(jkNo);
		
		String path = "D:"+File.separator+"oa"+File.separator+"BorrowContract"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				String filename = file[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("借款合同文本");
				list.add(accessory);
			}
			bc.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int i=0;i<file2.length;i++){
				String filename = file2[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file2[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("法律顾问签字");
				list2.add(accessory);
			}
			bc.setAccessory2(list2);
		}
		int i=service.addBorrowContractSave(bc);
		map.put("result", i);
		map.put("BorrowContract", bc);
		return map;
	}
	
	@RequestMapping("/addBorrowContractSubmit")
	@ResponseBody
	public Map<String,Object> addBorrowContractSubmit(BorrowContract bc,@RequestParam("file") MultipartFile [] file,@RequestParam("file2") MultipartFile [] file2) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		bc.setbId(id);
		int count=service.JKNocount();
		String jkNo="JK"+uuid.getClCode("", count+1);
		bc.setbNo(jkNo);
		
		String path = "D:"+File.separator+"oa"+File.separator+"BorrowContract"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				String filename = file[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("借款合同文本");
				list.add(accessory);
			}
			bc.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int i=0;i<file2.length;i++){
				String filename = file2[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file2[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("法律顾问签字");
				list2.add(accessory);
			}
			bc.setAccessory2(list2);
		}
		int i=service.addBorrowContractSave(bc);
		map.put("result", i);
		map.put("BorrowContract", bc);
		return map;
	}
	
	@RequestMapping("/updateBorrowContractSave")
	@ResponseBody
	public Map<String,Object> updateBorrowContractSave(BorrowContract bc,@RequestParam("file") MultipartFile [] file,@RequestParam("file2") MultipartFile [] file2) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		bc.setbId(id);
		
		String path = "D:"+File.separator+"oa"+File.separator+"BorrowContract"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				String filename = file[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("借款合同文本");
				list.add(accessory);
			}
			bc.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int i=0;i<file2.length;i++){
				String filename = file2[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file2[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("法律顾问签字");
				list2.add(accessory);
			}
			bc.setAccessory2(list2);
		}
		int i=service.addBorrowContractSave(bc);
		map.put("result", i);
		map.put("BorrowContract", bc);
		return map;
	}
	
	@RequestMapping("/updateBorrowContractSubmit")
	@ResponseBody
	public Map<String,Object> updateBorrowContractSubmit(BorrowContract bc,@RequestParam("file") MultipartFile [] file,@RequestParam("file2") MultipartFile [] file2) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		bc.setbId(id);
		
		String path = "D:"+File.separator+"oa"+File.separator+"BorrowContract"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				String filename = file[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("借款合同文本");
				list.add(accessory);
			}
			bc.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int i=0;i<file2.length;i++){
				String filename = file2[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file2[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("法律顾问签字");
				list2.add(accessory);
			}
			bc.setAccessory2(list2);
		}
		int i=service.addBorrowContractSave(bc);
		map.put("result", i);
		map.put("BorrowContract", bc);
		return map;
	}
	
	@RequestMapping("/selectBorrowContractHistory")
	@ResponseBody
	public List<BorrowContract> selectBorrowContractHistory(String no){
		return service.selectBorrowContractHistory(no);
	}
	
	@RequestMapping("/updateHistoryById") //通过id修改历史状态，prjno为当前的全部改为0，再把当前这条记录的历史状态改为1
	@ResponseBody
	public int updateHistoryById(String id){
		return service.updateHistoryById(id);
	}
	

}

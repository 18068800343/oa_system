package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.Pay;
import org.ldxx.service.ContractPaymentService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 合同付款
 * @author hp
 *
 */

@RequestMapping("pay")
@Controller
public class ContractPaymentController {
	
	@Autowired
	private ContractPaymentService payService;
	
	@RequestMapping("/selectPayByStatus")
	@ResponseBody
	public List<Pay> selectPayByStatus(String status){
		return payService.selectPayByStatus(status);
	}

	@RequestMapping("/selectPayById")
	@ResponseBody
	public Pay selectPayById(String id){
		return payService.selectPayById(id);
	}
	
	@RequestMapping("/addPaySave")//添加保存
	@ResponseBody
	public int addPaySave(Pay pay,@RequestParam("file1") MultipartFile [] file1,@RequestParam("file2") MultipartFile [] file2,@RequestParam("file3") MultipartFile [] file3) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		pay.setPayId(id);
		
		int count=payService.fkNocount();
		String fkNo="FBFK"+uuid.getPrjCode("", count+1);
		pay.setPayCode(fkNo);
		
		String path="D:"+File.separator+"oa"+File.separator+"pay";
		List<Accessory> list=new ArrayList<>();
		List<Accessory> list2=new ArrayList<>();
		List<Accessory> list3=new ArrayList<>();
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file1.length>0){
			for(int i=0;i<file1.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file1[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("开票附件");
				list.add(accessory);
			}
			pay.setAccessory(list);
		}
		if(file2.length>0){
			for(int i=0;i<file2.length;i++){
				Accessory accessory2=new Accessory();
				String fileName=file2[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[i].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(filePath);
				accessory2.setaType("附件上传");
				list2.add(accessory2);
			}
			pay.setAccessory2(list2);
		}
		if(file3.length>0){
			for(int i=0;i<file3.length;i++){
				Accessory accessory3=new Accessory();
				String fileName=file3[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file3[i].transferTo(f2);
				accessory3.setaId(id);
				accessory3.setAcName(fileName);
				accessory3.setAcUrl(filePath);
				accessory3.setaType("法律顾问签字");
				list3.add(accessory3);
			}
			pay.setAccessory3(list3);
		}
		int i=payService.addCgContract(pay);
		return i; 
	}
	
	@RequestMapping("/addPaySubmit")//添加提交
	@ResponseBody
	public int addPaySubmit(Pay pay,@RequestParam("file1") MultipartFile [] file1,@RequestParam("file2") MultipartFile [] file2,@RequestParam("file3") MultipartFile [] file3) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		pay.setPayId(id);
		
		int count=payService.fkNocount();
		count=count+1;
		String fkNo=uuid.getPrjCode("", count);
		fkNo="FBFK"+fkNo;
		pay.setPayCode(fkNo);
		
		String path="D:"+File.separator+"oa"+File.separator+"pay";
		List<Accessory> list=new ArrayList<>();
		List<Accessory> list2=new ArrayList<>();
		List<Accessory> list3=new ArrayList<>();
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file1.length>0){
			for(int i=0;i<file1.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file1[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("开票附件");
				list.add(accessory);
			}
			pay.setAccessory(list);
		}
		if(file2.length>0){
			for(int i=0;i<file2.length;i++){
				Accessory accessory2=new Accessory();
				String fileName=file2[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[i].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(filePath);
				accessory2.setaType("附件上传");
				list2.add(accessory2);
			}
			pay.setAccessory2(list2);
		}
		if(file3.length>0){
			for(int i=0;i<file3.length;i++){
				Accessory accessory3=new Accessory();
				String fileName=file3[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file3[i].transferTo(f2);
				accessory3.setaId(id);
				accessory3.setAcName(fileName);
				accessory3.setAcUrl(filePath);
				accessory3.setaType("法律顾问签字");
				list3.add(accessory3);
			}
			pay.setAccessory3(list3);
		}
		int i=payService.addCgContract(pay);
		return i; 
	}
	
	
	@RequestMapping("/updatePaySave")//修改保存
	@ResponseBody
	public int updatePaySave(Pay pay,@RequestParam("file1") MultipartFile [] file1,@RequestParam("file2") MultipartFile [] file2,@RequestParam("file3") MultipartFile [] file3) throws IllegalStateException, IOException{
		payService.updateHistory(pay.getPayId());
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		pay.setPayId(id);
		
		String path="D:"+File.separator+"oa"+File.separator+"pay";
		List<Accessory> list=new ArrayList<>();
		List<Accessory> list2=new ArrayList<>();
		List<Accessory> list3=new ArrayList<>();
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file1.length>0){
			for(int i=0;i<file1.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file1[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("开票附件");
				list.add(accessory);
			}
			pay.setAccessory(list);
		}
		if(file2.length>0){
			for(int i=0;i<file2.length;i++){
				Accessory accessory2=new Accessory();
				String fileName=file2[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[i].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(filePath);
				accessory2.setaType("附件上传");
				list2.add(accessory2);
			}
			pay.setAccessory2(list2);
		}
		if(file3.length>0){
			for(int i=0;i<file3.length;i++){
				Accessory accessory3=new Accessory();
				String fileName=file3[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file3[i].transferTo(f2);
				accessory3.setaId(id);
				accessory3.setAcName(fileName);
				accessory3.setAcUrl(filePath);
				accessory3.setaType("法律顾问签字");
				list3.add(accessory3);
			}
			pay.setAccessory3(list3);
		}
		int i=payService.addCgContract(pay);
		return i;
	}
	
	@RequestMapping("/updatePaySubmit")//修改提交
	@ResponseBody
	public int updatePaySubmit(Pay pay,@RequestParam("file1") MultipartFile [] file1,@RequestParam("file2") MultipartFile [] file2,@RequestParam("file3") MultipartFile [] file3) throws IllegalStateException, IOException{
		payService.updateHistory(pay.getPayId());
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		pay.setPayId(id);
		
		String path="D:"+File.separator+"oa"+File.separator+"pay";
		List<Accessory> list=new ArrayList<>();
		List<Accessory> list2=new ArrayList<>();
		List<Accessory> list3=new ArrayList<>();
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file1.length>0){
			for(int i=0;i<file1.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file1[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("开票附件");
				list.add(accessory);
			}
			pay.setAccessory(list);
		}
		if(file2.length>0){
			for(int i=0;i<file2.length;i++){
				Accessory accessory2=new Accessory();
				String fileName=file2[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[i].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(filePath);
				accessory2.setaType("附件上传");
				list2.add(accessory2);
			}
			pay.setAccessory2(list2);
		}
		if(file3.length>0){
			for(int i=0;i<file3.length;i++){
				Accessory accessory3=new Accessory();
				String fileName=file3[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file3[i].transferTo(f2);
				accessory3.setaId(id);
				accessory3.setAcName(fileName);
				accessory3.setAcUrl(filePath);
				accessory3.setaType("法律顾问签字");
				list3.add(accessory3);
			}
			pay.setAccessory3(list3);
		}
		int i=payService.addCgContract(pay);
		return i;
	}
	
	@RequestMapping("/selectAccessoryById")
	@ResponseBody
	public List<Accessory> selectAccessoryById(String id){
		List<Accessory> list=payService.selectAccessoryById(id);
		return list;
	}
	
	@RequestMapping("/deleteAccessory")
	@ResponseBody
	public int deleteAccessory(Accessory accessory){
		int i=payService.deleteAccessoryByIdAndName(accessory);
		if(i>0){
			File f=new File(accessory.getAcUrl());
			f.delete();
		}
		return i;
	}
	
	@RequestMapping("/selectHistoryBypayCode")
	@ResponseBody
	public List<Pay> selectHistoryBypayCode(String payCode){
		return payService.selectHistoryBypayCode(payCode);
	}
	

}

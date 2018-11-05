package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.clfbContractPurchaseSettlement;
import org.ldxx.service.MaterialPurchaseSettlementService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 材料分包合同下的采购结算申请
 * @author hp
 *
 */

@RequestMapping("materialPurchaseSettlement")
@Controller
public class MaterialPurchaseSettlementController {
	
	@Autowired
	private MaterialPurchaseSettlementService mService;
	
	@RequestMapping("/selectmaterialPurchaseSettlement")//初始化
	@ResponseBody
	public List<clfbContractPurchaseSettlement> selectmaterialPurchaseSettlement(String status){
		List<clfbContractPurchaseSettlement> list = mService.selectmaterialPurchaseSettlement(status);
		return list;
	}
	
	@RequestMapping("/addmaterialPurchaseSettlementSave")//添加保存
	@ResponseBody
	public Map<String,Object> addmaterialPurchaseSettlementSave(clfbContractPurchaseSettlement c,@RequestParam("file")MultipartFile file[]) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<String, Object>();
		TimeUUID uuid=new TimeUUID();
		String id = uuid.getTimeUUID();
		c.setCpId(id);
		int count=mService.cgjsNocount();
		count=count+1;
		String code=uuid.getPrjCode("", count);
		code="CGJS"+code;
		c.setCgjsNo(code);
		
		String path = "D:"+File.separator+"oa"+File.separator+"materialPurchaseSettlement";
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
				accessory.setaType("法律顾问签字");
				list.add(accessory);
			}
			c.setAccessory(list);
		}
		int i=mService.addmaterialPurchaseSettlementSave(c);
		map.put("result",i);
		map.put("clfbContractPurchaseSettlement", c);
		return map;
	}
	
	@RequestMapping("/addmaterialPurchaseSettlementSubmit")//添加提交
	@ResponseBody
	public Map<String,Object> addmaterialPurchaseSettlementSubmit(clfbContractPurchaseSettlement c,@RequestParam("file")MultipartFile file[]) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<String, Object>();
		TimeUUID uuid=new TimeUUID();
		String id = uuid.getTimeUUID();
		c.setCpId(id);
		int count=mService.cgjsNocount();
		count=count+1;
		String code=uuid.getPrjCode("", count);
		code="CGJS"+code;
		c.setCgjsNo(code);
		
		String path = "D:"+File.separator+"oa"+File.separator+"materialPurchaseSettlement";
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
				accessory.setaType("法律顾问签字");
				list.add(accessory);
			}
			c.setAccessory(list);
		}
		
		int i=mService.addmaterialPurchaseSettlementSave(c);
		map.put("result",i);
		map.put("clfbContractPurchaseSettlement", c);
		return map;
	}
	
	
	@RequestMapping("/updatematerialPurchaseSettlementSave")//修改保存
	@ResponseBody
	public Map<String,Object> updatematerialPurchaseSettlementSave(clfbContractPurchaseSettlement c,@RequestParam("file")MultipartFile file[]) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<String, Object>();
		mService.updateHistory(c.getCpId());
		TimeUUID uuid=new TimeUUID();
		String id = uuid.getTimeUUID();
		c.setCpId(id);
		
		String path = "D:"+File.separator+"oa"+File.separator+"materialPurchaseSettlement";
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
				accessory.setaType("法律顾问签字");
				list.add(accessory);
			}
			c.setAccessory(list);
		}
		
		int i=mService.addmaterialPurchaseSettlementSave(c);
		map.put("result",i);
		map.put("clfbContractPurchaseSettlement", c);
		return map;
	}
	
	
	@RequestMapping("/updatematerialPurchaseSettlementSubmit")//修改提交
	@ResponseBody
	public Map<String,Object> updatematerialPurchaseSettlementSubmit(clfbContractPurchaseSettlement c,@RequestParam("file")MultipartFile file[]) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<String, Object>();
		mService.updateHistory(c.getCpId());
		TimeUUID uuid=new TimeUUID();
		String id = uuid.getTimeUUID();
		c.setCpId(id);
		
		String path = "D:"+File.separator+"oa"+File.separator+"materialPurchaseSettlement";
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
				accessory.setaType("法律顾问签字");
				list.add(accessory);
			}
			c.setAccessory(list);
		}
		
		int i=mService.addmaterialPurchaseSettlementSave(c);
		map.put("result",i);
		map.put("clfbContractPurchaseSettlement", c);
		return map;
	}
	
	
	@RequestMapping("/selectAccessoryById")
	@ResponseBody
	public List<Accessory> selectAccessoryById(String id){
		List<Accessory> list=mService.selectAccessoryById(id);
		return list;
	}
	
	@RequestMapping("/deleteAccessory")
	@ResponseBody
	public int deleteAccessory(Accessory accessory){
		int i=mService.deleteAccessoryByIdAndName(accessory);
		if(i>0){
			File f=new File(accessory.getAcUrl());
			f.delete();
		}
		return i;
	}
	
	
	@RequestMapping("/selectmaterialPurchaseSettlementById")//通过id查询
	@ResponseBody
	public clfbContractPurchaseSettlement selectmaterialPurchaseSettlementById(String id){
		return mService.selectmaterialPurchaseSettlementById(id);
	}
	
	@RequestMapping("/selectHistoryByNo")//通过采购结算单号查询所有历史信息
	@ResponseBody
	public List<clfbContractPurchaseSettlement> selectHistoryByNo(String no){
		return mService.selectHistoryByNo(no);
	}

}

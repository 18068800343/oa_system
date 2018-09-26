package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.FbContract;
import org.ldxx.service.SubContractService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
/**
 * 分包合同管理
 * @author hp
 *
 */
@RequestMapping("subcontract")
@Controller
public class SubContractController {

	@Autowired
	private SubContractService scService;
	
	@RequestMapping("/selectSubContract")
	@ResponseBody
	public List<FbContract> selectSubContract(String status){
		return scService.selectSubContract(status);
	}
	
	@RequestMapping("/saveSubContract")//保存
	@ResponseBody
	public Map<String,Object> saveSubContract(FbContract fbContract,@RequestParam("file")MultipartFile file[]){
		Map<String,Object> map = new HashMap<>();
		List<Accessory> list=new ArrayList<>();
		String id=new TimeUUID().getTimeUUID();
		fbContract.setFbId(id);
		String path = "D:"+File.separator+"oa"+File.separator+"subcontract";
		for(int i=0;i<file.length;i++){
			String filename = file[i].getOriginalFilename();
			File f=new File(path);
			if(!f.exists()){
				f.mkdirs();
			}
			String path1=path+File.separator+filename;
			File f1=new File(path1);
			try {
				file[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(path1);
				list.add(accessory);
				fbContract.setAccessory(list);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				map.put("result", 0);
			}
		}
		int i=scService.saveSubContract(fbContract);
		map.put("result", i);
		map.put("fbContract", fbContract);
		return map;
	}
	
	@RequestMapping("/submitSubContract")//提交
	@ResponseBody
	public Map<String,Object> submitSubContract(FbContract fbContract,@RequestParam("file")MultipartFile file[]){
		Map<String,Object> map = new HashMap<>();
		List<Accessory> list=new ArrayList<>();
		String id=new TimeUUID().getTimeUUID();
		fbContract.setFbId(id);
		String path = "D:"+File.separator+"oa"+File.separator+"subcontract";
		for(int i=0;i<file.length;i++){
			String filename = file[i].getOriginalFilename();
			File f=new File(path);
			if(!f.exists()){
				f.mkdirs();
			}
			String path1=path+File.separator+filename;
			File f1=new File(path1);
			try {
				file[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(path1);
				list.add(accessory);
				fbContract.setAccessory(list);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				map.put("result", 0);
			}
		}
		int i=scService.saveSubContract(fbContract);
		map.put("result", i);
		map.put("fbContract", fbContract);
		return map;
	}
	
	@RequestMapping("/deleteSubContractById")
	@ResponseBody
	public int deleteSubContractById(String id){
		return scService.deleteSubContractById(id);
	}
	
	@RequestMapping("/deleteAccessory")
	@ResponseBody
	public int deleteAccessory(Accessory accessory){
		int i=scService.deleteAccessoryByIdAndName(accessory);
		if(i>0){
			File f=new File(accessory.getAcUrl());
			f.delete();
		}
		return i;
	}
	
	@RequestMapping("/updateSubContractsave")
	@ResponseBody
	public Map<String,Object> updateSubContractsave(FbContract fbContract,@RequestParam("file")MultipartFile file[]){
		Map<String,Object> map = new HashMap<>();
		List<Accessory> list=new ArrayList<>();
		String id = fbContract.getFbId();
		String path = "D:"+File.separator+"oa"+File.separator+"subcontract";
		for(int i=0;i<file.length;i++){
			String filename = file[i].getOriginalFilename();
			File f=new File(path);
			if(!f.exists()){
				f.mkdirs();
			}
			String path1=path+File.separator+filename;
			File f1=new File(path1);
			try {
				file[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(path1);
				list.add(accessory);
				fbContract.setAccessory(list);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				map.put("result", 0);
			}
		}
		int i=scService.updateSubContract(fbContract);
		map.put("result", i);
		map.put("fbContract", fbContract);
		return map;
	}
	
	@RequestMapping("/updateSubContractsubmit")
	@ResponseBody
	public Map<String,Object> updateSubContractsubmit(FbContract fbContract,@RequestParam("file")MultipartFile file[]){
		Map<String,Object> map = new HashMap<>();
		List<Accessory> list=new ArrayList<>();
		String id = fbContract.getFbId();
		String path = "D:"+File.separator+"oa"+File.separator+"subcontract";
		for(int i=0;i<file.length;i++){
			String filename = file[i].getOriginalFilename();
			File f=new File(path);
			if(!f.exists()){
				f.mkdirs();
			}
			String path1=path+File.separator+filename;
			File f1=new File(path1);
			try {
				file[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(path1);
				list.add(accessory);
				fbContract.setAccessory(list);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				map.put("result", 0);
			}
		}
		int i=scService.updateSubContract(fbContract);
		map.put("result", i);
		map.put("fbContract", fbContract);
		return map;
	}
	
	@RequestMapping("/selectSubContractById")
	@ResponseBody
	public FbContract selectSubContractById(String id){
		return scService.selectSubContractById(id);
	}
	
	@RequestMapping("/selectAccessoryById")
	@ResponseBody
	public List<Accessory> selectAccessoryById(String id){
		List<Accessory> list=scService.selectAccessoryById(id);
		return list;
	}
}

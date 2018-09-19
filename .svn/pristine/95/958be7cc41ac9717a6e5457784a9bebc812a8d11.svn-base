package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.SignetManage;
import org.ldxx.service.ProjectSealService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
/**
 * 项目印章管理
 * @author hp
 *
 */
@Controller
@RequestMapping("prjSeal")
public class ProjectSealController {
	
	@Autowired
	private ProjectSealService prjSealService;
	
	@RequestMapping("/selectPrjSeal")
	@ResponseBody
	public List<SignetManage> selectPrjSeal(String status){
		return prjSealService.selectPrjSeal(status);
	}
	
	@RequestMapping("/addPrjSea")/*添加保存印章*/
	@ResponseBody
	public Map<String,Object> addPrjSeal(@RequestParam("file")MultipartFile file[],SignetManage signetManage){
		Map<String,Object> map = new HashMap<>();
		List<Accessory> list=new ArrayList<>();
		String id = new TimeUUID().getTimeUUID();
		signetManage.setSmId(id);
		String path = "D:/oa/prjSeal/" + id;
		
		for(int i=0;i<file.length;i++) {
			String filename = file[i].getOriginalFilename();
			File f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			String path1 = path + File.separator + filename;
			File f1 = new File(path1);
			try {
				file[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(path1);
				list.add(accessory);
				signetManage.setAccessory(list);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				map.put("result", 0);
			}

		}
		int i = prjSealService.addPrjSeal(signetManage);
		map.put("result", i);
		map.put("signetManage", signetManage);
		return map;
	}
	
	@RequestMapping("/addPrjSealSubmit")/*添加提交印章*/
	@ResponseBody
	public Map<String,Object> addPrjSeal2(@RequestParam("file")MultipartFile file[],SignetManage signetManage){
		Map<String,Object> map = new HashMap<>();
		List<Accessory> list=new ArrayList<>();
		String id = new TimeUUID().getTimeUUID();
		signetManage.setSmId(id);
		String path = "D:/oa/prjSeal/" + id;
		
		for(int i=0;i<file.length;i++) {
			String filename = file[i].getOriginalFilename();
			File f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			String path1 = path + File.separator + filename;
			File f1 = new File(path1);
			try {
				file[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(path1);
				list.add(accessory);
				signetManage.setAccessory(list);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				map.put("result", 0);
			}

		}
		int i = prjSealService.addPrjSeal(signetManage);
		map.put("result", i);
		map.put("signetManage", signetManage);
		return map;
	}
	
	@RequestMapping("/deletePrjSealById")
	@ResponseBody
	public int deletePrjSealById(String smId){
		return prjSealService.deletePrjSealById(smId);
	}
	
	@RequestMapping("/deleteAccessory")
	@ResponseBody
	public int deleteAccessory(Accessory accessory){
		int i=prjSealService.deleteAccessoryByIdAndName(accessory);
		if(i>0){
			File f=new File(accessory.getAcUrl());
			f.delete();
		}
		return i;
	}
	
	@RequestMapping("/updatePrjSealById")/*修改保存*/
	@ResponseBody
	public Map<String,Object> updatePrjSealById(@RequestParam(value="file",required=false) MultipartFile file[],SignetManage signetManage){
		Map<String,Object> map = new HashMap<>();
		List<Accessory> list=new ArrayList<>();
		String id = signetManage.getSmId();
		String path = "D:/oa/prjSeal/" + id;
		
		for (int i=0;i<file.length;i++) {
			String filename = file[i].getOriginalFilename();
			File f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			String path1 = path + File.separator + filename;
			File f1 = new File(path1);
			try {
				file[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(path1);
				list.add(accessory);
				signetManage.setAccessory(list);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				map.put("result", 0);
			}

		}
		int i = prjSealService.updatePrjSealById(signetManage);
		if(i>0){
			map.put("result", i);
			map.put("signetManage", signetManage);
		}
		return map;
	}
	
	@RequestMapping("/updatePrjSealByIdSubmit")/*修改提交*/
	@ResponseBody
	public Map<String,Object> updatePrjSealByIdSubmit(@RequestParam(value="file",required=false) MultipartFile file[],SignetManage signetManage){
		Map<String,Object> map = new HashMap<>();
		List<Accessory> list=new ArrayList<>();
		String id = signetManage.getSmId();
		String path = "D:/oa/prjSeal/" + id;
		
		for (int i=0;i<file.length;i++) {
			String filename = file[i].getOriginalFilename();
			File f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			String path1 = path + File.separator + filename;
			File f1 = new File(path1);
			try {
				file[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(path1);
				list.add(accessory);
				signetManage.setAccessory(list);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				map.put("result", 0);
			}

		}
		int i = prjSealService.updatePrjSealById(signetManage);
		if(i>0){
			map.put("result", i);
			map.put("signetManage", signetManage);
		}
		return map;
	}
	
	@RequestMapping("/selectPrjSealById")
	@ResponseBody
	public SignetManage selectPrjSealById(String smId,String status){
		return prjSealService.selectPrjSealById(smId,status);
	}

	@RequestMapping("/selectAccessoryById")
	@ResponseBody
	public List<Accessory> selectAccessoryById(String id){
		List<Accessory> list=prjSealService.selectAccessoryById(id);
		return list;
	}
}

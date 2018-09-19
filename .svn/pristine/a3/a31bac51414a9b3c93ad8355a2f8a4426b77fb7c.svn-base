package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.SignetManage;
import org.ldxx.bean.SignetUsers;
import org.ldxx.service.SignetUsersService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 项目印章使用管理
 * @author hp
 *
 */
@Controller
@RequestMapping("signetUsers")
public class SignetUsersController {

	@Autowired
	private SignetUsersService suserService;
	
	
	@RequestMapping("/selectsUser")
	@ResponseBody
	public List<SignetUsers> selectUser(String status){
		List<SignetUsers> list= suserService.selectUser(status);
		return list;
	}
	
	@RequestMapping("/addsUser")/*保存*/
	@ResponseBody
	public Map<String,Object> addsUser(@RequestParam(value="file2",required = false)MultipartFile file2,SignetUsers sUser){
		Map<String,Object> map = new HashMap<>();
		List<Accessory> list=new ArrayList<>();
		String id = new TimeUUID().getTimeUUID();
		sUser.setSuId(id);
		String path = "D:/oa/signetUsers/" + id;
		
		if (file2 != null) {
			String filename = file2.getOriginalFilename();
			File f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			String path1 = path + File.separator + filename;
			File f1 = new File(path1);
			try {
				file2.transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(path1);
				list.add(accessory);
				sUser.setAccessory(list);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				map.put("result", 0);
			}

		}
		int i=suserService.addsUser(sUser);
		map.put("result", i);
		map.put("sUser", sUser);
		return map;
	}
	
	@RequestMapping("/submitsUser")/*提交*/
	@ResponseBody
	public Map<String,Object> submitsUser(@RequestParam(value="file2",required = false)MultipartFile file2,SignetUsers sUser){
		Map<String,Object> map = new HashMap<>();
		List<Accessory> list=new ArrayList<>();
		String id = new TimeUUID().getTimeUUID();
		sUser.setSuId(id);
		String path = "D:/oa/prjSeal/" + id;
		
		if (file2 != null) {
			String filename = file2.getOriginalFilename();
			File f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			String path1 = path + File.separator + filename;
			File f1 = new File(path1);
			try {
				file2.transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(path1);
				list.add(accessory);
				sUser.setAccessory(list);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				map.put("result", 0);
			}

		}
		int i=suserService.addsUser(sUser);
		map.put("result", i);
		map.put("sUser", sUser);
		return map;
	}
	
	@RequestMapping("/deletesUserById")
	@ResponseBody
	public int deletesUserById(String suId){
		return suserService.deletesUserById(suId);
	}
	
	@RequestMapping("/updatesUser")/*修改保存*/
	@ResponseBody
	public Map<String,Object> updatesUser(@RequestParam(value="file2",required = false)MultipartFile file2,SignetUsers sUser){
		Map<String,Object> map = new HashMap<>();
		List<Accessory> list=new ArrayList<>();
		String id = sUser.getSuId();
		String path = "D:/oa/prjSeal/" + id;
		
		if (file2 != null) {
			String filename = file2.getOriginalFilename();
			File f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			String path1 = path + File.separator + filename;
			File f1 = new File(path1);
			try {
				file2.transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(path1);
				list.add(accessory);
				sUser.setAccessory(list);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				map.put("result", 0);
			}

		}
		int i=suserService.updatesUser(sUser);
		map.put("result", i);
		map.put("sUser", sUser);
		return map;
	}
	
	@RequestMapping("/updateSubmitsUser")/*修改提交*/
	@ResponseBody
	public Map<String,Object> updateSubmitsUser(@RequestParam(value="file2",required = false)MultipartFile file2,SignetUsers sUser){
		Map<String,Object> map = new HashMap<>();
		List<Accessory> list=new ArrayList<>();
		String id = sUser.getSuId();
		String path = "D:/oa/prjSeal/" + id;
		
		if (file2 != null) {
			String filename = file2.getOriginalFilename();
			File f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			String path1 = path + File.separator + filename;
			File f1 = new File(path1);
			try {
				file2.transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(path1);
				list.add(accessory);
				sUser.setAccessory(list);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				map.put("result", 0);
			}

		}
		int i=suserService.updatesUser(sUser);
		map.put("result", i);
		map.put("sUser", sUser);
		return map;
	}
	
	@RequestMapping("/selectUsersById")
	@ResponseBody
	public SignetUsers selectUsersById(String suId,String status){
		return suserService.selectUsersById(suId,status);
	}
	
}

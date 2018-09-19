package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.Announcement;
import org.ldxx.service.AnnouncementService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("announcement")
public class AnnouncementController {

	@Autowired 
	private AnnouncementService service;
	
	@RequestMapping("/addAnnouncementByAllAndSave")/*公司公告新建保存*/
	@ResponseBody
	public int addAnnouncementByAllAndSave(Announcement announcement,@RequestParam("file")MultipartFile [] file){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		List<Accessory> list=new ArrayList<>();
		for(int i=0;i<file.length;i++){
			Accessory accessory=new Accessory();
			String acName=file[i].getOriginalFilename();
			String url="D:/oa/announcement/"+id;
			File f=new File(url);
			if(!f.exists()){
				f.mkdirs();
			}
			String acUrl=url+File.separator+acName;
			File acFile=new File(acUrl);
			accessory.setaId(id);
			accessory.setAcName(acName);
			accessory.setAcUrl(acUrl);
			list.add(accessory);
			try {
				file[i].transferTo(acFile);
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		announcement.setaId(id);
		announcement.setAccessory(list);
		int i=service.addAnnouncement(announcement);
		return i;
	}
	
	
	@RequestMapping("/addAnnouncementByThisAndSave")/*部门公告新建保存*/
	@ResponseBody
	public int addAnnouncementByThisAndSave(Announcement announcement,@RequestParam("file")MultipartFile [] file){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		List<Accessory> list=new ArrayList<>();
		for(int i=0;i<file.length;i++){
			Accessory accessory=new Accessory();
			String acName=file[i].getOriginalFilename();
			String url="D:/oa/announcement/"+id;
			File f=new File(url);
			if(!f.exists()){
				f.mkdirs();
			}
			String acUrl=url+File.separator+acName;
			File acFile=new File(acUrl);
			accessory.setaId(id);
			accessory.setAcName(acName);
			accessory.setAcUrl(acUrl);
			list.add(accessory);
			try {
				file[i].transferTo(acFile);
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		announcement.setaId(id);
		announcement.setAccessory(list);
		int i=service.addAnnouncement(announcement);
		return i;
	}
	
	
	@RequestMapping("/addAnnouncementByAllAndSubmit")/*公司公告新建提交*/
	@ResponseBody
	public int addAnnouncementByAllAndSubmit(Announcement announcement,@RequestParam("file")MultipartFile [] file){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		List<Accessory> list=new ArrayList<>();
		for(int i=0;i<file.length;i++){
			Accessory accessory=new Accessory();
			String acName=file[i].getOriginalFilename();
			String url="D:/oa/announcement/"+id;
			File f=new File(url);
			if(!f.exists()){
				f.mkdirs();
			}
			String acUrl=url+File.separator+acName;
			File acFile=new File(acUrl);
			accessory.setaId(id);
			accessory.setAcName(acName);
			accessory.setAcUrl(acUrl);
			list.add(accessory);
			try {
				file[i].transferTo(acFile);
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		announcement.setaId(id);
		announcement.setAccessory(list);
		int i=service.addAnnouncement(announcement);
		return i;
	}
	
	@RequestMapping("/addAnnouncementByThisAndSubmit")/*部门公告新建提交*/
	@ResponseBody
	public int addAnnouncementByThisAndSubmit(Announcement announcement,@RequestParam("file")MultipartFile [] file){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		List<Accessory> list=new ArrayList<>();
		for(int i=0;i<file.length;i++){
			Accessory accessory=new Accessory();
			String acName=file[i].getOriginalFilename();
			String url="D:/oa/announcement/"+id;
			File f=new File(url);
			if(!f.exists()){
				f.mkdirs();
			}
			String acUrl=url+File.separator+acName;
			File acFile=new File(acUrl);
			accessory.setaId(id);
			accessory.setAcName(acName);
			accessory.setAcUrl(acUrl);
			list.add(accessory);
			try {
				file[i].transferTo(acFile);
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		announcement.setaId(id);
		announcement.setAccessory(list);
		int i=service.addAnnouncement(announcement);
		return i;
	}
	
	
	@RequestMapping("/deleteAccessory")
	@ResponseBody
	public int deleteAccessory(Accessory accessory){
		int i=service.deleteAccessoryByIdAndName(accessory);
		if(i>0){
			File f=new File(accessory.getAcUrl());
			f.delete();
		}
		return i;
	}
	
	@RequestMapping("/updateAnnouncementByAllAndSave")/*公司通告修改保存*/
	@ResponseBody
	public int updateAnnouncementByAllAndSave(Announcement announcement,@RequestParam("file")MultipartFile [] file){
		int a=0;
		String id=announcement.getaId();
		List<Accessory> list2=new ArrayList<>();
		for(int iii=0;iii<file.length;iii++){
			Accessory accessory=new Accessory();
			String acName=file[iii].getOriginalFilename();
			String url="D:/oa/announcement/"+id;
			File f=new File(url);
			if(!f.exists()){
				f.mkdirs();
			}
			String acUrl=url+File.separator+acName;
			File acFile=new File(acUrl);
			accessory.setaId(id);
			accessory.setAcName(acName);
			accessory.setAcUrl(acUrl);
			list2.add(accessory);
			try {
				file[iii].transferTo(acFile);
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		announcement.setAccessory(list2);
		a=service.updateAnnouncement(announcement);
		
		return a;
	}
	
	
	@RequestMapping("/updateAnnouncementByThisAndSave")/*部门通告修改保存*/
	@ResponseBody
	public int updateAnnouncementByThisAndSave(Announcement announcement,@RequestParam("file")MultipartFile [] file){
		int a=0;
		String id=announcement.getaId();
		List<Accessory> list2=new ArrayList<>();
		for(int iii=0;iii<file.length;iii++){
			Accessory accessory=new Accessory();
			String acName=file[iii].getOriginalFilename();
			String url="D:/oa/announcement/"+id;
			File f=new File(url);
			if(!f.exists()){
				f.mkdirs();
			}
			String acUrl=url+File.separator+acName;
			File acFile=new File(acUrl);
			accessory.setaId(id);
			accessory.setAcName(acName);
			accessory.setAcUrl(acUrl);
			list2.add(accessory);
			try {
				file[iii].transferTo(acFile);
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		announcement.setAccessory(list2);
		a=service.updateAnnouncement(announcement);
		
		return a;
	}
	
	
	@RequestMapping("/updateAnnouncementByAllAndSubmit")/*公司通告修改提交*/
	@ResponseBody
	public int updateAnnouncementByAllAndSubmit(Announcement announcement,@RequestParam("file")MultipartFile [] file){
		int a=0;
		String id=announcement.getaId();
		List<Accessory> list2=new ArrayList<>();
		for(int iii=0;iii<file.length;iii++){
			Accessory accessory=new Accessory();
			String acName=file[iii].getOriginalFilename();
			String url="D:/oa/announcement/"+id;
			File f=new File(url);
			if(!f.exists()){
				f.mkdirs();
			}
			String acUrl=url+File.separator+acName;
			File acFile=new File(acUrl);
			accessory.setaId(id);
			accessory.setAcName(acName);
			accessory.setAcUrl(acUrl);
			list2.add(accessory);
			try {
				file[iii].transferTo(acFile);
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		announcement.setAccessory(list2);
		a=service.updateAnnouncement(announcement);
		
		return a;
	}
	
	
	@RequestMapping("/updateAnnouncementByThisAndSubmit")/*部门通告修改提交*/
	@ResponseBody
	public int updateAnnouncementByThisAndSubmit(Announcement announcement,@RequestParam("file")MultipartFile [] file){
		int a=0;
		String id=announcement.getaId();
		List<Accessory> list2=new ArrayList<>();
		for(int iii=0;iii<file.length;iii++){
			Accessory accessory=new Accessory();
			String acName=file[iii].getOriginalFilename();
			String url="D:/oa/announcement/"+id;
			File f=new File(url);
			if(!f.exists()){
				f.mkdirs();
			}
			String acUrl=url+File.separator+acName;
			File acFile=new File(acUrl);
			accessory.setaId(id);
			accessory.setAcName(acName);
			accessory.setAcUrl(acUrl);
			list2.add(accessory);
			try {
				file[iii].transferTo(acFile);
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		announcement.setAccessory(list2);
		a=service.updateAnnouncement(announcement);
		
		return a;
	}
	
	
	@RequestMapping("/deleteAnnouncement")
	@ResponseBody
	public int deleteAnnouncement(String id){
		return service.deleteAnnouncement(id);
	}
	
	
	@RequestMapping("/selectAnnouncement")
	@ResponseBody
	public List<Announcement> selectAnnouncement(String type,String status){
		List<Announcement> list=service.selectAnnouncement(type,status);
		return list;
	}
	
	@RequestMapping("/selectAccessoryById")
	@ResponseBody
	public List<Accessory> selectAccessoryById(String id){
		List<Accessory> list=service.selectAccessory(id);
		return list;
	}
	
	
}

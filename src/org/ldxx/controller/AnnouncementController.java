package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.Announcement;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FbContract;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.User;
import org.ldxx.dao.AnnouncementDao;
import org.ldxx.service.AnnouncementService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.util.FlowUtill;
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
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private AnnouncementDao aDao;
	@RequestMapping("/addAnnouncementByAllAndSave")/*公司公告新建保存*/
	@ResponseBody
	public int addAnnouncementByAllAndSave(Announcement announcement,@RequestParam("file")MultipartFile [] file,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String acName=file[i].getOriginalFilename();
				String url="D:"+File.separator+"apache-tomcat-8.5.37"+File.separator+"webapps/oa_file/announcement"+File.separator+id;
				File f=new File(url);
				if(!f.exists()){
					f.mkdirs();
				}
				String upUrl =url+File.separator+acName;
				String acUrl="announcement/"+id+"/"+acName;
				File acFile=new File(upUrl);
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
			announcement.setAccessory(list);
		}
		announcement.setaId(id);
		int i=service.addAnnouncement(announcement);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(announcement.getaDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(announcement.getaTitle());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());
			currentFlow.setMemo(announcement.getaTitle()+"公司公告保存");
			currentFlow.setUrl("xingzhengshiwuLook/NoticeBulletinLookGS.html-"+id);
			currentFlow.setParams("{'cs':'1'}");
			currentFlow.setStarter(user.getUserId());
			currentFlow.setStartername(user.getuName());
			currentFlow.setFkDept(omNo);
			currentFlow.setDeptname(user.getOmName());
			currentFlow.setNodename("节点名称");
			currentFlow.setPri(1);
			currentFlow.setSdtofnode(new Date());
			currentFlow.setSdtofflow(new Date());
			currentFlow.setFlowEndState(2);
			currentFlow.setFlowNopassState(0);
			FlowHistroy flowHistroy = new FlowHistroy();
			flowHistroy.setActor(user.getUserId());
			flowHistroy.setActorname(user.getuName());
			flowHistroy.setActorresult(0);
			flowHistroy.setView("");
			try {
				string = flowUtill.zancunFlow(currentFlow,flowHistroy);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return i;
	}
	
	
	@RequestMapping("/addAnnouncementByThisAndSave")/*部门公告新建保存*/
	@ResponseBody
	public int addAnnouncementByThisAndSave(Announcement announcement,@RequestParam("file")MultipartFile [] file,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		List<Accessory> list=new ArrayList<>();
		if(file.length>0){
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String acName=file[i].getOriginalFilename();
				String url="D:"+File.separator+"apache-tomcat-8.5.37"+File.separator+"webapps/oa_file/announcement"+File.separator+id;
				File f=new File(url);
				if(!f.exists()){
					f.mkdirs();
				}
				String upUrl =url+File.separator+acName;
				String acUrl="announcement/"+id+"/"+acName;
				File acFile=new File(upUrl);
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
			announcement.setAccessory(list);
		}
		announcement.setaId(id);
		int i=service.addAnnouncement(announcement);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(announcement.getaDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(announcement.getaTitle());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());
			currentFlow.setMemo(announcement.getaTitle()+"部门公告保存");
			currentFlow.setUrl("xingzhengshiwuLook/NoticeBulletinLookBM.html-"+id);
			currentFlow.setParams("{'cs':'1'}");
			currentFlow.setStarter(user.getUserId());
			currentFlow.setStartername(user.getuName());
			currentFlow.setFkDept(omNo);
			currentFlow.setDeptname(user.getOmName());
			currentFlow.setNodename("节点名称");
			currentFlow.setPri(1);
			currentFlow.setSdtofnode(new Date());
			currentFlow.setSdtofflow(new Date());
			currentFlow.setFlowEndState(2);
			currentFlow.setFlowNopassState(0);
			FlowHistroy flowHistroy = new FlowHistroy();
			flowHistroy.setActor(user.getUserId());
			flowHistroy.setActorname(user.getuName());
			flowHistroy.setActorresult(0);
			flowHistroy.setView("");
			try {
				string = flowUtill.zancunFlow(currentFlow,flowHistroy);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return i;
	}
	
	
	@RequestMapping("/addAnnouncementByAllAndSubmit")/*公司公告新建提交*/
	@ResponseBody
	public String addAnnouncementByAllAndSubmit(Announcement announcement,@RequestParam("file")MultipartFile [] file,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		List<Accessory> list=new ArrayList<>();
		if(file.length>0){
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String acName=file[i].getOriginalFilename();
				String url="D:"+File.separator+"apache-tomcat-8.5.37"+File.separator+"webapps/oa_file/announcement"+File.separator+id;
				File f=new File(url);
				if(!f.exists()){
					f.mkdirs();
				}
				String upUrl =url+File.separator+acName;
				String acUrl="announcement/"+id+"/"+acName;
				File acFile=new File(upUrl);
				accessory.setaId(id);
				accessory.setAcName(acName);
				accessory.setAcUrl(acUrl);
				list.add(accessory);
				try {
					file[i].transferTo(acFile);
				} catch (Exception e) {
					e.printStackTrace();
					return "0";
				}
			}
			announcement.setAccessory(list);
		}
		announcement.setaId(id);
		int i=service.addAnnouncement(announcement);
		String string=i+"";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(announcement.getaDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(announcement.getaTitle());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());
			currentFlow.setMemo(announcement.getaTitle()+"公司公告提交");
			currentFlow.setUrl("xingzhengshiwuLook/NoticeBulletinLookGS.html-"+id);
			currentFlow.setParams("{'cs':'1'}");
			currentFlow.setStarter(user.getUserId());
			currentFlow.setStartername(user.getuName());
			currentFlow.setFkDept(omNo);
			currentFlow.setDeptname(user.getOmName());
			currentFlow.setNodename("节点名称");
			currentFlow.setPri(1);
			currentFlow.setSdtofnode(new Date());
			currentFlow.setSdtofflow(new Date());
			currentFlow.setFlowEndState(2);
			currentFlow.setFlowNopassState(0);
			FlowHistroy flowHistroy = new FlowHistroy();
			flowHistroy.setActor(user.getUserId());
			flowHistroy.setActorname(user.getuName());
			flowHistroy.setActorresult(0);
			flowHistroy.setView("");
			try {
				string = flowUtill.submitGetReceiver(currentFlow,omNo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return string;
	}
	
	@RequestMapping("/addAnnouncementByThisAndSubmit")/*部门公告新建提交*/
	@ResponseBody
	public String addAnnouncementByThisAndSubmit(Announcement announcement,@RequestParam("file")MultipartFile [] file,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		List<Accessory> list=new ArrayList<>();
		if(file.length>0){
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String acName=file[i].getOriginalFilename();
				String url="D:"+File.separator+"apache-tomcat-8.5.37"+File.separator+"webapps/oa_file/announcement"+File.separator+id;
				File f=new File(url);
				if(!f.exists()){
					f.mkdirs();
				}
				String upUrl =url+File.separator+acName;
				String acUrl="announcement/"+id+"/"+acName;
				File acFile=new File(upUrl);
				accessory.setaId(id);
				accessory.setAcName(acName);
				accessory.setAcUrl(acUrl);
				list.add(accessory);
				try {
					file[i].transferTo(acFile);
				} catch (Exception e) {
					e.printStackTrace();
					return "0";
				}
			}
			announcement.setAccessory(list);
		}
		announcement.setaId(id);
		int i=service.addAnnouncement(announcement);
		String string=i+"";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(announcement.getaDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(announcement.getaTitle());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());
			currentFlow.setMemo(announcement.getaTitle()+"部门公告提交");
			currentFlow.setUrl("xingzhengshiwuLook/NoticeBulletinLookBM.html-"+id);
			currentFlow.setParams("{'cs':'1'}");
			currentFlow.setStarter(user.getUserId());
			currentFlow.setStartername(user.getuName());
			currentFlow.setFkDept(omNo);
			currentFlow.setDeptname(user.getOmName());
			currentFlow.setNodename("节点名称");
			currentFlow.setPri(1);
			currentFlow.setSdtofnode(new Date());
			currentFlow.setSdtofflow(new Date());
			currentFlow.setFlowEndState(2);
			currentFlow.setFlowNopassState(0);
			FlowHistroy flowHistroy = new FlowHistroy();
			flowHistroy.setActor(user.getUserId());
			flowHistroy.setActorname(user.getuName());
			flowHistroy.setActorresult(0);
			flowHistroy.setView("");
			try {
				string = flowUtill.submitGetReceiver(currentFlow,omNo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return string;
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
		if(file.length>0){
			for(int iii=0;iii<file.length;iii++){
				Accessory accessory=new Accessory();
				String acName=file[iii].getOriginalFilename();
				String url="D:"+File.separator+"apache-tomcat-8.5.37"+File.separator+"webapps/oa_file/announcement"+File.separator+id;
				File f=new File(url);
				if(!f.exists()){
					f.mkdirs();
				}
				String upUrl =url+File.separator+acName;
				String acUrl="announcement/"+id+"/"+acName;
				File acFile=new File(upUrl);
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
		}
		a=service.updateAnnouncement(announcement);
		return a;
	}
	
	
	@RequestMapping("/updateAnnouncementByThisAndSave")/*部门通告修改保存*/
	@ResponseBody
	public int updateAnnouncementByThisAndSave(Announcement announcement,@RequestParam("file")MultipartFile [] file){
		int a=0;
		String id=announcement.getaId();
		List<Accessory> list2=new ArrayList<>();
		if(file.length>0){
			for(int iii=0;iii<file.length;iii++){
				Accessory accessory=new Accessory();
				String acName=file[iii].getOriginalFilename();
				String url="D:"+File.separator+"apache-tomcat-8.5.37"+File.separator+"webapps/oa_file/announcement"+File.separator+id;
				File f=new File(url);
				if(!f.exists()){
					f.mkdirs();
				}
				String upUrl =url+File.separator+acName;
				String acUrl="announcement/"+id+"/"+acName;
				File acFile=new File(upUrl);
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
		}
		a=service.updateAnnouncement(announcement);
		return a;
	}
	
	
	@RequestMapping("/updateAnnouncementByAllAndSubmit")/*公司通告修改提交*/
	@ResponseBody
	public int updateAnnouncementByAllAndSubmit(Announcement announcement,@RequestParam("file")MultipartFile [] file){
		int a=0;
		String id=announcement.getaId();
		List<Accessory> list2=new ArrayList<>();
		if(file.length>0){
			for(int iii=0;iii<file.length;iii++){
				Accessory accessory=new Accessory();
				String acName=file[iii].getOriginalFilename();
				String url="D:"+File.separator+"apache-tomcat-8.5.37"+File.separator+"webapps/oa_file/announcement"+File.separator+id;
				File f=new File(url);
				if(!f.exists()){
					f.mkdirs();
				}
				String upUrl =url+File.separator+acName;
				String acUrl="announcement/"+id+"/"+acName;
				File acFile=new File(upUrl);
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
		}
		a=service.updateAnnouncement(announcement);
		return a;
	}
	
	
	@RequestMapping("/updateAnnouncementByThisAndSubmit")/*部门通告修改提交*/
	@ResponseBody
	public int updateAnnouncementByThisAndSubmit(Announcement announcement,@RequestParam("file")MultipartFile [] file){
		int a=0;
		String id=announcement.getaId();
		List<Accessory> list2=new ArrayList<>();
		if(file.length>0){
			for(int iii=0;iii<file.length;iii++){
				Accessory accessory=new Accessory();
				String acName=file[iii].getOriginalFilename();
				String url="D:"+File.separator+"apache-tomcat-8.5.37"+File.separator+"webapps/oa_file/announcement"+File.separator+id;
				File f=new File(url);
				if(!f.exists()){
					f.mkdirs();
				}
				String upUrl =url+File.separator+acName;
				String acUrl="announcement/"+id+"/"+acName;
				File acFile=new File(upUrl);
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
		}
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
	
	@RequestMapping("/selectAnnouncement2")
	@ResponseBody
	public List<Announcement> selectAnnouncement2(String type,String status,HttpSession session){
		String department="%";
		User u=(User) session.getAttribute("user");
		String omId=u.getOmId();
		if(!omId.equals("8187e2b1d153")){
			department="%"+omId+"%";
		}
		List<Announcement> list=service.selectAnnouncement2(type,status,department);
		return list;
	}
	
	@RequestMapping("/selectAccessoryById")
	@ResponseBody
	public List<Accessory> selectAccessoryById(String id){
		List<Accessory> list=service.selectAccessory(id);
		return list;
	}
	
	@RequestMapping("/selectAnnouncementById")//通过id查询信息
	@ResponseBody
	public Announcement selectAnnouncementById(String id){
		Announcement announcement=service.selectAnnouncementById(id);
		return announcement;
	}
	@RequestMapping("/selectHuankuanFbByTaskNo")//通过id查询信息
	@ResponseBody
	public List<FbContract> selectHuankuanFbByTaskNo(String taskNo){
		List<FbContract> fbContracts=aDao.selectHuankuanFbByTaskNo(taskNo);
		return fbContracts;
	}
}

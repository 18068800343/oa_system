package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ConstructionDocuments;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.TestingEvaluation;
import org.ldxx.bean.User;
import org.ldxx.dao.TestingEvaluationDao;
import org.ldxx.service.AccessoryService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.TestingEvaluationService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import net.sf.json.JSONObject;

/**
 * 检测评估类
 * @author hp
 *
 */
@RequestMapping("TestingEvaluation")
@Controller
public class TestingEvaluationController {
	
	@Autowired
	private TestingEvaluationService service;
	@Autowired
	private AccessoryService aService;
	@Autowired
	private TestingEvaluationDao dao;
	@Autowired
	private OrganizationManagementService oService;
	
	@RequestMapping("/selectTestingEvaluation")
	@ResponseBody
	public List<TestingEvaluation> selectTestingEvaluation(){
		List<TestingEvaluation> list=service.selectTestingEvaluation();
		for(int i=0;i<list.size();i++){
			int length=aService.fileCount(list.get(i).getTeId());
			list.get(i).setFileLengthJC(length);
		}
		return list;
	}
	
	/*@RequestMapping("/addTestingEvaluationSave")//添加保存
	@ResponseBody
	public Map<String,Object> addTestingEvaluationSave(String tes,@RequestParam MultipartFile [] file1,@RequestParam MultipartFile [] file2,@RequestParam MultipartFile [] file3,
			@RequestParam MultipartFile [] file4,@RequestParam MultipartFile [] file5,@RequestParam MultipartFile [] file6,@RequestParam MultipartFile [] file7,@RequestParam MultipartFile [] file8
			,@RequestParam MultipartFile [] file9,@RequestParam MultipartFile [] file10,@RequestParam MultipartFile [] file11,@RequestParam MultipartFile [] file12,@RequestParam MultipartFile [] file13) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		Map<String,Class> map2=new HashMap<>();
		map2.put("accessory1", Accessory.class);
		map2.put("accessory2", Accessory.class);
		map2.put("accessory3", Accessory.class);
		map2.put("accessory4", Accessory.class);
		map2.put("accessory5", Accessory.class);
		map2.put("accessory6", Accessory.class);
		map2.put("accessory7", Accessory.class);
		map2.put("accessory8", Accessory.class);
		map2.put("accessory9", Accessory.class);
		map2.put("accessory10", Accessory.class);
		JSONObject jsonObject=JSONObject.fromObject(tes);
		TestingEvaluation te=(TestingEvaluation)JSONObject.toBean(jsonObject, TestingEvaluation.class,map2);
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		te.setTeId(id);
		String path="D:"+File.separator+"oa"+File.separator+"TestingEvaluation"+File.separator+id;
		
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file1.length>0){
			List<Accessory> acc = te.getAccessory1();
			for(int i=0;i<file1.length;i++){
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file1[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("项目实际存档目录");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			te.setAccessory1(acc);
		}
		if(file2.length>0){
			List<Accessory> acc = te.getAccessory2();
			for(int i=0;i<file2.length;i++){
				String fileName=file2[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[i].transferTo(f2);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("项目特点介绍、关键词");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			te.setAccessory2(acc);
		}
		if(file3.length>0){
			List<Accessory> acc = te.getAccessory3();
			for(int i=0;i<file3.length;i++){
				String fileName=file3[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f3=new File(filePath);
				file3[i].transferTo(f3);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("招投标文件");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			te.setAccessory3(acc);
		}
		if(file4.length>0){
			List<Accessory> acc = te.getAccessory4();
			for(int i=0;i<file4.length;i++){
				String fileName=file4[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f4=new File(filePath);
				file4[i].transferTo(f4);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("合同资料");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			te.setAccessory4(acc);
		}
		if(file5.length>0){
			List<Accessory> acc = te.getAccessory5();
			for(int i=0;i<file5.length;i++){
				String fileName=file5[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f5=new File(filePath);
				file5[i].transferTo(f5);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("出版报告");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			te.setAccessory5(acc);
		}
		if(file6.length>0){
			List<Accessory> acc = te.getAccessory6();
			for(int i=0;i<file6.length;i++){
				String fileName=file6[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f6=new File(filePath);
				file6[i].transferTo(f6);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("计算模型、计算书");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			te.setAccessory6(acc);
		}
		if(file7.length>0){
			List<Accessory> acc = te.getAccessory7();
			for(int i=0;i<file7.length;i++){
				String fileName=file7[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f7=new File(filePath);
				file7[i].transferTo(f7);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("外部评审意见");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			te.setAccessory7(acc);
		}
		if(file8.length>0){
			List<Accessory> acc = te.getAccessory8();
			for(int i=0;i<file8.length;i++){
				String fileName=file8[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f8=new File(filePath);
				file8[i].transferTo(f8);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("校审资料");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			te.setAccessory8(acc);
		}
		if(file9.length>0){
			List<Accessory> acc = te.getAccessory9();
			for(int i=0;i<file9.length;i++){
				String fileName=file9[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f9=new File(filePath);
				file9[i].transferTo(f9);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("技术方案");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			te.setAccessory9(acc);
		}
		if(file10.length>0){
			List<Accessory> acc = te.getAccessory10();
			for(int i=0;i<file10.length;i++){
				String fileName=file10[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f10=new File(filePath);
				file10[i].transferTo(f10);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("重点项目的项目总结");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			te.setAccessory10(acc);
		}
		
		int i=service.addTestingEvaluationSave(te);
		map.put("result", i);
		map.put("TestingEvaluation", te);
		return map; 
	}*/

	
	@RequestMapping("/updateTestingEvaluationSave")//修改保存
	@ResponseBody
	public String updateTestingEvaluationSave(String tes,@RequestParam MultipartFile [] file1,@RequestParam MultipartFile [] file2,@RequestParam MultipartFile [] file3,
			@RequestParam MultipartFile [] file4,@RequestParam MultipartFile [] file5,@RequestParam MultipartFile [] file6,@RequestParam MultipartFile [] file7,@RequestParam MultipartFile [] file8
			,@RequestParam MultipartFile [] file9,@RequestParam MultipartFile [] file10,HttpSession session,HttpServletResponse response) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		Map<String,Class> map2=new HashMap<>();
		map2.put("accessory1", Accessory.class);
		map2.put("accessory2", Accessory.class);
		map2.put("accessory3", Accessory.class);
		map2.put("accessory4", Accessory.class);
		map2.put("accessory5", Accessory.class);
		map2.put("accessory6", Accessory.class);
		map2.put("accessory7", Accessory.class);
		map2.put("accessory8", Accessory.class);
		map2.put("accessory9", Accessory.class);
		map2.put("accessory10", Accessory.class);
		JSONObject jsonObject=JSONObject.fromObject(tes);
		TestingEvaluation te=(TestingEvaluation)JSONObject.toBean(jsonObject, TestingEvaluation.class,map2);
		
		TimeUUID uuid=new TimeUUID();
		String id=te.getTeId();
		if(id==null||id==""){
			id=uuid.getTimeUUID();
			te.setTeId(id);
			int i=dao.addTestingEvaluationSave(te);
		}
		//String path="D:"+File.separator+"oa"+File.separator+"TestingEvaluation"+File.separator+id;;
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file1.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file1.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file1[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("JC项目实际存档目录");
				list.add(accessory);
			}
			te.setAccessory1(list);
		}
		if(file2.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file2.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file2[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file2[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("JC项目特点介绍、关键词");
				list.add(accessory);
			}
			te.setAccessory2(list);
		}
		if(file3.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file3.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file3[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file3[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("JC合同资料(合同原件提交经营部综合部)");
				list.add(accessory);
			}
			te.setAccessory3(list);
		}
		if(file4.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file4.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file4[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file4[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("JC出版报告");
				list.add(accessory);
			}
			te.setAccessory4(list);
		}
		if(file5.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file5.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file5[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file5[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("JC计算模型、计算书");
				list.add(accessory);
			}
			te.setAccessory5(list);
		}
		if(file6.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file6.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file6[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file6[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("JC外部审查意见");
				list.add(accessory);
			}
			te.setAccessory6(list);
		}
		if(file7.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file7.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file7[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file7[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("JC校审资料");
				list.add(accessory);
			}
			te.setAccessory7(list);
		}
		if(file8.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file8.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file8[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file8[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("JC技术方案");
				list.add(accessory);
			}
			te.setAccessory8(list);
		}
		if(file9.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file9.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file9[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file9[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("JC重点项目的项目总结");
				list.add(accessory);
			}
			te.setAccessory9(list);
		}
		if(file10.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file10.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file10[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file10[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("JC依据历史设计图纸");
				list.add(accessory);
			}
			te.setAccessory10(list);
		}
		
		int i=service.updateTestingEvaluationSave(te);
		String string = i+"";
		if(i>0){
			User user = (User) session.getAttribute("user");
			OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String omNo=om.getOmNo();
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(te.getPrjName()+"检测评估资料归档申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(te.getPrjName()+"检测评估归档申请流程发起");
			currentFlow.setUrl("danganGUanli/DetectionEvaluationLook.html-"+id);
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
		response.setCharacterEncoding("UTF-8");
		return string;
		/*map.put("result", i);
		map.put("TestingEvaluation", te);
		return map;*/ 
	}
	
	@RequestMapping("/selectTestingEvaluationByno")
	@ResponseBody
	public TestingEvaluation selectTestingEvaluationByno(String no){
		return service.selectTestingEvaluationById(no);
	}
	
	@RequestMapping("/deleteTestingEvaluationById")
	@ResponseBody
	public int deleteTestingEvaluationById(String id){
		return service.deleteTestingEvaluationById(id);
	}
	
	@RequestMapping("/selectAccessoryById")
	@ResponseBody
	public List<Accessory> selectAccessoryById(String id){
		List<Accessory> list=service.selectAccessoryById(id);
		return list;
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
	
}

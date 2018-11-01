package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ConstructionDocuments;
import org.ldxx.bean.ManagingDocuments;
import org.ldxx.bean.ManagingDocumentsTenderer;
import org.ldxx.service.ConstructionDocumentsService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONObject;

/**
 * 施工文档资料
 * @author hp
 *
 */

@RequestMapping("ConstructionDocuments")
@Controller
public class ConstructionDocumentsController {
	
	@Autowired
	private ConstructionDocumentsService service;
	
	@RequestMapping("/selectConstructionDocuments")
	@ResponseBody
	public List<ConstructionDocuments> selectConstructionDocuments(){
		return service.selectConstructionDocuments();
	}
	
	
	@RequestMapping("/addManagingDocumentsSave")//添加保存
	@ResponseBody
	public Map<String,Object> addPaySave(ConstructionDocuments cd,@RequestParam MultipartFile [] file1,@RequestParam MultipartFile [] file2,@RequestParam MultipartFile [] file3,
			@RequestParam MultipartFile [] file4,@RequestParam MultipartFile [] file5,@RequestParam MultipartFile [] file6,@RequestParam MultipartFile [] file7,@RequestParam MultipartFile [] file8
			,@RequestParam MultipartFile [] file9,@RequestParam MultipartFile [] file10,@RequestParam MultipartFile [] file11,@RequestParam MultipartFile [] file12,@RequestParam MultipartFile [] file13
			,@RequestParam MultipartFile [] file14,@RequestParam MultipartFile [] file15) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cd.setCdId(id);
		String path="D:"+File.separator+"oa"+File.separator+"ConstructionDocuments";
		
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file1.length>0){
			List<Accessory> list1=new ArrayList<>();
			for(int i=0;i<file1.length;i++){
				Accessory accessory1=new Accessory();
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file1[i].transferTo(f1);
				accessory1.setaId(id);
				accessory1.setAcName(fileName);
				accessory1.setAcUrl(filePath);
				accessory1.setaType("项目实际存档目录");
				list1.add(accessory1);
			}
			cd.setAccessory1(list1);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int i=0;i<file2.length;i++){
				Accessory accessory2=new Accessory();
				String fileName=file2[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[i].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(filePath);
				accessory2.setaType("项目特点介绍、关键词");
				list2.add(accessory2);
			}
			cd.setAccessory2(list2);
		}
		if(file3.length>0){
			List<Accessory> list3=new ArrayList<>();
			for(int i=0;i<file3.length;i++){
				Accessory accessory3=new Accessory();
				String fileName=file3[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f3=new File(filePath);
				file3[i].transferTo(f3);
				accessory3.setaId(id);
				accessory3.setAcName(fileName);
				accessory3.setAcUrl(filePath);
				accessory3.setaType("招投标文件");
				list3.add(accessory3);
			}
			cd.setAccessory3(list3);
		}
		if(file4.length>0){
			List<Accessory> list4=new ArrayList<>();
			for(int i=0;i<file4.length;i++){
				Accessory accessory4=new Accessory();
				String fileName=file4[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f4=new File(filePath);
				file4[i].transferTo(f4);
				accessory4.setaId(id);
				accessory4.setAcName(fileName);
				accessory4.setAcUrl(filePath);
				accessory4.setaType("项目主合同");
				list4.add(accessory4);
			}
			cd.setAccessory4(list4);
		}
		if(file5.length>0){
			List<Accessory> list5=new ArrayList<>();
			for(int i=0;i<file5.length;i++){
				Accessory accessory5=new Accessory();
				String fileName=file5[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f5=new File(filePath);
				file5[i].transferTo(f5);
				accessory5.setaId(id);
				accessory5.setAcName(fileName);
				accessory5.setAcUrl(filePath);
				accessory5.setaType("开工报告");
				list5.add(accessory5);
			}
			cd.setAccessory5(list5);
		}
		if(file6.length>0){
			List<Accessory> list6=new ArrayList<>();
			for(int i=0;i<file6.length;i++){
				Accessory accessory6=new Accessory();
				String fileName=file6[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f6=new File(filePath);
				file6[i].transferTo(f6);
				accessory6.setaId(id);
				accessory6.setAcName(fileName);
				accessory6.setAcUrl(filePath);
				accessory6.setaType("项目总结");
				list6.add(accessory6);
			}
			cd.setAccessory6(list6);
		}
		if(file7.length>0){
			List<Accessory> list7=new ArrayList<>();
			for(int i=0;i<file7.length;i++){
				Accessory accessory7=new Accessory();
				String fileName=file7[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f7=new File(filePath);
				file7[i].transferTo(f7);
				accessory7.setaId(id);
				accessory7.setAcName(fileName);
				accessory7.setAcUrl(filePath);
				accessory7.setaType("计量资料");
				list7.add(accessory7);
			}
			cd.setAccessory7(list7);
		}
		if(file8.length>0){
			List<Accessory> list8=new ArrayList<>();
			for(int i=0;i<file8.length;i++){
				Accessory accessory8=new Accessory();
				String fileName=file8[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f8=new File(filePath);
				file8[i].transferTo(f8);
				accessory8.setaId(id);
				accessory8.setAcName(fileName);
				accessory8.setAcUrl(filePath);
				accessory8.setaType("设计变更资料");
				list8.add(accessory8);
			}
			cd.setAccessory8(list8);
		}
		if(file9.length>0){
			List<Accessory> list9=new ArrayList<>();
			for(int i=0;i<file9.length;i++){
				Accessory accessory9=new Accessory();
				String fileName=file9[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f9=new File(filePath);
				file9[i].transferTo(f9);
				accessory9.setaId(id);
				accessory9.setAcName(fileName);
				accessory9.setAcUrl(filePath);
				accessory9.setaType("施工图和竣工图");
				list9.add(accessory9);
			}
			cd.setAccessory9(list9);
		}
		if(file10.length>0){
			List<Accessory> list10=new ArrayList<>();
			for(int i=0;i<file10.length;i++){
				Accessory accessory10=new Accessory();
				String fileName=file10[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f10=new File(filePath);
				file10[i].transferTo(f10);
				accessory10.setaId(id);
				accessory10.setAcName(fileName);
				accessory10.setAcUrl(filePath);
				accessory10.setaType("开工、过程以及交竣工全部外部审查意见");
				list10.add(accessory10);
			}
			cd.setAccessory10(list10);
		}
		if(file11.length>0){
			List<Accessory> list11=new ArrayList<>();
			for(int i=0;i<file11.length;i++){
				Accessory accessory11=new Accessory();
				String fileName=file11[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f11=new File(filePath);
				file11[i].transferTo(f11);
				accessory11.setaId(id);
				accessory11.setAcName(fileName);
				accessory11.setAcUrl(filePath);
				accessory11.setaType("首件工程总结");
				list11.add(accessory11);
			}
			cd.setAccessory11(list11);
		}
		if(file12.length>0){
			List<Accessory> list12=new ArrayList<>();
			for(int i=0;i<file12.length;i++){
				Accessory accessory12=new Accessory();
				String fileName=file12[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f12=new File(filePath);
				file12[i].transferTo(f12);
				accessory12.setaId(id);
				accessory12.setAcName(fileName);
				accessory12.setAcUrl(filePath);
				accessory12.setaType("材料检测资料");
				list12.add(accessory12);
			}
			cd.setAccessory12(list12);
		}
		if(file13.length>0){
			List<Accessory> list13=new ArrayList<>();
			for(int i=0;i<file13.length;i++){
				Accessory accessory13=new Accessory();
				String fileName=file13[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f13=new File(filePath);
				file13[i].transferTo(f13);
				accessory13.setaId(id);
				accessory13.setAcName(fileName);
				accessory13.setAcUrl(filePath);
				accessory13.setaType("中间报验资料和检验评定资料");
				list13.add(accessory13);
			}
			cd.setAccessory13(list13);
		}
		if(file14.length>0){
			List<Accessory> list14=new ArrayList<>();
			for(int i=0;i<file14.length;i++){
				Accessory accessory14=new Accessory();
				String fileName=file14[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f14=new File(filePath);
				file14[i].transferTo(f14);
				accessory14.setaId(id);
				accessory14.setAcName(fileName);
				accessory14.setAcUrl(filePath);
				accessory14.setaType("施工日志");
				list14.add(accessory14);
			}
			cd.setAccessory14(list14);
		}
		if(file15.length>0){
			List<Accessory> list15=new ArrayList<>();
			for(int i=0;i<file15.length;i++){
				Accessory accessory15=new Accessory();
				String fileName=file15[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f15=new File(filePath);
				file15[i].transferTo(f15);
				accessory15.setaId(id);
				accessory15.setAcName(fileName);
				accessory15.setAcUrl(filePath);
				accessory15.setaType("其它");
				list15.add(accessory15);
			}
			cd.setAccessory15(list15);
		}
		
		int i=service.addManagingDocumentsSave(cd);
		map.put("result", i);
		map.put("ConstructionDocuments", cd);
		return map; 
	}
	
	
	
	@RequestMapping("/deleteConstructionDocumentsById")
	@ResponseBody
	public int deleteConstructionDocumentsById(String id){
		return service.deleteConstructionDocumentsById(id);
	}
	
	
	@RequestMapping("/updateManagingDocumentsSave")//修改保存
	@ResponseBody
	public Map<String,Object> updateManagingDocumentsSave(ConstructionDocuments cd,@RequestParam MultipartFile [] file1,@RequestParam MultipartFile [] file2,@RequestParam MultipartFile [] file3,
			@RequestParam MultipartFile [] file4,@RequestParam MultipartFile [] file5,@RequestParam MultipartFile [] file6,@RequestParam MultipartFile [] file7,@RequestParam MultipartFile [] file8
			,@RequestParam MultipartFile [] file9,@RequestParam MultipartFile [] file10,@RequestParam MultipartFile [] file11,@RequestParam MultipartFile [] file12,@RequestParam MultipartFile [] file13
			,@RequestParam MultipartFile [] file14,@RequestParam MultipartFile [] file15) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		String id=cd.getCdId();
		String path="D:"+File.separator+"oa"+File.separator+"ConstructionDocuments";
		
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file1.length>0){
			List<Accessory> list1=new ArrayList<>();
			for(int i=0;i<file1.length;i++){
				Accessory accessory1=new Accessory();
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file1[i].transferTo(f1);
				accessory1.setaId(id);
				accessory1.setAcName(fileName);
				accessory1.setAcUrl(filePath);
				accessory1.setaType("项目实际存档目录");
				list1.add(accessory1);
			}
			cd.setAccessory1(list1);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int i=0;i<file2.length;i++){
				Accessory accessory2=new Accessory();
				String fileName=file2[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[i].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(filePath);
				accessory2.setaType("项目特点介绍、关键词");
				list2.add(accessory2);
			}
			cd.setAccessory2(list2);
		}
		if(file3.length>0){
			List<Accessory> list3=new ArrayList<>();
			for(int i=0;i<file3.length;i++){
				Accessory accessory3=new Accessory();
				String fileName=file3[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f3=new File(filePath);
				file3[i].transferTo(f3);
				accessory3.setaId(id);
				accessory3.setAcName(fileName);
				accessory3.setAcUrl(filePath);
				accessory3.setaType("招投标文件");
				list3.add(accessory3);
			}
			cd.setAccessory3(list3);
		}
		if(file4.length>0){
			List<Accessory> list4=new ArrayList<>();
			for(int i=0;i<file4.length;i++){
				Accessory accessory4=new Accessory();
				String fileName=file4[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f4=new File(filePath);
				file4[i].transferTo(f4);
				accessory4.setaId(id);
				accessory4.setAcName(fileName);
				accessory4.setAcUrl(filePath);
				accessory4.setaType("项目主合同");
				list4.add(accessory4);
			}
			cd.setAccessory4(list4);
		}
		if(file5.length>0){
			List<Accessory> list5=new ArrayList<>();
			for(int i=0;i<file5.length;i++){
				Accessory accessory5=new Accessory();
				String fileName=file5[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f5=new File(filePath);
				file5[i].transferTo(f5);
				accessory5.setaId(id);
				accessory5.setAcName(fileName);
				accessory5.setAcUrl(filePath);
				accessory5.setaType("开工报告");
				list5.add(accessory5);
			}
			cd.setAccessory5(list5);
		}
		if(file6.length>0){
			List<Accessory> list6=new ArrayList<>();
			for(int i=0;i<file6.length;i++){
				Accessory accessory6=new Accessory();
				String fileName=file6[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f6=new File(filePath);
				file6[i].transferTo(f6);
				accessory6.setaId(id);
				accessory6.setAcName(fileName);
				accessory6.setAcUrl(filePath);
				accessory6.setaType("项目总结");
				list6.add(accessory6);
			}
			cd.setAccessory6(list6);
		}
		if(file7.length>0){
			List<Accessory> list7=new ArrayList<>();
			for(int i=0;i<file7.length;i++){
				Accessory accessory7=new Accessory();
				String fileName=file7[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f7=new File(filePath);
				file7[i].transferTo(f7);
				accessory7.setaId(id);
				accessory7.setAcName(fileName);
				accessory7.setAcUrl(filePath);
				accessory7.setaType("计量资料");
				list7.add(accessory7);
			}
			cd.setAccessory7(list7);
		}
		if(file8.length>0){
			List<Accessory> list8=new ArrayList<>();
			for(int i=0;i<file8.length;i++){
				Accessory accessory8=new Accessory();
				String fileName=file8[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f8=new File(filePath);
				file8[i].transferTo(f8);
				accessory8.setaId(id);
				accessory8.setAcName(fileName);
				accessory8.setAcUrl(filePath);
				accessory8.setaType("设计变更资料");
				list8.add(accessory8);
			}
			cd.setAccessory8(list8);
		}
		if(file9.length>0){
			List<Accessory> list9=new ArrayList<>();
			for(int i=0;i<file9.length;i++){
				Accessory accessory9=new Accessory();
				String fileName=file9[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f9=new File(filePath);
				file9[i].transferTo(f9);
				accessory9.setaId(id);
				accessory9.setAcName(fileName);
				accessory9.setAcUrl(filePath);
				accessory9.setaType("施工图和竣工图");
				list9.add(accessory9);
			}
			cd.setAccessory9(list9);
		}
		if(file10.length>0){
			List<Accessory> list10=new ArrayList<>();
			for(int i=0;i<file10.length;i++){
				Accessory accessory10=new Accessory();
				String fileName=file10[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f10=new File(filePath);
				file10[i].transferTo(f10);
				accessory10.setaId(id);
				accessory10.setAcName(fileName);
				accessory10.setAcUrl(filePath);
				accessory10.setaType("开工、过程以及交竣工全部外部审查意见");
				list10.add(accessory10);
			}
			cd.setAccessory10(list10);
		}
		if(file11.length>0){
			List<Accessory> list11=new ArrayList<>();
			for(int i=0;i<file11.length;i++){
				Accessory accessory11=new Accessory();
				String fileName=file11[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f11=new File(filePath);
				file11[i].transferTo(f11);
				accessory11.setaId(id);
				accessory11.setAcName(fileName);
				accessory11.setAcUrl(filePath);
				accessory11.setaType("首件工程总结");
				list11.add(accessory11);
			}
			cd.setAccessory11(list11);
		}
		if(file12.length>0){
			List<Accessory> list12=new ArrayList<>();
			for(int i=0;i<file12.length;i++){
				Accessory accessory12=new Accessory();
				String fileName=file12[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f12=new File(filePath);
				file12[i].transferTo(f12);
				accessory12.setaId(id);
				accessory12.setAcName(fileName);
				accessory12.setAcUrl(filePath);
				accessory12.setaType("材料检测资料");
				list12.add(accessory12);
			}
			cd.setAccessory12(list12);
		}
		if(file13.length>0){
			List<Accessory> list13=new ArrayList<>();
			for(int i=0;i<file13.length;i++){
				Accessory accessory13=new Accessory();
				String fileName=file13[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f13=new File(filePath);
				file13[i].transferTo(f13);
				accessory13.setaId(id);
				accessory13.setAcName(fileName);
				accessory13.setAcUrl(filePath);
				accessory13.setaType("中间报验资料和检验评定资料");
				list13.add(accessory13);
			}
			cd.setAccessory13(list13);
		}
		if(file14.length>0){
			List<Accessory> list14=new ArrayList<>();
			for(int i=0;i<file14.length;i++){
				Accessory accessory14=new Accessory();
				String fileName=file14[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f14=new File(filePath);
				file14[i].transferTo(f14);
				accessory14.setaId(id);
				accessory14.setAcName(fileName);
				accessory14.setAcUrl(filePath);
				accessory14.setaType("施工日志");
				list14.add(accessory14);
			}
			cd.setAccessory14(list14);
		}
		if(file15.length>0){
			List<Accessory> list15=new ArrayList<>();
			for(int i=0;i<file15.length;i++){
				Accessory accessory15=new Accessory();
				String fileName=file15[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f15=new File(filePath);
				file15[i].transferTo(f15);
				accessory15.setaId(id);
				accessory15.setAcName(fileName);
				accessory15.setAcUrl(filePath);
				accessory15.setaType("其它");
				list15.add(accessory15);
			}
			cd.setAccessory15(list15);
		}
		
		int i=service.updateManagingDocumentsSave(cd);
		map.put("result", i);
		map.put("ConstructionDocuments", cd);
		return map; 
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

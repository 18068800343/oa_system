package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ConstructionDocuments;
import org.ldxx.bean.TestingEvaluation;
import org.ldxx.service.TestingEvaluationService;
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
	
	
	@RequestMapping("/selectTestingEvaluation")
	@ResponseBody
	public List<TestingEvaluation> selectTestingEvaluation(){
		return service.selectTestingEvaluation();
	}
	
	@RequestMapping("/addTestingEvaluationSave")//添加保存
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
		map2.put("accessory11", Accessory.class);
		map2.put("accessory12", Accessory.class);
		map2.put("accessory13", Accessory.class);
		JSONObject jsonObject=JSONObject.fromObject(tes);
		TestingEvaluation te=(TestingEvaluation)JSONObject.toBean(jsonObject, TestingEvaluation.class,map2);
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		te.setTeId(id);
		String path="D:"+File.separator+"oa"+File.separator+"TestingEvaluation";
		
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
		if(file11.length>0){
			List<Accessory> acc = te.getAccessory11();
			for(int i=0;i<file11.length;i++){
				String fileName=file11[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f11=new File(filePath);
				file11[i].transferTo(f11);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("重点项目质量流程控制文件");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			te.setAccessory11(acc);
		}
		if(file12.length>0){
			List<Accessory> acc = te.getAccessory12();
			for(int i=0;i<file12.length;i++){
				String fileName=file12[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f12=new File(filePath);
				file12[i].transferTo(f12);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("依据设计图纸");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			te.setAccessory12(acc);
		}
		if(file13.length>0){
			List<Accessory> acc = te.getAccessory13();
			for(int i=0;i<file13.length;i++){
				String fileName=file13[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f13=new File(filePath);
				file13[i].transferTo(f13);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("其它");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			te.setAccessory13(acc);
		}
		
		int i=service.addTestingEvaluationSave(te);
		map.put("result", i);
		map.put("TestingEvaluation", te);
		return map; 
	}

	
	@RequestMapping("/updateTestingEvaluationSave")//修改保存
	@ResponseBody
	public Map<String,Object> updateTestingEvaluationSave(String tes,@RequestParam MultipartFile [] file1,@RequestParam MultipartFile [] file2,@RequestParam MultipartFile [] file3,
			@RequestParam MultipartFile [] file4,@RequestParam MultipartFile [] file5,@RequestParam MultipartFile [] file6,@RequestParam MultipartFile [] file7,@RequestParam MultipartFile [] file8
			,@RequestParam MultipartFile [] file9,@RequestParam MultipartFile [] file10,@RequestParam MultipartFile [] file11,@RequestParam MultipartFile [] file12,@RequestParam MultipartFile [] file13,HttpServletRequest request) throws IllegalStateException, IOException{
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
		map2.put("accessory11", Accessory.class);
		map2.put("accessory12", Accessory.class);
		map2.put("accessory13", Accessory.class);
		JSONObject jsonObject=JSONObject.fromObject(tes);
		TestingEvaluation te=(TestingEvaluation)JSONObject.toBean(jsonObject, TestingEvaluation.class,map2);
		
		String id=te.getTeId();
		String path="D:"+File.separator+"oa"+File.separator+"TestingEvaluation";
		
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
		if(file11.length>0){
			List<Accessory> acc = te.getAccessory11();
			for(int i=0;i<file11.length;i++){
				String fileName=file11[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f11=new File(filePath);
				file11[i].transferTo(f11);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("重点项目质量流程控制文件");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			te.setAccessory11(acc);
		}
		if(file12.length>0){
			List<Accessory> acc = te.getAccessory12();
			for(int i=0;i<file12.length;i++){
				String fileName=file12[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f12=new File(filePath);
				file12[i].transferTo(f12);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("依据设计图纸");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			te.setAccessory12(acc);
		}
		if(file13.length>0){
			List<Accessory> acc = te.getAccessory13();
			for(int i=0;i<file13.length;i++){
				String fileName=file13[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f13=new File(filePath);
				file13[i].transferTo(f13);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("其它");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			te.setAccessory13(acc);
		}
		
		int i=service.updateTestingEvaluationSave(te);
		map.put("result", i);
		map.put("TestingEvaluation", te);
		return map; 
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

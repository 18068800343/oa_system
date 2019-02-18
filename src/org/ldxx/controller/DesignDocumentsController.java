package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ConstructionDocuments;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.DesignDocuments;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.User;
import org.ldxx.dao.DesignDocumentsDao;
import org.ldxx.service.AccessoryService;
import org.ldxx.service.DesignDocumentsService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONObject;

/**
 * 设计文件资料
 * @author hp
 */
@RequestMapping("DesignDocuments")
@Controller
public class DesignDocumentsController {
	
	@Autowired
	private DesignDocumentsService service;
	@Autowired
	private AccessoryService aService;
	@Autowired
	private DesignDocumentsDao dao;
	@Autowired
	private OrganizationManagementService oService;
	
	
	@RequestMapping("/selectDesignDocuments")
	@ResponseBody
	public List<DesignDocuments> selectDesignDocuments(){
		List<DesignDocuments> list=service.selectDesignDocuments();
		for(int i=0;i<list.size();i++){
			int length=aService.fileCount(list.get(i).getDdId());
			list.get(i).setFileLengthSJ(length);
		}
		return list;
	}
	
	
	/*@RequestMapping("/addDesignDocumentsSave")
	@ResponseBody
	public Map<String,Object> addDesignDocumentsSave(String dds,@RequestParam MultipartFile [] file1,@RequestParam MultipartFile [] file2,@RequestParam MultipartFile [] file3,
			@RequestParam MultipartFile [] file4,@RequestParam MultipartFile [] file5,@RequestParam MultipartFile [] file6,@RequestParam MultipartFile [] file7,@RequestParam MultipartFile [] file8
			,@RequestParam MultipartFile [] file9,@RequestParam MultipartFile [] file10,@RequestParam MultipartFile [] file11,@RequestParam MultipartFile [] file12,@RequestParam MultipartFile [] file13
			,@RequestParam MultipartFile [] file14,@RequestParam MultipartFile [] file15,@RequestParam MultipartFile [] file16,@RequestParam MultipartFile [] file17,@RequestParam MultipartFile [] file18
			,@RequestParam MultipartFile [] file19,@RequestParam MultipartFile [] file20,@RequestParam MultipartFile [] file21,@RequestParam MultipartFile [] file22,@RequestParam MultipartFile [] file23
			,@RequestParam MultipartFile [] file24,@RequestParam MultipartFile [] file25,@RequestParam MultipartFile [] file26,@RequestParam MultipartFile [] file27,@RequestParam MultipartFile [] file28
			,@RequestParam MultipartFile [] file29,@RequestParam MultipartFile [] file30,@RequestParam MultipartFile [] file31,@RequestParam MultipartFile [] file32,@RequestParam MultipartFile [] file33
			,@RequestParam MultipartFile [] file34,@RequestParam MultipartFile [] file35,@RequestParam MultipartFile [] file36,@RequestParam MultipartFile [] file37,@RequestParam MultipartFile [] file38
			,@RequestParam MultipartFile [] file39) throws IllegalStateException, IOException{
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
		map2.put("accessory14", Accessory.class);
		map2.put("accessory15", Accessory.class);
		map2.put("accessory16", Accessory.class);
		map2.put("accessory17", Accessory.class);
		map2.put("accessory18", Accessory.class);
		map2.put("accessory19", Accessory.class);
		map2.put("accessory20", Accessory.class);
		map2.put("accessory21", Accessory.class);
		map2.put("accessory22", Accessory.class);
		map2.put("accessory23", Accessory.class);
		map2.put("accessory24", Accessory.class);
		map2.put("accessory25", Accessory.class);
		map2.put("accessory26", Accessory.class);
		map2.put("accessory27", Accessory.class);
		map2.put("accessory28", Accessory.class);
		map2.put("accessory29", Accessory.class);
		map2.put("accessory30", Accessory.class);
		map2.put("accessory31", Accessory.class);
		map2.put("accessory32", Accessory.class);
		map2.put("accessory33", Accessory.class);
		map2.put("accessory34", Accessory.class);
		map2.put("accessory35", Accessory.class);
		map2.put("accessory36", Accessory.class);
		map2.put("accessory37", Accessory.class);
		map2.put("accessory38", Accessory.class);
		map2.put("accessory39", Accessory.class);
		JSONObject jsonObject=JSONObject.fromObject(dds);
		DesignDocuments dd=(DesignDocuments)JSONObject.toBean(jsonObject, DesignDocuments.class,map2);
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		dd.setDdId(id);
		String path="D:"+File.separator+"oa"+File.separator+"DesignDocuments"+File.separator+id;;
		
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file1.length>0){
			List<Accessory> acc = dd.getAccessory1();
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
			dd.setAccessory1(acc);
		}
		if(file2.length>0){
			List<Accessory> acc = dd.getAccessory2();
			for(int i=0;i<file2.length;i++){
				String fileName=file2[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file2[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("项目特点介绍、关键词");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory2(acc);
		}
		if(file3.length>0){
			List<Accessory> acc = dd.getAccessory3();
			for(int i=0;i<file3.length;i++){
				String fileName=file3[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file3[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("招投标文件");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory3(acc);
		}
		if(file4.length>0){
			List<Accessory> acc = dd.getAccessory4();
			for(int i=0;i<file4.length;i++){
				String fileName=file4[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file4[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("合同资料");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory4(acc);
		}
		if(file5.length>0){
			List<Accessory> acc = dd.getAccessory5();
			for(int i=0;i<file5.length;i++){
				String fileName=file5[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file5[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("工可设计任务书");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory5(acc);
		}
		if(file6.length>0){
			List<Accessory> acc = dd.getAccessory6();
			for(int i=0;i<file6.length;i++){
				String fileName=file6[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file6[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("工可建设用地批准书、规划要点");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory6(acc);
		}
		if(file7.length>0){
			List<Accessory> acc = dd.getAccessory7();
			for(int i=0;i<file7.length;i++){
				String fileName=file7[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file7[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("工可用地红线图（地形图）");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory7(acc);
		}
		if(file8.length>0){
			List<Accessory> acc = dd.getAccessory8();
			for(int i=0;i<file8.length;i++){
				String fileName=file8[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file8[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("工可用地实测图");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory8(acc);
		}
		if(file9.length>0){
			List<Accessory> acc = dd.getAccessory9();
			for(int i=0;i<file9.length;i++){
				String fileName=file9[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file9[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("工可区域控制性详细规划");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory9(acc);
		}
		if(file10.length>0){
			List<Accessory> acc = dd.getAccessory10();
			for(int i=0;i<file10.length;i++){
				String fileName=file10[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file10[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("工可开发可行性报告与市场调查");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory10(acc);
		}
		if(file11.length>0){
			List<Accessory> acc = dd.getAccessory11();
			for(int i=0;i<file11.length;i++){
				String fileName=file11[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file11[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("工可工程地质勘察报告");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory11(acc);
		}
		if(file12.length>0){
			List<Accessory> acc = dd.getAccessory12();
			for(int i=0;i<file12.length;i++){
				String fileName=file12[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file12[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("工可工程场地地震安评报告");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory12(acc);
		}
		if(file13.length>0){
			List<Accessory> acc = dd.getAccessory13();
			for(int i=0;i<file13.length;i++){
				String fileName=file13[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file13[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("工可用地范围周边市政系统情况");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory13(acc);
		}
		if(file14.length>0){
			List<Accessory> acc = dd.getAccessory14();
			for(int i=0;i<file14.length;i++){
				String fileName=file14[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file14[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("工可效果图");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory14(acc);
		}
		if(file15.length>0){
			List<Accessory> acc = dd.getAccessory15();
			for(int i=0;i<file15.length;i++){
				String fileName=file15[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file15[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("工可工可报告、图纸");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory15(acc);
		}
		if(file16.length>0){
			List<Accessory> acc = dd.getAccessory16();
			for(int i=0;i<file16.length;i++){
				String fileName=file16[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file16[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("工可相关单位往来函、文");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory16(acc);
		}
		if(file17.length>0){
			List<Accessory> acc = dd.getAccessory17();
			for(int i=0;i<file17.length;i++){
				String fileName=file17[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file17[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("报批效果图");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory17(acc);
		}
		if(file18.length>0){
			List<Accessory> acc = dd.getAccessory18();
			for(int i=0;i<file18.length;i++){
				String fileName=file18[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file18[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("报批文本");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory18(acc);
		}
		if(file19.length>0){
			List<Accessory> acc = dd.getAccessory19();
			for(int i=0;i<file19.length;i++){
				String fileName=file19[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file19[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("报批图纸");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory19(acc);
		}
		if(file20.length>0){
			List<Accessory> acc = dd.getAccessory20();
			for(int i=0;i<file20.length;i++){
				String fileName=file20[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file20[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("报批审查意见");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory20(acc);
		}
		if(file21.length>0){
			List<Accessory> acc = dd.getAccessory21();
			for(int i=0;i<file21.length;i++){
				String fileName=file21[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file21[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("报批校审单");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory21(acc);
		}
		if(file22.length>0){
			List<Accessory> acc = dd.getAccessory22();
			for(int i=0;i<file22.length;i++){
				String fileName=file22[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file22[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("初设方案批文（规划、环评、安评等）");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory22(acc);
		}
		if(file23.length>0){
			List<Accessory> acc = dd.getAccessory23();
			for(int i=0;i<file23.length;i++){
				String fileName=file23[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file23[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("初设施工图文件");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory23(acc);
		}
		if(file24.length>0){
			List<Accessory> acc = dd.getAccessory24();
			for(int i=0;i<file24.length;i++){
				String fileName=file24[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file24[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("初设概算书");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory24(acc);
		}
		if(file25.length>0){
			List<Accessory> acc = dd.getAccessory25();
			for(int i=0;i<file25.length;i++){
				String fileName=file25[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file25[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("初设地勘报告（初勘或详勘）");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory25(acc);
		}
		if(file26.length>0){
			List<Accessory> acc = dd.getAccessory26();
			for(int i=0;i<file26.length;i++){
				String fileName=file26[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file26[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("初设审查意见");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory26(acc);
		}
		if(file27.length>0){
			List<Accessory> acc = dd.getAccessory27();
			for(int i=0;i<file27.length;i++){
				String fileName=file27[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file27[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("初设校审单");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory27(acc);
		}
		if(file28.length>0){
			List<Accessory> acc = dd.getAccessory28();
			for(int i=0;i<file28.length;i++){
				String fileName=file28[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file28[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("初设相关单位往来函、文");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory28(acc);
		}
		if(file29.length>0){
			List<Accessory> acc = dd.getAccessory29();
			for(int i=0;i<file29.length;i++){
				String fileName=file29[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file29[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("施工图初设批文");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory29(acc);
		}
		if(file30.length>0){
			List<Accessory> acc = dd.getAccessory30();
			for(int i=0;i<file30.length;i++){
				String fileName=file30[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file30[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("施工图施工图文件");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory30(acc);
		}
		if(file31.length>0){
			List<Accessory> acc = dd.getAccessory31();
			for(int i=0;i<file31.length;i++){
				String fileName=file31[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file31[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("施工图结构模型、计算书");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory31(acc);
		}
		if(file32.length>0){
			List<Accessory> acc = dd.getAccessory32();
			for(int i=0;i<file32.length;i++){
				String fileName=file32[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file32[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("施工图地勘报告（详勘）");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory32(acc);
		}
		if(file33.length>0){
			List<Accessory> acc = dd.getAccessory33();
			for(int i=0;i<file33.length;i++){
				String fileName=file33[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file33[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("施工图审查意见");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory33(acc);
		}
		if(file34.length>0){
			List<Accessory> acc = dd.getAccessory34();
			for(int i=0;i<file34.length;i++){
				String fileName=file34[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file34[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("施工图校审单");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory34(acc);
		}
		if(file35.length>0){
			List<Accessory> acc = dd.getAccessory35();
			for(int i=0;i<file35.length;i++){
				String fileName=file35[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file35[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("施工图施工交底记录及回复");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory35(acc);
		}
		if(file36.length>0){
			List<Accessory> acc = dd.getAccessory36();
			for(int i=0;i<file36.length;i++){
				String fileName=file36[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file36[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("施工图设计变更资料");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory36(acc);
		}
		if(file37.length>0){
			List<Accessory> acc = dd.getAccessory37();
			for(int i=0;i<file37.length;i++){
				String fileName=file37[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file37[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("施工图重点项目项目总结");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory37(acc);
		}
		if(file38.length>0){
			List<Accessory> acc = dd.getAccessory38();
			for(int i=0;i<file38.length;i++){
				String fileName=file38[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file38[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("施工图相关单位往来函、文");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory38(acc);
		}
		if(file39.length>0){
			List<Accessory> acc = dd.getAccessory39();
			for(int i=0;i<file39.length;i++){
				String fileName=file39[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file39[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("施工图重点项目质量流程内部控制文件");
					String desc=acc.get(j).getaDesc();
					acc.get(j).setaDesc(desc);
				}
			}
			dd.setAccessory39(acc);
		}
		
		int i=service.addDesignDocumentsSave(dd);
		map.put("result", i);
		map.put("DesignDocuments", dd);
		
		return map;
	}*/
	
	
	
	@RequestMapping("/updateDesignDocumentsSave")
	@ResponseBody
	public String updateDesignDocumentsSave(String dds,@RequestParam MultipartFile [] file1,@RequestParam MultipartFile [] file2,@RequestParam MultipartFile [] file3,
			@RequestParam MultipartFile [] file4,@RequestParam MultipartFile [] file5,@RequestParam MultipartFile [] file6,@RequestParam MultipartFile [] file7,@RequestParam MultipartFile [] file8
			,@RequestParam MultipartFile [] file9,@RequestParam MultipartFile [] file10,@RequestParam MultipartFile [] file11,@RequestParam MultipartFile [] file12,@RequestParam MultipartFile [] file13
			,@RequestParam MultipartFile [] file14,@RequestParam MultipartFile [] file15,@RequestParam MultipartFile [] file16,@RequestParam MultipartFile [] file17,@RequestParam MultipartFile [] file18
			,@RequestParam MultipartFile [] file19,@RequestParam MultipartFile [] file20,@RequestParam MultipartFile [] file21,@RequestParam MultipartFile [] file22,@RequestParam MultipartFile [] file23
			,@RequestParam MultipartFile [] file24,@RequestParam MultipartFile [] file25,@RequestParam MultipartFile [] file26,@RequestParam MultipartFile [] file27,@RequestParam MultipartFile [] file28
			,@RequestParam MultipartFile [] file29,@RequestParam MultipartFile [] file30,@RequestParam MultipartFile [] file31,@RequestParam MultipartFile [] file32,@RequestParam MultipartFile [] file33
			,@RequestParam MultipartFile [] file34,@RequestParam MultipartFile [] file35,@RequestParam MultipartFile [] file36,@RequestParam MultipartFile [] file37,@RequestParam MultipartFile [] file38
			,@RequestParam MultipartFile [] file39,@RequestParam MultipartFile [] file40,@RequestParam MultipartFile [] file41,HttpSession session,HttpServletResponse response) throws IllegalStateException, IOException{
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
		map2.put("accessory14", Accessory.class);
		map2.put("accessory15", Accessory.class);
		map2.put("accessory16", Accessory.class);
		map2.put("accessory17", Accessory.class);
		map2.put("accessory18", Accessory.class);
		map2.put("accessory19", Accessory.class);
		map2.put("accessory20", Accessory.class);
		map2.put("accessory21", Accessory.class);
		map2.put("accessory22", Accessory.class);
		map2.put("accessory23", Accessory.class);
		map2.put("accessory24", Accessory.class);
		map2.put("accessory25", Accessory.class);
		map2.put("accessory26", Accessory.class);
		map2.put("accessory27", Accessory.class);
		map2.put("accessory28", Accessory.class);
		map2.put("accessory29", Accessory.class);
		map2.put("accessory30", Accessory.class);
		map2.put("accessory31", Accessory.class);
		map2.put("accessory32", Accessory.class);
		map2.put("accessory33", Accessory.class);
		map2.put("accessory34", Accessory.class);
		map2.put("accessory35", Accessory.class);
		map2.put("accessory36", Accessory.class);
		map2.put("accessory37", Accessory.class);
		map2.put("accessory38", Accessory.class);
		map2.put("accessory39", Accessory.class);
		map2.put("accessory40", Accessory.class);
		map2.put("accessory41", Accessory.class);
		JSONObject jsonObject=JSONObject.fromObject(dds);
		DesignDocuments dd=(DesignDocuments)JSONObject.toBean(jsonObject, DesignDocuments.class,map2);
		
		TimeUUID uuid=new TimeUUID();
		String id=dd.getDdId();
		if(id==null||id==""){
			id=uuid.getTimeUUID();
			dd.setDdId(id);
			int i=dao.addDesignDocumentsSave(dd);
		}
		//String path="D:"+File.separator+"oa"+File.separator+"DesignDocuments"+File.separator+id;;
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
				accessory.setaType("SJ项目实际存档目录");
				list.add(accessory);
			}
			dd.setAccessory1(list);
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
				accessory.setaType("SJ项目特点介绍、关键词(尤其施工图阶段)");
				list.add(accessory);
			}
			dd.setAccessory2(list);
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
				accessory.setaType("SJ合同资料(合同原件提交经营部综合部)");
				list.add(accessory);
			}
			dd.setAccessory3(list);
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
				accessory.setaType("SJgk设计任务书");
				list.add(accessory);
			}
			dd.setAccessory4(list);
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
				accessory.setaType("SJgk建设用地批准书、规划要点");
				list.add(accessory);
			}
			dd.setAccessory5(list);
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
				accessory.setaType("SJgk用地红线图(地形图)");
				list.add(accessory);
			}
			dd.setAccessory6(list);
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
				accessory.setaType("SJgk用地实测图");
				list.add(accessory);
			}
			dd.setAccessory7(list);
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
				accessory.setaType("SJgk区域控制性详细规划");
				list.add(accessory);
			}
			dd.setAccessory8(list);
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
				accessory.setaType("SJgk开发可行性报告与市场调查");
				list.add(accessory);
			}
			dd.setAccessory9(list);
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
				accessory.setaType("SJgk工程地质勘察报告");
				list.add(accessory);
			}
			dd.setAccessory10(list);
		}
		if(file11.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file11.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file11[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file11[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJgk工程场地地震安评报告");
				list.add(accessory);
			}
			dd.setAccessory11(list);
		}
		if(file12.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file12.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file12[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file12[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJgk用地范围周边市政系统情况");
				list.add(accessory);
			}
			dd.setAccessory12(list);
		}
		if(file13.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file13.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file13[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file13[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJgk工可报告、图纸");
				list.add(accessory);
			}
			dd.setAccessory13(list);
		}
		if(file14.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file14.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file14[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file14[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJgk相关单位往来函、文");
				list.add(accessory);
			}
			dd.setAccessory14(list);
		}
		if(file15.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file15.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file15[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file15[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJgk效果图");
				list.add(accessory);
			}
			dd.setAccessory15(list);
		}
		if(file16.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file16.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file16[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file16[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJgk报批文本");
				list.add(accessory);
			}
			dd.setAccessory16(list);
		}
		if(file17.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file17.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file17[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file17[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJgk图纸");
				list.add(accessory);
			}
			dd.setAccessory17(list);
		}
		if(file18.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file18.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file18[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file18[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJgk审查意见");
				list.add(accessory);
			}
			dd.setAccessory18(list);
		}
		if(file19.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file19.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file19[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file19[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJgk校审单");
				list.add(accessory);
			}
			dd.setAccessory19(list);
		}
		if(file20.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file20.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file20[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file20[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJcs方案批文(规划、环评、安评等)");
				list.add(accessory);
			}
			dd.setAccessory20(list);
		}
		if(file21.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file21.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file21[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file21[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJcs施工图文件");
				list.add(accessory);
			}
			dd.setAccessory21(list);
		}
		if(file22.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file22.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file22[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file22[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJcs概算书");
				list.add(accessory);
			}
			dd.setAccessory22(list);
		}
		if(file23.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file23.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file23[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file23[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJcs地勘报告(初勘或详勘)");
				list.add(accessory);
			}
			dd.setAccessory23(list);
		}
		if(file24.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file24.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file24[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file24[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJcs审查意见");
				list.add(accessory);
			}
			dd.setAccessory24(list);
		}
		if(file25.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file25.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file25[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file25[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJcs校审单");
				list.add(accessory);
			}
			dd.setAccessory25(list);
		}
		if(file26.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file26.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file26[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file26[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJcs相关单位往来函、文");
				list.add(accessory);
			}
			dd.setAccessory26(list);
		}
		if(file27.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file27.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file27[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file27[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJsgt初设批文");
				list.add(accessory);
			}
			dd.setAccessory27(list);
		}
		if(file28.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file28.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file28[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file28[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJsgt施工图文件");
				list.add(accessory);
			}
			dd.setAccessory28(list);
		}
		if(file29.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file29.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file29[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file29[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJsgt预算书");
				list.add(accessory);
			}
			dd.setAccessory29(list);
		}
		if(file30.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file30.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file30[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file30[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJsgt依据历史图纸和报告");
				list.add(accessory);
			}
			dd.setAccessory30(list);
		}
		if(file31.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file31.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file31[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file31[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJsgt结构模型、计算书");
				list.add(accessory);
			}
			dd.setAccessory31(list);
		}
		if(file32.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file32.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file32[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file32[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJsgt地勘报告(详勘)");
				list.add(accessory);
			}
			dd.setAccessory32(list);
		}
		if(file33.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file33.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file33[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file33[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJsgt工程咨询报告");
				list.add(accessory);
			}
			dd.setAccessory33(list);
		}
		if(file34.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file34.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file34[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file34[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJsgt审查意见");
				list.add(accessory);
			}
			dd.setAccessory34(list);
		}
		if(file35.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file35.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file35[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file35[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJsgt校审单");
				list.add(accessory);
			}
			dd.setAccessory35(list);
		}
		if(file36.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file36.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file36[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file36[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJsgt施工交底记录及回复");
				list.add(accessory);
			}
			dd.setAccessory36(list);
		}
		if(file37.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file37.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file37[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file37[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJsgt设计变更资料");
				list.add(accessory);
			}
			dd.setAccessory37(list);
		}
		if(file38.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file38.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file38[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file38[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJsgt重点项目项目总结");
				list.add(accessory);
			}
			dd.setAccessory38(list);
		}
		if(file39.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file39.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file39[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file39[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJsgt交工验收文件(原件提交经营发展部，如施工任务由公司承担则不需要)");
				list.add(accessory);
			}
			dd.setAccessory39(list);
		}
		if(file40.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file40.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file40[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file40[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJsgt获奖证书");
				list.add(accessory);
			}
			dd.setAccessory40(list);
		}
		if(file41.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file41.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file41[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file41[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("SJsgt相关单位往来函、文");
				list.add(accessory);
			}
			dd.setAccessory41(list);
		}
		
		int i=service.updateDesignDocumentsSave(dd);
		String string = i+"";
		if(i>0){
			User user = (User) session.getAttribute("user");
			OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String omNo=om.getOmNo();
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(dd.getPrjName()+"设计资料归档申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(dd.getPrjName()+"设计资料归档申请流程发起");
			currentFlow.setUrl("danganGUanli/designDocumentLook.html-"+id);
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
		map.put("DesignDocuments", dd);
		return map;*/
	}
	
	@RequestMapping("/selectDesignDocumentsByno")
	@ResponseBody
	public DesignDocuments selectDesignDocumentsById(String no){
		return service.selectDesignDocumentsById(no);
	}
	
	
	@RequestMapping("/deleteDesignDocuments")
	@ResponseBody
	public int deleteDesignDocuments(String id){
		return service.deleteDesignDocuments(id);
	}
	

}

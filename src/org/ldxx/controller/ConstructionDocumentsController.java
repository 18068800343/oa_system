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
import org.ldxx.dao.ConstructionDocumentsDao;
import org.ldxx.service.AccessoryService;
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
	@Autowired
	private AccessoryService aService;
	@Autowired
	private ConstructionDocumentsDao dao;
	
	@RequestMapping("/selectConstructionDocuments")
	@ResponseBody
	public List<ConstructionDocuments> selectConstructionDocuments(){
		List<ConstructionDocuments> list = service.selectConstructionDocuments();
		for(int i=0;i<list.size();i++){
			int length=aService.fileCount(list.get(i).getCdId());
			list.get(i).setFileLengthSG(length);
		}
		return list;
	}
	
	
	/*@RequestMapping("/addConstructionDocumentsSave")//添加保存
	@ResponseBody
	public Map<String,Object> addConstructionDocumentsSave(String cds,@RequestParam MultipartFile [] file1,@RequestParam MultipartFile [] file2,@RequestParam MultipartFile [] file3,
			@RequestParam MultipartFile [] file4,@RequestParam MultipartFile [] file5,@RequestParam MultipartFile [] file6,@RequestParam MultipartFile [] file7,@RequestParam MultipartFile [] file8
			,@RequestParam MultipartFile [] file9,@RequestParam MultipartFile [] file10,@RequestParam MultipartFile [] file11,@RequestParam MultipartFile [] file12,@RequestParam MultipartFile [] file13
			,@RequestParam MultipartFile [] file14,@RequestParam MultipartFile [] file15) throws IllegalStateException, IOException{
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
		JSONObject jsonObject=JSONObject.fromObject(cds);
		ConstructionDocuments cd=(ConstructionDocuments)JSONObject.toBean(jsonObject, ConstructionDocuments.class,map2);
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cd.setCdId(id);
		String path="D:"+File.separator+"oa"+File.separator+"ConstructionDocuments"+File.separator+id;;
		
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file1.length>0){
			List<Accessory> acc = cd.getAccessory1();
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
			cd.setAccessory1(acc);
		}
		if(file2.length>0){
			List<Accessory> acc = cd.getAccessory2();
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
			cd.setAccessory2(acc);
		}
		if(file3.length>0){
			List<Accessory> acc = cd.getAccessory3();
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
			cd.setAccessory3(acc);
		}
		if(file4.length>0){
			List<Accessory> acc = cd.getAccessory4();
			for(int i=0;i<file4.length;i++){
				String fileName=file4[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f4=new File(filePath);
				file4[i].transferTo(f4);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("项目主合同");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			cd.setAccessory4(acc);
		}
		if(file5.length>0){
			List<Accessory> acc = cd.getAccessory5();
			for(int i=0;i<file5.length;i++){
				String fileName=file5[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f5=new File(filePath);
				file5[i].transferTo(f5);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("开工报告");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			cd.setAccessory5(acc);
		}
		if(file6.length>0){
			List<Accessory> acc = cd.getAccessory6();
			for(int i=0;i<file6.length;i++){
				String fileName=file6[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f6=new File(filePath);
				file6[i].transferTo(f6);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("项目总结");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			cd.setAccessory6(acc);
		}
		if(file7.length>0){
			List<Accessory> acc = cd.getAccessory7();
			for(int i=0;i<file7.length;i++){
				String fileName=file7[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f7=new File(filePath);
				file7[i].transferTo(f7);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("计量资料");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			cd.setAccessory7(acc);
		}
		if(file8.length>0){
			List<Accessory> acc = cd.getAccessory8();
			for(int i=0;i<file8.length;i++){
				String fileName=file8[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f8=new File(filePath);
				file8[i].transferTo(f8);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("设计变更资料");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			cd.setAccessory8(acc);
		}
		if(file9.length>0){
			List<Accessory> acc = cd.getAccessory9();
			for(int i=0;i<file9.length;i++){
				String fileName=file9[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f9=new File(filePath);
				file9[i].transferTo(f9);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("施工图和竣工图");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			cd.setAccessory9(acc);
		}
		if(file10.length>0){
			List<Accessory> acc = cd.getAccessory10();
			for(int i=0;i<file10.length;i++){
				String fileName=file10[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f10=new File(filePath);
				file10[i].transferTo(f10);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("开工、过程以及交竣工全部外部审查意见");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			cd.setAccessory10(acc);
		}
		if(file11.length>0){
			List<Accessory> acc = cd.getAccessory11();
			for(int i=0;i<file11.length;i++){
				String fileName=file11[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f11=new File(filePath);
				file11[i].transferTo(f11);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("首件工程总结");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			cd.setAccessory11(acc);
		}
		if(file12.length>0){
			List<Accessory> acc = cd.getAccessory12();
			for(int i=0;i<file12.length;i++){
				String fileName=file12[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f12=new File(filePath);
				file12[i].transferTo(f12);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("材料检测资料");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			cd.setAccessory12(acc);
		}
		if(file13.length>0){
			List<Accessory> acc = cd.getAccessory13();
			for(int i=0;i<file13.length;i++){
				String fileName=file13[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f13=new File(filePath);
				file13[i].transferTo(f13);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("中间报验资料和检验评定资料");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			cd.setAccessory13(acc);
		}
		if(file14.length>0){
			List<Accessory> acc = cd.getAccessory14();
			for(int i=0;i<file14.length;i++){
				String fileName=file14[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f14=new File(filePath);
				file14[i].transferTo(f14);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("施工日志");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			cd.setAccessory14(acc);
		}
		if(file15.length>0){
			List<Accessory> acc = cd.getAccessory15();
			for(int i=0;i<file15.length;i++){
				String fileName=file15[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f15=new File(filePath);
				file15[i].transferTo(f15);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("其它");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			cd.setAccessory15(acc);
		}
		
		int i=service.addConstructionDocumentsSave(cd);
		map.put("result", i);
		map.put("ConstructionDocuments", cd);
		return map; 
	}
	*/
	
	
	@RequestMapping("/deleteConstructionDocumentsById")
	@ResponseBody
	public int deleteConstructionDocumentsById(String id){
		return service.deleteConstructionDocumentsById(id);
	}
	
	
	@RequestMapping("/updateConstructionDocumentsSave")//修改保存
	@ResponseBody
	public Map<String,Object> updateConstructionDocumentsSave(String  cds,@RequestParam MultipartFile [] file1,@RequestParam MultipartFile [] file2,@RequestParam MultipartFile [] file3,
			@RequestParam MultipartFile [] file4,@RequestParam MultipartFile [] file5,@RequestParam MultipartFile [] file6,@RequestParam MultipartFile [] file7,@RequestParam MultipartFile [] file8
			,@RequestParam MultipartFile [] file9,@RequestParam MultipartFile [] file10,@RequestParam MultipartFile [] file11,@RequestParam MultipartFile [] file12,@RequestParam MultipartFile [] file13
			,@RequestParam MultipartFile [] file14,@RequestParam MultipartFile [] file15,@RequestParam MultipartFile [] file16) throws IllegalStateException, IOException{
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
		JSONObject jsonObject=JSONObject.fromObject(cds);
		ConstructionDocuments cd=(ConstructionDocuments)JSONObject.toBean(jsonObject, ConstructionDocuments.class,map2);
		
		TimeUUID uuid=new TimeUUID();
		String id=cd.getCdId();
		if(id==null||id==""){
			id=uuid.getTimeUUID();
			cd.setCdId(id);
			int i=dao.addConstructionDocumentsSave(cd);
		}
		//String path="D:"+File.separator+"oa"+File.separator+"ConstructionDocuments"+File.separator+id;
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
				accessory.setaType("SG项目实际存档目录");
				list.add(accessory);
			}
			cd.setAccessory1(list);
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
				accessory.setaType("SG项目特点介绍、关键词");
				list.add(accessory);
			}
			cd.setAccessory2(list);
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
				accessory.setaType("SG合同资料(合同原件提交经营部综合部)");
				list.add(accessory);
			}
			cd.setAccessory3(list);
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
				accessory.setaType("SG开工报告(含专项方案及评审)");
				list.add(accessory);
			}
			cd.setAccessory4(list);
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
				accessory.setaType("SG项目外部评价报告(安评等咨询类)");
				list.add(accessory);
			}
			cd.setAccessory5(list);
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
				accessory.setaType("SG项目总结(应包括照片并分类整理好)");
				list.add(accessory);
			}
			cd.setAccessory6(list);
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
				accessory.setaType("SG计量资料(原件提交经营发展部，审计结算报告需扫描件)");
				list.add(accessory);
			}
			cd.setAccessory7(list);
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
				accessory.setaType("SG设计变更资料");
				list.add(accessory);
			}
			cd.setAccessory8(list);
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
				accessory.setaType("SG施工图和竣工图");
				list.add(accessory);
			}
			cd.setAccessory9(list);
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
				accessory.setaType("SG开工至交竣工全部外部审查意见");
				list.add(accessory);
			}
			cd.setAccessory10(list);
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
				accessory.setaType("SG首件工程总结");
				list.add(accessory);
			}
			cd.setAccessory11(list);
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
				accessory.setaType("SG材料检测资料");
				list.add(accessory);
			}
			cd.setAccessory12(list);
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
				accessory.setaType("SG中间报验资料和检验评定资料");
				list.add(accessory);
			}
			cd.setAccessory13(list);
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
				accessory.setaType("SG施工日志");
				list.add(accessory);
			}
			cd.setAccessory14(list);
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
				accessory.setaType("SG获奖证书");
				list.add(accessory);
			}
			cd.setAccessory15(list);
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
				accessory.setaType("SG交竣工验收文件(原件提交经营发展部)");
				list.add(accessory);
			}
			cd.setAccessory16(list);
		}
		
		int i=service.updateConstructionDocumentsSave(cd);
		map.put("result", i);
		map.put("ConstructionDocuments", cd);
		return map; 
	}
	
	@RequestMapping("/selectConstructionDocumentsByno")
	@ResponseBody
	public ConstructionDocuments selectConstructionDocumentsByno(String no){
		return service.selectConstructionDocumentsByno(no);
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

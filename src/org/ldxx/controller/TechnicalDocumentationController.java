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
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.PrjRecord;
import org.ldxx.bean.TechnicalDocumentation;
import org.ldxx.bean.User;
import org.ldxx.dao.TechnicalDocumentationDao;
import org.ldxx.service.AccessoryService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.PrjRecordService;
import org.ldxx.service.TechnicalDocumentationService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

/**
 * 科技文档资料
 * @author hp
 *
 */
@RequestMapping("TechnicalDocumentation")
@Controller
public class TechnicalDocumentationController {
	
	@Autowired
	private TechnicalDocumentationService service;
	@Autowired
	private AccessoryService aService;
	@Autowired
	private TechnicalDocumentationDao dao;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private PrjRecordService prService;
	
	@RequestMapping("/selectTechnicalDocumentation")
	@ResponseBody
	public List<TechnicalDocumentation> selectTechnicalDocumentation(){
		List<TechnicalDocumentation> list=service.selectTechnicalDocumentation();
		for(int i=0;i<list.size();i++){
			int length=aService.fileCount(list.get(i).getTdId());
			list.get(i).setFileLengthKJ(length);
		}
		return list;
	}
	
	
	/*@RequestMapping("/addTechnicalDocumentationSave")//添加保存
	@ResponseBody
	public Map<String,Object> addTechnicalDocumentationSave(String tds,@RequestParam MultipartFile [] file1,@RequestParam MultipartFile [] file2,@RequestParam MultipartFile [] file3,
			@RequestParam MultipartFile [] file4,@RequestParam MultipartFile [] file5,@RequestParam MultipartFile [] file6,@RequestParam MultipartFile [] file7,@RequestParam MultipartFile [] file8
			,@RequestParam MultipartFile [] file9,@RequestParam MultipartFile [] file10,@RequestParam MultipartFile [] file11,@RequestParam MultipartFile [] file12,@RequestParam MultipartFile [] file13
			,@RequestParam MultipartFile [] file14,@RequestParam MultipartFile [] file15,@RequestParam MultipartFile [] file16,@RequestParam MultipartFile [] file17,@RequestParam MultipartFile [] file18) throws IllegalStateException, IOException{
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
		JSONObject jsonObject=JSONObject.fromObject(tds);
		TechnicalDocumentation td=(TechnicalDocumentation)JSONObject.toBean(jsonObject, TechnicalDocumentation.class,map2);
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		td.setTdId(id);
		String path="D:"+File.separator+"oa"+File.separator+"TechnicalDocumentation"+File.separator+id;;
		
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file1.length>0){
			List<Accessory> acc = td.getAccessory1();
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
			td.setAccessory1(acc);
		}
		if(file2.length>0){
			List<Accessory> acc = td.getAccessory2();
			for(int i=0;i<file2.length;i++){
				String fileName=file2[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[i].transferTo(f2);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("合同资料");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			td.setAccessory2(acc);
		}
		if(file3.length>0){
			List<Accessory> acc = td.getAccessory3();
			for(int i=0;i<file3.length;i++){
				String fileName=file3[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f3=new File(filePath);
				file3[i].transferTo(f3);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("科研申请书");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			td.setAccessory3(acc);
		}
		if(file4.length>0){
			List<Accessory> acc = td.getAccessory4();
			for(int i=0;i<file4.length;i++){
				String fileName=file4[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f4=new File(filePath);
				file4[i].transferTo(f4);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("工作大纲及评审记录");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			td.setAccessory4(acc);
		}
		if(file5.length>0){
			List<Accessory> acc = td.getAccessory5();
			for(int i=0;i<file5.length;i++){
				String fileName=file5[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f5=new File(filePath);
				file5[i].transferTo(f5);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("中间报告及评审记录");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			td.setAccessory5(acc);
		}
		if(file6.length>0){
			List<Accessory> acc = td.getAccessory6();
			for(int i=0;i<file6.length;i++){
				String fileName=file6[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f6=new File(filePath);
				file6[i].transferTo(f6);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("成果简介");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			td.setAccessory6(acc);
		}
		if(file7.length>0){
			List<Accessory> acc = td.getAccessory7();
			for(int i=0;i<file7.length;i++){
				String fileName=file7[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f7=new File(filePath);
				file7[i].transferTo(f7);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("研究报告");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			td.setAccessory7(acc);
		}
		if(file8.length>0){
			List<Accessory> acc = td.getAccessory8();
			for(int i=0;i<file8.length;i++){
				String fileName=file8[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f8=new File(filePath);
				file8[i].transferTo(f8);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("查新报告");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			td.setAccessory8(acc);
		}
		if(file9.length>0){
			List<Accessory> acc = td.getAccessory9();
			for(int i=0;i<file9.length;i++){
				String fileName=file9[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f9=new File(filePath);
				file9[i].transferTo(f9);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("总结报告");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			td.setAccessory9(acc);
		}
		if(file10.length>0){
			List<Accessory> acc = td.getAccessory10();
			for(int i=0;i<file10.length;i++){
				String fileName=file10[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f10=new File(filePath);
				file10[i].transferTo(f10);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("用户报告/应用证明");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			td.setAccessory10(acc);
		}
		if(file11.length>0){
			List<Accessory> acc = td.getAccessory11();
			for(int i=0;i<file11.length;i++){
				String fileName=file11[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f11=new File(filePath);
				file11[i].transferTo(f11);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("鉴定(评审)证书/验收评审意见");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			td.setAccessory11(acc);
		}
		if(file12.length>0){
			List<Accessory> acc = td.getAccessory12();
			for(int i=0;i<file12.length;i++){
				String fileName=file12[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f12=new File(filePath);
				file12[i].transferTo(f12);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("科研项目其他成果");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			td.setAccessory12(acc);
		}
		if(file13.length>0){
			List<Accessory> acc = td.getAccessory13();
			for(int i=0;i<file13.length;i++){
				String fileName=file13[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f13=new File(filePath);
				file13[i].transferTo(f13);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("汇报PPT");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			td.setAccessory13(acc);
		}
		if(file14.length>0){
			List<Accessory> acc = td.getAccessory14();
			for(int i=0;i<file14.length;i++){
				String fileName=file14[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f14=new File(filePath);
				file14[i].transferTo(f14);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("财务决算表");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			td.setAccessory14(acc);
		}
		if(file15.length>0){
			List<Accessory> acc = td.getAccessory15();
			for(int i=0;i<file15.length;i++){
				String fileName=file15[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f15=new File(filePath);
				file15[i].transferTo(f15);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("报奖文件");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			td.setAccessory15(acc);
		}
		if(file16.length>0){
			List<Accessory> acc = td.getAccessory16();
			for(int i=0;i<file16.length;i++){
				String fileName=file16[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f16=new File(filePath);
				file16[i].transferTo(f16);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("相关论文及专利");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			td.setAccessory16(acc);
		}
		if(file17.length>0){
			List<Accessory> acc = td.getAccessory17();
			for(int i=0;i<file17.length;i++){
				String fileName=file17[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f17=new File(filePath);
				file17[i].transferTo(f17);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					acc.get(j).setaType("课题所用到图纸、模型和报告");
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			td.setAccessory17(acc);
		}
		
		int i=service.addConstructionDocumentsSave(td);
		map.put("result", i);
		map.put("TechnicalDocumentation", td);
		return map; 
	}*/
	
	@RequestMapping("/updateTechnicalDocumentationSave")//修改保存
	@ResponseBody
	public int updateTechnicalDocumentationSave(String id,@RequestParam(required=false,value="file1") MultipartFile [] file1,@RequestParam(required=false,value="file2") MultipartFile [] file2,@RequestParam(required=false,value="file3") MultipartFile [] file3,
			@RequestParam(required=false,value="file4") MultipartFile [] file4,@RequestParam(required=false,value="file5") MultipartFile [] file5,@RequestParam(required=false,value="file6") MultipartFile [] file6,@RequestParam(required=false,value="file7") MultipartFile [] file7,@RequestParam(required=false,value="file8") MultipartFile [] file8
			,@RequestParam(required=false,value="file9") MultipartFile [] file9,@RequestParam(required=false,value="file10") MultipartFile [] file10,@RequestParam(required=false,value="file11") MultipartFile [] file11,@RequestParam(required=false,value="file12") MultipartFile [] file12,@RequestParam(required=false,value="file13") MultipartFile [] file13
			,@RequestParam(required=false,value="file14") MultipartFile [] file14,@RequestParam(required=false,value="file15") MultipartFile [] file15,@RequestParam(required=false,value="file16") MultipartFile [] file16,@RequestParam(required=false,value="file17") MultipartFile [] file17,@RequestParam(required=false,value="file18") MultipartFile [] file18,HttpSession session,HttpServletResponse response) throws IllegalStateException, IOException{
		/*Map<String,Object> map=new HashMap<>();
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
		JSONObject jsonObject=JSONObject.fromObject(tds);
		TechnicalDocumentation td=(TechnicalDocumentation)JSONObject.toBean(jsonObject, TechnicalDocumentation.class,map2);
		*/
		TimeUUID uuid=new TimeUUID();
		/*String id=td.getTdId();
		if(id==null||id==""){
			id=uuid.getTimeUUID();
			td.setTdId(id);
			int i=dao.addConstructionDocumentsSave(td);
		}*/
		//String path="D:"+File.separator+"oa"+File.separator+"TechnicalDocumentation"+File.separator+id;;
		String id2=id+"2";
		String webApps=uuid.getWebAppFile();
		String path=webApps+id2;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		List<Accessory> list=new ArrayList<>();
		int num=0;
		if(file1.length>0){
			for(int i=0;i<file1.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file1[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ项目实际存档目");
				list.add(accessory);
			}
			num+=1;
		}
		if(file2.length>0){
			for(int i=0;i<file2.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file2[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file2[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ合同资料(合同原件提交经营部综合部)");
				list.add(accessory);
			}
			num+=1;
		}
		if(file3.length>0){
			for(int i=0;i<file3.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file3[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file3[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ科研申请书");
				list.add(accessory);
			}
			num+=1;
		}
		if(file4.length>0){
			for(int i=0;i<file4.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file4[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file4[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ工作大纲及评审记录");
				list.add(accessory);
			}
			num+=1;
		}
		if(file5.length>0){
			for(int i=0;i<file5.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file5[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file5[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ中间报告及评审记录");
				list.add(accessory);
			}
			num+=1;
		}
		if(file6.length>0){
			for(int i=0;i<file6.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file6[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file6[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ成果简介");
				list.add(accessory);
			}
			num+=1;
		}
		if(file7.length>0){
			for(int i=0;i<file7.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file7[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file7[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ研究报告(内容比较全面)");
				list.add(accessory);
			}
			num+=1;
		}
		if(file8.length>0){
			for(int i=0;i<file8.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file8[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file8[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ查新报告");
				list.add(accessory);
			}
			num+=1;
		}
		if(file9.length>0){
			for(int i=0;i<file9.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file9[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file9[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ总结报告");
				list.add(accessory);
			}
			num+=1;
		}
		if(file10.length>0){
			for(int i=0;i<file10.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file10[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file10[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ用户报告/应用证明");
				list.add(accessory);
			}
			num+=1;
		}
		if(file11.length>0){
			for(int i=0;i<file11.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file11[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file11[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ鉴定(评审)证书/验收评审意见");
				list.add(accessory);
			}
			num+=1;
		}
		if(file12.length>0){
			for(int i=0;i<file12.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file12[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file12[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ科研项目其他成果(指南、调查报告等)");
				list.add(accessory);
			}
			num+=1;
		}
		if(file13.length>0){
			for(int i=0;i<file13.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file13[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file13[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ汇报PPT");
				list.add(accessory);
			}
			num+=1;
		}
		if(file14.length>0){
			for(int i=0;i<file14.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file14[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file14[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ财务决算表");
				list.add(accessory);
			}
			num+=1;
		}
		if(file15.length>0){
			for(int i=0;i<file15.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file15[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file15[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ报奖文件");
				list.add(accessory);
			}
			num+=1;
		}
		if(file16.length>0){
			for(int i=0;i<file16.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file16[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file16[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ相关论文及专利");
				list.add(accessory);
			}
			num+=1;
		}
		if(file17.length>0){
			for(int i=0;i<file17.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file17[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file17[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ课题所用到图纸、模型和报告");
				list.add(accessory);
			}
			num+=1;
		}
		if(file18.length>0){
			for(int i=0;i<file18.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file18[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file18[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ其他");
				list.add(accessory);
			}
			num+=1;
		}
		int i=0;
		if(list.size()==0||list==null){
			i=-1;
		}else{
			i=aService.addAccessory(list);
			if(i>0){
				if(i>0){
					prService.updateScStatus(id, 1);
				}
			}
		}
		return i;
		/*String string = i+"";
		if(i>0){
			User user = (User) session.getAttribute("user");
			OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String omNo=om.getOmNo();
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(td.getPrjName()+"科技资料归档申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(td.getPrjName()+"科技资料归档申请流程发起");
			currentFlow.setUrl("danganGUanliLook/ScienceTechnologyLook.html-"+id);
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
		return string;*/
	}
	
	@RequestMapping("/updateTechnicalDocumentationSave2")//修改保存
	@ResponseBody
	public int updateTechnicalDocumentationSave2(String id,@RequestParam(required=false,value="file1") MultipartFile [] file1,@RequestParam(required=false,value="file2") MultipartFile [] file2,@RequestParam(required=false,value="file3") MultipartFile [] file3,
			@RequestParam(required=false,value="file4") MultipartFile [] file4,@RequestParam(required=false,value="file5") MultipartFile [] file5,@RequestParam(required=false,value="file6") MultipartFile [] file6,@RequestParam(required=false,value="file7") MultipartFile [] file7,@RequestParam(required=false,value="file8") MultipartFile [] file8
			,@RequestParam(required=false,value="file9") MultipartFile [] file9,@RequestParam(required=false,value="file10") MultipartFile [] file10,@RequestParam(required=false,value="file11") MultipartFile [] file11,@RequestParam(required=false,value="file12") MultipartFile [] file12,@RequestParam(required=false,value="file13") MultipartFile [] file13
			,@RequestParam(required=false,value="file14") MultipartFile [] file14,@RequestParam(required=false,value="file15") MultipartFile [] file15,@RequestParam(required=false,value="file16") MultipartFile [] file16,@RequestParam(required=false,value="file17") MultipartFile [] file17,@RequestParam(required=false,value="file18") MultipartFile [] file18,HttpSession session,HttpServletResponse response) throws IllegalStateException, IOException{
		
		TimeUUID uuid=new TimeUUID();
		String id2=id+"2";
		String webApps=uuid.getWebAppFile();
		String path=webApps+id2;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		List<Accessory> list=new ArrayList<>();
		int num=0;
		if(file1.length>0){
			for(int i=0;i<file1.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file1[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ项目实际存档目");
				list.add(accessory);
			}
			num+=1;
		}
		if(file2.length>0){
			for(int i=0;i<file2.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file2[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file2[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ合同资料(合同原件提交经营部综合部)");
				list.add(accessory);
			}
			num+=1;
		}
		if(file3.length>0){
			for(int i=0;i<file3.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file3[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file3[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ科研申请书");
				list.add(accessory);
			}
			num+=1;
		}
		if(file4.length>0){
			for(int i=0;i<file4.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file4[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file4[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ工作大纲及评审记录");
				list.add(accessory);
			}
			num+=1;
		}
		if(file5.length>0){
			for(int i=0;i<file5.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file5[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file5[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ中间报告及评审记录");
				list.add(accessory);
			}
			num+=1;
		}
		if(file6.length>0){
			for(int i=0;i<file6.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file6[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file6[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ成果简介");
				list.add(accessory);
			}
			num+=1;
		}
		if(file7.length>0){
			for(int i=0;i<file7.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file7[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file7[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ研究报告(内容比较全面)");
				list.add(accessory);
			}
			num+=1;
		}
		if(file8.length>0){
			for(int i=0;i<file8.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file8[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file8[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ查新报告");
				list.add(accessory);
			}
			num+=1;
		}
		if(file9.length>0){
			for(int i=0;i<file9.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file9[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file9[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ总结报告");
				list.add(accessory);
			}
			num+=1;
		}
		if(file10.length>0){
			for(int i=0;i<file10.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file10[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file10[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ用户报告/应用证明");
				list.add(accessory);
			}
			num+=1;
		}
		if(file11.length>0){
			for(int i=0;i<file11.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file11[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file11[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ鉴定(评审)证书/验收评审意见");
				list.add(accessory);
			}
			num+=1;
		}
		if(file12.length>0){
			for(int i=0;i<file12.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file12[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file12[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ科研项目其他成果(指南、调查报告等)");
				list.add(accessory);
			}
			num+=1;
		}
		if(file13.length>0){
			for(int i=0;i<file13.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file13[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file13[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ汇报PPT");
				list.add(accessory);
			}
			num+=1;
		}
		if(file14.length>0){
			for(int i=0;i<file14.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file14[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file14[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ财务决算表");
				list.add(accessory);
			}
			num+=1;
		}
		if(file15.length>0){
			for(int i=0;i<file15.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file15[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file15[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ报奖文件");
				list.add(accessory);
			}
			num+=1;
		}
		if(file16.length>0){
			for(int i=0;i<file16.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file16[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file16[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ相关论文及专利");
				list.add(accessory);
			}
			num+=1;
		}
		if(file17.length>0){
			for(int i=0;i<file17.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file17[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file17[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ课题所用到图纸、模型和报告");
				list.add(accessory);
			}
			num+=1;
		}
		if(file18.length>0){
			for(int i=0;i<file18.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file18[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file18[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id2+File.separator+fileName);
				accessory.setaType("KJ其他");
				list.add(accessory);
			}
			num+=1;
		}
		int i=0;
		if(list.size()==0||list==null){
			i=-1;
		}else{
			i=aService.addAccessory(list);
			
		}
		return i;
		
	}
	
	@RequestMapping("/selectTechnicalDocumentationByno")
	@ResponseBody
	public TechnicalDocumentation selectTechnicalDocumentationById(String no){
		return service.selectTechnicalDocumentationById(no);
	}
	
	@RequestMapping("/deleteTechnicalDocumentation")
	@ResponseBody
	public int deleteTechnicalDocumentation(String id){
		return service.deleteTechnicalDocumentation(id);
	}

}

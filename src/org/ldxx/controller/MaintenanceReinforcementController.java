/**
 * <p>Title: MaintenanceReinforcementController.java</p>
 * <p>Description: 华通桥涵管理系统</p>
 * <p>Company: 环水信息技术有限公司</p>
 * @author 马潇霄
 * @version 1.0 创建时间：2018年11月8日 下午3:55:57
 */

package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.MaintenanceReinforcement;
import org.ldxx.service.AccessoryService;
import org.ldxx.service.MaintenanceReinforcementService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONObject;

/** 
* @ClassName: MaintenanceReinforcementController 
* @Description: 维护加固设计类
* @author zhaohui
* @date 2018年11月8日 下午3:55:57 
*  
*/
@Controller
@RequestMapping("/MaintenanceReinforcement")
public class MaintenanceReinforcementController {

	@Autowired
	private MaintenanceReinforcementService service;
	@Autowired
	private AccessoryService aService;
	
	@RequestMapping("/addMaintenanceReinforcement")
	@ResponseBody
	public Map<String,Object> addMaintenanceReinforcement(String tes,@RequestParam MultipartFile [] file1,@RequestParam MultipartFile [] file2,@RequestParam MultipartFile [] file3,
			@RequestParam MultipartFile [] file4,@RequestParam MultipartFile [] file5,@RequestParam MultipartFile [] file6,@RequestParam MultipartFile [] file7,@RequestParam MultipartFile [] file8,
			@RequestParam MultipartFile [] file9,@RequestParam MultipartFile [] file10,@RequestParam MultipartFile [] file11,@RequestParam MultipartFile [] file12,@RequestParam MultipartFile [] file13,
			@RequestParam MultipartFile [] file14,@RequestParam MultipartFile [] file15,@RequestParam MultipartFile [] file16,@RequestParam MultipartFile [] file17,@RequestParam MultipartFile [] file18,
			@RequestParam MultipartFile [] file19,@RequestParam MultipartFile [] file20) throws IllegalStateException, IOException{
		Map<String,Object> map =new HashMap<>();
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
		JSONObject jsonObject=JSONObject.fromObject(tes);
		MaintenanceReinforcement mr=(MaintenanceReinforcement)JSONObject.toBean(jsonObject, MaintenanceReinforcement.class,map2);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		mr.setMrId(id);
		String path="D:"+File.separator+"oa"+File.separator+"MaintenanceReinforcement"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file1.length>0){
			List<Accessory> acc = mr.getAccessory1();
			for(int i=0;i<file1.length;i++){
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file1[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			mr.setAccessory1(acc);
		}
		if(file2.length>0){
			List<Accessory> acc = mr.getAccessory2();
			for(int i=0;i<file2.length;i++){
				String fileName=file2[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file2[i].transferTo(f1);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			mr.setAccessory2(acc);
		}
		if(file3.length>0){
			List<Accessory> acc = mr.getAccessory3();
			for(int i=0;i<file3.length;i++){
				String fileName=file3[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f3=new File(filePath);
				file3[i].transferTo(f3);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			mr.setAccessory3(acc);
		}
		if(file4.length>0){
			List<Accessory> acc = mr.getAccessory4();
			for(int i=0;i<file4.length;i++){
				String fileName=file4[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f4=new File(filePath);
				file4[i].transferTo(f4);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			mr.setAccessory4(acc);
		}
		if(file5.length>0){
			List<Accessory> acc = mr.getAccessory5();
			for(int i=0;i<file5.length;i++){
				String fileName=file5[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f5=new File(filePath);
				file5[i].transferTo(f5);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			mr.setAccessory5(acc);
		}
		if(file6.length>0){
			List<Accessory> acc = mr.getAccessory6();
			for(int i=0;i<file6.length;i++){
				String fileName=file6[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f6=new File(filePath);
				file6[i].transferTo(f6);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			mr.setAccessory6(acc);
		}
		if(file7.length>0){
			List<Accessory> acc = mr.getAccessory7();
			for(int i=0;i<file7.length;i++){
				String fileName=file7[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f7=new File(filePath);
				file7[i].transferTo(f7);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			mr.setAccessory7(acc);
		}
		if(file8.length>0){
			List<Accessory> acc = mr.getAccessory8();
			for(int i=0;i<file8.length;i++){
				String fileName=file8[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f8=new File(filePath);
				file8[i].transferTo(f8);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			mr.setAccessory8(acc);
		}
		if(file9.length>0){
			List<Accessory> acc = mr.getAccessory9();
			for(int i=0;i<file9.length;i++){
				String fileName=file9[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f9=new File(filePath);
				file9[i].transferTo(f9);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			mr.setAccessory9(acc);
		}
		if(file10.length>0){
			List<Accessory> acc = mr.getAccessory10();
			for(int i=0;i<file10.length;i++){
				String fileName=file10[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f10=new File(filePath);
				file10[i].transferTo(f10);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			mr.setAccessory10(acc);
		}
		if(file11.length>0){
			List<Accessory> acc = mr.getAccessory11();
			for(int i=0;i<file11.length;i++){
				String fileName=file11[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f11=new File(filePath);
				file11[i].transferTo(f11);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			mr.setAccessory11(acc);
		}
		if(file12.length>0){
			List<Accessory> acc = mr.getAccessory12();
			for(int i=0;i<file12.length;i++){
				String fileName=file12[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f12=new File(filePath);
				file12[i].transferTo(f12);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			mr.setAccessory12(acc);
		}
		if(file13.length>0){
			List<Accessory> acc = mr.getAccessory13();
			for(int i=0;i<file13.length;i++){
				String fileName=file13[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f13=new File(filePath);
				file13[i].transferTo(f13);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			mr.setAccessory13(acc);
		}
		if(file14.length>0){
			List<Accessory> acc = mr.getAccessory14();
			for(int i=0;i<file14.length;i++){
				String fileName=file14[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f14=new File(filePath);
				file14[i].transferTo(f14);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			mr.setAccessory14(acc);
		}
		if(file15.length>0){
			List<Accessory> acc = mr.getAccessory15();
			for(int i=0;i<file15.length;i++){
				String fileName=file15[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f15=new File(filePath);
				file15[i].transferTo(f15);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			mr.setAccessory15(acc);
		}
		if(file16.length>0){
			List<Accessory> acc = mr.getAccessory16();
			for(int i=0;i<file16.length;i++){
				String fileName=file16[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f16=new File(filePath);
				file16[i].transferTo(f16);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			mr.setAccessory16(acc);
		}
		if(file17.length>0){
			List<Accessory> acc = mr.getAccessory17();
			for(int i=0;i<file17.length;i++){
				String fileName=file17[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f17=new File(filePath);
				file17[i].transferTo(f17);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			mr.setAccessory17(acc);
		}
		if(file18.length>0){
			List<Accessory> acc = mr.getAccessory18();
			for(int i=0;i<file18.length;i++){
				String fileName=file18[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f18=new File(filePath);
				file18[i].transferTo(f18);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			mr.setAccessory18(acc);
		}
		if(file19.length>0){
			List<Accessory> acc = mr.getAccessory19();
			for(int i=0;i<file19.length;i++){
				String fileName=file19[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f19=new File(filePath);
				file19[i].transferTo(f19);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			mr.setAccessory19(acc);
		}
		if(file20.length>0){
			List<Accessory> acc = mr.getAccessory20();
			for(int i=0;i<file20.length;i++){
				String fileName=file20[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f20=new File(filePath);
				file20[i].transferTo(f20);
				for(int j=0;j<acc.size();j++){
					acc.get(j).setaId(id);
					acc.get(j).setAcName(fileName);
					acc.get(j).setAcUrl(filePath);
					String atype=acc.get(j).getaDesc();
					acc.get(j).setaDesc(atype);
				}
			}
			mr.setAccessory20(acc);
		}
		int i=service.addMaintenanceReinforcement(mr);
		map.put("result", i);
		map.put("mr", mr);
		return map;
	}
	
	@RequestMapping("/selectAllMaintenanceReinforcement")
	@ResponseBody
	public List<MaintenanceReinforcement> selectAllMaintenanceReinforcement(){
		List<MaintenanceReinforcement> list=service.selectAllMaintenanceReinforcement();
		return list;
	}
	
	@RequestMapping("/selectAccessory")
	@ResponseBody
	public MaintenanceReinforcement selectAccessory(String id){
		MaintenanceReinforcement mr=new MaintenanceReinforcement();
		List<Accessory> acc=aService.selectAccessoryByIdAndType(id,"项目实际存档目录");
		List<Accessory> acc2=aService.selectAccessoryByIdAndType(id,"项目特点介绍、关键词");
		List<Accessory> acc3=aService.selectAccessoryByIdAndType(id,"招投标文件");
		List<Accessory> acc4=aService.selectAccessoryByIdAndType(id,"合同资料");
		List<Accessory> acc5=aService.selectAccessoryByIdAndType(id,"初设阶段-图纸");
		List<Accessory> acc6=aService.selectAccessoryByIdAndType(id,"初设阶段-概算书");
		List<Accessory> acc7=aService.selectAccessoryByIdAndType(id,"初设阶段-审查意见");
		List<Accessory> acc8=aService.selectAccessoryByIdAndType(id,"初设阶段-校审单");
		List<Accessory> acc9=aService.selectAccessoryByIdAndType(id,"初设阶段-相关单位往来函、文");
		List<Accessory> acc10=aService.selectAccessoryByIdAndType(id,"施工图阶段-初设、方案批文");
		List<Accessory> acc11=aService.selectAccessoryByIdAndType(id,"施工图阶段-图纸");
		List<Accessory> acc12=aService.selectAccessoryByIdAndType(id,"施工图阶段-结构模型、计算书");
		List<Accessory> acc13=aService.selectAccessoryByIdAndType(id,"施工图阶段-依据图纸和报告");
		List<Accessory> acc14=aService.selectAccessoryByIdAndType(id,"施工图阶段-审查意见");
		List<Accessory> acc15=aService.selectAccessoryByIdAndType(id,"施工图阶段-校审单");
		List<Accessory> acc16=aService.selectAccessoryByIdAndType(id,"施工图阶段-施工交底记录及回复");
		List<Accessory> acc17=aService.selectAccessoryByIdAndType(id,"施工图阶段-设计变更资料");
		List<Accessory> acc18=aService.selectAccessoryByIdAndType(id,"施工图阶段-重点项目的项目总结");
		List<Accessory> acc19=aService.selectAccessoryByIdAndType(id,"施工图阶段-相关单位往来函、文");
		List<Accessory> acc20=aService.selectAccessoryByIdAndType(id,"施工图阶段-重点项目质量流程内部控制文件");
		mr.setAccessory1(acc);
		mr.setAccessory2(acc2);
		mr.setAccessory3(acc3);
		mr.setAccessory4(acc4);
		mr.setAccessory5(acc5);
		mr.setAccessory6(acc6);
		mr.setAccessory7(acc7);
		mr.setAccessory8(acc8);
		mr.setAccessory9(acc9);
		mr.setAccessory10(acc10);
		mr.setAccessory11(acc11);
		mr.setAccessory12(acc12);
		mr.setAccessory13(acc13);
		mr.setAccessory14(acc14);
		mr.setAccessory15(acc15);
		mr.setAccessory16(acc16);
		mr.setAccessory17(acc17);
		mr.setAccessory18(acc18);
		mr.setAccessory19(acc19);
		mr.setAccessory20(acc20);
		return mr;
	}
	
	@RequestMapping("/deleteMr")
	@ResponseBody
	public int deleteMr(String id){
		int i=service.deleteMr(id);
		return i;
	}
	
}

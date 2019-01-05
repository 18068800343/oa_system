package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.Cooperator;
import org.ldxx.bean.Enterprise;
import org.ldxx.bean.ManagingDocuments;
import org.ldxx.bean.PrjWorkingHoursP;
import org.ldxx.dao.CooperatorDao;
import org.ldxx.service.CooperatorService;
import org.ldxx.service.EnterpriseService;
import org.ldxx.util.ExportData;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONObject;

/** 
* @ClassName: CooperatorController 
* @Description: 合作单位管理
* @author ailun
* @date 2018年8月13日 下午4:02:28 
*  
*/

@RequestMapping("cooperator")
@Controller
public class CooperatorController {

	@Autowired
	private CooperatorService cservice;
	@Autowired
	private EnterpriseService eService;
	@Autowired
	private CooperatorDao cDao;
	
	
	@RequestMapping("/addCooperator")
	@ResponseBody
	public  Map<String,Object> addCooperator(String xindanwei,@RequestParam MultipartFile [] file1,@RequestParam MultipartFile [] file2,
			@RequestParam MultipartFile [] file3,@RequestParam MultipartFile [] file4) throws IllegalStateException, IOException{
		Map<String,Object> map = new HashMap<>();
		Map<String,Class> map2=new HashMap<>();
		map2.put("enterprise", Enterprise.class);
		map2.put("accessory1", Accessory.class);
		map2.put("accessory2", Accessory.class);
		map2.put("accessory3", Accessory.class);
		map2.put("accessory4", Accessory.class);
		JSONObject jsonObject=JSONObject.fromObject(xindanwei);
		Cooperator Co=(Cooperator)JSONObject.toBean(jsonObject, Cooperator.class,map2);
		//Cooperator Co=cooperator.get(0);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		Co.setCcId(id);
		String path="D:"+File.separator+"oa"+File.separator+"cooperator"+File.separator+id;;
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
				accessory.setAcUrl(filePath);
				accessory.setaType("营业执照");
				list.add(accessory);
			}
			Co.setAccessory1(list);
		}
		if(file2.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file2.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file2[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[i].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("完税证明");
				list.add(accessory);
			}
			Co.setAccessory2(list);
		}
		if(file3.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file3.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file3[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f3=new File(filePath);
				file3[i].transferTo(f3);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("安全生产许可证");
				list.add(accessory);
			}
			Co.setAccessory3(list);
		}
		if(file4.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file4.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file4[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f4=new File(filePath);
				file4[i].transferTo(f4);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("资质证书");
				list.add(accessory);
			}
			Co.setAccessory4(list);
		}
		
		int i=cservice.addCooperator(Co);
		map.put("result", i);
		map.put("Cooperator", Co);
		return map;
	}
	
	
	@RequestMapping("/deleteCooperator")
	@ResponseBody
	public int deleteCooperator(String id){
		return cservice.deleteCooperator(id);
	}
	
	
	@RequestMapping("/updateCooperator")
	@ResponseBody
	public Map<String,Object> updateCooperator(String xiugaixindanwei,@RequestParam MultipartFile [] file1,@RequestParam MultipartFile [] file2,
			@RequestParam MultipartFile [] file3,@RequestParam MultipartFile [] file4) throws IllegalStateException, IOException{
		Map<String,Object> map = new HashMap<>();
		Map<String,Class> map2=new HashMap<>();
		map2.put("enterprise", Enterprise.class);
		map2.put("accessory1", Accessory.class);
		map2.put("accessory2", Accessory.class);
		map2.put("accessory3", Accessory.class);
		map2.put("accessory4", Accessory.class);
		JSONObject jsonObject=JSONObject.fromObject(xiugaixindanwei);
		Cooperator Co=(Cooperator)JSONObject.toBean(jsonObject, Cooperator.class,map2);
		String id = Co.getCcId();
		//Cooperator Co=cooperator.get(0);
		String path="D:"+File.separator+"oa"+File.separator+"cooperator"+File.separator+id;;
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
				accessory.setAcUrl(filePath);
				accessory.setaType("营业执照");
				list.add(accessory);
			}
			Co.setAccessory1(list);
		}
		if(file2.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file2.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file2[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[i].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("完税证明");
				list.add(accessory);
			}
			Co.setAccessory2(list);
		}
		if(file3.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file3.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file3[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f3=new File(filePath);
				file3[i].transferTo(f3);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("安全生产许可证");
				list.add(accessory);
			}
			Co.setAccessory3(list);
		}
		if(file4.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file4.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file4[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f4=new File(filePath);
				file4[i].transferTo(f4);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("资质证书");
				list.add(accessory);
			}
			Co.setAccessory4(list);
		}
		int i=cservice.updateCooperator(Co);
		map.put("result", i);
		map.put("Cooperator", Co);
		return map;
	}
	
	@RequestMapping("/selectAllCooperator")
	@ResponseBody
	public List<Cooperator> selectAllCooperator(){
		return cservice.selectAllCooperator();
	}
	
	@RequestMapping("/selectOneCooperator")
	@ResponseBody
	public Cooperator selectOneCooperator(String id){
		return cservice.selectOneCooperator(id);
	}
	
	@RequestMapping("/exportCooperator")
	@ResponseBody
	public void exportCooperator(HttpServletResponse response) throws Exception{
		String xlsName = "合作单位信息表";  
		ExportData exportData=new ExportData();
		List<Cooperator> cooperator=cservice.selectAllCooperator();
		 List<List<String>> dataList=new ArrayList<>();
		for(int i=0;i<cooperator.size();i++){
			List<String> data=new ArrayList<>();
			data.add(i+1+"");
			data.add(cooperator.get(i).getCcName());
			data.add(cooperator.get(i).getCcType());
			data.add(cooperator.get(i).getCreditCode());
			data.add(cooperator.get(i).getBankNo());
			data.add(cooperator.get(i).getBankName());
			data.add(cooperator.get(i).getBusinessLicense());
			data.add(cooperator.get(i).getBusinessLicenseTime());
			data.add(cooperator.get(i).getLegalPersonName());
			data.add(cooperator.get(i).getEnterpriseType());
			data.add(cooperator.get(i).getEnterpriseAddr());
			data.add(cooperator.get(i).getEnterpriseFax());
			data.add(cooperator.get(i).getEnterpriseEmail());
			data.add("sss");
			dataList.add(data);
		}
		String [] array={"编号","企业名称","类型","社会统一信用代码","银行账户","开户行","营业执照","营业执照有效期","法人姓名","企业性质","地址","传真","电子邮件","企业评级"};
	        exportData.ExportWithResponse(xlsName,xlsName,  
	        		array.length, array, dataList, response);
	}
	
	
	@RequestMapping("/selectCooperatorIdAndName")
	@ResponseBody
	public List<Cooperator> selectCooperatorIdAndName(){
		List<Cooperator> list=cservice.selectCooperatorIdAndName();
		return list;
	}
	@RequestMapping("/selectCooperatorIdAndNameByCcType")
	@ResponseBody
	public List<Cooperator> selectCooperatorIdAndNameByCcType(String ccType){
		List<Cooperator> list=cDao.selectCooperatorIdAndNameByCcType(ccType);
		return list;
	}
	
	@RequestMapping("/selectCooperatorById")
	@ResponseBody
	public Cooperator selectCooperatorById(String id){
		Cooperator list=cservice.selectOneCooperator(id);
		List<Enterprise> ent=eService.selectEnterpriseById(id);
		list.setEnterprise(ent);
		return list;
	}
	
	
	@RequestMapping("/countOfEnterprise")//先判断该公司下该联系人是否存在，不存在就添加
	@ResponseBody
	public int countOfEnterprise(Enterprise etel){
		return eService.countOfEnterprise(etel);
	}
	
}

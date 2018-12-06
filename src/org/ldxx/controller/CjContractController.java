package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.CjSplitMoney;
import org.ldxx.bean.PrjWorkingHours;
import org.ldxx.bean.PrjWorkingHoursP;
import org.ldxx.service.CjContractService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("cj")
public class CjContractController {

	@Autowired
	private CjContractService service;
	
	@RequestMapping("/addCjContractBySave")
	@ResponseBody
	public int addCjContractBySave(String cjContract,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2) throws IllegalStateException, IOException{
		Map<String,Class> map=new HashMap<>();
		map.put("cjSplitMoney", CjSplitMoney.class);
		JSONObject jsonObject=JSONObject.fromObject(cjContract);
		CjContract cj=(CjContract)JSONObject.toBean(jsonObject, CjContract.class,map);
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cj.setCjId(id);
		int count=service.countNo();
		String code="CJ"+uuid.getPrjCode("", count+1);
		cj.setContractNo(code);
		String path="D:"+File.separator+"oa"+File.separator+"CjContract"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[ii].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("承接合同文本");
				list.add(accessory);
			}
			cj.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int ii=0;ii<file2.length;ii++){
				Accessory accessory2=new Accessory();
				String fileName=file2[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[ii].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(filePath);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			cj.setAccessory2(list2);
		}
		int i=service.addCjContract(cj);
		return i;
	}
	
	
	@RequestMapping("/addCjContractBySubmit")
	@ResponseBody
	public int addCjContractBySubmit(String cjContract,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2) throws IllegalStateException, IOException{
		Map<String,Class> map=new HashMap<>();
		map.put("cjSplitMoney", CjSplitMoney.class);
		JSONObject jsonObject=JSONObject.fromObject(cjContract);
		CjContract cj=(CjContract)JSONObject.toBean(jsonObject, CjContract.class,map);
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cj.setCjId(id);
		int count=service.countNo();
		String code="CJ"+uuid.getPrjCode("", count+1);
		cj.setContractNo(code);
		String path="D:"+File.separator+"oa"+File.separator+"CjContract"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[ii].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("承接合同文本");
				list.add(accessory);
			}
			cj.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int ii=0;ii<file2.length;ii++){
				Accessory accessory2=new Accessory();
				String fileName=file2[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[ii].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(filePath);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			cj.setAccessory2(list2);
		}
		int i=service.addCjContract(cj);
		return i;
	}
	
	@RequestMapping("/selectCjContractByStatus")
	@ResponseBody
	public List<CjContract> selectCjContractByStatus(String status){
		List<CjContract> list=service.selectCjContractByStatus(status);
		return list;
	}
	
	@RequestMapping("/selectIdAndName")
	@ResponseBody
	public List<CjContract> selectIdAndName(){
		List<CjContract> list=service.selectIdAndName();
		return list;
	}
	
	@RequestMapping("/selectContractNoById")
	@ResponseBody
	public List<CjContract> selectContractNoById(String id){
		List<CjContract> list=service.selectContractNoById(id);
		return list;
	}
	
	@RequestMapping("/selectCjHistory")
	@ResponseBody
	public List<CjContract> selectCjHistory(String no){
		List<CjContract> list=service.selectCjHistory(no);
		return list;
	}
	
	@RequestMapping("/selectContractByTaskNo")
	@ResponseBody
	public List<CjContract> selectContractByTaskNo(String no){
		List<CjContract> list=service.selectContractByTaskNo(no);
		return list;
	}
	
	@RequestMapping("/selectCjByName")
	@ResponseBody
	public List<CjContract> selectCjByName(String name){
		List<CjContract> list=service.selectCjByName(name);
		return list;
	}
	
	@RequestMapping("/selectCjByNo")
	@ResponseBody
	public List<CjContract> selectCjByNo(String no){
		List<CjContract> list=service.selectCjByNo(no);
		return list;
	}
	
	@RequestMapping("/updateCjContractBySave")
	@ResponseBody
	public int updateCjContractBySave(String cjContract,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2) throws IllegalStateException, IOException{
		Map<String,Class> map=new HashMap<>();
		map.put("cjSplitMoney", CjSplitMoney.class);
		JSONObject jsonObject=JSONObject.fromObject(cjContract);
		CjContract cj=(CjContract)JSONObject.toBean(jsonObject, CjContract.class,map);
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cj.setCjId(id);
		String path="D:"+File.separator+"oa"+File.separator+"CjContract"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[ii].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("承接合同文本");
				list.add(accessory);
			}
			cj.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int ii=0;ii<file2.length;ii++){
				Accessory accessory2=new Accessory();
				String fileName=file2[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[ii].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(filePath);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			cj.setAccessory2(list2);
		}
		int i=service.addCjContract(cj);
		return i;
	}
	
	@RequestMapping("/updateCjContractBySubmit")
	@ResponseBody
	public int updateCjContractBySubmit(String cjContract,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file2) throws IllegalStateException, IOException{
		Map<String,Class> map=new HashMap<>();
		map.put("cjSplitMoney", CjSplitMoney.class);
		JSONObject jsonObject=JSONObject.fromObject(cjContract);
		CjContract cj=(CjContract)JSONObject.toBean(jsonObject, CjContract.class,map);
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cj.setCjId(id);
		String path="D:"+File.separator+"oa"+File.separator+"CjContract"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[ii].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("承接合同文本");
				list.add(accessory);
			}
			cj.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int ii=0;ii<file2.length;ii++){
				Accessory accessory2=new Accessory();
				String fileName=file2[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[ii].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(filePath);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			cj.setAccessory2(list2);
		}
		int i=service.addCjContract(cj);
		return i;
	}
	
	@RequestMapping("/selectNameAndNo")//初始化承接合同名和合同号
	@ResponseBody
	public List<CjContract> selectNameAndNo(){
		List<CjContract> list=service.selectNameAndNo();
		return list;
	}
	
	@RequestMapping("/selectCjContractByName")//通过承接合同名查询合同号、项目名以及任务单号
	@ResponseBody
	public CjContract selectCjContractByName(String name){
		return service.selectCjContractByName(name);
	}
	
	@RequestMapping("/selectCjContractByNo")//通过合同号查询承接合同名、项目名以及任务单号
	@ResponseBody
	public CjContract selectCjContractByNo(String no){
		return service.selectCjContractByNo(no);
	}
	
	@RequestMapping("/selectCjContractByTaskNo")//通过任务单号查询承接合同
	@ResponseBody
	public List<CjContract> selectCjContractByTaskNo(String no){
		String code="%"+no+"%";
		return service.selectCjContractByTaskNo(code);
	}
	
	@RequestMapping("/selectCjByCjNo")//通过承接编号查询承接合同详细信息
	@ResponseBody
	public CjContract selectCjByCjNo(String no){
		return service.selectCjByCjNo(no);
	}
	
}

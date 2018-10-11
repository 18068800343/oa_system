package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ContractWork;
import org.ldxx.bean.Enterprise;
import org.ldxx.service.AccessoryService;
import org.ldxx.service.ContractWorkService;
import org.ldxx.service.EnterpriseService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("work")
public class ContractWorkController {

	@Autowired
	private ContractWorkService service;
	
	@Autowired
	private EnterpriseService eservice;
	
	@Autowired
	private AccessoryService aservice;
	
	@RequestMapping("/addContractWorkBySave")
	@ResponseBody
	public int addContractWorkBySave( String work,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("enterprise", Enterprise.class);
		
		JSONObject jsonObject=JSONObject.fromObject(work);
		ContractWork cwork=(ContractWork)JSONObject.toBean(jsonObject, ContractWork.class,classMap);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cwork.setCwId(id);
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String path="D:"+File.separator+"oa"+File.separator+"ContractWork"+File.separator+id;
				File f=new File(path);
				if(!f.exists()){
					f.mkdirs();
				}
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[ii].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				list.add(accessory);
			}
			cwork.setAccessory(list);
		}
		int i=service.addContractWork(cwork);
		return i;
	}
	
	@RequestMapping("/addContractWorkBySubmit")
	@ResponseBody
	public int addContractWorkBySubmit(String work,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("enterprise", Enterprise.class);
		
		JSONObject jsonObject=JSONObject.fromObject(work);
		ContractWork cwork=(ContractWork)JSONObject.toBean(jsonObject, ContractWork.class,classMap);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cwork.setCwId(id);
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String path="D:"+File.separator+"oa"+File.separator+"ContractWork"+File.separator+id;
				File f=new File(path);
				if(!f.exists()){
					f.mkdirs();
				}
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[ii].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				list.add(accessory);
			}
			cwork.setAccessory(list);
		}
		int i=service.addContractWork(cwork);
		return i;
	}
	
	@RequestMapping("/selectContractWork")
	@ResponseBody
	public List<ContractWork> selectContractWork(String type){
		List<ContractWork> list=service.selectContractWork(type);
		return list;
	}
	
	@RequestMapping("/selectDepartmentAndPerson")
	@ResponseBody
	public Map<String,Object> selectDepartmentAndPerson(String id){
		Map<String,Object> map =new HashMap<>();
		List<Enterprise> enterprise=eservice.selectEnterpriseById(id);
		List<Accessory> accessory=aservice.selectAccessoryById(id);
		map.put("enterprise", enterprise);
		map.put("accessory", accessory);
		return map;
	}
	
	@RequestMapping("/addContractWork2BySave")
	@ResponseBody
	public int addContractWork2BySave( String work,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("enterprise", Enterprise.class);
		
		JSONObject jsonObject=JSONObject.fromObject(work);
		ContractWork cwork=(ContractWork)JSONObject.toBean(jsonObject, ContractWork.class,classMap);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cwork.setCwId(id);
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String path="D:"+File.separator+"oa"+File.separator+"ContractWork"+File.separator+id;
				File f=new File(path);
				if(!f.exists()){
					f.mkdirs();
				}
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[ii].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				list.add(accessory);
			}
			cwork.setAccessory(list);
		}
		int i=service.addContractWork(cwork);
		return i;
	}
	
	@RequestMapping("/addContractWork2BySubmit")
	@ResponseBody
	public int addContractWork2BySubmit(String work,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("enterprise", Enterprise.class);
		
		JSONObject jsonObject=JSONObject.fromObject(work);
		ContractWork cwork=(ContractWork)JSONObject.toBean(jsonObject, ContractWork.class,classMap);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cwork.setCwId(id);
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String path="D:"+File.separator+"oa"+File.separator+"ContractWork"+File.separator+id;
				File f=new File(path);
				if(!f.exists()){
					f.mkdirs();
				}
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[ii].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				list.add(accessory);
			}
			cwork.setAccessory(list);
		}
		int i=service.addContractWork(cwork);
		return i;
	}
	
	@RequestMapping("/addContractWork3BySave")
	@ResponseBody
	public int addContractWork3BySave( String work,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("enterprise", Enterprise.class);
		
		JSONObject jsonObject=JSONObject.fromObject(work);
		ContractWork cwork=(ContractWork)JSONObject.toBean(jsonObject, ContractWork.class,classMap);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cwork.setCwId(id);
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String path="D:"+File.separator+"oa"+File.separator+"ContractWork"+File.separator+id;
				File f=new File(path);
				if(!f.exists()){
					f.mkdirs();
				}
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[ii].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				list.add(accessory);
			}
			cwork.setAccessory(list);
		}
		int i=service.addContractWork(cwork);
		return i;
	}
	
	@RequestMapping("/addContractWork3BySubmit")
	@ResponseBody
	public int addContractWork3BySubmit(String work,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("enterprise", Enterprise.class);
		
		JSONObject jsonObject=JSONObject.fromObject(work);
		ContractWork cwork=(ContractWork)JSONObject.toBean(jsonObject, ContractWork.class,classMap);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cwork.setCwId(id);
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String path="D:"+File.separator+"oa"+File.separator+"ContractWork"+File.separator+id;
				File f=new File(path);
				if(!f.exists()){
					f.mkdirs();
				}
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[ii].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				list.add(accessory);
			}
			cwork.setAccessory(list);
		}
		int i=service.addContractWork(cwork);
		return i;
	}
	
}

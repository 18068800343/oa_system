package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CjContract;
import org.ldxx.service.CjContractService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("cj")
public class CjContractController {

	@Autowired
	private CjContractService service;
	
	@RequestMapping("/addCjContractBySave")
	@ResponseBody
	public int addCjContractBySave(CjContract cj,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cj.setCjId(id);
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String path="D:"+File.separator+"oa"+File.separator+"CjContract"+File.separator+id;
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
			cj.setAccessory(list);
		}
		int i=service.addCjContract(cj);
		return i;
	}
	
	
	@RequestMapping("/addCjContractBySubmit")
	@ResponseBody
	public int addCjContractBySubmit(CjContract cj,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cj.setCjId(id);
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String path="D:"+File.separator+"oa"+File.separator+"CjContract"+File.separator+id;
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
			cj.setAccessory(list);
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
	public int updateCjContractBySave(CjContract cj,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cj.setCjId(id);
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String path="D:"+File.separator+"oa"+File.separator+"CjContract"+File.separator+id;
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
			cj.setAccessory(list);
		}
		int i=service.addCjContract(cj);
		return i;
	}
	
	@RequestMapping("/updateCjContractBySubmit")
	@ResponseBody
	public int updateCjContractBySubmit(CjContract cj,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cj.setCjId(id);
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String path="D:"+File.separator+"oa"+File.separator+"CjContract"+File.separator+id;
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
			cj.setAccessory(list);
		}
		int i=service.addCjContract(cj);
		return i;
	}
}

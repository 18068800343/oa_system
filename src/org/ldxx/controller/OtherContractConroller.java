package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.OtherContract;
import org.ldxx.service.OtherContractService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("other")
public class OtherContractConroller {

	@Autowired
	private OtherContractService service;
	
	@RequestMapping("/addOtherContractBySave")
	@ResponseBody
	public int addOtherContractBySave(OtherContract other,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		other.setoId(id);
		int count=service.countNo();
		String type="";
		String code="QT"+uuid.getPrjCode(type, count+1);
		other.setContractCode(code);
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String path="D:"+File.separator+"oa"+File.separator+"OtherContract"+File.separator+id;
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
			other.setAccessory(list);
		}
		int i=service.addOtherContract(other);
		return i;
	}
	
	@RequestMapping("/addOtherContractBySubmit")
	@ResponseBody
	public int addOtherContractBySubmit(OtherContract other,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		other.setoId(id);
		int count=service.countNo();
		String type="";
		String code="QT"+uuid.getPrjCode(type, count+1);
		other.setContractCode(code);
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String path="D:"+File.separator+"oa"+File.separator+"OtherContract"+File.separator+id;
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
			other.setAccessory(list);
		}
		int i=service.addOtherContract(other);
		return i;
	}
	
	@RequestMapping("/updateOtherContractBySave")
	@ResponseBody
	public int updateOtherContractBySave(OtherContract other,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		other.setoId(id);
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String path="D:"+File.separator+"oa"+File.separator+"OtherContract"+File.separator+id;
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
			other.setAccessory(list);
		}
		int i=service.addOtherContract(other);
		return i;
	}
	
	@RequestMapping("/updateOtherContractBySubmit")
	@ResponseBody
	public int updateOtherContractBySubmit(OtherContract other,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		other.setoId(id);
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String path="D:"+File.separator+"oa"+File.separator+"OtherContract"+File.separator+id;
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
			other.setAccessory(list);
		}
		int i=service.addOtherContract(other);
		return i;
	}
	
	@RequestMapping("/selectOtherContract")
	@ResponseBody
	public List<OtherContract> selectOtherContract(String status){
		return service.selectOtherContract(status);
	}
	
	@RequestMapping("/selectCjHistory")
	@ResponseBody
	public List<OtherContract> selectCjHistory(String no){
		return service.selectCjHistory(no);
	}
}

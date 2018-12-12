package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.FbContractOver;
import org.ldxx.service.FbContractOverService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
/**
 * 分包结算申请
 * @author hp
 *
 */
@Controller
@RequestMapping("fbOver")
public class FbContractOverController {

	@Autowired
	private FbContractOverService service;
	
	@RequestMapping("/addFbContractOverBySave")
	@ResponseBody
	public int addFbContractOverBySave(FbContractOver fbContractOver,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file1) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		fbContractOver.setFcoId(id);
		String path="D:"+File.separator+"oa"+File.separator+"fbContractOver"+File.separator+id;
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
				accessory.setaType("合同文本");
				list.add(accessory);
			}
			fbContractOver.setAccessory(list);
		}
		if(file1.length>0){
			List<Accessory> list1=new ArrayList<>();
			for(int ii=0;ii<file1.length;ii++){
				Accessory accessory1=new Accessory();
				String fileName=file1[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file1[ii].transferTo(f2);
				accessory1.setaId(id);
				accessory1.setAcName(fileName);
				accessory1.setAcUrl(filePath);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			fbContractOver.setAccessory2(list1);
		}
		int i=service.addFbContractOver(fbContractOver);
		return i;
	}
	
	@RequestMapping("/addFbContractOverBySubmit")
	@ResponseBody
	public int addFbContractOverBySubmit(FbContractOver fbContractOver,@RequestParam MultipartFile [] file,@RequestParam MultipartFile [] file1) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		fbContractOver.setFcoId(id);
		String path="D:"+File.separator+"oa"+File.separator+"fbContractOver"+File.separator+id;
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
				accessory.setaType("合同文本");
				list.add(accessory);
			}
			fbContractOver.setAccessory(list);
		}
		if(file1.length>0){
			List<Accessory> list1=new ArrayList<>();
			for(int ii=0;ii<file1.length;ii++){
				Accessory accessory1=new Accessory();
				String fileName=file1[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file1[ii].transferTo(f2);
				accessory1.setaId(id);
				accessory1.setAcName(fileName);
				accessory1.setAcUrl(filePath);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			fbContractOver.setAccessory2(list1);
		}
		int i=service.addFbContractOver(fbContractOver);
		return i;
	}
	
	@RequestMapping("/selectFbContractOver")
	@ResponseBody
	public List<FbContractOver> selectFbContractOver(String state){
		return service.selectFbContractOver(state);
	}
}

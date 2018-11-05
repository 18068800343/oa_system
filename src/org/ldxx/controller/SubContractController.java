package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.FbContract;
import org.ldxx.service.SubContractService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
/**
 * 分包合同管理
 * @author hp
 *
 */
@RequestMapping("subcontract")
@Controller
public class SubContractController {

	@Autowired
	private SubContractService scService;
	
	@RequestMapping("/selectSubContract")
	@ResponseBody
	public List<FbContract> selectSubContract(String status){
		return scService.selectSubContract(status);
	}
	
	@RequestMapping("/saveSubContract")//保存
	@ResponseBody
	public Map<String,Object> saveSubContract(FbContract fbContract,@RequestParam("file")MultipartFile file[],@RequestParam("file1")MultipartFile file1[]) throws IllegalStateException, IOException{
		Map<String,Object> map = new HashMap<>();
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		fbContract.setFbId(id);
		
		String type = fbContract.getFbcType();
		String code = type.split(" ")[0];
		int count=scService.fbNocount();
		count=count+1;
		String fbNo=uuid.getPrjCode(code, count);
		fbNo="FB"+fbNo;
		fbContract.setFbNo(fbNo);	
		
		String path = "D:"+File.separator+"oa"+File.separator+"subcontract";
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				String filename = file[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("分包合同文本");
				list.add(accessory);
			}
			fbContract.setAccessory(list);
		}
		if(file1.length>0){
			List<Accessory> list1 = new ArrayList<>();
			for(int i=0;i<file1.length;i++){
				Accessory accessory1=new Accessory();
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file1[i].transferTo(f1);
				accessory1.setaId(id);
				accessory1.setAcName(fileName);
				accessory1.setAcUrl(filePath);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			fbContract.setAccessory1(list1);
		}
		int i=scService.saveSubContract(fbContract);
		map.put("result", i);
		map.put("fbContract", fbContract);
		return map;
	}
	
	@RequestMapping("/submitSubContract")//提交
	@ResponseBody
	public Map<String,Object> submitSubContract(FbContract fbContract,@RequestParam("file")MultipartFile file[],@RequestParam("file1")MultipartFile file1[]) throws IllegalStateException, IOException{
		Map<String,Object> map = new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		fbContract.setFbId(id);
		
		String type = fbContract.getFbcType();
		String code = type.split(" ")[0];
		int count=scService.fbNocount();
		count=count+1;
		String fbNo=uuid.getPrjCode(code, count);
		fbNo="FB"+fbNo;
		fbContract.setFbNo(fbNo);
		
		String path = "D:"+File.separator+"oa"+File.separator+"subcontract";
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				String filename = file[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("分包合同文本");
				list.add(accessory);
			}
			fbContract.setAccessory(list);
		}
		if(file1.length>0){
			List<Accessory> list1 = new ArrayList<>();
			for(int i=0;i<file1.length;i++){
				Accessory accessory1=new Accessory();
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file1[i].transferTo(f1);
				accessory1.setaId(id);
				accessory1.setAcName(fileName);
				accessory1.setAcUrl(filePath);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			fbContract.setAccessory1(list1);
		}
		int i=scService.saveSubContract(fbContract);
		map.put("result", i);
		map.put("fbContract", fbContract);
		return map;
	}
	
	@RequestMapping("/deleteSubContractById")
	@ResponseBody
	public int deleteSubContractById(String id){
		return scService.deleteSubContractById(id);
	}
	
	
	@RequestMapping("/updateSubContractsave")
	@ResponseBody
	public Map<String,Object> updateSubContractsave(FbContract fbContract,@RequestParam("file")MultipartFile file[],@RequestParam("file1")MultipartFile file1[]) throws IllegalStateException, IOException{
		Map<String,Object> map = new HashMap<>();
		String id=new TimeUUID().getTimeUUID();
		scService.updateHistory(fbContract.getFbId());
		fbContract.setFbId(id);
		
		String path = "D:"+File.separator+"oa"+File.separator+"subcontract";
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				String filename = file[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("分包合同文本");
				list.add(accessory);
			}
			fbContract.setAccessory(list);
		}
		if(file1.length>0){
			List<Accessory> list1 = new ArrayList<>();
			for(int i=0;i<file1.length;i++){
				Accessory accessory1=new Accessory();
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file1[i].transferTo(f1);
				accessory1.setaId(id);
				accessory1.setAcName(fileName);
				accessory1.setAcUrl(filePath);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			fbContract.setAccessory1(list1);
		}
		int i=scService.saveSubContract(fbContract);
		map.put("result", i);
		map.put("fbContract", fbContract);
		return map;
	}
	
	@RequestMapping("/updateSubContractsubmit")
	@ResponseBody
	public Map<String,Object> updateSubContractsubmit(FbContract fbContract,@RequestParam("file")MultipartFile file[],@RequestParam("file1")MultipartFile file1[]) throws IllegalStateException, IOException{
		Map<String,Object> map = new HashMap<>();
		String id=new TimeUUID().getTimeUUID();
		scService.updateHistory(fbContract.getFbId());
		fbContract.setFbId(id);
		
		String path = "D:"+File.separator+"oa"+File.separator+"subcontract";
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				String filename = file[i].getOriginalFilename();
				String filePath=path+File.separator+filename;
				File f1=new File(filePath);
				file[i].transferTo(f1);
				Accessory accessory=new Accessory();
				accessory.setaId(id);
				accessory.setAcName(filename);
				accessory.setAcUrl(filePath);
				accessory.setaType("分包合同文本");
				list.add(accessory);
			}
			fbContract.setAccessory(list);
		}
		if(file1.length>0){
			List<Accessory> list1 = new ArrayList<>();
			for(int i=0;i<file1.length;i++){
				Accessory accessory1=new Accessory();
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file1[i].transferTo(f1);
				accessory1.setaId(id);
				accessory1.setAcName(fileName);
				accessory1.setAcUrl(filePath);
				accessory1.setaType("法律顾问签字");
				list1.add(accessory1);
			}
			fbContract.setAccessory1(list1);
		}
		int i=scService.saveSubContract(fbContract);
		map.put("result", i);
		map.put("fbContract", fbContract);
		return map;
	}
	
	@RequestMapping("/selectSubContractById")
	@ResponseBody
	public FbContract selectSubContractById(String id){
		return scService.selectSubContractById(id);
	}
	
	@RequestMapping("/selectAccessoryById")
	@ResponseBody
	public List<Accessory> selectAccessoryById(String id){
		List<Accessory> list=scService.selectAccessoryById(id);
		return list;
	}
	
	@RequestMapping("/deleteAccessory")
	@ResponseBody
	public int deleteAccessory(Accessory accessory){
		int i=scService.deleteAccessoryByIdAndName(accessory);
		if(i>0){
			File f=new File(accessory.getAcUrl());
			f.delete();
		}
		return i;
	}
	
	@RequestMapping("/selectsubcontractHistory")//初始化合同历史信息
	@ResponseBody
	public List<FbContract> selectsubcontractHistory(String fbNo){
		List<FbContract> list=scService.selectsubcontractHistory(fbNo);
		return list;
	}
	
	@RequestMapping("/getFBNameAndNo")//初始化合同名和合同编号和乙方
	@ResponseBody
	public List<FbContract> getFBNameAndNo(){
		List<FbContract> list=scService.getFBNameAndNo();
		return list;
	}
	
	@RequestMapping("/getFBNameByNo")//通过合同编号获得合同名和乙方
	@ResponseBody
	public FbContract getFBNameByNo(String fbNo){
		return scService.getFBNameByNo(fbNo);
	}
	
	@RequestMapping("/getFBNoByName")//通过合同名获得合同编号和乙方
	@ResponseBody
	public FbContract getFBNoByName(String contractName){
		return scService.getFBNoByName(contractName);
	}
	
	@RequestMapping("/getFBContractByName")//通过合同名获得主合同名、主合同号、主合同金额、项目名、任务单号、（合同进度）
	@ResponseBody
	public FbContract getFBContractByName(String contractName){
		return scService.getFBContractByName(contractName);
	}
}

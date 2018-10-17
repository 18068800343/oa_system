package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CgContract;
import org.ldxx.bean.FbContract;
import org.ldxx.service.CgContractService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 采购合同管理
 * @author hp
 *
 */

@RequestMapping("cgcontract")
@Controller
public class CgContractController {
	
	@Autowired
	private CgContractService cgService;
	
	@RequestMapping("/selectCgContractByStatus")
	@ResponseBody
	public List<CgContract> selectCgContractByStatus(String status){
		List<CgContract> list = cgService.selectCgContractByStatus(status);
		return list;
	}

	@RequestMapping("/addCgContractSave")//保存
	@ResponseBody
	public int addCgContractSave(CgContract cg,@RequestParam("file") MultipartFile [] file) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cg.setCgId(id);
		
		String type = cg.getCgcType();
		String code = type.split(" ")[0];
		int count=cgService.cgNocount();
		count=count+1;
		String cgNo=uuid.getPrjCode(code, count);
		cgNo="CG"+cgNo;
		cg.setCgNo(cgNo);
		
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String path="D:"+File.separator+"oa"+File.separator+"CgContract";
				File f=new File(path);
				if(!f.exists()){
					f.mkdirs();
				}
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				list.add(accessory);
			}
			cg.setAccessory(list);
		}
		int i=cgService.addCgContract(cg);
		return i;
	}
	
	
	@RequestMapping("/addCgContractSubmit")//提交
	@ResponseBody
	public int addCgContractSubmit(CgContract cg,@RequestParam("file") MultipartFile [] file) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cg.setCgId(id);
		
		String type = cg.getCgcType();
		String code = type.split(" ")[0];
		int count=cgService.cgNocount();
		count=count+1;
		String cgNo=uuid.getPrjCode(code, count);
		cgNo="CG"+cgNo;
		cg.setCgNo(cgNo);
		
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String path="D:"+File.separator+"oa"+File.separator+"CgContract";
				File f=new File(path);
				if(!f.exists()){
					f.mkdirs();
				}
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				list.add(accessory);
			}
			cg.setAccessory(list);
		}
		int i=cgService.addCgContract(cg);
		return i;
	}
	
	
	@RequestMapping("/deleteCgContractById")
	@ResponseBody
	public int deleteCgContractById(String id){
		return cgService.deleteCgContractById(id);
	}
	
	@RequestMapping("/updateCgContractSave")
	@ResponseBody
	public int updateCgContractSave(CgContract cg,@RequestParam("file") MultipartFile [] file) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cgService.updateHistoryById(cg.getCgId());
		cg.setCgId(id);
		
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String path="D:"+File.separator+"oa"+File.separator+"CgContract";
				File f=new File(path);
				if(!f.exists()){
					f.mkdirs();
				}
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				list.add(accessory);
			}
			cg.setAccessory(list);
		}
		int i=cgService.addCgContract(cg);
		return i;
	}
	
	@RequestMapping("/updateCgContractSubmit")
	@ResponseBody
	public int updateCgContractSubmit(CgContract cg,@RequestParam("file") MultipartFile [] file) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cgService.updateHistoryById(cg.getCgId());
		cg.setCgId(id);
		
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String path="D:"+File.separator+"oa"+File.separator+"CgContract";
				File f=new File(path);
				if(!f.exists()){
					f.mkdirs();
				}
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				list.add(accessory);
			}
			cg.setAccessory(list);
		}
		int i=cgService.addCgContract(cg);
		return i;
	}
	
	@RequestMapping("/selectCgContractById")
	@ResponseBody
	public CgContract selectCgContractById(String id){
		return cgService.selectCgContractById(id);
	}
	
	@RequestMapping("/selectCgIdAndName")
	@ResponseBody
	public List<CgContract> selectCgIdAndName(){
		return cgService.selectCgIdAndName();
	}
	
	@RequestMapping("/selectCgnoById")
	@ResponseBody
	public CgContract selectCgnoById(String id){
		return cgService.selectCgnoById(id);
	}
	
	@RequestMapping("/selectAccessoryById")
	@ResponseBody
	public List<Accessory> selectAccessoryById(String id){
		List<Accessory> list=cgService.selectAccessoryById(id);
		return list;
	}
	
	@RequestMapping("/deleteAccessory")
	@ResponseBody
	public int deleteAccessory(Accessory accessory){
		int i=cgService.deleteAccessoryByIdAndName(accessory);
		if(i>0){
			File f=new File(accessory.getAcUrl());
			f.delete();
		}
		return i;
	}
	
	@RequestMapping("/selectHistoryByNo")
	@ResponseBody
	public List<CgContract> selectHistoryByNo(String cgNo){
		return cgService.selectHistoryByNo(cgNo);
	}
	
	@RequestMapping("/getCGNameAndNo")//初始化合同名和合同编号、项目名和任务单号
	@ResponseBody
	public List<CgContract> getCGNameAndNo(){
		List<CgContract> list=cgService.getCGNameAndNo();
		return list;
	}
	
	@RequestMapping("/getCGNameByNo")//通过合同编号获得合同名
	@ResponseBody
	public List<CgContract> getCGNameByNo(String cgNo){
		return cgService.getCGNameByNo(cgNo);
	}
	
	@RequestMapping("/getCGNoByName")//通过合同名获得合同编号
	@ResponseBody
	public List<CgContract> getCGNoByName(String contractName){
		return cgService.getCGNoByName(contractName);
	}
	
	
	@RequestMapping("/getCGNameAndPrjNameBytaskNo")//通过任务单获得采购合同和项目名
	@ResponseBody
	public List<CgContract> getCGNameAndPrjNameBytaskNo(String no){
		return cgService.getCGNameAndPrjNameBytaskNo(no);
	}
	
	@RequestMapping("/getCGNametaskNoAndByPrjName")//通过项目名获得采购合同和任务单
	@ResponseBody
	public List<CgContract> getCGNametaskNoAndByPrjName(String name){
		return cgService.getCGNametaskNoAndByPrjName(name);
	}
	
	@RequestMapping("/updateDepartmentMoney")//修改部门金额
	@ResponseBody
	public int updateDepartmentMoney(float price,String id){
		return cgService.updateDepartmentMoney(price,id);
	}
	
	@RequestMapping("/updateMaterialPrice")//修改材料单价
	@ResponseBody
	public int updateMaterialPrice(float price,String id){
		return cgService.updateMaterialPrice(price,id);
	}
}

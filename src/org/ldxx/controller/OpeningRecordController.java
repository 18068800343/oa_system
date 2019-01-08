package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.BidApproval;
import org.ldxx.bean.OpeningInformation;
import org.ldxx.bean.OpeningRecord;
import org.ldxx.bean.ProjectOver;
import org.ldxx.bean.User;
import org.ldxx.dao.OpeningRecordDao;
import org.ldxx.service.BidApprovalService;
import org.ldxx.service.OpeningRecordService;
import org.ldxx.service.ProjectOverService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONObject;

/**
 * 开标记录
 * @author hp
 *
 */
@RequestMapping("OpeningRecord")
@Controller
public class OpeningRecordController {
	
	@Autowired
	private OpeningRecordService service;
	@Autowired
	private BidApprovalService bService;
	@Autowired
	private OpeningRecordDao openingRecordDao;
	@Autowired
	private ProjectOverService pService;
	
	@RequestMapping("/selectOpeningRecord")
	@ResponseBody
	public List<OpeningRecord> selectOpeningRecord(){
		return service.selectOpeningRecord();
	}
	
	@RequestMapping("/selectOpeningRecordById")
	@ResponseBody
	public OpeningRecord selectOpeningRecordById(String id){
		return service.selectOpeningRecordById(id);
	}
	
	@RequestMapping("/updateIsQibiao")
	@ResponseBody
	public int updateIsQibiao(String isQibiao,String orId){
		return openingRecordDao.updateIsQibiao(isQibiao,orId);
	}
	
	@RequestMapping("/addOpeningRecord")
	@ResponseBody
	public int addOpeningRecord(String id){
		List<OpeningRecord> rdList=new ArrayList<>();
		BidApproval ba=bService.selectBidApprovalById(id);
		String prjName=ba.getPrjName();
		String prjNo=ba.getPrjNo();
		String prjType=ba.getPrjType();
		String bdNo=ba.getBdNo();
		
		for(int a=0;a<bdNo.split(",").length;a++){
			OpeningRecord rd=new OpeningRecord();
			TimeUUID uuid=new TimeUUID();
			String rdId=uuid.getTimeUUID();
			rd.setOrId(rdId);
			String bd=bdNo.split(",")[a];
			rd.setPrjName(prjName);
			rd.setPrjNo(prjNo);
			rd.setPrjType(prjType);
			rd.setBdNo(bd);
			rdList.add(rd);
		}
		int i=service.addOpeningRecord(rdList);
		return i;
	}
	
	
	@RequestMapping("/addOpeningRecordSave")
	@ResponseBody
	public Map<String,Object> addOpeningRecordSave(String record,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String,Object> map = new HashMap<>();
		Map<String,Class> map2=new HashMap<>();
		map2.put("openingInformation", OpeningInformation.class);
		JSONObject jsonObject=JSONObject.fromObject(record);
		OpeningRecord rd=(OpeningRecord)JSONObject.toBean(jsonObject, OpeningRecord.class,map2);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		rd.setOrId(id);
		String path="D:"+File.separator+"oa"+File.separator+"OpeningRecord"+File.separator+id;;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("开标记录公示截图");
				list.add(accessory);
			}
			rd.setAccessory(list);
		}
		int i=service.addOpeningRecordSave(rd);
		map.put("result", i);
		map.put("OpeningRecord", rd);
		return map;
	}
	@RequestMapping("/addOpeningRecordSubmit")
	@ResponseBody
	public Map<String,Object> addOpeningRecordSubmit(String record,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String,Object> map = new HashMap<>();
		Map<String,Class> map2=new HashMap<>();
		map2.put("openingInformation", OpeningInformation.class);
		JSONObject jsonObject=JSONObject.fromObject(record);
		OpeningRecord rd=(OpeningRecord)JSONObject.toBean(jsonObject, OpeningRecord.class,map2);
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		rd.setOrId(id);
		String path="D:"+File.separator+"oa"+File.separator+"OpeningRecord"+File.separator+id;;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("开标记录公示截图");
				list.add(accessory);
			}
			rd.setAccessory(list);
		}
		int i=service.addOpeningRecordSave(rd);
		map.put("result", i);
		map.put("OpeningRecord", rd);
		return map;
	}
	
	@RequestMapping("/updateOpeningRecordSave")
	@ResponseBody
	public Map<String,Object> updateOpeningRecordSave(String record,@RequestParam MultipartFile [] file,HttpServletRequest request) throws IllegalStateException, IOException{
		Map<String,Object> map = new HashMap<>();
		Map<String,Class> map2=new HashMap<>();
		map2.put("openingInformation", OpeningInformation.class);
		JSONObject jsonObject=JSONObject.fromObject(record);
		OpeningRecord rd=(OpeningRecord)JSONObject.toBean(jsonObject, OpeningRecord.class,map2);
		User user=(User) request.getSession().getAttribute("user");
		String uName=user.getuName();
		rd.setPreparer(uName);
		String id=rd.getOrId();
		String path="D:"+File.separator+"oa"+File.separator+"OpeningRecord"+File.separator+id;;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("开标记录公示截图");
				list.add(accessory);
			}
			rd.setAccessory(list);
		}
		int i=service.updateOpeningRecordSave(rd);
		if(i>0){
			String zhongbiao=rd.getZhongbiao();
			if(zhongbiao.equals("是")){
				int count=pService.selectPrjOverCountByNo(rd.getPrjNo());
				if(count==0){
					BidApproval ba=bService.selectNameByNo(rd.getPrjNo());
					ProjectOver po=new ProjectOver();
					po.setPrjName(ba.getPrjName());
					po.setPrjNo(ba.getPrjNo());
					po.setPrjType(ba.getPrjType());
					po.setProductOwners(ba.getCcName());
					po.setBdNo(rd.getBdNo());
					TimeUUID uuid=new TimeUUID();
					String poId=uuid.getTimeUUID();
					po.setPoId(poId);
					pService.addPrjOver(po);
				}else{
					pService.updateStatus2(rd.getPrjNo(),"1");
				}
			}else{
				pService.updateStatus2(rd.getPrjNo(),"0");
			}
		}
		map.put("result", i);
		map.put("OpeningRecord", rd);
		return map;
	}
	
	@RequestMapping("/updateOpeningRecordSubmit")
	@ResponseBody
	public Map<String,Object> updateOpeningRecordSubmit(String record,@RequestParam MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String,Object> map = new HashMap<>();
		Map<String,Class> map2=new HashMap<>();
		map2.put("openingInformation", OpeningInformation.class);
		JSONObject jsonObject=JSONObject.fromObject(record);
		OpeningRecord rd=(OpeningRecord)JSONObject.toBean(jsonObject, OpeningRecord.class,map2);
		String id=rd.getOrId();
		String path="D:"+File.separator+"oa"+File.separator+"OpeningRecord"+File.separator+id;;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("开标记录公示截图");
				list.add(accessory);
			}
			rd.setAccessory(list);
		}
		int i=service.updateOpeningRecordSave(rd);
		map.put("result", i);
		map.put("OpeningRecord", record);
		return map;
	}

}

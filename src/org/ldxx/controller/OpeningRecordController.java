package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.BidApproval;
import org.ldxx.bean.ModeStatus;
import org.ldxx.bean.OpeningInformation;
import org.ldxx.bean.OpeningRecord;
import org.ldxx.bean.ProjectOver;
import org.ldxx.bean.User;
import org.ldxx.dao.OpeningRecordDao;
import org.ldxx.mapper.ModeStatusMapper;
import org.ldxx.service.BidApprovalService;
import org.ldxx.service.OpeningRecordService;
import org.ldxx.service.ProjectOverService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
	@Autowired
	private ModeStatusMapper mapper;
	
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
	
	@Transactional
	@RequestMapping("/addOpeningRecord")
	@ResponseBody
	public int addOpeningRecord(String id){
		TimeUUID uuid=new TimeUUID();
		List<OpeningRecord> rdList=new ArrayList<>();
		BidApproval ba=bService.selectBidApprovalById(id);
		String prjName=ba.getPrjName();
		String bdNo=ba.getBdNo();
		String bid = ba.getBidder();
		String bidder = bid.split(" ")[0];
		String prjtype = ba.getPrjType();
		String type = prjtype.split(" ")[0];
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String time=sdf.format(new Date());
		int count=bService.prjNocount("%"+time+"%");
		String no = uuid.getSerialNumber(bidder, type, count+1);
		int i=bService.updateBidNoById(no, id);
		if(i>0){
			for(int a=0;a<bdNo.split(",").length;a++){
				OpeningRecord rd=new OpeningRecord();
				String rdId=uuid.getTimeUUID();
				rd.setOrId(rdId);
				String bd=bdNo.split(",")[a];
				rd.setPrjName(prjName);
				rd.setPrjNo(no);
				rd.setPrjType(prjtype);
				rd.setBdNo(bd);
				rdList.add(rd);
			}
			i=service.addOpeningRecord(rdList);
		}
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
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
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
				accessory.setAcUrl(id+File.separator+fileName);
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
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
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
				accessory.setAcUrl(id+File.separator+fileName);
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
		TimeUUID uuid2=new TimeUUID();
		String webApps=uuid2.getWebAppFile();
		String path=webApps+id;
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
				accessory.setAcUrl(id+File.separator+fileName);
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
					ModeStatus ms=new ModeStatus();
					ms.setModeId(poId);
					ms.setStatus("0");
					ms.setRemark("投标项目移交");
					mapper.insert(ms);
				}else{
					/*pService.updateStatus2(rd.getPrjNo(),"1");*/
				}
			}else{
				/*pService.updateStatus2(rd.getPrjNo(),"0");*/
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
		TimeUUID uuid=new TimeUUID();
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
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
				accessory.setAcUrl(id+File.separator+fileName);
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

package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.LianYing;
import org.ldxx.bean.LianYingHeSuan;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.Task;
import org.ldxx.bean.User;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.CompanyCostDao;
import org.ldxx.dao.SecondCompanyCostDao;
import org.ldxx.mapper.CurrentFlowMapper;
import org.ldxx.service.AccessoryService;
import org.ldxx.service.CjContractService;
import org.ldxx.service.FbContractOverService;
import org.ldxx.service.LianYingService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.TaskService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/LianYing")
public class LianYingController {

	@Autowired
	private LianYingService service;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private AccessoryService aService;
	@Autowired
	private SecondCompanyCostDao sccDao;
	@Autowired
	private CompanyCostDao ccDao;
	@Autowired
	private FbContractOverService fbService;
	@Autowired
	private CurrentFlowMapper currentFlowMapper;
	@Autowired
	private CjContractService cjService;
	@Autowired
	private AccessoryDao adao;
	
	@RequestMapping("/addLianYingBySave")
	@ResponseBody
	public int addLianYingBySave(LianYing ly,@RequestParam(value="file", required=false) MultipartFile [] file,@RequestParam(value="file2", required=false) MultipartFile file2,@RequestParam(value="file3", required=false) MultipartFile file3,@RequestParam(value="file4", required=false) MultipartFile file4,HttpSession session) throws IllegalStateException, IOException{
		User user = (User) session.getAttribute("user");
		if(user==null){
			return 2;
		}
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		ly.setLyId(id);
		
		/*SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		int count=service.lyNoCount(year);
		String lyNo="LY"+uuid.getPrjCode("", count+1);
		ly.setLyNo(lyNo);*/
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		List<Accessory> list=new ArrayList<>();
		if(file.length>0){
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[ii].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);  
				accessory.setaType("资质证书");
				list.add(accessory);
			}
		}
		if(file2!=null){
			Accessory accessory2=new Accessory();
			String fileName=file2.getOriginalFilename();
			String filePath=path+File.separator+fileName;
			File f2=new File(filePath);
			file2.transferTo(f2);
			accessory2.setaId(id);
			accessory2.setAcName(fileName);
			accessory2.setAcUrl(id+File.separator+fileName);  
			accessory2.setaType("安全生产许可证有效期");
			list.add(accessory2);
		}
		if(file3!=null){
			Accessory accessory3=new Accessory();
			String fileName=file3.getOriginalFilename();
			String filePath=path+File.separator+fileName;
			File f2=new File(filePath);
			file3.transferTo(f2);
			accessory3.setaId(id);
			accessory3.setAcName(fileName);
			accessory3.setAcUrl(id+File.separator+fileName);  
			accessory3.setaType("开户许可证");
			list.add(accessory3);
		}
		if(file4!=null){
			Accessory accessory4=new Accessory();
			String fileName=file4.getOriginalFilename();
			String filePath=path+File.separator+fileName;
			File f2=new File(filePath);
			file4.transferTo(f2);
			accessory4.setaId(id);
			accessory4.setAcName(fileName);
			accessory4.setAcUrl(id+File.separator+fileName);  
			accessory4.setaType("联营合同内容");
			list.add(accessory4);
		}
		ly.setAccessory(list);
		int i=service.addLianYing(ly);
		if(i>0){
			String string = i+"";
			Task t=taskService.selectIdByNo2(ly.getPrjNo());
			OrganizationManagement om=oService.selectOrgById(t.getMainDepartment());
			String omNo=om.getOmNo();
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(ly.getPrjName()+"流程发起");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(ly.getPrjName()+"流程发起");
			currentFlow.setUrl("shengchanguanliLook/lianying.html-"+id);
			currentFlow.setParams("{'cs':'1'}");
			currentFlow.setStarter(user.getUserId());
			currentFlow.setStartername(user.getuName());
			currentFlow.setFkDept(omNo);
			currentFlow.setDeptname(user.getOmName());
			currentFlow.setNodename("节点名称");
			currentFlow.setPri(1);
			currentFlow.setSdtofnode(new Date());
			currentFlow.setSdtofflow(new Date());
			currentFlow.setFlowEndState(2);
			currentFlow.setFlowNopassState(0);
			FlowHistroy flowHistroy = new FlowHistroy();
			flowHistroy.setActor(user.getUserId());
			flowHistroy.setActorname(user.getuName());
			flowHistroy.setActorresult(0);
			flowHistroy.setView("");
			try {
				string = flowUtill.zancunFlow(currentFlow,flowHistroy);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return i;
	}
	
	
	@RequestMapping("/addLianYing")
	@ResponseBody
	public String addLianYing(LianYing ly,@RequestParam(value="file", required=false) MultipartFile [] file,@RequestParam(value="file2", required=false) MultipartFile file2,@RequestParam(value="file3", required=false) MultipartFile file3,@RequestParam(value="file4", required=false) MultipartFile file4,HttpSession session) throws IllegalStateException, IOException{
		User user = (User) session.getAttribute("user");
		if(user==null){
			return "2";
		}
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		ly.setLyId(id);
		
		/*SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		int count=service.lyNoCount(year);
		String lyNo="LY"+uuid.getPrjCode("", count+1);
		ly.setLyNo(lyNo);*/
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		List<Accessory> list=new ArrayList<>();
		if(file.length>0){
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[ii].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);  
				accessory.setaType("资质证书");
				list.add(accessory);
			}
		}
		if(file2!=null){
			Accessory accessory2=new Accessory();
			String fileName=file2.getOriginalFilename();
			String filePath=path+File.separator+fileName;
			File f2=new File(filePath);
			file2.transferTo(f2);
			accessory2.setaId(id);
			accessory2.setAcName(fileName);
			accessory2.setAcUrl(id+File.separator+fileName);  
			accessory2.setaType("安全生产许可证有效期");
			list.add(accessory2);
		}
		if(file3!=null){
			Accessory accessory3=new Accessory();
			String fileName=file3.getOriginalFilename();
			String filePath=path+File.separator+fileName;
			File f2=new File(filePath);
			file3.transferTo(f2);
			accessory3.setaId(id);
			accessory3.setAcName(fileName);
			accessory3.setAcUrl(id+File.separator+fileName);  
			accessory3.setaType("开户许可证");
			list.add(accessory3);
		}
		if(file4!=null){
			Accessory accessory4=new Accessory();
			String fileName=file4.getOriginalFilename();
			String filePath=path+File.separator+fileName;
			File f2=new File(filePath);
			file4.transferTo(f2);
			accessory4.setaId(id);
			accessory4.setAcName(fileName);
			accessory4.setAcUrl(id+File.separator+fileName);  
			accessory4.setaType("联营合同内容");
			list.add(accessory4);
		}
		ly.setAccessory(list);
		int i=service.addLianYing(ly);
		String string = i+"";
		if(i>0){
			Task t=taskService.selectIdByNo2(ly.getPrjNo());
			OrganizationManagement om=oService.selectOrgById(t.getMainDepartment());
			String omNo=om.getOmNo();
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(ly.getPrjName()+"流程发起");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(ly.getPrjName()+"流程发起");
			currentFlow.setUrl("shengchanguanliLook/lianying.html-"+id);
			currentFlow.setParams("{'cs':'1'}");
			currentFlow.setStarter(user.getUserId());
			currentFlow.setStartername(user.getuName());
			currentFlow.setFkDept(omNo);
			currentFlow.setDeptname(user.getOmName());
			currentFlow.setNodename("节点名称");
			currentFlow.setPri(1);
			currentFlow.setSdtofnode(new Date());
			currentFlow.setSdtofflow(new Date());
			currentFlow.setFlowEndState(2);
			currentFlow.setFlowNopassState(0);
			FlowHistroy flowHistroy = new FlowHistroy();
			flowHistroy.setActor(user.getUserId());
			flowHistroy.setActorname(user.getuName());
			flowHistroy.setActorresult(0);
			flowHistroy.setView("");
			try {
				string = flowUtill.submitGetReceiver(currentFlow,omNo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return string;
	}
	
	@RequestMapping("/updateLianYingById")
	@ResponseBody
	public int updateLianYingById(LianYing ly,@RequestParam(value="file", required=false) MultipartFile [] file,@RequestParam(value="file2", required=false) MultipartFile file2,@RequestParam(value="file3", required=false) MultipartFile file3,@RequestParam(value="file4", required=false) MultipartFile file4,HttpSession session) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=ly.getLyId();
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		List<Accessory> list=new ArrayList<>();
		if(file.length>0){
			for(int ii=0;ii<file.length;ii++){
				Accessory accessory=new Accessory();
				String fileName=file[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[ii].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);  
				accessory.setaType("资质证书");
				list.add(accessory);
			}
		}
		if(file2!=null){
			Accessory accessory2=new Accessory();
			String fileName=file2.getOriginalFilename();
			String filePath=path+File.separator+fileName;
			File f2=new File(filePath);
			file2.transferTo(f2);
			accessory2.setaId(id);
			accessory2.setAcName(fileName);
			accessory2.setAcUrl(id+File.separator+fileName);  
			accessory2.setaType("安全生产许可证有效期");
			list.add(accessory2);
		}
		if(file3!=null){
			Accessory accessory3=new Accessory();
			String fileName=file3.getOriginalFilename();
			String filePath=path+File.separator+fileName;
			File f2=new File(filePath);
			file3.transferTo(f2);
			accessory3.setaId(id);
			accessory3.setAcName(fileName);
			accessory3.setAcUrl(id+File.separator+fileName);  
			accessory3.setaType("开户许可证");
			list.add(accessory3);
		}
		if(file4!=null){
			Accessory accessory4=new Accessory();
			String fileName=file4.getOriginalFilename();
			String filePath=path+File.separator+fileName;
			File f2=new File(filePath);
			file4.transferTo(f2);
			accessory4.setaId(id);
			accessory4.setAcName(fileName);
			accessory4.setAcUrl(id+File.separator+fileName);  
			accessory4.setaType("联营合同内容");
			list.add(accessory4);
		}
		ly.setAccessory(list);
		int i=service.updateLianYing(ly);
		if(i>0){
			Task t=taskService.selectIdByNo2(ly.getPrjNo());
			OrganizationManagement om=oService.selectOrgById(t.getMainDepartment());
			String omNo=om.getOmNo();
			currentFlowMapper.updateFkDeptByModeId(id, omNo);
		}
		return i;
	}
	
	
	@RequestMapping("/selectLianYingByStatus")
	@ResponseBody
	public List<LianYing> selectLianYingByStatus(String status){
		List<LianYing> list=service.selectLianYingByStatus(status);
		return list;
	}
	
	@RequestMapping("/selectLianYingById")
	@ResponseBody
	public LianYing selectLianYingById(String id){
		LianYing ly=service.selectLianYingById(id);
		List<Accessory> accessory=aService.selectAccessoryById(id);
		ly.setAccessory(accessory);
		return ly;
	}
	
	@RequestMapping("/selectLianYingByNo")
	@ResponseBody
	public Map<String,Object> selectLianYingByNo(String no){
		Map<String,Object> map=new HashMap<>();
		LianYing ly=service.selectLianYingByNo(no);
		map.put("ly", ly);
		BigDecimal cost=ccDao.selectSumMoneyByNo(no);//项目累计成本
		BigDecimal cost2=sccDao.selectSumMoneyByNo(no);//检测二部项目累计成本
		BigDecimal allCost=cost.add(cost2);//财务成本结算
		map.put("allCost", allCost);
		BigDecimal fbEndMoney=fbService.selectFbJsMoneyByNo(no);//任务单下所有分包结算金额总和
		map.put("fbEndMoney", fbEndMoney);
		return map;
	}
	
	
	@RequestMapping("/addLianYingHeSuan")
	@ResponseBody
	public Map<String,Object> addLianYingHeSuan(LianYingHeSuan hs){
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		hs.setHsId(id);
		int i=service.addLianYingHeSuan(hs);
		map.put("result", i);
		map.put("hs", hs);
		return map;
	}

	@RequestMapping("/selectLianYingHeSuan")
	@ResponseBody
	public List<LianYingHeSuan> selectLianYingHeSuan(){
		List<LianYingHeSuan> list=service.selectLianYingHeSuan();
		return list;
	}
	
	@RequestMapping("/updateHistory")
	@ResponseBody
	public int updateHistory(String id){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		/*TimeUUID uuid=new TimeUUID();
		int count=service.lyNoCount(year);
		String lyNo="LY"+uuid.getPrjCode("", count+1);*/
		String lyNo="LY"+year+cjService.CreateContractNumOrder("LY", year);
		int i=service.updateLyNoById(id, lyNo);
		return i;
	}
	@RequestMapping("/addSaoMiaoHeTong")
	@ResponseBody
	public Map<String,Object> addOtherFile(@RequestParam(value="file") MultipartFile [] file,String id,HttpServletRequest request){
		Map<String,Object> map=new HashMap<>();
		TimeUUID tu=new TimeUUID();
		int result;
		
		
		String webApps=tu.getWebAppFile();
		String path=webApps+id;
		//如果存在之前的文件，将其删除
		List<Accessory> list = adao.selectAccessoryById(id);
		for(int i=0;i<list.size();i++) {
			if("合同扫描件".equals(list.get(i).getaType()))
			{
				File fOld = new File(webApps+list.get(i).getAcUrl());
				fOld.delete();
				adao.deleteAccessoryByIdAndAType(list.get(i));			
			}
		}
		
		String fileName =file[0].getOriginalFilename();		
		if(file.length>0){
			Accessory accessory=new Accessory();
			
			String filePath=path+File.separator+fileName;
			File f2=new File(filePath);
			
			if(!f2.getParentFile().exists())
			{
				f2.getParentFile().mkdirs();
			}
			try {
				file[0].transferTo(f2);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			accessory.setaId(id);
			accessory.setAcName(fileName);
			accessory.setAcUrl(id+File.separator+fileName);
			accessory.setaType("合同扫描件");
			List<Accessory> lista=new ArrayList<>();
			lista.add(accessory);
			result = adao.addAccessory(lista);
		}else 
		{
			result=-1;
		}

		map.put("result", result);
		return map;
	}
	
	
	@RequestMapping("/selectLianYing2")
	@ResponseBody
	public List<LianYing> selectLianYing2(){
		List<LianYing> list=service.selectLianYing2();
		return list;
	}
}

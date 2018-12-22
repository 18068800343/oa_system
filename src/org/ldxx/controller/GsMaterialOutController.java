package org.ldxx.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CgContract;
import org.ldxx.bean.CompanyMateriaOut;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.GsClOut;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.Task;
import org.ldxx.bean.User;
import org.ldxx.dao.CgContractDao;
import org.ldxx.service.GsClOutService;
import org.ldxx.service.GsMaterialOutService;
import org.ldxx.service.MaterialDemandService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.TaskService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 公司材料出库
 * @author hp
 *
 */

@RequestMapping("gsMaterialOut")
@Controller
public class GsMaterialOutController {
	
	@Autowired
	private GsMaterialOutService service;
	@Autowired
	private GsClOutService gservice;
	@Autowired
	private CgContractDao cdao;
	@Autowired
	private MaterialDemandService mdservice;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private TaskService tService;
	
	@RequestMapping("/selectGsMaterialOut")
	@ResponseBody
	public List<CompanyMateriaOut> selectGsMaterialOut(String status){
		return service.selectGsMaterialOut(status);
	}
	
	
	@RequestMapping("/addGsMaterialOutSave")
	@ResponseBody
	public Map<String,Object> addGsMaterialOutSave(@RequestBody List<CompanyMateriaOut> cm,HttpSession session){
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id = uuid.getTimeUUID();
		CompanyMateriaOut materiaOut = cm.get(0);
		materiaOut.setCmoId(id);
		int i=service.addGsMaterialOutSave(materiaOut);
		if(i>0){
			Task task = tService.selectTaskPrjName(materiaOut.getTaskNo());
			OrganizationManagement om=oService.selectOrgById(task.getMainDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(materiaOut.getPickProject()+"公司材料出库");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(materiaOut.getPickProject()+"公司材料出库流程发起");
			currentFlow.setUrl("shengchanguanliLook/MaterialOut.html-"+id);
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
		map.put("result", i);
		map.put("CompanyMateriaOut", materiaOut);
		return map;
	}
	
	@RequestMapping("/addGsMaterialOutSubmit")
	@ResponseBody
	public String addGsMaterialOutSubmit(@RequestBody List<CompanyMateriaOut> cm,HttpSession session){
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id = uuid.getTimeUUID();
		CompanyMateriaOut materiaOut = cm.get(0);
		materiaOut.setCmoId(id);
		int i=service.addGsMaterialOutSave(materiaOut);
		String string = i+"";
		if(i>0){
			Task task = tService.selectTaskPrjName(materiaOut.getTaskNo());
			OrganizationManagement om=oService.selectOrgById(task.getMainDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			if(materiaOut.getType().equals("1")){
				currentFlow.setTitle(materiaOut.getPickProject()+"公司材料出库");
				currentFlow.setMemo(materiaOut.getPickProject()+"公司材料出库流程发起");
				currentFlow.setUrl("shengchanguanliLook/MaterialOut.html-"+id);
			}else if(materiaOut.getType().equals("3")){
				currentFlow.setTitle(materiaOut.getPickProject()+"公司材料结余转出");
				currentFlow.setMemo(materiaOut.getPickProject()+"公司材料结余转出流程发起");
				currentFlow.setUrl("shengchanguanliLook/BalanceManagement.html-"+id);
			}
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());
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
		/*map.put("result", i);
		map.put("CompanyMateriaOut", materiaOut);
		return map;*/
	}
	
	@RequestMapping("/selectXmMaterialOutByNo")
	@ResponseBody
	public List<CompanyMateriaOut> selectXmMaterialOutByNo(String no){
		List<CompanyMateriaOut> list=service.selectXmMaterialOutByNo(no);
		return list;
	}
	
	@RequestMapping("/selectAllXmMaterialOut")
	@ResponseBody
	public List<CompanyMateriaOut> selectAllXmMaterialOut(){
		List<CompanyMateriaOut> list=service.selectAllXmMaterialOut();
		return list;
	}
	
	
	@RequestMapping("/selectNoByName")
	@ResponseBody
	public Map<String,Object> selectNoByName(String name){
		Map<String,Object> map=new HashMap<>();
		CompanyMateriaOut cm=service.selectNoByName(name);
		List<GsClOut> list=gservice.selectClListByName(name);
		map.put("cmList", list);
		map.put("cm", cm);
		return map;
	}
	
	@RequestMapping("/selectNameByNo")
	@ResponseBody
	public Map<String,Object> selectNameByNo(String no){
		Map<String,Object> map=new HashMap<>();
		CompanyMateriaOut cm=service.selectNameByNo(no);
		List<GsClOut> list=gservice.selectClListByNo(no);
		map.put("cmList", list);
		map.put("cm", cm);
		return map;
	}
	
	@RequestMapping("/updateStatus")
	@ResponseBody
	public int updateStatus(CompanyMateriaOut out,@RequestParam MultipartFile [] file){
		String id=out.getCmoId();
		if(file!=null){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String acName=file[i].getOriginalFilename();
				String url="D:"+File.separator+"oa"+File.separator+"CompanyMateriaOut"+File.separator+id;
				File f=new File(url);
				if(!f.exists()){
					f.mkdirs();
				}
				String acUrl=url+File.separator+acName;
				File acFile=new File(acUrl);
				accessory.setaId(id);
				accessory.setAcName(acName);
				accessory.setAcUrl(acUrl);
				list.add(accessory);
				try {
					file[i].transferTo(acFile);
				} catch (Exception e) {
					e.printStackTrace();
					return 0;
				}
			}
			out.setAccessory(list);
		}
		int i=service.updateStatus(out);
		return i;
	}
	
	@RequestMapping("/selectCompanyMateriaOutForEnd")
	@ResponseBody
	public List<CompanyMateriaOut> selectCompanyMateriaOutForEnd(String no){
		List<CompanyMateriaOut> list=service.selectCompanyMateriaOutForEnd(no);
		return list;
	}

	@RequestMapping("/selectCompanyMateriaOutForWaste")
	@ResponseBody
	public List<CompanyMateriaOut> selectCompanyMateriaOutForWaste(String no){
		List<CompanyMateriaOut> list=service.selectCompanyMateriaOutForWaste(no);
		return list;
	}
	
	@RequestMapping("/selectCgIdAndName")
	@ResponseBody
	public List<CompanyMateriaOut> selectCgIdAndName(){
		List<CompanyMateriaOut> list=service.selectCgIdAndName();
		return list;
	}
	
	@RequestMapping("/selectCgListByName")
	@ResponseBody
	public Map<String,Object> selectCgListByName(String name){
		Map<String,Object> map=new HashMap<>();
		List<CgContract> cg=cdao.getCGNoByName(name);
		List<CompanyMateriaOut> cm=service.selectTaskByName(name);
		map.put("cg", cg);
		map.put("cm", cm);
		return map;
	}
	
	@RequestMapping("/selectCgListByNo")
	@ResponseBody
	public Map<String,Object> selectCgListByNo(String no){
		Map<String,Object> map=new HashMap<>();
		List<CgContract> cg=cdao.getCGNameByNo(no);
		List<CompanyMateriaOut> cm=service.selectTaskByNo(no);
		map.put("cg", cg);
		map.put("cm", cm);
		return map;
	}
	
	@RequestMapping("/selectPrjNoAndCl")
	@ResponseBody
	public Map<String,Object> selectPrjNoAndCl(String cgNo,String cgName,String name){
		Map<String,Object> map=new HashMap<>();
		CompanyMateriaOut cm=service.selectNoByName(name);
		List<GsClOut> gc=gservice.selectClListByIds2(cgNo, cgName, name);
		map.put("cm", cm);
		map.put("gc", gc);
		return map;
	}
	
	@RequestMapping("/selectPrjNameAndCl")
	@ResponseBody
	public Map<String,Object> selectPrjNameAndCl(String cgNo,String cgName,String no){
		Map<String,Object> map=new HashMap<>();
		CompanyMateriaOut cm=service.selectNameByNo(no);
		List<GsClOut> gc=gservice.selectClListByIds(cgNo, cgName, no);
		map.put("cm", cm);
		map.put("gc", gc);
		return map;
	}
	
	@RequestMapping("/updateMaterialDemand")//修改材料剩余数量
	@ResponseBody
	public int updateMaterialDemand(String id,int number){
		return mdservice.updateMaterialDemand(id,number);
	}
	
	@RequestMapping("/selectGsMaterialOutById")
	@ResponseBody
	public CompanyMateriaOut selectGsMaterialOutById(String id){
		return service.selectGsMaterialOutById(id);
	}
	
}

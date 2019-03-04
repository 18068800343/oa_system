package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ContractReason;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.OtherContract;
import org.ldxx.bean.User;
import org.ldxx.mapper.CurrentFlowMapper;
import org.ldxx.service.ContractReasonService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.OtherContractService;
import org.ldxx.util.FlowUtill;
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
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private ContractReasonService crService;
	@Autowired
	private CurrentFlowMapper currentFlowMapper;
	
	@RequestMapping("/addOtherContractBySave")
	@ResponseBody
	public int addOtherContractBySave(OtherContract other,@RequestParam(value="file",required=false) MultipartFile [] file,@RequestParam(value="file2",required=false) MultipartFile [] file2,HttpSession session) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		other.setoId(id);
		/*SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		int count=service.countNo(year);
		String type="";
		String code="QT"+uuid.getPrjCode(type, count+1);
		other.setContractCode(code);*/
		
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
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
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("其他合同文本");
				list.add(accessory);
			}
			other.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int ii=0;ii<file2.length;ii++){
				Accessory accessory2=new Accessory();
				String fileName=file2[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[ii].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(id+File.separator+fileName);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			other.setAccessory2(list2);
		}
		int i=service.addOtherContract(other);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(other.getAbutmentDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(other.getContractName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(other.getContractName()+"流程发起");
			currentFlow.setUrl("shengchanguanliLook/OtherContract.html-"+id);
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
	
	@RequestMapping("/addOtherContractBySubmit")
	@ResponseBody
	public String addOtherContractBySubmit(OtherContract other,@RequestParam(value="file",required=false) MultipartFile [] file,@RequestParam(value="file2",required=false) MultipartFile [] file2,HttpSession session) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		other.setoId(id);
		/*SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		int count=service.countNo(year);
		String type="";
		String code="QT"+uuid.getPrjCode(type, count+1);
		other.setContractCode(code);*/
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
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
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("其他合同文本");
				list.add(accessory);
			}
			other.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int ii=0;ii<file2.length;ii++){
				Accessory accessory2=new Accessory();
				String fileName=file2[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[ii].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(id+File.separator+fileName);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			other.setAccessory2(list2);
		}
		int i=service.addOtherContract(other);
		String string = i+"";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(other.getAbutmentDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(other.getContractName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(other.getContractName()+"流程发起");
			currentFlow.setUrl("shengchanguanliLook/OtherContract.html-"+id);
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
	
	@RequestMapping("/updateOtherContractBySave")
	@ResponseBody
	public int updateOtherContractBySave(OtherContract other,@RequestParam(value="file",required=false) MultipartFile [] file,@RequestParam(value="file2",required=false) MultipartFile [] file2,HttpSession session) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		other.setoId(id);
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
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
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("其他合同文本");
				list.add(accessory);
			}
			other.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int ii=0;ii<file2.length;ii++){
				Accessory accessory2=new Accessory();
				String fileName=file2[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[ii].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(id+File.separator+fileName);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			other.setAccessory2(list2);
		}
		int i=service.addOtherContract(other);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(other.getAbutmentDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(other.getContractName()+"其他合同变更");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(other.getContractName()+"其他合同变更流程发起");
			currentFlow.setUrl("shengchanguanliLook/OtherContract.html-"+id);
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
	
	@RequestMapping("/updateOtherContractBySubmit")
	@ResponseBody
	public String updateOtherContractBySubmit(OtherContract other,@RequestParam(value="file",required=false) MultipartFile [] file,@RequestParam(value="file2",required=false) MultipartFile [] file2,HttpSession session) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		other.setoId(id);
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
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
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("其他合同文本");
				list.add(accessory);
			}
			other.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int ii=0;ii<file2.length;ii++){
				Accessory accessory2=new Accessory();
				String fileName=file2[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[ii].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(id+File.separator+fileName);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			other.setAccessory2(list2);
		}
		int i=service.addOtherContract(other);
		String string = i+"";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(other.getAbutmentDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(other.getContractName()+"其他合同变更");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(other.getContractName()+"其他合同变更流程发起");
			currentFlow.setUrl("shengchanguanliLook/OtherContract.html-"+id);
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
	
	@RequestMapping("/selectOtherContractById")
	@ResponseBody
	public OtherContract selectOtherContractById(String id){
		return service.selectOtherContractById(id);
	}
	
	@RequestMapping("/selectOtherContractByNo")//通过合同号获得其他合同的详细信息
	@ResponseBody
	public OtherContract selectOtherContractByNo(String no){
		return service.selectOtherContractByNo(no);
	}
	
	@RequestMapping("/updateHistoryById") //通过id修改历史状态，prjno为当前的全部改为0，再把当前这条记录的历史状态改为1
	@ResponseBody
	public int updateHistoryById(String id){
		int i=service.updateHistoryById(id);
		if(i>0){
			TimeUUID uuid=new TimeUUID();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
			String year=sdf.format(new Date());
			int count=service.countNo(year);
			String type="";
			String code="QT"+uuid.getPrjCode(type, count+1);
			i=service.updateOnoById(id, code);
		}
		return i;
	}
	
	@RequestMapping("/updateOtherContractById")
	@ResponseBody
	public int updateOtherContractById(OtherContract other,@RequestParam(value="file",required=false) MultipartFile [] file,@RequestParam(value="file2",required=false) MultipartFile [] file2) throws IllegalStateException, IOException{
		String id=other.getoId();
		TimeUUID uuid=new TimeUUID();
		String webApps=uuid.getWebAppFile();
		String path=webApps+id;
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
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("其他合同文本");
				list.add(accessory);
			}
			other.setAccessory(list);
		}
		if(file2.length>0){
			List<Accessory> list2=new ArrayList<>();
			for(int ii=0;ii<file2.length;ii++){
				Accessory accessory2=new Accessory();
				String fileName=file2[ii].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[ii].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(id+File.separator+fileName);
				accessory2.setaType("法律顾问签字");
				list2.add(accessory2);
			}
			other.setAccessory2(list2);
		}
		int i=service.updateOtherContractById(other);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(other.getAbutmentDepartment());
			String omNo=om.getOmNo();
			currentFlowMapper.updateFkDeptByModeId(id, omNo);
		}
		return i;
	}
	
	
	
	
	@RequestMapping("/addOtherContractRestartReason")//合同重启原因
	@ResponseBody
	public String OtherContractRestartReason(ContractReason cr,HttpSession session) throws IllegalStateException, IOException{
		int i=crService.updateContractReasonById(cr);
		String string = i+"";
		if(i>0){
			OtherContract other= service.selectOtherContractById(cr.getId());
			OrganizationManagement om=oService.selectOrgById(other.getAbutmentDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setTitle("其他合同："+other.getContractName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo("其他合同:"+other.getContractName()+"重新启用流程发起");
			currentFlow.setUrl("shengchanguanliLook/OtherContract.html-"+cr.getId());
			currentFlow.setParams("其他合同启用原因："+cr.getRestartReason());
			currentFlow.setStarter(user.getUserId());
			currentFlow.setStartername(user.getuName());
			currentFlow.setFkDept(omNo);
			currentFlow.setDeptname(user.getOmName());
			currentFlow.setNodename("节点名称");
			currentFlow.setPri(1);
			currentFlow.setSdtofnode(new Date());
			currentFlow.setSdtofflow(new Date());
			currentFlow.setFlowEndState(2);
			currentFlow.setFlowNopassState(3);
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
	
	@RequestMapping("/addOtherContractStopReason")//合同取消原因
	@ResponseBody
	public String addOtherContractStopReason(ContractReason cr,HttpSession session) throws IllegalStateException, IOException{
		int count=crService.countId(cr.getId());
		int i=0;
		if(count==0){
			i=crService.addContractReason(cr);
		}else{
			i=crService.updateContractReasonById(cr);
		}
		String string = i+"";
		if(i>0){
			OtherContract other= service.selectOtherContractById(cr.getId());
			OrganizationManagement om=oService.selectOrgById(other.getAbutmentDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setTitle("其他合同："+other.getContractName());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo("其他合同："+other.getContractName()+"取消流程发起");
			currentFlow.setUrl("shengchanguanliLook/OtherContract.html-"+cr.getId());
			currentFlow.setParams("其他合同取消原因："+cr.getStopReason());
			currentFlow.setStarter(user.getUserId());
			currentFlow.setStartername(user.getuName());
			currentFlow.setFkDept(omNo);
			currentFlow.setDeptname(user.getOmName());
			currentFlow.setNodename("节点名称");
			currentFlow.setPri(1);
			currentFlow.setSdtofnode(new Date());
			currentFlow.setSdtofflow(new Date());
			currentFlow.setFlowEndState(3);
			currentFlow.setFlowNopassState(2);
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
}

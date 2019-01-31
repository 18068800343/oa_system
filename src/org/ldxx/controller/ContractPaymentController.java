package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.Pay;
import org.ldxx.bean.Task;
import org.ldxx.bean.User;
import org.ldxx.dao.TaskDao;
import org.ldxx.service.ContractPaymentService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.SubContractService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 合同付款
 * @author hp
 *
 */

@RequestMapping("pay")
@Controller
public class ContractPaymentController {
	
	@Autowired
	private ContractPaymentService payService;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private SubContractService sService;
	@Autowired
	private TaskDao taskDao;
	@RequestMapping("/selectPayByStatus")
	@ResponseBody
	public List<Pay> selectPayByStatus(String status){
		List<Pay> pay=payService.selectPayByStatus(status);
		for(int i=0;i<pay.size();i++){
			String fbNo=pay.get(i).getContractNo();
			Pay p=payService.getTotalPayMoney(fbNo);
			float alreadyAccumulateMoney=p.getAlreadyAccumulateMoney();
			pay.get(i).setAlreadyAccumulateMoney(alreadyAccumulateMoney);
		}
		return pay;
	}

	@RequestMapping("/selectPayById")
	@ResponseBody
	public Pay selectPayById(String id){
		return payService.selectPayById(id);
	}
	
	@RequestMapping("/selectPayById2")
	@ResponseBody
	public Pay selectPayById2(String id){
		Pay pay=payService.selectPayById(id);
		String fbNo=pay.getContractNo();
		Pay p=payService.getTotalPayMoney(fbNo);
		float alreadyAccumulateMoney=p.getAlreadyAccumulateMoney();
		pay.setAlreadyAccumulateMoney(alreadyAccumulateMoney);
		return pay;
	}
	
	
	@RequestMapping("/addPaySave")//添加保存
	@ResponseBody
	public int addPaySave(Pay pay,@RequestParam("file1") MultipartFile [] file1,@RequestParam("file2") MultipartFile [] file2/*,@RequestParam("file3") MultipartFile [] file3*/,HttpSession session) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		pay.setPayId(id);
		
		int count=payService.fkNocount();
		String fkNo="FBFK"+uuid.getPrjCode("", count+1);
		pay.setPayCode(fkNo);
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
		List<Accessory> list=new ArrayList<>();
		List<Accessory> list2=new ArrayList<>();
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file1.length>0){
			for(int i=0;i<file1.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file1[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("开票附件");
				list.add(accessory);
			}
			pay.setAccessory(list);
		}
		if(file2.length>0){
			for(int i=0;i<file2.length;i++){
				Accessory accessory2=new Accessory();
				String fileName=file2[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[i].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(id+File.separator+fileName);
				accessory2.setaType("附件上传");
				list2.add(accessory2);
			}
			pay.setAccessory2(list2);
		}
		/*if(file3.length>0){
			for(int i=0;i<file3.length;i++){
				Accessory accessory3=new Accessory();
				String fileName=file3[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file3[i].transferTo(f2);
				accessory3.setaId(id);
				accessory3.setAcName(fileName);
				accessory3.setAcUrl(filePath);
				accessory3.setaType("法律顾问签字");
				list3.add(accessory3);
			}
			pay.setAccessory3(list3);
		}*/
		int i=payService.addPaySave(pay);
		if(i>0){
			CjContract cj=sService.getCjContractMainPrjLeaderByFbNo(pay.getContractNo());
			OrganizationManagement om=oService.selectOrgById(cj.getMainDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(pay.getContractName()+"分包合同付款");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(pay.getContractName()+"分包合同付款流程保存");
			currentFlow.setUrl("shengchanguanliLook/ContractPayment.html-"+id);
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
	
	@RequestMapping("/addPaySubmit")//添加提交
	@ResponseBody
	public String addPaySubmit(Pay pay,@RequestParam("file1") MultipartFile [] file1,@RequestParam("file2") MultipartFile [] file2/*,@RequestParam("file3") MultipartFile [] file3*/,HttpSession session) throws IllegalStateException, IOException{
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		pay.setPayId(id);
		
		int count=payService.fkNocount();
		count=count+1;
		String fkNo=uuid.getPrjCode("", count);
		fkNo="FBFK"+fkNo;
		pay.setPayCode(fkNo);
		String webApp=uuid.getWebAppFile();
		String path=webApp+id;
		List<Accessory> list=new ArrayList<>();
		List<Accessory> list2=new ArrayList<>();
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file1.length>0){
			for(int i=0;i<file1.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file1[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f1=new File(filePath);
				file1[i].transferTo(f1);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(id+File.separator+fileName);
				accessory.setaType("开票附件");
				list.add(accessory);
			}
			pay.setAccessory(list);
		}
		if(file2.length>0){
			for(int i=0;i<file2.length;i++){
				Accessory accessory2=new Accessory();
				String fileName=file2[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file2[i].transferTo(f2);
				accessory2.setaId(id);
				accessory2.setAcName(fileName);
				accessory2.setAcUrl(id+File.separator+fileName);
				accessory2.setaType("附件上传");
				list2.add(accessory2);
			}
			pay.setAccessory2(list2);
		}
		/*if(file3.length>0){
			for(int i=0;i<file3.length;i++){
				Accessory accessory3=new Accessory();
				String fileName=file3[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file3[i].transferTo(f2);
				accessory3.setaId(id);
				accessory3.setAcName(fileName);
				accessory3.setAcUrl(filePath);
				accessory3.setaType("法律顾问签字");
				list3.add(accessory3);
			}
			pay.setAccessory3(list3);
		}*/
		int i=payService.addPaySave(pay);
		String string = i+"";
		if(i>0){
			CjContract cj=sService.getCjContractMainPrjLeaderByFbNo(pay.getContractNo());
			String prjCode = pay.getPrjListCode();
			Task task = taskDao.selectIdByNo2(prjCode);
			OrganizationManagement om=oService.selectOrgById(task.getMainDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(pay.getContractName()+"分包合同付款");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(pay.getContractName()+"分包合同付款流程发起");
			currentFlow.setUrl("shengchanguanliLook/ContractPayment.html-"+id);
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
	
	
	@RequestMapping("/updatePaySave")//修改保存
	@ResponseBody
	public int updatePaySave(String payId,float resultPay,String payTime) throws IllegalStateException, IOException{
		int i=payService.addPayResultInfo(payId, resultPay, payTime);
		return i;
	}
	
	
	
	@RequestMapping("/selectAccessoryById")
	@ResponseBody
	public List<Accessory> selectAccessoryById(String id){
		List<Accessory> list=payService.selectAccessoryById(id);
		return list;
	}
	
	@RequestMapping("/deleteAccessory")
	@ResponseBody
	public int deleteAccessory(Accessory accessory){
		int i=payService.deleteAccessoryByIdAndName(accessory);
		if(i>0){
			File f=new File(accessory.getAcUrl());
			f.delete();
		}
		return i;
	}
	
	@RequestMapping("/selectHistoryBypayCode")
	@ResponseBody
	public List<Pay> selectHistoryBypayCode(String payId){
		return payService.selectHistoryBypayCode(payId);
	}
	
	@RequestMapping("/getTotalPayMoney")
	@ResponseBody
	public Pay getTotalPayMoney(String no){
		return payService.getTotalPayMoney(no);
	}
	
	@RequestMapping("/updateHistoryById") //通过id修改历史状态，prjno为当前的全部改为0，再把当前这条记录的历史状态改为1
	@ResponseBody
	public int updateHistoryById(String id){
		return payService.updateHistoryById(id);
	}
	
	@RequestMapping("/updateAuthorisePayment")
	@ResponseBody
	public int updateAuthorisePayment(String id,String money){
		Float money1 = Float.valueOf(money);
		int i=payService.updateAuthorisePayment(id, money1);
		return i;
	}
	
}

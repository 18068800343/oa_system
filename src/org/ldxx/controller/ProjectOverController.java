package org.ldxx.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.BidApproval;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.ManagingDocuments;
import org.ldxx.bean.OpeningRecord;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.ProjectOver;
import org.ldxx.bean.User;
import org.ldxx.service.BidApprovalService;
import org.ldxx.service.ManagingDocumentsService;
import org.ldxx.service.OpeningRecordService;
import org.ldxx.service.ProjectOverService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 中标项目移交
 * @author hp
 *
 */
@RequestMapping("prjOver")
@Controller
public class ProjectOverController {
	
	@Autowired
	private ProjectOverService prjOverService;
	@Autowired
	private ManagingDocumentsService service;//经营文档资料
	@Autowired
	private OpeningRecordService oService;
	@Autowired
	private BidApprovalService bService;
	
	@RequestMapping("/selectPrjOver")
	@ResponseBody
	public List<ProjectOver> selectPrjOver(){
		return prjOverService.selectPrjOver();
	}
	
	@RequestMapping("/selectPrjOver2")
	@ResponseBody
	public List<ProjectOver> selectPrjOver2(){
		List<ProjectOver> list =null;
		list = prjOverService.selectPrjOver2();	
		return list;	
	}
	
	
	@RequestMapping("/selectPrjOverYiJiaoZhong")
	@ResponseBody
	public List<ProjectOver> selectPrjOverYiJiaoZhong(){
		List<ProjectOver> list =null;
		list = prjOverService.selectPrjOverYiJiaoZhong();	
		return list;	
	}
	
	@RequestMapping("/selectPrjOverCountByNo")
	@ResponseBody
	public int selectPrjOverCountByNo(String no){
		int i=prjOverService.selectPrjOverCountByNo(no);
		return i;
	}
	
	@RequestMapping("/addPrjOver")//添加保存
	@ResponseBody
	public int  addPrjOver(String id){
		ProjectOver projectOver=new ProjectOver();
		String poId=new TimeUUID().getTimeUUID();
		projectOver.setPoId(poId);
		OpeningRecord or=oService.selectOpeningRecordById(id);
		BidApproval ba=bService.selectBidApprovalById("sssssssssssssssssssssssssssssssssss");
		String prjName=ba.getPrjName();
		String prjNo=ba.getPrjNo();
		String prjType=ba.getPrjType();
		String ccName=ba.getCcName();
		projectOver.setPrjName(prjName);
		projectOver.setPrjNo(prjNo);
		projectOver.setPrjType(prjType);
		projectOver.setProductOwners(ccName);
		int i =prjOverService.addPrjOver(projectOver);
		return i;
		/*Map<String,Object> map = new HashMap<>();
		String id=new TimeUUID().getTimeUUID();
		projectOver.setPoId(id);
		int i =prjOverService.addPrjOver(projectOver);
		if(i>0){
			ManagingDocuments md=new ManagingDocuments();
			md.setMdId(id);
			md.setPrjName(projectOver.getPrjName());//项目名
			md.setPrjNo(projectOver.getPrjNo());//项目编号
			md.setPrjType(projectOver.getPrjType());//项目类型
			md.setPrjBidTime(projectOver.getPoDate());//项目投标时间
			md.setIsBidding("是");//是否中标
			md.setOffer(projectOver.getContractAmount());//本公司报价
			md.setBiddingPrice(projectOver.getContractAmount());//中标价格
			md.setBiddingPrjManager(projectOver.getProjectManager());//中标项目经理
			md.setPrjGeneral(projectOver.getProjectEngineer());//项目总工
			md.setBiddingUnit(projectOver.getTenderCompany());//中标单位
			i=service.addManagingDocumentsSave(md);
		}
		map.put("result", i);
		map.put("projectOver", projectOver);
		return map;*/
	}
	
	@RequestMapping("/SubmitPrjOver")//添加提交
	@ResponseBody
	public Map<String,Object> SubmitPrjOver(ProjectOver projectOver){
		Map<String,Object> map = new HashMap<>();
		String id=new TimeUUID().getTimeUUID();
		projectOver.setPoId(id);
		int i =prjOverService.addPrjOver(projectOver);
		if(i>0){
			ManagingDocuments md=new ManagingDocuments();
			md.setMdId(id);
			md.setPrjName(projectOver.getPrjName());//项目名
			md.setPrjNo(projectOver.getPrjNo());//项目编号
			md.setPrjType(projectOver.getPrjType());//项目类型
			md.setPrjBidTime(projectOver.getPoDate());//项目投标时间
			md.setIsBidding("是");//是否中标
			md.setOffer(projectOver.getContractAmount());//本公司报价
			md.setBiddingPrice(projectOver.getContractAmount());//中标价格
			md.setBiddingPrjManager(projectOver.getProjectManager());//中标项目经理
			md.setPrjGeneral(projectOver.getProjectEngineer());//项目总工
			md.setBiddingUnit(projectOver.getTenderCompany());//中标单位
			i=service.addManagingDocumentsSave(md);
		}
		map.put("result", i);
		map.put("projectOver", projectOver);
		return map;
	}
	
	@RequestMapping("/deletePrjOver")
	@ResponseBody
	public int deletePrjOver(String poId){
		int i =prjOverService.deletePrjOver(poId);
		return i;
	}
	
	@RequestMapping("/updatePrjOverByIdSave")/*修改保存*/
	@ResponseBody
	public int updatePrjOverById(ProjectOver projectOver,HttpSession session){
		int i =prjOverService.updatePrjOverById(projectOver);
		String string=i+"";
		String id=projectOver.getPoId();
		if(i>0){
			String omNo="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(projectOver.getPrjName()+"流程提交");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(projectOver.getPrjName()+"流程提交");
			currentFlow.setUrl("jingyingguanliLook/TransferBid.html-"+id);
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
	
	@RequestMapping("/updatePrjOverByIdSubmit")/*修改提交*/
	@ResponseBody
	public String updatePrjOverByIdSubmit(ProjectOver projectOver,HttpSession session){
		int i =prjOverService.updatePrjOverById(projectOver);
		String string=i+"";
		String id=projectOver.getPoId();
		if(i>0){
			String omNo="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(projectOver.getPrjName()+"流程提交");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(projectOver.getPrjName()+"流程提交");
			currentFlow.setUrl("jingyingguanliLook/TransferBid.html-"+id);
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
	
	@RequestMapping("/selectPrjOverById")
	@ResponseBody
	public ProjectOver selectPrjOverById(String poId){
		ProjectOver po = prjOverService.selectPrjOverById(poId);
		return po;
	}
	
	@RequestMapping("/updateUseStatus")
	@ResponseBody
	public int updateUseStatus(String id){
		int i=prjOverService.updateUseStatus(id);
		return i;
	}
	
}

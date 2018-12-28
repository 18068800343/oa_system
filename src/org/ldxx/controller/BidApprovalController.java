package org.ldxx.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.BidApproval;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.User;
import org.ldxx.dao.BidApprovalDao;
import org.ldxx.service.BidApprovalService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 投标审批单
 * @author hp
 *
 */
@RequestMapping("BidApproval")
@Controller
public class BidApprovalController {
	
	@Autowired
	private BidApprovalService service;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private BidApprovalDao bidApprovalDao;
	
	@RequestMapping("/selectBidApproval")
	@ResponseBody
	public List<BidApproval> selectBidApproval(String status){
		return service.selectBidApproval(status);
	}
	
	@RequestMapping("/selectBidApprovalById")
	@ResponseBody
	public BidApproval selectBidApprovalById(String id){
		return service.selectBidApprovalById(id);
	}
	
	@RequestMapping("/addBidApproval")//添加保存
	@ResponseBody
	public Map<String,Object> addBidApproval(BidApproval ba,HttpSession session){
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id = uuid.getTimeUUID();
		ba.setBaId(id);
		
		String bid = ba.getBidder();
		String bidder = bid.split(" ")[0];
		String prjtype = ba.getPrjType();
		String type = prjtype.split(" ")[0];
		int count=service.prjNocount();
		String no = uuid.getSerialNumber(bidder, type, count);
		ba.setPrjNo(no);
		int i=service.addBidApproval(ba);
		if(i>0){
			User user = (User) session.getAttribute("user");
			OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String omNo=om.getOmNo();
			String string="";
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(ba.getPrjName()+"项目投标审批");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(ba.getPrjName()+"项目投标审批流程发起");
			currentFlow.setUrl("jingyingguanliLook/toubiaoShenpi.html-"+id);
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
		map.put("BidApproval", ba);
		return map;
	}
	
	@RequestMapping("/addBidApprovalSubmit")//添加提交
	@ResponseBody
	public String addBidApprovalSubmit(BidApproval ba,HttpSession session){
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id = uuid.getTimeUUID();
		ba.setBaId(id);
		
		String bid = ba.getBidder();
		String bidder = bid.split(" ")[0];
		String prjtype = ba.getPrjType();
		String type = prjtype.split(" ")[0];
		int count=service.prjNocount();
		String no = uuid.getSerialNumber(bidder, type, count);
		ba.setPrjNo(no);
		int i=service.addBidApproval(ba);
		String string = i+"";
		if(i>0){
			User user = (User) session.getAttribute("user");
			OrganizationManagement om=oService.selectOrgById(user.getOmId());
			String omNo=om.getOmNo();
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(ba.getPrjName()+"项目投标审批");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(ba.getPrjName()+"项目投标审批流程发起");
			currentFlow.setUrl("jingyingguanliLook/toubiaoShenpi.html-"+id);
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
		map.put("BidApproval", ba);
		return map;*/
	}
	
	@RequestMapping("/deleteBidApproval")
	@ResponseBody
	public int deleteBidApproval(String id){
		return service.deleteBidApproval(id);
	}
	
	@RequestMapping("/updateBidApprovalSave")//修改保存
	@ResponseBody
	public Map<String,Object> updateBidApprovalSave(BidApproval ba){
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String bid = ba.getBidder();
		String bidder = bid.split(" ")[0];
		String prjtype = ba.getPrjType();
		String type = prjtype.split(" ")[0];
		int count=service.prjNocount();
		String no = uuid.getSerialNumber(bidder, type, count);
		ba.setPrjNo(no);
		int i=service.updateBidApproval(ba);
		map.put("result", i);
		map.put("BidApproval", ba);
		return map;
	}
	
	@RequestMapping("/updateBidApprovalSubmit")//修改提交
	@ResponseBody
	public Map<String,Object> updateBidApprovalSubmit(BidApproval ba){
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String bid = ba.getBidder();
		String bidder = bid.split(" ")[0];
		String prjtype = ba.getPrjType();
		String type = prjtype.split(" ")[0];
		int count=service.prjNocount();
		String no = uuid.getSerialNumber(bidder, type, count);
		ba.setPrjNo(no);
		int i=service.updateBidApproval(ba);
		map.put("result", i);
		map.put("BidApproval", ba);
		return map;
	}
	
	
	@RequestMapping("/selectprjNameAndNo")//初始化项目名称和项目编号（投标审批单号）
	@ResponseBody
	public List<BidApproval> selectprjNameAndNo(String status){
		return service.selectprjNameAndNo(status);
	}
	
	@RequestMapping("/selectNoByName")//通过项目名称查找项目编号（投标审批单号）和项目类型
	@ResponseBody
	public BidApproval selectNoByName(String name){
		return service.selectNoByName(name);
	}
	
	@RequestMapping("/selectNameByNo")//通过项目编号（投标审批单号）查找项目名称和项目类型
	@ResponseBody
	public BidApproval selectNameByNo(String no){
		return service.selectNameByNo(no);
	}

	@RequestMapping("/updateSpPeoson")
	@ResponseBody
	public int updateSpPeoson(BidApproval ba){
		return service.updateSpPeoson(ba);
	}
	
	@RequestMapping("/updateSubmissionTime")
	@ResponseBody
	public int updateSubmissionTime(BidApproval ba){
		int i=service.updateSubmissionTime(ba);
		return i;
	}
	
	@RequestMapping("/updateFlowEdit")
	@ResponseBody
	public int updateFlowEdit(BidApproval ba){
		int i=bidApprovalDao.updateFlowEdit(ba);
		return i;
	}
}

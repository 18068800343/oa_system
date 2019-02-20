package org.ldxx.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ldxx.bean.BidApproval;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.User;
import org.ldxx.dao.BidApprovalDao;
import org.ldxx.dao.UserDao;
import org.ldxx.service.BidApprovalService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.util.ExportData;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	@Autowired
	private UserDao userDao;
	@RequestMapping("/selectBidApproval")
	@ResponseBody
	public List<BidApproval> selectBidApproval(String status){
		return service.selectBidApproval(status);
	}
	
	@RequestMapping("/selectBidApproval2")
	@ResponseBody
	public List<BidApproval> selectBidApproval2(String status){
		return service.selectBidApproval2(status);
	}
	
	@RequestMapping("/selectBidApprovalById")
	@ResponseBody
	public BidApproval selectBidApprovalById(String id){
		return service.selectBidApprovalById(id);
	}
	
	@RequestMapping("/selectBidApprovalByNo")
	@ResponseBody
	public BidApproval selectBidApprovalByNo(String no){
		return service.selectBidApprovalByNo(no);
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
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String time=sdf.format(new Date());
		int count=service.prjNocount("%"+time+"%");
		String no = uuid.getSerialNumber(bidder, type, count+1);
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
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String time=sdf.format(new Date());
		int count=service.prjNocount("%"+time+"%");
		String no = uuid.getSerialNumber(bidder, type, count+1);
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
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String time=sdf.format(new Date());
		int count=service.prjNocount("%"+time+"%");
		String no = uuid.getSerialNumber(bidder, type, count+1);
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
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String time=sdf.format(new Date());
		int count=service.prjNocount("%"+time+"%");
		String no = uuid.getSerialNumber(bidder, type, count+1);
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
	
	@RequestMapping("/insertChaoSong")
	@ResponseBody
	public String insertChaoSong(String businessPeopleId,String businessPeopleIdName,String bidPeopleId,String bidPeopleName,String id,String tbPeople,String tbPeopleName){
	  List<User> users = new ArrayList<>();
	  User user1 = new User();             
	  user1.setUserId(businessPeopleId);   
	  user1.setuName(businessPeopleIdName);
	  if(businessPeopleId==null||"".equals(businessPeopleId)){
		User user =  userDao.getUserByUname(businessPeopleIdName);
		if(null!=user){
			user1.setUserId(user.getUserId());
		}
	  }
	  
	  User user2 = new User();
	  user2.setUserId(bidPeopleId);
	  user2.setuName(bidPeopleName);
	  if(bidPeopleId==null||"".equals(bidPeopleId)){
			User user =  userDao.getUserByUname(bidPeopleName);
			if(null!=user){
				user2.setUserId(user.getUserId());
			}
	  }
	  
	  users.add(user1);
	  users.add(user2);
	  String result = new FlowUtill().chaoSongFlow(id, users);
	  return result;
	}
	
	@RequestMapping("/insertChaoSongTb")
	@ResponseBody
	public String insertChaoSongTb(String id,String tbPeople,String tbPeopleName){
		List<User> users = new ArrayList<>();
		User user2 = new User();
		user2.setUserId(tbPeople);
		user2.setuName(tbPeopleName);
		if(tbPeople==null||"".equals(tbPeople)){
			User user =  userDao.getUserByUname(tbPeopleName);
			if(null!=user){
				user2.setUserId(user.getUserId());
			}
		}
		users.add(user2);
		String result = new FlowUtill().chaoSongFlow(id, users);
		return result;
	}
	
	@RequestMapping("/selectBidApprovalByTypeAndDepartment")
	@ResponseBody
	public List<BidApproval> selectBidApprovalByTypeAndDepartment(String type,String department){
		type="%"+type+"%";
		department="%"+department+"%";
		List<BidApproval> list=service.selectBidApprovalByTypeAndDepartment(type, department);
		return list;
	}
	
	@RequestMapping("/exportBidApproval")
	@ResponseBody
	public void exportBidApproval(String type,String department,HttpServletResponse response) throws Exception{
		type="%"+type+"%";
		department="%"+department+"%";
		List<BidApproval> list=service.selectBidApprovalByTypeAndDepartment(type, department);
		String xlsName = "投标项目信息表";
		ExportData exportData = new ExportData();
		List<List<String>> dataList = new ArrayList<>();
		for(int i=0;i<list.size();i++){
			List<String> data = new ArrayList<>();
			data.add(i + 1 + "");
			data.add(list.get(i).getPrjName());
			data.add(list.get(i).getCcName());
			data.add(list.get(i).getPrjType());
			data.add(list.get(i).getBidder());
			data.add(list.get(i).getProjectApplicants());
			data.add(list.get(i).getBusinessPeople());
			data.add(list.get(i).getXbDepartment());
			data.add(list.get(i).getSubmissionTime());
			dataList.add(data);
		}
		String[] array = { "序号", "项目名称","业主单位", "项目类型", "投标人","报名人员","商务负责人", "协办部门","投标文件递交时间"};
		exportData.ExportWithResponse(xlsName, xlsName, array.length, array, dataList, response);
	}
}

package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.BidApproval;
import org.ldxx.service.BidApprovalService;
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
	
	
	@RequestMapping("/selectBidApproval")
	@ResponseBody
	public List<BidApproval> selectBidApproval(){
		return service.selectBidApproval();
	}
	
	@RequestMapping("/addBidApproval")//添加保存
	@ResponseBody
	public Map<String,Object> addBidApproval(BidApproval ba){
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
		map.put("result", i);
		map.put("BidApproval", ba);
		return map;
	}
	
	@RequestMapping("/addBidApprovalSubmit")//添加提交
	@ResponseBody
	public Map<String,Object> addBidApprovalSubmit(BidApproval ba){
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
		map.put("result", i);
		map.put("BidApproval", ba);
		return map;
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

}

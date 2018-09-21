package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.BidProject;
import org.ldxx.service.ConstructionProjectService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 项目投标审批
 * @author hp
 *
 */
@RequestMapping("ConstructionProject")
@Controller
public class ConstructionProjectController {
	
	@Autowired
	private ConstructionProjectService cPrjService;
	
	@RequestMapping("/selectAllcPrj")
	@ResponseBody
	public List<BidProject> selectAllcPrj(String status){
		return cPrjService.selectAllcPrj(status);
	}
	
	@RequestMapping("/addcPrj")/*添加保存*/
	@ResponseBody
	public Map<String,Object> addcPrj(BidProject bidProject){
		Map<String,Object> map = new HashMap<>();
		String id = new TimeUUID().getTimeUUID();
		bidProject.setBpId(id);
		bidProject.setIsbidding("0");
		int i=cPrjService.addcPrj(bidProject);
		if(i>0){
			map.put("result", i);
			map.put("bidProject", bidProject);
		}else{
			i=2;
		}
		return map;
	}
	
	@RequestMapping("/addcPrjSubmit")/*添加提交*/
	@ResponseBody
	public Map<String,Object> addcPrjSubmit(BidProject bidProject){
		Map<String,Object> map = new HashMap<>();
		String id = new TimeUUID().getTimeUUID();
		bidProject.setBpId(id);
		bidProject.setIsbidding("0");
		int i=cPrjService.addcPrj(bidProject);
		if(i>0){
			map.put("result", i);
			map.put("bidProject", bidProject);
		}else{
			i=2;
		}
		return map;
	}
	
	@RequestMapping("/deletecPrj")
	@ResponseBody
	public int deletecPrj(String bpId){
		return cPrjService.deletecPrj(bpId);
	}
	
	@RequestMapping("/updatecPrj")/*修改保存*/
	@ResponseBody
	public Map<String,Object> updatecPrj(BidProject bidProject){
		Map<String,Object> map = new HashMap<>();
		int i=cPrjService.updatecPrj(bidProject);
		if(i>0){
			map.put("result", i);
			map.put("bidProject", bidProject);
		}else{
			i=2;
		}
		return map;
	}
	
	@RequestMapping("/updatecPrjSubmit")/*修改提交*/
	@ResponseBody
	public Map<String,Object> updatecPrjSubmit(BidProject bidProject){
		Map<String,Object> map = new HashMap<>();
		int i=cPrjService.updatecPrj(bidProject);
		if(i>0){
			map.put("result", i);
			map.put("bidProject", bidProject);
		}else{
			i=2;
		}
		return map;
	}
	
	@RequestMapping("/updatecPrjBidById")
	@ResponseBody
	public int updatecPrjBidById(BidProject bidProject){
		bidProject.setIsbidding("1");
		return cPrjService.updatecPrjBidById(bidProject);
	}

}

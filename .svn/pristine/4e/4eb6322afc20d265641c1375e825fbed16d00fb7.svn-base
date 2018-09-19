package org.ldxx.controller;

import java.util.List;

import org.ldxx.bean.OperationTarget;
import org.ldxx.service.OperationTargetService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("operationTarget")
public class OperationTargetController {

	@Autowired
	private OperationTargetService oservice;
	
	@RequestMapping("/addOperationTargetBySave")
	@ResponseBody
	public int addOperationTargetBySave(OperationTarget target){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		target.setOtId(id);
		int i=oservice.addOperationTarget(target);
		return i;
	}
	
	@RequestMapping("/addOperationTargetBySubmit")
	@ResponseBody
	public int addOperationTargetBySubmit(OperationTarget target){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		target.setOtId(id);
		int i=oservice.addOperationTarget(target);
		return i;
	}
	
	@RequestMapping("/deleteOperationTarget")
	@ResponseBody
	public int deleteOperationTarget(String id){
		int i=oservice.deleteOperationTargetById(id);
		return i;
	}
	
	@RequestMapping("/updateOperationTarget")
	@ResponseBody
	public int updateOperationTarget(OperationTarget target){
		int i=oservice.updateOperationTarget(target);
		return i;
	}
	
	@RequestMapping("/selectOperationTarget")
	@ResponseBody
	public List<OperationTarget> selectOperationTarget(){
		List<OperationTarget> list=oservice.selectOperationTarget();
		return list;
	}
}

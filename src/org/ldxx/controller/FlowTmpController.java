package org.ldxx.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.ldxx.bean.FlowTmp;
import org.ldxx.mapper.FlowTmpMapper;
import org.ldxx.service.FlowTmpService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("flowTmp")
@Controller
public class FlowTmpController {
	@Autowired
	FlowTmpService flowTmpService;
	@Autowired
	FlowTmpMapper flowTmpMapper;
	@ResponseBody
	@RequestMapping("/getFlowTmpList")
	public List<FlowTmp> getFlowTmpList(HttpServletRequest request){
		List<FlowTmp> flowTmps = flowTmpService.getFlowTmp();
		return flowTmps;
	}
	
	@ResponseBody
	@RequestMapping("/saveFlowTmp")
	public String saveFlowTmp(FlowTmp flowTmp){
		flowTmp.setId(new TimeUUID().getTimeUUID());
		flowTmpService.saveFlowTmp(flowTmp);
		return "1";
	}
	
	@ResponseBody
	@RequestMapping("/updateFlowTmp")
	public String updateFlowTmp(FlowTmp flowTmp){
		int i = flowTmpMapper.updateByPrimaryKeySelective(flowTmp);
		return i+"";
	}
	
	@ResponseBody
	@RequestMapping("/deleteFlowTmp")
	public String deleteFlowTmp(String id){
		flowTmpService.deleteFlowTmp(id);
		return "1";
	}
	
	
}

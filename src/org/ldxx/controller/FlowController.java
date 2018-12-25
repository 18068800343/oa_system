package org.ldxx.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.ldxx.bean.Business;
import org.ldxx.bean.BusinessExample;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.CurrentFlowExample;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.FlowNode;
import org.ldxx.exception.FlowException;
import org.ldxx.mapper.BusinessMapper;
import org.ldxx.mapper.CurrentFlowMapper;
import org.ldxx.mapper.FlowHistroyMapper;
import org.ldxx.mapper.FlowNodeMapper;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("flow")
@Controller
public class FlowController {
	private static final Logger log = Logger.getLogger("myLog");  
	@Autowired
	BusinessMapper businessMapper;
	@Autowired
	FlowNodeMapper flowNodeMapper;
	@Autowired
	CurrentFlowMapper currentFlowMapper;
	@Autowired
	FlowHistroyMapper flowHistroyMapper;
	@Autowired
	FlowUtill flowUtill;
	
	@ResponseBody
	@RequestMapping("/submitFlow")
	public String submitFlow(HttpServletRequest request){
		FlowUtill flowUtill = new FlowUtill();
		CurrentFlow currentFlow = new CurrentFlow();
		currentFlow.setActor("4136c78ab4d5");
		currentFlow.setActorname("萨姆");;
		currentFlow.setMemo("流程发起");
		currentFlow.setUrl("submitFlow-10b4b554825f");
		currentFlow.setParams("{'cs':'1'}");
		currentFlow.setStarter("4136c78ab4d5");
		currentFlow.setStartername("萨姆");
		currentFlow.setSdtofflow(new Date());
		currentFlow.setSdtofnode(new Date());
		currentFlow.setId(new TimeUUID().getTimeUUID());
		
		String string = "";
		String deptNo = "01";
		try {
			string = flowUtill.submitGetReceiver(currentFlow,deptNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return string;
	}
	
/*	@ResponseBody
	@RequestMapping("/submitFlow2")
	public String submitFlow2(HttpServletRequest request,FlowHistroy flowHistroy){
		FlowUtill flowUtill = new FlowUtill();
		CurrentFlow currentFlow = new CurrentFlow();
		currentFlow.setUrl("submitFlow-1");
		if(null==flowHistroy){
			flowHistroy = new FlowHistroy();
		}
	    flowHistroy.setActor("4136c78ab4d5");
	    flowHistroy.setActorname("萨姆");
	    flowHistroy.setView("无意见,通过");
		String string = "";
		try {
			string = flowUtill.submitFlow(currentFlow, flowHistroy, "7dad936dce6a", "小明");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return string;
	}*/
}

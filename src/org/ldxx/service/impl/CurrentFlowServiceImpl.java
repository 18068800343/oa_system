package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.CurrentFlowExample;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.FlowHistroyExample;
import org.ldxx.mapper.CurrentFlowMapper;
import org.ldxx.mapper.FlowHistroyMapper;
import org.ldxx.service.CurrentFlowService;
import org.springframework.beans.factory.annotation.Autowired;

public class CurrentFlowServiceImpl implements CurrentFlowService {

	@Autowired
	CurrentFlowMapper currentFlowMapper;
	@Autowired
	FlowHistroyMapper flowHistroyMapper;
	@Override
	public List<CurrentFlow> getCurrentFlowListByUser(String userId) {
		CurrentFlowExample example = new CurrentFlowExample();
	    example.createCriteria().andActorEqualTo(userId);
	    List<CurrentFlow> currentFlows =currentFlowMapper.selectByExample(example);
		return currentFlows;
	}	
	
	@Override
	public List<FlowHistroy> getFlowHistoryByUser(String userId) {
		FlowHistroyExample example = new FlowHistroyExample();
	    example.createCriteria().andActorEqualTo(userId);
	    List<FlowHistroy> flowHistroys =flowHistroyMapper.selectByExample(example);
		return flowHistroys;
	}
	
	
}

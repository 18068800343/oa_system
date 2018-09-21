package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.CurrentFlowExample;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.FlowHistroyExample;
import org.ldxx.mapper.CurrentFlowMapper;
import org.ldxx.mapper.FlowHistroyMapper;
import org.ldxx.model.CurrentFlowVo;
import org.ldxx.service.CurrentFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrentFlowServiceImpl implements CurrentFlowService {

	@Autowired
	CurrentFlowMapper currentFlowMapper;
	@Autowired
	FlowHistroyMapper flowHistroyMapper;
	@Override
	public List<CurrentFlowVo> getCurrentFlowListByUser(String userId,String status) {
	    List<CurrentFlowVo> currentFlows =currentFlowMapper.getCurrentFlowVoByUserId(userId, status);
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

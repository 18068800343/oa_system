package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.CurrentFlowExample;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.FlowHistroyExample;
import org.ldxx.mapper.CurrentFlowMapper;
import org.ldxx.mapper.FlowHistroyMapper;
import org.ldxx.service.CurrentFlowService;
import org.ldxx.service.FlowHistoryService;
import org.springframework.beans.factory.annotation.Autowired;

public class FlowHistoryServiceImpl implements FlowHistoryService {

	@Autowired
	FlowHistroyMapper flowHistroyMapper;

	@Override
	public List<FlowHistroy> getFlowHistoryByUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlowHistroy> getFlowHistoryByUserAlreadyEnd(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

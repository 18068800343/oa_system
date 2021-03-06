package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.CurrentFlowExample;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.FlowHistroyExample;
import org.ldxx.mapper.CurrentFlowMapper;
import org.ldxx.mapper.FlowHistroyMapper;
import org.ldxx.model.FlowHistoryVo;
import org.ldxx.service.CurrentFlowService;
import org.ldxx.service.FlowHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowHistoryServiceImpl implements FlowHistoryService {

	@Autowired
	FlowHistroyMapper flowHistroyMapper;

	@Override
	public List<FlowHistoryVo> getFlowHistoryByUser(String userId,String status) {
		List<FlowHistoryVo> list = flowHistroyMapper.getFlowHistoryVoByUserId(userId,status);
		return list;
	}
	
	@Override
	public List<FlowHistoryVo> getDistinctFlowHistoryByUser(String userId,String status) {
		List<FlowHistoryVo> list = flowHistroyMapper.getDistinctFlowHistoryByUser(userId,status);
		return list;
	}

	@Override
	public List<FlowHistoryVo> getFlowHistoryByUserAlreadyEnd(String userId) {
		List<FlowHistoryVo> list = flowHistroyMapper.getFlowHistoryVoByUserIdAlreadyEnd(userId);
		return list;
	}

	@Override
	public int deleteFlowHistory(String id) {
		return flowHistroyMapper.deleteFlowHistory(id);
	}

	
}

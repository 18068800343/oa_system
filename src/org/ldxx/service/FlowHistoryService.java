package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.model.FlowHistoryVo;

public interface FlowHistoryService {


	List<FlowHistoryVo> getFlowHistoryByUser(String userId,String status);
	
	List<FlowHistoryVo> getFlowHistoryByUserAlreadyEnd(String userId);

	List<FlowHistoryVo> getDistinctFlowHistoryByUser(String userId, String status);
	
	int deleteFlowHistory(String id);
}

package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;

public interface FlowHistoryService {


	List<FlowHistroy> getFlowHistoryByUser(String userId);
	
	List<FlowHistroy> getFlowHistoryByUserAlreadyEnd(String userId);
}

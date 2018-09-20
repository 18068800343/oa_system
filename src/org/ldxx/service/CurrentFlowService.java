package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;

public interface CurrentFlowService {

	public List<CurrentFlow> getCurrentFlowListByUser(String userId);

	List<FlowHistroy> getFlowHistoryByUser(String userId);
}

package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.model.CurrentFlowVo;

public interface CurrentFlowService {

	public List<CurrentFlowVo> getCurrentFlowListByUser(String userId,String status);

	List<FlowHistroy> getFlowHistoryByUser(String userId);
}

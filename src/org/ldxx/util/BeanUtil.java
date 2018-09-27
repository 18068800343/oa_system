package org.ldxx.util;

import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;

public class BeanUtil {

	public static FlowHistroy copyCurrentFlowToHistory(CurrentFlow currentFlow,FlowHistroy flowHistroy){
		flowHistroy.setFloNodeId(currentFlow.getFloNodeId());
		flowHistroy.setFloTmpId(currentFlow.getFloTmpId());
		flowHistroy.setId(new TimeUUID().getTimeUUID());
		flowHistroy.setUrl(currentFlow.getUrl());
		flowHistroy.setParams(currentFlow.getParams());
		flowHistroy.setTitle(currentFlow.getTitle());
		flowHistroy.setStarter(currentFlow.getStarter());
		flowHistroy.setStartername(currentFlow.getStartername());
		flowHistroy.setRdt(currentFlow.getRdt());
		flowHistroy.setFkDept(currentFlow.getFkDept());
		flowHistroy.setActor(currentFlow.getActor());
		flowHistroy.setActorname(currentFlow.getActorname());
		flowHistroy.setDeptname(currentFlow.getDeptname());
		flowHistroy.setNodename(currentFlow.getNodename());
		flowHistroy.setPri(currentFlow.getPri());
		flowHistroy.setModeId(currentFlow.getModeId());
		flowHistroy.setBusId(currentFlow.getBusId());
		return flowHistroy;
	}
}

package org.ldxx.util;

import org.apache.poi.ss.usermodel.Cell;
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
		if("".equals(flowHistroy.getActorname())||null==flowHistroy.getActorname()){
			flowHistroy.setActorname(currentFlow.getActorname());
		}
		if("".equals(flowHistroy.getDeptname())||null==flowHistroy.getDeptname()){
			flowHistroy.setDeptname(currentFlow.getDeptname());
		}
		flowHistroy.setNodename(currentFlow.getNodename());
		flowHistroy.setPri(currentFlow.getPri());
		flowHistroy.setModeId(currentFlow.getModeId());
		flowHistroy.setBusId(currentFlow.getBusId());
		return flowHistroy;
	}
	
	public  static String getOmNoByUserRole(String userRoleCode,String role_code){
		String[] strings = userRoleCode.split("_");
		for(String string : strings){
			if(string.length()>5&&string.contains(role_code)){
				return string.substring(6,8);
			}
		}
		return "";
	}
	
}

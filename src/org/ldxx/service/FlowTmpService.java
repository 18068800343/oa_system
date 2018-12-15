package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.FlowTmp;

public interface FlowTmpService {

	public List<FlowTmp> getFlowTmp();
	
	public String saveFlowTmp(FlowTmp flowTmp);
	
	public String deleteFlowTmp(String id);
}

package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.MaterialDemand;

public interface MaterialDemandService {

	public int addMaterialDemand(List<MaterialDemand> md);
	
	public List<MaterialDemand> selectMaterialDemandById(String id);
	
	public int updateMd(List<MaterialDemand> md);
}

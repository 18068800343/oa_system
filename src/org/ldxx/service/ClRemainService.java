package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.ClRemain;
import org.ldxx.bean.CompanyMateriaOut;

public interface ClRemainService {

	public int addClRemain(List<ClRemain> cr);
	
	public List<ClRemain> selectClRemainById(String id);
	
	public int remainUse(CompanyMateriaOut cm);
}

package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Enterprise;

public interface EnterpriseService {

	public List<Enterprise> selectEnterpriseById(String id);
	
	public List<Enterprise> selectEnterpriseByIdAndName(String id,String name);
}

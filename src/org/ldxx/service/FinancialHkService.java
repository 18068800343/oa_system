package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.FinancialHk;

public interface FinancialHkService {

	public int addFinancialHk(FinancialHk hk);
	
	public List<FinancialHk> selectFinancialHk();
	
	public FinancialHk selectFinancialHkById(String id);
}

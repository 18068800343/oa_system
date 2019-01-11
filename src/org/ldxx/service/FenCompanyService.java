package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.FenCompany;


public interface FenCompanyService {

	public List<FenCompany> selectFenCompany();
	
	public int addFenCompany(FenCompany job);
	
	public int deleteFenCompany(String id);
	
	public int updateFenCompany(FenCompany job);
}

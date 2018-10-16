package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.CompanyMateriaOut;

public interface GsMaterialOutService {

	List<CompanyMateriaOut> selectGsMaterialOut();

	int addGsMaterialOutSave(CompanyMateriaOut cm);
	
	List<CompanyMateriaOut> selectXmMaterialOutByNo(String no);
	
	List<CompanyMateriaOut> selectClByNo(String no);
	
	CompanyMateriaOut selectNoByName(String name);
	
	CompanyMateriaOut selectNameByNo(String no);
	
	List<CompanyMateriaOut> selectClListByNo(String no);
	
	List<CompanyMateriaOut> selectClListByName(String name);
	
	CompanyMateriaOut selectClInfoByNoAndClName(String no,String clName);
}

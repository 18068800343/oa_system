package org.ldxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CompanyMateriaOut;

public interface GsMaterialOutService {

	List<CompanyMateriaOut> selectGsMaterialOut();

	int addGsMaterialOutSave(CompanyMateriaOut cm);
	
	List<CompanyMateriaOut> selectXmMaterialOutByNo(String no);
	
	CompanyMateriaOut selectNoByName(String name);
	
	CompanyMateriaOut selectNameByNo(String no);
	
	CompanyMateriaOut selectClInfoByNoAndClName(String no,String clName);
	
	int updateStatus(CompanyMateriaOut out);
	
	List<CompanyMateriaOut> selectAllXmMaterialOut();
}

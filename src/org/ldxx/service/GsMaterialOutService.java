package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.CompanyMateriaOut;

public interface GsMaterialOutService {

	List<CompanyMateriaOut> selectGsMaterialOut();

	int addGsMaterialOutSave(CompanyMateriaOut cm);
	
	List<CompanyMateriaOut> selectXmMaterialOutByNo(String no);
	
	CompanyMateriaOut selectNoByName(String name);
	
	CompanyMateriaOut selectNameByNo(String no);
	
	int updateStatus(CompanyMateriaOut out);
	
	List<CompanyMateriaOut> selectAllXmMaterialOut();
	
	List<CompanyMateriaOut> selectCompanyMateriaOutForEnd(String no);
	
	List<CompanyMateriaOut> selectCompanyMateriaOutForWaste(String no);
	
	List<CompanyMateriaOut> selectCgIdAndName();
	
	List<CompanyMateriaOut> selectTaskByNo(String no);
	
	List<CompanyMateriaOut> selectTaskByName(String name);

	List<CompanyMateriaOut> selectGSmaterialRemain(int remainType);

	List<CompanyMateriaOut> selectGsMaterialRemainByname(int remainType,String name);

	List<CompanyMateriaOut> selectGsMaterialRemainByno(int remainType, String no);

	CompanyMateriaOut selectGsMaterialOutById(String id);
}

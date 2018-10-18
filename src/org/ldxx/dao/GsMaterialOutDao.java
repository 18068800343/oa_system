package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CompanyMateriaOut;

public interface GsMaterialOutDao {

	List<CompanyMateriaOut> selectGsMaterialOut();

	int addGsMaterialOutSave(@Param("cm")CompanyMateriaOut cm);
	
	List<CompanyMateriaOut> selectXmMaterialOutByNo(@Param("no")String no);

	CompanyMateriaOut selectNoByName(@Param("name")String name);
	
	CompanyMateriaOut selectNameByNo(@Param("no")String no);
	
	CompanyMateriaOut selectClInfoByNoAndClName(@Param("no")String no,@Param("clName")String clName);
	
	int updateStatus(@Param("out")CompanyMateriaOut out);
	
	List<CompanyMateriaOut> selectAllXmMaterialOut();
}

package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CompanyMateriaOut;

public interface GsMaterialOutDao {

	List<CompanyMateriaOut> selectGsMaterialOut();

	int addGsMaterialOutSave(@Param("cm")CompanyMateriaOut cm);
	
	List<CompanyMateriaOut> selectXmMaterialOutByNo(@Param("no")String no);

}

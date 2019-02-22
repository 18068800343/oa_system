package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.MaterialCompany;

public interface MaterialCompanyDao {

	int addMaterialCompany(@Param("mc")MaterialCompany mc);

	List<MaterialCompany> getAllMaterialCompany();

	int countOfmcName(@Param("mcName")String mcName);

	int deleteMaterialCompanyById(@Param("id")String id);

	int updateMaterialCompany(@Param("mc")MaterialCompany mc);

}

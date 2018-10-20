package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CompanyMaterialReturn;

public interface GsMaterialReturnDao {

	List<CompanyMaterialReturn> selectGsMaterialReturn();

	int addGsMaterialReturnSave(@Param("mr")CompanyMaterialReturn mr);

	int updateGsMaterialReturnSave(@Param("mr")CompanyMaterialReturn mr);

	int deleteGsMaterialReturn(@Param("id")String id);

}

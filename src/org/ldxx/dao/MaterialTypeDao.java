package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.MaterialType;

public interface MaterialTypeDao {

	int addMaterialType(@Param("mt")MaterialType mt);

	int deleteMaterialTypeById(@Param("id")String id);

	int updateMaterialTypeById(@Param("mt")MaterialType mt);

	List<MaterialType> selectMaterialType();

	int materialTypecount(@Param("materialType")String materialType);

}

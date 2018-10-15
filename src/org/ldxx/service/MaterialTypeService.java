package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.MaterialType;

public interface MaterialTypeService {

	int addMaterialType(MaterialType mt);

	int deleteMaterialTypeById(String id);

	int updateMaterialTypeById(MaterialType mt);

	List<MaterialType> selectMaterialType();

	int materialTypecount(String materialType);

}

package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.MaterialCompany;

public interface MaterialCompanyService {

	int addMaterialCompany(MaterialCompany mc);

	List<MaterialCompany> getAllMaterialCompany();

	int deleteMaterialCompanyById(String id);

	int updateMaterialCompany(MaterialCompany mc);

}

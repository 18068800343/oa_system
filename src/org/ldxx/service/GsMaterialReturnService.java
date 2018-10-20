package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.CompanyMaterialReturn;

public interface GsMaterialReturnService {

	List<CompanyMaterialReturn> selectGsMaterialReturn();

	int addGsMaterialReturnSave(CompanyMaterialReturn mr);

	int updateGsMaterialReturnSave(CompanyMaterialReturn mr);

	int deleteGsMaterialReturn(String id);

}

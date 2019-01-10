package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CompanyMateriaIn;

public interface GsMaterialInService {

	List<CompanyMateriaIn> selectGsMaterialIn(String outState);

	int addGsMaterialInSave(CompanyMateriaIn cm);

	List<CompanyMateriaIn> selectcgNotaskNoPrjName();

	List<CompanyMateriaIn> selecttaskNoPrjNameBycgNo(String cgNo);

	List<CompanyMateriaIn> selectcgNotaskNoPrjNameBycgName(String cgName);

	int updateGsMaterialInSave(CompanyMateriaIn cm);

	int updateMaterialbuyUnitAndManufacturer(String id,String unit, String manufacturer);

	CompanyMateriaIn selectGsClInById(String id);

	int updateOutStateById(String id,String outstate);


}

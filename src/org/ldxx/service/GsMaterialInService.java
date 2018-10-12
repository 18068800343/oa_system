package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CompanyMateriaIn;

public interface GsMaterialInService {

	List<CompanyMateriaIn> selectGsMaterialIn();

	int addGsMaterialInSave(CompanyMateriaIn cm);

	List<Accessory> selectAccessoryById(String id);

	int deleteAccessoryByIdAndName(Accessory accessory);

	List<CompanyMateriaIn> selectcgNotaskNoPrjName();

	List<CompanyMateriaIn> selecttaskNoPrjNameBycgNo(String cgNo);

	List<CompanyMateriaIn> selectcgNoPrjNameBytaskNo(String taskNo);

	List<CompanyMateriaIn> selectcgNotaskNoByPrjName(String name);


}

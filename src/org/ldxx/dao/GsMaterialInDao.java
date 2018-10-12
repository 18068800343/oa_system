package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CompanyMateriaIn;

public interface GsMaterialInDao {

	List<CompanyMateriaIn> selectGsMaterialIn();

	int addGsMaterialInSave(@Param("cm")CompanyMateriaIn cm);

	List<CompanyMateriaIn> selectcgNotaskNoPrjName();

	List<CompanyMateriaIn> selecttaskNoPrjNameBycgNo(@Param("cgNo")String cgNo);

	List<CompanyMateriaIn> selectcgNoPrjNameBytaskNo(@Param("taskNo")String taskNo);

	List<CompanyMateriaIn> selectcgNotaskNoByPrjName(@Param("name")String name);



}

package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.TechnicalDocumentation;

public interface TechnicalDocumentationDao {

	List<TechnicalDocumentation> selectTechnicalDocumentation();

	int addConstructionDocumentsSave(@Param("td")TechnicalDocumentation td);

	int deleteTechnicalDocumentation(@Param("id")String id);
	
	TechnicalDocumentation selectTechnicalDocumentationById(@Param("id")String id);

	int updateTechnicalDocumentationSave(@Param("td")TechnicalDocumentation td);

}

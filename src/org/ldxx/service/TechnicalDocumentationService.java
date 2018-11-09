package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.TechnicalDocumentation;

public interface TechnicalDocumentationService {

	List<TechnicalDocumentation> selectTechnicalDocumentation();

	int addConstructionDocumentsSave(TechnicalDocumentation td);

	int deleteTechnicalDocumentation(String id);

}

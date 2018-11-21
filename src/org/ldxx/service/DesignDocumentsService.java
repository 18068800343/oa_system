package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.DesignDocuments;

public interface DesignDocumentsService {

	List<DesignDocuments> selectDesignDocuments();

	int addDesignDocumentsSave(DesignDocuments dd);

	int deleteDesignDocuments(String id);
	
	DesignDocuments selectDesignDocumentsById(String id);

	int updateDesignDocumentsSave(DesignDocuments dd);

}

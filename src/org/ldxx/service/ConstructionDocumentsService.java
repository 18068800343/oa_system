package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ConstructionDocuments;

public interface ConstructionDocumentsService {

	List<ConstructionDocuments> selectConstructionDocuments();

	int deleteConstructionDocumentsById(String id);

	List<Accessory> selectAccessoryById(String id);

	int deleteAccessoryByIdAndName(Accessory accessory);

	int addConstructionDocumentsSave(ConstructionDocuments cd);

	int updateConstructionDocumentsSave(ConstructionDocuments cd);
	
	ConstructionDocuments selectConstructionDocumentsById(String id);

}

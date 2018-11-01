package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ConstructionDocuments;

public interface ConstructionDocumentsService {

	List<ConstructionDocuments> selectConstructionDocuments();

	int deleteConstructionDocumentsById(String id);

	List<Accessory> selectAccessoryById(String id);

	int deleteAccessoryByIdAndName(Accessory accessory);

	int addManagingDocumentsSave(ConstructionDocuments cd);

	int updateManagingDocumentsSave(ConstructionDocuments cd);

}

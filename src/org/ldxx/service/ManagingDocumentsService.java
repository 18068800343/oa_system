package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ManagingDocuments;

public interface ManagingDocumentsService {

	List<ManagingDocuments> selectManagingDocuments();

	int deleteManagingDocumentsById(String id);

	int addManagingDocumentsSave(ManagingDocuments md);

	List<Accessory> selectAccessoryById(String id);

	int deleteAccessoryByIdAndName(Accessory accessory);

	int updateManagingDocumentsSave(ManagingDocuments md);
	
	ManagingDocuments selectManagingDocumentsById(String id);

	ManagingDocuments selectById(String id);

}

package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ConstructionDocuments;

public interface ConstructionDocumentsDao {

	List<ConstructionDocuments> selectConstructionDocuments();

	int deleteConstructionDocumentsById(@Param("id")String id);

	int addManagingDocumentsSave(@Param("cd") ConstructionDocuments cd);

	int updateManagingDocumentsSave(@Param("cd")ConstructionDocuments cd);

}

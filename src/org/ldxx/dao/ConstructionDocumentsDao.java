package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ConstructionDocuments;

public interface ConstructionDocumentsDao {

	List<ConstructionDocuments> selectConstructionDocuments();

	int deleteConstructionDocumentsById(@Param("id")String id);

	int addConstructionDocumentsSave(@Param("cd") ConstructionDocuments cd);

	int updateConstructionDocumentsSave(@Param("cd")ConstructionDocuments cd);

}

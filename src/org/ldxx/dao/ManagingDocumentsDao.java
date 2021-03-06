package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ManagingDocuments;

public interface ManagingDocumentsDao {

	List<ManagingDocuments> selectManagingDocuments();

	int deleteManagingDocumentsById(@Param("id")String id);

	int addManagingDocumentsSave(@Param("md") ManagingDocuments md);

	int updateManagingDocumentsSave(@Param("md") ManagingDocuments md);

	ManagingDocuments selectManagingDocumentsByNo(@Param("no")String no);

	ManagingDocuments selectById(@Param("id")String id);
}

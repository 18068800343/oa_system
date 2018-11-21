package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.DesignDocuments;

public interface DesignDocumentsDao {

	List<DesignDocuments> selectDesignDocuments();

	int addDesignDocumentsSave(@Param("dd")DesignDocuments dd);

	int deleteDesignDocuments(@Param("id")String id);
	
	DesignDocuments selectDesignDocumentsById(@Param("id")String id);

	int updateDesignDocumentsSave(@Param("dd") DesignDocuments dd);

}

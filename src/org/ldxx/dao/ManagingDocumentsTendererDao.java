package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ManagingDocumentsTenderer;

public interface ManagingDocumentsTendererDao {
	
	int addTenderer(@Param("tenderer") List<ManagingDocumentsTenderer> tenderer);//添加招标人

	int deletetTendererById(@Param("id")String id);

	List<ManagingDocumentsTenderer> selectTendererById(@Param("id")String id);

}

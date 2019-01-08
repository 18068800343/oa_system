package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ProjectAccountingFyys;

public interface ProjectAccountingFyysDao {

	int addProjectAccountingFyys(@Param("accountingFyys")List<ProjectAccountingFyys> accountingFyys);

	List<ProjectAccountingFyys> getProjectAccountingFyysById(@Param("id")String id);

}

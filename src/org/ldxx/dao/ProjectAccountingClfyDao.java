package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ProjectAccountingClfy;

public interface ProjectAccountingClfyDao {

	int addProjectAccountingClfy(@Param("accountingClfy")List<ProjectAccountingClfy> accountingClfy);

	List<ProjectAccountingClfy> getProjectAccountingClfyById(@Param("id")String id);

}

package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ProjectAccountingJjfy;

public interface ProjectAccountingJjfyDao {

	int addProjectAccountingJjfy(@Param("accountingJjfy")List<ProjectAccountingJjfy> accountingJjfy);

	List<ProjectAccountingJjfy> getProjectAccountingJjfyById(@Param("id")String id);

}

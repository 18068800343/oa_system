package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ProjectAccountingRg;

public interface ProjectAccountingRgDao {

	int addProjectAccountingRg(@Param("accountingRg")List<ProjectAccountingRg> accountingRg);

	List<ProjectAccountingRg> getProjectAccountingRgById(@Param("id")String id);

	int deleteById(@Param("paId")String paId);

}

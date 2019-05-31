package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ProjectAccounting;

public interface ProjectAccountingDao {

	int addProjectAccounting(@Param("projectAccounting")ProjectAccounting projectAccounting);

	List<ProjectAccounting> selectProjectAccounting(@Param("status")String status);

	ProjectAccounting getProjectAccountingById(@Param("id")String id);

	int updateProjectAccountingById(@Param("projectAccounting")ProjectAccounting projectAccounting);

	int updateHSNoById(@Param("id")String id,@Param("code") String code);

	List<ProjectAccounting> selectProjectAccounting2();

}

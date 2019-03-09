package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.ProjectAccounting;

public interface ProjectAccountingService {

	int addProjectAccounting(ProjectAccounting projectAccounting);

	List<ProjectAccounting> selectProjectAccounting(String status);

	ProjectAccounting getProjectAccountingById(String id);

	int updateProjectAccountingById(ProjectAccounting projectAccounting);

	int updateHSNoById(String id, String code);

}

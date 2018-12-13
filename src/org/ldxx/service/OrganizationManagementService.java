package org.ldxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.OrganizationManagement;

public interface OrganizationManagementService {

	int addOrganizationManagement(OrganizationManagement organizationManagement);

	int deleteOrganizationManagement(String omId);

	int updateOrganizationManagement(OrganizationManagement organizationManagement);

	List<OrganizationManagement> getAllOrganizationManagement();

	List<OrganizationManagement> getOrgIdAndName();

	OrganizationManagement getOrgNameById(String omId);

	OrganizationManagement getOrgIdByName(String omName);
	
	OrganizationManagement selectOrgById(String omId);
	
	List<OrganizationManagement> selectProductionDepartment();

}

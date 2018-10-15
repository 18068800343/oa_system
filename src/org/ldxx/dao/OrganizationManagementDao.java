package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.OrganizationManagement;

public interface OrganizationManagementDao {

	int addOrganizationManagement(@Param("organizationManagement") OrganizationManagement organizationManagement);

	int deleteOrganizationManagement(@Param("omId") String omId);

	int updateOrganizationManagement(@Param("organizationManagement") OrganizationManagement organizationManagement);

	List<OrganizationManagement> getAllOrganizationManagement();

	List<OrganizationManagement> getOrgIdAndName();

	OrganizationManagement getOrgNameById(@Param("omId") String omId);

	OrganizationManagement getOrgIdByName(@Param("omName")String omName);
	
	OrganizationManagement selectOrgById(@Param("omId")String omId);

}

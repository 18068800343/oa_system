package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FinancialDepartments;

public interface FinancialDepartmentsDao {

	int addFinancialDepartments(@Param("fd")FinancialDepartments fd);

	int deleteFinancialDepartmentsById(@Param("id")String id);

	List<FinancialDepartments> selectFinancialDepartmentsById(@Param("id")String id);

}

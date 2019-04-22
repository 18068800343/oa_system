package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CompanyCostCf;

public interface CompanyCostCfDao {

	int addCompanyCostCf(@Param("ccclist")List<CompanyCostCf> ccclist);

	List<CompanyCostCf> selectCompanyCostCf();

}

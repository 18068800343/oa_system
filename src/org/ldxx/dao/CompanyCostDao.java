package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CompanyCost;
import org.ldxx.bean.SecondCompanyCost;
public interface CompanyCostDao {

	public int addCompanyCost(@Param("cc")List<CompanyCost> cc);
	
	public List<CompanyCost> selectCompanyCost();
	
	public int deleteCompanyCost(@Param("id")String id);

}

package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FenCompany;

public interface FenCompanyDao {

	public List<FenCompany> selectFenCompany();
	
	public int addFenCompany(@Param("job")FenCompany job);
	
	public int deleteFenCompany(@Param("id")String id);
	
	public int updateFenCompany(@Param("job")FenCompany job);
	
	public int countOfName(@Param("name")String name);
	
	public int countOfSize(@Param("size")int size);
	
	public int countOfNameToEdit(@Param("name")String name,@Param("id")String id);
	
	public int countOfSizeToEdit(@Param("size")int size,@Param("id")String id);
}

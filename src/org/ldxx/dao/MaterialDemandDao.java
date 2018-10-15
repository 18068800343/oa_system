package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.MaterialDemand;

public interface MaterialDemandDao {

	public int addMaterialDemand(@Param("md")List<MaterialDemand> md);
	
	public List<MaterialDemand> selectMaterialDemandById(@Param("id")String id);
	
	public int deleteMdById(@Param("id")String id);
}

package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Enterprise;

public interface EnterpriseDao {

		public int addEnterprise(@Param("enterprise")List<Enterprise> enterprise);
		
		public int deleteEnterprise(@Param("id")String id);
		
		public List<Enterprise> selectEnterpriseById(@Param("id")String id);
		
		public List<Enterprise> selectEnterpriseByIdAndName(@Param("id")String id,@Param("name")String name);
}

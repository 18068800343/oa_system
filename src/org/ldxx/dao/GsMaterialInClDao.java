package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CompanyMateriaIn;
import org.ldxx.bean.CompanyMaterialInCl;
import org.ldxx.bean.outRemain;

public interface GsMaterialInClDao {

	int addGsInCl(@Param("gsInCl")List<CompanyMaterialInCl> gsInCl);

	List<CompanyMaterialInCl> selectGsInClById(@Param("id")String id);

	int deleteGsInClById(@Param("id")String id);

	List<CompanyMaterialInCl> selectGsClInBytaskNo(@Param("no")String no);

	int updateRemain(@Param("id")String id, @Param("remain")String remain);

	int updateSumClRemainById(@Param("crId")String crId, @Param("cmoNumber")int cmoNumber);

	int updateRemainForWaste(@Param("cr")List<outRemain> cr);

}

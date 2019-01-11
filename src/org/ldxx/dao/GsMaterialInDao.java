package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CompanyMateriaIn;

public interface GsMaterialInDao {

	List<CompanyMateriaIn> selectGsMaterialIn(String outState);

	int addGsMaterialInSave(@Param("cm")CompanyMateriaIn cm);

	List<CompanyMateriaIn> selectcgNotaskNoPrjName();

	List<CompanyMateriaIn> selecttaskNoPrjNameBycgNo(@Param("cgNo")String cgNo);

	List<CompanyMateriaIn> selectcgNotaskNoPrjNameBycgName(@Param("cgName")String cgName);

	int updateGsMaterialInSave(@Param("cm")CompanyMateriaIn cm);

	CompanyMateriaIn selectGsClInById(@Param("id")String id);

	int updateOutStateById(@Param("id")String id,@Param("outstate")String outstate);

	List<CompanyMateriaIn> selectXmMaterialByPrj(@Param("prjname")String prjname,@Param("outstate") String outstate);

	int updateXmState(@Param("gsIncl")CompanyMateriaIn gsIncl);

	List<CompanyMateriaIn> selectAllXmReceivedGoods();



}

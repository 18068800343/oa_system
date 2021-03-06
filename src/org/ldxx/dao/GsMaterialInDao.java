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

	List<CompanyMateriaIn> selectXmMaterialByNo(@Param("no")String no,@Param("outstate") String outstate);

	int updateXmState(@Param("gsIn")CompanyMateriaIn gsIn);

	List<CompanyMateriaIn> selectAllXmReceivedGoods(@Param("useromId")String useromId);

	List<CompanyMateriaIn> selectMateriaOutForEnd(@Param("no")String no,@Param("type")String type,@Param("useromId") String useromId);

	int updateremainType(@Param("id")String id,@Param("type") String type);

	List<CompanyMateriaIn> selectGsMateriaOutForEnd(@Param("no")String no);

	List<CompanyMateriaIn> getGsMaterialIn();

	List<CompanyMateriaIn> selectAlearyRemain();

	List<CompanyMateriaIn> selectGsMateriaOutForEnd2(@Param("no")String no,@Param("useromId") String useromId);

	List<CompanyMateriaIn> selectBytaskNo(@Param("no")String no);

	List<CompanyMateriaIn> selectByoutStateAndgetState(@Param("outstate")String outstate, @Param("getstate")String getstate);

	List<CompanyMateriaIn> selectBygetDepartment(@Param("getDepartment")String getDepartment);

	List<CompanyMateriaIn> selectAlreadySure(@Param("getstate")String getstate,@Param("useromId") String useromId);

	List<CompanyMateriaIn> selectGsRemainOut(@Param("outState")String outState,@Param("getStatus") String getStatus,@Param("remainType") String remainType);

	List<CompanyMateriaIn> selectXmInByNo(@Param("no")String no, @Param("outstate")String outstate,@Param("useromId") String useromId);

	List<CompanyMateriaIn> selectXmInBybm(@Param("getDepartment")String getDepartment,@Param("useromId") String useromId);


}

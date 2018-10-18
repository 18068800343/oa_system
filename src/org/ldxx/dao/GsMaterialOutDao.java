package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CompanyMateriaOut;

public interface GsMaterialOutDao {

	List<CompanyMateriaOut> selectGsMaterialOut();

	int addGsMaterialOutSave(@Param("cm")CompanyMateriaOut cm);
	
	List<CompanyMateriaOut> selectXmMaterialOutByNo(@Param("no")String no);

	CompanyMateriaOut selectNoByName(@Param("name")String name);
	
	CompanyMateriaOut selectNameByNo(@Param("no")String no);
	
	int updateStatus(@Param("out")CompanyMateriaOut out);//更改验收信息
	
	List<CompanyMateriaOut> selectAllXmMaterialOut();
	
	List<CompanyMateriaOut> selectCompanyMateriaOutForEnd(@Param("no")String no);//项目结余列表
	
	int updateRemainStatus(@Param("id")String id);
}

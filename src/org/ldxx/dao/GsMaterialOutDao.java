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
	
	List<CompanyMateriaOut> selectCompanyMateriaOutForWaste(@Param("no")String no);//废旧品处理列表
	
	int updateRemainStatus(@Param("id")String id);
	
	int updateWasteDispose(@Param("out")CompanyMateriaOut out);
	
	List<CompanyMateriaOut> selectCgIdAndName();
	
	List<CompanyMateriaOut> selectTaskByNo(@Param("no")String no);
	
	List<CompanyMateriaOut> selectTaskByName(@Param("name")String name);

	List<CompanyMateriaOut> selectGSmaterialRemain(@Param("remainType")int remainType);

	List<CompanyMateriaOut> selectGsMaterialRemainByname(@Param("remainType")int remainType,@Param("name")String name);

	List<CompanyMateriaOut> selectGsMaterialRemainByno(@Param("remainType")int remainType,@Param("no") String no);

	CompanyMateriaOut selectGsMaterialOutById(@Param("id")String id);
	
}

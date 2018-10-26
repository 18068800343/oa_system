package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.MaterialDemand;

public interface MaterialDemandDao {

	public int addMaterialDemand(@Param("md")List<MaterialDemand> md);
	
	public List<MaterialDemand> selectMaterialDemandById(@Param("id")String id);
	
	public int deleteMdById(@Param("id")String id);

	public int updateMaterial(@Param("md")MaterialDemand md);//修改材料信息

	public int updateMaterialbuyUnitAndManufacturer(@Param("id")String id,@Param("unit")String unit, @Param("manufacturer")String manufacturer);//修改来货单位及生产厂家

	public int updateMaterialDemand(@Param("id")String id,@Param("number") int number);//修改剩余数量
}

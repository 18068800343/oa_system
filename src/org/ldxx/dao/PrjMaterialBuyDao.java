package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.PrjMaterialBuy;

public interface PrjMaterialBuyDao {

	public int addPrjMaterialBuy(@Param("buy")PrjMaterialBuy buy);
	
	public List<PrjMaterialBuy> selectPrjMaterialBuy(@Param("status")String status);
	
	public int selectPrjMaterialBuyCount();
	
	public List<PrjMaterialBuy> selectBuyCode();
	
	public PrjMaterialBuy selectBuyById(@Param("id")String id);
	
	public int updateSumPrice(@Param("sumPrice")Double sumPrice,@Param("id")String id);

	public List<PrjMaterialBuy> selectBuyByname(@Param("name")String name);

	public List<PrjMaterialBuy> selectDepartmentAndMoney();

	public List<PrjMaterialBuy> selectDepartmentlike(@Param("bumen")String bumen);

	public PrjMaterialBuy selectPrjMaterialBuyById(@Param("id")String id);

	public int updateXMById(@Param("buy")PrjMaterialBuy buy);

	public int updateById(@Param("buy")PrjMaterialBuy buy);

	public int updateTaskNoById(@Param("id")String id,@Param("taskCode") String taskCode);

}

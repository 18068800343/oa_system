package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.PrjMaterialBuy;

public interface PrjMaterialBuyDao {

	public int addPrjMaterialBuy(@Param("buy")PrjMaterialBuy buy);
	
	public List<PrjMaterialBuy> selectPrjMaterialBuy();
	
	public int selectPrjMaterialBuyCount();
	
	public List<PrjMaterialBuy> selectBuyCode();
	
	public PrjMaterialBuy selectBuyById(@Param("id")String id);
}

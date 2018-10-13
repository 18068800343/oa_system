package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.PrjMaterialBuy;

public interface PrjMaterialBuyService {

	public int addPrjMaterialBuy(PrjMaterialBuy buy);
	
	public List<PrjMaterialBuy> selectPrjMaterialBuy();
	
	public int selectPrjMaterialBuyCount();
	
	public List<PrjMaterialBuy> selectBuyCode();
	
	public List<PrjMaterialBuy> selectBuyByIds(String ids);
	
}

package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.PrjMaterialBuy;

public interface PrjMaterialBuyService {

	public int addPrjMaterialBuy(PrjMaterialBuy buy);
	
	public List<PrjMaterialBuy> selectPrjMaterialBuy(String status);
	
	public int selectPrjMaterialBuyCount();
	
	public List<PrjMaterialBuy> selectBuyCode();
	
	public List<PrjMaterialBuy> selectBuyByIds(String ids);

	public List<PrjMaterialBuy> selectBuyByname(String name);

	public List<PrjMaterialBuy> selectDepartmentAndMoney();

	public List<PrjMaterialBuy> selectDepartmentlike(String bumen);

	public PrjMaterialBuy selectPrjMaterialBuyById(String id);

	public int updateXMById(PrjMaterialBuy buy);

	public int updateById(PrjMaterialBuy buy);
	
}

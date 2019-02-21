package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.WxCost;

public interface WxCostService {

	public int addWxCost(List<WxCost> wx);
	
	public List<WxCost> selectAllWxCost();
}

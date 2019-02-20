package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.WxCost;

public interface WxCostDao {

	public int addWxCost(@Param("wx")List<WxCost> wx);
	
	public List<WxCost> selectAllWxCost();
}

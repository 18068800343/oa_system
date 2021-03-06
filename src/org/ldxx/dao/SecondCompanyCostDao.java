package org.ldxx.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.SecondCompanyCost;
public interface SecondCompanyCostDao {

	public int addSecondCompanyCost(@Param("scc")List<SecondCompanyCost> scc);
	
	public List<SecondCompanyCost> selectSecondComCost();
	
	public int deleteSecondComCost(@Param("id")String id);
	
	public BigDecimal selectSumMoneyByNo(@Param("no")String no);

}

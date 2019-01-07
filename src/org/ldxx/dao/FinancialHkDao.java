package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FinancialHk;

public interface FinancialHkDao {

	public int addFinancialHk(@Param("hk")FinancialHk hk);
	
	public List<FinancialHk> selectFinancialHk();
	
	public FinancialHk selectFinancialHkById(@Param("id")String id);
	
	public int updateFinancialHk(@Param("hk")FinancialHk hk);
}

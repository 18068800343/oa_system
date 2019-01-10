package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CostBudget;

public interface CostBudgetDao {

	int addCostBudget(@Param("costBudget")List<CostBudget> costBudget);

	int deleteCostBudgetById(@Param("id")String id);

	List<CostBudget> selectCostBudgetById(@Param("id")String id);

	int selectCount(@Param("id")String id,@Param("fenlei") String fenlei,@Param("mingxi") String mingxi);
}

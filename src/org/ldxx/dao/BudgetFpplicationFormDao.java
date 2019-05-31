package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.BudgetFpplicationForm;
import org.ldxx.bean.CostBudget;

public interface BudgetFpplicationFormDao {

	int saveBudge(@Param("budge")BudgetFpplicationForm budge);

	int deleteBudgeById(@Param("id")String id);

	int updateBudge(@Param("budge")BudgetFpplicationForm budge);

	List<BudgetFpplicationForm> selectBudgeByStatus(@Param("status")String status,@Param("timeMin")String timeMin,@Param("timeMax")String timeMax,@Param("costMin")Double costMin,@Param("costMax")Double costMax);

	BudgetFpplicationForm selectBudgeById(@Param("id")String id);


	List<BudgetFpplicationForm> selectBudgeHistory(@Param("no")String no);

	int countNo(@Param("year")String year);
	
	BudgetFpplicationForm selectBudgeByNo(@Param("no")String no);
	
	BudgetFpplicationForm selectBudgeByName(@Param("name")String name);
	
	Double getBudgeCost(@Param("department")String department,@Param("year")String year);
	
	BudgetFpplicationForm getAllCost(@Param("no")String no);

	int updateHistoryById(@Param("id")String id);
	
	int changeStateById(@Param("id")String id);
	
	CostBudget selectNwCostByTaskNo(@Param("no")String no,@Param("type")String type);
	
	List<CostBudget> selectNwCostByTaskNoAndDept(@Param("no")String no,@Param("type")String type);

	int updateBfNoById(@Param("id")String id,@Param("code") String code);
	
	String CreateBudgetNumOrder(@Param("year")String year);

	List<BudgetFpplicationForm> selectBudgeByStatus2(@Param("status")String status,@Param("timeMin")String timeMin,@Param("timeMax")String timeMax,@Param("costMin")Double costMin,@Param("costMax")Double costMax);
	
}

package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.BudgetFpplicationForm;

public interface BudgetFpplicationFormDao {

	int saveBudge(@Param("budge")BudgetFpplicationForm budge);

	int deleteBudgeById(@Param("id")String id);

	int updateBudge(@Param("budge")BudgetFpplicationForm budge);

	List<BudgetFpplicationForm> selectBudgeByStatus(@Param("status")String status,@Param("timeMin")String timeMin,@Param("timeMax")String timeMax,@Param("costMin")float costMin,@Param("costMax")float costMax);

	BudgetFpplicationForm selectBudgeById(@Param("id")String id);


	List<BudgetFpplicationForm> selectBudgeHistory(@Param("no")String no);

	int countNo();
	
	BudgetFpplicationForm selectBudgeByNo(@Param("no")String no);
	
	BudgetFpplicationForm selectBudgeByName(@Param("name")String name);
	
	float getBudgeCost(@Param("department")String department,@Param("year")String year);
	
	BudgetFpplicationForm getAllCost(@Param("no")String no);

	int updateHistoryById(@Param("id")String id);
	
	int changeStateById(@Param("id")String id);
	
}

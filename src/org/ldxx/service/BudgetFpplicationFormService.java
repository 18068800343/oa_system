package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.BudgetFpplicationForm;

public interface BudgetFpplicationFormService {

	int saveBudge(BudgetFpplicationForm budge);

	int deleteBudgeById(String id);

	int updateBudge(BudgetFpplicationForm budge);

	List<BudgetFpplicationForm> selectBudgeByStatus(String status,String timeMin,String timeMax,float costMin,float costMax);

	BudgetFpplicationForm selectBudgeById(String id);

	int changeStateById(String bfId);

	List<BudgetFpplicationForm> selectBudgeHistory(String no);

	int countNo();
	
	BudgetFpplicationForm selectBudgeByNo(String no);
	
	BudgetFpplicationForm selectBudgeByName(String name);
	
	float getBudgeCost(String department,String year);
	
	BudgetFpplicationForm getAllCost(String no);

	int updateHistoryById(String id);
	
}

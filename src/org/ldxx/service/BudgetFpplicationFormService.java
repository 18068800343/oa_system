package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.BudgetFpplicationForm;

public interface BudgetFpplicationFormService {

	int saveBudge(BudgetFpplicationForm budge);

	int deleteBudgeById(String id);

	int updateBudge(BudgetFpplicationForm budge);

	List<BudgetFpplicationForm> selectBudgeByStatus(String status);

	BudgetFpplicationForm selectBudgeById(String id);

	int changeStateById(String bfId);

	List<BudgetFpplicationForm> selectBudgeHistory(String no);

	int countNo();
	
	BudgetFpplicationForm selectBudgeByNo(String no);
	
	BudgetFpplicationForm selectBudgeByName(String name);
	
}

package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.BudgetFpplicationForm;

public interface BudgetFpplicationFormService {

	int saveBudge(BudgetFpplicationForm budge);

	int deleteBudgeById(String id);

	int updateBudge(BudgetFpplicationForm budge);

	List<BudgetFpplicationForm> selectBudgeByStatus(String status, String state);

	BudgetFpplicationForm selectBudgeById(String id, String status, String state);

	int changeStateById(String bfId);

}

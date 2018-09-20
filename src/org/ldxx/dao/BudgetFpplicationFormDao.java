package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.BudgetFpplicationForm;

public interface BudgetFpplicationFormDao {

	int saveBudge(@Param("budge")BudgetFpplicationForm budge);

	int deleteBudgeById(@Param("id")String id);

	int updateBudge(@Param("budge")BudgetFpplicationForm budge);

	List<BudgetFpplicationForm> selectBudgeByStatus(@Param("status")String status,@Param("state") String state);

	BudgetFpplicationForm selectBudgeById(@Param("id")String id,@Param("status") String status,@Param("state") String state);

	int changeStateById(@Param("bfId")String bfId);

}

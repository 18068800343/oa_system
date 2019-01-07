package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.BudgetMainMaterial;

public interface BudgetMainMaterialDao {

	int addBudgetMainMaterial(@Param("budgetMainMaterial")List<BudgetMainMaterial> budgetMainMaterial);

	int deleteBudgetMainMaterialById(@Param("id")String id);

	List<BudgetMainMaterial> selectBudgetMainMaterialById(@Param("id")String id);

}

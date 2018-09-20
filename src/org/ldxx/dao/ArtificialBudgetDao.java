package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ArtificialBudget;

public interface ArtificialBudgetDao {

	int addArtificialBudget(@Param("artificialBudget")List<ArtificialBudget> artificialBudget);

	int deleteArtificialBudgetById(@Param("id")String id);

	List<ArtificialBudget> selectArtificialBudgetById(@Param("id")String id);

}

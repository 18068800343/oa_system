package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.RiskAssessment;

public interface RiskAssessmentDao {

	int addRiskAssessment(@Param("riskassessment") RiskAssessment riskassessment);
	
	int deleteRiskAssessmentById(@Param("raId")String raId);

	RiskAssessment selectRiskAssessmentById(@Param("raId")String raId);

	int isExistByprjId(@Param("prjId")String prjId);

	int countOfPrjId(@Param("prjId")String prjId, @Param("raId")String raId);

	int updateRiskAssessmentById(@Param("riskassessment")RiskAssessment riskassessment);

	List<RiskAssessment> selectAllRiskAssessment();

	List<RiskAssessment> selectRiskAssessmentPrjName();

	RiskAssessment selectIdByName(@Param("prjId")String prjId);


}

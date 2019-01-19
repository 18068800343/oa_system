package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.RiskAssessment;

public interface RiskAssessmentDao {

	int addRiskAssessment(@Param("riskassessment") RiskAssessment riskassessment);
	
	int deleteRiskAssessmentById(@Param("raId")String raId);

	RiskAssessment selectRiskAssessmentById(@Param("raId")String raId);

	int isExistByprjId(@Param("prjName")String prjName);

	int countOfPrjId(@Param("prjName")String prjName, @Param("raId")String raId);

	int updateRiskAssessmentById(@Param("riskassessment")RiskAssessment riskassessment);

	List<RiskAssessment> selectAllRiskAssessment(@Param("status")String status);

	List<RiskAssessment> selectRiskAssessmentPrjName();

	RiskAssessment selectIdByName(@Param("prjName")String prjName);

	int updateStep2(@Param("id")String id,@Param("step")String step);
	
	int updateStep3(@Param("id")String id,@Param("step")String step);
	
	int updateStep4(@Param("id")String id,@Param("step")String step);
	
	int updateStep5(@Param("id")String id,@Param("step")String step);
	
	int updateStep6(@Param("id")String id,@Param("step")String step);
}

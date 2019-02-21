package org.ldxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.RiskAssessment;

public interface RiskAssessmentService {
	
	int isExistByprjId(String prjName);
	
	int addRiskAssessment(RiskAssessment riskassessment);

	int deleteRiskAssessmentById(String raId);

	RiskAssessment selectRiskAssessmentById(String raId);

	int countOfPrjId(String prjName, String raId);

	int updateRiskAssessmentById(RiskAssessment riskassessment);

	List<RiskAssessment> selectAllRiskAssessment(String status);

	List<RiskAssessment> selectRiskAssessmentPrjName();

	RiskAssessment selectIdByName(String prjName);

	int updateStep2(String id,String step,String view);
	
	int updateStep3(String id,String step, String view);
	
	int updateStep4(String id,String step, String view);
	
	int updateStep5(String id,String step, String view);
	
	int updateStep6(String id,String step, String view);

}

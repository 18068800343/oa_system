package org.ldxx.service;

import java.util.List;

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



}

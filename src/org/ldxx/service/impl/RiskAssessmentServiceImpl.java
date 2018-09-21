package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.RiskAssessment;
import org.ldxx.dao.RiskAssessmentDao;
import org.ldxx.service.RiskAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RiskAssessmentServiceImpl implements RiskAssessmentService {
	
	@Autowired
	private RiskAssessmentDao raDao;
	
	@Override
	public int isExistByprjId(String prjId) {
		return raDao.isExistByprjId(prjId);
	}
	
	@Override
	public int addRiskAssessment(RiskAssessment riskassessment) {
		return raDao.addRiskAssessment(riskassessment);
	}

	@Override
	public int deleteRiskAssessmentById(String raId) {
		return raDao.deleteRiskAssessmentById(raId);
	}

	@Override
	public RiskAssessment selectRiskAssessmentById(String raId) {
		return raDao.selectRiskAssessmentById(raId);
	}

	@Override
	public int countOfPrjId(String prjId, String raId) {
		return raDao.countOfPrjId(prjId,raId);
	}

	@Override
	public int updateRiskAssessmentById(RiskAssessment riskassessment) {
		return raDao.updateRiskAssessmentById(riskassessment);
	}

	@Override
	public List<RiskAssessment> selectAllRiskAssessment(String status) {
		return raDao.selectAllRiskAssessment(status);
	}

	@Override
	public List<RiskAssessment> selectRiskAssessmentPrjName() {
		return raDao.selectRiskAssessmentPrjName();
	}

	@Override
	public RiskAssessment selectIdByName(String prjId) {
		return raDao.selectIdByName(prjId);
	}

	


}

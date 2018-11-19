package org.ldxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Accessory;
import org.ldxx.bean.TestingEvaluation;

public interface TestingEvaluationService {

	List<TestingEvaluation> selectTestingEvaluation();

	int addTestingEvaluationSave(TestingEvaluation te);

	int updateTestingEvaluationSave(TestingEvaluation te);

	int deleteTestingEvaluationById(String id);

	List<Accessory> selectAccessoryById(String id);

	int deleteAccessoryByIdAndName(Accessory accessory);
	
	TestingEvaluation selectTestingEvaluationById(String id);

}

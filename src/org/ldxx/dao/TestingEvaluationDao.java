package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.TestingEvaluation;

public interface TestingEvaluationDao {

	List<TestingEvaluation> selectTestingEvaluation();

	int addTestingEvaluationSave(@Param("te")TestingEvaluation te);

	int updateTestingEvaluationSave(@Param("te") TestingEvaluation te);

	int deleteTestingEvaluationById(@Param("id")String id);

}

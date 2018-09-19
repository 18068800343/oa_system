package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.RiskAssessment;
import org.ldxx.bean.risk_assessmentExample;

public interface risk_assessmentMapper {
    int countByExample(risk_assessmentExample example);

    int deleteByExample(risk_assessmentExample example);

    int deleteByPrimaryKey(String raId);

    int insert(RiskAssessment record);

    int insertSelective(RiskAssessment record);

    List<RiskAssessment> selectByExample(risk_assessmentExample example);

    RiskAssessment selectByPrimaryKey(String raId);

    int updateByExampleSelective(@Param("record") RiskAssessment record, @Param("example") risk_assessmentExample example);

    int updateByExample(@Param("record") RiskAssessment record, @Param("example") risk_assessmentExample example);

    int updateByPrimaryKeySelective(RiskAssessment record);

    int updateByPrimaryKey(RiskAssessment record);
}
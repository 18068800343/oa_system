package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.PrjReport;
import org.ldxx.bean.PrjReportExample;

public interface PrjReportMapper {
    int countByExample(PrjReportExample example);

    int deleteByExample(PrjReportExample example);

    int deleteByPrimaryKey(String prId);

    int insert(PrjReport record);

    int insertSelective(PrjReport record);

    List<PrjReport> selectByExample(PrjReportExample example);

    PrjReport selectByPrimaryKey(String prId);

    int updateByExampleSelective(@Param("record") PrjReport record, @Param("example") PrjReportExample example);

    int updateByExample(@Param("record") PrjReport record, @Param("example") PrjReportExample example);

    int updateByPrimaryKeySelective(PrjReport record);

    int updateByPrimaryKey(PrjReport record);
}
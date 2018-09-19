package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.PrjConstructionLog;
import org.ldxx.bean.PrjConstructionLogExample;

public interface PrjConstructionLogMapper {
    int countByExample(PrjConstructionLogExample example);

    int deleteByExample(PrjConstructionLogExample example);

    int deleteByPrimaryKey(String pclId);

    int insert(PrjConstructionLog record);

    int insertSelective(PrjConstructionLog record);

    List<PrjConstructionLog> selectByExample(PrjConstructionLogExample example);

    PrjConstructionLog selectByPrimaryKey(String pclId);

    int updateByExampleSelective(@Param("record") PrjConstructionLog record, @Param("example") PrjConstructionLogExample example);

    int updateByExample(@Param("record") PrjConstructionLog record, @Param("example") PrjConstructionLogExample example);

    int updateByPrimaryKeySelective(PrjConstructionLog record);

    int updateByPrimaryKey(PrjConstructionLog record);
}
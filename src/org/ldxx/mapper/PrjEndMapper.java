package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.PrjEnd;
import org.ldxx.bean.PrjEndExample;

public interface PrjEndMapper {
    int countByExample(PrjEndExample example);

    int deleteByExample(PrjEndExample example);

    int deleteByPrimaryKey(String pelId);

    int insert(PrjEnd record);

    int insertSelective(PrjEnd record);

    List<PrjEnd> selectByExample(PrjEndExample example);

    PrjEnd selectByPrimaryKey(String pelId);

    int updateByExampleSelective(@Param("record") PrjEnd record, @Param("example") PrjEndExample example);

    int updateByExample(@Param("record") PrjEnd record, @Param("example") PrjEndExample example);

    int updateByPrimaryKeySelective(PrjEnd record);

    int updateByPrimaryKey(PrjEnd record);
}
package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.PrjEndWorkApply;
import org.ldxx.bean.PrjEndWorkApplyExample;

public interface PrjEndWorkApplyMapper {
    int countByExample(PrjEndWorkApplyExample example);

    int deleteByExample(PrjEndWorkApplyExample example);

    int deleteByPrimaryKey(String peId);

    int insert(PrjEndWorkApply record);

    int insertSelective(PrjEndWorkApply record);

    List<PrjEndWorkApply> selectByExample(PrjEndWorkApplyExample example);

    PrjEndWorkApply selectByPrimaryKey(String peId);

    int updateByExampleSelective(@Param("record") PrjEndWorkApply record, @Param("example") PrjEndWorkApplyExample example);

    int updateByExample(@Param("record") PrjEndWorkApply record, @Param("example") PrjEndWorkApplyExample example);

    int updateByPrimaryKeySelective(PrjEndWorkApply record);

    int updateByPrimaryKey(PrjEndWorkApply record);
}
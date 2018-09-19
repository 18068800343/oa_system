package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.MaterialDemand;
import org.ldxx.bean.MaterialDemandExample;

public interface MaterialDemandMapper {
    int countByExample(MaterialDemandExample example);

    int deleteByExample(MaterialDemandExample example);

    int deleteByPrimaryKey(String mdlId);

    int insert(MaterialDemand record);

    int insertSelective(MaterialDemand record);

    List<MaterialDemand> selectByExample(MaterialDemandExample example);

    MaterialDemand selectByPrimaryKey(String mdlId);

    int updateByExampleSelective(@Param("record") MaterialDemand record, @Param("example") MaterialDemandExample example);

    int updateByExample(@Param("record") MaterialDemand record, @Param("example") MaterialDemandExample example);

    int updateByPrimaryKeySelective(MaterialDemand record);

    int updateByPrimaryKey(MaterialDemand record);
}
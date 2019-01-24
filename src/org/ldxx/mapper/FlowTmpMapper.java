package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FlowTmp;
import org.ldxx.bean.FlowTmpExample;

public interface FlowTmpMapper {
    int countByExample(FlowTmpExample example);

    int deleteByExample(FlowTmpExample example);

    int deleteByPrimaryKey(String id);

    int insert(FlowTmp record);

    int insertSelective(FlowTmp record);

    List<FlowTmp> selectByExample(FlowTmpExample example);
    
    List<FlowTmp> selectAllFlowTmp();

    FlowTmp selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FlowTmp record, @Param("example") FlowTmpExample example);

    int updateByExample(@Param("record") FlowTmp record, @Param("example") FlowTmpExample example);

    int updateByPrimaryKeySelective(FlowTmp record);

    int updateByPrimaryKey(FlowTmp record);
}
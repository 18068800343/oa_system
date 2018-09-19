package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FlowEdge;
import org.ldxx.bean.FlowEdgeExample;

public interface FlowEdgeMapper {
    int countByExample(FlowEdgeExample example);

    int deleteByExample(FlowEdgeExample example);

    int deleteByPrimaryKey(String id);

    int insert(FlowEdge record);

    int insertSelective(FlowEdge record);

    List<FlowEdge> selectByExampleWithBLOBs(FlowEdgeExample example);

    List<FlowEdge> selectByExample(FlowEdgeExample example);

    FlowEdge selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FlowEdge record, @Param("example") FlowEdgeExample example);

    int updateByExampleWithBLOBs(@Param("record") FlowEdge record, @Param("example") FlowEdgeExample example);

    int updateByExample(@Param("record") FlowEdge record, @Param("example") FlowEdgeExample example);

    int updateByPrimaryKeySelective(FlowEdge record);

    int updateByPrimaryKeyWithBLOBs(FlowEdge record);

    int updateByPrimaryKey(FlowEdge record);
}
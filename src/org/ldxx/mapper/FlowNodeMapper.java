package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FlowNode;
import org.ldxx.bean.FlowNodeExample;
import org.ldxx.bean.NodeActorsVo;
import org.ldxx.bean.NodeRoleName;

public interface FlowNodeMapper {
    int countByExample(FlowNodeExample example);

    int deleteByExample(FlowNodeExample example);

    int deleteByPrimaryKey(String id);

    int insert(FlowNode record);

    int insertSelective(FlowNode record);

    List<FlowNode> selectByExample(FlowNodeExample example);
    
    FlowNode selectStartFlowNode(String id);
    
    NodeActorsVo selectNodeActors(String id);

    FlowNode selectByPrimaryKey(String id);
    
    List<String> selectFlowNodeRoleByTmpId(String id);

    int updateByExampleSelective(@Param("record") FlowNode record, @Param("example") FlowNodeExample example);

    int updateByExample(@Param("record") FlowNode record, @Param("example") FlowNodeExample example);

    int updateByPrimaryKeySelective(FlowNode record);

    int updateByPrimaryKey(FlowNode record);
}
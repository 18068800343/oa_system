package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.NodeActors;
import org.ldxx.bean.NodeActorsExample;
import org.ldxx.bean.NodeActorsVo;

public interface NodeActorsMapper {
    int countByExample(NodeActorsExample example);

    int deleteByExample(NodeActorsExample example);

    int deleteByPrimaryKey(String id);

    int insert(NodeActors record);

    int insertSelective(NodeActors record);

    List<NodeActors> selectByExample(NodeActorsExample example);

    NodeActors selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NodeActors record, @Param("example") NodeActorsExample example);

    int updateByExample(@Param("record") NodeActors record, @Param("example") NodeActorsExample example);

    int updateByPrimaryKeySelective(NodeActors record);

    int updateByPrimaryKey(NodeActors record);
    
    List<NodeActorsVo> getNextNodeActors(@Param("id")String id,@Param("userId")String userId);
    
    List<NodeActors> getNextNodeActorsByFloNodeId(@Param("id")String id);
}
package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FlowNodeActor;
import org.ldxx.bean.FlowNodeActorExample;

public interface FlowNodeActorMapper {
    int countByExample(FlowNodeActorExample example);

    int deleteByExample(FlowNodeActorExample example);

    int deleteByPrimaryKey(String id);

    int insert(FlowNodeActor record);

    int insertSelective(FlowNodeActor record);

    List<FlowNodeActor> selectByExample(FlowNodeActorExample example);

    FlowNodeActor selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FlowNodeActor record, @Param("example") FlowNodeActorExample example);

    int updateByExample(@Param("record") FlowNodeActor record, @Param("example") FlowNodeActorExample example);

    int updateByPrimaryKeySelective(FlowNodeActor record);

    int updateByPrimaryKey(FlowNodeActor record);
}
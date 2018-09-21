package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.FlowHistroyExample;
import org.ldxx.model.FlowHistoryVo;

public interface FlowHistroyMapper {
    int countByExample(FlowHistroyExample example);

    int deleteByExample(FlowHistroyExample example);

    int deleteByPrimaryKey(String id);

    int insert(FlowHistroy record);

    int insertSelective(FlowHistroy record);

    List<FlowHistroy> selectByExampleWithBLOBs(FlowHistroyExample example);

    List<FlowHistroy> selectByExample(FlowHistroyExample example);

    FlowHistroy selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FlowHistroy record, @Param("example") FlowHistroyExample example);

    int updateByExampleWithBLOBs(@Param("record") FlowHistroy record, @Param("example") FlowHistroyExample example);

    int updateByExample(@Param("record") FlowHistroy record, @Param("example") FlowHistroyExample example);

    int updateByPrimaryKeySelective(FlowHistroy record);

    int updateByPrimaryKeyWithBLOBs(FlowHistroy record);

    int updateByPrimaryKey(FlowHistroy record);
    
    List<FlowHistoryVo> getFlowHistoryVoByUserId(String userId,String status);
    
    List<FlowHistoryVo> getFlowHistoryVoByUserIdAlreadyEnd(String userId);
    
}
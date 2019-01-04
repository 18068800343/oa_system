package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.FlowHistroyExample;
import org.ldxx.model.FlowHistoryNowAndLast;
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
    
    List<FlowHistoryVo> getFlowHistoryVoByUserId(@Param("userId")String userId,@Param("status")String status);
    
    List<FlowHistoryVo> getFlowHistoryDeleteVoByUserId(@Param("userId")String userId,@Param("status")String status);
    
    List<FlowHistoryVo> getDistinctFlowHistoryByUser(@Param("userId")String userId,@Param("status")String status);
    
    List<FlowHistoryVo> getFlowHistoryVoByUserIdAlreadyEnd(@Param("userId")String userId);
    
    List<FlowHistoryVo> getTuiHuiFlowHistoryVo(@Param("url")String url,@Param("flowNodeLast")String flowNodeLast);
    
    int deleteFlowHistory(@Param("id")String id);
    
    List<FlowHistoryNowAndLast> getFlowHistorysLeftJoinByUrl(String url);
    
    List<FlowHistroy> getDistinctFlowHistorysByOperateType(String url);
}
package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.CurrentFlowExample;
import org.ldxx.model.CurrentFlowVo;

public interface CurrentFlowChaoSongMapper {
    int countByExample(CurrentFlowExample example);

    int deleteByExample(CurrentFlowExample example);

    int deleteByPrimaryKey(String id);

    int insert(CurrentFlow record);

    int insertSelective(CurrentFlow record);

    List<CurrentFlow> selectByExample(CurrentFlowExample example);

    CurrentFlow selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CurrentFlow record, @Param("example") CurrentFlowExample example);

    int updateByExample(@Param("record") CurrentFlow record, @Param("example") CurrentFlowExample example);

    int updateByPrimaryKeySelective(CurrentFlow record);

    int updateByPrimaryKey(CurrentFlow record);
    
    List<CurrentFlowVo> getCurrentFlowVoChaoSongByUserId(@Param("userId")String userId);
}
package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.CurrentFlowExample;
import org.ldxx.model.CurrentFlowVo;

public interface CurrentFlowMapper {
    int countByExample(CurrentFlowExample example);

    int deleteByExample(CurrentFlowExample example);

    int deleteByPrimaryKey(String id);

    int insert(CurrentFlow record);

    int insertSelective(CurrentFlow record);

    List<CurrentFlow> selectByExample(CurrentFlowExample example);
    
    List<CurrentFlow> selectByExampleNew(@Param("url") String url);

    CurrentFlow selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CurrentFlow record, @Param("example") CurrentFlowExample example);

    int updateByExample(@Param("record") CurrentFlow record, @Param("example") CurrentFlowExample example);

    int updateByPrimaryKeySelective(CurrentFlow record);

    int updateByPrimaryKey(CurrentFlow record);
    
    int updateFkDept(@Param("id")String id,@Param("fkDept")String fkDept);
    
    int updateFkDeptByModeId(@Param("id")String id,@Param("fkDept")String fkDept);
    
    List<CurrentFlowVo> getCurrentFlowVoByUserId(@Param("userId")String userId,@Param("status")String status);
    
    List<CurrentFlowVo> getCurrentFlowVoByStatus(@Param("userId")String userId,@Param("status")String status);
    
    List<CurrentFlow> selectByExampleAndDeptName(String url);
}
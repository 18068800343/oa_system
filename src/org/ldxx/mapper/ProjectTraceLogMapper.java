package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ProjectTraceLog;
import org.ldxx.bean.ProjectTraceLogExample;

public interface ProjectTraceLogMapper {
    int countByExample(ProjectTraceLogExample example);

    int deleteByExample(ProjectTraceLogExample example);

    int deleteByPrimaryKey(String ptlId);

    int insert(ProjectTraceLog record);

    int insertSelective(ProjectTraceLog record);

    List<ProjectTraceLog> selectByExampleWithBLOBs(ProjectTraceLogExample example);

    List<ProjectTraceLog> selectByExample(ProjectTraceLogExample example);

    ProjectTraceLog selectByPrimaryKey(String ptlId);

    int updateByExampleSelective(@Param("record") ProjectTraceLog record, @Param("example") ProjectTraceLogExample example);

    int updateByExampleWithBLOBs(@Param("record") ProjectTraceLog record, @Param("example") ProjectTraceLogExample example);

    int updateByExample(@Param("record") ProjectTraceLog record, @Param("example") ProjectTraceLogExample example);

    int updateByPrimaryKeySelective(ProjectTraceLog record);

    int updateByPrimaryKeyWithBLOBs(ProjectTraceLog record);

    int updateByPrimaryKey(ProjectTraceLog record);
}
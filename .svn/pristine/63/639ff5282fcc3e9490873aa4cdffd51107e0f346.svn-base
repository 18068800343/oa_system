package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ProjectTrace;
import org.ldxx.bean.ProjectTraceExample;

public interface ProjectTraceMapper {
    int countByExample(ProjectTraceExample example);

    int deleteByExample(ProjectTraceExample example);

    int deleteByPrimaryKey(String ptId);

    int insert(ProjectTrace record);

    int insertSelective(ProjectTrace record);

    List<ProjectTrace> selectByExample(ProjectTraceExample example);

    ProjectTrace selectByPrimaryKey(String ptId);

    int updateByExampleSelective(@Param("record") ProjectTrace record, @Param("example") ProjectTraceExample example);

    int updateByExample(@Param("record") ProjectTrace record, @Param("example") ProjectTraceExample example);

    int updateByPrimaryKeySelective(ProjectTrace record);

    int updateByPrimaryKey(ProjectTrace record);
}
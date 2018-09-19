package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ProjectScale;
import org.ldxx.bean.ProjectScaleExample;

public interface ProjectScaleMapper {
    int countByExample(ProjectScaleExample example);

    int deleteByExample(ProjectScaleExample example);

    int deleteByPrimaryKey(String psId);

    int insert(ProjectScale record);

    int insertSelective(ProjectScale record);

    List<ProjectScale> selectByExample(ProjectScaleExample example);

    ProjectScale selectByPrimaryKey(String psId);

    int updateByExampleSelective(@Param("record") ProjectScale record, @Param("example") ProjectScaleExample example);

    int updateByExample(@Param("record") ProjectScale record, @Param("example") ProjectScaleExample example);

    int updateByPrimaryKeySelective(ProjectScale record);

    int updateByPrimaryKey(ProjectScale record);
}
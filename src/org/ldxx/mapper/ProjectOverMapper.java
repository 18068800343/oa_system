package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ProjectOver;
import org.ldxx.bean.ProjectOverExample;

public interface ProjectOverMapper {
    int countByExample(ProjectOverExample example);

    int deleteByExample(ProjectOverExample example);

    int deleteByPrimaryKey(String poId);

    int insert(ProjectOver record);

    int insertSelective(ProjectOver record);

    List<ProjectOver> selectByExample(ProjectOverExample example);

    ProjectOver selectByPrimaryKey(String poId);

    int updateByExampleSelective(@Param("record") ProjectOver record, @Param("example") ProjectOverExample example);

    int updateByExample(@Param("record") ProjectOver record, @Param("example") ProjectOverExample example);

    int updateByPrimaryKeySelective(ProjectOver record);

    int updateByPrimaryKey(ProjectOver record);
}
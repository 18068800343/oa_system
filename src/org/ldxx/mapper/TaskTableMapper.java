package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.TaskTable;
import org.ldxx.bean.TaskTableExample;

public interface TaskTableMapper {
    int countByExample(TaskTableExample example);

    int deleteByExample(TaskTableExample example);

    int deleteByPrimaryKey(String id);

    int insert(TaskTable record);

    int insertSelective(TaskTable record);

    List<TaskTable> selectByExample(TaskTableExample example);

    TaskTable selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TaskTable record, @Param("example") TaskTableExample example);

    int updateByExample(@Param("record") TaskTable record, @Param("example") TaskTableExample example);

    int updateByPrimaryKeySelective(TaskTable record);

    int updateByPrimaryKey(TaskTable record);
}
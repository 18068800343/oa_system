package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.WorkParts;
import org.ldxx.bean.WorkPartsExample;

public interface WorkPartsMapper {
    int countByExample(WorkPartsExample example);

    int deleteByExample(WorkPartsExample example);

    int deleteByPrimaryKey(String wpId);

    int insert(WorkParts record);

    int insertSelective(WorkParts record);

    List<WorkParts> selectByExample(WorkPartsExample example);

    WorkParts selectByPrimaryKey(String wpId);

    int updateByExampleSelective(@Param("record") WorkParts record, @Param("example") WorkPartsExample example);

    int updateByExample(@Param("record") WorkParts record, @Param("example") WorkPartsExample example);

    int updateByPrimaryKeySelective(WorkParts record);

    int updateByPrimaryKey(WorkParts record);
}
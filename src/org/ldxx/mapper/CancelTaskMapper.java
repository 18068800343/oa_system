package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CancelTask;
import org.ldxx.bean.CancelTaskExample;

public interface CancelTaskMapper {
    int countByExample(CancelTaskExample example);

    int deleteByExample(CancelTaskExample example);

    int insert(CancelTask record);

    int insertSelective(CancelTask record);

    List<CancelTask> selectByExample(CancelTaskExample example);

    int updateByExampleSelective(@Param("record") CancelTask record, @Param("example") CancelTaskExample example);

    int updateByExample(@Param("record") CancelTask record, @Param("example") CancelTaskExample example);
}
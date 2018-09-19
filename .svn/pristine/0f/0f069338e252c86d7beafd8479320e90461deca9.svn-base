package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ModeStatus;
import org.ldxx.bean.ModeStatusExample;

public interface ModeStatusMapper {
    int countByExample(ModeStatusExample example);

    int deleteByExample(ModeStatusExample example);

    int deleteByPrimaryKey(String modeId);

    int insert(ModeStatus record);

    int insertSelective(ModeStatus record);

    List<ModeStatus> selectByExample(ModeStatusExample example);

    ModeStatus selectByPrimaryKey(String modeId);

    int updateByExampleSelective(@Param("record") ModeStatus record, @Param("example") ModeStatusExample example);

    int updateByExample(@Param("record") ModeStatus record, @Param("example") ModeStatusExample example);

    int updateByPrimaryKeySelective(ModeStatus record);

    int updateByPrimaryKey(ModeStatus record);
}
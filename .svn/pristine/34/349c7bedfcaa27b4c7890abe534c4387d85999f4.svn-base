package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.OutTrain;
import org.ldxx.bean.OutTrainExample;
import org.ldxx.bean.OutTrainWithBLOBs;

public interface OutTrainMapper {
    int countByExample(OutTrainExample example);

    int deleteByExample(OutTrainExample example);

    int insert(OutTrainWithBLOBs record);

    int insertSelective(OutTrainWithBLOBs record);

    List<OutTrainWithBLOBs> selectByExampleWithBLOBs(OutTrainExample example);

    List<OutTrain> selectByExample(OutTrainExample example);

    int updateByExampleSelective(@Param("record") OutTrainWithBLOBs record, @Param("example") OutTrainExample example);

    int updateByExampleWithBLOBs(@Param("record") OutTrainWithBLOBs record, @Param("example") OutTrainExample example);

    int updateByExample(@Param("record") OutTrain record, @Param("example") OutTrainExample example);
}
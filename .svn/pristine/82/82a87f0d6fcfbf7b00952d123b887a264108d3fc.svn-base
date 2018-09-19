package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.InternalTraining;
import org.ldxx.bean.InternalTrainingExample;
import org.ldxx.bean.InternalTrainingWithBLOBs;

public interface InternalTrainingMapper {
    int countByExample(InternalTrainingExample example);

    int deleteByExample(InternalTrainingExample example);

    int deleteByPrimaryKey(String itId);

    int insert(InternalTrainingWithBLOBs record);

    int insertSelective(InternalTrainingWithBLOBs record);

    List<InternalTrainingWithBLOBs> selectByExampleWithBLOBs(InternalTrainingExample example);

    List<InternalTraining> selectByExample(InternalTrainingExample example);

    InternalTrainingWithBLOBs selectByPrimaryKey(String itId);

    int updateByExampleSelective(@Param("record") InternalTrainingWithBLOBs record, @Param("example") InternalTrainingExample example);

    int updateByExampleWithBLOBs(@Param("record") InternalTrainingWithBLOBs record, @Param("example") InternalTrainingExample example);

    int updateByExample(@Param("record") InternalTraining record, @Param("example") InternalTrainingExample example);

    int updateByPrimaryKeySelective(InternalTrainingWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(InternalTrainingWithBLOBs record);

    int updateByPrimaryKey(InternalTraining record);
}
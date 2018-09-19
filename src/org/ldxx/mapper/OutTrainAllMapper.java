package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.OutTrainAll;
import org.ldxx.bean.OutTrainAllExample;
import org.ldxx.bean.OutTrainAllWithBLOBs;

public interface OutTrainAllMapper {
    int countByExample(OutTrainAllExample example);

    int deleteByExample(OutTrainAllExample example);

    int deleteByPrimaryKey(String otaId);

    int insert(OutTrainAllWithBLOBs record);

    int insertSelective(OutTrainAllWithBLOBs record);

    List<OutTrainAllWithBLOBs> selectByExampleWithBLOBs(OutTrainAllExample example);

    List<OutTrainAll> selectByExample(OutTrainAllExample example);

    OutTrainAllWithBLOBs selectByPrimaryKey(String otaId);

    int updateByExampleSelective(@Param("record") OutTrainAllWithBLOBs record, @Param("example") OutTrainAllExample example);

    int updateByExampleWithBLOBs(@Param("record") OutTrainAllWithBLOBs record, @Param("example") OutTrainAllExample example);

    int updateByExample(@Param("record") OutTrainAll record, @Param("example") OutTrainAllExample example);

    int updateByPrimaryKeySelective(OutTrainAllWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OutTrainAllWithBLOBs record);

    int updateByPrimaryKey(OutTrainAll record);
}
package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FbCancelContract;
import org.ldxx.bean.FbCancelContractExample;

public interface FbCancelContractMapper {
    int countByExample(FbCancelContractExample example);

    int deleteByExample(FbCancelContractExample example);

    int deleteByPrimaryKey(String fbcId);

    int insert(FbCancelContract record);

    int insertSelective(FbCancelContract record);

    List<FbCancelContract> selectByExample(FbCancelContractExample example);

    FbCancelContract selectByPrimaryKey(String fbcId);

    int updateByExampleSelective(@Param("record") FbCancelContract record, @Param("example") FbCancelContractExample example);

    int updateByExample(@Param("record") FbCancelContract record, @Param("example") FbCancelContractExample example);

    int updateByPrimaryKeySelective(FbCancelContract record);

    int updateByPrimaryKey(FbCancelContract record);
}
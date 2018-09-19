package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FbContract;
import org.ldxx.bean.FbContractExample;

public interface FbContractMapper {
    int countByExample(FbContractExample example);

    int deleteByExample(FbContractExample example);

    int deleteByPrimaryKey(String fbId);

    int insert(FbContract record);

    int insertSelective(FbContract record);

    List<FbContract> selectByExample(FbContractExample example);

    FbContract selectByPrimaryKey(String fbId);

    int updateByExampleSelective(@Param("record") FbContract record, @Param("example") FbContractExample example);

    int updateByExample(@Param("record") FbContract record, @Param("example") FbContractExample example);

    int updateByPrimaryKeySelective(FbContract record);

    int updateByPrimaryKey(FbContract record);
}
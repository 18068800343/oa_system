package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FbContractOver;
import org.ldxx.bean.FbContractOverExample;

public interface FbContractOverMapper {
    int countByExample(FbContractOverExample example);

    int deleteByExample(FbContractOverExample example);

    int deleteByPrimaryKey(String fcoId);

    int insert(FbContractOver record);

    int insertSelective(FbContractOver record);

    List<FbContractOver> selectByExample(FbContractOverExample example);

    FbContractOver selectByPrimaryKey(String fcoId);

    int updateByExampleSelective(@Param("record") FbContractOver record, @Param("example") FbContractOverExample example);

    int updateByExample(@Param("record") FbContractOver record, @Param("example") FbContractOverExample example);

    int updateByPrimaryKeySelective(FbContractOver record);

    int updateByPrimaryKey(FbContractOver record);
}
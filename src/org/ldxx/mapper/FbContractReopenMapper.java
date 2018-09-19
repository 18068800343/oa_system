package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FbContractReopen;
import org.ldxx.bean.FbContractReopenExample;

public interface FbContractReopenMapper {
    int countByExample(FbContractReopenExample example);

    int deleteByExample(FbContractReopenExample example);

    int deleteByPrimaryKey(String fbrId);

    int insert(FbContractReopen record);

    int insertSelective(FbContractReopen record);

    List<FbContractReopen> selectByExample(FbContractReopenExample example);

    FbContractReopen selectByPrimaryKey(String fbrId);

    int updateByExampleSelective(@Param("record") FbContractReopen record, @Param("example") FbContractReopenExample example);

    int updateByExample(@Param("record") FbContractReopen record, @Param("example") FbContractReopenExample example);

    int updateByPrimaryKeySelective(FbContractReopen record);

    int updateByPrimaryKey(FbContractReopen record);
}
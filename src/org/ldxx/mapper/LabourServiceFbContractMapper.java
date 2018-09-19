package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.LabourServiceFbContract;
import org.ldxx.bean.LabourServiceFbContractExample;

public interface LabourServiceFbContractMapper {
    int countByExample(LabourServiceFbContractExample example);

    int deleteByExample(LabourServiceFbContractExample example);

    int deleteByPrimaryKey(String fcoId);

    int insert(LabourServiceFbContract record);

    int insertSelective(LabourServiceFbContract record);

    List<LabourServiceFbContract> selectByExample(LabourServiceFbContractExample example);

    LabourServiceFbContract selectByPrimaryKey(String fcoId);

    int updateByExampleSelective(@Param("record") LabourServiceFbContract record, @Param("example") LabourServiceFbContractExample example);

    int updateByExample(@Param("record") LabourServiceFbContract record, @Param("example") LabourServiceFbContractExample example);

    int updateByPrimaryKeySelective(LabourServiceFbContract record);

    int updateByPrimaryKey(LabourServiceFbContract record);
}
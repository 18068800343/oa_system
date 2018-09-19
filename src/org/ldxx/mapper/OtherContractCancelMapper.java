package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.OtherContractCancel;
import org.ldxx.bean.OtherContractCancelExample;

public interface OtherContractCancelMapper {
    int countByExample(OtherContractCancelExample example);

    int deleteByExample(OtherContractCancelExample example);

    int deleteByPrimaryKey(String ocId);

    int insert(OtherContractCancel record);

    int insertSelective(OtherContractCancel record);

    List<OtherContractCancel> selectByExample(OtherContractCancelExample example);

    OtherContractCancel selectByPrimaryKey(String ocId);

    int updateByExampleSelective(@Param("record") OtherContractCancel record, @Param("example") OtherContractCancelExample example);

    int updateByExample(@Param("record") OtherContractCancel record, @Param("example") OtherContractCancelExample example);

    int updateByPrimaryKeySelective(OtherContractCancel record);

    int updateByPrimaryKey(OtherContractCancel record);
}
package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.OtherContractReopen;
import org.ldxx.bean.OtherContractReopenExample;

public interface OtherContractReopenMapper {
    int countByExample(OtherContractReopenExample example);

    int deleteByExample(OtherContractReopenExample example);

    int deleteByPrimaryKey(String orId);

    int insert(OtherContractReopen record);

    int insertSelective(OtherContractReopen record);

    List<OtherContractReopen> selectByExample(OtherContractReopenExample example);

    OtherContractReopen selectByPrimaryKey(String orId);

    int updateByExampleSelective(@Param("record") OtherContractReopen record, @Param("example") OtherContractReopenExample example);

    int updateByExample(@Param("record") OtherContractReopen record, @Param("example") OtherContractReopenExample example);

    int updateByPrimaryKeySelective(OtherContractReopen record);

    int updateByPrimaryKey(OtherContractReopen record);
}
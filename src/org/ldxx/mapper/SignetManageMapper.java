package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.SignetManage;
import org.ldxx.bean.SignetManageExample;

public interface SignetManageMapper {
    int countByExample(SignetManageExample example);

    int deleteByExample(SignetManageExample example);

    int deleteByPrimaryKey(String smId);

    int insert(SignetManage record);

    int insertSelective(SignetManage record);

    List<SignetManage> selectByExampleWithBLOBs(SignetManageExample example);

    List<SignetManage> selectByExample(SignetManageExample example);

    SignetManage selectByPrimaryKey(String smId);

    int updateByExampleSelective(@Param("record") SignetManage record, @Param("example") SignetManageExample example);

    int updateByExampleWithBLOBs(@Param("record") SignetManage record, @Param("example") SignetManageExample example);

    int updateByExample(@Param("record") SignetManage record, @Param("example") SignetManageExample example);

    int updateByPrimaryKeySelective(SignetManage record);

    int updateByPrimaryKeyWithBLOBs(SignetManage record);

    int updateByPrimaryKey(SignetManage record);
}
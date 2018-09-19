package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.MessageFunction;
import org.ldxx.bean.MessageFunctionExample;

public interface MessageFunctionMapper {
    int countByExample(MessageFunctionExample example);

    int deleteByExample(MessageFunctionExample example);

    int deleteByPrimaryKey(String mfId);

    int insert(MessageFunction record);

    int insertSelective(MessageFunction record);

    List<MessageFunction> selectByExample(MessageFunctionExample example);

    MessageFunction selectByPrimaryKey(String mfId);

    int updateByExampleSelective(@Param("record") MessageFunction record, @Param("example") MessageFunctionExample example);

    int updateByExample(@Param("record") MessageFunction record, @Param("example") MessageFunctionExample example);

    int updateByPrimaryKeySelective(MessageFunction record);

    int updateByPrimaryKey(MessageFunction record);
}
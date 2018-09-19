package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.MessageQuery;
import org.ldxx.bean.MessageQueryExample;

public interface MessageQueryMapper {
    int countByExample(MessageQueryExample example);

    int deleteByExample(MessageQueryExample example);

    int deleteByPrimaryKey(String mqId);

    int insert(MessageQuery record);

    int insertSelective(MessageQuery record);

    List<MessageQuery> selectByExample(MessageQueryExample example);

    MessageQuery selectByPrimaryKey(String mqId);

    int updateByExampleSelective(@Param("record") MessageQuery record, @Param("example") MessageQueryExample example);

    int updateByExample(@Param("record") MessageQuery record, @Param("example") MessageQueryExample example);

    int updateByPrimaryKeySelective(MessageQuery record);

    int updateByPrimaryKey(MessageQuery record);
}
package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.MessageNotice;
import org.ldxx.bean.MessageNoticeExample;

public interface MessageNoticeMapper {
    int countByExample(MessageNoticeExample example);

    int deleteByExample(MessageNoticeExample example);

    int deleteByPrimaryKey(String mnId);

    int insert(MessageNotice record);

    int insertSelective(MessageNotice record);

    List<MessageNotice> selectByExample(MessageNoticeExample example);

    MessageNotice selectByPrimaryKey(String mnId);

    int updateByExampleSelective(@Param("record") MessageNotice record, @Param("example") MessageNoticeExample example);

    int updateByExample(@Param("record") MessageNotice record, @Param("example") MessageNoticeExample example);

    int updateByPrimaryKeySelective(MessageNotice record);

    int updateByPrimaryKey(MessageNotice record);
}
package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Notifier;
import org.ldxx.bean.NotifierExample;

public interface NotifierMapper {
    int countByExample(NotifierExample example);

    int deleteByExample(NotifierExample example);

    int insert(Notifier record);

    int insertSelective(Notifier record);

    List<Notifier> selectByExample(NotifierExample example);

    int updateByExampleSelective(@Param("record") Notifier record, @Param("example") NotifierExample example);

    int updateByExample(@Param("record") Notifier record, @Param("example") NotifierExample example);
}
package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.SignetUsers;
import org.ldxx.bean.SignetUsersExample;

public interface SignetUsersMapper {
    int countByExample(SignetUsersExample example);

    int deleteByExample(SignetUsersExample example);

    int deleteByPrimaryKey(String suId);

    int insert(SignetUsers record);

    int insertSelective(SignetUsers record);

    List<SignetUsers> selectByExample(SignetUsersExample example);

    SignetUsers selectByPrimaryKey(String suId);

    int updateByExampleSelective(@Param("record") SignetUsers record, @Param("example") SignetUsersExample example);

    int updateByExample(@Param("record") SignetUsers record, @Param("example") SignetUsersExample example);

    int updateByPrimaryKeySelective(SignetUsers record);

    int updateByPrimaryKey(SignetUsers record);
}
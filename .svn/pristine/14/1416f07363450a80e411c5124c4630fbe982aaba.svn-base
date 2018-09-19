package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.DataArchive;
import org.ldxx.bean.DataArchiveExample;

public interface DataArchiveMapper {
    int countByExample(DataArchiveExample example);

    int deleteByExample(DataArchiveExample example);

    int deleteByPrimaryKey(String daId);

    int insert(DataArchive record);

    int insertSelective(DataArchive record);

    List<DataArchive> selectByExampleWithBLOBs(DataArchiveExample example);

    List<DataArchive> selectByExample(DataArchiveExample example);

    DataArchive selectByPrimaryKey(String daId);

    int updateByExampleSelective(@Param("record") DataArchive record, @Param("example") DataArchiveExample example);

    int updateByExampleWithBLOBs(@Param("record") DataArchive record, @Param("example") DataArchiveExample example);

    int updateByExample(@Param("record") DataArchive record, @Param("example") DataArchiveExample example);

    int updateByPrimaryKeySelective(DataArchive record);

    int updateByPrimaryKeyWithBLOBs(DataArchive record);

    int updateByPrimaryKey(DataArchive record);
}
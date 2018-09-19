package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Cooperator;
import org.ldxx.bean.ConsociationCompanyExample;
import org.ldxx.bean.ConsociationCompanyWithBLOBs;

public interface ConsociationCompanyMapper {
    int countByExample(ConsociationCompanyExample example);

    int deleteByExample(ConsociationCompanyExample example);

    int deleteByPrimaryKey(String ccId);

    int insert(ConsociationCompanyWithBLOBs record);

    int insertSelective(ConsociationCompanyWithBLOBs record);

    List<ConsociationCompanyWithBLOBs> selectByExampleWithBLOBs(ConsociationCompanyExample example);

    List<Cooperator> selectByExample(ConsociationCompanyExample example);

    ConsociationCompanyWithBLOBs selectByPrimaryKey(String ccId);

    int updateByExampleSelective(@Param("record") ConsociationCompanyWithBLOBs record, @Param("example") ConsociationCompanyExample example);

    int updateByExampleWithBLOBs(@Param("record") ConsociationCompanyWithBLOBs record, @Param("example") ConsociationCompanyExample example);

    int updateByExample(@Param("record") Cooperator record, @Param("example") ConsociationCompanyExample example);

    int updateByPrimaryKeySelective(ConsociationCompanyWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ConsociationCompanyWithBLOBs record);

    int updateByPrimaryKey(Cooperator record);
}
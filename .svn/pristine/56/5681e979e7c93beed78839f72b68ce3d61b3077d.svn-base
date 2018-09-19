package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Supplier;
import org.ldxx.bean.SourcingPurchasingExample;
import org.ldxx.bean.SourcingPurchasingWithBLOBs;

public interface SourcingPurchasingMapper {
    int countByExample(SourcingPurchasingExample example);

    int deleteByExample(SourcingPurchasingExample example);

    int deleteByPrimaryKey(Integer spId);

    int insert(SourcingPurchasingWithBLOBs record);

    int insertSelective(SourcingPurchasingWithBLOBs record);

    List<SourcingPurchasingWithBLOBs> selectByExampleWithBLOBs(SourcingPurchasingExample example);

    List<Supplier> selectByExample(SourcingPurchasingExample example);

    SourcingPurchasingWithBLOBs selectByPrimaryKey(Integer spId);

    int updateByExampleSelective(@Param("record") SourcingPurchasingWithBLOBs record, @Param("example") SourcingPurchasingExample example);

    int updateByExampleWithBLOBs(@Param("record") SourcingPurchasingWithBLOBs record, @Param("example") SourcingPurchasingExample example);

    int updateByExample(@Param("record") Supplier record, @Param("example") SourcingPurchasingExample example);

    int updateByPrimaryKeySelective(SourcingPurchasingWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SourcingPurchasingWithBLOBs record);

    int updateByPrimaryKey(Supplier record);
}
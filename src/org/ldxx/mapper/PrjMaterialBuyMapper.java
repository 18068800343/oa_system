package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.PrjMaterialBuy;
import org.ldxx.bean.PrjMaterialBuyExample;

public interface PrjMaterialBuyMapper {
    int countByExample(PrjMaterialBuyExample example);

    int deleteByExample(PrjMaterialBuyExample example);

    int deleteByPrimaryKey(String pmbId);

    int insert(PrjMaterialBuy record);

    int insertSelective(PrjMaterialBuy record);

    List<PrjMaterialBuy> selectByExample(PrjMaterialBuyExample example);

    PrjMaterialBuy selectByPrimaryKey(String pmbId);

    int updateByExampleSelective(@Param("record") PrjMaterialBuy record, @Param("example") PrjMaterialBuyExample example);

    int updateByExample(@Param("record") PrjMaterialBuy record, @Param("example") PrjMaterialBuyExample example);

    int updateByPrimaryKeySelective(PrjMaterialBuy record);

    int updateByPrimaryKey(PrjMaterialBuy record);
}
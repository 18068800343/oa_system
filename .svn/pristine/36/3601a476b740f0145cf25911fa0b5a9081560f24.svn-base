package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FinancialReceivables;
import org.ldxx.bean.FinancialReceivablesExample;

public interface FinancialReceivablesMapper {
    int countByExample(FinancialReceivablesExample example);

    int deleteByExample(FinancialReceivablesExample example);

    int deleteByPrimaryKey(String frId);

    int insert(FinancialReceivables record);

    int insertSelective(FinancialReceivables record);

    List<FinancialReceivables> selectByExample(FinancialReceivablesExample example);

    FinancialReceivables selectByPrimaryKey(String frId);

    int updateByExampleSelective(@Param("record") FinancialReceivables record, @Param("example") FinancialReceivablesExample example);

    int updateByExample(@Param("record") FinancialReceivables record, @Param("example") FinancialReceivablesExample example);

    int updateByPrimaryKeySelective(FinancialReceivables record);

    int updateByPrimaryKey(FinancialReceivables record);
}
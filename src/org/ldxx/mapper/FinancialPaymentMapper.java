package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.FinancialPayment;
import org.ldxx.bean.FinancialPaymentExample;

public interface FinancialPaymentMapper {
    int countByExample(FinancialPaymentExample example);

    int deleteByExample(FinancialPaymentExample example);

    int deleteByPrimaryKey(String fpId);

    int insert(FinancialPayment record);

    int insertSelective(FinancialPayment record);

    List<FinancialPayment> selectByExample(FinancialPaymentExample example);

    FinancialPayment selectByPrimaryKey(String fpId);

    int updateByExampleSelective(@Param("record") FinancialPayment record, @Param("example") FinancialPaymentExample example);

    int updateByExample(@Param("record") FinancialPayment record, @Param("example") FinancialPaymentExample example);

    int updateByPrimaryKeySelective(FinancialPayment record);

    int updateByPrimaryKey(FinancialPayment record);
}
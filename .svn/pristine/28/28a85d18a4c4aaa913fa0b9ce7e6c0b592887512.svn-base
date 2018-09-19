package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.InvoiceSign;
import org.ldxx.bean.InvoiceSignExample;

public interface InvoiceSignMapper {
    int countByExample(InvoiceSignExample example);

    int deleteByExample(InvoiceSignExample example);

    int deleteByPrimaryKey(String isId);

    int insert(InvoiceSign record);

    int insertSelective(InvoiceSign record);

    List<InvoiceSign> selectByExample(InvoiceSignExample example);

    InvoiceSign selectByPrimaryKey(String isId);

    int updateByExampleSelective(@Param("record") InvoiceSign record, @Param("example") InvoiceSignExample example);

    int updateByExample(@Param("record") InvoiceSign record, @Param("example") InvoiceSignExample example);

    int updateByPrimaryKeySelective(InvoiceSign record);

    int updateByPrimaryKey(InvoiceSign record);
}
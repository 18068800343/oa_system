package org.ldxx.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.AllQuery;

public interface AllQueryDao {

	public List<AllQuery> selectAllQueryByTime(@Param("year_time")String year_time,@Param("depart")String depart,@Param("omName")String omName);

	public List<AllQuery> getQueryTable(@Param("depart")String depart,@Param("omName")String omName, @Param("seachCjMoneyMin")BigDecimal seachCjMoneyMin, @Param("seachCjMoneyMax")BigDecimal seachCjMoneyMax,
			@Param("seachTimeMin")String seachTimeMin, @Param("seachTimeMax")String seachTimeMax, @Param("serchType")String serchType,@Param("serchYear")String serchYear);
	
}

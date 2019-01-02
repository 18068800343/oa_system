package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.AllQuery;

public interface AllQueryDao {

	public List<AllQuery> selectAllQueryByTime(@Param("year_time")String year_time,@Param("depart")String depart,@Param("omName")String omName);
	
}

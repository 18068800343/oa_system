package org.ldxx.dao;

import java.util.List;

import org.ldxx.bean.AllQuery;

public interface AllQueryDao {

	public List<AllQuery> selectAllQueryByTime(String year_time);
	
}

package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ClOut;

public interface ClOutDao {

	public int addClOut(@Param("out")ClOut out);
	
	public List<ClOut> selectClOut();
}

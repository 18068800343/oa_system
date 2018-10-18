package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ClRemain;

public interface ClRemainDao {
	
	public int addClRemain(@Param("cr") List<ClRemain> cr);
	

}

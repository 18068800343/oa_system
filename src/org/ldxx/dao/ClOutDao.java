package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ClOut;

public interface ClOutDao {

	public int addClOut(@Param("out")List<ClOut> out);
	
	public List<ClOut> selectClOutByNo(@Param("no")String no);
	
	public List<ClOut> selectClByNoAndTimeAndPerson(@Param("no")String no,@Param("time")String time,@Param("person")String person);
}

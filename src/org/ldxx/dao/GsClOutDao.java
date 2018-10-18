package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.GsClOut;

public interface GsClOutDao {

	List<GsClOut> selectClByNo(@Param("no")String no);
	
	List<GsClOut> selectClListByNo(@Param("no")String no);
	
	List<GsClOut> selectClListByName(@Param("name")String name);
	
	int updateRemain(@Param("id")String id,@Param("remain")int remain);
	
	int updateRemainForEnd(@Param("id")String id);
}

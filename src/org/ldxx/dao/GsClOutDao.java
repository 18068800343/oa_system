package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.GsClOut;
import org.ldxx.bean.outRemain;

public interface GsClOutDao {

	List<GsClOut> selectClByNo(@Param("no")String no);
	
	List<GsClOut> selectClListByNo(@Param("no")String no);
	
	List<GsClOut> selectClListByName(@Param("name")String name);
	
	int updateRemain(@Param("id")String id,@Param("remain")int remain);
	
	int updateRemainForEnd(@Param("id")String id);
	
	int updateRemainForWaste(@Param("cr")List<outRemain> cr);

	int addgsClOut(@Param("gsClOut")List<GsClOut> gsClOut);
	
	List<GsClOut> selectClListByIds(@Param("cgNo")String cgNo,@Param("cgName")String cgName,@Param("taskNo")String taskNo);
	
	List<GsClOut> selectClListByIds2(@Param("cgNo")String cgNo,@Param("cgName")String cgName,@Param("name")String name);
}

package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ProjectScale;

public interface ProjectScaleDao {

	public ProjectScale getProjectScale(@Param("type")String type,@Param("scale")String scale);
	
	public int updateScale(@Param("type")String type,@Param("scale")String scale,@Param("small")int small,@Param("big")int big);

}

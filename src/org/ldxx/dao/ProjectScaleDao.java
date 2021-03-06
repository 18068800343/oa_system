package org.ldxx.dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ProjectScale;

public interface ProjectScaleDao {

	public ProjectScale getProjectScale(@Param("type")String type,@Param("scale")String scale);
	
	public int updateScale(@Param("type")String type,@Param("scale")String scale,@Param("small")int small,@Param("big")int big);

	public ProjectScale selectProjectScale(@Param("type")String type,@Param("money")BigDecimal money);
}

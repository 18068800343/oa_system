package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ClRemain;
import org.ldxx.bean.GsClOut;
import org.ldxx.bean.outRemain;

public interface ClRemainDao {
	
	public int addClRemain(@Param("cr") List<ClRemain> cr);
	
	public List<ClRemain> selectGsClOutById(@Param("id")String id);
	
	public int updateClRemain(@Param("out")List<outRemain> out);

	public List<ClRemain> selectClRemainById(@Param("id")String id);

	public int updateClRemainNum(@Param("cr")ClRemain cr);

	public int updateRemainForWaste(@Param("remain")List<outRemain> remain);

	public int deleteClremainByGsoutId(@Param("id")String id);

	public int updateRemainNumById(@Param("id")String id, @Param("remain")String remain);
	
}

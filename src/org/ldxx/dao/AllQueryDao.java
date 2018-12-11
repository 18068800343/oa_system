package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Job;

public interface AllQueryDao {

	public List<Job> selectJobByType(@Param("type")String type);
	
	public int addJob(@Param("job")Job job);
	
	public int deleteJob(@Param("id")String id);
	
	public int updateJob(@Param("job")Job job);
	
	public int countOfJobSecond(@Param("second")String second,@Param("type")String type);
	
	public int countOfJobSecondToEdit(@Param("second")String second,@Param("type")String type,@Param("id")String id);
}

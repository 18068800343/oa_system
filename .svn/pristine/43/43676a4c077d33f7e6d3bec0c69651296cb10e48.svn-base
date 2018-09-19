package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.JobLv;

public interface JobLvDao {

	public List<JobLv> selectJobLv();
	
	public int addJobLv(@Param("job")JobLv job);
	
	public int deleteJobLv(@Param("id")String id);
	
	public int updateJobLv(@Param("job")JobLv job);
	
	public int countOfName(@Param("name")String name);
	
	public int countOfSize(@Param("size")int size);
	
	public int countOfNameToEdit(@Param("name")String name,@Param("id")String id);
	
	public int countOfSizeToEdit(@Param("size")int size,@Param("id")String id);
}

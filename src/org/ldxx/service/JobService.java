package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Job;

public interface JobService {

	public List<Job> selectJobByType(String type);
	
	public int addJob(Job job);
	
	public int deleteJob(String id);
	
	public int updateJob(Job job);
	
	public int countOfJobSecond(String second,String type);
	
	public int countOfJobSecondToEdit(String second,String type,String id);
}

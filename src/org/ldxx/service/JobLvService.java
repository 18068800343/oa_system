package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.JobLv;

public interface JobLvService {

	public List<JobLv> selectJobLv();
	
	public int addJobLv(JobLv job);
	
	public int deleteJobLv(String id);
	
	public int updateJobLv(JobLv job);
}

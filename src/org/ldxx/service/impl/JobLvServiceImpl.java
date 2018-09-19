package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.JobLv;
import org.ldxx.dao.JobLvDao;
import org.ldxx.service.JobLvService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobLvServiceImpl implements JobLvService{

	@Autowired
	private JobLvDao jldao;
	
	@Override
	public List<JobLv> selectJobLv() {
		return jldao.selectJobLv();
	}

	@Override
	public int addJobLv(JobLv job) {
		int i=jldao.countOfName(job.getJobLvName());
		if(i==0){
			i=jldao.countOfSize(job.getJobLvSize());
			if(i==0){
				i=jldao.addJobLv(job);
			}else{
				i=3;
			}
		}else{
			i=2;
		}
		return i;
	}

	@Override
	public int deleteJobLv(String id) {
		return jldao.deleteJobLv(id);
	}

	@Override
	public int updateJobLv(JobLv job) {
		int i=jldao.countOfNameToEdit(job.getJobLvName(),job.getJobLvId());
		if(i<1){
			i=jldao.countOfSizeToEdit(job.getJobLvSize(),job.getJobLvId());
			if(i<1){
				i=jldao.updateJobLv(job);
			}else{
				i=3;
			}
		}else{
			i=2;
		}
		return i;
	}

}

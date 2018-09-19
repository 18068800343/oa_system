package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Job;
import org.ldxx.dao.JobDao;
import org.ldxx.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService{

	
	@Autowired
	private JobDao jdao;
	
	@Override
	public List<Job> selectJobByType(String type) {
		return jdao.selectJobByType(type);
	}

	@Override
	public int addJob(Job job) {
		return jdao.addJob(job);
	}

	@Override
	public int deleteJob(String id) {
		return jdao.deleteJob(id);
	}

	@Override
	public int updateJob(Job job) {
		return jdao.updateJob(job);
	}

	@Override
	public int countOfJobSecond(String second, String type) {
		return jdao.countOfJobSecond(second, type);
	}

	@Override
	public int countOfJobSecondToEdit(String second, String type, String id) {
		return jdao.countOfJobSecondToEdit(second, type, id);
	}

}

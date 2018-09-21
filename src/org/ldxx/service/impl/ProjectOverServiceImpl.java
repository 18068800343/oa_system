package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.ProjectOver;
import org.ldxx.dao.ProjectOverDao;
import org.ldxx.service.ProjectOverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjectOverServiceImpl implements ProjectOverService {
	
	@Autowired
	private ProjectOverDao prjDao;

	@Override
	public int addPrjOver(ProjectOver projectOver) {
		return prjDao.addPrjOver(projectOver);
	}

	@Override
	public int deletePrjOver(String poId) {
		return prjDao.deletePrjOver(poId);
	}

	@Override
	public int updatePrjOverById(ProjectOver projectOver) {
		return prjDao.updatePrjOverById(projectOver);
	}

	@Override
	public List<ProjectOver> selectPrjOver(String status) {
		return prjDao.selectPrjOver(status);
	}

	@Override
	public ProjectOver selectPrjOverById(String poId) {
		return prjDao.selectPrjOverById(poId);
	}

}

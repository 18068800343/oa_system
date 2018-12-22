package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.ResultManagementSignet;
import org.ldxx.dao.ResultsUsingDao;
import org.ldxx.service.ResultsUsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ResultsUsingServiceImpl implements ResultsUsingService {

	@Autowired
	private ResultsUsingDao rUsingDao;

	@Override
	public List<ResultManagementSignet> selectResultsUsing(String status) {
		return rUsingDao.selectResultsUsing(status);
	}

	@Override
	public int addResultsUsing(ResultManagementSignet rs) {
		return rUsingDao.addResultsUsing(rs);
	}

	@Override
	public int deleteResultsUsingById(String usId) {
		return rUsingDao.deleteResultsUsingById(usId);
	}

	@Override
	public int updateResultsUsingByIdSave(ResultManagementSignet rs) {
		return rUsingDao.updateResultsUsingByIdSave(rs);
	}

	@Override
	public ResultManagementSignet selectResultsUsingById(String usId) {
		return rUsingDao.selectResultsUsingById(usId);
	}
}

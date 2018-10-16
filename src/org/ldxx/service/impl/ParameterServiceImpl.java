package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Parameter;
import org.ldxx.dao.ParameterDao;
import org.ldxx.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ParameterServiceImpl implements ParameterService {

	
	@Autowired
	private ParameterDao dao;

	@Override
	public List<Parameter> selectParameter() {
		return dao.selectParameter();
	}

	@Override
	public int addParameter(Parameter p) {
		return dao.addParameter(p);
	}

	@Override
	public int deleteParameter(String id) {
		return dao.deleteParameter(id);
	}

	@Override
	public int updateParameter(Parameter p) {
		return dao.updateParameter(p);
	}
}

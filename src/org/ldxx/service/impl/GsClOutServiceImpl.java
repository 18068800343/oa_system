package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.GsClOut;
import org.ldxx.dao.GsClOutDao;
import org.ldxx.service.GsClOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GsClOutServiceImpl implements GsClOutService{

	@Autowired
	private GsClOutDao dao;
	
	@Override
	public List<GsClOut> selectClByNo(String no) {
		return dao.selectClByNo(no);
	}

	@Override
	public List<GsClOut> selectClListByNo(String no) {
		return dao.selectClListByNo(no);
	}

	@Override
	public List<GsClOut> selectClListByName(String name) {
		return dao.selectClListByName(name);
	}

	@Override
	public int updateRemain(String id, int remain) {
		return dao.updateRemain(id, remain);
	}

}

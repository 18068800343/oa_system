package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.ClOut;
import org.ldxx.dao.ClOutDao;
import org.ldxx.service.ClOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClOutServiceImpl implements ClOutService{

	@Autowired
	private ClOutDao cdao;
	
	@Override
	public int addClOut(ClOut out) {
		return cdao.addClOut(out);
	}

	@Override
	public List<ClOut> selectClOut() {
		return cdao.selectClOut();
	}

}

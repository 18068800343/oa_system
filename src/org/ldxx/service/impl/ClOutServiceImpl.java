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
	public int addClOut(List<ClOut> out) {
		return cdao.addClOut(out);
	}

	@Override
	public List<ClOut> selectClOutByNo(String no) {
		return cdao.selectClOutByNo(no);
	}

	@Override
	public List<ClOut> selectClByNoAndTimeAndPerson(String no, String time, String person) {
		return cdao.selectClByNoAndTimeAndPerson(no, time, person);
	}

}

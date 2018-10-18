package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.ClRemain;
import org.ldxx.dao.ClRemainDao;
import org.ldxx.dao.GsClOutDao;
import org.ldxx.dao.GsMaterialOutDao;
import org.ldxx.service.ClRemainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClRemainServiceImpl implements ClRemainService{

	@Autowired
	private ClRemainDao dao;
	
	@Autowired
	private GsMaterialOutDao gdao;
	
	@Autowired
	private GsClOutDao goDao;
	
	@Transactional
	@Override
	public int addClRemain(List<ClRemain> cr) {
		int i=dao.addClRemain(cr);
		if(i>0){
			String id=cr.get(0).getGsOutId();
			i=gdao.updateRemainStatus(id);
			i=goDao.updateRemainForEnd(id);
		}
		return i;
	}

}

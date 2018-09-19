package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.OutTrainAll;
import org.ldxx.dao.OutTrainAllDao;
import org.ldxx.service.OutTrainAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutTrainAllServiceImpl implements OutTrainAllService{

	@Autowired
	private OutTrainAllDao odao;
	
	@Override
	public int addOutTrainAll(OutTrainAll trainAll) {
		return odao.addOutTrainAll(trainAll);
	}

	@Override
	public int deleteOutTrainAll(String id) {
		return odao.deleteOutTrainAll(id);
	}

	@Override
	public int updateOutTrainAll(OutTrainAll trainAll) {
		return odao.updateOutTrainAll(trainAll);
	}

	@Override
	public List<OutTrainAll> selectOutTrainAll() {
		return odao.selectOutTrainAll();
	}

}

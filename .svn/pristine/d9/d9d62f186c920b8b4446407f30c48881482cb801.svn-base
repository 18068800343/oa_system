package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.OutTrain;
import org.ldxx.dao.OutTrainDao;
import org.ldxx.service.OutTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutTrainServiceImpl implements OutTrainService{

	@Autowired
	private OutTrainDao odao;
	
	@Override
	public int addOutTrain(OutTrain outTrain) {
		return odao.addOutTrain(outTrain);
	}

	@Override
	public int deleteOutTrain(String id) {
		return odao.deleteOutTrain(id);
	}

	@Override
	public int updateOutTrain(OutTrain outTrain) {
		return odao.updateOutTrain(outTrain);
	}

	@Override
	public List<OutTrain> selectOutTrain() {
		return odao.selectOutTrain();
	}

}

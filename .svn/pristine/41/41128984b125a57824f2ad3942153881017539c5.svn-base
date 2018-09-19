package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.InternalTraining;
import org.ldxx.dao.InternalTrainingDao;
import org.ldxx.service.InternalTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternalTrainingServiceImpl implements InternalTrainingService{

	@Autowired
	private InternalTrainingDao idao;
	
	@Override
	public int addInternalTraining(InternalTraining training) {
		return idao.addInternalTraining(training);
	}

	@Override
	public int deleteInternalTraining(String id) {
		return idao.deleteInternalTraining(id);
	}


	@Override
	public List<InternalTraining> selectInternalTraining() {
		return idao.selectInternalTraining();
	}

	@Override
	public InternalTraining selectInternalTrainingById(String id) {
		return idao.selectInternalTrainingById(id);
	}

	@Override
	public int updateInternalTrainingHasFile(InternalTraining training) {
		return idao.updateInternalTrainingHasFile(training);
	}

	@Override
	public int updateInternalTrainingNoFile(InternalTraining training) {
		return idao.updateInternalTrainingNoFile(training);
	}

	@Override
	public int deleteFile(String id) {
		return idao.deleteFile(id);
	}

}

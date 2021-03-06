package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.InternalTraining;

public interface InternalTrainingService {

	public int addInternalTraining(InternalTraining training);
	
	public int deleteInternalTraining(String id);
	
	public int updateInternalTraining(InternalTraining training);
	
	public List<InternalTraining> selectInternalTraining();
	
	public InternalTraining selectInternalTrainingById(String id);

	public List<InternalTraining> getInternalTrainingName();
	
}

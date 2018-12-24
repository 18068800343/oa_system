package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.OutTrainAll;

public interface OutTrainAllService {

	public int addOutTrainAll(OutTrainAll trainAll);
	
	public int deleteOutTrainAll(String id);
	
	public int updateOutTrainAll(OutTrainAll trainAll);
	
	public List<OutTrainAll> selectOutTrainAll();
	
	public OutTrainAll selectOutTrainAllById(String id);
}

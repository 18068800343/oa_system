package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.InternalTraining;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.InternalTrainingDao;
import org.ldxx.service.InternalTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternalTrainingServiceImpl implements InternalTrainingService{

	@Autowired
	private InternalTrainingDao idao;
	
	@Autowired
	private AccessoryDao adao;
	
	@Override
	public int addInternalTraining(InternalTraining training) {
		int i=idao.addInternalTraining(training);
		if(i>0){
			List<Accessory> list=training.getAccessory();
			if(list.size()>0){
				i=adao.addAccessory(list);
			}
		}
		return i;
	}

	@Override
	public int deleteInternalTraining(String id) {
		return idao.deleteInternalTraining(id);
	}


	@Override
	public List<InternalTraining> selectInternalTraining() {
		List<InternalTraining> list=idao.selectInternalTraining();
		for(int i=0;i<list.size();i++){
			String id=list.get(i).getItId();
			List<Accessory> acc=adao.selectAccessoryById(id);
			list.get(i).setAccessory(acc);
		}
		return list;
	}

	@Override
	public InternalTraining selectInternalTrainingById(String id) {
		return idao.selectInternalTrainingById(id);
	}

	@Override
	public int updateInternalTraining(InternalTraining training) {
		int i=idao.updateInternalTraining(training);
		if(i>0){
			List<Accessory> list=training.getAccessory();
			if(list.size()>0){
				i=adao.addAccessory(list);
			}
		}
		return i;
	}

}

package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.OutTrain;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.OutTrainDao;
import org.ldxx.service.OutTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OutTrainServiceImpl implements OutTrainService{

	@Autowired
	private OutTrainDao odao;
	
	@Autowired
	private AccessoryDao adao;
	
	@Transactional
	@Override
	public int addOutTrain(OutTrain outTrain) {
		int i=odao.addOutTrain(outTrain);
		if(i>0){
			List<Accessory> list=outTrain.getAccessory();
			if(list.size()>0){
				i=adao.addAccessory(list);
			}
		}
		return i;
	}

	@Transactional
	@Override
	public int deleteOutTrain(String id) {
		return odao.deleteOutTrain(id);
	}

	@Override
	public int updateOutTrain(OutTrain outTrain) {
		int i=odao.updateOutTrain(outTrain);
		if(i>0){
			List<Accessory> list=outTrain.getAccessory();
			if(list.size()>0){
				i=adao.addAccessory(list);
			}
		}
		return i;
	}

	@Override
	public List<OutTrain> selectOutTrain() {
		List<OutTrain> list=odao.selectOutTrain();
		for(int i=0;i<list.size();i++){
			String id=list.get(i).getOtId();
			List<Accessory> acc=adao.selectAccessoryById(id);
			list.get(i).setAccessory(acc);
		}
		return list;
	}

	@Override
	public OutTrain selectOutTrainById(String id) {
		return odao.selectOutTrainById(id);
	}

	@Override
	public List<OutTrain> getOutTrainName() {
		return odao.getOutTrainName();
	}

}

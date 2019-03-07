package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.OutTrainAll;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.OutTrainAllDao;
import org.ldxx.service.OutTrainAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OutTrainAllServiceImpl implements OutTrainAllService{

	@Autowired
	private OutTrainAllDao odao;
	
	@Autowired
	private AccessoryDao adao;
	
	@Transactional
	@Override
	public int addOutTrainAll(OutTrainAll trainAll) {
		int i=odao.addOutTrainAll(trainAll);
		if(i>0){
			List<Accessory> list=trainAll.getAccessory();
			if(list.size()>0){
				i=adao.addAccessory(list);
			}
		}
		return i;
	}

	@Override
	public int deleteOutTrainAll(String id) {
		return odao.deleteOutTrainAll(id);
	}

	@Transactional
	@Override
	public int updateOutTrainAll(OutTrainAll trainAll) {
		int i=odao.updateOutTrainAll(trainAll);
		if(i>0){
			List<Accessory> list=trainAll.getAccessory();
			if(list.size()>0){
				adao.addAccessory(list);
			}
		}
		return i;
	}

	@Override
	public List<OutTrainAll> selectOutTrainAll() {
		List<OutTrainAll> list=odao.selectOutTrainAll();
		for(int i=0;i<list.size();i++){
			String id=list.get(i).getOtaId();
			List<Accessory> acc=adao.selectAccessoryById(id);
			list.get(i).setAccessory(acc);
		}
		return list;
	}

	@Override
	public OutTrainAll selectOutTrainAllById(String id) {
		return odao.selectOutTrainAllById(id);
	}

	@Override
	public List<OutTrainAll> getOutTrainAllName() {
		return odao.getOutTrainAllName();
	}

}

package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.FbContract;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.SubContractDao;
import org.ldxx.service.SubContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SubContractServiceImpl implements SubContractService {

	@Autowired
	private SubContractDao scDao;
	
	@Autowired
	private AccessoryDao adao;

	@Override
	public List<FbContract> selectSubContract(String status) {
		return scDao.selectSubContract(status);
	}

	@Override
	public int saveSubContract(FbContract fbContract) {
		int i=scDao.saveSubContract(fbContract);
		if(i>0){
			List<Accessory> accessory = fbContract.getAccessory();
			if(accessory!=null&&accessory.size()>0){
				i = adao.addAccessory(accessory);
			}
		}
		return i;
	}

	@Override
	public int deleteSubContractById(String id) {
		int i=scDao.deleteSubContractById(id);
		if(i>0){
			i=adao.deleteAccessory(id);
		}
		return i;
	}

	@Override
	public FbContract selectSubContractById(String id) {
		FbContract fc=scDao.selectSubContractById(id);
		List<Accessory> list = adao.selectAccessoryById(id);
		fc.setAccessory(list);
		return fc;
	}

	@Override
	public List<Accessory> selectAccessoryById(String id) {
		return adao.selectAccessoryById(id);
	}

	@Override
	public int updateSubContract(FbContract fbContract) {
		int i= scDao.updateSubContract(fbContract);
		if(i>0){
			List<Accessory> accessory = fbContract.getAccessory();
			if(accessory!=null&&accessory.size()>0){
				i=adao.addAccessory(accessory);
			}
		}
		return i;
	}

	@Override
	public int deleteAccessoryByIdAndName(Accessory accessory) {
		return adao.deleteAccessoryByIdAndName(accessory);
	}
}

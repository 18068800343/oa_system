package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CjContract;
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
	public int saveSubContract(FbContract fbContract) {
		int i=scDao.saveSubContract(fbContract);
		if(i>0){
			List<Accessory> accessory = fbContract.getAccessory();
			if(accessory!=null&&accessory.size()>0){
				i = adao.addAccessory(accessory);
			}
			List<Accessory> accessory1 = fbContract.getAccessory1();
			if(accessory1!=null&&accessory1.size()>0){
				i = adao.addAccessory(accessory1);
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
		if(list.size()!=0){
			fc.setAccessory(list);
		}
		return fc;
	}

	@Override
	public List<Accessory> selectAccessoryById(String id) {
		return adao.selectAccessoryById(id);
	}

	@Transactional
	@Override
	public int updateSubContract(FbContract fbContract) {
		int i= scDao.updateSubContract(fbContract);
		if(i>0){
			List<Accessory> accessory = fbContract.getAccessory();
			if(accessory!=null&&accessory.size()>0){
				i=adao.addAccessory(accessory);
			}
			List<Accessory> accessory2 = fbContract.getAccessory1();
			if(accessory2!=null&&accessory2.size()>0){
				i=adao.addAccessory(accessory2);
			}
		}
		return i;
	}

	@Override
	public int deleteAccessoryByIdAndName(Accessory accessory) {
		return adao.deleteAccessoryByIdAndName(accessory);
	}

	@Override
	public List<FbContract> selectsubcontractHistory(String fbNo) {
		return scDao.selectsubcontractHistory(fbNo);
	}

	@Override
	public int fbNocount() {
		return scDao.fbNocount();
	}


	@Override
	public List<FbContract> getFBNameAndNo() {
		return scDao.getFBNameAndNo();
	}

	@Override
	public FbContract getFBNameByNo(String fbNo) {
		return scDao.getFBNameByNo(fbNo);
	}

	@Override
	public FbContract getFBNoByName(String contractName) {
		return scDao.getFBNoByName(contractName);
	}

	@Override
	public FbContract getFBContractByName(String contractName) {
		return scDao.getFBContractByName(contractName);
	}

	@Override
	public FbContract getFBContractByNo(String no) {
		return scDao.getFBContractByNo(no);
	}

	@Override
	public List<FbContract> getFbcjNo() {
		return scDao.getFbcjNo();
	}

	@Override
	public List<FbContract> getFBNoBycjNo(String no) {
		return scDao.getFBNoBycjNo(no);
	}

	@Override
	public List<FbContract> getFBNameAndNo2() {
		return scDao.getFBNameAndNo2();
	}

	@Override
	public List<FbContract> selectSubContract(String status, String startMin, String startMax, String endMin,
			String endMax, String mainDp, String spType, float fbMoneyMin, float fbMoneyMax, float contractMoneyMin,
			float contractMoneyMax, float zdMoneyMin, float zdMoneyMax) {
		return scDao.selectSubContract(status, startMin, startMax, endMin, endMax, mainDp, spType, fbMoneyMin, fbMoneyMax, contractMoneyMin, contractMoneyMax, zdMoneyMin, zdMoneyMax);
	}

	@Override
	public int updateHistoryById(String id) {
		int i= scDao.updateHistoryById(id);
		if(i>0){
			i=scDao.updateHistoryNow(id);
		}
		return i;
	}

	@Override
	public CjContract getCjContractMainPrjLeaderByFbNo(String fbNo) {
		return scDao.getCjContractMainPrjLeaderByFbNo(fbNo);
	}

}

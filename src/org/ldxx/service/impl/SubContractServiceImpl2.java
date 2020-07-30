package org.ldxx.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.FbCgContract;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.SubContractDao2;
import org.ldxx.service.SubContractService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SubContractServiceImpl2 implements SubContractService2 {

	@Autowired
	private SubContractDao2 scDao;
	
	@Autowired
	private AccessoryDao adao;

	@Override
	public int saveSubContract(FbCgContract fbContract) {
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
	public FbCgContract selectSubContractById(String id) {
		FbCgContract fc=scDao.selectSubContractById(id);
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
	public int updateSubContract(FbCgContract fbContract) {
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
	public List<FbCgContract> selectsubcontractHistory(String fbNo) {
		return scDao.selectsubcontractHistory(fbNo);
	}

	@Override
	public int fbNocount(String year) {
		year="%"+year+"%";
		return scDao.fbNocount(year);
	}


	@Override
	public List<FbCgContract> getFBNameAndNo() {
		return scDao.getFBNameAndNo();
	}

	@Override
	public FbCgContract getFBNameByNo(String fbNo) {
		return scDao.getFBNameByNo(fbNo);
	}

	@Override
	public FbCgContract getFBNoByName(String contractName) {
		return scDao.getFBNoByName(contractName);
	}

	@Override
	public FbCgContract getFBContractByName(String contractName) {
		return scDao.getFBContractByName(contractName);
	}

	@Override
	public FbCgContract getFBContractByNo(String no) {
		return scDao.getFBContractByNo(no);
	}

	@Override
	public List<FbCgContract> getFbcjNo() {
		return scDao.getFbcjNo();
	}

	@Override
	public List<FbCgContract> getFBNoBycjNo(String no) {
		return scDao.getFBNoBycjNo(no);
	}

	@Override
	public List<FbCgContract> getFBNameAndNo2() {
		return scDao.getFBNameAndNo2();
	}

	@Override
	public List<FbCgContract> selectSubContract(String status, String startMin, String startMax, String endMin,
			String endMax, String mainDp, String spType, BigDecimal fbMoneyMin, BigDecimal fbMoneyMax, BigDecimal contractMoneyMin,
			BigDecimal contractMoneyMax, BigDecimal zdMoneyMin, BigDecimal zdMoneyMax) {
		return scDao.selectSubContract(status, startMin, startMax, endMin, endMax, mainDp, spType, fbMoneyMin, fbMoneyMax, contractMoneyMin, contractMoneyMax, zdMoneyMin, zdMoneyMax);
	}
	
	@Override
	public List<FbCgContract> selectSubContract2(String startMin, String startMax, String endMin,
			String endMax, String mainDp, String spType, BigDecimal fbMoneyMin, BigDecimal fbMoneyMax, BigDecimal contractMoneyMin,
			BigDecimal contractMoneyMax, BigDecimal zdMoneyMin, BigDecimal zdMoneyMax) {
		return scDao.selectSubContract2(startMin, startMax, endMin, endMax, mainDp, spType, fbMoneyMin, fbMoneyMax, contractMoneyMin, contractMoneyMax, zdMoneyMin, zdMoneyMax);
	}

	@Override
	public int updateHistoryById(String id) {
		int i= scDao.updateHistoryById(id);
		
		i=scDao.updateHistoryNow(id);
		
		return i;
	}

	@Override
	public CjContract getCjContractMainPrjLeaderByFbNo(String fbNo) {
		return scDao.getCjContractMainPrjLeaderByFbNo(fbNo);
	}

	@Override
	public FbCgContract selectYiFangByNo(String no) {
		return scDao.selectYiFangByNo(no);
	}

	@Override
	public List<FbCgContract> selectFbContractByTaskNo(String no) {
		return scDao.selectFbContractByTaskNo(no);
	}

	@Override
	public int updateFbNoById(String id, String no) {
		return scDao.updateFbNoById(id, no);
	}

	@Override
	public FbCgContract selectFbContractShowByFbNo(String fbNo) {
		FbCgContract fbc = scDao.selectFbContractShowByFbNo(fbNo);
		//页面里有别人写的查询附件代码了。
		//List<Accessory> list = adao.selectAccessoryById(fbc.getFbId());
		//if(null!=list&&list.size()!=0){
			//fbc.setAccessory(list);
		//}
		return fbc;
	}

	@Override
	public String CreateEBContractNumOrder(String year) {
		return scDao.CreateEBContractNumOrder(year);
	}

}

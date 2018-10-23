package org.ldxx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CgContract;
import org.ldxx.bean.FbContract;
import org.ldxx.bean.PrjMaterialBuy;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.CgContractDao;
import org.ldxx.dao.MaterialDemandDao;
import org.ldxx.dao.PrjMaterialBuyDao;
import org.ldxx.service.CgContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CgContractServiceImpl implements CgContractService {
	
	@Autowired
	private CgContractDao cgDao;
	
	@Autowired
	private AccessoryDao adao;
	
	@Autowired
	private PrjMaterialBuyDao pdao;
	
	@Autowired
	private MaterialDemandDao mdao;

	@Override
	public List<CgContract> selectCgContractByStatus(String status) {
		return cgDao.selectCgContractByStatus(status);
	}

	@Override
	public int addCgContract(CgContract cg) {
		int i=cgDao.addCgContract(cg);
		if(i>0){
			List<Accessory> accessory=cg.getAccessory();
			if(accessory!=null&&accessory.size()>0){
				i=adao.addAccessory(accessory);
			}
		}
		return i;
	}

	@Override
	public int deleteCgContractById(String id) {
		int i=cgDao.deleteCgContractById(id);
		if(i>0){
			i=adao.deleteAccessory(id);
		}
		return i;
	}

	@Override
	public int updateCgContractSave(CgContract cg) {
		int i=cgDao.updateCgContractSave(cg);
		if(i>0){
			List<Accessory> accessory=cg.getAccessory();
			if(accessory!=null&&accessory.size()>0){
				i=adao.addAccessory(accessory);
			}
		}
		return i;
	}

	@Override
	public CgContract selectCgContractById(String id) {
		CgContract cg=cgDao.selectCgContractById(id);
		List<Accessory> list = adao.selectAccessoryById(id);
		if(list!=null){
			cg.setAccessory(list);
		}
		return cg;
	}

	@Override
	public List<Accessory> selectAccessoryById(String id) {
		return adao.selectAccessoryById(id);
	}

	@Override
	public int deleteAccessoryByIdAndName(Accessory accessory) {
		return adao.deleteAccessoryByIdAndName(accessory);
	}

	@Override
	public List<CgContract> selectCgIdAndName() {
		return cgDao.selectCgIdAndName();
	}

	@Override
	public CgContract selectCgnoById(String id) {
		return cgDao.selectCgnoById(id);
	}

	@Override
	public void updateHistoryById(String cgId) {
		cgDao.updateHistoryById(cgId);
	}

	@Override
	public List<CgContract> selectHistoryByNo(String cgNo) {
		return cgDao.selectHistoryByNo(cgNo);
	}

	@Override
	public int cgNocount() {
		return cgDao.cgNocount();
	}

	@Override
	public List<CgContract> getCGNameAndNo() {
		return cgDao.getCGNameAndNo();
	}

	@Override
	public List<CgContract> getCGNameByNo(String cgNo) {
		return cgDao.getCGNameByNo(cgNo);
	}

	@Override
	public List<CgContract> getCGNoByName(String contractName) {
		return cgDao.getCGNoByName(contractName);
	}

	@Override
	public List<CgContract> getCGNameAndPrjNameBytaskNo(String no) {
		return cgDao.getCGNameAndPrjNameBytaskNo(no);
	}

	@Override
	public List<CgContract> getCGNametaskNoAndByPrjName(String name) {
		return cgDao.getCGNametaskNoAndByPrjName(name);
	}


	@Override
	public int updateDepartmentMoney(float price, String id) {
		return pdao.updateSumPrice(price,id);
	}

	@Override
	public int updateMaterialPrice(float price, String id) {
		return mdao.updateMaterialPrice(price,id);
	}

	@Override
	public List<CgContract> getCGNameCgNoAndCgMoney() {
		return cgDao.getCGNameCgNoAndCgMoney();
	}

}

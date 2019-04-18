package org.ldxx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.BorrowContract;
import org.ldxx.bean.CgCl;
import org.ldxx.bean.CgOtherContract;
import org.ldxx.bean.FbContract;
import org.ldxx.bean.MaterialDemand;
import org.ldxx.bean.Pay;
import org.ldxx.bean.PrjMaterialBuy;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.BorrowContractDao;
import org.ldxx.dao.CgClDao;
import org.ldxx.dao.CgOtherContractDao;
import org.ldxx.dao.ContractPaymentDao;
import org.ldxx.dao.MaterialDemandDao;
import org.ldxx.dao.PrjMaterialBuyDao;
import org.ldxx.service.CgOtherContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CgOtherContractServiceImpl implements CgOtherContractService {
	
	@Autowired
	private CgOtherContractDao cgoDao;
	@Autowired
	private AccessoryDao adao;
	@Autowired
	private PrjMaterialBuyDao pdao;
	@Autowired
	private MaterialDemandDao mdao;
	@Autowired
	private ContractPaymentDao payDao;


	@Override
	public List<CgOtherContract> selectCgOtherContractByStatus(String status) {
		return cgoDao.selectCgOtherContractByStatus(status);
	}

	@Override
	public int addCgOtherContract(CgOtherContract cgo) {
		int i=cgoDao.addCgOtherContract(cgo);
		if(i>0){
			List<Accessory> accessory=cgo.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
			List<Accessory> accessory1=cgo.getAccessory1();
			if(accessory1!=null&&accessory1.size()>0){
				i=adao.addAccessory(accessory1);
			}
		}
		return i;
	}

	@Override
	public int deleteCgOtherContractById(String id) {
		int i=cgoDao.deleteCgOtherContractById(id);
		if(i>0){
			List<Accessory> accessory = adao.selectAccessoryById(id);
			if(accessory!=null&&accessory.size()!=0){
				i=adao.deleteAccessory(id);
			}
		}
		return i;
	}

	@Override
	public int updateCgOtherContractSave(CgOtherContract cgo) {
		int i=cgoDao.updateCgOtherContractSave(cgo);
		if(i>0){
			List<Accessory> accessory=cgo.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
		}
		return i;
	}

	@Override
	public CgOtherContract selectCgOtherContractById(String id) {
		CgOtherContract cgo=cgoDao.selectCgOtherContractById(id);
		List<Accessory> list = adao.selectAccessoryById(id);
		if(list!=null){
			cgo.setAccessory(list);
		}
		return cgo;
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
	public List<CgOtherContract> selectCgoIdAndName() {
		return cgoDao.selectCgoIdAndName();
	}

	@Override
	public CgOtherContract selectCgonoById(String id) {
		return cgoDao.selectCgonoById(id);
	}

	@Override
	public int updateHistoryById(String id) {
		int i= cgoDao.updateHistoryById(id);
		//if(i>0){
			i=cgoDao.updateHistoryNow(id);
		//}
		return i;
	}

	@Override
	public List<CgOtherContract> selectHistoryByNo(String cgoNo) {
		return cgoDao.selectHistoryByNo(cgoNo);
	}

	@Override
	public int cgoNocount(String year) {
		year="%"+year+"%";
		return cgoDao.cgoNocount(year);
	}

	@Override
	public List<CgOtherContract> getCGoNameAndNo() {
		return cgoDao.getCGoNameAndNo();
	}

	@Override
	public List<CgOtherContract> getCGoNameByNo(String cgoNo) {
		return cgoDao.getCGoNameByNo(cgoNo);
	}

	@Override
	public List<CgOtherContract> getCGoNoByName(String contractName) {
		return cgoDao.getCGoNoByName(contractName);
	}

	@Override
	public List<CgOtherContract> getCGoNameAndPrjNameBytaskNo(String no) {
		return cgoDao.getCGoNameAndPrjNameBytaskNo(no);
	}

	@Override
	public List<CgOtherContract> getCGoNametaskNoAndByPrjName(String name) {
		return cgoDao.getCGoNametaskNoAndByPrjName(name);
	}


	@Override
	public int updateDepartmentMoney(Double price, String id) {
		return pdao.updateSumPrice(price,id);
	}

	@Override
	public int updateMaterial(MaterialDemand md) {
		return mdao.updateMaterial(md);
	}

	@Override
	public List<CgOtherContract> getCGoNameCgoNoAndCgoMoney() {
		return cgoDao.getCGoNameCgoNoAndCgoMoney();
	}

	@Override
	public List<MaterialDemand> getMdById(String id) {
		return mdao.getMdById(id);
	}

	@Override
	public CgOtherContract selectByCgoNo(String no) {
		return cgoDao.selectByCgoNo(no);
	}

	@Override
	public List<CgOtherContract> selectCgOtherContractByWorkNo(String no) {
		return cgoDao.selectCgOtherContractByWorkNo(no);
	}

	@Override
	public int updateCgOtherContractById(CgOtherContract cgo) {
		int i=cgoDao.updateCgOtherContractById(cgo);
		if(i>0){
			List<Accessory> accessory=cgo.getAccessory();
			if(accessory!=null){
				adao.addAccessory(accessory);
			}
			List<Accessory> accessory1=cgo.getAccessory1();
			if(accessory1!=null&&accessory1.size()>0){
				adao.addAccessory(accessory1);
			}
		}
		return i;
	}


	@Override
	public int updatePrjNameAndNoById(CgOtherContract cgo) {
		int i= cgoDao.updatePrjNameAndNoById(cgo);
		return i;
	}

	@Override
	public int updatecgoNoById(String id, String cgoNo2) {
		return cgoDao.updatecgoNoById(id,cgoNo2);
	}

	@Override
	public CgOtherContract selectCgOtherContractShowByCgoNo(String cgoNo) {
		CgOtherContract cgoc = cgoDao.selectCgOtherContractShowByCgoNo(cgoNo);
		
		List<Accessory> list = adao.selectAccessoryById(cgoc.getCgoId());
		if(list!=null){
			cgoc.setAccessory(list);
		}
		// TODO Auto-generated method stub
		return cgoc;
	}

	
	
}

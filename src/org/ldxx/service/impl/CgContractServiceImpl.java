package org.ldxx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CgCl;
import org.ldxx.bean.CgContract;
import org.ldxx.bean.FbContract;
import org.ldxx.bean.MaterialDemand;
import org.ldxx.bean.Pay;
import org.ldxx.bean.PrjMaterialBuy;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.CgClDao;
import org.ldxx.dao.CgContractDao;
import org.ldxx.dao.ContractPaymentDao;
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
	@Autowired
	private ContractPaymentDao payDao;
	@Autowired
	private CgClDao cgclDao;

	@Override
	public List<CgContract> selectCgContractByStatus(String status) {
		return cgDao.selectCgContractByStatus(status);
	}

	@Override
	public int addCgContract(CgContract cg) {
		int i=cgDao.addCgContract(cg);
		if(i>0){
			String isProgram = cg.getIsProgram();
			if(isProgram.equals("是")){	//当是否代购为是时，金额统计到付款申请代垫款中。
				Pay pay=payDao.selectPayByNo(cg.getFbNo());
				if(pay!=null){
					i=payDao.updateGenerationAdvancesMoney(cg.getProgramMoney(),pay.getPayId());
				}
			}
			List<CgCl> cgcl = cg.getCgcl();
			if(cgcl!=null&&cgcl.size()>0){
				for(int j=0;j<cgcl.size();j++){
					cgcl.get(j).setCgId(cg.getCgId());
				}
			}
			i=cgclDao.addCgCl(cgcl);
			List<Accessory> accessory=cg.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
			List<Accessory> accessory1=cg.getAccessory1();
			if(accessory1!=null&&accessory1.size()>0){
				i=adao.addAccessory(accessory1);
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
			if(accessory!=null){
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
		List<CgCl> cgcl=cgclDao.selectCgClById(id);
		if(cgcl!=null&&cgcl.size()>0){
			cg.setCgcl(cgcl);
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
	public int updateHistoryById(String id) {
		int i= cgDao.updateHistoryById(id);
		if(i>0){
			i=cgDao.updateHistoryNow(id);
		}
		return i;
	}

	@Override
	public List<CgContract> selectHistoryByNo(String cgNo) {
		return cgDao.selectHistoryByNo(cgNo);
	}

	@Override
	public int cgNocount(String year) {
		year="%"+year+"%";
		return cgDao.cgNocount(year);
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
	public int updateMaterial(MaterialDemand md) {
		return mdao.updateMaterial(md);
	}

	@Override
	public List<CgContract> getCGNameCgNoAndCgMoney() {
		return cgDao.getCGNameCgNoAndCgMoney();
	}

	@Override
	public List<MaterialDemand> getMdById(String id) {
		return mdao.getMdById(id);
	}

	@Override
	public CgContract selectByCgNo(String no) {
		return cgDao.selectByCgNo(no);
	}

	@Override
	public List<CgContract> selectCgContractByWorkNo(String no) {
		return cgDao.selectCgContractByWorkNo(no);
	}

	@Override
	public int updateCgContractById(CgContract cg) {
		int i=cgDao.updateCgContractById(cg);
		if(i>0){
			String isProgram = cg.getIsProgram();
			if(isProgram.equals("是")){	//当是否代购为是时，金额统计到付款申请代垫款中。
				Pay pay=payDao.selectPayByNo(cg.getFbNo());
				if(pay!=null){
					i=payDao.updateGenerationAdvancesMoney(cg.getProgramMoney(),pay.getPayId());
				}
			}
			List<Accessory> accessory=cg.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
			List<Accessory> accessory1=cg.getAccessory1();
			if(accessory1!=null&&accessory1.size()>0){
				i=adao.addAccessory(accessory1);
			}
		}
		return i;
	}

}

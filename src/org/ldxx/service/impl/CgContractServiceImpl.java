package org.ldxx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.BorrowContract;
import org.ldxx.bean.CgCl;
import org.ldxx.bean.CgContract;
import org.ldxx.bean.FbContract;
import org.ldxx.bean.MaterialDemand;
import org.ldxx.bean.Pay;
import org.ldxx.bean.PrjMaterialBuy;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.BorrowContractDao;
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
	@Autowired
	private BorrowContractDao borrowdao;

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
				if(cg.getFbNo()!=null&&cg.getFbNo()!=""){
					Pay pay=payDao.selectPayByNo(cg.getFbNo());
					if(pay!=null){
						i=payDao.updateGenerationAdvancesMoney(cg.getProgramMoney(),pay.getPayId());
					}
				}
			}
			List<CgCl> cgcl = cg.getCgcl();
			if(cgcl!=null&&cgcl.size()>0){
				for(int j=0;j<cgcl.size();j++){
					cgcl.get(j).setCgId(cg.getCgId());
				}
				i=cgclDao.addCgCl(cgcl);
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

	@Override
	public int deleteCgContractById(String id) {
		int i=cgDao.deleteCgContractById(id);
		if(i>0){
			List<Accessory> accessory = adao.selectAccessoryById(id);
			if(accessory!=null&&accessory.size()!=0){
				i=adao.deleteAccessory(id);
			}
			List<CgCl> cgcl = cgclDao.selectCgClById(id);
			if(cgcl!=null&&cgcl.size()!=0){
				i = cgclDao.deleteCgClById(id);
			}
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
		if(list!=null&&list.size()!=0){
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
		//if(i>0){
			i=cgDao.updateHistoryNow(id);
		//}
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
	public int updateDepartmentMoney(Double price, String id) {
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
				if(cg.getFbNo()!=null&&cg.getFbNo()!=""){
					Pay pay=payDao.selectPayByNo(cg.getFbNo());
					if(pay!=null){
						payDao.updateGenerationAdvancesMoney(cg.getProgramMoney(),pay.getPayId());
					}
				}
			}
			List<Accessory> accessory=cg.getAccessory();
			if(accessory!=null){
				adao.addAccessory(accessory);
			}
			List<Accessory> accessory1=cg.getAccessory1();
			if(accessory1!=null&&accessory1.size()>0){
				adao.addAccessory(accessory1);
			}
			if(null!=cg.getCgcl()&&cg.getCgcl().size()>0){
			    cgclDao.deleteCgClById(cg.getCgId());
			    cgclDao.addCgCl(cg.getCgcl());
			}
		}
		return i;
	}

	@Override
	public List<BorrowContract> getRateAndMoney(String no) {
		return borrowdao.getRateAndMoney(no);
	}

	@Override
	public int updatePrjNameAndNoById(CgContract cg) {
		int i= cgDao.updatePrjNameAndNoById(cg);
		if(i>0){
			if(cg.getFbNo()!=null&&cg.getFbNo()!=""){
				Pay pay=payDao.selectPayByNo(cg.getFbNo());
				if(pay!=null){
					payDao.updateGenerationAdvancesMoney(cg.getProgramMoney(),pay.getPayId());
				}
			}
		}
		return i;
	}

	@Override
	public int updatecgNoById(String id, String cgNo2) {
		return cgDao.updatecgNoById(id,cgNo2);
	}

	@Override
	public CgContract selectCgContractShowByCgNo(String cgNo) {
		CgContract cgc = cgDao.selectCgContractShowByCgNo(cgNo);
		
		List<Accessory> list = adao.selectAccessoryById(cgc.getCgId());
		if(list!=null){
			cgc.setAccessory(list);
		}
		List<CgCl> cgcl=cgclDao.selectCgClById(cgc.getCgId());
		if(cgcl!=null&&cgcl.size()>0){
			cgc.setCgcl(cgcl);
		}
		// TODO Auto-generated method stub
		return cgc;
	}

	@Override
	public List<CgContract> getCGNoByTaskNo(String no) {
		List<CgContract> list = cgDao.getCGNoByTaskNo(no);
		return list;
	}

	@Override
	public int updatecancelReasonById(String id, String cancelReason) {
		return cgDao.updatecancelReasonById(id,cancelReason);
	}

}

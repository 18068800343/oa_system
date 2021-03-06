package org.ldxx.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.OtherContract;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.OtherContractDao;
import org.ldxx.service.OtherContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OtherContractServiceImpl implements OtherContractService{

	@Autowired
	private OtherContractDao dao;
	
	@Autowired
	private AccessoryDao adao;
	
	@Transactional
	@Override
	public int addOtherContract(OtherContract other) {
		int i=dao.addOtherContract(other);
		if(i>0){
			List<Accessory> accessory=other.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
			List<Accessory> accessory2=other.getAccessory2();
			if(accessory2!=null){
				i=adao.addAccessory(accessory2);
			}
		}
		return i;
	}

	@Override
	public int deleteOtherContract(String id) {
		return 0;
	}

	@Override
	public List<OtherContract> selectOtherContract(String status) {
		return dao.selectOtherContract(status);
	}

	@Transactional
	@Override
	public int updateOtherContract(OtherContract other) {
		int i=dao.updateOtherContract(other);
		if(i>0){
			List<Accessory> accessory=other.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
		}
		return i;
	}

	@Override
	public List<OtherContract> selectCjHistory(String no) {
		return dao.selectCjHistory(no);
	}

	@Override
	public int countNo(String year) {
		year="%"+year+"%";
		return dao.countNo(year);
	}

	@Override
	public OtherContract selectOtherContractById(String id) {
		return dao.selectOtherContractById(id);
	}

	@Override
	public OtherContract selectOtherContractByNo(String no) {
		return dao.selectOtherContractByNo(no);
	}

	@Override
	public BigDecimal selectOtherContractMoneyBySignTime(String time) {
		BigDecimal money=new BigDecimal(0);
		List<OtherContract> other=dao.selectOtherContractMoneyBySignTime(time);
		if(other!=null){
			for(int i=0;i<other.size();i++){
				BigDecimal otherMoney=other.get(i).getContractMoney();
				money=money.add(otherMoney);
			}
		}
		return money;
	}

	@Override
	public BigDecimal selectOtherContractMoneyBySignTimeAndDepartment(String time, String department) {
		BigDecimal money=new BigDecimal(0);
		List<OtherContract> other=dao.selectOtherContractMoneyBySignTimeAndDepartment(time, department);
		if(other!=null){
			for(int i=0;i<other.size();i++){
				BigDecimal contractMoney=other.get(i).getContractMoney();
				money=money.add(contractMoney);
			}
		}
		return money;
	}

	@Override
	public int updateHistoryById(String id) {
		int i=dao.updateHistoryById(id);
		
		i=dao.updateHistoryNow(id);
		
		return i;
	}

	@Override
	public int updateOtherContractById(OtherContract other) {
		int i = dao.updateOtherContract(other);
		if(i>0){
			List<Accessory> accessory=other.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
			List<Accessory> accessory2=other.getAccessory2();
			if(accessory2!=null){
				i=adao.addAccessory(accessory2);
			}
		}
		return i;
	}

	@Override
	public int updateOnoById(String id, String no) {
		int i=dao.updateOnoById(id, no);
		return i;
	}

	@Override
	public List<OtherContract> selectOtherContract2() {
		return dao.selectOtherContract2();
	}

}

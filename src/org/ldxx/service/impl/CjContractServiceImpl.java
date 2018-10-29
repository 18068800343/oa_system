package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.CjSplitMoney;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.CjContractDao;
import org.ldxx.service.CjContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CjContractServiceImpl implements CjContractService{

	@Autowired
	private CjContractDao dao;
	
	@Autowired
	private AccessoryDao adao;
	
	@Transactional
	@Override
	public int addCjContract(CjContract cj) {
		int i=dao.addCjContract(cj);
		if(i>0){
			List<Accessory> accessory=cj.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
			List<CjSplitMoney> cjSplitMoney = cj.getCjSplitMoney();
			for(int j=0;j<cjSplitMoney.size();j++){
				cjSplitMoney.get(j).setCjId(cj.getCjId());
			}
			if(cjSplitMoney!=null&& cjSplitMoney.size()>0){
				i = dao.addCjSplitMoneySave(cjSplitMoney);
			}
		}
		return i;
	}

	@Transactional
	@Override
	public int updateCjContract(CjContract cj) {
		int i=dao.updateCjContract(cj);
		if(i>0){
			List<Accessory> accessory=cj.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
		}
		return i;
	}

	@Override
	public List<CjContract> selectCjContractByStatus(String status) {
		List<CjContract> list = dao.selectCjContractByStatus(status);
		for(int i=0;i<list.size();i++){
			String id = list.get(i).getCjId();
			List<CjSplitMoney> cjSplitMoney=dao.selectCjSplitMoneyById(id);
			list.get(i).setCjSplitMoney(cjSplitMoney);
		}
		return list;
	}

	@Override
	public CjContract selectCjContractById(String id) {
		return null;
	}

	@Override
	public int deleteCjContract(String id) {
		return 0;
	}

	@Override
	public List<CjContract> selectIdAndName() {
		return dao.selectIdAndName();
	}

	@Override
	public List<CjContract> selectContractNoById(String id) {
		return dao.selectContractNoById(id);
	}

	@Override
	public List<CjContract> selectContractByTaskNo(String no) {
		return dao.selectContractByTaskNo(no);
	}

	@Override
	public List<CjContract> selectCjByName(String name) {
		return dao.selectCjByName(name);
	}

	@Override
	public List<CjContract> selectCjByNo(String no) {
		return dao.selectCjByNo(no);
	}

	@Override
	public List<CjContract> selectCjHistory(String no) {
		List<CjContract> list = dao.selectCjHistory(no);
		for(int i=0;i<list.size();i++){
			String id = list.get(i).getCjId();
			List<CjSplitMoney> cjSplitMoney=dao.selectCjSplitMoneyById(id);
			list.get(i).setCjSplitMoney(cjSplitMoney);
		}
		return list;
	}

	@Override
	public int countNo() {
		return dao.countNo();
	}

	@Override
	public List<CjContract> selectNameAndNo() {
		return dao.selectNameAndNo();
	}

	@Override
	public CjContract selectCjContractByName(String name) {
		return dao.selectCjContractByName(name);
	}

	@Override
	public CjContract selectCjContractByNo(String no) {
		return dao.selectCjContractByNo(no);
	}

	@Override
	public List<CjContract> selectCjContractByTaskNo(String no) {
		return dao.selectCjContractByTaskNo(no);
	}

}

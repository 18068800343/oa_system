package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CjContract;
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
		return dao.selectCjContractByStatus(status);
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
		return dao.selectCjHistory(no);
	}

}

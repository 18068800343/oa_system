package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ContractWork;
import org.ldxx.bean.Enterprise;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.ContractWorkDao;
import org.ldxx.dao.EnterpriseDao;
import org.ldxx.service.ContractWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractWorkServiceImpl implements ContractWorkService{

	@Autowired
	private ContractWorkDao dao;
	
	@Autowired
	private AccessoryDao adao;
	
	@Autowired
	private EnterpriseDao edao;
	
	@Transactional
	@Override
	public int addContractWork(ContractWork work) {
		int i=dao.addContractWork(work);
		String id=work.getCwId();
		if(i>0){
			List<Accessory> accessory=work.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(accessory);
			}
			List<Accessory> accessory1=work.getAccessory1();
			if(accessory1!=null){
				i=adao.addAccessory(accessory1);
			}
			List<Enterprise> enterprise=work.getEnterprise();
			if(enterprise!=null){
				for(int a=0;a<enterprise.size();a++){
					enterprise.get(a).seteId(id);
				}
				i=edao.addEnterprise(enterprise);
			}
		}
		return i;
	}

	@Override
	public List<ContractWork> selectContractWork(String type) {
		return dao.selectContractWork(type);
	}

}

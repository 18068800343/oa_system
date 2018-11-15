package org.ldxx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.Cooperator;
import org.ldxx.bean.Enterprise;
import org.ldxx.bean.Eva;
import org.ldxx.dao.CooperatorDao;
import org.ldxx.dao.EnterpriseDao;
import org.ldxx.service.CooperatorService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CooperatorServiceImpl  implements CooperatorService{

	@Autowired
	private CooperatorDao cDao;
	
	@Autowired
	private EnterpriseDao eDao;
	
	
	@Transactional
	@Override
	public int addCooperator(Cooperator cooperator) {
		TimeUUID uuid=new TimeUUID();
		List<Enterprise> enterprise=cooperator.getEnterprise();
		String id=uuid.getTimeUUID();
		cooperator.setCcId(id);
		for(int ii=0;ii<enterprise.size();ii++){
			enterprise.get(ii).seteId(id);
		}
		int i=cDao.addCooperator(cooperator);
		if(i>0){
			if(enterprise.size()!=0&&enterprise!=null){
				i=eDao.addEnterprise(enterprise);
			}
		}
		return i;
	}

	@Transactional
	@Override
	public int deleteCooperator(String id) {
		int i=eDao.deleteEnterprise(id);
		if(i>0){
			i=cDao.deleteCooperator(id);
		}
		return i;
	}

	@Transactional
	@Override
	public int updateCooperator(Cooperator cooperator) {
		int i=eDao.deleteEnterprise(cooperator.getCcId());
		List<Enterprise>enterprise=cooperator.getEnterprise();
		for(int ii=0;ii<enterprise.size();ii++){
			enterprise.get(ii).seteId(cooperator.getCcId());
		}
		if(i>0){
			i=cDao.updateCooperator(cooperator);
			if(i>0){
				i=eDao.addEnterprise(enterprise);
			}
		}
		return i;
	}

	@Override
	public List<Cooperator> selectAllCooperator() {
		return cDao.selectAllCooperator();
	}

	@Transactional
	@Override
	public Cooperator selectOneCooperator(String id) {
		Cooperator cooperator=cDao.selectOneCooperator(id);
		List<Enterprise> enterprise=eDao.selectEnterpriseById(id);
		cooperator.setEnterprise(enterprise);
		List<Eva> eva=new ArrayList<>();
		Eva a=new Eva();
		a.setEvaName("棱点oA合同");
		a.setEvaLv("90");
		eva.add(a);
		cooperator.setEnterpriseEva(eva);
		return cooperator;
	}

	@Override
	public List<Cooperator> selectCooperatorIdAndName() {
		return cDao.selectCooperatorIdAndName();
	}

}

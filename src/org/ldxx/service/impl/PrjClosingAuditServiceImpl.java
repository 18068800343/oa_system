package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.PrjClosingAudit;
import org.ldxx.bean.PrjClosingAuditPerson;
import org.ldxx.dao.PrjClosingAuditDao;
import org.ldxx.service.PrjClosingAuditService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrjClosingAuditServiceImpl implements PrjClosingAuditService{

	@Autowired
	private PrjClosingAuditDao dao;
	
	
	@Transactional
	@Override
	public int addPrjClosingAudit(PrjClosingAudit audit) {
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		audit.setPcId(id);
		int i=dao.addPrjClosingAudit(audit);
		if(i>0){
			List<PrjClosingAuditPerson> person=audit.getPerson();
			if(person.size()!=0){
				for(int a=0;a<person.size();a++){
					person.get(a).setPcId(id);
				}
				i=dao.addPrjClosingAuditPerson(person);
			}
		}
		return i;
	}

	@Override
	public int addPrjClosingAuditPerson(List<PrjClosingAuditPerson> person) {
		return dao.addPrjClosingAuditPerson(person);
	}

	@Override
	public List<PrjClosingAudit> selectPrjClosingAudit() {
		return dao.selectPrjClosingAudit();
	}

	@Override
	public PrjClosingAudit selectPrjClosingAuditById(String id) {
		return dao.selectPrjClosingAuditById(id);
	}

	@Override
	public List<PrjClosingAuditPerson> selectPrjClosingAuditPersonById(String id) {
		return dao.selectPrjClosingAuditPersonById(id);
	}

}

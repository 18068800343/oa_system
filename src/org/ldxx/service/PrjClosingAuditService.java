package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.PrjClosingAudit;
import org.ldxx.bean.PrjClosingAuditPerson;

public interface PrjClosingAuditService {

	public int addPrjClosingAudit(PrjClosingAudit audit);
	
	public int addPrjClosingAuditPerson(List<PrjClosingAuditPerson> person);
	
	public List<PrjClosingAudit> selectPrjClosingAudit();
	
	public PrjClosingAudit selectPrjClosingAuditById(String id);
	
	public List<PrjClosingAuditPerson> selectPrjClosingAuditPersonById(String id);
}

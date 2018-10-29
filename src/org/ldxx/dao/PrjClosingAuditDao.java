package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.PrjClosingAudit;
import org.ldxx.bean.PrjClosingAuditPerson;

public interface PrjClosingAuditDao {

	public int addPrjClosingAudit(@Param("audit")PrjClosingAudit audit);
	
	public int addPrjClosingAuditPerson(@Param("person")List<PrjClosingAuditPerson> person);
	
	public List<PrjClosingAudit> selectPrjClosingAudit();
	
	public PrjClosingAudit selectPrjClosingAuditById(@Param("id")String id);
	
	public List<PrjClosingAuditPerson> selectPrjClosingAuditPersonById(@Param("id")String id);
}

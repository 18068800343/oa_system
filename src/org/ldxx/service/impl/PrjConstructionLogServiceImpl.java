package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.PrjConstructionLog;
import org.ldxx.dao.PrjConstructionLogDao;
import org.ldxx.service.PrjConstructionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PrjConstructionLogServiceImpl implements PrjConstructionLogService {
	
	
	@Autowired
	private PrjConstructionLogDao dao;

	@Override
	public List<PrjConstructionLog> selectPrjConstructionLog() {
		return dao.selectPrjConstructionLog();
	}

	@Override
	public int addPrjConstructionLogSave(PrjConstructionLog prjLog) {
		return dao.addPrjConstructionLogSave(prjLog);
	}

	@Override
	public int deletePrjConstructionLog(String id) {
		return dao.deletePrjConstructionLog(id);
	}

	@Override
	public int updatePrjConstructionLogSave(PrjConstructionLog prjLog) {
		return dao.updatePrjConstructionLogSave(prjLog);
	}
}

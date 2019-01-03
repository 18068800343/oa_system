package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.PrjConstructionLog;
import org.ldxx.bean.PrjConstructionLogInfo;
import org.ldxx.dao.PrjConstructionLogDao;
import org.ldxx.dao.PrjConstructionLogInfoDao;
import org.ldxx.service.PrjConstructionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PrjConstructionLogServiceImpl implements PrjConstructionLogService {
	
	
	@Autowired
	private PrjConstructionLogDao dao;
	@Autowired
	private PrjConstructionLogInfoDao prjLogInfodao;

	@Override
	public List<PrjConstructionLog> selectPrjConstructionLog() {
		List<PrjConstructionLog> prjConstructionLog = dao.selectPrjConstructionLog();
		for(int i=0;i<prjConstructionLog.size();i++){
			String id = prjConstructionLog.get(i).getPclId();
			List<PrjConstructionLogInfo> list=prjLogInfodao.selectPrjConstructionLogInfoById(id);
			if(list!=null){
				prjConstructionLog.get(i).setPrjLogInfo(list);
			}
		}
		return prjConstructionLog;
	}

	@Override
	public int addPrjConstructionLogSave(PrjConstructionLog prjLog) {
		int i=dao.addPrjConstructionLogSave(prjLog);
		if(i>0){
			List<PrjConstructionLogInfo> prjLogInfo = prjLog.getPrjLogInfo();
			if(prjLogInfo!=null){
				for(int j=0;j<prjLogInfo.size();j++){
					prjLogInfo.get(j).setPclId(prjLog.getPclId());
				}
				i=prjLogInfodao.addrjConstructionLogInfo(prjLogInfo);
			}
		}
		return i;
	}

	@Override
	public int deletePrjConstructionLog(String id) {
		int i=dao.deletePrjConstructionLog(id);
		if(i>0){
			i=prjLogInfodao.deletePrjConstructionLogInfo(id);
		}
		return i;
	}

	@Override
	public int updatePrjConstructionLogSave(PrjConstructionLog prjLog) {
		int i=dao.updatePrjConstructionLogSave(prjLog);
		if(i>0){
			List<PrjConstructionLogInfo> logInfoById = prjLogInfodao.selectPrjConstructionLogInfoById(prjLog.getPclId());
			if(logInfoById!=null){
				i=prjLogInfodao.deletePrjConstructionLogInfo(prjLog.getPclId());
			}
			i=prjLogInfodao.addrjConstructionLogInfo(prjLog.getPrjLogInfo());
		}
		return i;
	}

	@Override
	public List<PrjConstructionLogInfo> selectPrjConstructionLogInfoById(String id) {
		return prjLogInfodao.selectPrjConstructionLogInfoById(id);
	}
}

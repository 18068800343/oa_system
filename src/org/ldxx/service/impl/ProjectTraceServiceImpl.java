package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.Enterprise;
import org.ldxx.bean.ProjectTrace;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.EnterpriseDao;
import org.ldxx.dao.ProjectTraceDao;
import org.ldxx.service.ProjectTraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectTraceServiceImpl implements ProjectTraceService{

	@Autowired
	private ProjectTraceDao dao;
	
	@Autowired
	private AccessoryDao adao;
	
	@Autowired
	private EnterpriseDao eDao;
	
	
	@Transactional
	@Override
	public int addProjectTrace(ProjectTrace trace) {
		int i=dao.addProjectTrace(trace);
		if(i>0){
			List<Accessory> accessory=trace.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(trace.getAccessory());
			}
			
			List<Enterprise> enterprise=trace.getEnterprise();
			for(int ii=0;ii<enterprise.size();ii++){
				enterprise.get(ii).seteId(trace.getPtId());
			}
			if(enterprise!=null&&enterprise.size()!=0){
				i=eDao.addEnterprise(enterprise);
			}
		}
		return i;
	}

	@Transactional
	@Override
	public int deleteProjectTrace(String id) {
		int i=adao.deleteAccessory(id);
		if(i>0){
			i=dao.deleteProjectTrace(id);
		}
		return i;
	}

	@Transactional
	@Override
	public int updateProjectTrace(ProjectTrace trace) {
		int i=dao.updateProjectTrace(trace);
		if(i>0){
			List<Enterprise> enterprise=trace.getEnterprise();
			eDao.deleteEnterprise(trace.getPtId());
			if(enterprise!=null){
				eDao.addEnterprise(enterprise);
			}
			List<Accessory> accessory=trace.getAccessory();
			if(accessory!=null){
				adao.addAccessory(trace.getAccessory());
			}
		}
		return i;
	}

	@Override
	public List<ProjectTrace> selectProjectTrace(String status) {
		return dao.selectProjectTrace(status);
	}

	@Override
	public ProjectTrace selectProjectTraceById(String id) {
		ProjectTrace trace=dao.selectProjectTraceById(id);
		return trace;
	}

	@Override
	public int dateCount(String time) {
		time="%"+time+"%";
		return dao.dateCount(time);
	}

	@Override
	public ProjectTrace selectProjectTraceByNo(String no) {
		return dao.selectProjectTraceByNo(no);
	}

	@Override
	public ProjectTrace selectProjectTraceByName(String name) {
		return dao.selectProjectTraceByName(name);
	}

	@Override
	public int updateTraceEnd(String gzEnd, String id) {
		return dao.updateTraceEnd(gzEnd, id);
	}

	@Override
	public int updatePrjNoById(String id, String no) {
		return dao.updatePrjNoById(id, no);
	}

}

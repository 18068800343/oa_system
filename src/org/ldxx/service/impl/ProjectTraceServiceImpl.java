package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ProjectTrace;
import org.ldxx.dao.AccessoryDao;
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
	
	
	@Transactional
	@Override
	public int addProjectTrace(ProjectTrace trace) {
		int i=dao.addProjectTrace(trace);
		if(i>0){
			List<Accessory> accessory=trace.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(trace.getAccessory());
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

	@Override
	public int updateProjectTrace(ProjectTrace trace) {
		int i=dao.updateProjectTrace(trace);
		if(i>0){
			List<Accessory> accessory=trace.getAccessory();
			if(accessory!=null){
				i=adao.addAccessory(trace.getAccessory());
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

}

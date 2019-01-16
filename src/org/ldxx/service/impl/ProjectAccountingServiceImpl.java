package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.ProjectAccounting;
import org.ldxx.bean.ProjectAccountingRg;
import org.ldxx.dao.ProjectAccountingDao;
import org.ldxx.dao.ProjectAccountingRgDao;
import org.ldxx.service.ProjectAccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProjectAccountingServiceImpl implements ProjectAccountingService {
	
	@Autowired
	private ProjectAccountingDao dao;
	@Autowired
	private ProjectAccountingRgDao rgdao;

	@Override
	public int addProjectAccounting(ProjectAccounting projectAccounting) {
		int i=dao.addProjectAccounting(projectAccounting);
		if(i>0){
			String paId = projectAccounting.getPaId();
			List<ProjectAccountingRg> accountingRg = projectAccounting.getProjectAccountingRg();
			if(accountingRg!=null && accountingRg.size()>0){
				for(int j=0;j<accountingRg.size();j++){
					accountingRg.get(j).setPaId(paId);
				}
				i=rgdao.addProjectAccountingRg(accountingRg);
			}
		}
		return i;
	}

	@Override
	public List<ProjectAccounting> selectProjectAccounting(String status) {
		return dao.selectProjectAccounting(status);
	}

	@Override
	public ProjectAccounting getProjectAccountingById(String id) {
		ProjectAccounting pa=dao.getProjectAccountingById(id);
		if(pa!=null){
			List<ProjectAccountingRg> rg=rgdao.getProjectAccountingRgById(id);
			if(rg!=null){
				pa.setProjectAccountingRg(rg);
			}
		}
		return pa;
	}

}

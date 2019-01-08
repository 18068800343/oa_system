package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.ProjectAccounting;
import org.ldxx.bean.ProjectAccountingClfy;
import org.ldxx.bean.ProjectAccountingFyys;
import org.ldxx.bean.ProjectAccountingJjfy;
import org.ldxx.bean.ProjectAccountingRg;
import org.ldxx.dao.ProjectAccountingClfyDao;
import org.ldxx.dao.ProjectAccountingDao;
import org.ldxx.dao.ProjectAccountingFyysDao;
import org.ldxx.dao.ProjectAccountingJjfyDao;
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
	@Autowired
	private ProjectAccountingFyysDao fyysdao;
	@Autowired
	private ProjectAccountingClfyDao clfydao;
	@Autowired
	private ProjectAccountingJjfyDao jjfydao;

	@Override
	public int addProjectAccounting(ProjectAccounting projectAccounting) {
		int i=dao.addProjectAccounting(projectAccounting);
		if(i>0){
			String paId = projectAccounting.getPaId();
			List<ProjectAccountingRg> accountingRg = projectAccounting.getProjectAccountingRg();
			if(accountingRg!=null){
				for(int j=0;j<accountingRg.size();j++){
					accountingRg.get(j).setPaId(paId);
				}
				i=rgdao.addProjectAccountingRg(accountingRg);
			}
			List<ProjectAccountingFyys> accountingFyys = projectAccounting.getProjectAccountingFyys();
			if(accountingFyys!=null){
				for (int k=0;k<accountingFyys.size();k++) {
					accountingFyys.get(k).setPaId(paId);
				}
				i=fyysdao.addProjectAccountingFyys(accountingFyys);
			}
			List<ProjectAccountingClfy> accountingClfy = projectAccounting.getProjectAccountingClfy();
			if(accountingClfy!=null){
				for(int m=0;m<accountingClfy.size();m++){
					accountingClfy.get(m).setPaId(paId);
				}
				i=clfydao.addProjectAccountingClfy(accountingClfy);
			}
			List<ProjectAccountingJjfy> accountingJjfy = projectAccounting.getProjectAccountingJjfy();
			if(accountingJjfy!=null){
				for(int n=0;n<accountingJjfy.size();n++){
					accountingJjfy.get(n).setPaId(paId);
				}
				i=jjfydao.addProjectAccountingJjfy(accountingJjfy);
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
			List<ProjectAccountingFyys> fyys=fyysdao.getProjectAccountingFyysById(id);
			if(fyys!=null){
				pa.setProjectAccountingFyys(fyys);
			}
			List<ProjectAccountingClfy> clfy=clfydao.getProjectAccountingClfyById(id);
			if(clfy!=null){
				pa.setProjectAccountingClfy(clfy);
			}
			List<ProjectAccountingJjfy> jjfy=jjfydao.getProjectAccountingJjfyById(id);
			if(jjfy!=null){
				pa.setProjectAccountingJjfy(jjfy);
			}
		}
		return pa;
	}

}

package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.ProjectScale;
import org.ldxx.bean.Scale;
import org.ldxx.dao.ProjectScaleDao;
import org.ldxx.service.ProjectScaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjectScaleServiceImpl implements ProjectScaleService {

	@Autowired
	private ProjectScaleDao projectScaleDao;

	@Override
	public ProjectScale getProjectScale(String type,String scale) {
		return projectScaleDao.getProjectScale(type, scale);
	}

	@Transactional
	@Override
	public int updateScale(Scale scale) {
		int i=projectScaleDao.updateScale("设计项目", "大型项目", scale.getSjdx(), 9999);
		if(i!=0){
			i=projectScaleDao.updateScale("设计项目", "中型项目", scale.getSjzx(), scale.getSjzd());
		}
		
		if(i!=0){
			 i=projectScaleDao.updateScale("设计项目", "小型项目", 0, scale.getSjxd());
		}
		
		if(i!=0){
			 i=projectScaleDao.updateScale("检测项目", "大型项目", scale.getJcdx(), 9999);
		}

		if(i!=0){
			 i=projectScaleDao.updateScale("检测项目", "中型项目", scale.getJczx(), scale.getJczd());
		}

		if(i!=0){
			 i=projectScaleDao.updateScale("检测项目", "小型项目", 0, scale.getJcxd());
		}

		if(i!=0){
			 i=projectScaleDao.updateScale("新建施工", "大型项目", scale.getXjdx(), 9999);
		}
		
		if(i!=0){
			 i=projectScaleDao.updateScale("新建施工", "中型项目", scale.getXjzx(), scale.getXjzd());
		}
		
		if(i!=0){
			 i=projectScaleDao.updateScale("新建施工", "小型项目", 0, scale.getXjxd());
		}
		
		if(i!=0){
			 i=projectScaleDao.updateScale("加固施工", "大型项目", scale.getJgdx(), 9999);
		}
		
		if(i!=0){
			 i=projectScaleDao.updateScale("加固施工", "中型项目", scale.getJgzx(), scale.getJgzd());
		}
		
		if(i!=0){
			i=projectScaleDao.updateScale("加固施工", "小型项目", 0, scale.getJgxd());
		}
		
		if(i!=0){
			 i=projectScaleDao.updateScale("信息化项目", "大型项目", scale.getXxhdx(), 9999);
		}
		 
		if(i!=0){
			 i=projectScaleDao.updateScale("信息化项目", "中型项目", scale.getXxhzx(), scale.getXxhzd());
		}
		
		if(i!=0){
			 i=projectScaleDao.updateScale("信息化项目", "小型项目", 0, scale.getXxhxd());
		}
		
		return i;
	}

	@Override
	public ProjectScale selectProjectScale(String type, float money) {
		return projectScaleDao.selectProjectScale(type, money);
	}



}

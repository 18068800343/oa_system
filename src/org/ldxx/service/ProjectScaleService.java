package org.ldxx.service;


import org.ldxx.bean.ProjectScale;
import org.ldxx.bean.Scale;

public interface ProjectScaleService {

	public ProjectScale getProjectScale(String type,String scale);
	
	public int updateScale(Scale scale);
	
	public ProjectScale selectProjectScale(String type,Double money);
}

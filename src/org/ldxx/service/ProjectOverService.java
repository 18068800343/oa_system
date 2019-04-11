package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.ProjectOver;

public interface ProjectOverService {

	int addPrjOver(ProjectOver projectOver);

	int deletePrjOver(String poId);

	int updatePrjOverById(ProjectOver projectOver);

	List<ProjectOver> selectPrjOver();
	
	List<ProjectOver> selectPrjOver2();
	
	List<ProjectOver> selectPrjOverYiJiaoZhong();

	ProjectOver selectPrjOverById(String poId);
	
	int selectPrjOverCountByNo(String no);
	
	int updateUseStatus(String id);
	
	 

}

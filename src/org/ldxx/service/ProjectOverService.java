package org.ldxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ProjectOver;

public interface ProjectOverService {

	int addPrjOver(ProjectOver projectOver);

	int deletePrjOver(String poId);

	int updatePrjOverById(ProjectOver projectOver);

	List<ProjectOver> selectPrjOver(int status);

	ProjectOver selectPrjOverById(String poId);
	
	int selectPrjOverCountByNo(String no);
	
	int updateStatus2(String no,String status);

}

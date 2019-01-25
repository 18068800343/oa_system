package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ProjectOver;

public interface ProjectOverDao {

	int addPrjOver(@Param("projectOver")ProjectOver projectOver);

	int deletePrjOver(@Param("poId")String poId);

	int updatePrjOverById(@Param("projectOver") ProjectOver projectOver);

	List<ProjectOver> selectPrjOver();
	
	List<ProjectOver> selectPrjOver2();

	ProjectOver selectPrjOverById(@Param("poId")String poId);
	
	int selectPrjOverCountByNo(@Param("no")String no);

	int updateUseStatus(@Param("id")String id);
	
}

package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.OutTrainAll;

public interface OutTrainAllDao {

	public int addOutTrainAll(@Param("trainAll")OutTrainAll trainAll);
	
	public int deleteOutTrainAll(@Param("id")String id);
	
	public int updateOutTrainAll(@Param("trainAll")OutTrainAll trainAll);
	
	public List<OutTrainAll> selectOutTrainAll();
	
	public OutTrainAll selectOutTrainAllById(@Param("id")String id);

	public List<OutTrainAll> getOutTrainAllName();
}

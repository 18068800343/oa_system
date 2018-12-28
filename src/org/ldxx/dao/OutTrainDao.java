package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.OutTrain;

public interface OutTrainDao {
	
	public int addOutTrain(@Param("outTrain")OutTrain outTrain);
	
	public int deleteOutTrain(@Param("id")String id);
	
	public int updateOutTrain(@Param("outTrain")OutTrain outTrain);
	
	public List<OutTrain> selectOutTrain();
	
	public OutTrain selectOutTrainById(@Param("id")String id);

	public List<OutTrain> getOutTrainName();
}

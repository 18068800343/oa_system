package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.InternalTraining;

public interface InternalTrainingDao {

	public int addInternalTraining(@Param("training")InternalTraining training);
	
	public int deleteInternalTraining(@Param("id")String id);
	
	public int updateInternalTrainingHasFile(@Param("training")InternalTraining training);
	
	public int updateInternalTrainingNoFile(@Param("training")InternalTraining training);
	
	public List<InternalTraining> selectInternalTraining();
	
	public InternalTraining selectInternalTrainingById(@Param("id")String id);
	
	public int deleteFile(@Param("id")String id);
}

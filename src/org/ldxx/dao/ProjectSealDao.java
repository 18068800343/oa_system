package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.SignetManage;

public interface ProjectSealDao {

	List<SignetManage> selectPrjSeal(@Param("status")String status);

	int addPrjSeal(@Param("signetManage")SignetManage signetManage);

	int deletePrjSealById(@Param("id")String id);

	int updatePrjSealById(@Param("signetManage")SignetManage signetManage);

	SignetManage selectPrjSealById(@Param("smId")String smId);
	
	SignetManage getSignetByTaskNo(@Param("taskNo")String taskNo);
	
	SignetManage getSignetBySignetNo(@Param("signetNo")String signetNo);
	
	int addStop(@Param("signetManage")SignetManage signetManage);
	
	int updateStatus(@Param("id")String id,@Param("status")String status);
	
	int updateSignetNo(@Param("no")String no,@Param("id")String id);
	
	int updateStatusByNo(@Param("no")String no,@Param("status")String status);
	
	int countSignet(@Param("year")String year);
	
	String CreatePrjSealNumOrder(@Param("year")String year);
}

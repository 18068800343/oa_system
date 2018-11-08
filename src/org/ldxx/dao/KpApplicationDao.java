package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.KpApplication;

public interface KpApplicationDao {

	public int addKpApplication(@Param("kp")KpApplication kp);
	
	public List<KpApplication> selectKpApplication(@Param("status")String status);
	
	public float getAllMoney(@Param("contractNo")String contractNo,@Param("prjNo")String prjNo);
}

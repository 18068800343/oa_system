package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.KpApplication;

public interface KpApplicationDao {

	public int addKpApplication(@Param("kp")KpApplication kp);
	
	public List<KpApplication> selectKpApplication(@Param("status")String status);
	
	public float getAllMoney(@Param("contractNo")String contractNo,@Param("prjNo")String prjNo);
	
	public int buleFpNo(@Param("no")String no,@Param("id")String id);
	
	public  List<KpApplication> getKpNo(@Param("no")String no);
	
	public KpApplication getAllKpMoneyByFpNo(@Param("no")String no);

	public List<KpApplication> getAllKpMoneyByFpNoAndTaskNo(@Param("taskno")String taskno,@Param("contractno") String contractno);

	public int countfpNo();

	public List<KpApplication> getAllkpNo();

	public KpApplication getKpApplicationBykpNo(@Param("kpno")String kpno);
}

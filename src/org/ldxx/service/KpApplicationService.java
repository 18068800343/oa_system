package org.ldxx.service;

import java.math.BigDecimal;
import java.util.List;

import org.ldxx.bean.KpApplication;

public interface KpApplicationService {

	public int addKpApplication(KpApplication kp);
	
	public List<KpApplication> selectKpApplication(String status);
	
	public BigDecimal getAllMoney(String contractNo,String prjNo);
	
	public int buleFpNo(String no,String id);
	
	public  List<KpApplication> getKpNo(String no);
	
	public KpApplication getAllKpMoneyByFpNo(String no);

	public List<KpApplication> getAllKpMoneyByFpNoAndTaskNo(String taskno, String contractno);

	public int countfpNo();

	public List<KpApplication> getAllkpNo();

	public KpApplication getKpApplicationBykpNo(String kpno);

	public KpApplication getKpApplicationById(String id);

	public int updateKpApplicationById(KpApplication kp);

	public int updateKpNoById(String id, String code);
}

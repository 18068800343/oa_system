package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.KpApplication;

public interface KpApplicationService {

	public int addKpApplication(KpApplication kp);
	
	public List<KpApplication> selectKpApplication(String status);
	
	public float getAllMoney(String contractNo,String prjNo);
}

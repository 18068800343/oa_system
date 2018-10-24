package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.PrjProgressFill;
import org.ldxx.bean.PrjProgressFillInfo;

public interface PrjProgressFillService {

	public int addPrjProgressFill(PrjProgressFill ppf);
	
	public List<PrjProgressFill> selectPrjProgressFill(String status);
	
	public PrjProgressFill selectPrjProgressFillById(String id);
	
	public List<PrjProgressFillInfo> selectPrjProgressFillInfo(String id,String type);
	
	public PrjProgressFill selectLastPrjProgressFill(String no);
}

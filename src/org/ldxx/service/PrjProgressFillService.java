package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.PrjProgressFill;
import org.ldxx.bean.PrjProgressFillCj;
import org.ldxx.bean.PrjProgressFillInfo;

public interface PrjProgressFillService {

	public int addPrjProgressFill(PrjProgressFill ppf);
	
	public List<PrjProgressFill> selectPrjProgressFill(String status);
	
	public PrjProgressFill selectPrjProgressFillById(String id);
	
	public List<PrjProgressFillInfo> selectPrjProgressFillInfo(String id,String type);
	
	public PrjProgressFill selectLastPrjProgressFill(String no);
	
	public PrjProgressFillInfo getLastByDepartmentAndId(String id,String department);
	
	public int addPrjProgressFillCj(List<PrjProgressFillCj> ppcj);
	
	public PrjProgressFillCj cjBq(String ppfId,String cjId);
	
	public List<PrjProgressFillCj> selectPrjProgressFillCjById(String id);
	
	public List<PrjProgressFill> selectPrjProgressFillByStatus(int status);
	
	public int updateStatusAndDesc(int status,String infos,String id);
}

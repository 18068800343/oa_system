package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.CjContract;
import org.ldxx.bean.PrjProgressFill;
import org.ldxx.bean.PrjProgressFillCj;
import org.ldxx.bean.PrjProgressFillFb;
import org.ldxx.bean.PrjProgressFillInfo;

public interface PrjProgressFillService {

	public int addPrjProgressFill(PrjProgressFill ppf);
	
	public List<PrjProgressFill> selectPrjProgressFill(String status);
	
	public PrjProgressFill selectPrjProgressFillById(String id);
	
	public List<PrjProgressFillInfo> selectPrjProgressFillInfo(String id,String type);
	
	public PrjProgressFill selectLastPrjProgressFill(String no);
	
	public PrjProgressFillInfo getLastByDepartmentAndId(String id,String department);
	
	public int addPrjProgressFillCj(PrjProgressFillCj ppcj);
	
	public List<PrjProgressFillCj> selectPrjProgressFillCjById(String id);
	
	public List<PrjProgressFill> selectPrjProgressFillByStatus(int status);
	
	public int updateStatusAndDesc(int status,String infos,String id);
	
	public List<PrjProgressFill> selectDistinctTaskNo(String year);
	
	public PrjProgressFill getCost(String no);
	
	public float getDepartmentCost(String department,String id);
	
	public int countOfDepartmentCost(String department,String id);

	public List<PrjProgressFill> selectPrjProgressFillByYear(String status, String y);
	
	public PrjProgressFill selectAllCostAndJd(String taskNo);
	
	public List<PrjProgressFill> selectDepartmentIncome(String department,String start,String end);
	
	public PrjProgressFillInfo selectYearCostByDepartment(String department,String year);
	
	public List<PrjProgressFill> selectNewest();
	
	public int updatePrjProgressFill(PrjProgressFill ppf);
	
	public CjContract selectCjContractAndPrjProgressFillCj(String no);
	
	public int addPrjProgressFillFb(List<PrjProgressFillFb> fb);
	
	public PrjProgressFillFb selectPrjProgressFillFbByFbId(String id);
	
	public PrjProgressFillCj selectPrjProgressFillCjIncomeBq(String id,String bq);
	
	public PrjProgressFillInfo selectPrjProgressFillInfoTotalByTaskAndDept(String no,String dept);
	
	public  List<PrjProgressFillFb>  selectPrjProgressFillFbByPpfId(String id);
	
	public PrjProgressFill selectGsIncomeByTime(String time);
	
	public PrjProgressFill selectGsIncomeByTimeAndDept(String time,String dept);
	
}

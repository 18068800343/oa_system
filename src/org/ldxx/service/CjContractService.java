package org.ldxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.CjDeptSplitMoney;

public interface CjContractService {

	public int addCjContract(CjContract cj);
	
	public int updateCjContract(CjContract cj);
	
	public List<CjContract> selectCjContractByStatus(String status,String startMin,String startMax,String endMin,String endMax,String mainDp,String xbDp,Double contractMoneyMin,Double contractMoneyMax,Double zdMoneyMin,Double zdMoneyMax);
	
	public List<CjContract> selectCjContractBySome (String startMin,String startMax,String endMin,String endMax,String mainDp,String xbDp,Double contractMoneyMin,Double contractMoneyMax,Double zdMoneyMin,Double zdMoneyMax,String lxdateMin,String lxdateMax,String erjileixing);
	
	public CjContract selectCjContractById(String id);
	
	public int deleteCjContract(String id);
	
	public List<CjContract> selectIdAndName();
	
	public List<CjContract> selectContractNoById(String id);
	
	public List<CjContract> selectContractByTaskNo(String no);
	
	public List<CjContract> selectCjByName(String name);
	
	public List<CjContract> selectCjByNo(String no);
	
	public List<CjContract> selectCjHistory(String no);
	
	public int countNo(String year);

	public List<CjContract> selectNameAndNo();

	public CjContract selectCjContractByName(String name);

	public CjContract selectCjContractByNo(String no);
	
	public List<CjContract> selectCjContractByTaskNo(String no);

	public CjContract selectCjByCjNo(String no);
	
	public List<CjContract> selectNoAndMoneyByDepartment(String department,String year);
	
	public Double selectCjContractMoneyBySignTime(String time);
	
	public CjContract getCjContractMainDepartmentLeader(String no);

	public int updateHistoryById(String id);
	
	public List<CjDeptSplitMoney> selectCjDeptSplitMoney(String id,String dept);
	
	public CjContract selectCjContractLikeTaskNo(String no);
	
	public CjContract selectCjContractLikeTaskCode(String no);
	
	public int updateCjNoById(String no,String id);
	
	public String CreateContractNumOrder(String type,String year);
	
	public int updateCjContractCancelReason(CjContract cj);
	
}

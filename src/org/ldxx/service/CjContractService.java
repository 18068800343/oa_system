package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.CjContract;
import org.ldxx.bean.CjDeptSplitMoney;

public interface CjContractService {

	public int addCjContract(CjContract cj);
	
	public int updateCjContract(CjContract cj);
	
	public List<CjContract> selectCjContractByStatus(String status,String startMin,String startMax,String endMin,String endMax,String mainDp,String xbDp,float contractMoneyMin,float contractMoneyMax,float zdMoneyMin,float zdMoneyMax);
	
	public CjContract selectCjContractById(String id);
	
	public int deleteCjContract(String id);
	
	public List<CjContract> selectIdAndName();
	
	public List<CjContract> selectContractNoById(String id);
	
	public List<CjContract> selectContractByTaskNo(String no);
	
	public List<CjContract> selectCjByName(String name);
	
	public List<CjContract> selectCjByNo(String no);
	
	public List<CjContract> selectCjHistory(String no);
	
	public int countNo();

	public List<CjContract> selectNameAndNo();

	public CjContract selectCjContractByName(String name);

	public CjContract selectCjContractByNo(String no);
	
	public List<CjContract> selectCjContractByTaskNo(String no);

	public CjContract selectCjByCjNo(String no);
	
	public List<CjContract> selectNoAndMoneyByDepartment(String department,String year);
	
	public float selectCjContractMoneyBySignTime(String time);
	
	public CjContract getCjContractMainDepartmentLeader(String no);

	public int updateHistoryById(String id);
	
	public List<CjDeptSplitMoney> selectCjDeptSplitMoney(String id,String dept);
	
}

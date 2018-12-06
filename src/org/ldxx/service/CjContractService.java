package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.CjContract;
import org.ldxx.bean.CjSplitMoney;

public interface CjContractService {

	public int addCjContract(CjContract cj);
	
	public int updateCjContract(CjContract cj);
	
	public List<CjContract> selectCjContractByStatus(String status);
	
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
}

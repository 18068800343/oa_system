package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.CjContract;

public interface CjContractService {

	public int addCjContract(CjContract cj);
	
	public int updateCjContract(CjContract cj);
	
	public List<CjContract> selectCjContractByStatus(String status);
	
	public CjContract selectCjContractById(String id);
	
	public int deleteCjContract(String id);
	
	public List<CjContract> selectIdAndName();
}

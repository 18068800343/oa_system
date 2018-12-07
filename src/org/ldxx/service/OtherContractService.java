package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.OtherContract;

public interface OtherContractService {

	public int addOtherContract(OtherContract other);
	
	public int deleteOtherContract(String id);
	
	public List<OtherContract> selectOtherContract(String status);
	
	public int updateOtherContract(OtherContract other);
	
	public List<OtherContract> selectCjHistory(String no);
	
	public int countNo();

	public OtherContract selectOtherContractById(String id);

	public OtherContract selectOtherContractByNo(String no);

}

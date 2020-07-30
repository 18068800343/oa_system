package org.ldxx.service;

import java.math.BigDecimal;
import java.util.List;

import org.ldxx.bean.OtherContract;

public interface OtherContractService {

	public int addOtherContract(OtherContract other);
	
	public int deleteOtherContract(String id);
	
	public List<OtherContract> selectOtherContract(String status);
	
	public int updateOtherContract(OtherContract other);
	
	public List<OtherContract> selectCjHistory(String no);
	
	public int countNo(String year);

	public OtherContract selectOtherContractById(String id);

	public OtherContract selectOtherContractByNo(String no);
	
	public BigDecimal selectOtherContractMoneyBySignTime(String time);
	
	public BigDecimal selectOtherContractMoneyBySignTimeAndDepartment(String time,String department);

	public int updateHistoryById(String id);

	public int updateOtherContractById(OtherContract other);
	
	public int updateOnoById(String id,String no);

	public List<OtherContract> selectOtherContract2();

}

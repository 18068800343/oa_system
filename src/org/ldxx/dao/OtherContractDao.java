package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.OtherContract;

public interface OtherContractDao {

	public int addOtherContract(@Param("other")OtherContract other);
	
	public int deleteOtherContract(@Param("id")String id);
	
	public List<OtherContract> selectOtherContract(@Param("status")String status);
	
	public int updateOtherContract(@Param("other")OtherContract other);
	
	public List<OtherContract> selectCjHistory(@Param("no")String no);
	
	public int countNo();

	public OtherContract selectOtherContractById(@Param("id")String id);

	public OtherContract selectOtherContractByNo(@Param("no")String no);
	
	public List<OtherContract> selectOtherContractMoneyBySignTime(@Param("time")String time);
	
	public List<OtherContract> selectOtherContractMoneyBySignTimeAndDepartment(@Param("time")String time,@Param("department")String department);
}
